# OCP 17


# Basics

- JRE = java 8 and earlier, just for running
- javac = converts .java into .class bytecode (compile)
- java = 
- jar = 
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

# Jars

- creating jar: jar -cvf someJar.jar . "-cvf" stands for --create --verbose --file
- specify the directory: jar -cvf someJar.jar -C target_dir .

# Conventions

- declaration order:
  1. package
  2. imports after package
  3. public class
  4. fields inside classes
  5. methods inside classes
- PIC = package, import, class

# Garbage collector (GC)

- All java object are stored in `heap memory` or free store
- Object eligible for GC doesnt mean it will be immediately deleted by GC
- System.gc() do not guaranntee to GC run
- Object no longer available when:
  - no references pointing to it
  - references are out of scope


Memory HEAP ( SomeObject, AnotherObject )

SomeObject reference = new SomeObject();
variable is just a reference


# General knowledge

> Size of boolean? depends on JVM implementation

- `identifier`: name of variable

> Legal, valid, compiles are synonyms in java exam

> 1 and 0 in java ARE NOT RELATED TO boolean in any way!

> Floor value drops de decimal poins, different than round! floor of 4.0, 4.5, 4.9999 results in 4!

> without L in literal, java will treat like int. Ex: `long value = 12223313232323; //compiler error` 

> Remember, for literal float, aways use "F"/"f", or it will be considerated a double.

> Assign a LARGER value to a smaller data type will result in compiler error without casting explicity. Casting is optional when small to large. `int fur = (int)5`

# LAST PAGE: 83
