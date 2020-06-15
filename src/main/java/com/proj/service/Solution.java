package com.proj.service;

import java.util.Scanner;
import java.util.*;
class Solution {
	public static void main(String[] argh) {
		
		withBuiltInMethod();

		

	}
	
	private static void withBuiltInMethod() {
		System.out.println("Java Loops");
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int i = 0; i < t; i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			int n = in.nextInt();

			for (int x = 1; x <= n; x++) {
				int ans = 0;
				for (int y = 1; y <= x; y++) {
					ans= ans+(int) Math.pow(2,y-1)*b; 
				}
				System.out.print(ans + a + " ");
			}

			System.out.println("");
		}

		System.out.println("End");
		in.close();
	}
	
	private static void withoutBuiltInMethod() {
		System.out.println("Java Loops");
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int i = 0; i < t; i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			int n = in.nextInt();

			for (int x = 1; x <= n; x++) {
				int ans = 0;
				int temp = 0;
				for (int y = 1; y <= x; y++) {

					if (y <= 2) {
						temp = y;
					} else {
						temp = temp * 2;
					}

					ans = ans + temp * b;
				}
				System.out.print(ans + a + " ");
			}

			System.out.println("");
		}

		System.out.println("End");
		in.close();
	}
}