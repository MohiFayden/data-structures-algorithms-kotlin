package tree

data class TreeNode(
    val `val`: Int,
    var left: TreeNode? = null,
    var right: TreeNode? = null
)
