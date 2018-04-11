# -*- coding:utf-8 -*-
from scipy.stats import t

'''
假设检验
'''

def confidence_sv(freedom, avg, sd, alpha):
    return t.ppf(alpha, freedom) * sd / (freedom + 1) ** 0.5


class Solution:
    def __init__(self):
        pass

    def solve(self):
        freedom = 24
        sv = (8-7.73)/(0.77/25**0.5)
        accept = True
        if sv>t.ppf(0.95,24):
            accept = False
        return [freedom,round(sv,2),accept]

print Solution().solve()
