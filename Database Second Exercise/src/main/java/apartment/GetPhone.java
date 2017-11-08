package apartment;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by LWY on 2017/11/7.
 */
public class GetPhone {

    private Map<String, String> apartmentPhone = new HashMap<String, String>();
    private String filePath = "";

    public Map<String, String> readTXT(String filePath) {
        if (!apartmentPhone.isEmpty() && this.filePath.equals(filePath)) {
            return apartmentPhone;
        }

        try {
            File fileView = new File(filePath);
            this.filePath = filePath;

            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fileView), "UTF-8"));
            String line = in.readLine(); // desert the first line
            String apartmentID;
            String phone;
            while ((line = in.readLine()) != null) {
                apartmentID = line.split(";")[0];
                phone = line.split(";")[1];
                apartmentPhone.put(apartmentID, phone);
            }

            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return apartmentPhone;
    }
}
