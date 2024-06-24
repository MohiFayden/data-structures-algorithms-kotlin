package hashing

/**
 * 2352. Equal Row and Column Pairs
 *
 * Given a 0-indexed n x n integer matrix grid, return the number of pairs (ri, cj) such that row ri and column cj are equal.
 *
 * A row and column pair is considered equal if they contain the same elements in the same order (i.e., an equal array).
 *
 *
 *
 * Example 1:
 *
 *
 * Input: grid = [[3,2,1],[1,7,6],[2,7,7]]
 * Output: 1
 * Explanation: There is 1 equal row and column pair:
 * - (Row 2, Column 1): [2,7,7]
 * Example 2:
 *
 *
 * Input: grid = [[3,1,2,2],[1,4,4,5],[2,4,2,2],[2,4,2,2]]
 * Output: 3
 * Explanation: There are 3 equal row and column pairs:
 * - (Row 0, Column 0): [3,1,2,2]
 * - (Row 2, Column 2): [2,4,2,2]
 * - (Row 3, Column 2): [2,4,2,2]
 *
 *
 * Constraints:
 *
 * n == grid.length == grid[i].length
 * 1 <= n <= 200
 * 1 <= grid[i][j] <= 105
 */

class LC2352EqualRowAndColumnPairs {
    fun equalPairs(grid: Array<IntArray>): Int {

        // One solution to find the same row and columns is to make the elements as key
        // Iterate over the grid
        // For each row, build the key by concatenating the keys as strings and storing them in the map1
        // If we see a duplicated key, we increment the count of that key to be able to count the correct answer

        // iterate over the grid indices
        //The first iterator is the column (i) and the second one is the row (j)
        // Build the key and update the map2 like the map1

        // Iterate over the map1
        // For each element, if we saw the same in map1, count the answer
        //      As we might have more than one occurrence for an element
        //      The formula would be like (rowCount * columCount)

        var ans = 0
        val map1 = mutableMapOf<String, Int>()
        val map2 = mutableMapOf<String, Int>()

        grid.forEach { row ->
            val key = buildString {
                row.forEach { append("$it,") }
            }
            map1[key] = (map1[key] ?: 0) + 1
        }

        // i is for column and j is for the row
        for (i in grid.indices) {
            val key = buildString {
                for (j in grid.indices) {
                    append("${grid[j][i]},")
                }
            }
            map2[key] = (map2[key] ?: 0) + 1
        }

        map1.forEach { row ->
            val columnCount = map2[row.key] ?: 0
            ans += (row.value * columnCount)
        }

        return ans
    }
}