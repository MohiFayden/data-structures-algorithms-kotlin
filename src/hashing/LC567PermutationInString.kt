package hashing

/**
 * 567. Permutation in String
 *
 * Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
 *
 * In other words, return true if one of s1's permutations is the substring of s2.
 *
 *
 *
 * Example 1:
 *
 * Input: s1 = "ab", s2 = "eidbaooo"
 * Output: true
 * Explanation: s2 contains one permutation of s1 ("ba").
 * Example 2:
 *
 * Input: s1 = "ab", s2 = "eidboaoo"
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= s1.length, s2.length <= 104
 * s1 and s2 consist of lowercase English letters.
 */

class LC567PermutationInString {
    fun checkInclusion(s1: String, s2: String): Boolean {

        // One key is that the size of the s1 should be the size of a subarray of the s2 as the first condition
        // We can count the frequency of chars in s1
        // Then expand a window on s2
        // For each window, check if the frequency of the window is the same as s1 or not
        // At each step of the window
        //      Remove the left char or decrement the frequency
        //      Add the right chart or increment the frequency

        if (s1.length > s2.length) return false

        val valid = mutableMapOf<Char, Int>()
        val window = mutableMapOf<Char, Int>()

        s1.forEach { char ->
            valid[char] = (valid[char] ?: 0) + 1
        }

        // Initialize the first window
        for (i in s1.indices) {
            val char = s2[i]
            window[char] = (window[char] ?: 0) + 1
        }

        // Inner function to validate the current window
        fun windowIsValid(): Boolean {
            if (window.size != valid.size) return false
            window.keys.forEach { key ->
                if (window[key] != valid[key]) return false
            }
            return true
        }

        // If current window is valid return true
        if (windowIsValid()) return true

        for (index in s1.length..<s2.length) {
            val leftChar = s2[index - s1.length]
            val rightChar = s2[index]
            if (window[leftChar]!! == 1) {
                window.remove(leftChar)
            } else {
                window[leftChar] = window[leftChar]!! - 1
            }
            window[rightChar] = (window[rightChar] ?: 0) + 1

            if (windowIsValid()) return true
        }

        return false
    }
}