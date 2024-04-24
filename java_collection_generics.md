# Collection framework

- TODO skiped topics: Core Apis, Methods, Class Design, Beyond classes

# To remember

- Some Topics to remember before reading the comments

## Big O

![big_oh_sheetsheet](/imgs/bigOsheetsheat.jpg)

![big_oh_time_complexity](/imgs/big_oh_time_complexity.jpg)

## Collection framework resume

![collection_framework_tree](/imgs/java_collection_framework.jpg)

# Collections

> Java collections framework, java.util

- Data structures basic
  - stack = LIFO = e.g.: pile of plates
  - queue = FIFO = e.g.: Queue to buy tickets to some concert
  - list = index based

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
    - `public void add(int index, E element)` add item and shift the rest to right (end)
    - `public E get(int index)` get item by index
    - `public E remove(int index)` removes the item and shift the rest to left (start)
      - :warning: this remove() overloads the Collection, which uses the element instead of the index
    - `public void replaceAlll(UnaryOperator<E> op)` applies UnaryOperator at each element and replace it
      - e.g.: `listOfNumbers.replaceAll(x -> x*2)`
    - `public E set(int index, E e)` replace item and return the original
    - `public void sort(Comparator<? super E> c)` sort the list based on comparator
    - `list.toArray`:
      - `list.toArray()` defaults to object, so the return will be -> Object[] even if the list is ArrayList<String>
      - `list.toArray(new String[0])` return String[] with the proper size by specifing zero (String[0])
        - if u specify a longer size, the other value will be String null
        - if u specify a smaller size, the parameter will be ignored and will the the specific size of the List
  - Specific Construtors:
    - `new ArrayList<String>(2);` create a list of 2 slots

- Set
  - No duplicates, no order, no GET (must iterate to get any value)
    - Implementation
      - Hashset (HashTable)
        - uses the hashCode() to retrieve
        - Constant (o1) to add
      - TreeSet (Tree data structure [root node, no cycle])
        - sorted tree structure (always sorted)
        - O(log n) for all operations
        - :warning: require implementation of `Comparable<T>` or u can pass `Comparator` as parameter
    - Specific methods:
      - `Set.of('a', 'b');` create an immutable set
      - `Set.copyOf(anotherSet);` returns an immutable shallow copy of the anotherSet

- Queue (FIFO)
  - Allow duplicates, order, must add/remove in specific order
  - processing order.
  - Deque subinterface allow access both ends
  - Implementation
    - Deque
    - LinkedList
  - Specific methods:
    - offer same as add
    - peek same as get
    - remove same as poll

- Deque (double-ended queue [can remove from head and tail])
  - Implementation
    - LinkedList
  - Specific methods:
    - offerFist(E e) = add to the head
    - offerLast(E e) = add to the tail
    - peekFist(E e) = get head item
    - peekLast(E e) = get tail item
    - pollFist(E e) = remove and get head
    - pollLast(E e) = remove and get tail

- Map <K, V> (Do not implement Collection interface, but still in collections framework)
  - Do not allow duplicate keys (allow for value)
  - key, value
  - Implementation
    - TreeMap
      - sorted tree structure (key sorted) like TreeSet
      - :warning: require implementation of `Comparable<T>` or u can pass `Comparator` as parameter
    - HashMap (no order)
      - Constant time for add/get
      - uses hashcode() for keys
  - Specific methods:
    - `Map.of("key1", "value1", "key2", "value2");`
    - `Map.ofEntries(Map.entry("key1", "value1"), Map.entry("key2", "value2"));` ideal
    - `Map.copyOf(map);`
    - `void clear()` remove all keys
    - `boolean containsKey(Object key)`
    - `boolean containsValue(Object Value)`
    - `Set<Map.Entry<K, V>> entrySet()` get `Set` of key value
    - `forEach(BiConsumer<K key, V value>)` to loop
    - `V get(Object key)` get value by key or returns null
    - `V getOrDefault(Object key, V defaultValue)`
    - `boolean isEmpty()`
    - `Set<K> keySet()` get all keys in a `Set`
    - `V merge(K key, V value, Function(<V, V, V> func))`
      - Sets the value based on the result of func
      - Sets the value if the value is null
    - `V put(K key, V value)`
    - `V putIfAbsent(K key, V value)` returns null if value not set
    - `V remove(Object key)`
    - `V replace(K key, V value)` return original value or null
    - `void replaceAll(BiFunction<K, V, V> func)` replace values based on the func return
      - e.g.: `map.replaceAll((k, v) -> k + v);` all value will result in k+v, but the key remains
    - `int size()`
    - `Collection<V> values()` iterable of values

- Collection constructors
  - `new ArrayList<String>();` empty collection
  - `new ArrayList<String>(anotherList);` passing another subtype of collection

- Collection interface methods:
  - boolean add(E element)
        - set.add("one"); // true set.add("one"); false
  - boolean remove(Object object)
    - `someList.remove("<NO_EXISTING_ITEM>"); //false`
  - boolean isEmpty()
  - int size()
  - void clear()
    - discart all elements in the collection
  - boolean contains(Object object)
    - `someList.contains("<NO_EXISTING_ITEM>"); //false`
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

## Collection Sort

- :warning: must implement `Comparable.compareTo` OR use `Comparator` as lambda
- `Collection.sort()` no return, changes object by reference
- `Collection.reverse()` also works

### Comparable (interface)

- Any object can implement it to sort the objects
- `interface Comparable<T> { int compareTo(T other);}`

