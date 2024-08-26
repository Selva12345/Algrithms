package com.leetcode;

import java.util.*;

public class SumofDistancesinTree {
	public static void main(String[] args) {
		SumofDistancesinTree s=new SumofDistancesinTree();
		int edge[][]= {{0,1},{0,2},{2,3},{2,4},{2,5}};
		s.sumOfDistancesInTree(6, edge);
		
	}
	int []res;
	int count[];
	int M;
	public int[] sumOfDistancesInTree(int n, int[][] edges) {
		res=new int[n];
		count=new int[n];
		M=n;
		Map<Integer, List<Integer>> graph= new HashMap<>();
		buildGraph(n,edges,graph);

		traverse(graph,0,-1);
		traverseAll(graph,0,-1);
		return res;
	}

	public void traverse(Map<Integer,List<Integer>> graph, int start, int prev){
		int c=0;
		if(graph.get(start)==null)return ;
		for(int v:graph.get(start)){
			if(v==prev)continue;
			traverse(graph,v,start);
			count[start]+= count[v];
			res[start]+=res[v]+count[v];
			//System.out.println(start+" "+count[start]);
		}

		 count[start]++;
	}
	public void traverseAll(Map<Integer,List<Integer>> graph,int start,int prev){
		int c=0;
		if(graph.get(start)==null)return;
		for(int v:graph.get(start)){
			if(v==prev)continue;
			res[v]=res[start]-count[v]+(M-count[v]);
			traverseAll(graph,v,start);

		}
		return;
	}
	public void buildGraph(int n, int[][] edges, Map<Integer,List<Integer>> graph){
		for(int arr[]:edges){
			graph.computeIfAbsent(arr[0],s->new ArrayList<>()).add(arr[1]);
			graph.computeIfAbsent(arr[1],s->new ArrayList<>()).add(arr[0]);
		}
	}
}
