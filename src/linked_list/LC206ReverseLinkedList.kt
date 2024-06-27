package linked_list

/**
 * 206. Reverse Linked List
 *
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,3,4,5]
 * Output: [5,4,3,2,1]
 * Example 2:
 *
 *
 * Input: head = [1,2]
 * Output: [2,1]
 * Example 3:
 *
 * Input: head = []
 * Output: []
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is the range [0, 5000].
 * -5000 <= Node.val <= 5000
 *
 *
 * Follow up: A linked list can be reversed either iteratively or recursively. Could you implement both?
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
class LC206ReverseLinkedList {
    fun reverseList(head: ListNode?): ListNode? {
        return iteratively(head)
        // return recursively(head)
    }

    //-----------Iterative-------------
    private fun iteratively(head: ListNode?): ListNode? {

        // Iterate through the list
        // At each step, keep reference to the prev and next items
        // Then for the curr item, change the next pointer to point to the prev item
        // At the end, list is reversed

        var prev: ListNode? = null
        var cur = head
        while (cur != null) {
            val next = cur.next
            cur.next = prev
            prev = cur
            cur = next
        }
        return prev
    }


    //------------Recursively------------
    private fun recursively(head: ListNode?): ListNode? {

        if (head?.next == null) return head

        val prev = recursively(head.next)
        head.next?.next = head
        head.next = null
        return prev
    }
}