package graph

/**
 * Class representing a graph using a 2D matrix.
 * Each cell in the matrix is connected to its adjacent cells (left, right, above, and bottom).
 */
class Graph2DMatrix(private val matrix: List<List<Int>>) {

    private val rows: Int = matrix.size
    private val cols: Int = matrix[0].size

    /**
     * Represents a node in the graph with its row and column indices.
     */
    data class Node(val row: Int, val col: Int)

    /**
     * Returns the list of neighbors for a given node.
     * A neighbor is a node that is adjacent to the given node (left, right, above, or bottom).
     *
     * @param node The node for which to find the neighbors.
     * @return List of neighboring nodes.
     */
    fun getNeighbors(node: Node): List<Node> {
        val neighbors = mutableListOf<Node>()

        val directions = listOf(
            Pair(-1, 0),  // up
            Pair(1, 0),   // down
            Pair(0, -1),  // left
            Pair(0, 1)    // right
        )

        for (direction in directions) {
            val newRow = node.row + direction.first
            val newCol = node.col + direction.second

            if (newRow in 0..<rows && newCol in 0..<cols) {
                neighbors.add(Node(newRow, newCol))
            }
        }

        return neighbors
    }

    /**
     * Processes the graph by iterating over each node and printing its neighbors.
     */
    fun processGraph() {
        for (row in 0..<rows) {
            for (col in 0..<cols) {
                val node = Node(row, col)
                val neighbors = getNeighbors(node)
                println("Node ($row, $col) has neighbors: ${neighbors.joinToString { "(${it.row}, ${it.col})" }}")
            }
        }
    }
}

// Example usage
fun mainGraph2DMatrix() {
    val matrix = listOf(
        listOf(1, 2, 3),
        listOf(4, 5, 6),
        listOf(7, 8, 9)
    )

    val graphProcessor = Graph2DMatrix(matrix)
    graphProcessor.processGraph()

    // Node (0, 0) has neighbors: (1, 0), (0, 1)
    // Node (0, 1) has neighbors: (1, 1), (0, 0), (0, 2)
    // Node (0, 2) has neighbors: (1, 2), (0, 1)
    // Node (1, 0) has neighbors: (0, 0), (2, 0), (1, 1)
    // Node (1, 1) has neighbors: (0, 1), (2, 1), (1, 0), (1, 2)
    // Node (1, 2) has neighbors: (0, 2), (2, 2), (1, 1)
    // Node (2, 0) has neighbors: (1, 0), (2, 1)
    // Node (2, 1) has neighbors: (1, 1), (2, 0), (2, 2)
    // Node (2, 2) has neighbors: (1, 2), (2, 1)
}