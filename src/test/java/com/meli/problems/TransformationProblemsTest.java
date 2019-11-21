package com.meli.problems;

import org.junit.Test;
import rx.Observable;
import rx.observers.TestSubscriber;

import java.util.Arrays;
import java.util.List;

public class TransformationProblemsTest {
  @Test
  public void TestFirstProblem() {
    List<Integer> numbersList = Arrays.asList(1, 2, 3, 4, 5, 6);
    List<String> expectedList = Arrays.asList("6", "8", "10", "12");
    final Observable<List<String>> stringListObs = TransformationProblems.getStringList(numbersList);

    TestSubscriber<List<String>> testSubscriber = new TestSubscriber<>();
    stringListObs.subscribe(testSubscriber);

    testSubscriber.assertNoErrors();
    testSubscriber.assertValue(expectedList);
  }

  @Test
  public void TestSecondProblem() {
    List<Integer> firstList = Arrays.asList(1, 2, 3, 4);
    List<Integer> secondList = Arrays.asList(1, 8, 10, 12);

    List<Integer> expectedList = Arrays.asList(10, 13, 16);
    final Observable<List<Integer>> stringListObs = TransformationProblems.getListsSum(firstList, secondList);

    TestSubscriber<List<Integer>> testSubscriber = new TestSubscriber<>();
    stringListObs.subscribe(testSubscriber);

    testSubscriber.assertNoErrors();
    testSubscriber.assertValue(expectedList);
  }
}
