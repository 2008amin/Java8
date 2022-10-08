package com.amin.java8;

import java.util.Optional;

/**
 * @author A.andalibi
 * @date 08/10/2022
 */
public class OptionalWithJAVA8 {

    public  void testOptional()
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
