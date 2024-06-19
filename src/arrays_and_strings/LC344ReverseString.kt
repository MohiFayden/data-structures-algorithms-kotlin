package arrays_and_strings

/**
 * 344. Reverse String
 *
 * Write a function that reverses a string. The input string is given as an array of characters s.
 *
 * You must do this by modifying the input array in-place with O(1) extra memory.
 *
 *
 * Example 1:
 *
 * Input: s = ["h","e","l","l","o"]
 * Output: ["o","l","l","e","h"]
 * Example 2:
 *
 * Input: s = ["H","a","n","n","a","h"]
 * Output: ["h","a","n","n","a","H"]
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 105
 * s[i] is a printable ascii character.
 */

class LC344ReverseString {
    fun reverseString(s: CharArray): Unit {
        // s = ["h","e","l","l","o"]
        // reverse: ["o","l","l","e","h"]

        // We can set two pointers at the begening and at the end of the string and start swapping them
        var left = 0
        var right = s.size - 1

        while(left < right){
            swap(s, left, right)
            left++
            right--
        }
    }

    private fun swap(s: CharArray, i: Int, j: Int){
        val temp = s[i]
        s[i] = s[j]
        s[j] = temp
    }
}