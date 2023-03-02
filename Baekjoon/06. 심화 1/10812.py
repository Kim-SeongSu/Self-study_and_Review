N,M = map(int,input().split())
basket = list(range(1,N+1))

for _ in range(M):
    i,j,k = map(int,input().split())
    i,j,k = i-1,j-1,k-1

    cycle = basket[i:j+1]

    temp = cycle[i:k]
    cycle[i:k+1] = cycle[k:j+1]
    cycle[k+1:j+1] = temp

    basket[i:j+1] = cycle
print(basket)