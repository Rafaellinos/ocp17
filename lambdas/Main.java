package lambdas;

import java.util.ArrayList;
import java.util.*;

public class Main {

  public static void main(String... args) {
    var animal = new ArrayList<RecordAnimal>();
    animal.add(new RecordAnimal("Rat", false, false));
    animal.add(new RecordAnimal("Lion", false, true));


    print(animal, RecordAnimal::isMale);
    //print(animal, r -> r.isMale()); // same as


  }

  public static void print(List<RecordAnimal> animals, ILambda tester) {
    tester.printSomething(); // it works!
    for (RecordAnimal a : animals) {
      if (tester.check(a)) {
        System.out.println(a);
      } else {
        System.out.println("\"" + a.name() + "\" did not pass to the testtt!");
      }
    }
  }

  public boolean equals(int a, int b, String f, boolean jjj){
    return false;
  }


}
