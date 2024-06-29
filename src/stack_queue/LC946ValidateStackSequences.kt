package stack_queue

/**
 * 946. Validate Stack Sequences
 *
 * Medium
 *
 * Given two integer arrays pushed and popped each with distinct values, return true if this could have been the result of a sequence of push and pop operations on an initially empty stack, or false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
 * Output: true
 * Explanation: We might do the following sequence:
 * push(1), push(2), push(3), push(4),
 * pop() -> 4,
 * push(5),
 * pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
 * Example 2:
 *
 * Input: pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
 * Output: false
 * Explanation: 1 cannot be popped before 2.
 *
 *
 * Constraints:
 *
 * 1 <= pushed.length <= 1000
 * 0 <= pushed[i] <= 1000
 * All the elements of pushed are unique.
 * popped.length == pushed.length
 * popped is a permutation of pushed.
 */

class LC946ValidateStackSequences {
    fun validateStackSequences(pushed: IntArray, popped: IntArray): Boolean {

        // Intuition:
        // We simulate the stack to see if the pushed and popped sequences are valid.
        // The idea is to use a stack to mimic the push/pop operations.
        // We iterate through the 'pushed' array and simulate the pushing of elements onto the stack.
        // After each push, we check if the top of the stack matches the next element in the 'popped' array.
        // If it matches, we pop from the stack. This continues until we have processed all elements.
        // If the stack is empty at the end, it means the sequences are valid.

        val stack = ArrayDeque<Int>() // Using ArrayDeque as a stack to hold the pushed elements
        var popIndex = 0 // This keeps track of the current position in the popped array

        // Iterate through each element in the pushed array
        for (push in pushed) {
            stack.addLast(push) // Simulate pushing the element onto the stack

            // Check if the top of the stack matches the current element in the popped array
            while (stack.isNotEmpty() && stack.last() == popped[popIndex]) {
                stack.removeLast() // Simulate popping the element from the stack
                popIndex++ // Move to the next element in the popped array
            }
        }

        // If the stack is empty, all pushed elements were matched correctly with the popped elements
        return stack.isEmpty()
    }
}