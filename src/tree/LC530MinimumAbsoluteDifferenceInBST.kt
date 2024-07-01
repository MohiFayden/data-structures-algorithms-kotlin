package tree

/**
 * 530. Minimum Absolute Difference in BST
 *
 * Easy
 *
 * Given the root of a Binary Search Tree (BST), return the minimum absolute difference between the values of any two different nodes in the tree.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [4,2,6,1,3]
 * Output: 1
 * Example 2:
 *
 *
 * Input: root = [1,0,48,null,null,12,49]
 * Output: 1
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [2, 104].
 * 0 <= Node.val <= 105
 *
 *
 * Note: This question is the same as 783: https://leetcode.com/problems/minimum-distance-between-bst-nodes/
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
class LC530MinimumAbsoluteDifferenceInBST {
    fun getMinimumDifference(root: TreeNode?): Int {

        // Intuition and algorithm:
        // We can put all the values in a list
        // To avoid bruteforce which leads to O(n^2) time complexity
        // we can sort the nodes in a list to calculate the min difference
        // We can leverage the BST to gain the O(n) time complexity for
        // sorting as the in-order dfs on a bst will give us the sorted values in O(n) time

        val list = mutableListOf<Int>() // To collect the nodes
        var ans = Int.MAX_VALUE

        // Perform in-order DFS to collect the sorted values
        fun dfs(node: TreeNode?) {
            if (node == null) return

            dfs(node.left)
            list.add(node.`val`)
            dfs(node.right)
        }

        dfs(root)

        // Check the adjacent items to find the minimum answer
        // Since the list is sorted, the minimum difference will be between two adjacent elements
        for (i in 0..<list.size - 1) {
            ans = minOf(ans, list[i + 1] - list[i])
        }

        return ans
    }
}