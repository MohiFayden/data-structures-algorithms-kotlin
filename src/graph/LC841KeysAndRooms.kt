package graph

/**
 * 841. Keys and Rooms
 *
 * Medium
 *
 * There are n rooms labeled from 0 to n - 1 and all the rooms are locked except for room 0. Your goal is to visit all the rooms. However, you cannot enter a locked room without having its key.
 *
 * When you visit a room, you may find a set of distinct keys in it. Each key has a number on it, denoting which room it unlocks, and you can take all of them with you to unlock the other rooms.
 *
 * Given an array rooms where rooms[i] is the set of keys that you can obtain if you visited room i, return true if you can visit all the rooms, or false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: rooms = [[1],[2],[3],[]]
 * Output: true
 * Explanation:
 * We visit room 0 and pick up key 1.
 * We then visit room 1 and pick up key 2.
 * We then visit room 2 and pick up key 3.
 * We then visit room 3.
 * Since we were able to visit every room, we return true.
 * Example 2:
 *
 * Input: rooms = [[1,3],[3,0,1],[2],[0]]
 * Output: false
 * Explanation: We can not enter room number 2 since the only key that unlocks it is in that room.
 *
 *
 * Constraints:
 *
 * n == rooms.length
 * 2 <= n <= 1000
 * 0 <= rooms[i].length <= 1000
 * 1 <= sum(rooms[i].length) <= 3000
 * 0 <= rooms[i][j] < n
 * All the values of rooms[i] are unique.
 */

class LC841KeysAndRooms {
    fun canVisitAllRooms(rooms: List<List<Int>>): Boolean {

        // We can treat this as a graph with nodes labeled from 0 to n-1
        // The neighbors of each node are the list of keys in that room
        // Since room 0 is unlocked, we can start our DFS traversal from room 0
        // We will use a set to keep track of visited rooms

        val seen = mutableSetOf<Int>()

        // Perform the DFS
        fun dfs(node: Int) {
            // Visit all the neighbors for the current node
            for (neighbor in rooms[node]) {
                if (!seen.contains(neighbor)) {
                    seen.add(neighbor)
                    dfs(neighbor)
                }
            }
        }

        // Start the DFS from room 0
        seen.add(0)
        dfs(0)

        // If the size of the seen set is the same as the number of rooms,
        // it means we have visited all the rooms
        return seen.size == rooms.size
    }
}