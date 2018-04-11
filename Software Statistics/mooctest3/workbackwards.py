# -*- coding:utf-8 -*-
from scipy.stats import t

'''
t.ppf(1-a,n)
'''


class Solution:
    def __init__(self):
        pass

    def solve(self):
        res = list()
        res1 = round((18.985 + 21.015) / 2, 2)
        res.append(res1)
        res2 = round((21.015 - 20) / t.ppf(0.975, 36 - 1) * (36 ** 0.5), 2)
        res.append(res2)
        print res
        return res


Solution().solve()
