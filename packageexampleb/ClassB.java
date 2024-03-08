package packageexampleb;

import packageexamplea.ClassA;

public class ClassB {

    int numberEggs;

    public ClassB() {
        System.out.println("constructor");
    }

    public static void main(String... args) {
        ClassA a = new ClassA();
        a.ClassA(); // not a constructor!!!
        System.out.println("Hello!");

        { // not a instance initializer, just a code block
            System.out.println("hello2!");
        }

        ClassB b = new ClassB();

        long someBigInt = 1______________________0L;
        System.out.println(someBigInt);
        
        double $ = 120.00; // compile!
        double ¥AnotherValue = 1500.123; // also compile!!

        // System.out.println("check: " + b.checkValue($));

        System.out.println("" + $ + "/" + ¥AnotherValue);

        // final String[] nomes = new String[]{"rafael", "yasmin"};
        // nomes = null;
    }

    {// instance initializer. Only works when u create a new instance of this class
        System.out.println("instance initializer");
    }

    // public boolean checkValue(double $) {
    //     boolean result;
    //     if ($ > 1222222.31) {
    //         result = true;
    //     }
    //     return result; // compilation error, no default value for result!
    // }
}

