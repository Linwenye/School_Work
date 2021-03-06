/*
 * This file was automatically generated by EvoSuite
 * Wed Apr 25 04:23:12 GMT 2018
 */

package net.mooctest;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import net.mooctest.JCLO;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class JCLO_ESTest extends JCLO_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      Object object0 = new Object();
      String[][] stringArray0 = new String[8][7];
      String[] stringArray1 = new String[7];
      stringArray1[0] = "--";
      stringArray0[0] = stringArray1;
      stringArray0[1] = stringArray1;
      stringArray0[2] = stringArray0[0];
      stringArray0[3] = stringArray0[0];
      stringArray0[4] = stringArray0[2];
      String[] stringArray2 = new String[0];
      stringArray0[5] = stringArray2;
      JCLO jCLO0 = new JCLO(object0, stringArray0);
      // Undeclared exception!
      try { 
        jCLO0.parse(stringArray1);
        fail("Expecting exception: ArrayIndexOutOfBoundsException");
      
      } catch(ArrayIndexOutOfBoundsException e) {
         //
         // 0
         //
         verifyException("net.mooctest.JCLO", e);
      }
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      String[][] stringArray0 = new String[4][5];
      JCLO jCLO0 = null;
      try {
        jCLO0 = new JCLO((String) null, (Object) null, stringArray0);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("net.mooctest.JCLO", e);
      }
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      JCLO jCLO0 = null;
      try {
        jCLO0 = new JCLO((String) null, (Object) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("net.mooctest.JCLO", e);
      }
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      String[][] stringArray0 = new String[0][9];
      JCLO jCLO0 = null;
      try {
        jCLO0 = new JCLO((Object) null, stringArray0);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("net.mooctest.JCLO", e);
      }
  }

  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
      JCLO jCLO0 = null;
      try {
        jCLO0 = new JCLO((Object) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("net.mooctest.JCLO", e);
      }
  }

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      JCLO jCLO0 = new JCLO("");
      String[] stringArray0 = new String[0];
      jCLO0.parse(stringArray0);
      assertEquals(0, stringArray0.length);
  }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      String[][] stringArray0 = new String[8][8];
      String[] stringArray1 = new String[9];
      stringArray1[0] = "__";
      stringArray0[0] = stringArray1;
      stringArray0[1] = stringArray1;
      stringArray0[2] = stringArray1;
      stringArray0[3] = stringArray1;
      stringArray0[4] = stringArray1;
      stringArray0[5] = stringArray0[3];
      String[] stringArray2 = new String[8];
      stringArray2[0] = "---";
      stringArray0[6] = stringArray2;
      stringArray0[7] = stringArray1;
      JCLO jCLO0 = new JCLO("__", "__", stringArray0);
      // Undeclared exception!
      try { 
        jCLO0.parse(stringArray2);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // No such option: \"null\"
         //
         verifyException("net.mooctest.JCLO", e);
      }
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
      String[][] stringArray0 = new String[8][8];
      String[] stringArray1 = new String[8];
      stringArray1[0] = "---";
      JCLO jCLO0 = new JCLO("__", "__", stringArray0);
      // Undeclared exception!
      try { 
        jCLO0.parse(stringArray1);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
      }
  }

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
      JCLO jCLO0 = new JCLO("");
      String string0 = jCLO0.usage();
      assertEquals("-hash int\n", string0);
  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
      String[][] stringArray0 = new String[22][9];
      JCLO jCLO0 = new JCLO("", "", stringArray0);
      String string0 = jCLO0.usage();
      assertEquals("-hash int\n", string0);
  }

  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
      Object object0 = new Object();
      JCLO jCLO0 = new JCLO(object0);
      String string0 = jCLO0.toString();
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test11()  throws Throwable  {
      String[] stringArray0 = new String[1];
      stringArray0[0] = "-' requir=es '=VAEU'";
      JCLO jCLO0 = new JCLO("-' requir=es '=VAEU'", "-' requir=es '=VAEU'");
      // Undeclared exception!
      try { 
        jCLO0.parse(stringArray0);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // No such option: \"' requir\"
         //
         verifyException("net.mooctest.JCLO", e);
      }
  }

  @Test(timeout = 4000)
  public void test12()  throws Throwable  {
      String[][] stringArray0 = new String[5][0];
      String[] stringArray1 = new String[1];
      stringArray1[0] = "";
      JCLO jCLO0 = new JCLO((Object) "", stringArray0);
      jCLO0.parse(stringArray1);
      assertEquals(1, stringArray1.length);
  }

  @Test(timeout = 4000)
  public void test13()  throws Throwable  {
      JCLO jCLO0 = new JCLO("r", "r");
      String string0 = jCLO0.usage();
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test14()  throws Throwable  {
      String[][] stringArray0 = new String[22][9];
      JCLO jCLO0 = new JCLO("", "", stringArray0);
      // Undeclared exception!
      try { 
        jCLO0.toString();
        fail("Expecting exception: ClassCastException");
      
      } catch(ClassCastException e) {
         //
         // [C cannot be cast to [Ljava.lang.Object;
         //
         verifyException("net.mooctest.JCLO", e);
      }
  }
}
