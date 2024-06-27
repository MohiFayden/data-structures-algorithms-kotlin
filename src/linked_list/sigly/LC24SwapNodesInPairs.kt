package linked_list.sigly

/**
 * 24. Swap Nodes in Pairs
 *
 * Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,3,4]
 * Output: [2,1,4,3]
 * Example 2:
 *
 * Input: head = []
 * Output: []
 * Example 3:
 *
 * Input: head = [1]
 * Output: [1]
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is in the range [0, 100].
 * 0 <= Node.val <= 100
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
class LC24SwapNodesInPairs {
    fun swapPairs(head: ListNode?): ListNode? {
        return iterative(head)
        // return recursive(head)
    }


    //----------Iterative-----------------
    private fun iterative(head: ListNode?): ListNode? {
        if (head?.next == null) return head

        // 1->2->3->4->5->6 ==> 2->1->4->3->6->5

        val newHead = head.next // New head starts fro m the second item: 2->1...
        var prev: ListNode? = null
        var curr = head

        // At each operation, we move 2 steps
        while (curr?.next != null) {

            val third = curr.next?.next // Keep this for the next pair

            prev?.next = curr.next // make the connection to the next pair
            prev = curr // Initiate the previous item for the next pair

            // Start swapping the current pair
            curr.next?.next = curr
            curr.next = third
            curr = third // Start the next pair
        }
        return newHead
    }


    //----------Recursive----------------------
    private fun recursive(head: ListNode?): ListNode? {

        if (head?.next == null) { // Guarantee we have at least 2 items for the rest of the logic
            return head
        }

        val first = swapPairs(head.next?.next) // Split the list 2 by 2

        // Start swapping the items from the very last pair
        val second = head.next
        head.next = first
        second?.next = head

        return second
    }
}