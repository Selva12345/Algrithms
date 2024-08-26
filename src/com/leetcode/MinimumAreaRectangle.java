package com.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MinimumAreaRectangle {
    public static void main(String[] args) {
        MinimumAreaRectangle m=new MinimumAreaRectangle();
        int point[][]={{1,1},{1,3},{3,1},{3,3},{4,1},{4,3}};
        System.out.println(m.minAreaRect(point));
    }
    public int minAreaRect(int[][] points) {

        Set<String> pts=new HashSet<>();
        for(int i=0;i<points.length;i++){
            int point[]=points[i];
            pts.add(point[0]+"-"+point[1]);
        }
        Arrays.sort(points,(a, b)->a[0]==b[0]?a[1]-b[1]:a[0]-b[0]);
        int area=Integer.MAX_VALUE;
        for(int i=0;i<points.length;i++){
            for(int j=i+1;j<points.length;j++){
                int a[]=points[i];
                int b[]=points[j];
                if(a[0]==b[0]||a[1]==b[1]){
                    continue;
                }
                System.out.println(a[0]+"-"+a[1]);
                System.out.println(b[0]+"-"+b[1]);
                if(pts.contains(a[0]+"-"+b[1])&&pts.contains(b[0]+"-"+a[1])){
                    int c=Math.abs(a[0]-b[0]);
                    int d=Math.abs(a[1]-b[1]);
                    area=Math.min(area,c*d);
                    //break;
                }

            }
        }
        return area;
    }
}
