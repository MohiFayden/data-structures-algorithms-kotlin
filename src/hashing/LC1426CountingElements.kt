package hashing

/**
 * 1426. Counting Elements
 *
 * Given an integer array arr, count how many elements x there are, such that x + 1 is also in arr. If there are duplicates in arr, count them separately.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = [1,2,3]
 * Output: 2
 * Explanation: 1 and 2 are counted cause 2 and 3 are in arr.
 * Example 2:
 *
 * Input: arr = [1,1,3,3,5,5,7,7]
 * Output: 0
 * Explanation: No numbers are counted, cause there is no 2, 4, 6, or 8 in arr.
 *
 *
 * Constraints:
 *
 * 1 <= arr.length <= 1000
 * 0 <= arr[i] <= 1000
 */

class LC1426CountingElements {
    fun countElements(arr: IntArray): Int {

        // We can put the elements in a set to visit them later in o(1) time complexity
        // We iterate over the arr, for each element x if the x+1 is in the set, increment the counter

        val set = mutableSetOf<Int>()
        var counter = 0
        arr.forEach { x -> set.add(x) }

        arr.forEach { x ->
            if (set.contains(x + 1)) counter++
        }

        return counter
    }
}