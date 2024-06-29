package stack_queue

import kotlin.collections.ArrayDeque

/**
 * 739. Daily Temperatures
 *
 * Medium
 *
 * Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.
 *
 *
 *
 * Example 1:
 *
 * Input: temperatures = [73,74,75,71,69,72,76,73]
 * Output: [1,1,4,2,1,1,0,0]
 * Example 2:
 *
 * Input: temperatures = [30,40,50,60]
 * Output: [1,1,1,0]
 * Example 3:
 *
 * Input: temperatures = [30,60,90]
 * Output: [1,1,0]
 *
 *
 * Constraints:
 *
 * 1 <= temperatures.length <= 105
 * 30 <= temperatures[i] <= 100
 */

class LC739DailyTemperatures {
    fun dailyTemperatures(temperatures: IntArray): IntArray {
        // Create a stack to store indices of the temperatures array
        val stack = ArrayDeque<Int>()
        // Initialize the result array with the same size as the input array
        val ans = IntArray(temperatures.size)

        // Iterate through each temperature in the input array
        for (i in temperatures.indices) {
            // While stack is not empty and the current temperature is greater than
            // the temperature at the index stored at the top of the stack
            while (stack.isNotEmpty() && temperatures[stack.last()] < temperatures[i]) {
                // Pop the index from the stack
                val j = stack.removeLast()
                // The difference between the current index and the popped index
                // is the number of days until a warmer temperature
                ans[j] = i - j
            }
            // Push the current index onto the stack
            stack.addLast(i)
        }
        // Return the result array containing the number of days to wait for a warmer temperature
        return ans
    }
}
