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
  - writing: `Box<Magazine> boxOfMagazine = new Box<Magazine>; Magazine m = boxOfMagazine.getThing();`
  - compiled: `Magazine m = (Magazine) boxOfMagazine.getThing();`

Because java transform generics into Objects, overloading is not possible, since the method will contain the same signature.

```java
public class Packageable {
    public void addToPackage(Box<Magazine> boxOfMagazine) {}
    public void addToPackage(Box<List<Magazine>> boxWithLotsOfMagazines) {} // not compile
}
```

Generic type is dropped at compilation time, then both of these methods became:
`public void addToPackage(Box input){}`

> If `Box` is replaced by any subtype in one method, the class will compile, because the signature will be differente from each other. E.g.: `addToPacakge(Box b)` and `addToPackage(SmallBox sb)`
