package tree

/**
 * 100. Same Tree
 *
 * Easy
 *
 * Given the roots of two binary trees p and q, write a function to check if they are the same or not.
 *
 * Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: p = [1,2,3], q = [1,2,3]
 * Output: true
 * Example 2:
 *
 *
 * Input: p = [1,2], q = [1,null,2]
 * Output: false
 * Example 3:
 *
 *
 * Input: p = [1,2,1], q = [1,1,2]
 * Output: false
 *
 *
 * Constraints:
 *
 * The number of nodes in both trees is in the range [0, 100].
 * -104 <= Node.val <= 104
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
class LC100SameTree {
    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        return dfs(p, q)
        // Uncomment the following line to use the iterative approach instead
        // return iterative(p, q)
    }

    //-----------------Recursive--------------------
    fun dfs(p: TreeNode?, q: TreeNode?): Boolean {
        if (p == null && q == null) return true  // Both nodes are null, trees are same up to this point
        if (p?.`val` != q?.`val`) return false  // Values of nodes differ, trees are not the same (Also checks that to one of them not be null)

        // Recursively check left and right subtrees
        return dfs(p?.left, q?.left) && dfs(p?.right, q?.right)
    }

    //-----------------Iterative--------------------
    fun iterative(p: TreeNode?, q: TreeNode?): Boolean {
        val stack = ArrayDeque<Pair<TreeNode?, TreeNode?>>()

        stack.addLast(p to q)  // Initialize the stack with the root nodes

        while (stack.isNotEmpty()) {
            val (a, b) = stack.removeLast()

            if (a == null && b == null) continue  // Both nodes are null, continue to next pair
            if (a?.`val` != b?.`val`) return false  // Values of nodes differ, trees are not the same (Also checks that to one of them not be null)

            // Add left and right children of both nodes to the stack
            stack.addLast(a?.left to b?.left)
            stack.addLast(a?.right to b?.right)
        }

        return true  // All nodes match, trees are the same
    }
}