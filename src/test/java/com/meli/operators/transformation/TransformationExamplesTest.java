package com.meli.operators.transformation;

import org.junit.Test;
import rx.Observable;
import rx.observers.TestSubscriber;

import java.util.Arrays;
import java.util.List;

public class TransformationExamplesTest {
  @Test
  public void mapExampleTest() {
    Observable<Integer> integerObservable = TransformationExamples.mapExample();
    TestSubscriber<Integer> testSubscriber = new TestSubscriber<>();

    integerObservable.subscribe(testSubscriber);
    testSubscriber.assertValues(2, 4, 6, 8, 10);
  }

  @Test
  public void flatMapExampleTest() {
    Observable<String> integerStrObservable = TransformationExamples.flatMapExample();
    TestSubscriber<String> testSubscriber = new TestSubscriber<>();

    integerStrObservable.subscribe(testSubscriber);
    testSubscriber.assertValues("number :1", "number :2", "number :3", "number :4", "number :5", "number :6");
  }

  @Test
  public void concatMapExampleTest() {
    Observable<String> integerStrObservable = TransformationExamples.concatMapExample();
    TestSubscriber<String> testSubscriber = new TestSubscriber<>();

    integerStrObservable.subscribe(testSubscriber);
    testSubscriber.assertValues("number :1", "number :2", "number :3", "number :4", "number :5", "number :6");
  }

  @Test
  public void reduceExample1Test() {
    final Observable<Integer> integerObservable = TransformationExamples.reduceExample1();
    TestSubscriber<Integer> testSubscriber = new TestSubscriber<>();

    integerObservable.subscribe(testSubscriber);

    testSubscriber.assertNoErrors();
    testSubscriber.assertValue(10);
  }

  @Test
  public void reduceExample2Test() {
    final List<Integer> integerList = Arrays.asList(1, 2, 3, 4);

    final Observable<List<Integer>> listObservable = TransformationExamples.reduceExample2();
    TestSubscriber<List<Integer>> testSubscriber = new TestSubscriber<>();

    listObservable.subscribe(testSubscriber);

    testSubscriber.assertNoErrors();
    testSubscriber.assertValue(integerList);
  }

  @Test
  public void toListExampleTest() {
    final List<String> integerList = Arrays.asList("first title", "second title");

    Observable<List<String>> listObservable = TransformationExamples.toListExample();
    TestSubscriber<List<String>> testSubscriber = new TestSubscriber<>();

    listObservable.subscribe(testSubscriber);

    testSubscriber.assertNoErrors();
    testSubscriber.assertValue(integerList);
  }


}
