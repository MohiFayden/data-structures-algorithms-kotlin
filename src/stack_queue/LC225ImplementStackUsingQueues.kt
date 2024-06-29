package stack_queue

/**
 * 225. Implement Stack using Queues
 *
 * Easy
 *
 * Implement a last-in-first-out (LIFO) stack using only two queues. The implemented stack should support all the functions of a normal stack (push, top, pop, and empty).
 *
 * Implement the MyStack class:
 *
 * void push(int x) Pushes element x to the top of the stack.
 * int pop() Removes the element on the top of the stack and returns it.
 * int top() Returns the element on the top of the stack.
 * boolean empty() Returns true if the stack is empty, false otherwise.
 * Notes:
 *
 * You must use only standard operations of a queue, which means that only push to back, peek/pop from front, size and is empty operations are valid.
 * Depending on your language, the queue may not be supported natively. You may simulate a queue using a list or deque (double-ended queue) as long as you use only a queue's standard operations.
 *
 *
 * Example 1:
 *
 * Input
 * ["MyStack", "push", "push", "top", "pop", "empty"]
 * [[], [1], [2], [], [], []]
 * Output
 * [null, null, null, 2, 2, false]
 *
 * Explanation
 * MyStack myStack = new MyStack();
 * myStack.push(1);
 * myStack.push(2);
 * myStack.top(); // return 2
 * myStack.pop(); // return 2
 * myStack.empty(); // return False
 *
 *
 * Constraints:
 *
 * 1 <= x <= 9
 * At most 100 calls will be made to push, pop, top, and empty.
 * All the calls to pop and top are valid.
 *
 *
 * Follow-up: Can you implement the stack using only one queue?
 */

class LC225ImplementStackUsingQueues() {

    // Intuition:
    // This implementation of a stack uses a single queue (ArrayDeque) to mimic
    // the behavior of a stack. The key idea is to maintain the order of elements
    // such that the last pushed element is always at the front of the queue.
    // This is achieved by rotating the queue each time an element is pushed.
    // The 'push' operation involves adding the new element at the end of the queue
    // and then rotating the queue to move this new element to the front.
    // The 'pop' operation simply removes the element from the front of the queue.
    // The 'top' operation returns the element at the front without removing it.
    // The 'empty' operation checks if the queue is empty.

    private val queue = ArrayDeque<Int>()

    /**
     * Push element x onto stack.
     * We add the element to the end of the queue and then
     * rotate the queue so that the newly added element is at the front.
     */
    fun push(x: Int) {
        val size = queue.size
        queue.addLast(x)  // Add the element to the end of the queue

        // Rotate the queue to move the new element to the front
        repeat(size) {
            queue.addLast(queue.removeFirst()) // Move each element to the end of the queue
        }
    }

    /**
     * Removes the element on top of the stack and returns that element.
     * Since the top element of the stack is always at the front of the queue,
     * we remove and return the element from the front.
     */
    fun pop(): Int {
        return queue.removeFirst()  // Remove and return the front element
    }

    /**
     * Get the top element.
     * Returns the element at the front of the queue without removing it.
     */
    fun top(): Int {
        return queue.first()  // Return the front element without removing it
    }

    /**
     * Returns whether the stack is empty.
     * Checks if the queue is empty.
     */
    fun empty(): Boolean {
        return queue.isEmpty()  // Return true if the queue is empty, false otherwise
    }

}

/**
 * Your MyStack object will be instantiated and called as such:
 * var obj = MyStack()
 * obj.push(x)
 * var param_2 = obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.empty()
 */
