package arrays_and_strings

/**
 * 557. Reverse Words in a String III
 *
 * Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 * Example 2:
 *
 * Input: s = "Mr Ding"
 * Output: "rM gniD"
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 5 * 104
 * s contains printable ASCII characters.
 * s does not contain any leading or trailing spaces.
 * There is at least one word in s.
 * All the words in s are separated by a single space.
 */

class LC557ReverseWordsInAStringIII {
    fun reverseWords(s: String): String {

        // Change the string to CharArray to be able to operate the reverse inplace
        var char = s.toCharArray()

        var startIndex = 0
        var endIndex = 0
        var spaceIndex = 0

        while (spaceIndex <= s.length) {

            // Continue untill we found a space or we reach the end of string
            if (spaceIndex < s.length && s[spaceIndex] != ' ') {
                spaceIndex++
                continue
            }

            endIndex = spaceIndex - 1

            while (startIndex < endIndex) {
                val temp = char[startIndex]
                char[startIndex] = char[endIndex]
                char[endIndex] = temp
                startIndex++
                endIndex--
            }
            spaceIndex++
            startIndex = spaceIndex
        }

        return char.concatToString()
    }
}