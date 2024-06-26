# Java 17 Basics

- JRE = java 8 and earlier, just for running
- javac = converts .java into .class bytecode (compile)
- javadoc = starts with = /** . javadoc reads these comments
- java APIS = suite of utils, like StringBuilder, Collections, etc
- _preview features_ = off by default, but can enable
- object = runtime instance
- methods = functions or producers
- variables = fields
- multiline comment = /**/
- statements = import, for, if, etc => instruction

## Keywords

- var: can be used as method name
- case, new, this, var

- final
  - constant, cannot reassign value
  - final String[] names = new String[]{"rafael", "yasmin"}; nomes = null; // error!

## Classes

### public class

- if u have a `public` type in a file, the filename MUST match the class name
- U can have more than one class in a file, but only one class can be `public`
- U can access `ClasseLocal` and `ClasseLocal2` within the same package

```java
class ClasseLocal { // valid
}

class ClasseLocal2 { // valid
  
}

public class MainClass {
  public static void main(String[] args) {
    
  }
}

public class MainClass2 { // not valid
}
```

## Main

```java
public static void main(String[] args) { // main method, jvm looks for this method
  System.out.println("Hello!");
}
```

```java
public static void main(String args[]) { // main method, valid
  System.out.println("Hello!");
}
```

```java
public static void main(String... args) { // main method, valid
  System.out.println("Hello!");
}
```

## Access modifier

- public = access to everyone

## Void return type

- Usage: Good practice for when u change the object by reference/state

## packages and imports

> No package name, default package!

- imports included by default (implied imports):
  - java.lang.* is imported by default, it includes useful classes like System
  - classes within the same package

- begins java <- comes from JDK
- br.com.rafaelino => package => br.com.rafaelino.main => child package

- wildcards = * 
  - import all classes under the package, does not work recursively (like import class from a distant package, two dots away)
  - ex: import java.util.* doesn't import AtormicInteger, because its on java.util. concurrent atomic.*
  - wildcards does not slow down the program
  - doesn't work to import methods, like `import java.lang.System.*`

- by having different packages, u can have more than one class with same name
  - ex: `java.sql.Date` and `java.util.Date`
  - compile error: `import java.sql.*; import java.util.*`, both have Date class
  - compile error: `import java.sql.Date; import java.util.Date`, both have Date class
  - works: `import java.sql.Date; import java.util.*`, explicitly has procedence
  - Can use the fully qualified class name, like:

```java
public class LocalTest {
  public static void main(String[] args) {
    java.util.Date data = new java.util.Date(); // fully qualified name
    System.out.println(data.toString());
  }
}
```

- commands:
  - javac -d <DIRECTORY> packagea/... packageb/... etc => will create <DIRECTORY> with files.class inside, instead of creating in the package
  - To run: java -cp <DIRECTORY> packagemain.MainClass
  - To run: java -classpath <DIRECTORY> packagemain.MainClass
  - To run: java -class-path <DIRECTORY> packagemain.MainClass
  - including jars: java -cp ".;/home/dir;/home/somejar.jar" package.MainClass
  - include all jars in dir: java -cp "/home/somedir/directoryWithJars/*" packagemain.MainClass
  - :warning: the "/*" wild card for jars doesnt include child dirs


java packageexampleb/ClassB.java packageexamplea/ClassA.java
javac -d examplepackage1 packageexampleb/ClassB.java packageexamplea/ClassA.java

java packageexampleb/ClassB.java packageexamplea/ClassA.java
> to run ClassB.java without compiling, classA must be compiled before! (have ClassA.class)

## Objects

- All classes inherit Object by default
- Methods in Object:
  - String toString();
  - boolean equals(Object);
  - int hashCode();
- Declaring a method with signature `int toString()` wont compile, abstract or not

## Constructors

```java
public class ClassA {
 public ClassA() {
    System.out.println("construct classAAAA");
 }   
 public void ClassA() {
    System.out.println("not a constructor, just a method");
 }
}
```

- order for instance:
  1. fields and instance initializer (by order in file)
  2. constructor

> Remember, order matter for blocks of code, u cannot reffer to a field from instance initializer that has not been created yet.

## Data types

> for number, always consider its size with negative and positive. Ex: 8bit = 256, -128 to 127 (including 0)

