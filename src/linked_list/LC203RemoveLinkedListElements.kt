package linked_list

/**
 * 203. Remove Linked List Elements
 *
 * Easy
 *
 * Given the head of a linked list and an integer val, remove all the nodes of the linked list that has Node.val == val, and return the new head.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,6,3,4,5,6], val = 6
 * Output: [1,2,3,4,5]
 * Example 2:
 *
 * Input: head = [], val = 1
 * Output: []
 * Example 3:
 *
 * Input: head = [7,7,7,7], val = 7
 * Output: []
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is in the range [0, 104].
 * 1 <= Node.val <= 50
 * 0 <= val <= 50
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
class LC203RemoveLinkedListElements {
    fun removeElements(head: ListNode?, `val`: Int): ListNode? {
        // Create a dummy node to simplify edge cases such as removing the head node
        val dummy = ListNode(-1, head)

        var prev: ListNode? = dummy
        var curr = head

        // Traverse the list
        while (curr != null) {
            if (curr.`val` == `val`) {
                // If current node's value equals the target value, bypass it
                prev?.next = curr.next
            } else {
                // Otherwise, move the prev pointer to the current node
                prev = curr
            }
            // Move to the next node in the list
            curr = curr.next
        }

        // Return the updated list, which starts after the dummy node
        return dummy.next
    }
}
