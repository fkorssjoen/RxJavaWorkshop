package com.meli.highorder;


import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

public class HighOrder {
  public static Integer findNumber(Integer number, List<Integer> list) {
    return list
      .stream()
      .filter(x -> x.equals(number))
      .findFirst()
      .orElse(null);
  }

  public static Integer sumValues(List<Integer> list) {
    return list
      .stream()
      .reduce(0, (acumulator, x) -> acumulator + x);
  }

  public static List<Integer> multiplyBy2(List<Integer> list) {
    for (ListIterator<Integer> i = list.listIterator(); i.hasNext(); ) {
      Integer element = i.next();
      i.set(element * 2);
    }
    return list;
  }


  public static List<String> newStringList(List<Integer> list, Integer number) {
    return list
      .stream()
      .filter(x -> x >= number)
      .map(x -> x.toString())
      .collect(Collectors.toList());
  }

  public static Integer factorial(List<Integer> list) {
    return 5;
  }

}
