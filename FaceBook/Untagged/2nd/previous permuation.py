def previousPermuation(nums):
        if not nums:
            return []

        # Scan from right to left to find position i that nums[i] > nums[i]
        left_index = None
        for i in range(len(nums) - 2, -1, -1):
            if nums[i] > nums[i + 1]:
                left_index= i
                break

        if left_index is None:
            nums.reverse()
            return nums

        # Scan from right to left to find first position j that nums[i] > nums[j]
        for j in range(len(nums) - 1, left_index, -1):
            if nums[left_index] > nums[j]:
                right_index = j
                break

        # Swap i, j
        nums[left_index], nums[right_index] = nums[right_index], nums[left_index]

        # Reverse nums[i+1: j]
        start, end = left_index + 1, len(nums) - 1
        while start < end:
            nums[start], nums[end] = nums[end], nums[start]
            start += 1
            end -= 1

        return nums

nums = [2,1,1,1]
print(previousPermuation(nums))
