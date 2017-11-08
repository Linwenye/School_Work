package apartment;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by LWY on 2017/11/7.
 */
public class ExcelReader {
    /**
     * 适用于第一行是标题行的excel，例如
     * 姓名   年龄  性别  身高
     * 张三   25  男   175
     * 李四   22  女   160
     * 每一行构成一个map，key值是列标题，value是列值。没有值的单元格其value值为null
     * 返回结果最外层的list对应一个sheet页，map对应sheet页中的一行
     *
     * @throws Exception
     */

    private Map<String, String> apartmentPhone;

    public ExcelReader() {
        String txtPath = "C:\\Users\\Venric\\Desktop\\database\\Homework II_design\\电话.txt";
        apartmentPhone = new GetPhone().readTXT(txtPath);
    }

    public void readExcelAndInsert(String filepath) throws Exception {
        long a = System.currentTimeMillis();
        String fileType = filepath.substring(filepath.lastIndexOf(".") + 1, filepath.length());
        InputStream is = null;
        Workbook wb = null;
        Connection con = MyConnection.getConnection();
        try {
            is = new FileInputStream(filepath);

            if (fileType.equals("xls")) {
                wb = new HSSFWorkbook(is);
            } else {
                throw new Exception("读取的不是excel文件");
            }


            Sheet sheet = wb.getSheetAt(0);

            List<String> titles = new ArrayList<String>();//放置所有的标题

            // <id,<**>
            Map<String, Map<String, String>> apartment = new HashMap<String, Map<String, String>>();

            int rowSize = sheet.getLastRowNum() + 1;
            PreparedStatement apartStmt = con.prepareStatement("INSERT ignore INTO `apartment`.apartment (apartment_id,phone,charge,area) VALUE(?,?,?,?)");
            PreparedStatement departStmt = con.prepareStatement("INSERT IGNORE INTO `apartment`.department (department_name,gender,apartment_id) VALUE(?,?,?)");
            PreparedStatement studentStmt = con.prepareStatement("INSERT ignore INTO `apartment`.student (student_id,name,gender,department_name) VALUE(?,?,?,?)");
            for (int j = 0; j < rowSize; j++) { //遍历行
                Row row = sheet.getRow(j);
                if (row == null) {//略过空行
                    continue;
                }
                int cellSize = 7;//行中有多少个单元格，也就是有多少列
                if (j == 0) {//第一行是标题行
                    for (int k = 0; k < cellSize; k++) {
                        Cell cell = row.getCell(k);
                        titles.add(cell.toString());
                    }
                } else {//其他行是数据行
                    Map<String, String> rowMap = new HashMap<String, String>();//对应一个数据行
                    for (int k = 0; k < cellSize; k++) {
                        Cell cell = row.getCell(k);
                        String key = titles.get(k);
                        String value = null;
                        if (cell != null) {
                            value = cell.toString();
                        }
                        rowMap.put(key, value);
                    }
                    studentStmt.setString(1, rowMap.get("学号"));
                    studentStmt.setString(2, rowMap.get("姓名"));
                    studentStmt.setString(3, rowMap.get("性别"));
                    studentStmt.setString(4, rowMap.get("院系"));
                    studentStmt.executeUpdate();

                    departStmt.setString(1, rowMap.get("院系"));
                    departStmt.setString(2, rowMap.get("性别"));
                    departStmt.setString(3, rowMap.get("宿舍楼"));
                    departStmt.executeUpdate();

                    if (!apartment.containsKey(rowMap.get("宿舍楼"))) {
                        Map<String, String> apartValue = new HashMap<String, String>();

                        apartValue.put("phone", apartmentPhone.get(rowMap.get("宿舍楼")));
                        apartValue.put("charge", rowMap.get("住宿费标准"));
                        apartValue.put("area", rowMap.get("校区"));
                        apartment.put(rowMap.get("宿舍楼"), apartValue);
                    }
                }
            }

            for (Map.Entry<String, Map<String, String>> entry : apartment.entrySet()) {
                apartStmt.setString(1, entry.getKey());
                apartStmt.setString(2, entry.getValue().get("phone"));
                apartStmt.setDouble(3, Double.valueOf(entry.getValue().get("charge")));
                apartStmt.setString(4, entry.getValue().get("area"));
                apartStmt.executeUpdate();
            }

        } catch (FileNotFoundException e) {
            throw e;
        } finally {
            long b = System.currentTimeMillis();
            System.out.println("用时" + (b - a) + " ms");
            if (wb != null) {
                wb.close();
            }
            if (is != null) {
                is.close();
            }
        }
    }

    public static void main(String[] args) {
        String excelPath = "C:\\Users\\Venric\\Desktop\\database\\Homework II_design\\分配方案.xls";

        try {
            new ExcelReader().readExcelAndInsert(excelPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
