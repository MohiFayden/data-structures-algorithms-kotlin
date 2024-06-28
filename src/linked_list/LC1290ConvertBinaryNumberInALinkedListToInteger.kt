package linked_list

import kotlin.math.pow

/**
 * 1290. Convert Binary Number in a Linked List to Integer
 *
 * Easy
 *
 * Given head which is a reference node to a singly-linked list. The value of each node in the linked list is either 0 or 1. The linked list holds the binary representation of a number.
 *
 * Return the decimal value of the number in the linked list.
 *
 * The most significant bit is at the head of the linked list.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,0,1]
 * Output: 5
 * Explanation: (101) in base 2 = (5) in base 10
 * Example 2:
 *
 * Input: head = [0]
 * Output: 0
 *
 *
 * Constraints:
 *
 * The Linked List is not empty.
 * Number of nodes will not exceed 30.
 * Each node's value is either 0 or 1.
 */

/**
 * Example usage:
 * var li = ListNode(5)
 * var v = li.`val`
 *
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class LC1290ConvertBinaryNumberInALinkedListToInteger {
    fun getDecimalValue(head: ListNode?): Int {
        // Convert a binary number represented as a linked list to a decimal value.
        // Binary numbers are base-2 numbers, where each digit represents a power of 2.
        // For example, the positional values for 101 are 2^2, 2^1, 2^0 (right to left).
        // The result will be: (1 * 2^2) + (0 * 2^1) + (1 * 2^0) == 4 + 0 + 1 = 5

        // First, we need to determine the size of the list to assign the correct positional values.
        var size = 0
        var curr = head
        while (curr != null) {
            size++
            curr = curr.next
        }

        // Now, we can iterate over the list again and calculate the decimal value.
        var ans = 0.0
        curr = head
        size-- // Adjust for 0 indexing (last item will be to the power of 0, not 1)
        while (curr != null) {
            ans += curr.`val` * 2.0.pow(size.toDouble())
            size--
            curr = curr.next
        }

        // Return the calculated decimal value as an integer.
        return ans.toInt()
    }
}