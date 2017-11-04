
stack_oprator = []
stack_node = []


def pop_two_stack():
    operator_char = stack_oprator.pop()
    new_right = stack_node.pop()
    new_left = stack_node.pop()
    operator_char.set_children(new_left, new_right)
    stack_node.append(operator_char)


def re_to_parsetree(reg):
    cat_needed = False
    for ch in reg:

        if ch == '(':
            if cat_needed:
                if not stack_oprator or stack_oprator[-1].value == '(' or stack_oprator[-1].value == '|':
                    stack_oprator.append(BSTreeNode('`'))

                elif stack_oprator[-1].value == '`':
                    pop_two_stack()
                    stack_oprator.append(BSTreeNode('`'))

            stack_oprator.append(BSTreeNode(ch))
            cat_needed = False
        elif ch == ')':
            operator_char = stack_oprator.pop()
            while not operator_char.value == '(':
                if operator_char.value == '`' or operator_char.value == '|':
                    operator_char.right = stack_node.pop()
                    operator_char.left = stack_node.pop()
                    stack_node.append(operator_char)
                operator_char = stack_oprator.pop()

            cat_needed = True
        elif ch == '*':
            new_node = BSTreeNode(ch)
            new_node.set_children(stack_node.pop())
            stack_node.append(new_node)
            cat_needed = True
        elif ch == '|':
            if not stack_oprator or stack_oprator[-1].value == '(':
                stack_oprator.append(BSTreeNode(ch))
            else:
                pop_two_stack()

                stack_oprator.append(BSTreeNode(ch))

            cat_needed = False
        else:
            if cat_needed:
                if not stack_oprator or stack_oprator[-1].value == '(' or stack_oprator[-1].value == '|':
                    stack_oprator.append(BSTreeNode('`'))

                elif stack_oprator[-1].value == '`':
                    pop_two_stack()
                    stack_oprator.append(BSTreeNode('`'))

            stack_node.append(BSTreeNode(ch))
            cat_needed = True

    while stack_oprator:
        pop_two_stack()
    return stack_node[0]


class BSTreeNode:
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None

    def set_children(self, left, right=None):
        self.left = left
        if right is not None:
            self.right = right

    def print_tree(self):
        print self.value
        if self.left:
            self.left.print_tree()

        if self.right:
            self.right.print_tree()


class NFA:
    def __init__(self):
        self.start = None
        self.end = None


class NFAnode:
    def __init__(self, state):
        self.next1 = None
        self.next2 = None
        self.character = None
        self.state = state


if __name__ == '__main__':
    re_to_parsetree('a*|bc(d|e)').print_tree()
