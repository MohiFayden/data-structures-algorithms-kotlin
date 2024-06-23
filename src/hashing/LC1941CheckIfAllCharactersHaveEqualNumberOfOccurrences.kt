package hashing

/**
 * 1941. Check if All Characters Have Equal Number of Occurrences
 *
 * Given a string s, return true if s is a good string, or false otherwise.
 *
 * A string s is good if all the characters that appear in s have the same number of occurrences (i.e., the same frequency).
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abacbc"
 * Output: true
 * Explanation: The characters that appear in s are 'a', 'b', and 'c'. All characters occur 2 times in s.
 * Example 2:
 *
 * Input: s = "aaabb"
 * Output: false
 * Explanation: The characters that appear in s are 'a' and 'b'.
 * 'a' occurs 3 times while 'b' occurs 2 times, which is not the same number of times.
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 1000
 * s consists of lowercase English letters.
 */

class LC1941CheckIfAllCharactersHaveEqualNumberOfOccurrences {
    fun areOccurrencesEqual(s: String): Boolean {

        // We can use Hash Table to count the number of occurrences for each char
        // Iterate over the string
        // At each step, increment the number of count for that char
        // At the end, see if all the counts are equal
        //

        val map = mutableMapOf<Char, Int>()

        s.forEach { char ->
            map[char] = map.getOrDefault(char, 0) + 1
        }
        val occ = map.values.first()

        // We can use this simple line but is not efficient as it always loop over the all map items
        // return map.filterValues{ it != occ }.isEmpty()
        // Or we can define a set to and store the values in the set and see if the size of set is 1, then it's a good string

        for (item in map.values) {
            if (item != occ) {
                return false
            }
        }

        return true
    }
}