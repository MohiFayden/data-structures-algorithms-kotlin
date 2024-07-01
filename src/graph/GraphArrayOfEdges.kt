package graph

/**
 * GraphArrayOfEdges class represents a graph using an array of edges.
 * Example of edges: [[0, 1], [1, 2], [2, 0], [2, 3]]
 * This represents a graph with nodes 0, 1, 2, and 3, and edges between them.
 */
class GraphArrayOfEdges {

    /**
     * This function builds a graph from a list of edges.
     *
     * @param edges A list of edges, where each edge is represented by a pair of nodes.
     * @return A map representing the adjacency list of the graph.
     */
    fun buildGraph(edges: List<List<Int>>): Map<Int, List<Int>> {

        // We use a hash table (mutableMapOf) to pre-process the graph when the input is the list of edges.
        val map = mutableMapOf<Int, MutableList<Int>>()

        edges.forEach { edge ->
            // Check if the starting node of the edge is already in the map.
            // If not, initialize it with an empty list.
            map[edge[0]] = map[edge[0]] ?: mutableListOf()
            // Add the end node of the edge to the list of the starting node.
            map[edge[0]]?.add(edge[1])

            // The following part is for undirected graphs only:
            // For an undirected graph, add the reverse edge as well.
            map[edge[1]] = map[edge[1]] ?: mutableListOf()
            // Add the starting node to the list of the end node.
            map[edge[1]]?.add(edge[0])
        }

        // Return the map as an immutable map representing the adjacency list of the graph.
        return map
    }
}