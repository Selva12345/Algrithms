package com.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class DesignCircularQueue {
	public static void main(String[] args) {
		DesignCircularQueue d = new DesignCircularQueue(3);
		d.enQueue(2);  // return true
		d.enQueue(3);  // return true
		d.enQueue(4);  // return false, the queue is full
		d.Rear();  // return 3
		d.isFull();  // return true
		d.deQueue();  // return true
		d.enQueue(4);  // return true
		d.Rear();  // return 4
	}

	  final int[] a;
      int front, rear = -1, len = 0;

      public DesignCircularQueue(int k) { a = new int[k];}

      public boolean enQueue(int val) {
          if (!isFull()) {
              rear = (rear + 1) % a.length;
              a[rear] = val;
              len++;
              return true;
          } else return false;
      }

      public boolean deQueue() {
          if (!isEmpty()) {
              front = (front + 1) % a.length;
              len--;
              return true;
          } else return false;
      }

      public int Front() { return isEmpty() ? -1 : a[front];}

      public int Rear() {return isEmpty() ? -1 : a[rear];}

      public boolean isEmpty() { return len == 0;}

      public boolean isFull() { return len == a.length;}
}
