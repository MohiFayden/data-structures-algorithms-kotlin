package hashing

/**
 * 791. Custom Sort String
 *
 * You are given two strings order and s. All the characters of order are unique and were sorted in some custom order previously.
 *
 * Permute the characters of s so that they match the order that order was sorted. More specifically, if a character x occurs before a character y in order, then x should occur before y in the permuted string.
 *
 * Return any permutation of s that satisfies this property.
 *
 *
 *
 * Example 1:
 *
 * Input: order = "cba", s = "abcd"
 *
 * Output: "cbad"
 *
 * Explanation: "a", "b", "c" appear in order, so the order of "a", "b", "c" should be "c", "b", and "a".
 *
 * Since "d" does not appear in order, it can be at any position in the returned string. "dcba", "cdba", "cbda" are also valid outputs.
 *
 * Example 2:
 *
 * Input: order = "bcafg", s = "abcd"
 *
 * Output: "bcad"
 *
 * Explanation: The characters "b", "c", and "a" from order dictate the order for the characters in s. The character "d" in s does not appear in order, so its position is flexible.
 *
 * Following the order of appearance in order, "b", "c", and "a" from s should be arranged as "b", "c", "a". "d" can be placed at any position since it's not in order. The output "bcad" correctly follows this rule. Other arrangements like "bacd" or "bcda" would also be valid, as long as "b", "c", "a" maintain their order.
 *
 *
 *
 * Constraints:
 *
 * 1 <= order.length <= 26
 * 1 <= s.length <= 200
 * order and s consist of lowercase English letters.
 * All the characters of order are unique.
 */

class LC791CustomSortString {
    fun customSortString(order: String, s: String): String {
        return withSimpleHashMap(order, s)
        // return withListAndSort(order, s)
    }

    //----------------Use simple hashmap and build the string---------------
    private fun withSimpleHashMap(order: String, s: String): String {

        // Put the s chars in a hash table (count) and count the frequency of each
        // Iterate over the order, for each char in order, retrieve the frequency of it from the count and build the string and remove it from the count
        // At the end, put all the remaining of s to the ans

        val counts = mutableMapOf<Char, Int>()

        // Count the frequency of each character in s
        s.forEach { char ->
            counts[char] = (counts[char] ?: 0) + 1
        }

        return buildString {
            // Append characters from s based on the order defined in 'order'
            order.forEach { char ->
                if (counts.contains(char)) {
                    // Append the character 'char' as many times as it appears in s
                    repeat(counts[char]!!) {
                        append(char)
                    }
                    // Remove the character from the map after processing
                    counts.remove(char)
                }
            }

            // Append the remaining characters that are not in 'order'
            counts.forEach { entry ->
                repeat(entry.value) {
                    append(entry.key)
                }
            }
        }
    }

    //--------------Convert to List and Sort--------------------

    fun withListAndSort(order: String, s: String): String {
        // Create a map to store the position of each character in order
        val orderMap = mutableMapOf<Char, Int>()
        for ((index, char) in order.withIndex()) {
            orderMap[char] = index
        }

        // Convert string s to a list of characters
        val sCharList = s.toList()

        // Sort the list based on the order defined in the map
        val sortedList = sCharList.sortedWith(compareBy { orderMap[it] ?: Int.MAX_VALUE })

        // Convert the sorted list back to a string
        return sortedList.joinToString("")
    }
}