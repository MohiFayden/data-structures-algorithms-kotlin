package arrays_and_strings

import kotlin.math.max

/**
 * 1456. Maximum Number of Vowels in a Substring of Given Length
 *
 * Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.
 *
 * Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abciiidef", k = 3
 * Output: 3
 * Explanation: The substring "iii" contains 3 vowel letters.
 * Example 2:
 *
 * Input: s = "aeiou", k = 2
 * Output: 2
 * Explanation: Any substring of length 2 contains 2 vowels.
 * Example 3:
 *
 * Input: s = "leetcode", k = 3
 * Output: 2
 * Explanation: "lee", "eet" and "ode" contain 2 vowels.
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 105
 * s consists of lowercase English letters.
 * 1 <= k <= s.length
 */

class LC1456MaximumNumberOfVowelsInASubstringOfGivenLength {
    fun maxVowels(s: String, k: Int): Int {

        // This can be done by Sliding Window technique
        // Set two pointer, left at the beginning, right at the kth index
        //      count the vowels in this range
        // Start moving the window by incrementing the left and right
        // Update the count and answer
        //      If the left char is a vowel, decrement the count
        //      If the right char is vowel, increment the count
        //      Update the answer

        var count = 0

        fun isVowel(index: Int): Boolean {
            return when (s[index]) {
                'a', 'e', 'i', 'o', 'u' -> true
                else -> false
            }
        }

        for (i in 0..<k) {
            if (isVowel(i)) count++
        }

        var ans = count

        for ((left, right) in (k..<s.length).withIndex()) {
            if (isVowel(left)) count--
            if (isVowel(right)) count++
            ans = max(ans, count)
        }

        return ans
    }
}