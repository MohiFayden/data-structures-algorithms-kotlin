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
        // We can reverse the second half of the list and sum up the nodes starting from the head and half side
        // 1->2->3->6->5->4 ==> now we can sum up starting from index 0 and list.size / 2

        // Find the middle of the linked list (the prev of the second half)
        while (fast?.next != null) {
            slow = slow?.next
            fast = fast.next?.next
        }

        // Reverse the second half
        var prev: ListNode? = null
        var curr = slow?.next

        while (curr != null) {
            val next = curr.next
            curr.next = prev
            prev = curr
            curr = next
        }

        // Build the new linked list in place (prev is the head of the reversed half)
        slow?.next = prev

        // Sum up the pairs starting from the head and the half way head (reversed part)
        var ans = 0
        var first = head
        var second = slow?.next // the new head for the second half
        while (second != null) {
            ans = max(ans, first!!.`val` + second.`val`)

            first = first.next
            second = second.next
        }

        return ans
    }
}