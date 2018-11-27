def diameter_of_n_arr_tree(root):
    helper(root)


def helper(root):
    if root is None:
        return 0, 0

    diameter, first_depth, second_depth= 0, 0, 0
    for child in root.children:
        child_diameter, child_depth = helper(child)

        diameter = max(diameter, child_diameter)

        if child_depth >  first_depth:
            first_depth, second_depth = child_depth, first_depth
        elif child_depth > second_depth:
            second_depth = child_depth

    diameter = max(diameter, first_depth + second_depth)
    return diameter, first_depth + 1
