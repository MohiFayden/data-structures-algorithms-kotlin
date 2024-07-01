package tree

/**
 * 199. Binary Tree Right Side View
 *
 * Medium
 *
 * Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,2,3,null,5,null,4]
 * Output: [1,3,4]
 * Example 2:
 *
 * Input: root = [1,null,3]
 * Output: [1,3]
 * Example 3:
 *
 * Input: root = []
 * Output: []
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 100].
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
class LC199BinaryTreeRightSidView {
    fun rightSideView(root: TreeNode?): List<Int> {

        // We know that the right side means the right nodes in each level
        // So, we can simply use BFS to collect the items in each level
        // Then, grab the last item for that level and add it to the answer

        // Define the ans list to collect the values
        val ans = mutableListOf<Int>()

        // Operate the BFS
        val queue = ArrayDeque<TreeNode>()
        root?.let { queue.addLast(root) }

        while (queue.isNotEmpty()) {
            val levelSize = queue.size

            // Add the last item in the level to teh ans
            ans.add(queue.last().`val`)

            // Remove the items in the level and add the next level
            repeat(levelSize) {
                val curr = queue.removeFirst()
                curr.left?.let { queue.add(it) }
                curr.right?.let { queue.add(it) }
            }
        }

        return ans
    }
}