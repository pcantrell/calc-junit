A simple example of JUnit, and how automated unit testing enables us to refactor with confidence.

Note how the [second commit](https://github.com/pcantrell/calc-junit/commit/4fb1ed1a00562867d7378e01360ea4512a67656a) drastically reorganizes the Calculator class, but leaves CalculatorTest unchanged. Because the tests still pass, we can perform a risky refactoring like this with confidence — though never absolute certainty — that we haven’t broken anything.
