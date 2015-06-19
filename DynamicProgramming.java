//Sean Stasny
//Dr. Yixin Chen
//CSci: 433 - Algorithms and Data Analysis
//04-19-2015

/*The stock market lets investors make money through dividends and by selling appreciated stocks at a profit. But investors can lose money if the stock's price goes down and the investor sells the stock at a loss. Dr. Stock Market Oracle designed an algorithm that is capable of predicting what the share price of The Most Predictable Inc. (TMP) will be for the next N days. Each day you can either buy one share of TMP, sell any number of shares of TMP, or not doing any transaction. Design a trading algorithm that will make the maximum profit.

The input of your JAVA program should accept two lines. The first line contains the integer N, i.e., number of days. The second line contains N integers, representing predicted TMP share price for the next N days.

The output should be the maximum profit.

Samples:
Input:
3
9 6 3
Output:
0

Input:
4
1 2 1 2
Output:
2

Input:
3
1 2 10
Output:
17

Due: April 20.
*/

package edu.olemiss.algorithms;

import java.util.Scanner;

public class Project2
{
	public static void main(String [] args)
	{
		Scanner scan = new Scanner(System.in);
		int totalDays = scan.nextInt();
		int[] days = new int[totalDays];
		int max = 0;
		int maxIndex = 0;
		int sum = 0;
		
		for(int i = 0; i < totalDays; i++)
		{
			days[i] = scan.nextInt();
		}
		
		for(int i = 0; i < totalDays; i++)
		{
			if(days[i] > max)
			{
				maxIndex = i;
				max = days[i];
			}
		}
		
		for(int i = 0; i < maxIndex; i++)
		{
			sum += days[i];
		}
		
		int sellAmount = (maxIndex) * max;
		int finalAmount = sellAmount - sum;
		//System.out.println("Sum: " + sum + ", SellAmount: " + sellAmount + ", FinalAmount: " + finalAmount);
		//System.out.println("Max: " + max + ", MaxIndex: "+ maxIndex);
		
		int savedFinalAmount = finalAmount;
		int savedMaxIndex = 0;
		
		while(maxIndex != totalDays-1)
		{
			max = 0;
			sum = 0;
			savedMaxIndex = maxIndex;
			sellAmount = 0;
			for(int i = (maxIndex + 1); i < totalDays; i++)
			{

				if(days[i] > max)
				{
					maxIndex = i;
					max = days[i];
				}
			}	
			System.out.println("MaxIndex: " + maxIndex + ",Max: " + max);
			for(int i = savedMaxIndex + 1; i < maxIndex; i++)
			{
				sum += days[i];
				sellAmount += max;
			}
			finalAmount = sellAmount - sum;
			savedFinalAmount += finalAmount;
			//System.out.println("Sum: " + sum + ", SellAmount: " + sellAmount + ", FinalAmount: " + finalAmount);
		}
		
		//System.out.println("-MaxIndex: " + maxIndex + ", Max: " + max);
		
		//System.out.println("SaveFinalAmount: " + savedFinalAmount);
		System.out.println("Output: \n" + savedFinalAmount);
	}
}
