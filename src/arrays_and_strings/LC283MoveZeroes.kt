package arrays_and_strings

/**
 * 283. Move Zeroes
 * 
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 *
 * Note that you must do this in-place without making a copy of the array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * Example 2:
 *
 * Input: nums = [0]
 * Output: [0]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 104
 * -231 <= nums[i] <= 231 - 1
 *
 *
 * Follow up: Could you minimize the total number of operations done?
 */

class LC283MoveZeroes {
    fun moveZeroes(nums: IntArray): Unit {

        // We can skip the zeros and try to put the non-zeros after each other
        // If we count the non-zeros, then we have the position that the zeros should be started

        var index = 0 // non-zero counter or the start of the zeros

        nums.asSequence()

        for (num in nums) {
            if (num != 0) {
                nums[index] = num
                index++
            }
        }

        for (i in index..<nums.size) {
            nums[i] = 0
        }
    }
}