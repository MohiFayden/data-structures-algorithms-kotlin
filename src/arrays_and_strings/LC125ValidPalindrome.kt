package arrays_and_strings

/**
 * 125. Valid Palindrome
 *
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.
 *
 * Given a string s, return true if it is a palindrome, or false otherwise.
 *
 *
 * Example 1:
 *
 * Input: s = "A man, a plan, a canal: Panama"
 * Output: true
 * Explanation: "amanaplanacanalpanama" is a palindrome.
 * Example 2:
 *
 * Input: s = "race a car"
 * Output: false
 * Explanation: "raceacar" is not a palindrome.
 * Example 3:
 *
 * Input: s = " "
 * Output: true
 * Explanation: s is an empty string "" after removing non-alphanumeric characters.
 * Since an empty string reads the same forward and backward, it is a palindrome.
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 2 * 105
 * s consists only of printable ASCII characters.
 */

class LC125ValidPalindrome {
    fun isPalindrome(s: String): Boolean {

        var left = 0
        var right = s.length - 1

        while (left < right) {

            // Check if the left char is a valid char, if not, remove it from the process
            if (!s[left].isLetterOrDigit()) {
                left++
                continue
            }

            // Check if the right char is a valid char, if not remove it from the process
            if (!s[right].isLetterOrDigit()) {
                right--
                continue
            }

            // Return false if the corresponding chars are not equal
            if (!s[left].equals(s[right], ignoreCase = true)) {
                return false
            }

            left++
            right--
        }

        // Return true when we checked all the string
        return true
    }
}