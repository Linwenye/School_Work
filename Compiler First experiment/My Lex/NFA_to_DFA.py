class DFAnode:
    def __init__(self):
        self.state = get_state()

        self.next = []  # multiple next node, like LinkedList<LinkedList<>> in java
        self.edge = []  # save with what char to turn to next

    def add_edge(self, next_node, one_edge):
        self.next.append(next_node)
        self.edge.append(one_edge)


class StateSet:
    def __init__(self):
        self.state_set_list = []  # this is a list of set; just like list(set1,set2 ...,etc)
        self.marker = []  # this marks whether the state_set in the list has calculate the e-closure(move(A,char))
        self.dfa = []

    def is_all_marked(self):
        if 0 not in self.marker:
            return True
        else:
            return False

    def get_not_marked(self):
        for i, item in enumerate(self.marker):
            if item == 0:
                return i

    def add_without_mark(self, new_state_set):
        self.state_set_list.append(new_state_set)
        self.marker.append(0)
        self.dfa.append(DFAnode())

        # def add_state_set(self, the_state_set):
        #     if the_state_set not in self.state_set_list:
        #         self.add_without_mark(the_state_set)


def tran_table(nfa_start, term_tuple):
    """
    :param term_tuple: My_RE's terminal tuple, iterate it to find the closure
    :param nfa_start: the start node of nfa
    :return: DFA
    """
    state_set = StateSet()
    s0 = execute_closure([nfa_start])
    state_set.add_without_mark(s0)

    for ch in term_tuple:
        the_state_set = execute_edge_closure(s0, ch)
        if not the_state_set:  # judge of None set
            continue
        if the_state_set not in state_set.state_set_list:
            state_set.add_without_mark(the_state_set)

            # not in state_set, so the state must be it's index in dfa
            state_set.dfa[0].add_edge(state_set.dfa[state - 1], ch)
        else:
            next_node_index = state_set.state_set_list.index(the_state_set)
            state_set.dfa[0].add_edge(state_set.dfa[next_node_index], ch)

    state_set.marker[0] = 1  # mark as looked through

    while not state_set.is_all_marked():
        index = state_set.get_not_marked()
        unmarked_s = state_set.state_set_list[index]
        dfa_node = state_set.dfa[index]
        for ch in term_tuple:
            s_next = execute_edge_closure(unmarked_s, ch)
            if not s_next:  # judge of None set
                continue
            if s_next not in state_set.state_set_list:
                state_set.add_without_mark(s_next)
                dfa_node.add_edge(state_set.dfa[state - 1], ch)
            else:
                next_node_index = state_set.state_set_list.index(s_next)
                dfa_node.add_edge(state_set.dfa[next_node_index], ch)
        state_set.marker[index] = 1

    return state_set


state = 0


def get_state():
    global state
    res = state
    state += 1
    return res


def execute_closure(nfa_node_set):
    res_set = set()
    # print nfa_node_set
    for node in nfa_node_set:
        res_set.update(_execute_closure(node))
    return res_set


def _execute_closure(nfa_node):
    res_set = set()
    res_set.add(nfa_node)
    if nfa_node.edge == '~':
        res_set.update(_execute_closure(nfa_node.next1))
        if nfa_node.next2:
            res_set.update(_execute_closure(nfa_node.next2))
    return res_set


def execute_edge_closure(nfa_node_set, ch):
    """
    :param ch:
    :param nfa_node_set:
    :return: epsilon-closure(move(A,char))
    """

    res = set()
    for node in nfa_node_set:
        edge_node = _execute_edge_closure(node, ch)
        if edge_node:
            res.add(edge_node)

    res = execute_closure(res)
    return res


def _execute_edge_closure(nfa_node, ch):
    if nfa_node.edge == ch:
        return nfa_node.next1
