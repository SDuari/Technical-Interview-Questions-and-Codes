/*
Question: Given an array on integers as input[], produce as output[] another array such that output[i] contains the result of multiplying all numbers but input[i].

Sample input: 5
			  3 4 2 1 6

Sample output: 48 36 72 144 24
*/

import java.util.*;
import java.io.*;

class MultiplyAllButItself{
	public static void main(String[] args){
		int n;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter array size (> 1): "); 
		n = sc.nextInt(); // input array size
		if(n > 1){  // run only if array size is bigger than 1
			int [] input = new int[n];  // input array
			int [] output = new int[n];  // output array
			int [] left = new int[n];  // left[i] is result of multiplication of all values towards left of arr[i]
			int [] right = new int[n];  // right[i] is result of multiplication of all values towards right of arr[i] 
			int i, j;
			
			System.out.println("Enter the " + n + " elements: "); 
			// Get array as input
			for(i = 0; i < n; i++){
				input[i] = sc.nextInt();
			}
			sc.close();
			
			left[0] = 1;
			right[n - 1] = 1;
			
			// Compute left array
			for(i = 1; i < n; i ++){
				left[i] = left[i - 1] * input[i - 1];
			}
			
			// Compute right array
			for(j = n - 2; j >= 0; j--){
				right[j] = right[j + 1] * input[j + 1];
			}
			
			// Compute output array: it is left * right for index i
			for(i = 0; i < n; i++){
				output[i] = left[i] * right[i];
			}
			
			System.out.print("The output is:\t");
			for(i = 0; i < n; i++){
				System.out.print(output[i] + "\t");
			}
			System.out.print("\n");
		}
		else{ // takes care of invalid input (n < 1)
			System.out.println("Wrong input. Array size must be greater than 1. Program terminated!!!");
		}
	}
}