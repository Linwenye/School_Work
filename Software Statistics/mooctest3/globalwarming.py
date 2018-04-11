# -*- coding:utf-8 -*-
from scipy.stats import norm

'''
单边检验问题
'''


class Solution:
    def __init__(self):
        pass

    def solve(self):
        accept = True
        z = 1.1 / (4.9 / (51 ** 0.5))
        if z > norm.ppf(0.95):
            accept = False
        z = round(z, 2)
        res = [51 - 1, z, accept]
        return res


print Solution().solve()
