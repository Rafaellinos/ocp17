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


### For static reference vs Instance reference

- java treats static and instance reference differently.
- e.g.: `String::toUpperCase` will work, but `someStrIntance::toUpperCase` will not
    - The first case does compile, because it matches the signature: void doSomethindWithString(Sring), receives method reference for string
    - The last case doesnt compile, does not specifies the target object like `String`




```java
@FunctionalInterface
public interface SomeInterface {
    void doSomethindWithString(String string);
}

{
    SomeInterface a = System.out::println; 
    // valid, java knows by the context that the println has the same signature
    a.doSomethindWithString("somestr"); // will print "somestr"
}

{
    import java.lang.Math;

    SomeInterface b = Math::max; // not compile, 2 args number
    SomeInterface c = String::toUpperCase; // will compile, but does not return
    
    var someStr = "I";
    
    SomeInterface d = someStr::toUpperCase; 
    // does not compile, toUpperCase has two overloads: String toUpperCase() and String toUpperCase(Locale)
    // the interface expects a method reference that receives a string.

    SomeInterface e = someStr::endsWith; // compile
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
