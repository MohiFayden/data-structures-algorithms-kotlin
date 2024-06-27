package linked_list

/**
 * 234. Palindrome Linked List
 *
 * Easy :: Medium if we want to gain O(1) space complexity
 *
 * Given the head of a singly linked list, return true if it is a
 * palindrome
 *  or false otherwise.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,2,1]
 * Output: true
 * Example 2:
 *
 *
 * Input: head = [1,2]
 * Output: false
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is in the range [1, 105].
 * 0 <= Node.val <= 9
 *
 *
 * Follow up: Could you do it in O(n) time and O(1) space?
 */

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class LC234PalindromeLinkedList {
    fun isPalindrome(head: ListNode?): Boolean {
        // If we read the list from the left to right and right to left, all the elements should be the same
        // To gain the O(n) time and O(1) Space complexity, we should check the list in place (without consuming new space)
        // So, If we reverse the second half of the linked list, then start two pointers,
        //       left at the beginning and right at the half way, left and right nodes at each step should be the same
        // e.g: 1->2->3->3->2->1 => 1->2->3->1->2->3
        // To reverse teh list, we can use fast and slow (Two Pointers) technique
        // Set fast and slow to the head
        // Iterate over the head, at each step, move slow one node ahead, and fast two nodes ahead
        // When fast reaches the end of the list, slow is at the middle of the list
        // Start reversing the list from the middle

        var slow = head
        var fast = head
        var midPar = head // Keep reference to the parent of the middle item to make the correct connection later

        // Find the middle of the list : When fast is at the end of the list, slow is at the middle of the list
        while (fast != null) {
            midPar = slow
            slow = slow?.next
            fast = fast.next?.next
        }

        // Start reversing the second half of the list
        var prev: ListNode? = null

        while (slow != null) {
            // ...->3->2->1
            val next = slow.next
            slow.next = prev
            prev = slow
            slow = next
        }

        // Adjust the list to connect the first half with the reversed second half
        midPar?.next = prev

        // Check both sides to see if they are equal or not
        var left = head
        var right = midPar?.next

        while (right != null) {
            if (left?.`val` != right.`val`) return false
            left = left.next
            right = right.next
        }

        return true
    }
}