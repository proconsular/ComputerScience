package com.chrisluttio.cs.algorithms;

import java.util.ArrayList;

public class Robber {
	
	public int rob(ArrayList<Integer> houses) {
		if (houses.size() <= 3)
			return baseRob(houses);
		int max = 0;
		for (int i = 0; i < houses.size(); i++) {
			int v = rob(getRange(houses, 0, i)) + rob(getRange(houses, i + 2, houses.size()));
			if (v > max)
				max = v;
		}
		return max;
	}
	
	public int baseRob(ArrayList<Integer> houses) {
		int max = 0;
		for (int i = 0; i < houses.size(); i++) {
			int i_val = houses.get(i);
			if (i_val > max) {
				max = i_val;
			}
			for (int j = i + 2; j < houses.size(); j++) {
				int j_val = houses.get(j);
				if (i_val + j_val > max) {
					max = i_val + j_val;
				}
			}
		}
		return max;
	}
	
	public ArrayList<Integer> getRange(ArrayList<Integer> list, int i, int j) {
		ArrayList<Integer> out = new ArrayList<>();
		for (int n = i; n < j; n++)
			out.add(list.get(n));
		return out;
	}
	
}
