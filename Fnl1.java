package com.nal.streams;

//import java.util.Arrays;
import java.util.List;

public class Fnl1 {

	public static void main(String[] args) {
		
		List<String> courses = List.of("Spring","Spring Boot","API","Microservices","AWS","PCF","Azure","Docker","Kubernetes");
		
		//evenFunctional(List.of(1,2,3,4,5,6,7,8,9,10));
		//oddFunctional(List.of(1,2,3,4,5,6,7,8,9,10));
		//printCourses(courses);
		//containsSpring(courses);
		//nameLength(courses);
		//squareEven(List.of(1,2,3,4,5,6,7,8,9,10));
		//qubeOdd(List.of(1,2,3,4,5,6,7,8,9,10));
		printCoursesChars(courses);
	}

	private static void evenFunctional(List<Integer> nums)
	{
		nums.stream()
		.filter(no -> no%2 == 0)
		.forEach(System.out::println);
	}
	
	private static void oddFunctional(List<Integer> nums)
	{
		nums.stream()
		.filter(no -> no%2 == 1)
		.forEach(System.out::println);
	}
	
	private static void printCourses(List<String> courseNames)
	{
		courseNames.stream()
		.forEach(System.out::println);
	}
	private static void containsSpring(List<String> courseNames)
	{
		courseNames.stream()
		.filter(name -> name.contains("Spring"))
		.forEach(System.out::println);
	}
	private static void nameLength(List<String> courseNames)
	{
		courseNames.stream()
		.filter(name -> name.length() <= 4)
		.forEach(System.out::println);
	}
	private static void squareEven(List<Integer> nums)
	{
		nums.stream()
		.filter(num -> num %2 == 0)
		.map(num -> num*num)
		.forEach(System.out::println);
	}
	private static void qubeOdd(List<Integer> nums)
	{
		nums.stream()
		.filter(num -> num %2 == 1)
		.map(num -> num*num*num)
		.forEach(System.out::println);
	}
	private static void printCoursesChars(List<String> courseNames)
	{
		courseNames.stream()
		.map(courseName -> courseName +" "+ courseName.length())
		.forEach(System.out::println);
	}
}
