package arrays_and_strings

/**
 * 917. Reverse Only Letters
 * 
 * Given a string s, reverse the string according to the following rules:
 *
 * All the characters that are not English letters remain in the same position.
 * All the English letters (lowercase or uppercase) should be reversed.
 * Return s after reversing it.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "ab-cd"
 * Output: "dc-ba"
 * Example 2:
 *
 * Input: s = "a-bC-dEf-ghIj"
 * Output: "j-Ih-gfE-dCba"
 * Example 3:
 *
 * Input: s = "Test1ng-Leet=code-Q!"
 * Output: "Qedo1ct-eeLg=ntse-T!"
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 100
 * s consists of characters with ASCII values in the range [33, 122].
 * s does not contain '\"' or '\\'.
 */

class LC917ReverseOnlyLetters {
    fun reverseOnlyLetters(s: String): String {
        // Change the string to char array to reverse in place
        // Set two pointers at the left and right side of the strings
        // Start iterating over the string until two pointers are not met
        // If both left and right side chars are english letters, swap them in place
        // Otherwise, increment or decrement the left and right side based on the non letter char

        val ans = s.toCharArray()
        var left = 0
        var right = s.length - 1

        while (left < right) {
            when {
                !ans[left].isLetter() -> left++
                !ans[right].isLetter() -> right--
                else -> {
                    val temp = ans[left]
                    ans[left] = ans[right]
                    ans[right] = temp
                    left++
                    right--
                }
            }
        }

        return ans.concatToString()
    }
}