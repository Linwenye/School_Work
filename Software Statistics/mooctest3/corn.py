# -*- coding:utf-8 -*-
from scipy.stats import t
from scipy.stats import norm

'''
 功效分析
'''


class Solution:
    def __init__(self):
        pass

    def solve(self):
        print ((norm.ppf(0.975)+norm.ppf(0.90))*94.0/40.0)**2
        print ((norm.ppf(0.95)+norm.ppf(0.90))*94.0/40.0)**2
        for i in range(1, 100):
            tt = 40 / (94 / i ** 0.5)
            if tt > t.ppf(0.90, tt - 1):
                print i
                break
        res = 49
        print type(res)
        n = 94**2 * (norm.ppf(0.95)+norm.ppf(0.90))**2/40**2
        print n
Solution().solve()
