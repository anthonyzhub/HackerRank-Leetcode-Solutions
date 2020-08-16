#! /usr/bin/python3

class Node(object):

    def __init__(self, value):

        # Store node's data
        self.value = value

        # Setup children
        self.left = None
        self.right = None

class BinaryTree(object):

    def __init__(self, root):

        # Setup starting node
        self.root = Node(root)

    def preorder(self, parent, traversal):
        # OBJECTIVE: To traverse tree in preorder
        # Preorder: Root=>Left=>Right

        # Check if node is not empty
        if parent is not None:

            # Add node's value to string
            traversal += "{}-".format(parent.value)

            # Make recursive call to the left child
            traversal = self.preorder(parent.left, traversal)

            # Make recursive call to the right child
            traversal = self.preorder(parent.right, traversal)

        return traversal

    def inorder(self, parent, traversal):
        # OBJECTIVE: To traverse tree in inorder
        # Inorder: Left=>Root=>Right

        # Check if node is not empty
        if parent is not None:

            # Make a recursive call to left child
            traversal = self.inorder(parent.left, traversal)

            # Add node's data
            traversal += "{}-".format(parent.value)

            # Make a recursive call to right child
            traversal = self.inorder(parent.right, traversal)

        return traversal

    def postorder(self, parent, traversal):
        # OBJECTIVE: To traverse tree in postorder
        # Postorder: Left=>Right=>Root

        # Check if node is not empty
        if parent is not None:

            # Make a recursive call to left child
            traversal = self.postorder(parent.left, traversal)

            # Make a recursive call to right child
            traversal = self.postorder(parent.right, traversal)

            # Add node's data to string
            traversal += "{}-".format(parent.value)

        return traversal

    def print_tree(self, traversal_type):
        # OBJECTIVE: To print the binary tree in any traversal type

        if traversal_type == "preorder":
            return self.preorder(tree.root, "")
        elif traversal_type == "inorder":
            return self.inorder(tree.root, "")
        elif traversal_type == "postorder":
            return self.postorder(tree.root, "")

# Create tree with root having "initial value"
tree = BinaryTree(1)

# Add children to the root node
tree.root.left = Node(2)
tree.root.right = Node(3)

# Add children to the children
tree.root.left.left = Node(4)
tree.root.left.right = Node(5)

tree.root.right.left = Node(6)

tree.root.left.left.left = Node(7)
tree.root.left.left.right = Node(8)

"""
ILLUSTRATION:

            1
           / \
          2   3
         / \  /
        4   5 6
       / \
      7   8

"""

# Print tree
print("Preorder: {}".format(tree.print_tree("preorder")))
print("Inorder: {}".format(tree.print_tree("inorder")))
print("Postorder: {}".format(tree.print_tree("postorder")))