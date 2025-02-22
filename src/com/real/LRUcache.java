package com.real;

import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class LRUcache {

	// store keys of cache 
    static Deque<Integer> dq; 
    // store references of key in cache 
    static HashSet<Integer> map; 
    // maximum capacity of cache 
    static int csize; 
  
    LRUcache(int n) 
    { 
        dq = new LinkedList<>(); 
        map = new HashSet<>(); 
        csize = n; 
    } 
  
    /* Refers key x with in the LRU cache */
    public void refer(int x) 
    { 
        if (!map.contains(x)) { 
            if (dq.size() == csize) { 
                int last = dq.removeLast(); 
                map.remove(last); 
            } 
        } 
        else { 
            /* The found page may not be always the last element, even if it's an  
               intermediate element that needs to be removed and added to the start  
               of the Queue */
            int index = 0, i = 0; 
            Iterator<Integer> itr = dq.iterator(); 
            while (itr.hasNext()) { 
                if (itr.next() == x) { 
                    index = i; 
                    break; 
                } 
                i++; 
            } 
            dq.remove(index); 
        } 
        dq.push(x); 
        map.add(x); 
    } 
  
    // display contents of cache 
    public void display() 
    { 
        Iterator<Integer> itr = dq.iterator(); 
        while (itr.hasNext()) { 
            System.out.print(itr.next() + " "); 
        } 
    } 
  
    public static void main(String[] args) 
    { 
        LRUcache ca = new LRUcache(4); 
        ca.refer(1); 
        ca.refer(2); 
        ca.refer(3); 
        ca.refer(1); 
        ca.refer(4); 
        ca.refer(5); 
        ca.display(); 
    } 
}
