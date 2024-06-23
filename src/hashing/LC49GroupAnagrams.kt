package hashing

/**
 * 49. Group Anagrams
 *
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 *
 *
 *
 * Example 1:
 *
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * Example 2:
 *
 * Input: strs = [""]
 * Output: [[""]]
 * Example 3:
 *
 * Input: strs = ["a"]
 * Output: [["a"]]
 *
 *
 * Constraints:
 *
 * 1 <= strs.length <= 104
 * 0 <= strs[i].length <= 100
 * strs[i] consists of lowercase English letters.
 */

class LC49GroupAnagrams {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        // strs = ["eat","tea","tan","ate","nat","bat"]
        // [["bat"],["nat","tan"],["ate","eat","tea"]]

        // Define a map to collect the groups
        // Iterate over the strings
        // Sort the string to be able to use it as the unique key
        //      Convert the string to CharArray and sort it and convert it back to string
        // Add the string to the map with the unique sorted key

        val map = mutableMapOf<String, MutableList<String>>()

        strs.forEach { str ->
            val sortedStr = str.toCharArray().sorted().joinToString("")
            val group = map[sortedStr] ?: mutableListOf()
            group.add(str)
            map[sortedStr] = group
        }

        println(map)

        return map.values.toList()
    }
}