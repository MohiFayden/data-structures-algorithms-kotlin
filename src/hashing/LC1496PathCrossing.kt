package hashing

/**
 * 1496. Path Crossing
 *
 * Given a string path, where path[i] = 'N', 'S', 'E' or 'W', each representing moving one unit north, south, east, or west, respectively. You start at the origin (0, 0) on a 2D plane and walk on the path specified by path.
 *
 * Return true if the path crosses itself at any point, that is, if at any time you are on a location you have previously visited. Return false otherwise.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: path = "NES"
 * Output: false
 * Explanation: Notice that the path doesn't cross any point more than once.
 * Example 2:
 *
 *
 * Input: path = "NESWW"
 * Output: true
 * Explanation: Notice that the path visits the origin twice.
 *
 *
 * Constraints:
 *
 * 1 <= path.length <= 104
 * path[i] is either 'N', 'S', 'E', or 'W'.
 */

class LC1496PathCrossing {
    fun isPathCrossing(path: String): Boolean {

        // Let's introduce i and j to represent the coordinate, initialized with (0, 0)
        // Iterate over the path and at each index if the direction is:
        //      'N' (north), increment the j
        //      'S' (south), decrement the j
        //      'E' (east), increment the i
        //      'W' (west), decrement the i
        // This is simulating the movement on the 2D plane
        //At each index, concatenate the (i, j) as a string key ("i, j") and put it in the set which means we were at this point
        // Continue simulating the movement by iterating over the path
        // At each point, if we saw a point ("i, j") in the set, that means it's crossing itself

        val seen = mutableSetOf<String>()
        var i = 0
        var j = 0

        seen.add("0, 0") // Add the starting point to the seen

        path.forEach { dir ->
            when (dir) {
                'N' -> j++
                'S' -> j--
                'E' -> i++
                'W' -> i--
            }
            val key = "$i, $j"

            if (seen.contains(key)) return true
            seen.add(key)
        }

        return false
    }
}