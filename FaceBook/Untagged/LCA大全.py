# 普通版 LCA of BT
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root, p, q):
        """
        :type root: TreeNode
        :type p: TreeNode
        :type q: TreeNode
        :rtype: TreeNode
        """
        return self.LCA_helper(root, p, q)


    def LCA_helper(self, node, p, q):
        if node is None:
            return None

        if node == q or node == p:
            return node

        left = self.LCA_helper(node.left, p, q)
        right = self.LCA_helper(node.right, p, q)

        if left and right:
            return node
        if left:
            return left
        if right:
            return right
        return None

# 有parent指针
"""
Definition of ParentTreeNode:
class ParentTreeNode:
    def __init__(self, val):
        self.val = val
        self.parent, self.left, self.right = None, None, None
"""


class Solution:
    """
    @param: root: The root of the tree
    @param: A: node in the tree
    @param: B: node in the tree
    @return: The lowest common ancestor of A and B
    """
    def lowestCommonAncestorII(self, root, A, B):
        A_family = {}

        while A:
            A_family[A] = True
            A = A.parent

        while B:
            if B in A_family:
                return B
            B = B.parent

# LCA有可能不存在
"""
Definition of TreeNode:
class TreeNode:
    def __init__(self, val):
        this.val = val
        this.left, this.right = None, None
"""
class Solution:
    """
    @param: root: The root of the binary tree.
    @param: A: A TreeNode
    @param: B: A TreeNode
    @return: Return the LCA of the two nodes.
    """
    def lowestCommonAncestor3(self, root, A, B):
        # write your code here
        if A == B:
            return A

        node, status = self.helper(root, A, B)

        if status:
            return node
        return None

    def helper(self, root, A, B):
        if root is None:
            return None, False

        left, left_status = self.helper(root.left, A, B)
        right, right_status = self.helper(root.right, A, B)

        if root == A or root == B:
            if left:
                return root, True
            if right:
                return root, True
            return root, False
        else:
            if left and right:
                return root, True
            if left:
                return left, left_status
            if right:
                return right, right_status
            return None, False
