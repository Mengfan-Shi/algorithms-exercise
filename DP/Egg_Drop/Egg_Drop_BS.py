# Improvement1: replace liner search with binary search
# O(time) = O(logN) * O(KN) = O(KNlogN)
# O(space) = O(KN)

def eggDrop(K: int, N: int):
    memo = dict()
    def dp(K,N) -> int:
        # base case
        if N == 0: return 0
        if K == 1: return N 
        if (K,N) in memo:
            return memo[(K,N)]
        res = float('INF')
        # binary search
        lo, hi = 1, N 
        while lo <= hi:
            mid = (lo + hi) // 2
            broken = dp(K-1, mid-1)
            not_broken = dp(K, N-mid)
            if broken > not_broken:
                hi = mid - 1
                res = min(res, broken + 1)
            else: 
                lo = mid + 1
                res = min(res, not_broken + 1)
        
        memo[(K,N)] = res
        return res 
    return dp(K,N)

K = 2
N = 100
e = eggDrop(K,N)
print(e)