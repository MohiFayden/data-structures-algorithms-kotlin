package tree

/**
 * 113. Path Sum II
 *
 * Medium
 *
 * Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where the sum of the node values in the path equals targetSum. Each path should be returned as a list of the node values, not node references.
 *
 * A root-to-leaf path is a path starting from the root and ending at any leaf node. A leaf is a node with no children.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * Output: [[5,4,11,2],[5,8,4,5]]
 * Explanation: There are two paths whose sum equals targetSum:
 * 5 + 4 + 11 + 2 = 22
 * 5 + 8 + 4 + 5 = 22
 * Example 2:
 *
 *
 * Input: root = [1,2,3], targetSum = 5
 * Output: []
 * Example 3:
 *
 * Input: root = [1,2], targetSum = 0
 * Output: []
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 5000].
 * -1000 <= Node.val <= 1000
 * -1000 <= targetSum <= 1000
 */

/**
 * Example usage:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class LC113PathSumII {
    fun pathSum(root: TreeNode?, targetSum: Int): List<List<Int>> {

        // Intuition and algorithm:
        // We can use Depth-First Search (DFS) to explore all possible paths from the root to the leaves.
        // We'll maintain a running sum (prevSum) of the values along the current path.
        // For each node, we update the current sum (currSum) by adding the node's value.
        // If we reach a leaf node (a node with no children) and currSum equals targetSum, we add the current path to our results.
        // We use backtracking to explore different paths: after exploring both children of a node, we remove the current node's value from the path to backtrack.

        val ans = mutableListOf<List<Int>>()

        // Helper function to perform DFS
        fun dfs(node: TreeNode?, prevSum: Int, path: MutableList<Int>) {
            if (node == null) return

            // Add current node's value to the path
            path.add(node.`val`)
            // Calculate the current sum
            val currSum = prevSum + node.`val`

            // Check if it's a leaf node and the current sum equals the target sum
            if (node.left == null && node.right == null && currSum == targetSum) {
                // Add a copy of the current path to the answer list
                ans.add(path.toList())
            } else {
                // Continue DFS on the left and right subtrees
                dfs(node.left, currSum, path)
                dfs(node.right, currSum, path)
            }

            // Backtrack: remove the current node's value from the path
            path.removeAt(path.size - 1)
        }

        // Start DFS from the root node with an initial sum of 0 and an empty path
        dfs(root, 0, mutableListOf())

        return ans
    }
}