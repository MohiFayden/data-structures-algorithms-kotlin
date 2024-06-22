package arrays_and_strings

import kotlin.math.abs
import kotlin.math.max

/**
 * 1208. Get Equal Substrings Within Budget
 *
 * You are given two strings s and t of the same length and an integer maxCost.
 *
 * You want to change s to t. Changing the ith character of s to ith character of t costs |s[i] - t[i]| (i.e., the absolute difference between the ASCII values of the characters).
 *
 * Return the maximum length of a substring of s that can be changed to be the same as the corresponding substring of t with a cost less than or equal to maxCost. If there is no substring from s that can be changed to its corresponding substring from t, return 0.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abcd", t = "bcdf", maxCost = 3
 * Output: 3
 * Explanation: "abc" of s can change to "bcd".
 * That costs 3, so the maximum length is 3.
 * Example 2:
 *
 * Input: s = "abcd", t = "cdef", maxCost = 3
 * Output: 1
 * Explanation: Each character in s costs 2 to change to character in t,  so the maximum length is 1.
 * Example 3:
 *
 * Input: s = "abcd", t = "acde", maxCost = 0
 * Output: 1
 * Explanation: You cannot make any change, so the maximum length is 1.
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 105
 * t.length == s.length
 * 0 <= maxCost <= 106
 * s and t consist of only lowercase English letters.
 */

class LC1208GetEqualSubstringsWithinBudget {
    fun equalSubstring(s: String, t: String, maxCost: Int): Int {
        // We can use Sliding Window technique to achieve the goal
        // Put two pointers at the beginning of the strings (left, right)
        // Initialize a cost variable to collect the current cost of the window
        // Start expanding the window by incrementing the right
        //      At each step, calculate the cost and add it up to the cost
        // If cost is higher than the maxCost, collapse the window by incrementing the left
        // Update the answer at each step

        var left = 0
        var cost = 0
        var ans = 0

        for (right in s.indices) {
            cost += abs(s[right] - t[right])

            while (cost > maxCost) {
                cost -= abs(s[left] - t[left])
                left++
            }
            ans = max(ans, right - left + 1)
        }

        return ans
    }
}