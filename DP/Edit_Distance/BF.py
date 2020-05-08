# for each pair of s1[i], s2[j], there are four operations:
# if s1[i]=s2[j]: skip, i, j both move forward
# else: three operations
# {insert(dp(i, j-1) + 1), delete(dp(i-1, j) + 1), replace(dp(i-1, j-1) + 1)}

# Repeat problem
# for dp(i, j) => dp(i-1,j-1)
# {1. dp(i, j) => dp(i-1,j-1)
#  2. dp(i, j) => dp(i-1, j) => dp(i-1, j-1)}

def mindistance(s1, s2) -> int:
    def dp(i, j):
        # base case
        if i == -1: return j + 1
        if j == -1: return i + 1 

        if (s1[i] == s2[j]):
            return dp(i - 1, j - 1)
        else:
            return min(
                dp(i, j - 1) + 1, # insert
                dp(i - 1, j) + 1, # delete
                dp(i - 1, j - 1) + 1 # replace
            )
    return dp(len(s1) - 1, len(s2) - 1)


s1 = 'intention'
s2 = 'execution'
d = mindistance(s1, s2)
print(d)