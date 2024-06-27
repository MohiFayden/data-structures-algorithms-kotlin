package linked_list

/**
 * 19. Remove Nth Node From End of List
 *
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,3,4,5], n = 2
 * Output: [1,2,3,5]
 * Example 2:
 *
 * Input: head = [1], n = 1
 * Output: []
 * Example 3:
 *
 * Input: head = [1,2], n = 1
 * Output: [1]
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is sz.
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 *
 *
 * Follow up: Could you do this in one pass?
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
class LC19RemoveNthNodeFromEndOfList {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {

        // We can use the Fast and Slow pointers to find the kth item
        // target is nth behind the tail
        // Define the slow and fast variables (both to head)
        // Iterate over the list nth times to put the fast nth item ahead of the slow
        // Then start moving the slow as well
        // When fast hit the end of the list, slow will be at the nth position
        // Keep track of the previous item of the slow to be able to remove the slow item

        var dummy = head

        if (dummy?.next == null) {
            dummy = null
        }

        var prev: ListNode? = null
        var slow: ListNode? = dummy
        var fast = dummy

        var counter = 1
        while (fast?.next != null) {
            fast = fast.next
            if (counter >= n) {
                prev = slow
                slow = slow?.next
            }
            counter++
        }

        if (slow == dummy) {
            dummy = slow?.next
        } else {
            prev?.next = slow?.next
        }

        return dummy
    }
}