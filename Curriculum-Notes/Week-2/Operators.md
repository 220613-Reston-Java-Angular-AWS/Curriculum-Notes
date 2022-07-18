

## Operators
There are several different operators in Java. We have already seen the assignment operator (`=`) which assigns a reference variable to a primitive value or object. [This article](https://docs.oracle.com/javase/8/docs/api/java/util/StringTokenizer.html) explains in detail many of the other operators, some of which we will discuss below.

### Increment and decrement operators
In order to increment or decrement integral values, we can use the common **postfix** operators: `x++` and `x--`, where `x` is a `byte`, `short`, `int`, or `long`. A similar operator is the **prefix** increment or decrement: `++x` and `--x`. The difference is that the prefix operator will change the value *before* the rest of the expression is evaluated, while the postfix operator changes the value *after* the entire expression is evaluated.
```
int a = 5;
int b = a++; // assign b=5, then increment a to 6
int c = ++a; // increment a to 7, then assign c=7
System.out.println(a); // 7
System.out.println(b); // 5
System.out.println(c); // 7
```

### Logical operators
There are a few logical operators you should be aware of: `&&` is the logical AND operator - it compares two boolean values. If both are true, the expression becomes true. Otherwise, the expression becomes false.

The logical OR operator `||` compares two boolean values - if **either** of the values are true, the expression evaluates to true. Otherwise, the expression is false.

Finally, the logical NOT operator `!` reverses the state of the boolean - so true becomes false and false becomes true.

We can combine logical operations like so:
```java
boolean a = true;
boolean b = false;
if (!(a && b)) {
  System.out.println("a and b are NOT both true");
}
```

### Ternary Operator
The **ternary operator** uses the following syntax: `x = condition ? expr1 : expr2`. If the condition is true, `x` is assigned the value of `expr1`; if the condition is false, `expr2` is assigned.
```java
boolean skyIsBlue = true;
boolean twoAndTwoIsFour = true;
boolean makesSense = (skyIsBlue && twoAndTwoIsFour) ? true : false ;
```

## Operator precedence

The operators below are listed in order of precedence. The closer an operator is to the top the table, the higher its precedence. Operators with higher precedence will be evaluated before operators with lower precedence.

When operators of equal precedence appear in the same line of code:
- All binary operators with the exception of assignment operators are evaluated from left to right.
- Assignment operators are evaluated from right to left.

|Operators|Precedence|
|---------|----------|
|postfix  |expr++ expr--|
|unary    |++expr --expr +expr -expr ~ !
|multiplicative|* / %|
|additive |+ - |
|shift    |<< >> >>>|
|relational |< > <= >= instanceof|
|equality |== != |
|bitwise  |AND	&|
|bitwise exclusive OR| ^ |
|bitwise inclusive OR| \| |
|logical AND |&&
|logical OR  |\|\|
|ternary |? :|
|assignment|	= += -= *= /= %= &= ^= |= <<= >>= >>>=