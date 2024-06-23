package hashing

/**
 * 2225. Find Players With Zero or One Losses
 *
 * You are given an integer array matches where matches[i] = [winneri, loseri] indicates that the player winneri defeated player loseri in a match.
 *
 * Return a list answer of size 2 where:
 *
 * answer[0] is a list of all players that have not lost any matches.
 * answer[1] is a list of all players that have lost exactly one match.
 * The values in the two lists should be returned in increasing order.
 *
 * Note:
 *
 * You should only consider the players that have played at least one match.
 * The testcases will be generated such that no two matches will have the same outcome.
 *
 *
 * Example 1:
 *
 * Input: matches = [[1,3],[2,3],[3,6],[5,6],[5,7],[4,5],[4,8],[4,9],[10,4],[10,9]]
 * Output: [[1,2,10],[4,5,7,8]]
 * Explanation:
 * Players 1, 2, and 10 have not lost any matches.
 * Players 4, 5, 7, and 8 each have lost one match.
 * Players 3, 6, and 9 each have lost two matches.
 * Thus, answer[0] = [1,2,10] and answer[1] = [4,5,7,8].
 * Example 2:
 *
 * Input: matches = [[2,3],[1,3],[5,4],[6,4]]
 * Output: [[1,2,5,6],[]]
 * Explanation:
 * Players 1, 2, 5, and 6 have not lost any matches.
 * Players 3 and 4 each have lost two matches.
 * Thus, answer[0] = [1,2,5,6] and answer[1] = [].
 *
 *
 * Constraints:
 *
 * 1 <= matches.length <= 105
 * matches[i].length == 2
 * 1 <= winneri, loseri <= 105
 * winneri != loseri
 * All matches[i] are unique.
 *
 */

class LC2225FindPlayersWithZeroOrOneLosses {
    fun findWinners(matches: Array<IntArray>): List<List<Int>> {

        // We don't care about the number of matches that a player won, we care about the lost matches
        // We can use a hash table to count the lost matches
        // So, at any match, for player1 which won the match, we don't increment the count
        // For player2 which lost the match, we increment the counter by one

        val counts = mutableMapOf<Int, Int>()

        matches.forEach { match ->
            counts[match[0]] = counts[match[0]] ?: 0
            counts[match[1]] = (counts[match[1]] ?: 0) + 1
        }

        val ans1 = mutableListOf<Int>()
        val ans2 = mutableListOf<Int>()

        counts.forEach { player ->
            if (player.value == 0) {
                ans1.add(player.key)
            } else if (player.value == 1) {
                ans2.add(player.key)
            }
        }

        return listOf(ans1.sorted(), ans2.sorted())
    }
}