'''
N = int(input())
for i in range(2,N+1):
    while N % i == 0:
        print(i)
        N = N // i
'''
N = int(input())
for i in range(2,int(N**(0.5))+2):
    while N % i == 0:
        print(i)
        N //= i
if N != 1:
    print(N)