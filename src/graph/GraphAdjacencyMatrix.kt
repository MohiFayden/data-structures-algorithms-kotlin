package graph

/**
 * Class representing a graph using an adjacency matrix.
 *
 * An adjacency matrix is a square matrix used to represent a finite graph.
 * The elements of the matrix indicate whether pairs of vertices are adjacent or not in the graph.
 * For a graph with `n` vertices, the adjacency matrix is an `n x n` matrix.
 *
 * Example of an adjacency matrix:
 *      [
 *        [0, 1, 0, 0],
 *        [0, 0, 1, 0],
 *        [1, 0, 0, 1],
 *        [0, 0, 0, 0]
 *      ]
 * This matrix represents a directed graph with 4 vertices.
 * For instance, there is an edge from vertex 0 to vertex 1,
 * from vertex 1 to vertex 2, and so on.
 * If graph[i][j] == 1, that means there is an outgoing edge from node i to node j
 *
 * We can access the edges directly or preprocess the input like what we did with hash map in Array Of Edges as well
 */
class GraphAdjacencyMatrix {

    /**
     * Processes the graph represented by the given adjacency matrix.
     *
     * This function can perform various operations on the graph,
     * such as traversals, searches, or modifications.
     *
     * @param graph The adjacency matrix representing the graph.
     *              It is a list of lists of integers where `graph[i][j]`
     *              is 1 if there is an edge from vertex `i` to vertex `j`, and 0 otherwise.
     */
    fun processGraph(graph: List<List<Int>>) {
        // Example processing: Print the adjacency matrix
        for (row in graph) {
            println(row.joinToString(" "))
        }

        // Additional processing can be added here
    }
}

// Example usage
fun mainGraphAdjacencyMatrix() {
    val graph = listOf(
        listOf(0, 1, 0, 0),
        listOf(0, 0, 1, 0),
        listOf(1, 0, 0, 1),
        listOf(0, 0, 0, 0)
    )

    val graphProcessor = GraphAdjacencyMatrix()
    graphProcessor.processGraph(graph)
}