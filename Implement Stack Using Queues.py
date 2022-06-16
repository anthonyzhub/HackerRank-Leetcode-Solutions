# https://leetcode.com/problems/implement-stack-using-queues/

from collections import deque

class MyStack:
    
    # OBJECTIVE: Replicate a stack by using a queue.
    # NOTE: I used dequeue, instead of a list, because all operations perform in O(1) time unlike lists.

    def __init__(self):
        self.queue = deque()

    def push(self, x: int) -> None:
        self.queue.append(x)

    def pop(self) -> int:
        return self.queue.pop()

    def top(self) -> int:
        return self.queue[-1]

    def empty(self) -> bool:
        return len(self.queue) == 0


# Your MyStack object will be instantiated and called as such:
# obj = MyStack()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.top()
# param_4 = obj.empty()
