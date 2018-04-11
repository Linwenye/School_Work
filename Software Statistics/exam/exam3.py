# coding=utf-8
from scipy.stats import t


def avg(ls):
    res = 0
    for item in ls:
        res += item
    return res / float(len(ls))


def avgd(ls):
    res = 0.0
    for item in ls:
        res += (item - avg(ls)) ** 2
    return res / float(len(ls)-1)


def newls(ls1, ls2):
    res = []
    for x, y in zip(ls1, ls2):
        res.append(y - x)
    return res


def newls2(ls1):
    res = []
    for item in ls1:
        res.append(item / 10000.0)
    return res


class Solution:
    def __init__(self):
        pass

    def solve(self):
        datals2010 = [6, 17.3, 104.3, 101, 120.4, 91.9, 30, 41.9, 23.9, 101.2, 67.7, 48.7, 39.9, 49, 136.6, 117.6, 52.7,
                      64.9, 101.3, 83.5, 2.1, 58.6, 94.6, 62.4, 41.8, 0.2, 74.2, 40.1, 12.7, 27.8, 51.5]

        # datals2010 = newls2(datals2010)
        datals2014 = [52041, 207793, 176469, 88880, 96190, 130672, 57246, 65987, 172867, 110665, 82021, 41483, 76043,
                      40756, 81118, 106123, 96222, 21173, 65589, 33045, 1798, 494415, 52040, 70603, 102842, 930, 69103,
                      72148, 71839, 92369, 74216]
        datals2014 = newls2(datals2014)

        ls_1 = newls(datals2010, datals2014)
        print ls_1
        n1 = len(ls_1)
        av = avg(ls_1)
        print av
        print avgd(ls_1) ** 0.5
        z = av / (avgd(ls_1) ** 0.5 / n1 ** 0.5)
        if z > t.ppf(0.95, len(ls_1) - 1):
            return [z, 'YES']
        else:
            return [z, 'NO']


print Solution().solve()
