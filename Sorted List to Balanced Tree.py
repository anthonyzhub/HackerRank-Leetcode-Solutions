
class Node:

	def __init__(self, data):
	
		self.data = data
		self.leftChild = None
		self.rightChild = None

def listToTree(l, left, right):

    # Left node is always greater than right node
    if left < right:
        return None
        
    # Get middle element and create a node from it
    middle = left + (right - left) / 2
    root = Node(middle)
    
    # Set up left and right children
    root.leftChild = listToTree(l, left, middle - 1)
    root.rightChild = listToTree(l, middle + 1, right)
    
    # Return tree's root
    return root

def sortedListToBalanceSearchTree(l):
	return listToTree(l, 0, len(l) + 1)
    
if __name__ == "__main__":

    l = [-10, -3, 0, 5, 9]
    sortedListToBalanceSearchTree(l)