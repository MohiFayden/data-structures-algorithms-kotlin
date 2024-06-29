package stack_queue

/**
 * 2434. Using a Robot to Print the Lexicographically Smallest String
 *
 * Medium
 *
 * You are given a string s and a robot that currently holds an empty string t. Apply one of the following operations until s and t are both empty:
 *
 * Remove the first character of a string s and give it to the robot. The robot will append this character to the string t.
 * Remove the last character of a string t and give it to the robot. The robot will write this character on paper.
 * Return the lexicographically smallest string that can be written on the paper.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "zza"
 * Output: "azz"
 * Explanation: Let p denote the written string.
 * Initially p="", s="zza", t="".
 * Perform first operation three times p="", s="", t="zza".
 * Perform second operation three times p="azz", s="", t="".
 * Example 2:
 *
 * Input: s = "bac"
 * Output: "abc"
 * Explanation: Let p denote the written string.
 * Perform first operation twice p="", s="c", t="ba".
 * Perform second operation twice p="ab", s="c", t="".
 * Perform first operation p="ab", s="", t="c".
 * Perform second operation p="abc", s="", t="".
 * Example 3:
 *
 * Input: s = "bdda"
 * Output: "addb"
 * Explanation: Let p denote the written string.
 * Initially p="", s="bdda", t="".
 * Perform first operation four times p="", s="", t="bdda".
 * Perform second operation four times p="addb", s="", t="".
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 105
 * s consists of only English lowercase letters.
 */

class LC2434UsingARobotToPrintTheLexicographicallySmallestString {
    fun robotWithString(s: String): String {

        // Intuition:
        // The goal is to create the smallest possible lexicographical string by manipulating the input string `s`.
        // We use a deque `t` to temporarily store characters from `s` and a StringBuilder `p` to construct the final result.
        // The key insight is to maintain a "minSuffix" array that keeps track of the smallest character from the current
        // position to the end of the string. This helps in deciding when to move characters from `t` to `p`.

        val n = s.length
        val t = ArrayDeque<Char>()  // Deque to store characters temporarily
        val p = StringBuilder()  // StringBuilder for the final result

        // This array stores the minimum character from any position i to the end of the string
        val minSuffix = CharArray(n)
        minSuffix[n - 1] = s[n - 1]

        // Populate the minSuffix array
        for (i in n - 2 downTo 0) {
            minSuffix[i] = minOf(s[i], minSuffix[i + 1])
        }

        println()
        minSuffix.forEach { print(it) }
        println()

        for (i in 0..<n) {

            // Check if we can remove characters from t and append to p
            // We can only move characters from `t` to `p` if the last character in `t` is not greater than
            // the smallest character in the remaining part of `s` (tracked by `minSuffix`).
            while (t.isNotEmpty() && t.last() <= minSuffix[i]) {
                p.append(t.removeLast())
            }

            // Add current character from s to the end of the deque t
            t.addLast(s[i])
        }

        // Append any remaining characters in `t` to `p`
        // This ensures that all characters are moved to the final result string.
        while (t.isNotEmpty()) {
            p.append(t.removeLast())
        }

        return p.toString()
    }
}