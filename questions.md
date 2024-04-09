# Questions

## chapter 1, bulding blocks

- V 1: D, E 
- V 2: C, E, D
- V 3: A, E, 
- V 4: B, G, E
- V 5: A, D, F
- V 6: F
- V 7: C, E
- X 8: B, D, H (B, D, H, E)
- X 9: A, E, (Only E)
- V 10: A, E, F
- X 11: D (E)
- V 12: A, C, D
- X 13: B, C, E? (A, B, C)
- X 14: A, B, D? (A, B, D, E)
- V 15: C, E, F
- X 16: A, D, F (A, D)
- X 17: A?, D, G (D, F, G)
- V 18: B, F, C
- X 19: A, D?, E? (A,D)
- X 20: C, F (C)
- V 21: D
- X 22: A, C, F, G (C,F,G)
- X 23: D, H (A,D)

8: Letter E is correct. Even though the 1/0 raise an ArithmeticException, which is a RuntimeException, that isnt raised on compilation time.

9: A is incorrect because float should have a decimal point

11: E. Remeber, classes in the same package do not need to be imported

13: A is correct because import package* look only at the specific folder. E is incorrect, cannot have same import class.

14: Primitives does not have methods, like .length or .length()

16: F is incorrect because identantion at the beginning is ignored, and considered accidental.

17: U can concatenate null with string

19: 
var num1 = Long.parseLong("100"); // returns primitive long
var num2 = Long.valueOf("100"); // returns Long object

20: 
long age = 1400; // this is valid! "L" is optional. Only required if the number exceeds the range of int
Only F or f is required in case of float literal, no for int literals.

22:
C, F, G.  
0b = binary value
0x = hexadecimal

Can be use to asign primitives, like int.

A is incorrect because Amount is not amount and will not compile in print statement.

23:
A, D.  

float temp = 50.0; "F" or "f" is required for float. Without "F", is a double and it not fit in float.


## chapter 2, Operators

- unary vs binary operators???

> U can return Intergers value to floating value. Like double receiving long.

- 66%

- V 1: A,D,G
- V 2: A,B,D
- X 3: B,C,F - B,C,D,F.
- V 4: B
- X 5: B, D, - A,C 
- V 6: F
- X 7: C - D
- V 8: A
- V 9: A, D, E
- V 10: G
- V 11: D   
- V 12: D 
- V 13: F 
- V 14: B, E, G   
- V 15: D, 
- X 16: C - B 
- X 17: G - C, F 
- V 18: C 
- X 19: E, B - B, F
- V 20: A, E, D 
- X 21: F - E  

## chapter 3, for loops, switch


- X 1: A, B, E, F - A, B, C, E, F, G cannot have long in switch
- X 2: A - B 
- V 3: A, D, F, H  
- X 4: C - F 
- V 5: E 
- X 6: C, A, D, E - C, D, E  
- X 7: B, C, D - B, D
- V 8: G 
- X 9: C - B,C,E 
- V 10: E
- V 11: A   
- V 12: C 
- V 13: G 
- V 14: B,D,F  
- V 15: F
- V 16: A, B,D, 
- X 17: G - B,E 
- X 18: C, D, E - C,E
- V 19: E 
- X 20: E - A, E
- V 21: E  
- X 22: F - E   
- X 23: A - F  
- X 24: A, D, E - G  
- X 25: F - D  
- V 26: F
- V 27: F 
- X 28: B - F 
- X 29: D - C

# Chapter 4 - Core APIs

-  1: 
-  2: 
-  3:  
-  4: 
-  5: 
-  6: 
-  7:
-  8:
-  9:  
-  10:
-  11:    
-  12:  
-  13: 
-  14:  
-  15: 
-  16: 
-  17: 
-  18:
-  19: 
-  20:
-  21:
-  22:   
-  23:  
-  24:  
-  25:  
-  26:
-  27:
-  28: 
-  29:


# Chapter 5 - Methods

-  1: 
-  2: 
-  3:  
-  4: 
-  5: 
-  6: 
-  7:
-  8:
-  9:  
-  10:
-  11:    
-  12:  
-  13: 
-  14:  
-  15: 
-  16: 
-  17: 
-  18:
-  19: 
-  20:
-  21:
-  22:   
-  23:  
-  24:  
-  25:  
-  26:
-  27:
-  28: 
-  29:

# Chapter 6 - Class Design

-  1: 
-  2: 
-  3:  
-  4: 
-  5: 
-  6: 
-  7:
-  8:
-  9:  
-  10:
-  11:    
-  12:  
-  13: 
-  14:  
-  15: 
-  16: 
-  17: 
-  18:
-  19: 
-  20:
-  21:
-  22:   
-  23:  
-  24:  
-  25:  
-  26:
-  27:
-  28: 
-  29:

# Chapter 7 - Beyond Classes

