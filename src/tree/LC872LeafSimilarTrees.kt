package tree

/**
 * 872. Leaf-Similar Trees
 *
 * Easy
 *
 * Consider all the leaves of a binary tree, from left to right order, the values of those leaves form a leaf value sequence.
 *
 *
 *
 * For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).
 *
 * Two binary trees are considered leaf-similar if their leaf value sequence is the same.
 *
 * Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root1 = [3,5,1,6,2,9,8,null,null,7,4], root2 = [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]
 * Output: true
 * Example 2:
 *
 *
 * Input: root1 = [1,2,3], root2 = [1,3,2]
 * Output: false
 *
 *
 * Constraints:
 *
 * The number of nodes in each tree will be in the range [1, 200].
 * Both of the given trees will have values in the range [0, 200].
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
class LC872LeafSimilarTrees {
    fun leafSimilar(root1: TreeNode?, root2: TreeNode?): Boolean {

        // Intuition:
        // We can perform a Depth-First Search (DFS) on both trees to collect the leaf nodes.
        // Then, we compare the sequences of leaf nodes to determine if they are similar.

        // Helper function to perform DFS and collect leaf nodes.
        fun dfs(root: TreeNode?, list: MutableList<Int>): List<Int> {
            if (root == null) return list // Base case: if the node is null, return the current list

            if (root.left == null && root.right == null) { // Check if the node is a leaf node
                list.add(root.`val`) // Add the leaf node value to the list
            }

            root.left?.let { dfs(it, list) } // Recursively traverse the left subtree
            root.right?.let { dfs(it, list) } // Recursively traverse the right subtree

            return list // Return the list of leaf nodes
        }

        val leafs1 = dfs(root1, mutableListOf()) // Collect leaf nodes from the first tree
        val leafs2 = dfs(root2, mutableListOf()) // Collect leaf nodes from the second tree

        if (leafs1.size != leafs2.size) return false // If the sizes of leaf sequences differ, return false

        // Compare the leaf nodes from both trees
        leafs1.forEachIndexed { index, value ->
            if (value != leafs2[index]) return false // If any leaf node value differs, return false
        }

        return true // If all leaf nodes are similar, return true
    }
}
