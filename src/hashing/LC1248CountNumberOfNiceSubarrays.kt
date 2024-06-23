package hashing

/**
 * 1248. Count Number of Nice Subarrays
 *
 * Given an array of integers nums and an integer k. A continuous subarray is called nice if there are k odd numbers on it.
 *
 * Return the number of nice sub-arrays.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,2,1,1], k = 3
 * Output: 2
 * Explanation: The only sub-arrays with 3 odd numbers are [1,1,2,1] and [1,2,1,1].
 * Example 2:
 *
 * Input: nums = [2,4,6], k = 1
 * Output: 0
 * Explanation: There are no odd numbers in the array.
 * Example 3:
 *
 * Input: nums = [2,2,2,1,2,2,1,2,2,2], k = 2
 * Output: 16
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 50000
 * 1 <= nums[i] <= 10^5
 * 1 <= k <= nums.length
 */

class LC1248CountNumberOfNiceSubarrays {
    fun numberOfSubarrays(nums: IntArray, k: Int): Int {

        // We can use the prefix sum technique here but, instead of the sum of numbers, we can build the number of odds
        //If the modulus of a number is 0, it's even, otherwise, it's 1 which is odd
        // Count the (num % 2) at each index to see how many odd numbers we have up to this index
        // If we put this count in a map or increment if we already have it which means we continue the subarray on the even numbers-
        //      -we know how many nice subarrays we have at each index

        val counts = mutableMapOf<Int, Int>()

        var curr = 0
        var ans = 0
        counts[0] = 1

        for (num in nums) {
            curr += num % 2
            ans += counts[curr - k] ?: 0
            counts[curr] = (counts[curr] ?: 0) + 1
        }

        return ans
    }
}