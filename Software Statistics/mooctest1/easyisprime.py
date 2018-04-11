# -*- coding:utf-8 -*-


class Solution:
    def __init__(self):
        pass

    def solve(self, A):
        # call function prime
        res = list()
        for a in A:
            if self.prime(a):
                res.append(a)
        return res

    def prime(self, x):
        res = True
        if x > 2:
            for i in range(2, x):
                if not x % i:
                    res = False
        return res


print Solution().solve([23, 45, 76, 67, 17])
