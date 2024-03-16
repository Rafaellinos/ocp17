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


h = 1
w = 3

z = 

- 1: A,D,G?
- 2: A,B,i
- 3: B,C,F
- 4: B
- 5: B, D, 
- 6: F
- 7: C
- 8: A
- 9: A, D, E
- 10: G
