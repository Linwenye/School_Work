package net.mooctest;

import static org.junit.Assert.*;

import org.junit.Test;

public class SuffixArrayTest {

	@Test(timeout = 4000)
	public void test() {
		int a[] = { 1, 2, 3 };
		int c[] = { 2, 1, 3 };

		try {
			SuffixArray.isSorted(a, c, 3);

		} catch (Exception e) {
			// TODO: handle exception
		}
	
		// SuffixArray.sleq(a, 0, b, 2);

	}
	@Test
	public void test_sleq(){
		int a[]={0,1,2};
		try {
			assertTrue(SuffixArray.sleq(a, 0, a, 0));
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@Test
	public void test_sort(){
		int s[] = {98,97,110,97,110,97};
		int sa[] = { 5, 3, 1, 0, 4, 2 };
		try {
			
			assertEquals(true, SuffixArray.isSorted(sa, s, 6));
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@Test(timeout = 4000)
	public void test1() {
		int a[] = { 1, 2, 3 };
		try {

			SuffixArray.isSorted(a, a, 3);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Test(timeout = 4000)
	public void test3() {
		int lcp[] = new int[6];
		int suffixArray[] = new int[6];

		int expectSa[] = { 5, 3, 1, 0, 4, 2 };
		int expectLcp[] = { 0, 1, 3, 0, 0, 2 };
		try {

			SuffixArray.createSuffixArray("banana", suffixArray, lcp);
			assertArrayEquals(expectSa, suffixArray);
			assertArrayEquals(expectLcp, lcp);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@Test(timeout = 4000)
	public void test_slow() {
		int lcp[] = new int[6];
		int suffixArray[] = new int[6];
		
		int expectSa[] = { 5, 3, 1, 0, 4, 2 };
		int expectLcp[] = { 0, 1, 3, 0, 0, 2 };
		try {
			
			SuffixArray.createSuffixArraySlow("banana", suffixArray, lcp);
			assertArrayEquals(expectSa, suffixArray);
			assertArrayEquals(expectLcp, lcp);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Test
	public void test_print(){
		int a[] = {1,2,3};
		SuffixArray.printV(a,"result");
	}
	
//	@Test
//	public void test_permulate1(){
//		int a[] = {1,2};
//		assertEquals(false, SuffixArray.isPermutation(a, 3));
//	}
	
	@Test
	public void test_permulate2(){
		int a[] = {0,1,2};
		assertEquals(true, SuffixArray.isPermutation(a,3));
	}
}
