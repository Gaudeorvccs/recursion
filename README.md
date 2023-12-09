## Java Recursion Examples

GuessingGame generates a random integer between 0 and 100 and shows it to the player. It then tries to guess the number, and the player must enter "higher", "lower", or "correct". If the user enters feedback correctly, then the game will eventually guess the number using a recursive search algorithm. Input checking is separated into a method.

SortedListSearch is a recursive algorithm to find a specific integer in a sorted array of integers. The method returns the index of the integer in the array, or -1 indicating it does not exist. Main implements an example usage.

FactorialCalculator implments a recusive algorithm to calculate the factorial of an input positive integer. It will throw an out of bounds error for negative input. It returns a BigInteger object since Factorials can be large when inVal > 19.