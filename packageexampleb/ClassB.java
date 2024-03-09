package packageexampleb;

import packageexamplea.ClassA;

public class ClassB {

    int numberEggs;

    String name;

    boolean isLucky;

    Boolean isLucky2;

    public ClassB() {
        System.out.println("constructor");
        this.numberEggs = 22;
    }

    public void printDefaultValue() {
        System.out.println("default value for numberEggs: " + numberEggs);
        System.out.println("default value for name: " + name);
        System.out.println("default value for isLucky: " + isLucky);
        System.out.println("default value for isLucky2: " + isLucky2);
    }

    public static void main(String... args) {
        ClassA a = new ClassA();
        a.ClassA(); // not a constructor!!!
        System.out.println("Hello!");

        { // not a instance initializer, just a code block
            System.out.println("hello2!");
        }

        ClassB b = new ClassB();

        b.printDefaultValue();

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
        System.out.println("instance initializer" + this.numberEggs);
        var name2 = "jonh";
    }

    // public boolean checkValue(double $) {
    //     boolean result;
    //     if ($ > 1222222.31) {
    //         result = true;
    //     }
    //     return result; // compilation error, no default value for result!
    // }
}

