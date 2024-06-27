package hashing

/**
 * 1657. Determine if Two Strings Are Close
 *
 * Two strings are considered close if you can attain one from the other using the following operations:
 *
 * Operation 1: Swap any two existing characters.
 * For example, abcde -> aecdb
 * Operation 2: Transform every occurrence of one existing character into another existing character, and do the same with the other character.
 * For example, aacabb -> bbcbaa (all a's turn into b's, and all b's turn into a's)
 * You can use the operations on either string as many times as necessary.
 *
 * Given two strings, word1 and word2, return true if word1 and word2 are close, and false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: word1 = "abc", word2 = "bca"
 * Output: true
 * Explanation: You can attain word2 from word1 in 2 operations.
 * Apply Operation 1: "abc" -> "acb"
 * Apply Operation 1: "acb" -> "bca"
 * Example 2:
 *
 * Input: word1 = "a", word2 = "aa"
 * Output: false
 * Explanation: It is impossible to attain word2 from word1, or vice versa, in any number of operations.
 * Example 3:
 *
 * Input: word1 = "cabbba", word2 = "abbccc"
 * Output: true
 * Explanation: You can attain word2 from word1 in 3 operations.
 * Apply Operation 1: "cabbba" -> "caabbb"
 * Apply Operation 2: "caabbb" -> "baaccc"
 * Apply Operation 2: "baaccc" -> "abbccc"
 *
 *
 * Constraints:
 *
 * 1 <= word1.length, word2.length <= 105
 * word1 and word2 contain only lowercase English letters.
 */

class LC1657DetermineIfTwoStringsAreClose {
    fun closeStrings(word1: String, word2: String): Boolean {

        // One key is that we don't need to return any string or actual result
        // We just need to validate the two strings in any way
        // Validations:
        //      1- that word1 and word2 should have the same chars regardless of their frequency
        //      2- the frequencies list itself should be the same for both words regardless of the chars

        // The length should be the same
        if (word1.length != word2.length) return false

        // Set the size of 26 as we only have 26 english letters
        val map1 = HashMap<Char, Int>(26)
        val map2 = HashMap<Char, Int>(26)

        // Initialize the maps
        word1.forEach { char ->
            map1[char] = (map1[char] ?: 0) + 1
        }

        word2.forEach { char ->
            map2[char] = (map2[char] ?: 0) + 1
        }

        // Size of the unique chars should be the same
        if (map1.size != map2.size) return false

        // unique chars should be available in both strings
        map1.keys.forEach { char ->
            if (!map2.contains(char)) return false
        }

        // Check if all the frequencies are the same regardless of the letters
        // Sort them to easily compare both lists
        return map1.values.sorted() == map2.values.sorted()

        // We can also use the following code to compare the frequencies
        // return map1.values.groupingBy { it }.eachCount() == map2.values.groupingBy { it }.eachCount()
    }
}