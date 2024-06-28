package stack_queue

/**
 * 20. Valid Parentheses
 *
 * Easy
 *
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 *
 *
 * Example 1:
 *
 * Input: s = "()"
 * Output: true
 * Example 2:
 *
 * Input: s = "()[]{}"
 * Output: true
 * Example 3:
 *
 * Input: s = "(]"
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 104
 * s consists of parentheses only '()[]{}'.
 */

class LC20ValidParentheses {

    fun isValid(s: String): Boolean {

        // To validate the brackets, we need to ensure that every closing bracket has a corresponding opening bracket in the correct order.
        // Examples:
        // "{[]}" -> true
        // "()[]{}" -> true
        // "[({})]" -> true
        // "[()[]]({})" -> true
        // "]" or "(]" -> false

        if (s.length < 2) {
            return false
        }

        // Helper function to get the corresponding opening bracket for a given closing bracket.
        fun pair(char: Char): Char {
            return when (char) {
                ')' -> '('
                ']' -> '['
                else -> '{'
            }
        }

        // Helper function to check if a character is an opening bracket.
        fun isOpen(char: Char): Boolean {
            return char == '(' || char == '[' || char == '{'
        }

        // ArrayDeque is an efficient data structure for use as a stack.
        val stack = ArrayDeque<Char>()

        s.forEach { char ->
            if (isOpen(char)) { // If it's an open bracket, push it onto the stack.
                stack.add(char)
            } else { // If it's a close bracket, check if the previous bracket on the stack is the corresponding open bracket.
                if (stack.isNotEmpty() && stack.last() == pair(char)) {
                    stack.removeLast()
                } else {
                    return false
                }
            }
        }

        // If the stack is empty, all brackets were properly closed and the input string is valid.
        return stack.isEmpty()

        // Alternative approach using a hash table for bracket pairs. This approach uses more space due to the overhead of the hash table.

        // val par = mapOf(
        //     '(' to ')',
        //     '[' to ']',
        //     '{' to '}'
        // )
        // s.forEach { char ->
        //     if (par.contains(char)) {
        //         stack.add(char)
        //     } else {
        //         if (stack.isNotEmpty() && par[stack.last()] == char) { // Found the correct pair
        //             stack.removeLast()
        //         } else {
        //             return false // Found the wrong pair
        //         }
        //     }
        // }
        // return stack.isEmpty()
    }
}