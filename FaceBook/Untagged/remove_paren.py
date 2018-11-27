# 只要求一个解
# Stack two pass
def remove_parentheses(s):
    left_paren = 0
    stack = []
    for c in s:
        if c == '(':
            left_paren += 1
            stack.append(c)
        elif c == ')':
            if left_paren > 0:
                left_paren -= 1
                stack.append(c)
        else:
            stack.append(c)

    right_paren = 0
    result = ''
    while stack:
        c = stack.pop()
        if c == ')':
            right_paren += 1
            result = c + result
        elif c == '(':
            if right_paren > 0:
                right_paren -= 1
                result = c + result
        else:
            result = c + result
    return result

# Stack one pass

# Test case
s = '((a)))a)a'
print(remove_parentheses(s))
