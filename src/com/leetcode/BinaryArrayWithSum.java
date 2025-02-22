package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class BinaryArrayWithSum {
	public static void main(String[] args) {
		BinaryArrayWithSum b = new BinaryArrayWithSum();
		int A[] = { 1,0,1,1,0,0,1,1};

		int S = 2;
		System.out.println(b.numSubarraysWithSum(A, S));
	}

	 public int numSubarraysWithSum(int[] nums, int k) {
	        int curr_sum = 0;
	        int cnt = 0;
	        Map<Integer, Integer> map = new HashMap<>();
	        map.put(0, 1);
	        for(int i=0;i<nums.length;i++){
	            curr_sum += nums[i];
	            if(map.containsKey(curr_sum - k)){
	                cnt += map.get(curr_sum - k);
	            }
	            map.put(curr_sum, map.getOrDefault(curr_sum, 0) + 1);
	        }
	        return cnt;
	    }
}
