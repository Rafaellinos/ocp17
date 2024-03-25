

import java.util.Random;


public class RandomTests {
  public static void main(String... args) {
    var r = new RandomTests();
    r.printDayOfWeek(new Random().nextInt(3));
    var r1 = r.printDayOfWeekSwitchExpression(new Random().nextInt(6));
    System.out.println("" + r1);
    SOME_LABEL: if (r1 > 0)
       ANOTHER_LABEL: {
          System.out.println("aaaaaa");
    }
    int[] a = null;
    System.out.println(findItem(new int[]{1,2,3}, 99));
  }
  

  final static int[] findItem(int[] items, int v) {
    for (int i : items) {
      if (i == v) {
        int[] res = new int[]{i,v};
        return res;
      }
    }
    return null;
  }

  final void printDayOfWeek(int day) {
    day++;
    switch (--day) {
      case 0:
        System.out.println("domingo");
        //break;
      case 1: case 2:
        System.out.println("segunda ou terca");
      default:
        System.out.println("dia invalido!");
    }

  }
  
  final int printDayOfWeekSwitchExpression(int someVariable) {
    var valueToAdd = someVariable <= 2 ? 2 : 0; 
    //someVariable = someVariable <= 2 ? (someVariable += 20+2) : (someVariable += 20);
    System.out.println(valueToAdd);
    System.out.println(someVariable);
    return switch ((someVariable += 20 + valueToAdd)) {
      case 22 -> 5; // ";" required
      case 23, 24 -> {   
        yield 6; // yield required in case of return
      }
      //case 99 -> System.out.println("ah"); this wont work, cannot mix return types (void in this case)
      default -> 0; // default is required, not all cases is covered
    };
  } 
}

