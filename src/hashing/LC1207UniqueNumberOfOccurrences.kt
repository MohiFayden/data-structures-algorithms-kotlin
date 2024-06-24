package hashing

/**
 * 1207. Unique Number of Occurrences
 *
 * Given an array of integers arr, return true if the number of occurrences of each value in the array is unique or false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = [1,2,2,1,1,3]
 * Output: true
 * Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1. No two values have the same number of occurrences.
 * Example 2:
 *
 * Input: arr = [1,2]
 * Output: false
 * Example 3:
 *
 * Input: arr = [-3,0,1,-3,1,1,1,-3,10,0]
 * Output: true
 *
 *
 * Constraints:
 *
 * 1 <= arr.length <= 1000
 * -1000 <= arr[i] <= 1000
 */

class LC1207UniqueNumberOfOccurrences {
    fun uniqueOccurrences(arr: IntArray): Boolean {

        // Define a hash table to count the frequency of each element and start iterating over the arr
        // Define a Set to check the frequencies to be unique
        // Iterate over the values of the count, and add them to the set, if we've already seen any value, that's not unique and return false

        val counts = mutableMapOf<Int, Int>()
        val seen = mutableSetOf<Int>()

        arr.forEach { element ->
            counts[element] = (counts[element] ?: 0) + 1
        }

        counts.values.forEach { count ->
            if (!seen.add(count)) return false
        }

        return true
    }
}