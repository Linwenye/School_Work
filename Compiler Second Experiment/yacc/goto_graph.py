def shift(list_shifted, list_unshifted):
    list_shifted.append(list_unshifted.pop(0))


class Node:
    def __init__(self, state):
        """
        using ~ to represent the augment start symbol
        """

        # next node index
        self.next = []
        # by the edge to the next node
        self.edge = []

        # data structure:[(char1,list1,list2,a)]
        # char1 represents nonterminal;
        # list1 represents shifted chars;# list2 reprensents unshifted ones;a reprensents lookahead
        self.production_list = []

        self.state = state

    def closure(self):
        for production in self.production_list:
            self._closure(production)

    def _closure(self, production):
        if production[2]:
            first_set = self.first(production)
            symbol = production[2][0]
            for grammar in grammars:
                if grammar[0] == symbol:
                    for predict in first_set:
                        self._add_production(grammar, predict)

    def _add_production(self, grammar, predict):
        new_prod = (grammar[0], [], grammar[1], predict)
        if new_prod not in self.production_list:
            self.production_list.append(new_prod)
            self._closure(new_prod)

    def first(self, production):
        res = set()
        unshifted = production[2][1:]
        predict = production[3]
        if not unshifted:
            res.add(predict)
            return res
        elif unshifted[0] not in nonterminal_set:
            res.add(unshifted[0])
            return res
        else:
            res = self._first(unshifted[0])

        return res

    def _first(self, char):
        res = set()
        if not char:
            return res
        elif char not in nonterminal_set:
            res.add(char)
            return res
        else:
            for grammar in grammars:
                if grammar[0] == char and not grammar[0] == grammar[1][0]:
                    res.update(self._first(grammar[1][0]))
        return res


class GotoGraph:
    def __init__(self, start):
        self.state = 0

        # data structure: [s1,s2...sn]  s structure:
        self.node_list = []
        self.start_node = self.new_node()

        self.start_node.production_list.append(('~', [], [start], '$'))
        self.start_node.closure()

        self.add_node(self.start_node)

        self.items()

    def new_node(self):
        res = Node(self.state)
        return res

    def add_node(self, node):
        self.node_list.append(node)
        self.state += 1

    def goto_construct(self, productions, x):
        node = self.new_node()
        for production in productions:
            if production[2]:
                if production[2][0] == x:
                    pro1 = production[1][:]
                    pro2 = production[2][:]
                    shift(pro1, pro2)
                    node.production_list.append((production[0], pro1, pro2, production[3]))
                    node.closure()
        if node.production_list:
            return node
        else:
            return None

    def items(self):
        self._items(self.node_list[0])

    def _items(self, node):
        for x in grammar_symbols:
            tmp_node = self.goto_construct(node.production_list, x)
            if tmp_node:
                tmp = tmp_node.production_list
                in_list_index = self._in_list(tmp)
                if in_list_index < 0:
                    self.add_node(tmp_node)
                    node.next.append(tmp_node.state)
                    node.edge.append(x)
                    # tmp node recursively calculate goto
                    self._items(tmp_node)
                else:
                    if in_list_index not in node.next or (not node.edge[node.next.index(in_list_index)] == x):
                        node.next.append(in_list_index)
                        node.edge.append(x)

    def _in_list(self, pro_list):
        res = -1
        for node in self.node_list:
            if pro_list == node.production_list:
                res = node.state
        return res

    def goto(self, state_stack, shifted, unshifted):
        """
        print parsing action on input

        """

        def print_action(action):
            print 'Stack:', state_stack, 'Symbols:', shifted, 'Input:', unshifted, 'Action:', action

        while True:

            char = unshifted[0]
            state_int = state_stack[-1]
            is_end = (char == '$' and len(self.node_list[state_int].production_list) == 1 and
                      self.node_list[state_int].production_list[0][0] == '~')
            if is_end:
                print_action('accept')
                break

            if char in self.node_list[state_int].edge:
                print_action('shift')
                next_state_int = self.node_list[state_int].next[self.node_list[state_int].edge.index(char)]
                state_stack.append(next_state_int)
                shift(shifted, unshifted)

            else:
                reduction = False
                the_production = None
                for production in self.node_list[state_int].production_list:
                    if not production[2] and char == production[3]:
                        reduction = True
                        the_production = production
                if reduction:
                    print_action('reduce by ' + the_production[0] + '->' + ''.join(the_production[1]))

                    # pop shifted to reduce
                    shifted = shifted[0:len(shifted) - len(the_production[1])]
                    shifted.append(the_production[0])
                    state_stack = state_stack[0:len(state_stack) - len(the_production[1])]
                    state_stack.append(self.node_list[state_stack[-1]].next[
                                           self.node_list[state_stack[-1]].edge.index(the_production[0])])
                else:
                    # add ambiguous handling or error recovery here!
                    pass

    def parse(self, i_filepath):
        # test_filepath = "E:\GitHub\School_Work\Compiler Second Experiment/test_calculator.txt"
        f_test = open(i_filepath)
        input_stream = f_test.read()

        shifted = []
        unshifted = list(input_stream)
        unshifted.append('$')

        state_stack = [0]
        self.goto(state_stack, shifted, unshifted)


grammars = []
nonterminal_set = set()
grammar_symbols = set()
filepath = 'E:\GitHub\School_Work\Compiler Second Experiment/textbook_grammar.y'
# filepath = "E:\GitHub\School_Work\Compiler Second Experiment\input_grammar.y"
f = open(filepath)
for line in f:

    line = line.strip()
    line_split = line.split(':')
    char_nonterminal = line_split[0]
    nonterminal_set.add(char_nonterminal)
    grammar_symbols.add(char_nonterminal)

    production_split = line_split[1].split('|')
    for item in production_split:
        grammars.append((char_nonterminal, list(item)))
        grammar_symbols.update(set(item))
S = GotoGraph(grammars[0][0])

test_filepath = "E:\GitHub\School_Work\Compiler Second Experiment/test_textbook_gram.txt"
S.parse(test_filepath)
# print S
