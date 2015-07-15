package com.laboon;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.*;
import org.mockito.Mockito;

import org.junit.Test;

public class PinningTests {

	@Test
	public void testWorldtoString() {
		World w = new World(12,5,50);
		String result = w.toString();
		assertTrue(result.contains("012345678901"));
		assertFalse(result.contains("0123456789012"));
	}
	
	@Test
	public void test() {
		fail();
	}
	
	@Test
	public void testWoring() {
		fail();
	}

}
