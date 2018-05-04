/**
 * 
 */
package net.mooctest;

import static org.junit.Assert.*;

import org.junit.Test;

public class NextdayTest {

	@Test
	public void test() {
		Nextday n = new Nextday();
		Date new_date = new Date(2, 28, 2018);
		
        new_date.printDate();
		Date res = new Date(3, 1, 2018);
		Date output = n.nextDay(new_date);
		assertEquals("3/1/2018",res.toString());
		assertEquals(res, output);
		assertEquals(true,output.getDay().isValid());
		assertEquals(false,output.getYear().isLeap());
		assertEquals(true,output.getMonth().equals(new Month(3,new Year(2018))));
		
		res.getDay().increment();
		res.getMonth().increment();
		res.getYear().increment();
		Date anot = new Date(4,2,2019);
		assertEquals(anot,res);
	}

}
