/*
 * @author RasPat
Problem:
Given a list of points sum 
up all points and give a percentage value (truncated)
to each position.  Any remaining percentage points
will be given to those with the most points in order 
from most to least.  IF there is a tie when ahndign 
out the remaining points the priority goes to those
earlier in the list.

See ./Bonuses.txt

Solution
Add up all the values in the list
Divide and assign points
Truncate the percenteage
Give the points out
Divide the remaining n% over n employees
*/

import java.util.ArrayList;

public class Bonuses {
	public static void main(String[] args) {
		int[] points = new int[args.length];
		for (int i = 0; i < args.length; i++) {
			points[i] = Integer.parseInt(args[i]);
		}
		getDivision(points);	
	}

	public static void getDivision(int[] points) {
		int sum = getSum(points);
		int[] percentages = new int[points.length];

		for (int i = 0; i < points.length; i++) {
			// Find percentage points of total for each employee
			percentages[i] = (points[i] * 100 / sum);
		}

		// Find how many unallovated percentage points
		int diff = 100 - getSum(percentages);
		findNMaxes(diff, points);
		printPoints(points);
		printPoints(percentages);
	}

	/*
	This function finds the top N employees
	input: 	N - number of top employees to find
			points, the point values of the top employees 
	output: An array continaing the indicies of the top N employees

	Note: If there are multiple employees with the same # of points
	preference goes the the employee who appears first in the list	
	
	Note: send in the points not the percentages since the
	percenages get truncated frm points	
	*/
	public static int[] findNMaxes(int diff, int[] points) {
		int[] indicies = new int[diff];
		// Separate list of pairs for index and max value
		// [0][i] is value
		// [1][i] is index

		int[][] pairs = new int[diff][2];
		ArrayList pairs = new ArrayList();

		for (int i = 0; i < points.length; i++) {
			pairs.add(points[i], i);
			pairs.sort();
		}

		for (int i = 0; i < diff; i++) {
			int index = pairs.get(i);
			points[index]++;
		}

		for (int i = 0; i < points.length; i++) {
			for (int n = 0; n < diff; n++) {
				// Keep pairs list sorted by point Number

			}
			// if (pairs[i][1] < points[i]) {
			// 	pairs[i][0] = 
			// }
		}


		return indicies;
	}






	public static int getSum(int[] points) {
		int sum = 0;
		for (int p : points) {
			sum += p;
		}
		return sum;
	}

	public static void printPoints(int[] points) {
		System.out.print("[");
		for (int p: points) {
			System.out.print(" " + p);
		}
		System.out.print(" ]\n");
	}
}
