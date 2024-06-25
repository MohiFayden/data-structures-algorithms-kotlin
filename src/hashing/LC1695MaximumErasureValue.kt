package hashing

import kotlin.math.max

/**
 * 1695. Maximum Erasure Value
 *
 * You are given an array of positive integers nums and want to erase a subarray containing unique elements. The score you get by erasing the subarray is equal to the sum of its elements.
 *
 * Return the maximum score you can get by erasing exactly one subarray.
 *
 * An array b is called to be a subarray of a if it forms a contiguous subsequence of a, that is, if it is equal to a[l],a[l+1],...,a[r] for some (l,r).
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [4,2,4,5,6]
 * Output: 17
 * Explanation: The optimal subarray here is [2,4,5,6].
 * Example 2:
 *
 * Input: nums = [5,2,1,2,5,2,1,2,5]
 * Output: 8
 * Explanation: The optimal subarray here is [5,2,1] or [1,2,5].
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 104
 */

class LC1695MaximumErasureValue {
    fun maximumUniqueSubarray(nums: IntArray): Int {

        // Since we're dealing with the subarrays and positive integers, we can use
        //      Prefix sum to calculate the sum of the subarray in place (O(1))
        //      Sliding window (two pointers) technique
        //      Set to check the unique elements
        // Start expanding the window by incrementing the right pointer
        // Add the element to the set to check it later to make sure it's unique
        // If the current element is already in the set, collapse the window by incrementing the left pointer
        //      Do this and remove the leftmost item from the Set until the window is valid

        val prefix = IntArray(nums.size)
        var left = 0
        val seen = mutableSetOf<Int>()
        var ans = 0

        // Build the prefix sum
        prefix[0] = nums[0]
        for (i in 1..<nums.size) {
            prefix[i] = nums[i] + prefix[i - 1]
        }

        for ((right, num) in nums.withIndex()) {
            // If we have a duplicated in the list, collapse and remove it
            while (seen.contains(num)) {
                seen.remove(nums[left])
                left++
            }

            ans = max(ans, prefix[right] - prefix[left] + nums[left])
            seen.add(num)
        }

        return ans
    }
}