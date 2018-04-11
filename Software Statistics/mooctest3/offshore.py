# encoding=utf-8
from scipy.stats import chi2

'''
卡方独立性检验
'''


def independ(ls_horizon, ls_vertical, sum_s, ls_origin):
    ls1 = []
    for i in range(0, len(ls_origin)):
        for j in range(0, len(ls_origin[0])):
            tem = ls_vertical[i] * ls_horizon[j] / float(sum_s)
            ls1.append((ls_origin[i][j] - tem) ** 2 / tem)
    return round(sum(ls1), 2)


class Solution:
    def __init__(self):
        pass

    def solve(self):
        ls1 = [438, 389]
        ls2 = [286, 306, 235]
        sum_s = 827
        ls_origin = [[154, 132], [180, 126], [104, 131]]
        freedom = (len(ls1) - 1) * (len(ls2) - 1)
        sv = independ(ls1, ls2, sum_s, ls_origin)
        accept = True
        if sv > chi2.ppf(0.95, freedom):
            accept = False
        return [freedom, sv, accept]


print Solution().solve()
