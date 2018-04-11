# -*- coding:utf-8 -*-
from scipy.stats import chi2

'''
卡方拟合优度检验
'''


class Solution:
    def __init__(self):
        pass

    def solve(self):
        accept = True
        n = 43 + 21 + 35
        freedom = 3 - 1
        x_2 = 0
        accept = True
        for i in [43, 21, 35]:
            x_2 += i ** 2 / (n / 3.0)
        x_2 = x_2 - n
        if x_2 > chi2.ppf(0.975, freedom):
            accept = False
        return [freedom, round(x_2, 2), accept]


print Solution().solve()
