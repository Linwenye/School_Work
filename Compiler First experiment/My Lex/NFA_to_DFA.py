'''
Construction of an NFA from a Regular Expression
using Thompson algorithm

                writen by LinWenye on 2017/10/31
'''


class ParseTree:
    def __init__(self, re_string):
        state_num = 0
        pass

    def construct(self):
        pass


class FA:
    def __init__(self):
        self.top = Node(0)
        self.current_node = self.top

    def find_node_recursive(self,value):
        for item in self.top:


class Node:
    def __init__(self, state_num):
        self.state = state_num
        self.next = []  # multiple next node, like LinkedList<LinkedList<>> in java
    def connect(self,node2):
        self.next.append(node2)