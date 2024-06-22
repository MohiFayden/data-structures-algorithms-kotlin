package hashing

/**
 * 1. Two Sum
 *
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * You can return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 * Example 2:
 *
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * Example 3:
 *
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 *
 *
 * Constraints:
 *
 * 2 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * Only one valid answer exists.
 *
 *
 * Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?
 */

class LC1TwoSum {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        // [2,7,11,15], target = 9 -> [0,1]
        // [3,2,4], target = 6 -> [1,2]

        // Algorithm:
        // We can keep the diff between the current item and the target
        //   and if we see that diff in the rest of the list, we return the index of the current item
        //   and the original of the diff
        // - Define a hash table to keep track of the diff and the index of the diff
        // 1- Loop on the nums
        // 2- For each item, if we see the value is equal to diff, return the index of the current item and the original of diff
        // 3- If we didn't find the diff, return and empty array

        val map = mutableMapOf<Int, Int>()
        for (i in nums.indices) {
            if (map.contains(target - nums[i])) {
                return intArrayOf(map[target - nums[i]]!!, i)
            }
            map[nums[i]] = i
        }

        return intArrayOf()
    }
}