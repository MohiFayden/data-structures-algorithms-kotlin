package linked_list

import kotlin.math.max

/**
 * 2130. Maximum Twin Sum of a Linked List
 *
 * In a linked list of size n, where n is even, the ith node (0-indexed) of the linked list is known as the twin of the (n-1-i)th node, if 0 <= i <= (n / 2) - 1.
 *
 * For example, if n = 4, then node 0 is the twin of node 3, and node 1 is the twin of node 2. These are the only nodes with twins for n = 4.
 * The twin sum is defined as the sum of a node and its twin.
 *
 * Given the head of a linked list with even length, return the maximum twin sum of the linked list.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [5,4,2,1]
 * Output: 6
 * Explanation:
 * Nodes 0 and 1 are the twins of nodes 3 and 2, respectively. All have twin sum = 6.
 * There are no other nodes with twins in the linked list.
 * Thus, the maximum twin sum of the linked list is 6.
 * Example 2:
 *
 *
 * Input: head = [4,2,2,3]
 * Output: 7
 * Explanation:
 * The nodes with twins present in this linked list are:
 * - Node 0 is the twin of node 3 having a twin sum of 4 + 3 = 7.
 * - Node 1 is the twin of node 2 having a twin sum of 2 + 2 = 4.
 * Thus, the maximum twin sum of the linked list is max(7, 4) = 7.
 * Example 3:
 *
 *
 * Input: head = [1,100000]
 * Output: 100001
 * Explanation:
 * There is only one node with a twin in the linked list having twin sum of 1 + 100000 = 100001.
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is an even integer in the range [2, 105].
 * 1 <= Node.val <= 105
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
class LC2130MaximumTwinSumOfALinkedList {
    fun pairSum(head: ListNode?): Int {
        var slow = head
        var fast = head?.next

        // 1->2->3->4->5->6 ==> Goal = max((1+6), (2+5), (3+4))
        // The goal is to find the maximum twin sum of pairs of nodes from the start and end of the list.
        // To achieve this, reverse the second half of the list and then sum the pairs of nodes
        // starting from the head of the list and the head of the reversed half.
        // For example: 1->2->3->4->5->6 becomes 1->2->3->6->5->4 and then sum pairs (1+6), (2+5), (3+4).

        // Find the middle of the linked list. 'slow' will point to the last node of the first half when 'fast' reaches the end of the list.
        while (fast?.next != null) {
            slow = slow?.next
            fast = fast.next?.next
        }

        // Reverse the second half of the list starting from the node after 'slow'.
        // 'prev' will be the new head of the reversed half.
        var prev: ListNode? = null
        var curr = slow?.next

        while (curr != null) {
            val next = curr.next
            curr.next = prev
            prev = curr
            curr = next
        }

        // Connect the end of the first half to the head of the reversed second half.
        slow?.next = prev

        // Sum the pairs of nodes from the start of the list and the start of the reversed half,
        // keeping track of the maximum sum.
        var ans = 0
        var first = head
        var second = slow?.next // 'second' points to the start of the reversed half
        while (second != null) {
            ans = max(ans, first!!.`val` + second.`val`)

            first = first.next
            second = second.next
        }

        return ans
    }
}