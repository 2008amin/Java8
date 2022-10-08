package com.amin.java8;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * @author A.andalibi
 * @date 08/10/2022
 */
public class HashMapWithJava8 {
    private ConcurrentHashMap<String, Student> students = new ConcurrentHashMap();

    private List<Integer> predicateAndFunctionWithSortForStudents() {

        // Predicate<Student> predicate= i->i.getAge()>11;
        // Function<Student,Integer> function= I->I.getAge()/10;

        return
                students.values().stream()
                        .filter(i -> i.getAge() > 11)
                        .sorted(Comparator.comparing(Student::getAge))
                        .map(I -> I.getAge() / 10)
                        .collect(Collectors.toList());
    }


    public  List<Student> getFamilies() {
        return (List)students.keySet()
                .stream().map((a) -> {
                    return new Student("Ali","Rezaei","Tehran",10);
                }).collect(Collectors.toList());


		/*students.keySet().stream().forEach((a) -> {
			Student student = new Student();
			student.setFamily(a);
			student.setName(a);
		})*/
    }


    public   void sortAndMap()
    {
        students.put("first",new Student("Ali","Rezaei","Tehran",10));
        students.put("second",new Student("Ahmad","Ahmadi","Shiraz",20));

        students.keySet().stream()
                .filter(x->x.equals("first"))
                .collect(Collectors.toList());

        students.keySet().stream().sorted().collect(Collectors.toList());

        students.keySet().stream().map(Objects::hashCode).collect(Collectors.toList());

    }


}
