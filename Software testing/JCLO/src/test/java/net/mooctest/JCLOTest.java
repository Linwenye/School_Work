package net.mooctest;

import org.junit.Test;

import static org.junit.Assert.*;

public class JCLOTest {

    @Test
    public void test() {
        class ExampleArgs {
            int a;
            boolean b;
            float c;
            short e;
            byte t;
            char[] d;
        }
        ExampleArgs ea = new ExampleArgs();
        JCLO jCLO0 = new JCLO(ea);
        String[] stringArray0 = "--a=5 --b --c=3.141592 -e=1 -t=0 --d=this".split(" ");
        try {
            jCLO0.parse(stringArray0);
        }catch (IllegalArgumentException e){
            //
            assertEquals("Unknown type: string",e.getMessage());
        }
    }

    @Test
    public void test2() {
        class ExampleArgs {
            int b;
            int [] a;
        }
        ExampleArgs ea = new ExampleArgs();
        JCLO jCLO0 = new JCLO(ea);
        String[] stringArray0 = "-b=2 --a=35".split(" ");
        jCLO0.parse(stringArray0);
    }

    @Test
    public void test3() {
        class ExampleArgs {
            String [] a;
        }
        ExampleArgs ea = new ExampleArgs();
        JCLO jCLO0 = new JCLO(ea);
        String[] stringArray0 = "a b".split(" ");
        try {
            jCLO0.parse(stringArray0);
        }catch (IllegalArgumentException e){
            //
            assertEquals("No varible 'additional' found",e.getMessage());
        }
    }

    @Test
    public void test4() {
        class ExampleArgs {
            int a;
            int b;
        }
        ExampleArgs ea = new ExampleArgs();
        JCLO jCLO0 = new JCLO(ea);
        String[] stringArray0 = "-a=2 -b=3".split(" ");
        jCLO0.parse(stringArray0);
    }

    @Test
    public void testmm(){
        class ExampleArgs
        {
            int a;
            boolean b;
            float c;
            double d;
            long h;
            char e;
            int[] additional;
        }
        ExampleArgs ea = new ExampleArgs();
        JCLO jCLO0 = new JCLO(ea);
        String[] stringArray0 = "--a=5 --b --c=3.141592 --d=4.1 --h=33 --e=t 3".split(" ");
        try {

            jCLO0.parse(stringArray0);
        }catch (Exception e){
            //
        }
    }
}
