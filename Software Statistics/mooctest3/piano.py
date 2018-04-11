# encoding=utf-8
from scipy.stats import t

'''
t分布
置信区间
'''


def confidence_sv(freedom, avg, sd, alpha):
    return t.ppf(alpha, freedom) * sd / (freedom + 1) ** 0.5
    # return avg


class Solution:
    def __init__(self):
        pass

    def solve(self):
        freedom = 20 - 1
        # sv = confidence_sv(freedom, 2.2, 0.975)
        sv = (5 - 4.6) / 2.2 * 20 ** 0.5
        accept = True
        if sv > t.ppf(0.975, 19):
            accept = False
        return [freedom, round(sv,2), accept]


# print Solution().solve()
