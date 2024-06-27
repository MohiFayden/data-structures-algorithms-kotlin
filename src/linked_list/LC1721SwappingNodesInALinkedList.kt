package linked_list

/**
 * 1721. Swapping Nodes in a Linked List
 *
 * Medium
 *
 * You are given the head of a linked list, and an integer k.
 *
 * Return the head of the linked list after swapping the values of the kth node from the beginning and the kth node from the end (the list is 1-indexed).
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [1,4,3,2,5]
 * Example 2:
 *
 * Input: head = [7,9,6,6,7,8,3,0,9,5], k = 5
 * Output: [7,9,6,6,8,7,3,0,9,5]
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is n.
 * 1 <= k <= n <= 105
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
class LC1721SwappingNodesInALinkedList {
    fun swapNodes(head: ListNode?, k: Int): ListNode? {

        // We can update the list in one pass by finding the references left and right node with Fast and Slow technique
        // Start iterating over the list with a counter
        // When the counter is equal to `k`, we are at the left's kth, so, store the leftNode
        // Now, continue iterating (consider fast and slow technique) until the fast node reaches the end of the list
        // The Slow node, is the right's kth node, keeping the reference of the previous node of it.
        // Now swap the nodes

        var leftNode: ListNode? = null
        var rightNode: ListNode? = null

        var slow = head
        var fast = head
        var counter = 1

        // Iterate over the list to find both nodes
        while (fast != null) {
            if (counter == k) { // Find the leftNode (fast ndoe will be the answer)
                leftNode = fast
            }

            if (counter >= k) { // Find the rightNode (Slow node is the answer when fast reaches the end of the list)
                rightNode = slow
                slow = slow?.next
            }
            fast = fast.next
            counter++
        }

        // Swap the value of nodes if we have them
        leftNode?.let { left ->
            rightNode?.let { right ->
                val temp = right.`val`
                right.`val` = left.`val`
                left.`val` = temp
            }
        }

        return head
    }
}