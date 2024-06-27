package linked_list

data class ListNode(
    var `val`: Int,
    var next: ListNode? = null,
    var prev: ListNode? = null // This can be ignored for the singly linked list
)
