# N floor building dropping K eggs, exist floor F(0<=F<=N) where the dropping egg is just not broken
# In worst case, at least how many times can eggs be dropped to find the exact floor F?

# O(space) = O(KN)
# O(time) = O(KN) * O(N) = O(KN^2)

def eggDrop(K:int, N:int):
    memo = dict()
    def dp(K, N) -> int:
        # base case
        if N == 0: return 0
        if K == 1: return N
        # avoid repeat
        if (K,N) in memo:
            return memo[(K,N)]
        
        res = float('INF')
        for i in range(1, N+1):
            res = min(res, max(
                dp(K-1, i-1), # egg broken
                dp(K, N-i) # egg not broken
            ) + 1 # floor i drop once
        ) 

        memo[(K,N)] = res
        return res

    return dp(K,N)

K = 2
N = 100
e = eggDrop(K,N)
print(e)