-  1: 
-  2: 
-  3:  
-  4: 
-  5: 
-  6: 
-  7:
-  8:
-  9:  
-  10:
-  11:    
-  12:  
-  13: 
-  14:  
-  15: 
-  16: 
-  17: 
-  18:
-  19: 
-  20:
-  21:
-  22:   
-  23:  
-  24:  
-  25:  
-  26:
-  27:
-  28: 
-  29:

# Chapter 8 - Lambdas and Functional interfaces

Trans, train, 

- V 1: A 
- V 2: C 
- V 3: A, C  
- V 4: A, F 
- V 5: A, C, E 
- V 6: A, C, 
- X 7: B - E
- V 8: E
- V 9: A, F,  
- V 10: A, B, C
- V 11: D    
- V 12: A  
- V 13: E 
- X 14: B, D, F, - B, D  
- X 15: C, B, - A, F
- V 16: C 
- V 17: C 
- X 18: B, E, G - B, F, G
- X 19: B, C, F - F 
- V 20: E
- X 21: F, E - A, E, F

------
- 7:
B is incorrect because the code does compile.

- 14:
Option F is incorrect because the variable declaration requires a semicolon (;) after it.

- 15:
A, F.  

> C is incorrect because p is already declared within the scope.

> B is incorrect because the variable age isnt final or efective final

> A is correct since p is accessible within the scope

> F is correct because h became the Hyena passed as parameter

- 18:

> F is correct because Supplier<String> is used for String::new

> E is incorrect because Predicate<String> doesnt fit any blank space

- 19:

> B and C is incorrect because "s" is already defined within the scope


- 21

> A is valid. int hashCode() does not count because it is the same from
> Object().hashCode. int hashCode(String input); makes the interface a valid SAM

# Chapter 9 - Collections and Generics

-  1: 
-  2: 
-  3:  
-  4: 
-  5: 
-  6: 
-  7:
-  8:
-  9:  
-  10:
-  11:    
-  12:  
-  13: 
-  14:  
-  15: 
-  16: 
-  17: 
-  18:
-  19: 
-  20:
-  21:
-  22:   
-  23:  
-  24:  
-  25:  
-  26:
-  27:
-  28: 
-  29:

# Chapter 10 - Streams 

-  1: 
-  2: 
-  3:  
-  4: 
-  5: 
-  6: 
-  7:
-  8:
-  9:  
-  10:
-  11:    
-  12:  
-  13: 
-  14:  
-  15: 
-  16: 
-  17: 
-  18:
-  19: 
-  20:
-  21:
-  22:   
-  23:  
-  24:  
-  25:  
-  26:
-  27:
-  28: 
-  29:

# Chapter 11 - Exceptions and Localization

-  1: 
-  2: 
-  3:  
-  4: 
-  5: 
-  6: 
-  7:
-  8:
-  9:  
-  10:
-  11:    
-  12:  
-  13: 
-  14:  
-  15: 
-  16: 
-  17: 
-  18:
-  19: 
-  20:
-  21:
-  22:   
-  23:  
-  24:  
-  25:  
-  26:
-  27:
-  28: 
-  29:

# Chapter 12 - Modules

-  1: 
-  2: 
-  3:  
-  4: 
-  5: 
-  6: 
-  7:
-  8:
-  9:  
-  10:
-  11:    
-  12:  
-  13: 
-  14:  
-  15: 
-  16: 
-  17: 
-  18:
-  19: 
-  20:
-  21:
-  22:   
-  23:  
-  24:  
-  25:  
-  26:
-  27:
-  28: 
-  29:

# Chapter 13 - Concurrency

-  1: 
-  2: 
-  3:  
-  4: 
-  5: 
-  6: 
-  7:
-  8:
-  9:  
-  10:
-  11:    
-  12:  
-  13: 
-  14:  
-  15: 
-  16: 
-  17: 
-  18:
-  19: 
-  20:
-  21:
-  22:   
-  23:  
-  24:  
-  25:  
-  26:
-  27:
-  28: 
-  29:

# Chapter 14 - I/O

-  1: 
-  2: 
-  3:  
-  4: 
-  5: 
-  6: 
-  7:
-  8:
-  9:  
-  10:
-  11:    
-  12:  
-  13: 
-  14:  
-  15: 
-  16: 
-  17: 
-  18:
-  19: 
-  20:
-  21:
-  22:   
-  23:  
-  24:  
-  25:  
-  26:
-  27:
-  28: 
-  29:

# Chapter 15 - JDBC

-  1: 
-  2: 
-  3:  
-  4: 
-  5: 
-  6: 
-  7:
-  8:
-  9:  
-  10:
-  11:    
-  12:  
-  13: 
-  14:  
-  15: 
-  16: 
-  17: 
-  18:
-  19: 
-  20:
-  21:
-  22:   
-  23:  
-  24:  
-  25:  
-  26:
-  27:
-  28: 
-  29:


