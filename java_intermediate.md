# Java intermediate topics

- TODO skiped topics: Core Apis, Methods, Class Design, Beyond classes

# Lambda (or clojures)

- like anonymous classes and method
- interfaces with exacly one abstract method
- Parentheses are optional only if theres ONLY one parameter AND no type declared
- U can `extends` the functional interface and still considerated SAM, but if u add another abstract method... not SAM
    - `default` method + abstract method = valid SAM
    - `static` methods + abstract method = valid SAM
    - `extends` from a SAM & not add another instance method = valid SAM
    - only `default` method in interface = not valid SAM
    - :warning: methods that inherits from `Object` = not valid SAM
        - methods like: toString(), equals() and hashCode()

- Valid lambdas
    - `(RecordAnimal a) -> {return a.isMale();}`
    - `a -> {return a.isMale();}`
    - `(RecordAnimal a) -> a.isMale()`
    - `s -> {}` this is valid if interface returns void
    - `() -> true` this is valid if interface has no parameters
    - `(String x, String y) -> x == y`

- @FunctionalInterface
    - The annotation does not compile with more than one abstract method



> Single Abstract Method (SAM) @FunctionalInterface

> :warning: `var i = (RecordAnimal a) -> a.isMale();` Does not compile! cannot determine the type


## Method reference 

- ::
- e.g.: 
    - `SomeFuncInterface sfi = System.out::println;` 
    - instead of:
    - `SomeFuncInterface sfi = s -> System.out.println(s);`
- same as lambdas in runtime
- formats:
    - static methods
    - instance methods (object or to be determined)
    - Constructors

- Can be use to make a reference to a method that has the same type of return AND parameters

```java
public interface SomeInterface {
    void doSomethindWithString(String string);
}

{
    SomeInterface a = System.out::println; 
    // valid, java knows by the context that the println has the same signature
}
```

# Streams


# Exceptions

# I/O


# Important

```java
@Override
public boolean equals(int a, int b, String abc) {
    return true; // this is valid
}
```

```java
@Override
public int equals(Object a, Object b) {
    return false; // this is not valid, not campatile with Object.equals
}
```
