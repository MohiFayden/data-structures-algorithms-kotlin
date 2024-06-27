package linked_list

/**
 * 82. Remove Duplicates from Sorted List II
 *
 * Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. Return the linked list sorted as well.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,3,3,4,4,5]
 * Output: [1,2,5]
 * Example 2:
 *
 *
 * Input: head = [1,1,1,2,3]
 * Output: [2,3]
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
class LC82RemoveDuplicatesFromSortedListII {
    fun deleteDuplicates(head: ListNode?): ListNode? {

        // We set a dummy item at the beginning of the list to keep a reference on the whole list
        // Define a unique variable that will move one step ahead only if the element is unique
        // Define a current element to iterate over the list

        val dummy = ListNode(-1, head) // To keep track of the list and not loosing it
        var uniq = dummy // This represent a unique element
        var curr = head // first item to be checked

        // Iterate over the list until we don't have any element
        while (curr != null) {

            // If current item has the same value as the next item, try to skip all the duplicates
            if (curr.next != null && curr.`val` == curr.next!!.`val`) {

                // As we might have more duplicated for `curr`, try to skip all of them
                while (curr?.next != null && curr!!.`val` == curr.next!!.`val`) {
                    curr = curr.next
                }

                // as `curr` was not unique, update the next elements of `uniq` variable to connect with the elements after the `curr` (Skip the `curr`)
                uniq.next = curr?.next

            } else { // Since `curr` was unique, move the `uniq` one step further
                uniq = curr
            }

            curr = curr?.next
        }

        // Return the updates list which the `dummy` kept track of it
        return dummy.next
    }
}