package linked_list

/**
 * 92. Reverse Linked List II
 *
 * Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position left to position right, and return the reversed list.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,3,4,5], left = 2, right = 4
 * Output: [1,4,3,2,5]
 * Example 2:
 *
 * Input: head = [5], left = 1, right = 1
 * Output: [5]
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is n.
 * 1 <= n <= 500
 * -500 <= Node.val <= 500
 * 1 <= left <= right <= n
 *
 *
 * Follow up: Could you do it in one pass?
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
class LC92ReverseLinkedListII {
    fun reverseBetween(head: ListNode?, left: Int, right: Int): ListNode? {

        if (left == right) return head

        var dummy = head
        // Find the prev for the left position before start reversing
        var i = 1
        var leftPrev: ListNode? = null

        // This function added for reusability
        fun nextLeftPrev(): ListNode? {
            return if (leftPrev == null) dummy else leftPrev?.next
        }

        while (i < left) {
            leftPrev = nextLeftPrev()
            i++
        }

        // Reverse the list until right position
        var prev: ListNode? = null
        val tail =
            nextLeftPrev() // This is the first item to be reversed and is going to be the tail of the reversed list (left position)
        var curr = nextLeftPrev() // Starting point of the reversal (left position)
        while (i <= right) {
            val next = curr?.next // Keep for the next round of reverse
            curr?.next = prev // change the pointer of current to previous
            prev = curr // put the current item as the previous for the next round
            curr = next // Prepare the current item for next round
            i++
        }

        // Adjust the linked list
        if (leftPrev == null) { // This means left was 0
            dummy = prev
        } else {
            leftPrev.next = prev
        }
        tail?.next = curr // connect teh new reversed list to the rest of the list (right position)

        return dummy
    }
}