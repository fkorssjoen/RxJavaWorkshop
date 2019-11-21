package com.meli.operators.merge;

import org.junit.Test;
import rx.Observable;
import rx.observers.TestSubscriber;

public class MergeOperatorsExampleTest {
  @Test
  public void TestZipExample() {
    Observable<Integer> integerObservable = MergeOperatorsExample.zipExample();
    TestSubscriber<Integer> testSubscriber = new TestSubscriber<>();
    integerObservable.subscribe(testSubscriber);

    testSubscriber.assertValues(7, 9, 11, 13, 15);
  }

  @Test
  public void TestMergeExample() {
    Observable<Integer> integerObservable = MergeOperatorsExample.mergeExample();
    TestSubscriber<Integer> testSubscriber = new TestSubscriber<>();
    integerObservable.subscribe(testSubscriber);

    testSubscriber.assertValues(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
  }
}
