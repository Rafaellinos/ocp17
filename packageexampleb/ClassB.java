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
        
    }

    {// instance initializer. Only works when u create a new instance of this class
        System.out.println("instance initializer");
    }
}

