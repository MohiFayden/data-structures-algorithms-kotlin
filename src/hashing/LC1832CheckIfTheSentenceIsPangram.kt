package hashing

/**
 * 1832. Check if the Sentence Is Pangram
 *
 * A pangram is a sentence where every letter of the English alphabet appears at least once.
 *
 * Given a string sentence containing only lowercase English letters, return true if sentence is a pangram, or false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: sentence = "thequickbrownfoxjumpsoverthelazydog"
 * Output: true
 * Explanation: sentence contains at least one of every letter of the English alphabet.
 * Example 2:
 *
 * Input: sentence = "leetcode"
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= sentence.length <= 1000
 * sentence consists of lowercase English letters.
 */

class LC1832CheckIfTheSentenceIsPangram {
    fun checkIfPangram(sentence: String): Boolean {
        // 1: Set
        // Easiest way is to use a set and try to add chars into the set
        // Since set does not except the duplicated items, at the end the size should be 26
        // If so, return true, otherwise, return false


        // 2: Char Value
        // We now that the 'a'...'z' chars can be converted to the equivalent int numbers -> 97...122
        // If init a loop of 26, we can have the value of 'a'...'z'
        //      and check if all the chars are presented in the sentence or not

        // return useSet(sentence)
        return useCharValue(sentence)
    }


    //----------Char Value----------
    private fun useCharValue(sentence: String): Boolean {
        repeat(26) {
            if (sentence.indexOf('a' + it) == -1) {
                return false
            }
        }

        return true
    }


    //----------Set----------
    private fun useSet(sentence: String): Boolean {
        val set = mutableSetOf<Char>()
        sentence.forEach { char ->
            set.add(char)
        }

        return set.size == 26
    }
}