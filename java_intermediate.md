# Java intermediate topics

- TODO skiped topics: Core Apis, Methods, Class Design, Beyond classes

# Lambda (or clojures)

- like anonymous classes and method
- interfaces with exacly one abstract method
- Parentheses are optional only if theres ONLY one parameter AND no type declared
- U can extend the functional interface and still considerated SAM, but if u add another method... not SAM
    - `default` method + abstract method = valid SAM
    - `static` methods + abstract method = valid SAM

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


# Streams


# Exceptions

# I/O
