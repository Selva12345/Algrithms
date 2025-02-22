package com.hacker;

public class DistanceBetweenNodes {
	
	    // (To the moderator) in c++ solution this variable 
	    // are declared as pointers hence changes made to them  
	    // reflects in the whole program 
	      
	    // Global static variable 
	    static int d1 = -1; 
	    static int d2 = -1; 
	    static int dist = 0; 
	      
	    // A Binary Tree Node 
	    static class Node{ 
	        Node left, right; 
	        int key; 
	          
	        // constructor 
	        Node(int key){ 
	            this.key = key; 
	            left = null; 
	            right = null; 
	        } 
	    } 
	      
	    // Returns level of key k if it is present in tree, 
	     // otherwise returns -1 
	    static int findLevel(Node root, int k, int level) 
	    { 
	        // Base Case 
	        if (root == null) 
	            return -1; 
	          
	        // If key is present at root, or in left subtree or right subtree, 
	        // return true; 
	        if (root.key == k) 
	            return level; 
	              
	        int l = findLevel(root.left, k, level + 1); 
	        return (l != -1)? l : findLevel(root.right, k, level + 1); 
	    } 
	      
	    // This function returns pointer to LCA of two given values n1 and n2.  
	    // It also sets d1, d2 and dist if one key is not ancestor of other 
	    // d1 --> To store distance of n1 from root 
	    // d2 --> To store distance of n2 from root 
	    // lvl --> Level (or distance from root) of current node 
	    // dist --> To store distance between n1 and n2 
	    static Node findDistUtil(Node root, int n1, int n2, int lvl){ 
	          
	        // Base case 
	        if (root == null) 
	            return null; 
	          
	        // If either n1 or n2 matches with root's key, report 
	        // the presence by returning root (Note that if a key is 
	        // ancestor of other, then the ancestor key becomes LCA 
	        if (root.key == n1){ 
	            d1 = lvl; 
	            return root; 
	        } 
	        if (root.key == n2) 
	        { 
	            d2 = lvl; 
	            return root; 
	        } 
	          
	        // Look for n1 and n2 in left and right subtrees 
	        Node left_lca = findDistUtil(root.left, n1, n2,  lvl + 1); 
	        Node right_lca = findDistUtil(root.right, n1, n2,  lvl + 1); 
	          
	        // If both of the above calls return Non-NULL, then one key 
	        // is present in once subtree and other is present in other, 
	        // So this node is the LCA 
	        if (left_lca != null && right_lca != null) 
	        { 
	            dist = (d1 + d2) - 2*lvl; 
	            return root; 
	        } 
	          
	        // Otherwise check if left subtree or right subtree is LCA 
	        return (left_lca != null)? left_lca : right_lca;     
	    } 
	      
	    // The main function that returns distance between n1 and n2 
	    // This function returns -1 if either n1 or n2 is not present in 
	    // Binary Tree. 
	    static int findDistance(Node root, int n1, int n2){ 
	         d1 = -1; 
	         d2 = -1; 
	         dist = 0; 
	        Node lca = findDistUtil(root, n1, n2, 1); 
	          
	        // If both n1 and n2 were present in Binary Tree, return dist 
	        if (d1 != -1 && d2 != -1) 
	            return dist; 
	          
	        // If n1 is ancestor of n2, consider n1 as root and find level  
	        // of n2 in subtree rooted with n1 
	        if (d1 != -1) 
	        { 
	            dist = findLevel(lca, n2, 0); 
	            return dist; 
	        } 
	          
	        // If n2 is ancestor of n1, consider n2 as root and find level  
	        // of n1 in subtree rooted with n2 
	        if (d2 != -1) 
	        { 
	            dist = findLevel(lca, n1, 0); 
	            return dist; 
	        } 
	          
	        return -1; 
	    } 
	      
	  
	    // Driver program to test above functions 
	    public static void main(String[] args) { 
	          
	        // Let us create binary tree given in the above example 
	        Node  root = new Node(1); 
	        root.left = new Node(2); 
	        root.right = new Node(3); 
	        root.left.left = new Node(4); 
	        root.left.right = new Node(5); 
	        root.right.left = new Node(6); 
	        root.right.right = new Node(7); 
	        root.right.left.right = new Node(8); 
	         
	        System.out.println("Dist(4, 5) = "+findDistance(root, 4, 5)); 
	        System.out.println("Dist(4, 6) = "+findDistance(root, 4, 6)); 
	        System.out.println("Dist(3, 4) = "+findDistance(root, 3, 4)); 
	        System.out.println("Dist(2, 4) = "+findDistance(root, 2, 4)); 
	        System.out.println("Dist(8, 5) = " +findDistance(root, 8, 5)); 
	          
	    } 

}
