package hashing

import kotlin.math.max

/**
 * 3. Longest Substring Without Repeating Characters
 *
 * Given a string s, find the length of the longest
 * substring
 *  without repeating characters.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 *
 * Constraints:
 *
 * 0 <= s.length <= 5 * 104
 * s consists of English letters, digits, symbols and spaces.
 */

class LC3LongestSubstringWithoutRepeatingCharacters {
    fun lengthOfLongestSubstring(s: String): Int {

        // Since the problem deals with the longest substring, we can use the Sliding Window technique
        // To check if a char is already presented in the string, we can use a set to gain O(1)
        // Define left and right variables and iterate over the string
        // Start expanding the window by incrementing the right
        // For each index (char), we're going to put it in the set as we've seen it
        //      If the char (rightmost index) is in the set, that means we already saw this char
        //      We try to collapse the window by incrementing the left index and removing it from the seen
        //      Continue this step until the right most char is unique
        // Update the answer. (The formula to find the length between two indexes is (right - left + 1))

        var ans = 0
        val check = mutableSetOf<Char>()
        var left = 0

        for (right in s.indices) {
            while (check.contains(s[right])) {
                check.remove(s[left])
                left++
            }
            check.add(s[right])
            ans = max(ans, right - left + 1)
        }

        return ans
    }
}