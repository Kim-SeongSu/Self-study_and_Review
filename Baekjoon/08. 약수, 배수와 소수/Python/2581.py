M = int(input()); N = int(input())
L = [i for i in range(M,N+1)]
prime_N = []
for i in L:
    temp = [j for j in range(1,1+i) if i % j == 0]
    if len(temp) == 2:
        prime_N.append(i)
print(f'{sum(prime_N)}\n{prime_N[0]}' if len(prime_N) != 0 else -1)