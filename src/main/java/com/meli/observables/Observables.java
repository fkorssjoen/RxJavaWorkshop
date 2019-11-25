package com.meli.observables;

import rx.Observable;
import rx.observables.ConnectableObservable;

import java.util.concurrent.TimeUnit;

public class Observables {

  public static void main(String[] args) {
    coldObservable();
  }


  public static void coldObservable() {
    try {
      Observable<Long> cold = Observable.interval(200, TimeUnit.MILLISECONDS);
      cold.subscribe(i -> System.out.println("First: " + i));
      Thread.sleep(500);
      cold.subscribe(i -> System.out.println("Second: " + i));
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public static void hotObservable() {
    try {
      ConnectableObservable<Long> cold = Observable.interval(200, TimeUnit.MILLISECONDS).publish();
      cold.connect();

      cold.subscribe(i -> System.out.println("First: " + i));
      Thread.sleep(500);
      cold.subscribe(i -> System.out.println("Second: " + i));
      Thread.sleep(2000);
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}
