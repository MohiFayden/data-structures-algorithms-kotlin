package hashing

import kotlin.math.max

/**
 * 2342. Max Sum of a Pair With Equal Sum of Digits
 *
 * You are given a 0-indexed array nums consisting of positive integers. You can choose two indices i and j, such that i != j, and the sum of digits of the number nums[i] is equal to that of nums[j].
 *
 * Return the maximum value of nums[i] + nums[j] that you can obtain over all possible indices i and j that satisfy the conditions.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [18,43,36,13,7]
 * Output: 54
 * Explanation: The pairs (i, j) that satisfy the conditions are:
 * - (0, 2), both numbers have a sum of digits equal to 9, and their sum is 18 + 36 = 54.
 * - (1, 4), both numbers have a sum of digits equal to 7, and their sum is 43 + 7 = 50.
 * So the maximum sum that we can obtain is 54.
 * Example 2:
 *
 * Input: nums = [10,12,19,14]
 * Output: -1
 * Explanation: There are no two numbers that satisfy the conditions, so we return -1.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 109
 */

class LC2342MaxSumOfAPairWithEqualSumOfDigits {
    fun maximumSum(nums: IntArray): Int {

        // Iterate over the nums
        // Calculate the sum of digits for each element
        // We're going to put it on a map to visit it later (If we see any number with the same sum of digits)
        // If we already have such a sum in the map, try to sum up that element with the current and update the answer
        // Put the number in the map (If we already have a number that sum is the same, put the one which is bigger to satisfy the answer in the future)

        return approach1(nums)
        // return approach2(nums)
    }


    //----------Approach1----------
    private fun approach1(nums: IntArray): Int {
        if (nums.size < 2) return -1

        var ans = -1
        val map = mutableMapOf<Int, Int>()

        nums.forEach { num ->
            val sum = sumOfDigits(num)
            if (map.contains(sum)) {
                ans = max(ans, map[sum]!! + num)
            }

            map[sum] = max(map[sum] ?: 0, num)
        }

        return ans
    }


    //----------Approach2----------
    private fun approach2(nums: IntArray): Int {
        if (nums.size < 2) return -1

        var ans = -1
        val map = mutableMapOf<Int, MutableList<Int>>()

        nums.forEach { num ->
            val sum = sumOfDigits(num)
            map[sum] = map[sum] ?: mutableListOf()
            map[sum]!!.add(num)
        }

        map.values.forEach { list ->
            val temp = list.sorted().reversed()
            if (temp.size > 1) {
                ans = max(ans, temp[0] + temp[1])
            }
        }

        return ans
    }

    private fun sumOfDigits(num: Int): Int {
        var sum = 0
        var remainedNum = num
        while (remainedNum > 0) {
            sum += remainedNum % 10
            remainedNum /= 10
        }
        return sum
    }
}