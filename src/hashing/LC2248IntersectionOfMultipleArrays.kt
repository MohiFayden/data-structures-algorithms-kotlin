package hashing

/**
 * 2248. Intersection of Multiple Arrays
 *
 * Given a 2D integer array nums where nums[i] is a non-empty array of distinct positive integers, return the list of integers that are present in each array of nums sorted in ascending order.
 *
 *
 * Example 1:
 *
 * Input: nums = [[3,1,2,4,5],[1,2,3,4],[3,4,5,6]]
 * Output: [3,4]
 * Explanation:
 * The only integers present in each of nums[0] = [3,1,2,4,5], nums[1] = [1,2,3,4], and nums[2] = [3,4,5,6] are 3 and 4, so we return [3,4].
 * Example 2:
 *
 * Input: nums = [[1,2,3],[4,5,6]]
 * Output: []
 * Explanation:
 * There does not exist any integer present both in nums[0] and nums[1], so we return an empty list [].
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 1000
 * 1 <= sum(nums[i].length) <= 1000
 * 1 <= nums[i][j] <= 1000
 * All the values of nums[i] are unique.
 */

class LC2248IntersectionOfMultipleArrays {
    fun intersection(nums: Array<IntArray>): List<Int> {

        // We can use a map to count the number of occurrences for each element
        // Iterate over the nums and then for each, element (row) iterate over the row
        // In each element of the row, increment the count for that element
        // At the end, return the items in which the size of the count is equal to the nums.size which means that the number is presented in all the inner arrays

        val map = mutableMapOf<Int, Int>()

        nums.forEach { row ->
            row.forEach { num ->
                map[num] = (map[num] ?: 0) + 1
            }
        }

        return map.filterValues { it == nums.size }.keys.sorted()
    }
}