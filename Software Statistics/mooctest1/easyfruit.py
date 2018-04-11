# -*- coding:utf-8 -*-


class Solution:
    def __init__(self):
        pass

    def solve(self, A):
        res = dict()
        for a in A:
            res[a] = res.get(a, 0) + 1
        return res


print Solution().solve(['apple', 'banana', 'cherry', 'pineapple', 'banana', 'peach', 'pear', 'peach', 'cherry'])
