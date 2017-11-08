import NFA_to_DFA
import RE_to_NFA
import My_RE

if __name__ == '__main__':
    # test_example
    nfa = RE_to_NFA.re_to_nfa('(a|b)*abb')
    RE_to_NFA.set_init()
    nfa2 = RE_to_NFA.re_to_nfa('a|b|c')
    # dfa_o = NFA_to_DFA.tran_table(nfa.start, ('a', 'b')).DFA_to_DFAo(nfa.end)
    # print dfa_o
    print nfa2
