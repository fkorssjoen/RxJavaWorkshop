package com.meli.highorder;

import java.util.List;
import java.util.ListIterator;

public class HighOrder {
  public static Integer findNumber(Integer number, List<Integer> list) {
    for (Integer element : list) {
      if (element.equals(number)) {
        return element;
      }
    }
    return null;
  }

  public static Integer sumValues(List<Integer> list) {
    int result = 0;
    for (Integer element : list) {
      result += element;
    }
    return result;
  }

  public static List<Integer> multiplyBy2(List<Integer> list) {
    for (ListIterator<Integer> i = list.listIterator(); i.hasNext(); ) {
      Integer element = i.next();
      i.set(element * 2);
    }
    return list;
  }
}
