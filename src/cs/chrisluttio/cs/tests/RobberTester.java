package cs.chrisluttio.cs.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.chrisluttio.cs.algorithms.Robber;

public class RobberTester {

	@Test
	public void testSmallRob() {
		Robber robber = new Robber();
		
		ArrayList<Integer> houses = new ArrayList<>();
		houses.add(500);
		houses.add(30);
		houses.add(100);
		
		assertEquals(600, robber.rob(houses));
	}
	
	@Test
	public void testBigRob() {
		Robber robber = new Robber();
		
		ArrayList<Integer> houses = new ArrayList<>();
		houses.add(500);
		houses.add(200);
		houses.add(100);
		houses.add(800);
		houses.add(60);
		houses.add(30);
		houses.add(1000);
		houses.add(900);
		
		int max = robber.rob(houses);
		assertEquals(2300, max);
	}
	
}
