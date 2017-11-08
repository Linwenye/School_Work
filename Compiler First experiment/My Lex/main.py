import re
import NFA_to_DFA
import RE_to_NFA
import My_RE
from My_RE import comment_signal


def first_scan(file_path):
    # temporary not care about report line number of error

    with open(file_path) as f:
        lin_num = 0
        for line in f:
            lin_num += 1
            # delete comment
            line = line[:line.find(comment_signal)]

            # delete space
            # .# line = ' '.join(line.split(' ')) --> can't recognize tab
            line = re.sub(r'\s+', ' ', line.strip())

            # check if null
            if not line.strip():
                continue

            # revoke the second scan to get lexical analyse

            for lexeme in line.split():
                get_token(lexeme, lin_num)


def get_token(word_to_analyse, lin_num):
    if word_to_analyse in My_RE.reserved_word:
        print_to_file(word_to_analyse + ' ' + word_to_analyse.upper())
        return
    dfa_node = dfa_o.dfa[0]
    tem_res = None
    i = 0
    for j in range(i, len(word_to_analyse)):
        char = word_to_analyse[j]
        if char not in dfa_node.edge:
            dfa_node = dfa_o.dfa[0]
            i = j + 1
            if tem_res:
                if char in My_RE.character and tem_res.split()[1] == 'num':
                    print_to_file('Line' + str(lin_num) + ': Error, ' + tem_res.split()[
                        0] + char + ':' + ' id can not start with number')
                print_to_file(tem_res)
                tem_res = None
            continue
        else:
            ii = dfa_node.edge.index(char)
            dfa_node = dfa_node.next[ii]
            if dfa_node.state in dfa_o.terminals.keys():
                tem_res = word_to_analyse[i:j + 1] + ' ' + dfa_o.terminals[dfa_node.state]
            if j == len(word_to_analyse) - 1:
                print_to_file(tem_res)


def print_to_file(strings):
    output_file.write(strings + '\n')


if __name__ == '__main__':
    nfa_id = RE_to_NFA.re_to_nfa(My_RE.identification)
    RE_to_NFA.set_init()

    nfa_num = RE_to_NFA.re_to_nfa(My_RE.number)
    RE_to_NFA.set_init()

    nfa_reserve = RE_to_NFA.re_to_nfa('|'.join(My_RE.reserved_word))
    RE_to_NFA.set_init()

    nfa_oper = RE_to_NFA.re_to_nfa('|'.join(My_RE.oprator))
    RE_to_NFA.set_init()

    end_state_token = dict()
    end_state_token[nfa_reserve.end] = 'reserve'
    end_state_token[nfa_id.end] = 'id'
    end_state_token[nfa_num.end] = 'num'
    end_state_token[nfa_oper.end] = 'operator'

    nfa1 = RE_to_NFA.NFAor(nfa_reserve, nfa_oper)
    nfa2 = RE_to_NFA.NFAor(nfa_id, nfa_num)
    nfa = RE_to_NFA.NFAor(nfa1, nfa2)
    dfa_o = NFA_to_DFA.tran_table(nfa.start, My_RE.terminals)
    dfa_o.DFA_to_DFAo(nfa.end, end_state_token)

    outputpath = 'E:\GitHub\School_Work\Compiler First experiment/token_out.txt'
    output_file = open(outputpath, 'w')
    first_scan('E:\GitHub\School_Work\Compiler First experiment\Python_file_for_test.py')
