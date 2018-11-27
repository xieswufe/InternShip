class Solution:
    """
    @param L: Given n pieces of wood with length L[i]
    @param k: An integer
    @return: The maximum length of the small pieces
    """
    # Time O(log(max-min)) Space O(1)
    def woodCut(self, L, k):
        if not L:
            return 0

        start = 1
        end = max(L)

        while start + 1 < end:
            mid = (start + end) // 2
            if self.cut_wood(L, mid) >= k:
                start = mid
            else:
                end = mid

        if self.cut_wood(L, end) >= k:
            return end
        if self.cut_wood(L, start) >= k:
            return start
        return 0

    def cut_wood(self, L, length):
        count = 0
        for wood in L:
            count += wood // length
        return count