```java
import java.util.*;

public class Person implements Comparable<Person> {

  private String name;
  private Integer age;

  // getters and setters ommited

  @Override
  public int compareTo(Person otherPerson) {
    return age.compareTo(otherPerson.getAge());
    // could be this.age - other.age
    // -1, 0, 1
    // less, equal, greater
    // e.g.: if this.age < other.age -> -1
  }

  public static void main(String... args) {
    List<Person> persons = new ArrayList<>();
    persons.add(new Person("Rafael", 33));
    persons.add(new Person("Yasmin", 25));
    System.out.println(persons); // [Rafael, Yasmin]
    Collections.sort(persons);
    System.out.println(persons); // [Yasmin, Rafael]
  }
}

```

### Comparator

- useful to sort a Collection of objects that do not implement `Comparable<T>` interface
- Can be used to compare a different attribute than the used in `compareTo()` from comparable interface

```java
import java.util.*;

// example of implementation with Comparable and Comparator
public Computer implements Comparable<Computer> {
  private int cpuCores;
  private int ramMemoryInGBs;

  public void setCpuCores(int cpuCores) {this.cpuCores = cpuCores};
  public void setRamMemoryinGBs(int ramMemoryInGBs) {this.ramMemoryInGBs = ramMemoryInGBs};
  public int getCpfuCores() {return this.cpuCores};
  public int getRamMemoryinGBs() {return this.ramMemoryInGBs};

  @Override
  public int compareTo(Computer otherComputer) {
    return this.cpuCores - otherComputer.getCpuCores();
  }

  public static void main(String... args) {
    var pc1 = new Computer();
    pc1.setRamMemoryInGBs(8);
    pc1.setCpuCores(4);
    
    var pc2 = new Computer();
    pc2.setRamMemoryInGBs(16);
    pc2.setCpuCores(2);

    List<Computer> listOfPcs = List.of(pc1, pc2);

    // custom comparator class
    Comparator<Computer> byRam = new Comparator<Computer>() {
      @Override
      public int compare(Computer pc1, Computer pc2) {
        return pc1.getRamMemoryInGBs() - pc2.getRamMemoryInGBs();
      }      
    };

    Collection.sort(listOfPcs); // [PC1(4), PC2(2)]
    Collection.sort(listOfPcs, byRam); // [PC2(16), PC1(8)] 
  }
}
```

- It is possible to implement `Comparator<T>` and implement `compare()` method

```java
// using chain of comparator to compore more fields
Comparator<Computer> pc = Comparator.comparing(Computer::getCpuCores)
  .thenComparingInt(Computer::getRamMemoryInGBs);
```

- `comparing(function)` -> uses any Object (or autoboxed into Object)
- `comparingDouble(function)`
- `comparingInt(function)`
- `comparingLong(function)`
- `natualOrder()` -> sort by Comparable implementation `compareTo()`
- `reverseOrder()` -> sort reversed by Comparable implementation `compareTo()`
- `Comparator.comparing(Person::getId).reversed()` reversed uses `reverseOrder(this)`
- `thenComparing(function)` -> continue the chain of comparison (if previous passed)
- `thenComparing*(function)` * = Double, Int and Long.

> :warning: Be careful, `.sort()` will no compile if the class does not implement `Comparable`. Use `Comparator` lambda instead

### Comparator vs Comparable

| Specification    | Comparable<T> | Comparator           |
|------------------|---------------|----------------------|
| package Location | java.lang     | java.util            |
| Must implement   | Yes           | No                   |
| method name      | compareTo()   | compare()            |
| parameters       | <T> other     | <T> obj1, <T> obj2   |
| lambda           | No            | Yes                  |

## Binary search

- required a sorted list
- Signature: `Collections.binarySearch(<Collection>, <ObjectToFind>)`
- Returns -1 if the result cannot be determined (not in the right order, descending or not sorted)
- 

## Notes

> in `compareTo()` method, handle `null` values to avoid `NullPointerExcetion`

> Maintain `compareTo()` consistent with `equals()` method. If `compareTo()` return 0, the `equals()` should do the same (remeber, 0 in string.compareTo means equality)

> String is sorted based on Unicode character mapping

> LinkedList implements both List and Deque

> Deque implements Queue

> If the Collection starts with `Hash`, it uses `hashCode()` method

> :warning: Rule of thumb -> Always consider `Tree*` as sorted/compareTo and `Hash*` that call hashcode

> :warning: `java.util.Comparator` vs `java.lang.Comparable` diff packs!

## Examples

### Lists

> `var h = new ArrayList<Interger>(); h.add(null); int h1 = h.get(0); // NullPointerException!`

> `var l = new ArrayList<>();` this is valid! produce an ArrayList<Object>

```java

public class Test {
    public static void main(String... args) {
        var lista = new ArrayList<Integer>();
        lista.add(3);
        lista.add(2);
        lista.add(1); // [3, 2, 1]
        lista.remove(2); // will remove by index, therefore item 1 -> [3, 2]
        lista.remove(Integer.valueOf(2)); // will move by Integer class, therefore item 2 -> [3]
        System.out.println(lista); // [3]
    }
}

```

### Maps

```java
import java.util.HashMap;
import java.util.Map;

// Map.merge example
public class MapExample {
  public static void main(String... args) {
    Map<String, Integer> someMap = new HashMap<>();
    someMap.put("nome", "Rafael");
    someMap.put("idade", "33");

    BiFunction<String, String, String> normalizeIfNoName = (originalValue, parameterValue) -> {
      return (originalValue != null && !originalValue.isEmpty()) ? originalValue : parameterValue; 
    };

    someMap.merge("nome", "N/A", normalizeIfNoName);

    System.out.println(someMap); // {nome=Rafael, idade=33}

    someMap.put("nome", null);

    someMap.merge("nome", "N/A", normalizeIfNoName);

    System.out.println(someMap); // {nome=N/A, idade=33}

  }
}
```

> Get hash code -> `animals.forEach(x -> System.out.println(x.hashCode()));`

