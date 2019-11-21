package com.meli.operators.filter;

import org.junit.Test;
import rx.Observable;
import rx.observers.TestSubscriber;

public class FilterExampleTest {
  @Test
  public void TestFilterExample() {
    final Observable<Integer> integerObservable = FilterExample.filterExample();
    TestSubscriber<Integer> testSubscriber = new TestSubscriber<>();
    integerObservable.subscribe(testSubscriber);

    testSubscriber.assertNoErrors();
    testSubscriber.assertValues(6, 8, 10, 12);
  }

  @Test
  public void TestSkipWhileExample() {
    final Observable<Integer> integerObservable = FilterExample.skipExample();

    integerObservable.subscribe(System.out::println);
    TestSubscriber<Integer> testSubscriber = new TestSubscriber<>();
    integerObservable.subscribe(testSubscriber);

    testSubscriber.assertNoErrors();
    testSubscriber.assertValues(8, 10, 12);
  }
}
