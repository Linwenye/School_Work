# -*- coding:utf-8 -*-
import numpy as np


class Solution:
    def __init__(self):
        pass

    def solve(self, A):
        return np.poly1d(A) * np.poly1d(np.array([2.0, 0.0, -1.0, 1.0]))
