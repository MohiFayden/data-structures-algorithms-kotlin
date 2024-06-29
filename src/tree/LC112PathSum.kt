package tree

/**
 * 112. Path Sum
 *
 * Easy
 *
 * Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.
 *
 * A leaf is a node with no children.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
 * Output: true
 * Explanation: The root-to-leaf path with the target sum is shown.
 * Example 2:
 *
 *
 * Input: root = [1,2,3], targetSum = 5
 * Output: false
 * Explanation: There two root-to-leaf paths in the tree:
 * (1 --> 2): The sum is 3.
 * (1 --> 3): The sum is 4.
 * There is no root-to-leaf path with sum = 5.
 * Example 3:
 *
 * Input: root = [], targetSum = 0
 * Output: false
 * Explanation: Since the tree is empty, there are no root-to-leaf paths.
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 5000].
 * -1000 <= Node.val <= 1000
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
class LC112PathSum {
    fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {
        // Choose either the recursive or iterative approach to solve the problem
        // return recursively(root, targetSum)
        return iteratively(root, targetSum)
    }

    //-----------------Recursively------------------
    private fun recursively(root: TreeNode?, targetSum: Int): Boolean {
        // Helper function to perform Depth-First Search (DFS) recursively
        fun dfs(node: TreeNode?, curr: Int): Boolean {
            // If the node is null, there is no path, so return false
            if (node == null) return false

            // Update the current sum by adding the node's value
            val sum = curr + node.`val`

            // If the node is a leaf node (no children), check if the current sum equals targetSum
            if (node.left == null && node.right == null) return sum == targetSum

            // Recursively check the left and right subtrees
            val left = dfs(node.left, sum)
            val right = dfs(node.right, sum)

            // Return true if any path in the left or right subtree has the required sum
            return left || right
        }

        // Start DFS from the root with an initial sum of 0
        return dfs(root, 0)
    }

    //-----------------Iteratively------------------
    private fun iteratively(root: TreeNode?, targetSum: Int): Boolean {
        // If the root is null, there is no path, so return false
        if (root == null) return false

        // Stack to store pairs of TreeNode and the current path sum
        val stack = ArrayDeque<Pair<TreeNode, Int>>()

        // Initialize the stack with the root node and initial sum of 0
        stack.addLast(root to 0)

        // Perform iterative DFS using the stack
        while (stack.isNotEmpty()) {
            // Pop the top element from the stack
            var (node, curr) = stack.removeLast()

            // Update the current sum by adding the node's value
            curr += node.`val`

            // If the node is a leaf node, check if the current sum equals targetSum
            if (node.left == null && node.right == null) {
                if (curr == targetSum) return true
            }

            // If there is a left child, add it to the stack with the updated sum
            if (node.left != null) stack.addLast(node.left!! to curr)

            // If there is a right child, add it to the stack with the updated sum
            if (node.right != null) stack.addLast(node.right!! to curr)
        }

        // If no path sum equals targetSum, return false
        return false
    }
}