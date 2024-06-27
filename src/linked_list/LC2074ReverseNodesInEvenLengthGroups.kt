package linked_list

/**
 * 2074. Reverse Nodes in Even Length Groups
 *
 * Medium
 *
 * You are given the head of a linked list.
 *
 * The nodes in the linked list are sequentially assigned to non-empty groups whose lengths form the sequence of the natural numbers (1, 2, 3, 4, ...). The length of a group is the number of nodes assigned to it. In other words,
 *
 * The 1st node is assigned to the first group.
 * The 2nd and the 3rd nodes are assigned to the second group.
 * The 4th, 5th, and 6th nodes are assigned to the third group, and so on.
 * Note that the length of the last group may be less than or equal to 1 + the length of the second to last group.
 *
 * Reverse the nodes in each group with an even length, and return the head of the modified linked list.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [5,2,6,3,9,1,7,3,8,4]
 * Output: [5,6,2,3,9,1,4,8,3,7]
 * Explanation:
 * - The length of the first group is 1, which is odd, hence no reversal occurs.
 * - The length of the second group is 2, which is even, hence the nodes are reversed.
 * - The length of the third group is 3, which is odd, hence no reversal occurs.
 * - The length of the last group is 4, which is even, hence the nodes are reversed.
 * Example 2:
 *
 *
 * Input: head = [1,1,0,6]
 * Output: [1,0,1,6]
 * Explanation:
 * - The length of the first group is 1. No reversal occurs.
 * - The length of the second group is 2. The nodes are reversed.
 * - The length of the last group is 1. No reversal occurs.
 * Example 3:
 *
 *
 * Input: head = [1,1,0,6,5]
 * Output: [1,0,1,5,6]
 * Explanation:
 * - The length of the first group is 1. No reversal occurs.
 * - The length of the second group is 2. The nodes are reversed.
 * - The length of the last group is 2. The nodes are reversed.
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is in the range [1, 105].
 * 0 <= Node.val <= 105
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
class LC2074ReverseNodesInEvenLengthGroups {
    fun reverseEvenLengthGroups(head: ListNode?): ListNode? {

        // Initialize the group number
        var group = 1 // current group

        var curr = head
        var prevTail: ListNode? = null // Tail of the previous group to connect the reversed section to the main list

        while (curr != null) {

            // Calculate the size of the current group
            var node = curr
            var groupSize = 0
            while (node != null && groupSize < group) {
                groupSize++
                node = node.next
            }

            if (groupSize % 2 == 0) { // Check if the group size is even
                // Reverse the nodes in the current group
                val tail = curr
                var next: ListNode? = null // Reference to the start of the next group
                var prev: ListNode? = null // Previous node in the reversed list

                // Reverse the current group of nodes
                for (i in 1..groupSize) {
                    next = curr?.next
                    curr?.next = prev
                    prev = curr
                    curr = next
                }

                // Connect the reversed group to the previous part of the list
                prevTail?.next = prev
                tail.next = next
                curr = next
                prevTail = tail

            } else { // If the group size is odd, skip reversing
                for (i in 1..groupSize) {
                    prevTail = curr
                    curr = curr?.next
                }
            }
            group++ // Move to the next group
        }
        return head
    }
}
