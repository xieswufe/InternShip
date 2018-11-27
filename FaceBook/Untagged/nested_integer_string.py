def to_formula(nest):
    return to_formula_helper(nest, 1)

def to_formula_helper(nest, depth):
    if not nest:
        return ''

    result = ''
    for i, ele in enumerate(nest):
        if ele.isInteger():
            result = result + str(ele.getInteger()) + '+'
        else:
            sub_result = to_formula_helper(ele.getList(), depth + 1)
            if sub_result:
                result = result + sub_result + '+'

    result.pop()
    if depth != 1:
        result = '(' + result + ')*'+ str(depth)

    return result
