package hashing

/**
 * 290. Word Pattern
 *
 * Given a pattern and a string s, find if s follows the same pattern.
 *
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.
 *
 *
 *
 * Example 1:
 *
 * Input: pattern = "abba", s = "dog cat cat dog"
 * Output: true
 * Example 2:
 *
 * Input: pattern = "abba", s = "dog cat cat fish"
 * Output: false
 * Example 3:
 *
 * Input: pattern = "aaaa", s = "dog cat cat dog"
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= pattern.length <= 300
 * pattern contains only lower-case English letters.
 * 1 <= s.length <= 3000
 * s contains only lowercase English letters and spaces ' '.
 * s does not contain any leading or trailing spaces.
 * All the words in s are separated by a single space.
 */

class LC290WordPattern {
    fun wordPattern(pattern: String, s: String): Boolean {

        // The problem states that every unique letter in the pattern should be mapped with a unique word in s
        // We can build the words along with the algorithm:
        // var start = 0
        // var end = start + 1
        // val word = buildString {
        //     append(s[start])
        //     while (end < s.length && s[end] != ' ') {
        //         append(s[end])
        //         end++
        //     }
        // }
        // But, since the condition is simple, we can use the builtin split function to split the s into the words
        // If any letter, is mapped exactly to one word, then return true
        // We can iterate over the pattern, for each letter in the pattern, extract a word from s with a pointer technique

        val words = s.split(' ')

        if (pattern.length != words.size) return false

        val charToWord = mutableMapOf<Char, String>() // map pattern to s
        val wordToChar = mutableMapOf<String, Char>() // map s to pattern

        for (i in pattern.indices) {

            val char = pattern[i]
            val word = words[i]

            // Check if the mapping of pattern to s is valid
            if (charToWord.contains(char)) {
                if (charToWord[char]!! != word) return false
            } else {
                charToWord[char] = word
            }

            // Check if the mapping of s to pattern is valid
            if (wordToChar.contains(word)) {
                if (wordToChar[word]!! != char) return false
            } else {
                wordToChar[word] = char
            }
        }

        return true
    }
}