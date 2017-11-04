import NFA_to_DFA
import RE_to_NFA
import My_RE

if __name__ == '__main__':
    start = RE_to_NFA.re_to_nfa('(a|b)*abb').start
    NFA_to_DFA.tran_table(start, ('a', 'b'))
