package hashing

/**
 * 2351. First Letter to Appear Twice
 *
 * Given a string s consisting of lowercase English letters, return the first letter to appear twice.
 *
 * Note:
 *
 * A letter a appears twice before another letter b if the second occurrence of a is before the second occurrence of b.
 * s will contain at least one letter that appears twice.
 *
 *
 * Example 1:
 *
 * Input: s = "abccbaacz"
 * Output: "c"
 * Explanation:
 * The letter 'a' appears on the indexes 0, 5 and 6.
 * The letter 'b' appears on the indexes 1 and 4.
 * The letter 'c' appears on the indexes 2, 3 and 7.
 * The letter 'z' appears on the index 8.
 * The letter 'c' is the first letter to appear twice, because out of all the letters the index of its second occurrence is the smallest.
 * Example 2:
 *
 * Input: s = "abcdd"
 * Output: "d"
 * Explanation:
 * The only letter that appears twice is 'd' so we return 'd'.
 *
 *
 * Constraints:
 *
 * 2 <= s.length <= 100
 * s consists of lowercase English letters.
 * s has at least one repeated letter.
 */

class LC2351FirstLetterToAppearTwice {
    fun repeatedCharacter(s: String): Char {
        // We can start loop over the s chars and put the char into a set to check back later
        // In each step, if we've seen the char, then return it as the ans
        // Otherwise, add it to the set and move to the next char

        val set = mutableSetOf<Char>()

        for (char in s) {
            // If set.add(char) returns false, it means we haven't seen the char,
            // Otherwise, this char is already in the set and the new char is a duplicated and return it as answer
            if (!set.add(char)) {
                return char
            }
        }

        return ' '
    }
}