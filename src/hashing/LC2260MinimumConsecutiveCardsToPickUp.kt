package hashing

import kotlin.math.min

/**
 * 2260. Minimum Consecutive Cards to Pick Up
 *
 * You are given an integer array cards where cards[i] represents the value of the ith card. A pair of cards are matching if the cards have the same value.
 *
 * Return the minimum number of consecutive cards you have to pick up to have a pair of matching cards among the picked cards. If it is impossible to have matching cards, return -1.
 *
 *
 *
 * Example 1:
 *
 * Input: cards = [3,4,2,3,4,7]
 * Output: 4
 * Explanation: We can pick up the cards [3,4,2,3] which contain a matching pair of cards with value 3. Note that picking up the cards [4,2,3,4] is also optimal.
 * Example 2:
 *
 * Input: cards = [1,0,5,3]
 * Output: -1
 * Explanation: There is no way to pick up a set of consecutive cards that contain a pair of matching cards.
 *
 *
 * Constraints:
 *
 * 1 <= cards.length <= 105
 * 0 <= cards[i] <= 106
 */

class LC2260MinimumConsecutiveCardsToPickUp {
    fun minimumCardPickup(cards: IntArray): Int {

        // We can introduce a hash table (map) to keep a record of the latest card that is seen
        // Iterate over the cards
        // For each card, if we saw it before, check if the distance of the current card and the previous is the minimum answer or not
        // Add the card and index to the map as in the future if we see it again, this will be the closest card to it.
        // Formula for the length of the subarray is (i - j + 1)
        //      (+ 1) is because the length of the subarray is inclusive of both sides

        return firstApproach(cards)
        // return secondApproach(cards)
    }


    //----------First Approach----------
    private fun firstApproach(cards: IntArray): Int {
        var ans = Int.MAX_VALUE
        val map = mutableMapOf<Int, Int>()

        cards.forEachIndexed { i, card ->
            if (map.contains(card)) {
                ans = min(ans, i - map[card]!! + 1)
            }

            map[card] = i
        }

        return if (ans == Int.MAX_VALUE) -1 else ans
    }


    //----------Second Approach---------
    private fun secondApproach(cards: IntArray): Int {

        var ans = Int.MAX_VALUE
        val map = mutableMapOf<Int, MutableList<Int>>()

        cards.forEachIndexed { i, card ->
            map[card] = map[card] ?: mutableListOf()
            map[card]!!.add(i)
        }

        map.values.forEach { match ->
            for (i in 0..<match.size - 1) {
                ans = min(ans, match[i + 1] - match[i] + 1)
            }
        }

        return if (ans == Int.MAX_VALUE) -1 else ans
    }
}