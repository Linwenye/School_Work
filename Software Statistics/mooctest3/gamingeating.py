# -*- coding:utf-8 -*-
'''
t检验的统计量
'''
from scipy.stats import t
from scipy.stats import norm


class Solution:
    def __init__(self):
        pass

    def solve(self):
        free = 42
        accept = True
        sw = ((21 * 45.1 ** 2 + 21 * 26.4 ** 2) / 42) ** 0.5
        st = (52.1 - 27.1) / (sw * (1.0 / 22 + 1.0 / 22) ** 0.5)
        print st
        if st > t.ppf(0.975, 42):
            accept = False
        return [free, round(st, 2), accept]

    def solve2(self):
        free = 22 - 1
        accept = True
        sw = ((45.1 ** 2 * 21.0 + 26.4 ** 2 * 21.0) / 42) ** 0.5
        st = (52.1 - 27.1) / (sw * (1.0 / 22.0 + 1.0 / 22.0) ** 0.5)
        print st
        if st > norm.ppf(0.975):
            accept = False
        return [free, round(st, 2), accept]


print Solution().solve()
print Solution().solve2()
