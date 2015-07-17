package com.laboon;

import static org.junit.Assert.*;
import org.junit.Test;

public class PinningTests {

	// check that toString() shows the correct number and sequence of columns
	@Test
	public void testWorldtoString() {
		World w = new World(12, 5, 50);
		String result = w.toString();
		assertTrue(result.contains("012345678901")); // 12 columns in proper order
		assertFalse(result.contains("0123456789012")); // 13 is too many
	}

	// check that iterate() returns a world of the same size as the world it is
	// iterating
	@Test
	public void testWorldIterate() {
		World w = new World(14, 6, 40);
		World iteration = w.iterate();
		String result = iteration.toString();
		assertTrue(result.contains("01234567890123")); // 14 columns in proper
		assertFalse(result.contains("012345678901234")); // 15 is too many
	}

	// check that isAlive shows true for a cell initialized as alive
	@Test
	public void testCellInitialization() {
		Cell c = new Cell(State.ALIVE, 4, 4);
		assertTrue(c.isAlive());
	}

	// check that iterate returns the correct state for different cases
	@Test
	public void testCellIteration() {
		// initialize a living cell and a dead cell
		Cell aliveCell = new Cell(State.ALIVE, 3, 3);
		Cell deadCell = new Cell(State.DEAD, 3, 3);

		// test alive cases
		State diesFew = aliveCell.iterate(1); // too few neighbors, dies
		assertEquals(diesFew, State.DEAD);
		State diesMany = aliveCell.iterate(4); // too many neighbors, dies
		assertEquals(diesMany, State.DEAD);
		State lives = aliveCell.iterate(3); // suitable number of neighbors, lives
		assertEquals(lives, State.ALIVE);

		// test dead cases
		State newLife = deadCell.iterate(3); // has 3 neighbors, resurrects
		assertEquals(newLife, State.ALIVE);
		State staysDead = deadCell.iterate(4); // not 3 neighbors, stays dead
		assertEquals(staysDead, State.DEAD);
	}

}
