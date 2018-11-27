
# time O(n) space O(1) Input is modified
def reverseList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        node_iter = head
        prev = None
        while node_iter:
            next = node_iter.next
            node_iter.next = prev
            prev = node_iter
            node_iter = next

        return prev

# time O(n) space O(n)
def reverseList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if head is None:
            return None

        node_stack = []
        node_iter = head
        while node_iter:
            next = node_iter.next
            node_iter.next = None
            node_stack.append(node_iter)
            node_iter = next

        reversed_head = node_stack.pop()
        reversed_node_iter = reversed_head
        while node_stack:
            reversed_node_iter.next = node_stack.pop()
            reversed_node_iter = reversed_node_iter.next

        return reversed_head
