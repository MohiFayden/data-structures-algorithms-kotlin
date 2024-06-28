package linked_list

/**
 * 707. Design Linked List
 *
 * Medium
 *
 * Design your implementation of the linked list. You can choose to use a singly or doubly linked list.
 * A node in a singly linked list should have two attributes: val and next. val is the value of the current node, and next is a pointer/reference to the next node.
 * If you want to use the doubly linked list, you will need one more attribute prev to indicate the previous node in the linked list. Assume all nodes in the linked list are 0-indexed.
 *
 * Implement the MyLinkedList class:
 *
 * MyLinkedList() Initializes the MyLinkedList object.
 * int get(int index) Get the value of the indexth node in the linked list. If the index is invalid, return -1.
 * void addAtHead(int val) Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
 * void addAtTail(int val) Append a node of value val as the last element of the linked list.
 * void addAtIndex(int index, int val) Add a node of value val before the indexth node in the linked list. If index equals the length of the linked list, the node will be appended to the end of the linked list. If index is greater than the length, the node will not be inserted.
 * void deleteAtIndex(int index) Delete the indexth node in the linked list, if the index is valid.
 *
 *
 * Example 1:
 *
 * Input
 * ["MyLinkedList", "addAtHead", "addAtTail", "addAtIndex", "get", "deleteAtIndex", "get"]
 * [[], [1], [3], [1, 2], [1], [1], [1]]
 * Output
 * [null, null, null, null, 2, null, 3]
 *
 * Explanation
 * MyLinkedList myLinkedList = new MyLinkedList();
 * myLinkedList.addAtHead(1);
 * myLinkedList.addAtTail(3);
 * myLinkedList.addAtIndex(1, 2);    // linked list becomes 1->2->3
 * myLinkedList.get(1);              // return 2
 * myLinkedList.deleteAtIndex(1);    // now the linked list is 1->3
 * myLinkedList.get(1);              // return 3
 *
 *
 * Constraints:
 *
 * 0 <= index, val <= 1000
 * Please do not use the built-in LinkedList library.
 * At most 2000 calls will be made to get, addAtHead, addAtTail, addAtIndex and deleteAtIndex.
 */

class LC707DesignLinkedList() {

    var head: Node? = null // The head node of the linked list
    var size = 0 // The size of the linked list

    // Returns the value of the node at the specified index
    fun get(index: Int): Int {
        return if (size == 0 || index < 0 || index >= size) {
            // If the list is empty or the index is out of bounds, return -1
            -1
        } else {
            if (index == 0) {
                // If the index is 0, return the value of the head node
                requireNotNull(head).value
            } else {
                // Otherwise, traverse to the specified index and return the node's value
                val node = traverseToNode(index)
                node.value
            }
        }
    }

    // Adds a new node with the specified value at the head of the list
    fun addAtHead(value: Int) {
        val node = Node(value)
        node.next = head // The new node points to the current head
        head = node // The new node becomes the head
        size++ // Increment the size of the list
    }

    // Adds a new node with the specified value at the tail of the list
    fun addAtTail(value: Int) {
        addAtIndex(size, value) // Utilize addAtIndex to add the node at the end
    }

    // Adds a new node with the specified value at the specified index
    fun addAtIndex(index: Int, value: Int) {
        if (index <= size) {
            if (index == 0) {
                // If the index is 0, add the node at the head
                addAtHead(value)
            } else {
                val node = Node(value)
                // Traverse to the node just before the specified index
                val prev = traverseToNode(index - 1)
                node.next = prev.next // The new node points to the next node
                prev.next = node // The previous node points to the new node
                size++ // Increment the size of the list
            }
        }
    }

    // Deletes the node at the specified index
    fun deleteAtIndex(index: Int) {
        if (index in 0 until size) {
            if (index == 0) {
                // If the index is 0, remove the head node
                head = head?.next
            } else {
                // Traverse to the node just before the specified index
                val prev = traverseToNode(index - 1)
                prev.next = prev.next?.next // The previous node points to the node after the next
            }
            size-- // Decrement the size of the list
        }
    }

    // Helper function to traverse to the node at the specified index
    private fun traverseToNode(index: Int): Node {
        var target: Node = requireNotNull(head)

        var cur: Node? = target.next
        var counter = 0
        while (counter < index && cur != null) {
            target = cur // Move to the next node
            cur = cur.next // Update current node
            counter++ // Increment the counter
        }

        return target // Return the target node
    }

    // Data class representing a node in the linked list
    data class Node(
        val value: Int,
        var next: Node? = null
    )
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * var obj = MyLinkedList()
 * var param_1 = obj.get(index)
 * obj.addAtHead(`val`)
 * obj.addAtTail(`val`)
 * obj.addAtIndex(index, `val`)
 * obj.deleteAtIndex(index)
 */
