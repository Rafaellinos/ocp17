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
- statemants = import, for, if, etc => instruction

## Keyworks

- var: can be used as method name
- case, new, this, var

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

## access modifier

- public = access to everyone

## Void return type

- Usage: Good practice for when u change the object by reference/state


## packages and imports

- imports included by default (implicity imports):
  - java.lang.* is imported by default, it includes useful classes like System
  - classes within the same package

- begins java <- comes from JDK
- br.com.rafaelino => package => br.com.rafaelino.main => child package

- wildcards = * , import all classes under the package, does not work recursively (like import class from a distant package, two dots away)
  - ex: import java.util.* doesnt import AtormicInteger, because its on java.util.concurennt.atomic.*
- wildcards does not slow down the program