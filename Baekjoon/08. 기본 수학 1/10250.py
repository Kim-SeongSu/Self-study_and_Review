for _ in range(int(input())):
    H, W, N = map(int,input().split())
    Y = str(N % W)
    XX = f'0{N/W+1}' if N/W+1 <10 else str(N / W +1)
    print(Y,XX)