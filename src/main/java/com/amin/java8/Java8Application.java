package com.amin.java8;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@SpringBootApplication
public class Java8Application {

	private  static final ConcurrentHashMap<String, String> students = new ConcurrentHashMap();
	private  static final ArrayList<Integer> numbers = new ArrayList<>();


	public static void main(String[] args) {
    	SpringApplication.run(Java8Application.class, args);

		testFunctionAndPredicate();

		testHashmap();

		testOptional();

        getFamilies();
	}

	private static void testFunctionAndPredicate() {

		numbers.add(10);
		numbers.add(20);
		numbers.add(30);

		numbers.stream()
				.filter(i->i>11).map(x->x/10)
				.sorted(Comparator.reverseOrder())
				.collect(Collectors.toList());

		//Comparator.comparing(LoanFile::getEffectiveDate)

		Predicate<Integer> predicateOne= i->i>1;
		Function<Integer,Integer> functionOne= I->I/10;
		numbers.stream().filter(predicateOne).map(functionOne).sorted().collect(Collectors.toList());
	}

	public static List<Student> getFamilies() {
		return (List)students.keySet().stream().map((a) -> {
			Student student = new Student();
			student.setFamily(a);
			student.setName(a);
			return student;
		}).collect(Collectors.toList());


		/*students.keySet().stream().forEach((a) -> {
			Student student = new Student();
			student.setFamily(a);
			student.setName(a);
		})*/
	}


	public  static void testHashmap()
	{
		students.put("a","aa");
		students.put("b","bb");

		students.keySet().stream().filter(x->x.equals("a")).collect(Collectors.toList());

		students.keySet().stream().sorted().collect(Collectors.toList());

		students.keySet().stream().map(Objects::hashCode).collect(Collectors.toList());

	}


	 public static void testOptional()
	{
		Integer value1 = null;
		Integer value2 = new Integer(10);

		//Optional.ofNullable - allows passed parameter to be null.
		Optional<Integer> a = Optional.ofNullable(value1);

		//Optional.of - throws NullPointerException if passed parameter is null
		Optional<Integer> b = Optional.of(value2);

		//Optional.orElse - returns the value if present otherwise returns
		//the default value passed.
		Integer value11 = a.orElse(new Integer(0));

		//Optional.get - gets the value, value should be present
		Integer value12 = b.get();
	}

}
