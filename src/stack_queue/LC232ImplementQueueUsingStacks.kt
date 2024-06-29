package stack_queue

/**
 * 232. Implement Queue using Stacks
 *
 * Easy
 *
 * Implement a first in first out (FIFO) queue using only two stacks. The implemented queue should support all the functions of a normal queue (push, peek, pop, and empty).
 *
 * Implement the MyQueue class:
 *
 * void push(int x) Pushes element x to the back of the queue.
 * int pop() Removes the element from the front of the queue and returns it.
 * int peek() Returns the element at the front of the queue.
 * boolean empty() Returns true if the queue is empty, false otherwise.
 * Notes:
 *
 * You must use only standard operations of a stack, which means only push to top, peek/pop from top, size, and is empty operations are valid.
 * Depending on your language, the stack may not be supported natively. You may simulate a stack using a list or deque (double-ended queue) as long as you use only a stack's standard operations.
 *
 *
 * Example 1:
 *
 * Input
 * ["MyQueue", "push", "push", "peek", "pop", "empty"]
 * [[], [1], [2], [], [], []]
 * Output
 * [null, null, null, 1, 1, false]
 *
 * Explanation
 * MyQueue myQueue = new MyQueue();
 * myQueue.push(1); // queue is: [1]
 * myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
 * myQueue.peek(); // return 1
 * myQueue.pop(); // return 1, queue is [2]
 * myQueue.empty(); // return false
 *
 *
 * Constraints:
 *
 * 1 <= x <= 9
 * At most 100 calls will be made to push, pop, peek, and empty.
 * All the calls to pop and peek are valid.
 *
 *
 * Follow-up: Can you implement the queue such that each operation is amortized O(1) time complexity? In other words, performing n operations will take overall O(n) time even if one of those operations may take longer.
 */

class LC232ImplementQueueUsingStacks() {

    // Intuition:
    // We use 2 stacks (stack1 and stack2) to simulate the behavior of a queue.
    // stack1 is used for enqueue (push) operations.
    // stack2 is used for dequeue (pop) operations.
    // When stack2 is empty, we transfer all elements from stack1 to stack2.
    // This ensures that the oldest element is always on top of stack2.

    private val stack1 = ArrayDeque<Int>()  // Stack for enqueue operations
    private val stack2 = ArrayDeque<Int>()  // Stack for dequeue operations

    // Push operation: Adds an element to the end of the queue
    fun push(x: Int) {
        stack1.addLast(x)
    }

    // Pop operation: Removes and returns the element from the front of the queue
    fun pop(): Int {
        if (stack2.isEmpty()) {
            while (stack1.isNotEmpty()) {
                stack2.addLast(stack1.removeLast())
            }
        }
        return stack2.removeLast()
    }

    // Peek operation: Returns the element at the front of the queue without removing it
    fun peek(): Int {
        if (stack2.isEmpty()) {
            while (stack1.isNotEmpty()) {
                stack2.addLast(stack1.removeLast())
            }
        }
        return stack2.last()
    }

    // Empty operation: Checks if the queue is empty
    fun empty(): Boolean {
        return stack1.isEmpty() && stack2.isEmpty()
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * var obj = MyQueue()
 * obj.push(x)
 * var param_2 = obj.pop()
 * var param_3 = obj.peek()
 * var param_4 = obj.empty()
 */