package com.leetcode;

import java.util.Map;
import java.util.TreeMap;

public class DivideArrayIntoKConsecutiveNumber {
	public static void main(String[] args) {
		DivideArrayIntoKConsecutiveNumber d=new DivideArrayIntoKConsecutiveNumber();
		int nums[]= {1,2,3,3,2,1,2,3,4,3,4,5,9,10,11};
		d.isPossibleDivide(nums, 3);
	}
	public boolean isPossibleDivide(int[] A, int k) {
		        Map<Integer, Integer> c = new TreeMap<>();
		        for (int i : A) c.put(i, c.getOrDefault(i, 0)+1);
		        for (int it : c.keySet())
		            if (c.get(it) > 0)
		                for (int i = k - 1; i >= 0; --i) {
		                    if (c.getOrDefault(it + i, 0) < c.get(it))
		                    	return false;
		                    
		                    c.put(it + i, c.get(it + i) - c.get(it));
		                }
		        return true;
		    }
    }

