package linked_list.sigly

/**
 * 141. Linked List Cycle
 *
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.
 *
 * There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.
 *
 * Return true if there is a cycle in the linked list. Otherwise, return false.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [3,2,0,-4], pos = 1
 * Output: true
 * Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).
 * Example 2:
 *
 *
 * Input: head = [1,2], pos = 0
 * Output: true
 * Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.
 * Example 3:
 *
 *
 * Input: head = [1], pos = -1
 * Output: false
 * Explanation: There is no cycle in the linked list.
 *
 *
 * Constraints:
 *
 * The number of the nodes in the list is in the range [0, 104].
 * -105 <= Node.val <= 105
 * pos is -1 or a valid index in the linked-list.
 *
 *
 * Follow up: Can you solve it using O(1) (i.e. constant) memory?
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

class LC141LinkedListCycle {
    fun hasCycle(head: ListNode?): Boolean {
        // If the tail.next is not null, and it is pointing to a node before it,
        //      then there is a cycle, and iterating through the list is infinite.

        // One way is to put two pointers, fast and slow
        // As the fest goes 2 step at each iteration
        // If there is a cycle, finally the fast will meet the slow

        // Another way is to put the elements in a set
        // If we see an element again, that means there is a cycle in the list

        return hasCycleTwoPointer(head)
        // return hasCycleHashTable(head)
    }

    //----------------------------------------
    // Using two pointer
    private fun hasCycleTwoPointer(head: ListNode?): Boolean {
        var slow = head
        var fast = head
        while (fast?.next != null) {
            slow = slow?.next
            fast = fast.next?.next

            if (slow == fast) {
                return true
            }
        }

        return false
    }


    //----------------------------------------
    // Using hash table
    private fun hasCycleHashTable(head: ListNode?): Boolean {
        // We iterate through the list and if tail is connected to a node
        //      in before it, eventually we can see that node is in the set
        val set = mutableSetOf<ListNode>()
        var cur = head
        while (cur != null) {
            if (!set.add(cur)) {
                return true
            }
            cur = cur.next
        }
        return false
    }
}