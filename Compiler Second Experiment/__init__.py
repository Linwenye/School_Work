ss = 'hello'
ss2 = 'hello2'


def shift(list_shifted, list_unshifted):
    # unshifted list must be a reverse one
    list_shifted.append(list_unshifted.pop())


lll = list(ss2)
llt = list(ss)
lll.reverse()
shift(llt, lll)
print lll
print llt
a = set(lll)
a.add('h')
print a
