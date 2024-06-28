package stack_queue

/**
 * 1047. Remove All Adjacent Duplicates In String
 *
 * Easy
 *
 * You are given a string s consisting of lowercase English letters. A duplicate removal consists of choosing two adjacent and equal letters and removing them.
 *
 * We repeatedly make duplicate removals on s until we no longer can.
 *
 * Return the final string after all such duplicate removals have been made. It can be proven that the answer is unique.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abbaca"
 * Output: "ca"
 * Explanation:
 * For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, and this is the only possible move.  The result of this move is that the string is "aaca", of which only "aa" is possible, so the final string is "ca".
 * Example 2:
 *
 * Input: s = "azxxzy"
 * Output: "ay"
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 105
 * s consists of lowercase English letters.
 */

class LC1047RemoveAllAdjacentDuplicatesInString {
    fun removeDuplicates(s: String): String {
        // Initialize a stack to keep track of characters
        val stack = ArrayDeque<Char>()

        // Iterate through each character in the string
        s.forEach { char ->
            // If the stack is not empty and the top element is the same as the current character
            if (stack.isNotEmpty() && stack.last() == char) {
                // Remove the top element from the stack
                stack.removeLast()
            } else {
                // Otherwise, add the current character to the stack
                stack.add(char)
            }
        }

        // Join the elements of the stack to form the resultant string without duplicates
        return stack.joinToString("")
    }
}