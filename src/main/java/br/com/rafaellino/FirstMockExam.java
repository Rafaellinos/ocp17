package br.com.rafaellino;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class LocalClass {

}

public class FirstMockExam {

  public static void question1() {
    final int score1 = 8, score2 = 3;
    char myScore = 7;
    var goal = switch (myScore) {
      default -> {if(10 > score1) yield "unknown"; else yield "a";} // 44 missing yield when false
      case score1 -> "great";
      case 2, 4, 6 -> "good";
      case score2, 0 -> {yield "bad";} // 47 originally missing yield keyword
      };
//    System.out.println(goal);
//    System.out.println();
  }

  public static void question2() {
    int moon = 9, star = 2 + 2 * 3;
    float sun = star > 10 ? 1 : 3;
    double jupiter = (sun + moon) - 1.0F; // autocast?
    int mars = --moon <= 8 ? 2 : 3;
    System.out.println(sun+", "+jupiter+", "+mars);
    // 3,11,2
  }

  public static void question3() {
    // how to make this code always return 100?
    // wrap lambda with synchronized block to guarantee thread safety
    // remove parallel
    // change forEach to forEachOrdered
    List<Integer> data = new ArrayList<>();
    IntStream.range(0,100).parallel().forEach(s -> data.add(s));
    System.out.println(data.size());
  }

  public static void question4() {
    Predicate<String> empty = String::isEmpty;
    Predicate<String> notEmpty = empty.negate();

    // runs indefinite
    Object Entry = null;
    Object Collection = new Object();
    var result = Stream.generate(() -> "")
      .filter(notEmpty)
      .collect(Collectors.groupingBy(k -> k))
      .entrySet()
      .stream();
//      .map(Entry::getValue)
//      .flatMap(Collection::stream)
//      .collect(Collectors.partitioningBy(notEmpty));
    System.out.println(result);
  }

  public static void question5() {
    // public class above
    class MathFunctions {
      public static void addToInt(int x, int amountToAdd) {
        x = x + amountToAdd;
      }
      public static void main(String[] args) {
        var a = 15;
        var b = 10;
        MathFunctions.addToInt(a, b);
        System.out.println(a);
      }
    }
  }

  public static void question6() {
    // properties default order
    // 1: SOMETHING.properties
    // 2: SOMETHING_<some_lang>.properties in Locale.setDefault()
    Locale fr = new Locale("fr");
    Locale.setDefault(new Locale("en", "US"));
    var b = ResourceBundle.getBundle("Penguin", fr);
    System.out.println(b.getString("name"));
    System.out.println(b.getString("age"));
  }

  public static void question7() {
    int[] array = {6,9,8};
    System.out.println("B" + Arrays.binarySearch(array,9));
    // binarysSearch DOES NOT SORT the elements (undefined)
    System.out.println("C" + Arrays.compare(array, new int[] {6, 9, 8}));
    // compare returns 0 when same length and same elements (C0)
    System.out.println("M" + Arrays.mismatch(array, new int[] {6, 9, 8}));
    // mismatch returns -1 when arrays are equivalents (M-1)
  }

  public static void question8() {
    // TODO estudar
    Predicate<Integer> r = i -> i == 1;

    Predicate<Integer> x = r.negate(); // negates the r result
    Runnable y = () -> System.out.println(); //Runnable does not use generics
    Comparator<Integer> z = (a, b) -> a - b;
  }

  public static void question9() {
    // module name com.vet
    // where to put module-info.java
    // answer: usually, in the root folder, in this case, none because public modifier isn't allowed in a module
//    public module com.vet {
//      exports com.vet;
//    }
  }

  public static void question10() {
//    interface HasTail {
//      private int getTailLength();
//    } // line 1 does not compile

    interface HasTail {

    }
    abstract class Puma implements HasTail {
      String getTailLength() { return "4"; } // line 3
    }

    // originally public class Cougar implements HasTail
    class Cougar implements HasTail { // line 5
      public static void main(String[] args) {
        var puma = new Puma() {}; // line 7 anonymous implementation of Puma
        System.out.println(puma.getTailLength());
      }
      public int getTailLength(int length) { return 2; } // line 10
    }
  }

  /**
   * Aahasdasd
   * @author Rafael Veloso
   */
  public static void question11() {
    // Frog.java
    //    package animal;
    //    public class Frog {
    class Frog{
      protected void ribbit() { }
      void jump() { }
    }

    // Tadpole.java
    //    package other;
    //    import animal.*;
    class Tadpole extends Frog {
      public static void mainFake(String[] args) {
        Tadpole t = new Tadpole();
        t.ribbit();
        t.jump();
        Frog f = new Tadpole();
        f.ribbit();
        f.jump();
      }
    }
    Tadpole.mainFake(new String[] {});
  }
}

