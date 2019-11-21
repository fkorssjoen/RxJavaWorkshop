package com.meli.operators.creation;

import org.junit.Test;
import rx.Observable;
import rx.observers.TestSubscriber;

import java.util.Arrays;
import java.util.List;

public class CreationExampleTest {

  @Test
  public void TestFromExample() {
    Observable<Integer> integerObs = CreationExample.obsFromExample();
    TestSubscriber<Integer> testSubscriber = new TestSubscriber<>();
    integerObs.subscribe(testSubscriber);

    testSubscriber.assertNoErrors();
    testSubscriber.assertValues(1, 2, 3, 4, 5, 6);
  }

  @Test
  public void TestJustExample() {
    List<Integer> expectedList = Arrays.asList(1, 2, 3, 4, 5, 6);
    Observable<List<Integer>> integerObs = CreationExample.obsJustExample();
    TestSubscriber<List<Integer>> testSubscriber = new TestSubscriber<>();

    integerObs.subscribe(testSubscriber);
    testSubscriber.assertNoErrors();
    testSubscriber.assertValue(expectedList);
  }

}
