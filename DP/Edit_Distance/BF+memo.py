def mindistance(s1, s2) -> int:
    # add a memo
    memo = dict()
    def dp(i, j):
        if(i, j) in memo:
            return memo[(i, j)]
        if i == -1: return j + 1
        if j == -1: return i + 1
        
        if s1[i] == s2[j]:
            memo[(i, j)] = dp(i-1, j-1)
        else:
            memo[(i, j)] = min(
                dp(i-1, j) + 1,
                dp(i , j-1) + 1,
                dp(i-1, j-1) + 1
            )
        return memo[(i, j)]
    return dp(len(s1) - 1, len(s2) - 1)

s1 = 'intention'
s2 = 'execution'
d = mindistance(s1, s2)
print(d)