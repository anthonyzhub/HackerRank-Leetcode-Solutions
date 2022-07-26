# https://leetcode.com/problems/maximum-profit-in-job-scheduling/

class Node:
    
    def __init__(self, startTime, endTime, profit):
        self.startTime = startTime
        self.endTime = endTime
        self.profit = profit
        
    @property
    def info(self):
        return "startTime: {}, endTime: {}, profit: {}".format(self.startTime, self.endTime, self.profit)

class Solution:
    
    def binarySearch(self, nodes: List[Node], curNode: Node, startPtr: int, endPtr: int):
        
        # OBJECTIVE: Return index of node with earliest end time
        
        while startPtr <= endPtr:
            
            # Get middle node
            midPtr = (startPtr + endPtr) // 2
            midNode = nodes[midPtr]
            
            # If midNode.endTime is less than or equal to curNode.startTime, move to right-half of the list
            if midNode.endTime <= curNode.startTime:
                startPtr = midPtr + 1
                
            # If midNode.endTime is greater than curNode.startTime, move to left-half of the list
            else:
                endPtr = midPtr - 1
                
        return endPtr
    
    def jobScheduling(self, startTime: List[int], endTime: List[int], profit: List[int]) -> int:
        
        # Calculate number of jobs there are
        # NOTE: All arrays will always share the same size
        numOfJobs = len(startTime)
        
        # Create a list of nodes
        nodes = list()
        
        # Populate nodes list
        for i in range(len(startTime)):
            
            # Create a new node
            newNode = Node(startTime[i], endTime[i], profit[i])
            nodes.append(newNode)
        
        # Sort nodes list by end time
        nodes.sort(key= lambda elem: elem.endTime)
        # for node in nodes: print(node.info)
        
        # Create a list of total profits made based on jobs
        totalProfit = [0] * numOfJobs
        
        # Make combinations
        for i in range(numOfJobs):
            
            # Get index of node with earliest end time
            profitIdx = self.binarySearch(nodes, nodes[i], 0, i - 1)
            
            # Get profit that was previously made with that node from binarySearch()
            if profitIdx != -1:
                preProfit = totalProfit[profitIdx]
            else:
                preProfit = 0
            
            # Keep maximum profit
            totalProfit[i] = max(totalProfit[i - 1], nodes[i].profit + preProfit)
            
        return totalProfit[-1]
