/*
 * This file was automatically generated by EvoSuite
 * Tue Apr 24 02:58:23 GMT 2018
 */

package net.mooctest;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import net.mooctest.Year;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class Year_ESTest extends Year_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      Year year0 = new Year((-149));
      year0.increment();
      Year year1 = new Year((-149));
      boolean boolean0 = year0.equals(year1);
      assertEquals((-148), year0.getYear());
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      Year year0 = new Year((-2406));
      assertEquals((-2406), year0.getYear());
      
      year0.setCurrentPos(0);
      boolean boolean0 = year0.isLeap();
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      Year year0 = new Year(1);
      year0.isValid();
      assertEquals(1, year0.getYear());
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      Year year0 = new Year((-30));
      assertEquals((-30), year0.getYear());
      
      year0.setCurrentPos(0);
      boolean boolean0 = year0.isValid();
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
      Year year0 = new Year((-30));
      year0.setCurrentPos(0);
      int int0 = year0.getYear();
      assertEquals(0, int0);
  }

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      Year year0 = new Year(1);
      year0.setYear((-166));
      int int0 = year0.getYear();
      assertEquals((-166), int0);
  }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      Year year0 = new Year(2386);
      // Undeclared exception!
      try { 
        year0.setYear(0);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // Not a valid month
         //
         verifyException("net.net.mooctest.Year", e);
      }
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
      Year year0 = new Year(400);
      Year year1 = new Year(400);
      year0.increment();
      boolean boolean0 = year1.equals(year0);
      assertEquals(401, year0.getYear());
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
      Year year0 = new Year(400);
      boolean boolean0 = year0.equals(year0);
      assertTrue(year0.isLeap());
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
      Year year0 = new Year((-1692));
      boolean boolean0 = year0.equals("X.:a");
      assertEquals((-1692), year0.getYear());
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
      Year year0 = new Year(1);
      year0.setYear((-166));
      year0.increment();
      year0.increment();
      year0.increment();
      year0.increment();
      year0.increment();
      boolean boolean0 = year0.isLeap();
      assertEquals((-161), year0.getYear());
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test11()  throws Throwable  {
      Year year0 = new Year((-1692));
      assertEquals((-1692), year0.getYear());
      
      year0.currentPos = (-1);
      boolean boolean0 = year0.isLeap();
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test12()  throws Throwable  {
      Year year0 = new Year(400);
      boolean boolean0 = year0.isLeap();
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test13()  throws Throwable  {
      Year year0 = new Year((-1692));
      year0.currentPos = (-1);
      year0.increment();
      year0.increment();
      year0.increment();
      year0.increment();
      boolean boolean0 = year0.isLeap();
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test14()  throws Throwable  {
      Year year0 = new Year(1);
      year0.setYear((-166));
      boolean boolean0 = year0.isLeap();
      assertEquals((-166), year0.getYear());
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test15()  throws Throwable  {
      Year year0 = null;
      try {
        year0 = new Year(0);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // Not a valid month
         //
         verifyException("net.net.mooctest.Year", e);
      }
  }

  @Test(timeout = 4000)
  public void test16()  throws Throwable  {
      Year year0 = new Year(1);
      int int0 = year0.getYear();
      assertEquals(1, int0);
  }

  @Test(timeout = 4000)
  public void test17()  throws Throwable  {
      Year year0 = new Year((-1692));
      year0.currentPos = (-1);
      year0.increment();
      boolean boolean0 = year0.isLeap();
      assertEquals(1, year0.getYear());
      assertFalse(boolean0);
  }
}
