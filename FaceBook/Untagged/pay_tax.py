def pay_tax():
    tax = 0
    for item in items:
        if salary > item[0]:
            tax += item[0] * item[1]
            salary -= item[0]
        else:
            tax += salary * item[1]
            break
    return tax 
