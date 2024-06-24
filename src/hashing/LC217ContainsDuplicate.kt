package hashing

/**
 * 217. Contains Duplicate
 *
 * Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,1]
 * Output: true
 * Example 2:
 *
 * Input: nums = [1,2,3,4]
 * Output: false
 * Example 3:
 *
 * Input: nums = [1,1,1,3,3,4,3,2,4,2]
 * Output: true
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 */

class LC217ContainsDuplicate {
    fun containsDuplicate(nums: IntArray): Boolean {

        // We can define a set (seen) to collect the seen elements
        // Iterate over the nums and put them in the seen
        // At any step, before putting the item in the seen, if we already saw that item, return true

        return checkWithSet(nums)
        // return checkWithSorting(nums)
    }


    //--------------------------------------------
    // Using hash set with time complexity of O(n) and Space complexity of O(n)
    private fun checkWithSet(nums: IntArray): Boolean {
        val set = mutableSetOf<Int>()
        nums.forEach { item ->
            if (set.contains(item)) {
                return true
            }
            set.add(item)
        }
        return false
    }


    //--------------------------------------------
    // Using sorting with the time complexity of (Sorting) and space complexity of (Sorting)
    private fun checkWithSorting(nums: IntArray): Boolean {
        nums.sort()
        for (i in 0..<nums.size - 1) {
            if (nums[i] == nums[i + 1]) {
                return true
            }
        }
        return false
    }
}