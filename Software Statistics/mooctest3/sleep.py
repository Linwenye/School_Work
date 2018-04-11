# -*- coding:utf-8 -*-
from scipy.stats import norm

'''
ppf: 根据概率求对应的x值
cdf：查表，根据x值求概率
'''

# class Solution:
#     def __init__(self):
#         pass
#
#     def solve(self):
print norm.ppf(0.975)*5/60+8.5
print norm.ppf(0.975)*5/60+8.5
print (-norm.ppf(0.975))*5/60+8.5
print norm.pdf(0.01)
print norm.cdf(0.02)
