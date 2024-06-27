package linked_list

/**
 * 83. Remove Duplicates from Sorted List
 *
 * Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,1,2]
 * Output: [1,2]
 * Example 2:
 *
 *
 * Input: head = [1,1,2,3,3]
 * Output: [1,2,3]
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is in the range [0, 300].
 * -100 <= Node.val <= 100
 * The list is guaranteed to be sorted in ascending order.
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
class LC83RemoveDuplicatesFromSortedList {
    fun deleteDuplicates(head: ListNode?): ListNode? {

        // Since it's a sorted list, we can just compare the current element with the next element
        // If the next element is the same as the current one, simply just remove it by pointing the next of the current to the next.next

        var curr = head
        while (curr?.next != null) {
            if (curr.`val` == curr.next!!.`val`) {
                curr.next = curr.next?.next
            } else {
                curr = curr.next
            }
        }
        return head
    }
}