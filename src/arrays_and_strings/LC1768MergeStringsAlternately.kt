package arrays_and_strings

/**
 * 1768. Merge Strings Alternately
 *
 * You are given two strings word1 and word2. Merge the strings by adding letters in alternating order, starting with word1. If a string is longer than the other, append the additional letters onto the end of the merged string.
 *
 * Return the merged string.
 *
 *
 *
 * Example 1:
 *
 * Input: word1 = "abc", word2 = "pqr"
 * Output: "apbqcr"
 * Explanation: The merged string will be merged as so:
 * word1:  a   b   c
 * word2:    p   q   r
 * merged: a p b q c r
 * Example 2:
 *
 * Input: word1 = "ab", word2 = "pqrs"
 * Output: "apbqrs"
 * Explanation: Notice that as word2 is longer, "rs" is appended to the end.
 * word1:  a   b
 * word2:    p   q   r   s
 * merged: a p b q   r   s
 * Example 3:
 *
 * Input: word1 = "abcd", word2 = "pq"
 * Output: "apbqcd"
 * Explanation: Notice that as word1 is longer, "cd" is appended to the end.
 * word1:  a   b   c   d
 * word2:    p   q
 * merged: a p b q c   d
 *
 *
 * Constraints:
 *
 * 1 <= word1.length, word2.length <= 100
 * word1 and word2 consist of lowercase English letters.
 */

class LC1768MergeStringsAlternately {
    fun mergeAlternately(word1: String, word2: String): String {

        // Intuition:
        // The problem asks us to merge two strings by alternating characters from each string.
        // A simple and efficient way to accomplish this is by using two pointers, one for each string.
        // We iterate through both strings simultaneously, appending characters from each string in turn.
        // If one string is shorter, once we exhaust it, we continue appending characters from the longer string.

        // Initialize two pointers to iterate over word1 and word2
        var counter1 = 0
        var counter2 = 0

        // Use a StringBuilder to efficiently build the resulting string
        return buildString {
            // Continue looping until we've processed all characters in both strings
            while (counter1 < word1.length || counter2 < word2.length) {
                // If there are remaining characters in word1, append the next character
                if (counter1 < word1.length) {
                    append(word1[counter1])
                }
                // If there are remaining characters in word2, append the next character
                if (counter2 < word2.length) {
                    append(word2[counter2])
                }
                // Move both pointers forward by one position
                counter1++
                counter2++
            }
        }
    }
}