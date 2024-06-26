package hashing

/**
 * 205. Isomorphic Strings
 *
 * Given two strings s and t, determine if they are isomorphic.
 *
 * Two strings s and t are isomorphic if the characters in s can be replaced to get t.
 *
 * All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "egg", t = "add"
 * Output: true
 * Example 2:
 *
 * Input: s = "foo", t = "bar"
 * Output: false
 * Example 3:
 *
 * Input: s = "paper", t = "title"
 * Output: true
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 5 * 104
 * t.length == s.length
 * s and t consist of any valid ascii character.
 */

class LC205IsomorphicStrings {
    fun isIsomorphic(s: String, t: String): Boolean {

        // The key is that, if a char from s mapped to a char from t,
        //      for the rest of the strings, the same mapping should happen for those chars otherwise, false should be return
        // We need to hash table to map "s to t" and "t to s"
        // Iterate over the strings
        // At each step, check the mapping to be correct in both way
        // If no mapping is there, map the chars together

        val sToT = mutableMapOf<Char, Char>()
        val tToS = mutableMapOf<Char, Char>()

        for (i in s.indices) {
            val sChar = s[i]
            val tChar = t[i]

            // Map the s to t
            if (sToT.contains(sChar)) {
                if (sToT[sChar]!! != tChar) return false
            } else {
                sToT[sChar] = tChar
            }

            // Map the t to s
            if (tToS.contains(tChar)) {
                if (tToS[tChar]!! != sChar) return false
            } else {
                tToS[tChar] = sChar
            }
        }

        return true
    }


    // ----------------Second Solution-----------------------
    private fun secondSolution(s: String, t: String): Boolean {

        // Capture the occurrence indexes for the first string.
        // e.g: "paper" -> {p=[0, 2], a=[1], e=[3], r=[4]}
        val mapS = mutableMapOf<Char, MutableList<Int>>()

        // Capture the occurrence indexes for the second string.
        // e.g: "title" = {t=[0, 2], i=[1], l=[3], e=[4]}
        val mapT = mutableMapOf<Char, MutableList<Int>>()

        fun initMap(str: String, map: MutableMap<Char, MutableList<Int>>) {
            for (i in str.indices) {
                if (map.contains(str[i])) {
                    map[str[i]]!!.add(i)
                } else {
                    map[str[i]] = mutableListOf(i)
                }
            }
        }

        initMap(s, mapS)
        initMap(t, mapT)

        for (i in s.indices) {
            val occS = mapS[s[i]]!!
            val occT = mapT[t[i]]!!

            // If size are not the same return false
            if (occS.size != occT.size) {
                return false
            }

            // If position for all the chars are not the same return false
            for (j in occS.indices) {
                if (occS[j] != occT[j]) {
                    return false
                }
            }
        }

        return true
    }
}