# -*- coding:utf-8 -*-


class Solution:
    def __init__(self):
        pass

    def solve(self, A):
        # use isPalindrom function to check if the string is palindrome or not
        res = list()
        for a in A:
            if self.isPalindrome(a):
                res.append(a)
        return res

    def isPalindrome(self, x):
        lens = len(x)
        res = True
        for i in range(0, lens / 2):
            if x[i] != x[lens - 1 - i]:
                res = False
        return res


print Solution().solve(['123', '232', '4556554', '12123', '3443', '1314131'])
