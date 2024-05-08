# Generics

```java
// using interface
public interface Serializer<T, R> {
    public R serialize(T dataToSerialize);
    public T deserialize(R dataToDeserialize);
}
```

```java
// using concrete class
public class Box<T> {

    private T thing;

    public T getThing() {
        return thing;
    }

    public void setThing(T thing) {
        this.thing = thing;
    }
}
```

## Type Erasure

- In compilation transform T in `Object` and adds casting.
- e.g.:
  - before: `Box<Magazine> boxOfMagazine = new Box<Magazine>; Magazine m = boxOfMagazine.getThing();`
  - after: `Magazine m = (Magazine) boxOfMagazine.getThing();`

Because java transform generics into Objects, overloading is not possible, since the method will contain the same signature.

```java
public class Packageable {
    public void addToPackage(Box<Magazine> boxOfMagazine) {}
    public void addToPackage(Box<List<Magazine>> boxWithLotsOfMagazines) {} // not compile
}
```

Generic types are dropped at compilation time, then both of these methods became:
`public void addToPackage(Box input){}`

> :warning: Even using inheritance (`extends`) the class will not compile

> If `List` is replaced by any subtype in a method, the class will compile, because the signature will be differente from each other.
> E.g.: `addListToPacakge(List<Box> b)` and `addListToPackage(ArrayList<Box> sb)`

## Generic types return

- The Generic type as a return must be an exact match when using inheritance.

e.g.:

```java
public class Truck {

    private List<Box> boxes = new ArrayList<>();
    
    public List<Box> getAllBoxes() {
        return boxes;
    }

    public void addBox(Box box) {
        this.boxes.add(box);
    }
}

class SmallTruck extends Truck {

    @Override
    public List<SmallBox> getAllBoxes() { 
        // does not compile!
        // Generic type must mach. Even SmallBox being subtype of box
        return boxes;
    }

}

class SpecialTruck extends Truck {
    @Override
    public ArrayList<Box> getAllBoxes() { 
        // Compile! generic type match
        return boxes;
    }
}
```
## Limitations

- Cannot call `new T()`, not allowed
- Create array of generic type
- call `instanceof`. `List<Integer>` and `List<String` look the same for java (`List`)
    - :warning: Remember, generics types are dropped
- use primitive as generic type.
- create `static` variable as a generic parameter
    - the type is related to the instance of a class

## Generics in methods level

- it's possible to declare generics at method only level, no need to declare in the class declartion

e.g.:

```java
public class SomeClass {
    //// <T> is the type, even though the return type is void
    public static <T> void doSomething(T t) {
       System.out.println("hello from " + t.toString()); 
    }
    public static <T> Box<T> getBox(T t) {
        System.out.println("boxing... " + t.toString());
        return new Box<T>();
    }
    // <T> type, T return type
    public static <T> T getThing(T t) {
        return t;
    }
}
```

```java
public class Main {

    public static void main(String... args) {
        SomeClass.<String[]>getThing(new String[5]); // this is valid
        // ClassReference.<Type> can be used
        // output:
        /*
            jshell> SomeClass.<String[]>get(new String[5])
            $4 ==> String[5] { null, null, null, null, null }
        */
    }
}
```

Pay atention on this example:

```java
public class TrickyBox<T> {
    public <T> T getTrickyThing(T t) {
        return t;
    }
    
    public static void main(String... args) {
        TrickyBox<String> tbox = new TrickyBox<>();
        var a = tbox.getTrickyThing(123);
        System.out.println(a); // 123
        System.out.println(a instanceof Number); // true
    }
}
```

In the example above, the type of the method became what is passed as a parameter (String) in `getTrickyThing`.

## Generics in Records

```java
public record RecordWithGenerics<T>(
    T someGenericField,
    String someStringField
) {
}
```

## Bounding Generic types

- wild card generic type represented by (`?`)
- Usages:
    - `List<?> a = new ArrayList<String>();`
    - `List<? extends Exception> a = new ArrayList<RuntimeException>();`
    - `List<? super Exception> a = new ArrayList<Object>();`

