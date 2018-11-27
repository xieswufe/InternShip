def findTargetSumWays(nums, S):
    """
    :type nums: List[int]
    :type S: int
    :rtype: int
    """
    results = []
    helper(nums, 0, S, '', results)
    return results

def helper(nums, index, target, formula, results):
    if index == len(nums):
        if target == 0:
            results.append(formula)
        return

    helper(nums, index + 1, target - nums[index], formula + '+' + str(nums[index]), results)
    helper(nums, index + 1, target + nums[index], formula + '-' + str(nums[index]), results)

nums = [1, 1, 1, 1, 1, 2, 2]
S = 3

print(findTargetSumWays(nums, S))
