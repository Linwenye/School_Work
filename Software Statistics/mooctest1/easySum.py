# -*- coding:utf-8 -*-
"""
log api example: log('output is: ' + str(output))
"""


class Solution():
    def __init__(self):
        pass

    def solve(self, A):
        res = dict()
        for i in range(0, 10):
            res[i] = 0
        for a in A:
            for astr in a:
                aint = int(astr)
                res[aint] = res.get(aint, 0) + 1
        return res


print Solution().solve([''])
