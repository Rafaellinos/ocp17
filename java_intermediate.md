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
- Valid methods/functions in SAM
  - default, private, static, private static

- Valid lambdas
  - `(RecordAnimal a) -> {return a.isMale();}`
    - `a -> {return a.isMale();}`
    - `(RecordAnimal a) -> a.isMale()`
    - `s -> {}` this is valid if interface returns void
    - `() -> true` this is valid if interface has no parameters
    - `(String x, String y) -> x == y`
    - `Predicate<String> toTest = p -> true`
    - `Predicate<String> toTest = (var p) -> true`
    - `Predicate<String> toTest = (String p) -> true`
    - `BinaryOperator<Integer> sortFunc = (final var x, @Deprecated var y) -> x.compareTo(y);`
- Invalid lambdas
  - To be valid: Without types, With types OR with var. Must be only one of these 3
    - `(var x, y) -> "hello"` must specify for x and y or none
    - `(var x, Integer y) -> x+y` cannot mix types
    - `(String x, var y, Interger z) -> true` mixed types
    - `(Integer x, y) -> "Darth Valdir"` mixed types, wont compile

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

## Functional interfaces

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
    - default methods:
    - andThen(Consumer<T>)
- Predicate<T>
  - boolean test(T) :warning: returns a boolean primitive and not object
    - filter, test, or match some generic type.
    - e.g.: `Predicate<Animal> isTigger = a -> a.getName().equals("Tigger");`
    - e.g.2: `BiPredicate<Animal, Animal> sameAnime = (a1, a2) -> a1.getName().equals(a2.getName());`
    - default methods:
      - and(Predicate<T>)
        - negate(void)
        - or(Predicate<T>)
- Function<T, R>
  - R apply(T)
    - anonymous functions
    - e.g.: `Function<Person, Document> getFormattedDocu = p -> DocumentUtils.format(p.getDocument());`
    - default methods:
      - andThen(Function<T, R>) // after
        - compose(Function<T, R>) // before
- UnarityOperator<T>
  - T apply(T)

## Functional Interfaces for primities

> most for int, long and double

- booleanSupplier.getAsBoolean (Returns primitive boolean)
- DoubleSupplier getAsDouble
- IntSupplier getAsInt
- LongSupplier getAsLong

- DoubleConsumer . accept
- IntConsumer
- LongConsumer

- DoublePredicate . test
- IntPredicate
- LongPredicate

- DoubleFunction<R> . apply
- IntFunction<R>
- LongFunction

- DoubleUnaryOperator . applyAsDouble
- IntUnaryOperator . applyAsInt
- LongBinaryOperator . applyAsLong

## Functional interfaces for converting (specific)

> Most for int, long and double

- ToDoubleFunction<T> applyAsDouble
  - e.g. `ToDoubleFunction<String> makeDouble = Double::valueOf; makeDouble.applyAsDouble("123");`
- ToIntFunction<T>
- ToLongFunction<T

- DoubleToIntFunction applyAsInt
- DoubleToLongFunction applyAsLong
- IntToDoubleFunction
- IntToLongFunction
- LongToDoubleFunction applyAsDouble
- LongToIntFunction

> BuiltIns$$ (the $$ means that this class exists only in memory)

## Variables allowed in lambda scope

- instance variable
- static variable
- local variable (only if final or effectively final [no reasignment] )
- method parameter (only if final or effectively final [no reasignment])
- lambda parameter

```java
// be aware, even if the reasignment happens AFTER, i still wont compile
public class Main {

    public static void main(String... args) {
        
        String name = "Jonh";

        Predicate<String> checkName = n -> {
            return name.equalsIgnoreCase(n);
        };
        name = "rafael"; // wont compile, name is not final or effectively final 

    }

}
```

# Collections and generics

> Java collections framework, java.util

- List
  - Allow duplicates, index, ordered
    - Implementation
      - ArrayList (Best choice for unknown scenarios)
        - good for reading, not so good for adding/removing
      - LinkedList (Implements List and Deque)
        - Constant (O1) for add/remove
        - Linear time to read, no indexes (To find something, must search one by one)
  - Specific Methods:
    - `Arrays.asList(varargs);` Fixed size
    - `List.of(varargs);` immutable list
    - `List.copyOf(collection);` immutable copy (shallow copy)
    - :warning: All the example above will produce error if try to add/remove
  - Specific Construtors:
    - `new ArrayList<String>(2);` create a list of 2 slots

- Set
  - No duplicates
    - Implementation
      - Hashset
      - TreeSet

- Queue
  - processing order.
  - Deque subinterface allow access both ends
  - Implementation
    - Deque, LinkedList
- Map (Do not implement Collection interface, but still in collections framework)
  - key, value
  - do not allow duplicate keys

- Collection constructors
  - `new ArrayList<String>();` empty collection
  - `new ArrayList<String>(anotherList);` passing another subtype of collection


- Collection interface methods:
  - boolean add(E element)
        - set.add("one"); // true set.add("one"); false
  - boolean remove(Object object)
    - `someList.remove("<NONE_EXISTING_ITEM>"); //false`
  - boolean isEmpty()
  - int size()
  - void clear()
    - discart all elements in the collection
  - boolean contains(Object object)
    - someList.contains("<NONE_EXISTING_ITEM>"); false
  - boolean removeIf(Predicate<? super E> filter)
    - expects a lambda/Implementation to filter
    - e.g.: `list.removeIf(s -> s.startsWith("A"));`
    - e.g.2: `list.removeIf(String::isEmpty);`

- iterating over Collection:
  - expects: `public void forEach(Consumer<? super T> action)`
  - e.g.: `cats.forEach(System.out::println);`
  - e.g.2: `cats.forEach(c -> System.out.println(c));`
  - Other usages:
    - for-enhanced `for (String element: Collection) print(element);`
    - iterator `Iterator<String> iter = someIter.iterator(); while (iter.hasNext()) {print(iter.next());}`

- Comparting Collections:
  - ArrayList: :warning: checks elements AND order equals
  - HashSet: :warning: Does not check order, only if contains same value

- Diamont operator <>
  - Right side can be omited (inferred)

- Comparator
- Comparable

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

> `var h = new ArrayList<Interger>(); h.add(null); int h1 = h.get(0); // NullPointerException!`

> `var l = new ArrayList<>();` this is valid! produce an ArrayList<Object>
