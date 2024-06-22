package hashing

/**
 * 268. Missing Number
 *
 * Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [3,0,1]
 * Output: 2
 * Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.
 * Example 2:
 *
 * Input: nums = [0,1]
 * Output: 2
 * Explanation: n = 2 since there are 2 numbers, so all numbers are in the range [0,2]. 2 is the missing number in the range since it does not appear in nums.
 * Example 3:
 *
 * Input: nums = [9,6,4,2,3,5,7,0,1]
 * Output: 8
 * Explanation: n = 9 since there are 9 numbers, so all numbers are in the range [0,9]. 8 is the missing number in the range since it does not appear in nums.
 *
 *
 * Constraints:
 *
 * n == nums.length
 * 1 <= n <= 104
 * 0 <= nums[i] <= n
 * All the numbers of nums are unique.
 *
 *
 * Follow up: Could you implement a solution using only O(1) extra space complexity and O(n) runtime complexity?
 */

class LC268MissingNumber {
    fun missingNumber(nums: IntArray): Int {
        // 1: Set
        // Easiest way is to store the nums in a set
        // Loop over the 0...n which is equal to nums.size
        // In each step, if we don't see the number in the set, that's the missign number

        // 2: Sum
        // A better way to prevent O(n) space complexity is to calculate the sum of 0...n
        // Then, calculate the sum of the nums
        // The difference will be the missing number

        return useSum(nums)
        // return useSet(nums)
    }


    //----------Sum--------
    private fun useSum(nums: IntArray): Int {
        // We can use the n(n+1)/2 formula instead of loop to calculate the 0...n sum

        val n = nums.size
        val target = n * (n + 1) / 2
        var sum = 0
        nums.forEach { num ->
            sum += num
        }

        return target - sum
    }


    //---------Set----------
    private fun useSet(nums: IntArray): Int {

        val set = mutableSetOf<Int>()

        nums.forEach { num ->
            set.add(num)
        }

        for (i in 0..nums.size) {
            if (!set.contains(i)) {
                return i
            }
        }

        return -1
    }
}