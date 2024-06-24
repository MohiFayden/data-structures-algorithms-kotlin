package hashing

/**
 * 451. Sort Characters By Frequency
 *
 * Given a string s, sort it in decreasing order based on the frequency of the characters. The frequency of a character is the number of times it appears in the string.
 *
 * Return the sorted string. If there are multiple answers, return any of them.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "tree"
 * Output: "eert"
 * Explanation: 'e' appears twice while 'r' and 't' both appear once.
 * So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
 * Example 2:
 *
 * Input: s = "cccaaa"
 * Output: "aaaccc"
 * Explanation: Both 'c' and 'a' appear three times, so both "cccaaa" and "aaaccc" are valid answers.
 * Note that "cacaca" is incorrect, as the same characters must be together.
 * Example 3:
 *
 * Input: s = "Aabb"
 * Output: "bbAa"
 * Explanation: "bbaA" is also a valid answer, but "Aabb" is incorrect.
 * Note that 'A' and 'a' are treated as two different characters.
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 5 * 105
 * s consists of uppercase and lowercase English letters and digits.
 */

class LC451SortCharactersByFrequency {
    fun frequencySort(s: String): String {

        // We Can define a hash table to count the frequency of the characters
        // Iterate over the string and collect the frequency of the chars
        // Then, iterate over the entries, sort them based on the value, and return the keys which are now sorted
        // Iterate over the sorted keys and based on their frequency build the new string

        val counts = mutableMapOf<Char, Int>()

        // Frequency
        s.forEach { char ->
            counts[char] = (counts[char] ?: 0) + 1
        }

        // We use the build it sort function to do the sorting
        val sortedKeys = counts.entries.sortedByDescending { it.value }.map { it.key }

        // Build the new string based on the frequency of each char
        return buildString {
            sortedKeys.forEach { char ->
                repeat(counts[char]!!) {
                    append(char)
                }
            }
        }
    }
}