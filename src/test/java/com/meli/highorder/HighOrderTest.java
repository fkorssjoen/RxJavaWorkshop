package com.meli.highorder;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class HighOrderTest {

  @Test
  public void returnsANumberFromAList() {
    List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5);
    Integer number = HighOrder.findNumber(2, integerList);
    Assert.assertEquals(2, number.intValue());
  }

  @Test
  public void returnsTheSumOfAList() {
    List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5);
    Integer number = HighOrder.sumValues(integerList);
    Assert.assertEquals(15, number.intValue());
  }

  @Test
  public void returnsEachElementOfAListBy2() {
    List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5);
    List<Integer> newIntegerList = HighOrder.multiplyBy2(integerList);
    Assert.assertEquals(2, newIntegerList.get(0).intValue());
  }


  @Test
  public void createStringNewListGreaterThan2() {
    List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5);
    List<String> newStringList = HighOrder.newStringList(integerList, 2);

    List<String> expected = Arrays.asList("2", "3", "4", "5");
    Assert.assertEquals(expected, newStringList);
  }

  @Test
  public void testFactorialOf6() {
    List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 6);
    Integer factorial = HighOrder.factorial(integerList);
    Integer expected = 720;

    Assert.assertEquals(expected, factorial);
  }

}
