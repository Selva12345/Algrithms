package com.leetcode;

import java.util.TreeMap;

public class RangeModule {
	public static void main(String[] args) {
		RangeModule r=new RangeModule();
		r.addRange(5,20);
		r.addRange(23, 30);
		r.removeRange(17, 25);
		r.addRange(15, 25);
		
		
		
		
	}
    TreeMap<Integer, Integer> intervals = new TreeMap<>();

	 public void addRange(int left, int right) {
	        Integer start = intervals.floorKey(left);
	        Integer end = intervals.floorKey(right);
	        if(start != null && intervals.get(start) >= left){
	            left = start;
	        }
	        if(end != null && intervals.get(end) > right){
	            right = intervals.get(end);
	        }
	        intervals.put(left, right);
	       
	        intervals.subMap(left, false, right, true).clear();
	    }
	    
	    public boolean queryRange(int left, int right) {
	        Integer start = intervals.floorKey(left);
	        if(start == null) return false;
	        return intervals.get(start) >= right;
	    }
	    
	    public void removeRange(int left, int right) {
	        Integer start = intervals.floorKey(left);
	        Integer end = intervals.floorKey(right);

	        if(end != null && intervals.get(end) > right){
	            intervals.put(right, intervals.get(end));
	        }
	        if(start != null && intervals.get(start) > left){
	            intervals.put(start, left);
	        }
	        intervals.subMap(left, true, right, false).clear();
	    }
}
