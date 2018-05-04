package net.mooctest;

/**
 * Created by LWY on 2018/4/25.
 */
public class my {

    public static void main() {
        JCLO jCLO0 = new JCLO("~\"!vbvJhLq[@:(~");
        String[] stringArray0 = new String[9];
        stringArray0[0] = "-hash int\n";
        // Undeclared exception!
        try {
            jCLO0.parse(stringArray0);

        } catch(IllegalArgumentException e) {
            //
            // No such option: \"ash int
            // \"
            //
            System.out.println(e.getMessage());
            //verifyException("net.mooctest.JCLO", e);
        }
    }
}
