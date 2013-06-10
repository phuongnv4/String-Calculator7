package com.qsoft.unittest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.qsoft.Calculator;

public class CalculatorUnitTest {

	@Test
	public void addNumberNull() {
		assertEquals(1, Calculator.add(null));
	}

	@Test
	public void addNumberEmpty() {
		assertEquals(1, Calculator.add(""));
	}

	@Test
	public void addNumberNewLine() {
		try {
			assertEquals(4, Calculator.add("-2,\n5,1"));
		} catch (Exception e) {
			assertEquals(true, "negatives not allowed".equals(e.getMessage()));
		}
	}

	@Test
	public void addNumberDelimiter1() {
		assertEquals(4, Calculator.add("//;\n1;3"));
	}

	@Test
	public void addNumberDelimiter2() {
		assertEquals(6, Calculator.add("//[***]\n1***2***3"));
	}

	@Test
	public void addNumberDelimiter3() {
		assertEquals(6, Calculator.add("//[*][%]\n1*2%3"));
	}

	@Test
	public void addNumberMultiDelimiter() {
		assertEquals(
				6,
				Calculator
						.add("//[!@#$%^&*(][qwertyuiopdfghjkl][!@#$%^&*(][^65465^^&*]\n1[!@#$%]2[^^^&*]3[pokjniuhygtgf][ghjkkkll]qwertyuiopdfghjkl[dsad]"));
	}
}
