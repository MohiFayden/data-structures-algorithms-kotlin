package linked_list

/**
 * 328. Odd Even Linked List
 *
 * Medium
 *
 * Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return the reordered list.
 *
 * The first node is considered odd, and the second node is even, and so on.
 *
 * Note that the relative order inside both the even and odd groups should remain as it was in the input.
 *
 * You must solve the problem in O(1) extra space complexity and O(n) time complexity.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,3,4,5]
 * Output: [1,3,5,2,4]
 * Example 2:
 *
 *
 * Input: head = [2,1,3,5,6,4,7]
 * Output: [2,3,6,7,1,5,4]
 *
 *
 * Constraints:
 *
 * The number of nodes in the linked list is in the range [0, 104].
 * -106 <= Node.val <= 106
 */

/**
 * Example usage:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list:
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class LC328OddEvenLinkedList {
    fun oddEvenList(head: ListNode?): ListNode? {

        // This function rearranges a singly-linked list such that all odd-indexed nodes
        // are grouped together followed by the even-indexed nodes. The goal is to achieve
        // this rearrangement in O(1) space complexity and O(n) time complexity.

        var odd = head // Pointer to track the odd indexed nodes
        var even = head?.next // Pointer to track the even indexed nodes
        val evenHead = even // Reference to the head of the even indexed list

        // Iterate through the list until there are no more even nodes
        while (even?.next != null) {
            odd?.next = odd?.next?.next // Link current odd node to the next odd node
            even.next = even.next?.next // Link current even node to the next even node
            odd = odd?.next // Move odd pointer to the next odd node
            even = even.next // Move even pointer to the next even node
        }

        // Connect the end of the odd indexed list to the head of the even indexed list
        odd?.next = evenHead

        // Return the modified list
        return head
    }
}