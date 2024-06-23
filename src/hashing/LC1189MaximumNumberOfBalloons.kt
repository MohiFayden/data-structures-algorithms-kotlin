package hashing

import kotlin.math.min

/**
 * 1189. Maximum Number of Balloons
 *
 * Given a string text, you want to use the characters of text to form as many instances of the word "balloon" as possible.
 *
 * You can use each character in text at most once. Return the maximum number of instances that can be formed.
 *
 * Example 1:
 *
 *
 * Input: text = "nlaebolko"
 * Output: 1
 * Example 2:
 *
 *
 *
 * Input: text = "loonbalxballpoon"
 * Output: 2
 * Example 3:
 *
 * Input: text = "leetcode"
 * Output: 0
 *
 *
 * Constraints:
 *
 * 1 <= text.length <= 104
 * text consists of lower case English letters only.
 */

class LC1189MaximumNumberOfBalloons {
    fun maxNumberOfBalloons(text: String): Int {

        // 1- Simple counting:
        // Set 5 counter to track the balons occurrences
        // Iterate over the text and increment the counters when seeing any of them
        // Divide the l and o counters by two as we have 2 of them in the balloon
        // At the end, return the minimum of the counters which we can build balloon words with it

        // 2- Hash table
        // Define a hash table to keep the count of each character
        // Iterate over the text, and increment the counter
        // Next, iterate over the counts, for each iteration if we have enough char to build the balloon, increment ans
        // Otherwise, exit and return the ans

        return counting1(text)
        // return counting2(text)
    }


    //----------Counting1----------
    private fun counting1(text: String): Int {
        var bCount = 0
        var aCount = 0
        var lCount = 0
        var oCount = 0
        var nCount = 0

        text.forEach { char ->
            when (char) {
                'b' -> bCount++
                'a' -> aCount++
                'l' -> lCount++
                'o' -> oCount++
                'n' -> nCount++
            }
        }

        lCount /= 2
        oCount /= 2

        return min(bCount, min(min(aCount, lCount), min(oCount, nCount)))
    }


    //----------Counting2----------
    private fun counting2(text: String): Int {
        val counts = mutableMapOf(
            'b' to 0,
            'a' to 0,
            'l' to 0,
            'o' to 0,
            'n' to 0
        )

        text.forEach { char ->
            if (counts.contains(char)) {
                counts[char] = counts[char]!! + 1
            }
        }

        var ans = 0
        var isValid = true
        while (isValid) {
            for (item in counts) {
                when (item.key) {
                    'b', 'a', 'n' -> {
                        if (item.value >= 1) {
                            counts[item.key] = counts[item.key]!! - 1
                        } else {
                            isValid = false
                        }
                    }

                    'l', 'o' -> {
                        if (item.value >= 2) {
                            counts[item.key] = counts[item.key]!! - 2
                        } else {
                            isValid = false
                        }
                    }
                }
            }

            if (isValid) {
                ans++
            }
        }

        return ans
    }
}