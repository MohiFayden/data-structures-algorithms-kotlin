package tree

import kotlin.math.max

/**
 * 104. Maximum Depth of Binary Tree
 *
 * Easy
 *
 * Given the root of a binary tree, return its maximum depth.
 *
 * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 3
 * Example 2:
 *
 * Input: root = [1,null,2]
 * Output: 2
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 104].
 * -100 <= Node.val <= 100
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
class LC104MaximumDepthOfBinaryTree {

    fun maxDepth(root: TreeNode?): Int {
        // Choose to find the maximum depth either recursively or iteratively
        return dfs(root) // Recursive approach
        // return iteratively(root) // Iterative approach
    }

    //----------Recursively--------------
    // Recursive Depth-First Search (DFS) approach to find maximum depth
    private fun dfs(root: TreeNode?): Int {
        // Base case: if the node is null, the depth is 0
        if (root == null) return 0

        // Recursively find the depth of the left and right subtrees
        val left = dfs(root.left)
        val right = dfs(root.right)

        // The maximum depth at the current node is the greater of the two subtrees' depths plus one (for the current node level)
        return max(left, right) + 1 // 1 is the current level
    }

    //----------Iteratively--------------
    // Iterative approach using a stack to find the maximum depth
    private fun iteratively(root: TreeNode?): Int {
        // If the tree is empty, the depth is 0
        if (root == null) return 0

        // Stack to store pairs of tree nodes and their corresponding depth
        val stack = ArrayDeque<Pair<TreeNode, Int>>()
        var ans = 0

        // Initialize the stack with the root node and its depth (1)
        stack.addLast(root to 1)

        // Perform Depth-First Search iteratively
        while (stack.isNotEmpty()) {
            // Pop a node and its depth from the stack
            val (node, depth) = stack.removeLast()

            // If the node has a left child, push it to the stack with depth +1
            if (node.left != null) stack.addLast(node.left to depth + 1)
            // If the node has a right child, push it to the stack with depth +1
            if (node.right != null) stack.addLast(node.right to depth + 1)

            // Update the maximum depth found so far
            ans = max(ans, depth)
        }

        // Return the maximum depth found
        return ans
    }
}