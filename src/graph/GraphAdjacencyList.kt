package graph

/**
 * This class represents a Graph using an adjacency list.
 * An adjacency list is an array of lists used to represent a graph.
 * The index of the array represents a node in the graph, and each list at
 * that index contains the nodes that are connected to that node.
// *
 * Example:
 * Given a graph: [[1], [2], [0, 3], []]
 * This means:
 * - Node 0 is connected to Node 1
 * - Node 1 is connected to Node 2
 * - Node 2 is connected to Node 0 and Node 3
 * - Node 3 has no outgoing edges
 */

class GraphAdjacencyList {

    /**
     * Processes the given graph represented as an adjacency list.
     *
     * @param graph A list of lists where each inner list contains the nodes
     *              connected to the node at that index.
     */
    fun computeGraph(graph: List<List<Int>>) {
        // Placeholder function: Add logic to process the graph here
        // Example: Print the graph
        graph.forEachIndexed { index, edges ->
            println("Node $index is connected to: ${edges.joinToString(", ")}")
        }
    }
}

fun mainGraphAdjacencyList() {
    val graph = listOf(
        listOf(1),    // Node 0 is connected to Node 1
        listOf(2),    // Node 1 is connected to Node 2
        listOf(0, 3), // Node 2 is connected to Node 0 and Node 3
        listOf()      // Node 3 has no outgoing edges
    )

    val graphAdjacencyList = GraphAdjacencyList()
    graphAdjacencyList.computeGraph(graph)
}