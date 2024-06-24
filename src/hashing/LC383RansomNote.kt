package hashing

/**
 * 383. Ransom Note
 *
 * Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.
 *
 * Each letter in magazine can only be used once in ransomNote.
 *
 *
 *
 * Example 1:
 *
 * Input: ransomNote = "a", magazine = "b"
 * Output: false
 * Example 2:
 *
 * Input: ransomNote = "aa", magazine = "ab"
 * Output: false
 * Example 3:
 *
 * Input: ransomNote = "aa", magazine = "aab"
 * Output: true
 *
 *
 * Constraints:
 *
 * 1 <= ransomNote.length, magazine.length <= 105
 * ransomNote and magazine consist of lowercase English letters.
 */

class LC383RansomNote {
    fun canConstruct(ransomNote: String, magazine: String): Boolean {

        // The key here is the magazine
        // Define a map to count the magazine letters
        // Iterate over the ransomNote, for each char, if we have that in the count map, decrement the count for that letter and continue
        // Otherwise, immediately return false
        // If we iterate over all the letters in ransomNote successfully, then return true

        if (ransomNote.length > magazine.length) return false

        val counts = mutableMapOf<Char, Int>()

        magazine.forEach { char ->
            counts[char] = (counts[char] ?: 0) + 1
        }

        for (char in ransomNote) {
            if ((counts[char] ?: 0) > 0) {
                counts[char] = counts[char]!! - 1
            } else {
                return false
            }
        }

        return true
    }
}