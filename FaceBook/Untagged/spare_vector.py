# Hash Map method

# Two pointers method
def dot_product(v1, v2):
    l1 = preprocess(v1)
    l2 = preprocess(v2)

    pos1, pos2 = 0, 0
    result = 0
    while pos1 < len(l1) and pos2 < len(l2):
        if l1[pos1][0] == l2[pos2][0]:
            result += l1[pos1][1] * l2[pos2][1]
        elif l1[pos1][0] < l2[pos2][0]:
            pos1 += 1
        else:
            pos2 += 1
    return result


def preprocess(v):
    result = []
    for i, ele in v:
        if ele != 0:
            result.append(i, ele)
    return result
