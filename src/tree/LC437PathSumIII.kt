package tree

/**
 * 437. Path Sum III
 *
 * Medium
 *
 * Given the root of a binary tree and an integer targetSum, return the number of paths where the sum of the values along the path equals targetSum.
 *
 * The path does not need to start or end at the root or a leaf, but it must go downwards (i.e., traveling only from parent nodes to child nodes).
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
 * Output: 3
 * Explanation: The paths that sum to 8 are shown.
 * Example 2:
 *
 * Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * Output: 3
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 1000].
 * -109 <= Node.val <= 109
 * -1000 <= targetSum <= 1000
 */

/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class LC437PathSumIII {
    fun pathSum(root: TreeNode?, targetSum: Int): Int {

        // Intuition:
        // We need to find paths that sum to targetSum, regardless of whether they start or end at root or leaf.
        // We will use prefix sums to make this process efficient.
        // A HashMap will track the frequency of each prefix sum encountered.
        // For each node, we check if (current prefix sum - targetSum) exists in the map.
        // If so, it means there is a subpath ending at the current node that sums to targetSum.

        // HashMap to store the frequency of prefix sums
        val counts = mutableMapOf<Long, Int>()
        var ans = 0

        // Helper function for DFS traversal
        fun dfs(node: TreeNode?, prefix: Long) {
            if (node == null) return

            val currSum = prefix + node.`val`

            // If current prefix sum equals targetSum, increment the count
            if (currSum == targetSum.toLong()) ans++

            // Check if there exists a prefix sum such that the difference equals targetSum
            ans += counts[currSum - targetSum] ?: 0

            // Update the HashMap with the current prefix sum
            counts[currSum] = (counts[currSum] ?: 0) + 1

            // Recursively call DFS on left and right subtrees
            dfs(node.left, currSum)
            dfs(node.right, currSum)

            // Backtrack: Decrement the frequency of the current prefix sum
            // This step is crucial for exploring other paths without interference
            counts[currSum] = counts[currSum]!! - 1
        }

        // Start DFS from the root with initial prefix sum 0
        dfs(root, 0)

        return ans
    }
}