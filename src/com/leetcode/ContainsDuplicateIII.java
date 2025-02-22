package com.leetcode;

import java.util.TreeSet;

public class ContainsDuplicateIII {
	public static void main(String[] args) {
		ContainsDuplicateIII c=new ContainsDuplicateIII();
		int nums[]= {1,2,1,1};
		int k=1,t=0;
		c.containsNearbyAlmostDuplicate(nums, k, t);
	}
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return false;
        }

        final TreeSet<Integer> values = new TreeSet<>();
        for (int ind = 0; ind < nums.length; ind++) {

            final Integer floor = values.floor(nums[ind] + t);
            final Integer ceil = values.ceiling(nums[ind] - t);
            if ((floor != null && floor >= nums[ind])
                    || (ceil != null && ceil <= nums[ind])) {
                return true;
            }

            values.add(nums[ind]);
            if (ind >= k) {
                values.remove(nums[ind - k]);
            }
        }

        return false;
    }

}
