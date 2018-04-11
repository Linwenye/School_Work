# -*- coding:utf-8 -*-
import math

'''
'''


def mul(num):
    res = 1
    for i in range(1, num + 1):
        res = res * i
    return res


class Solution():
    def solve(self):
        for i in range(0, 1000):
            if self.getnotzero(i) >= 0.98:
                return i

    def getP(self, k, e):
        res = e ** k / mul(k) * math.exp(-e)
        return res

    def getnotzero(self, e):
        return 1 - self.getP(0, e)


print Solution().solve()
