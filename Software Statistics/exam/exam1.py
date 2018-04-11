# -*- coding:utf-8 -*-
from scipy.stats import t


def pearsonr(x, y):
    num_x = len(x)
    num_y = len(y)
    sum_x = 0.0
    sum_y = 0.0
    sum_x_y = 0.0
    x2 = 0.0
    y2 = 0.0
    if (num_x == 0) | (num_y == 0):
        return [None, None]
    sum_x = sum(x)
    sum_y = sum(y)
    for i in range(num_x):
        sum_x_y += x[i] * y[i]
        x2 += x[i] ** 2
        y2 += y[i] ** 2
    r_x_y = num_x * sum_x_y - sum_x * sum_y
    ax = (num_x * x2 - sum_x ** 2) ** 0.5
    ay = (num_x * y2 - sum_y ** 2) ** 0.5
    if (ax == 0.0) | (ay == 0.0):
        return [None, 0.0]
    r_x_y = r_x_y / ax
    r_x_y = r_x_y / ay
    if r_x_y == 1:
        return [r_x_y, 0.0]
    T = r_x_y * ((num_x - 2) / (1 - r_x_y ** 2)) ** 0.5
    p = (t.sf(abs(T), num_x - 2)) * 2
    return [round(r_x_y, 6), round(p, 6)]


class Solution:
    def __init__(self):
        pass

    def solve(self, x, y):
        return pearsonr(x, y)


print Solution().solve([1.0, 2.0, 3.0], [2.0, 2.0, 3.0])
