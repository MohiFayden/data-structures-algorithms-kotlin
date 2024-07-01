package tree

/**
 * 1305. All Elements in Two Binary Search Trees
 *
 * Medium
 *
 * Given two binary search trees root1 and root2, return a list containing all the integers from both trees sorted in ascending order.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root1 = [2,1,4], root2 = [1,0,3]
 * Output: [0,1,1,2,3,4]
 * Example 2:
 *
 *
 * Input: root1 = [1,null,8], root2 = [8,1]
 * Output: [1,1,8,8]
 *
 *
 * Constraints:
 *
 * The number of nodes in each tree is in the range [0, 5000].
 * -105 <= Node.val <= 105
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
class LC1305AllElementsInTwoBinarySearchTrees {
    fun getAllElements(root1: TreeNode?, root2: TreeNode?): List<Int> {

        // Intuition:
        // We have two BSTs. By performing in-order DFS on each tree, we will obtain a sorted list for each tree.
        // We can then merge these two sorted lists into one sorted list.

        // Helper function to perform in-order DFS and collect the values in a list
        fun dfs(node: TreeNode?, list: MutableList<Int>) {
            if (node == null) return

            // Traverse left subtree
            dfs(node.left, list)
            // Visit current node
            list.add(node.`val`)
            // Traverse right subtree
            dfs(node.right, list)
        }

        val list1 = mutableListOf<Int>()
        val list2 = mutableListOf<Int>()

        // Perform DFS on both trees to get the sorted lists
        dfs(root1, list1)
        dfs(root2, list2)

        val ans = mutableListOf<Int>()
        var i = 0 // Index for list1
        var j = 0 // Index for list2

        // Merge the two sorted lists
        while (i < list1.size && j < list2.size) {
            if (list1[i] < list2[j]) {
                ans.add(list1[i])
                i++
            } else {
                ans.add(list2[j])
                j++
            }
        }

        // Add remaining elements from list1, if any
        while (i < list1.size) {
            ans.add(list1[i])
            i++
        }

        // Add remaining elements from list2, if any
        while (j < list2.size) {
            ans.add(list2[j])
            j++
        }

        return ans
    }
}