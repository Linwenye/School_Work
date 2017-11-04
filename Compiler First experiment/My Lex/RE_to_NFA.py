# coding=utf-8

"""
Construction of an NFA from a Regular Expression
using Thompson algorithm

                writen by LinWenye on 2017/10/31
"""


class NFAnode:
    # maybe the set next method should be include, thus no need to set the next node everywhere in the code
    def __init__(self, edge=None):
        self.edge = edge
        self.next1 = None
        self.next2 = None
        self.state = get_state()


class NFAchar:
    """
     NFA of character
    """

    def __init__(self, edge):
        self.start = NFAnode(edge)
        self.end = NFAnode()
        self.start.next1 = self.end


class NFAor:
    """
    operator :|
    use ~ to represent ε
    """

    def __init__(self, nfa1, nfa2):
        self.start = NFAnode('~')
        self.start.next1 = nfa1.start
        self.start.next2 = nfa2.start

        self.end = NFAnode()

        nfa1.end.edge = '~'
        nfa1.end.next1 = self.end
        nfa2.end.edge = '~'
        nfa2.end.next1 = self.end


class NFAcat:
    """
    operator: `
    """

    def __init__(self, nfa1, nfa2):
        nfa1.end.edge = nfa2.start.edge
        nfa1.end.next1 = nfa2.start.next1
        nfa1.end.next2 = nfa2.start.next2

        nfa2.start = nfa1.end

        self.start = nfa1.start
        self.end = nfa2.end


class NFAclosure:
    """
    operator: *
    """

    def __init__(self, nfa):
        self.start = NFAnode('~')
        self.end = NFAnode()
        self.start.next1 = nfa.start
        self.start.next2 = self.end

        nfa.end.edge = '~'
        nfa.end.next1 = nfa.start
        nfa.end.next2 = self.end


stack_oprator = []
stack_node = []
state = 0


def re_to_nfa(reg):
    cat_needed = False
    for ch in reg:

        if ch == '(':
            if cat_needed:
                if not stack_oprator or stack_oprator[-1] == '(' or stack_oprator[-1] == '|':
                    stack_oprator.append('`')

                elif stack_oprator[-1] == '`':
                    pop_two_stack()
                    stack_oprator.append('`')

            stack_oprator.append(ch)
            cat_needed = False
        elif ch == ')':
            operator_char = stack_oprator.pop()
            while not operator_char == '(':
                if operator_char == '`' or operator_char == '|':
                    new_nfa2 = stack_node.pop()
                    new_nfa1 = stack_node.pop()
                    stack_node.append(construct_nfa(operator_char, new_nfa1, new_nfa2))
                operator_char = stack_oprator.pop()

            cat_needed = True
        elif ch == '*':
            stack_node.append(construct_nfa(ch, stack_node.pop()))
            cat_needed = True
        elif ch == '|':
            if not stack_oprator or stack_oprator[-1] == '(':
                stack_oprator.append(ch)
            else:
                pop_two_stack()

                stack_oprator.append(ch)

            cat_needed = False
        else:
            if cat_needed:
                if not stack_oprator or stack_oprator[-1] == '(' or stack_oprator[-1] == '|':
                    stack_oprator.append('`')

                elif stack_oprator[-1] == '`':
                    pop_two_stack()
                    stack_oprator.append('`')

            stack_node.append(NFAchar(ch))
            cat_needed = True

    while stack_oprator:
        pop_two_stack()
    return stack_node[0]


def get_state():
    global state
    res = state
    state += 1
    return res


def pop_two_stack():
    operator_char = stack_oprator.pop()

    new_nfa2 = stack_node.pop()
    new_nfa1 = stack_node.pop()

    stack_node.append(construct_nfa(operator_char, new_nfa1, new_nfa2))


# wrong!!! Because it's a graph, close graph. This will lead to endless recursiveness
# the right way is to mark if the node has been seeked

# def look_up_nfa(node, stat):
#     if node.state == stat:
#         return node
#     else:
#
#         if node.next1:
#             look_up_nfa(node.next1, stat)
#         if node.next2:
#             look_up_nfa(node.next2, stat)


def construct_nfa(ch, nfa1, nfa2=None):
    if ch == '|':
        return NFAor(nfa1, nfa2)
    elif ch == '`':
        return NFAcat(nfa1, nfa2)
    elif ch == '*':
        return NFAclosure(nfa1)


if __name__ == '__main__':
    # re_to_nfa('a*|bc(d|e)')
    re_to_nfa('(a|b)*abb')
    # sucessfully test 2017/11/3  LinWenye, niubi!  Python, niubi!
