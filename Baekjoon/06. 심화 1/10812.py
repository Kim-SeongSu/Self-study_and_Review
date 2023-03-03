N,M = map(int,input().split())
basket = list(range(1,N+1))

for _ in range(M):
    i,j,k = map(int,input().split())

    # wile문 사용
    # cycle = basket[i-1:j]

    # while cycle.index(basket[k-1]) != 0:
    #     cycle.append(cycle[0])
    #     del cycle[0]

    # basket[i-1:j] = cycle


    #슬라이싱 사용
    basket[i-1:j] = basket[k-1:j] + basket[i-1:k-1]

print(*basket)