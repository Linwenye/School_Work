# coding=utf-8
import urllib
import csv
from scipy.stats import norm


def avg(ls):
    res = 0
    for item in ls:
        res += item
    return res / len(ls)


def avgd(ls):
    res = 0
    for item in ls:
        res += (item - avg(ls)) ** 2
    return res / len(ls)


def newls(ls1, ls2):
    res = []
    for x, y in zip(ls1, ls2):
        res.append(y - x)
    return res


class Solution:
    def __init__(self):
        pass

    def solve(self):
        f = urllib.urlopen('http://py.mooctest.net:8081/dataset/temperature/temperature_2010.csv')
        reader = csv.reader(f)
        datals2010 = []
        i = 0
        for row in reader:
            if i < 6:
                i += 1
                continue
            if row[8] != '':
                datals2010.append(float(row[8]))

        f2 = urllib.urlopen('http://py.mooctest.net:8081/dataset/temperature/temperature_2014.csv')
        reader2 = csv.reader(f2)
        datals2014 = []
        j = 0
        for row2 in reader2:
            if j < 5:
                j += 1
                continue
            if row2[8] != '':
                datals2014.append(float(row2[8]))

        ls = newls(datals2010, datals2014)
        n1 = len(ls)
        av = avg(ls)
        z = av / (avgd(ls) / n1 ** 0.5)
        print z
        if z > norm.ppf(0.95):
            return 'YES'
        else:
            return 'NO'

print Solution().solve()

