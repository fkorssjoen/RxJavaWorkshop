package com.meli.badpractices;

import com.meli.dto.Numbers;
import rx.Observable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BadPractices {

  public static void main(String[] args) {
    thirdExampleRight();
  }

  public static void firstExample() {
    Integer[] a = {1, 2, 3, 4, 5};
    final Observable<Integer> obs1 = Observable.from(a);
    List<Integer> result = new ArrayList<>();
    obs1.toBlocking().forEach(number -> {
      result.add(number * 2);
    });

//    obs1.map(x -> x*2).subscribe(result::add);
  }


  public static void secondExample() {
    Integer[] a = {2, 3, 4, 5};
    final Observable<Integer> obs1 = Observable.from(a);
    List<Integer> result = new ArrayList<>();

    obs1.map(x -> {
      if(x >= 2) {
        return x*2;
      }
      return 1;
    }).subscribe(result::add);

//    obs1.filter(x -> x >=2)
//        .map(x -> x*2)
//        .defaultIfEmpty(1)
//        .subscribe(result::add);
  }


  public static void thirdExample() {
    List<Integer> firstList = Arrays.asList(2, 3, 4, 5);
    List<Integer> secondList = Arrays.asList(6, 7, 8, 9);
    final Observable<List<Integer>> obs1 = Observable.just(firstList);
    Observable<List<Integer>> obs2 = Observable.just(secondList);

    List<Integer> result = new ArrayList<>();

    obs1.flatMap(firstNumbers ->
        obs2.flatMap(secondNumbers -> {
          List<Integer> resultList = new ArrayList<>();
          resultList.addAll(firstNumbers);
          resultList.addAll(secondNumbers);
          return Observable.just(resultList);
        })).subscribe(result::addAll);

    result.forEach(x -> System.out.println(x));

  }

  public static void thirdExampleRight() {
    List<Integer> firstList = Arrays.asList(2, 3, 4, 5);
    List<Integer> secondList = Arrays.asList(6, 7, 8, 9);
    final Observable<List<Integer>> obs1 = Observable.just(firstList);
    Observable<List<Integer>> obs2 = Observable.just(secondList);

    List<Integer> result = new ArrayList<>();
    Observable.zip(obs1, obs2, ((firstListZip, secondListZip) -> {
      Numbers numbers = new Numbers();
      numbers.setFirstList(firstListZip);
      numbers.setSecondList(secondListZip);
      return numbers;
    })).reduce(new ArrayList<Integer>(), (list, numbersObj) -> {
      list.addAll(numbersObj.getFirstList());
      list.addAll(numbersObj.getSecondList());
      return list;
    }).subscribe(result::addAll);

    result.forEach(x -> System.out.println(x));
  }
}