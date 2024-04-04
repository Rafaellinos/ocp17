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

- Can be use to make a reference to a method that has the same type of parameters
    - AND u cannot pass arguments to it


### Types of method references

> Consider the example bellow

```java
@FunctionalInterface
public interface SomeInterface {
    void doSomethindWithString(String string);
}
```

- static method
    - `String::valueOf` <- valueOf ia a static method
- Instance methods on a particular object
    - `someStrInstance::startsWith` <- same as `someStrInstance = "a"; SomeInterface si = s -> someStrInstance.startsWith(s);`
- Instance methods on a parameter to be determined at runtime
    - `String::toUpperCase` <- toUpperCase will be applied in the String
    - `toUpperCase` is a instance method, but the String in the left side indicates the parameter match
    - parameter match: String::toUpperCase <- String -> void doSomethindWithString(String str)
    - :warning: can use to combine arguments, being the first the parameter and the second, the instance to be checked.
        - e.g.: `interface StringChecker { boolean check(String text, String prefix)};`
        - ... : `StringChecker a = String::startsWith; a.check("rafael", "a"); // returns true`
- Constructurs
    - use `new` keyword combined with class name to create a new object.
    - e.g.: `String::new;`

| Type                         | Left Side  | right side           | example            |
| ---------------------------- | ---------- | -------------------- | ------------------ |
| static method                | Class name | Static method name   | String::valueOf    |
| instance method for object   | instance   | instance method name | String::startsWith |
| instance method as parameter | class name | instance method name | String::isEmpty    |
| Constructor                  | Class name | new keyword          | String::new        |


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
    SomeInterface c = String::toUpperCase; 
        // will compile, but does not return anything. Using method reference as parameter
    
    var someStr = "I";
    
    SomeInterface d = someStr::toUpperCase; 
    // does not compile, toUpperCase has two overloads: String toUpperCase() and String toUpperCase(Locale)
    // none of these will work, these methods expect Locale OR no params.
    // will be treaded as 'instance method for object'

    SomeInterface e = someStr::endsWith; // compile. same as: s -> somestr.endsWith(s);
}
```

### Functional interfaces

- Supplier<T>
    - T get()
    - useful for getting some value without parameters, often getting something from the local scope
    - e.g.: `Supplier<Person> getPersonFullName = p -> p.getFirstName()+p.getLastName();`
    - :warning: `BiSupllier` does not exist
- Consumer<T>
    - void accept(T)
    - do something with the generic parameter and not return. Changing a method by reference for exemple.
    - e.g.: `BiConsumer<String, Object> wrapperPut = (s, o) -> map.put(s,o);`
    - e.g.2: `Consumer<String> print = System.out::println;`
- Predicate<T>
    - boolean test(T)
    - filter, test, or match some generic type.
    - e.g.: `Predicate<Animal> isTigger = a -> a.getName().equals("Tigger");`
    - e.g.2: `BiPredicate<Animal, Animal> sameAnime = (a1, a2) -> a1.getName().equals(a2.getName());`
- Function<T, R>
    - R apply(T)
    - anonymous functions
    - e.g.:
- UnarityOperator<T>
    - T apply(T)


> BuiltIns$$ (the $$ means that this class exists only in memory)


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
