package com.real;

public class MInimumSwaps {
	static void updateindex(int index[], int a, int ai, int b, int bi) {
		index[a] = ai;
		index[b] = bi;
	}

	// This function returns minimum number
	// of swaps required to arrange
	// all elements of arr[i..n] become aranged
	static int minSwapsUtil(int arr[], int pairs[], int index[], int i, int n) {
		// If all pairs procesed so
		// no swapping needed return 0
		if (i > n)
			return 0;

		// If current pair is valid so
		// DO NOT DISTURB this pair
		// and move ahead.
		if (pairs[arr[i]] == arr[i + 1])
			return minSwapsUtil(arr, pairs, index, i + 2, n);

		// If we reach here, then arr[i] and
		// arr[i+1] don't form a pair

		// Swap pair of arr[i] with arr[i+1]
		// and recursively compute minimum swap
		// required if this move is made.
		int one = arr[i + 1];
		int indextwo = i + 1;
		int indexone = index[pairs[arr[i]]];
		int two = arr[index[pairs[arr[i]]]];
		int k1 = arr[i + 1];
		int k2 = arr[indexone];
		int k3 = arr[indexone] = arr[i + 1];
		int s = k1 ^ k2 ^ (k3);

		arr[i + 1] = s;
		updateindex(index, one, indexone, two, indextwo);
		int a = minSwapsUtil(arr, pairs, index, i + 2, n);

		// Backtrack to previous configuration.
		// Also restore the previous
		// indices, of one and two
		arr[i + 1] = arr[i + 1] ^ arr[indexone] ^ (arr[indexone] = arr[i + 1]);
		updateindex(index, one, indextwo, two, indexone);
		one = arr[i];
		indexone = index[pairs[arr[i + 1]]];

		// Now swap arr[i] with pair of arr[i+1]
		// and recursively compute minimum swaps
		// required for the subproblem
		// after this move
		two = arr[index[pairs[arr[i + 1]]]];
		indextwo = i;
		arr[i] = arr[i] ^ arr[indexone] ^ (arr[indexone] = arr[i]);
		updateindex(index, one, indexone, two, indextwo);
		int b = minSwapsUtil(arr, pairs, index, i + 2, n);

		// Backtrack to previous configuration. Also restore
		// the previous indices, of one and two
		arr[i] = arr[i] ^ arr[indexone] ^ (arr[indexone] = arr[i]);
		updateindex(index, one, indextwo, two, indexone);

		// Return minimum of two cases
		return 1 + Math.min(a, b);
	}

	// Returns minimum swaps required
	static int minSwaps(int n, int pairs[], int arr[]) {
		// To store indices of array elements
		int index[] = new int[2 * n + 1];

		// Store index of each element in array index
		for (int i = 1; i <= 2 * n; i++)
			index[arr[i]] = i;

		// Call the recursive function
		return minSwapsUtil(arr, pairs, index, 1, 2 * n);
	}

	// Driver code
	public static void main(String[] args) {

		// For simplicity, it is assumed that arr[0] is
		// not used. The elements from index 1 to n are
		// only valid elements
		int arr[] = { 0, 3, 5, 6, 4, 1, 2 };

		// if (a, b) is pair than we have assigned elements
		// in array such that pairs[a] = b and pairs[b] = a
		int pairs[] = { 0, 3, 6, 1, 5, 4, 2};
		int m = pairs.length;

		// Number of pairs n is half of total elements
		int n = m / 2;
		System.out.println(3 ^ 9 ^ 3);
		// If there are n elements in array, then
		// there are n pairs
		System.out.print("Min swaps required is " + minSwaps(n, pairs, arr));
	}

}
