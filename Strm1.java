package com.nal.streams;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class Strm1 {

	public static void main(String[] args) {
		
		
		List<Integer> nums = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		
		List<Integer> nums2 = Arrays.asList(2,22,232,453,765,987,2048,244,322,397,-225);
		
		List<Integer> nums3 = Arrays.asList(1,2,3,3,4,6,2,7,8,9,45,78,9,45);
		
		printSum(nums);
		
		printAverage(nums);
		
		squareAndFilter(nums);
		
		oddAndEven(nums);
		
		startsWithX(nums2);
		
		printDuplicate(nums3);
		
		maxAndMin(nums2);
		
		ascAndDesc(nums2);
		
		getIgnoreN(nums2);
		
		secondHighestLowest(nums2);
	}

	private static void printSum(List<Integer> nums) {
		// TODO - print the sum of numbers in a list
		
		Optional<Integer> sumNums = nums.stream().reduce((a,b)->(a+b));
		
		System.out.println("Sum of the given numbers = "+sumNums.get());
	}
	
	private static void printAverage(List<Integer> nums)
	{
		// TODO - print the average of numbers in a list
		
		double avg = nums.stream().mapToInt(x -> x).average().getAsDouble();
		System.out.println("The average is = "+avg);
	}
	private static void squareAndFilter(List<Integer> nums)
	{
		// TODO - square the number and print those that are greater than 50
		
		nums.stream()
		.map(x -> x*x)
		.filter(x -> x > 50)
		.forEach(System.out::println);
	}
	private static void oddAndEven(List<Integer> nums)
	{
		// TODO - store and print odd and even numbers
		
		List<Integer> oddNums = nums.stream()
								.filter(x -> x%2==1)
								.collect(Collectors.toList());
		System.out.println("Odd numbers "+oddNums);
		
		List<Integer> evenNums = nums.stream()
				.filter(x -> x%2==0)
				.collect(Collectors.toList());
		System.out.println("Even numbers "+evenNums);
	}
	private static void startsWithX(List<Integer> nums)
	{
		// TODO - store and print numbers starting with x 
		
		List<Integer> numsOfX = nums.stream()
								.map(x -> Integer.toString(x))
								.filter(x -> x.startsWith("2") || x.startsWith("-2"))
								.map(x -> Integer.parseInt(x))
								.collect(Collectors.toList());
		
		System.out.println("Numbers starting with 2 are "+numsOfX);
	}
	private static void printDuplicate(List<Integer> nums)
	{
		// TODO - print the duplicate numbers from the list 
		
		Set<Integer> dup = nums.stream()
						.filter(x -> Collections.frequency(nums, x)>1)
						.collect(Collectors.toSet());
		
		System.out.println("Duplicate elements are "+ dup);
		
		// alternative approach by using a HashSet
		Set<Integer> dupNum = new HashSet<Integer>();
		Set<Integer> dup2 = nums.stream()
							.filter(x -> !dupNum.add(x))
							.collect(Collectors.toSet());
							
		System.out.println("Duplicat numbers by HashSet = "+dup2);
	}
	private static void maxAndMin(List<Integer> nums)
	{
		// TODO - print the maximum and the minimum number in the list
		
		int max = nums.stream()
				.max(Comparator.comparing(Integer::valueOf))
				.get();
		
		System.out.println("Maximum number in the list is = "+max);
		
		int min = nums.stream()
				.min(Comparator.comparing(Integer::valueOf))
				.get();
		
		System.out.println("Minimum number in the list is = "+min);
	}
	private static void ascAndDesc(List<Integer> nums)
	{
		// TODO - print the list in ascending and descending order
		
		List<Integer> asc = nums.stream()
							.sorted()
							.collect(Collectors.toList());
		
		System.out.println("List in ascending order = "+asc);
		
		List<Integer> desc = nums.stream()
							 .sorted(Collections.reverseOrder())
							 .collect(Collectors.toList());
		
		System.out.println("List in descending order = "+desc);
	}
	private static void getIgnoreN(List<Integer> nums)
	{
		// TODO - print the first 5 numbers and skip the first 5 numbers
		
		List<Integer> skip = nums.stream()
								.skip(5)
								.collect(Collectors.toList());
		
		System.out.println("Elements after skipping first 5 elements "+skip);
		System.out.println("Their sum is = "+ skip.stream().reduce((a,b) -> (a+b)).get());
		
		// now to include the first 5 numbers
		
		List<Integer> include = nums.stream()
				.limit(5)
				.collect(Collectors.toList());

		System.out.println("Elements after including first 5 elements "+include);
		System.out.println("Their sum is = "+ include.stream().reduce((a,b) -> (a+b)).get());
	}
	private static void secondHighestLowest(List<Integer> nums)
	{
		// TODO - print the second highest and the 2nd lowest number 
		
		int secH = nums.stream()
					.sorted(Collections.reverseOrder())
					.distinct()
					.skip(1)
					.findFirst()
					.get();
		
		System.out.println("The second highest number in the list is = "+secH);
		
		int secL = nums.stream()
				.sorted()
				.distinct()
				.skip(1)
				.findFirst()
				.get();
	
		System.out.println("The second lowest number in the list is = "+secL);
	}
}
