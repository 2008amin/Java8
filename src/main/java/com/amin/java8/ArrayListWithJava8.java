package com.amin.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author A.andalibi
 * @date 08/10/2022
 */
public class ArrayListWithJava8 {
    private ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(10, 20, 30));
    private  static final ArrayList<Integer> numbers1 = new ArrayList<>(Arrays.asList(10,20,30));
    private  static final ArrayList<Integer> numbers2 = new ArrayList<>(Arrays.asList(10,20));

    public List<Integer> filterAndMapNumbers() {
        return numbers.stream()
                .filter(i -> i > 11)
                .map(x -> x / 10)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    private List<Integer> predicateAndFunctionForNumbers() {
        Predicate<Integer> predicateOne = i -> i > 11;
        Function<Integer, Integer> functionOne = I -> I / 10;


        return
                numbers.stream()
                        .filter(predicateOne)
                        .map(functionOne)
                        .sorted()
                        .collect(Collectors.toList());
    }

    public  void removeDuplicateBetweenTwoCollections()
    {
        List<Integer> duplicateItems = numbers1.stream()
                .filter(two -> numbers2.stream()
                        .anyMatch(one -> one.toString().equals(two.toString())))
                .collect(Collectors.toList());

        numbers1.removeAll(duplicateItems);
    }

    public  void parallelVSSequential()
    {
        List<Integer> myList = new ArrayList<>();
        for(int i=0; i<100; i++) myList.add(i);

        //sequential stream
        Stream<Integer> sequentialStream = myList.stream();

        //parallel stream
        Stream<Integer> parallelStream = myList.parallelStream();

        //using lambda with Stream API, filter example
        Stream<Integer> highNums = parallelStream.filter(p -> p > 90);
        //using lambda in forEach
        highNums.forEach(p -> System.out.println("High Nums parallel="+p));

        Stream<Integer> highNumsSeq = sequentialStream.filter(p -> p > 90);
        highNumsSeq.forEach(p -> System.out.println("High Nums sequential="+p));

    }
}