- Primitive Types:
  - single value in memory, is not an object
  - byte, short, int, long = integer values (starts from 8bit until 64bit [double size each time]) / use l|L for long, otherwise, java will consider as int
  - float, double = float values [double size each time] / use f|F for float, otherwise java will consider as double
  - char = unicode value / 256 size, no negative


- long someBigInt = 1_________0; // valid

- Object types wrapper classes
  - Boolean / booleanValue()
  - Byte, Short, Integer, Long, Float, Double (inherits from Number)
  - Character / charValue() 
  - Number abstract: byteValue(), shortValue(), intValue(), longValue(), floatValue(), doubleValue. (returns primitive)
  - max(int num1, int num2), min(int num1, int num2), sun(int num1, int num2)

- Scape characters:
  - \n = regular string = " , text block = "
  - \""" = regular string = invalid , text block = """
  - \"\"\" = regular string = """ , text block = """
  - Space at the end of line = regular string = Space, text block = ignored
  - \s = regular string = two spaces , text block = two spaces
  - \ end of line = regular string = invalid , text block = omit new line
- text blocks

```java
String somestring = """ some text """; // does not compile, breakline mandatory
String anotherstrng = """
some other text"""; // compile
```

## Variable (or identifiers)

- rules:
  - Identifiers: letters, currency symbols ($,¥,€) or underscore (only at the beginning).
  - cannot start with numbers!
  - reserved words: const, goto, native, volatile, transient, strictfp
  - Passing a non-instantiated variable to a method also results in a compilation error

```java
public boolean checkValue(double $) {
  boolean result;
  if ($ > 1222222.31) {
    result = true;
  }
  return result; // compilation error, no default value for result!
}
public void anotherMethod() {
  double notInstantiatedVar;
  checkValue(notInstanciatedVar); // compilation error
}
```

```java
double $ = 120.00; // compile!
double ¥AnotherValue = 1500.123; // also compile!!
```

- multiple initializing
  - String s1, s2;
  - String s3 = "ah", s4 = "bbb"; // must be same type
  - String s1, s2, s3 = "smassa"; // only last one has been initialized
  - double value1, double value2; // not legal, only 1 type per statement

## Instance variable (or field)

- class variable = static field
- instance variable = normal field
- auto initialization (null for object, zero for numeric values and false for boolean)

## Local variable type inference (`var`)

- infers the type on compilation time, cannot change the type after initialization
- infers in single line / statement
- cannot be initialized with `null` but can receive `null` after initialization
- `var` can be used for class name, package and method
- var nome1 = "rafael", nome2 = "yasmin"; // not valid
- var num1 = Long.parseLong("100"); // returns primitive
- var num2 = Long.valueOf("100"); // returns Long object

## Methods

## Scopes

- each variable declare in a scope ({}), cannot be used in outer scope

## Operators

- Operands = variables used
- Operator = +, -, *, =
- Operators:
  - Unary 1: !a, ~b, +c, -d, +=e, casting, etc
  - Binary 2
  - Ternary 3

- If same level of precedence, such as `2 * someVariable - 2 * anotherVariable`, java evaluates from left to right.
- Parentheses override the precedence

- post-unary operator: expression++ / expression--
- pre-unary operator: ++expression, --expression
- shift operators: `>>`, `<<`, `>>>`
- Logical AND: &
- Logical exclusive OR: ^
- Logical inclusive OR: |
- ternary: boolean expression? return this: or this;
- assignment operators: =, +=, -=, *=, /=, %=, &=, ^=, |=, <<=, >>=, >>>=
- binary arithmetic operator: +, -, *, /, % 

### Bitwise complement

- inverts zeros and ones from integers (including short, long, etc)
- ex: int value = 3; // 0011, int complement = ~value; // 1100 (equals to -4)
- -1*value-1 to find the bitwise complement

### Negation operator

- reverses the sign of a numeric expression
- ex: `double something = 2.24; double something2 = -something; // -2.24`

### Increment / Decrement operators

- Pre-increment: ++someVar, --someVar (apply minus or plus AND return new value)
- Post-increment: someVar++, someVar++ (apply minus or plus AND return old value)
- ex:

```java
public class Teste {
  public static void main(String... args) {
    int someVar = 1;
    System.out.println(someVar); // print 1
    System.out.println(++someVar); // print 2
    System.out.println(someVar); // print 2
    System.out.println(someVar--); // print 2
    System.out.println(someVar); // print 1
  }
}
```

### Arithmetic Operators

- includes increment/decrement operators
- Modulus (remainder) = returns the remainder of the division
  - integer modulus results in floor value

### Rules for Numeric promotion

- Larger is promoted
  - ex: short vs long, long will prevail
- Floating point is promoted
  - ex: double vs long, double will prevail
- byte, short and char to int
  - promoted to int if binary arithmetic operator (+, -, %, etc)
- All operands will end with the same type
  - the data type of the result will be the promoted operands

## Casting

- Smaller to larger is required, throws error if u do not cast
- Larger to smaller is optional
- Casting is always on the left side `long value = (long) someInt;`

- overflow: number is too large to fit
- underflow: number too low, like -200 in byte field

```java
short ten = 10; // <- in theory, 10 is a literal int, but literals works naturally for smaller types (byte, short)
short three = 3;
short magicResult = ten * three; // int doesnt fit in short!
short magicResult2 = 10 * 3; // compile! literals does compile!
short magicResult3 = ten * 10; // does not compile!
```

## Compound assignment operators

- +=, -=, *=, /=
- automatically cast the value for the left-side variable type

```java
short ten = 10; 
int three = 3;
ten = ten * three; // does not compile, trying to fit int into short!
ten *= three; // compile, compound operator automatically cast!
```

## Assignment with return value

- example: `float someFloat = 2; double someDouble = (someFloat=3.1L);`
- example2: `boolean value = false; if (value = true) {System.out.println("will be printed")};`

## Comparing Operators

- cannot compare different types, like: true ==3, false != "string"
- References are equals only if pointing to same object. like:

```java
{
    var test1 = new File("someFile.txt"); 
    var test2 = new File("someFile.txt");
    var test3 = test1;
    System.out.println(test1 == test2); // false
    System.out.println(test1 == test3); // true
    System.out.println(null == null); // true
}
```

- instanceof Object => compare class, interface, record, enum, annotation
- instanceof CANNOT COMPILE in case of incompatible types, like `(number = Long.valueOf(1)) instanceof String`
- comparing with instanceof with null always results in false, event if the reference is `null`
- cannot use null in the right side of instanceof, even for references
  - {null instanceof null // does not compile}

## Logical operators

- & AND (check both sides of expression)
- | OR inclusive
- ^ OR exclusive (only if operands are idifferent, true ^ false = true, false ^ false = false)

```java
int age = 18;
boolean isAdult = (age <= 18) || (--age <= 18); // --age wont happen, only if use "|"
```

## Conditional operators (short-circuit operators)

- && AND (if left is false, the rest will not be evaluated)
- || OR (if the left side is true, the rest will not be evaluated)

## Control flow / Decisions / If else for

- if statement:
  - only if boolean extression evaluates to true
  - without brances, only the next statement will be executed within the if
    - ex: `if (isAccountSuspended) blockMoney(); log.info("something")` something will be always logged
  - `int someInfo = 1; if(someInfo) {}` this code wont compile, only boolean expressions

### Pattern variable

- avoid boilerplate code

```java
public class Main {
  public static void main(String... args) {
   Number number = 5;
   checkIfInt(number);
   }

  void checkIfInt(Number number) {
    if (number instanceof Integer) {
        System.out.println("is integer!");
        Integer data = (Integer) number; // will compile
    }
  }

  // pattern variable
  void checkIfIntShortSintax(Number number) {
    //if (number instanceof final Integer data) { can be final 
    //if (number instanceof final Integer data && data.compareTo(12)>5) { can be used in sequence  

    if (number instanceof Integer data) { // will cast to Integer and assign data
        System.out.println("is integer!");
    }
  }

}
```


> pattern variable aplies :warning: ONLY to subtype. `Integer value=11;if(value instanceof Integer data);` <- will not compile

> Becareful with flow scaping :warning: 
> `if(number instanceof Integer data || data.compareTo(1)<0);`
> <- this code wont compile, because the OR will try to evaluate the data.compare, the compile cannot guaranntee the type

### Switch statement

- if not default provided and not case match, nothing will happen
- if no `break;` provided, the entiry switch will be executed from first match until reachs a break, including default
- int, byte, short, char, String, enum and vars of previous types are valid. Respectives objects are also valid;
  - boolean, float, double arent permited in switch
- switch accepts :warning: literal, enum constants or final constants variables of same type
- Case options are only valid if: :warning: final + literal, enum or literal 

```java
final int b = 22;
int f = 22;
switch (b) {
    case f: // does not compile! only if final
    case 7*8: // will compile! literal is known by the compiler
}
```

```java
void printDayOfWeek(int day) {
  switch (day) { // parentheses is mandatory
    case 0:
       System.out.println("domingo");
    break;
    
    case 1, 2: 
       // case 1: 2: System.out.println("something") will not compile, "," necessary
       // case 1: case 2: .... will compile
       System.out.println("segunda ou terca");

    } // braces mandatory

  switch (day) {} // this is valid

```

### Switch case expressions (java 14)

- avoid boilerplate from classic switch statements
- Can return a value OR not
- Cannot mix return void and return some value and type.
- default case is required if not all cases covered OR no value is returned
  - for enum, covering all cases doesnt required a default case
  - if u add a new enum, the switch case without a default case will failt to compile
- returned data must be consistent in size, can return a short to a int, because it fits

```java
int someVariable = 21;
// return assignment is optional
int result = switch (someVariable) {
  case 22 -> 5; // ";" required
  case 23, 24 -> {
    yield 6; // yield required in case of block of code
  }
  default -> 0;
}; // semicolumn at the end is mandatory
```

### Loops (while, do/while, for, enhanced for (for each))

- while
  - while (booleanExpression) {} <- structure
  - braces are optional for a sinle statement
- do/while
  - at least once executed
  - `int someInt = 0; do someInt; while (someInt <10);` <- this is valid!
- for loop (classic)
  - for (initialization; booleanExpression, update) {} <- structure
  - braces are for single statement
- enhanced for
  - for (dataType instance : collection) {} <- structure
  - braces are optional for a single statement
  - for (; ;) {sout("111")} <- it does compile!
  - for () {} <- doent compile :/
  - :warning: works with: java array, implements java.lang.Iterable

- adding multiple terms is valid in for loops.
  - e.g. for (int y=1, z=4; y < 7 && z != 99; y++) {}

### Labels (if, switch, loops)

- labels are used to mark some statement
- SNAKE_CASE
- e.g. OUTER_LOOP: for(int[] somearray: matrixArray) { INNER_LOOP: for(int i=0...)}
- e.g. 2 SOME_IF: if(someInt > 10) SOME_BLOCK: {someInt++;}
- u can use `break` in labels, like: `break OUTER_LOOP;`
- :warning: without the label (optional), `break` will end the closest loop

### Continue statment

- can be used with labels aswell
- `continue SOME_LABEL;`
- continue goes to the nearest boolean expression, unless u use labels

## Jars

- creating jar: jar -cvf someJar.jar . "-cvf" stands for --create --verbose --file
- specify the directory: jar -cvf someJar.jar -C target_dir .

## Conventions

- declaration order:
  1. package
  2. imports after package
  3. public class
  4. fields inside classes
  5. methods inside classes
- PIC = package, import, class

## Garbage collector (GC)

- All java object are stored in `heap memory` or free store
- Object eligible for GC doesnt mean it will be immediately deleted by GC
- System.gc() do not guaranntee to GC run
- Object no longer available when:
  - no references pointing to it
  - references are out of scope

Memory HEAP ( SomeObject, AnotherObject )

SomeObject reference = new SomeObject();
variable is just a reference

## General knowledge

> Size of boolean? depends on JVM implementation

- `identifier`: name of variable

> Legal, valid, compiles are synonyms in java exam

> 1 and 0 in java ARE NOT RELATED TO boolean in any way!

> Floor value drops de decimal poins, different than round! floor of 4.0, 4.5, 4.9999 results in 4!

> without L in literal, java will treat like int. Ex: `long value = 12223313232323; //compiler error` 

> Remember, for literal float, aways use "F"/"f", or it will be considerated a double.

> Assign a LARGER value to a smaller data type will result in compiler error without casting explicity. Casting is optional when small to large. `int fur = (int)5`

> System.out.print() // call Object.toString under the hood

> U can assign integer value into floting value.


> char[] charArray = new char[]{'a'}; for (int x : charArray) System.out.println(x); this is valid,
> because char can be cast to int, float and double

> char++ goes the the nest letter in alphabet. `char k = 'a'; a++; // result == 'b'`


> classic arrays, like int[] can receive null

> :warning: code after continue, break and return will not compile, even with with LABELs. Reason: unreacheble code

> :warning: switch cannot be float, double or boolean

