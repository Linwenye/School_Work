import urllib
import csv
from scipy.stats import norm
from scipy.stats import chi2


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
        res.append(x * 100 / y)
    return res


class Solution:
    def __init__(self):
        pass

    def solve(self):

        f = urllib.urlopen('http://py.mooctest.net:8081/dataset/population/population_old.csv')
        reader = csv.reader(f)
        data_old = []
        i = 0
        for row in reader:
            if i < 3:
                i += 1
                continue
            if row[1] != '':
                data_old.append(float(row[1]))

        f2 = urllib.urlopen('http://py.mooctest.net:8081/dataset/population/population_total.csv')
        reader2 = csv.reader(f2)
        data_total = []
        i = 0
        for row in reader2:
            if i < 5:
                i += 1
                continue
            if row[4] != '':
                data_total.append(float(row[4]))

        ls = newls(data_old, data_total)

        av = avg(ls)
        dd = avgd(ls) ** 0.5
        res = []
        res1 = [av - norm.ppf(0.95) * dd / len(ls) ** 0.5, av + norm.ppf(0.95) * dd / len(ls) ** 0.5]
        res.append(res1)
        res2 = [(len(ls) - 1) * avgd(ls) / chi2.ppf(0.95, len(ls) - 1),
                (len(ls) - 1) * avgd(ls) / chi2.ppf(0.05, len(ls) - 1)]
        res.append(res2)
        return res
