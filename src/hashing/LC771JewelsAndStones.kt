package hashing

/**
 * 771. Jewels and Stones
 *
 * You're given strings jewels representing the types of stones that are jewels, and stones representing the stones you have. Each character in stones is a type of stone you have. You want to know how many of the stones you have are also jewels.
 *
 * Letters are case sensitive, so "a" is considered a different type of stone from "A".
 *
 *
 *
 * Example 1:
 *
 * Input: jewels = "aA", stones = "aAAbbbb"
 * Output: 3
 * Example 2:
 *
 * Input: jewels = "z", stones = "ZZ"
 * Output: 0
 *
 *
 * Constraints:
 *
 * 1 <= jewels.length, stones.length <= 50
 * jewels and stones consist of only English letters.
 * All the characters of jewels are unique.
 */

class LC771JewelsAndStones {
    fun numJewelsInStones(jewels: String, stones: String): Int {

        // One of the simplest ways is to use a set (seen) to store the jewels
        // Then, we can check a stone if it's a jewel or not in O(1)
        // Iterate over the jewels, and put them in a set
        // Iterate over the stones, for each element, if it's in the set, increment the answer

        return useSet(jewels, stones)
        // return simpleCounting(jewels, stones)
    }

    //----------Hash Table - Set-----------------
    private fun useSet(jewels: String, stones: String): Int {
        var ans = 0
        val seen = mutableSetOf<Char>()

        jewels.forEach { char -> seen.add(char) }

        stones.forEach { stone ->
            if (seen.contains(stone)) {
                ans++
            }
        }

        return ans
    }

    //----------Counting----------
    private fun simpleCounting(jewels: String, stones: String): Int {
        var ans = 0
        stones.forEach { char ->
            val index = jewels.indexOf(char)
            if (index != -1) {
                ans++
            }
        }
        return ans
    }
}