/*
 * This file was automatically generated by EvoSuite
 * Tue Apr 24 02:58:16 GMT 2018
 */

package net.mooctest;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import net.mooctest.Month;
import net.mooctest.Year;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class Month_ESTest extends Month_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      Year year0 = new Year((-2514));
      Month month0 = new Month(8, year0);
      Month month1 = new Month(11, year0);
      boolean boolean0 = month0.equals(month1);
      assertEquals(31, month0.getMonthSize());
      assertFalse(month1.equals((Object)month0));
      assertFalse(boolean0);
      assertEquals(30, month1.getMonthSize());
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      Year year0 = new Year(7);
      Month month0 = new Month(7, year0);
      month0.setCurrentPos(11);
      month0.increment();
      boolean boolean0 = month0.isValid();
      assertEquals(12, month0.getMonth());
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      Year year0 = new Year(8);
      Month month0 = new Month(8, year0);
      month0.setCurrentPos(0);
      int int0 = month0.getMonth();
      assertFalse(month0.isValid());
      assertEquals(0, int0);
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      Year year0 = new Year(11);
      Month month0 = new Month(11, year0);
      month0.setCurrentPos((-379));
      int int0 = month0.getMonth();
      assertEquals((-379), int0);
  }

  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
      Year year0 = new Year(11);
      Month month0 = new Month(11, year0);
      month0.increment();
      month0.increment();
      // Undeclared exception!
      try { 
        month0.getMonthSize();
        fail("Expecting exception: ArrayIndexOutOfBoundsException");
      
      } catch(ArrayIndexOutOfBoundsException e) {
         //
         // 12
         //
         verifyException("net.mooctest.Month", e);
      }
  }

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      Year year0 = new Year(4);
      Month month0 = new Month(4, year0);
      month0.setCurrentPos((-2048));
      boolean boolean0 = month0.isValid();
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      Year year0 = new Year(8);
      Month month0 = new Month(8, year0);
      Month month1 = new Month(11, year0);
      Year year1 = new Year(2071);
      month1.setMonth(11, year1);
      assertEquals(11, month1.getMonth());
      
      month1.currentPos = 8;
      boolean boolean0 = month0.equals(month1);
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
      Year year0 = new Year(5);
      Month month0 = new Month(5, year0);
      month0.increment();
      Month month1 = new Month(5, year0);
      boolean boolean0 = month0.equals(month1);
      assertEquals(6, month0.getMonth());
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
      Year year0 = new Year(5);
      Month month0 = new Month(5, year0);
      boolean boolean0 = month0.equals(month0);
      assertTrue(boolean0);
      assertEquals(31, month0.getMonthSize());
  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
      Year year0 = new Year(11);
      Month month0 = new Month(11, year0);
      boolean boolean0 = month0.equals(year0);
      assertEquals(30, month0.getMonthSize());
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
      Year year0 = new Year((-1230));
      Month month0 = new Month(3, year0);
      year0.currentPos = 2;
      year0.currentPos = (-1230);
      year0.currentPos = 0;
      boolean boolean0 = month0.isValid();
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test11()  throws Throwable  {
      Month month0 = null;
      try {
        month0 = new Month((-19), (Year) null);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // Not a valid month
         //
         verifyException("net.mooctest.Month", e);
      }
  }

  @Test(timeout = 4000)
  public void test12()  throws Throwable  {
      Year year0 = new Year(11);
      Month month0 = new Month(11, year0);
      month0.increment();
      month0.increment();
      boolean boolean0 = month0.isValid();
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test13()  throws Throwable  {
      Year year0 = new Year(11);
      Month month0 = new Month(11, year0);
      year0.increment();
      int int0 = month0.getMonthSize();
      assertEquals(30, int0);
  }

  @Test(timeout = 4000)
  public void test14()  throws Throwable  {
      Year year0 = new Year(4);
      Month month0 = new Month(4, year0);
      // Undeclared exception!
      try { 
        month0.setMonth((-1987), year0);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // Not a valid month
         //
         verifyException("net.mooctest.Month", e);
      }
  }

  @Test(timeout = 4000)
  public void test15()  throws Throwable  {
      Year year0 = new Year((-2514));
      Month month0 = new Month(8, year0);
      int int0 = month0.getMonth();
      assertEquals(8, int0);
      assertEquals(31, month0.getMonthSize());
  }
}