First, you would like to check the credit in Credit.md file.

This architecture mainly concern about to eliminating Circular dependency problem. By using Control
Module we can cut the dependency line into only single module source. For any shared module or
feature have tobe injected into the Control Injection Module.

By this way, every module can use shared features without "knowing" or "see" or "depend" to the
module that serve the shared features.

## The Arrow Library

Arrow is so powerfull to simplify and cleanify the codebase. Also so powerful to eliminate
exception.

## Jetpack Compose

Compose is so wondeful. Even though compose is so powerful in handling side effect, it is quite new
and quite hard not to make the memory leaks.
