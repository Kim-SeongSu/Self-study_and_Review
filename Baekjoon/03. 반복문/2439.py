# N = int(input())

# for star in range(N):
#     print(' '*(N-star-1)+'*'*(star+1))

N = int(input())
[print(' '*(N-star-1)+'*'*(star+1)) for star in range(N)]