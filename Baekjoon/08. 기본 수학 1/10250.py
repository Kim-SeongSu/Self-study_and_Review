for _ in range(int(input())):
    H, W, N = map(int,input().split())
    row = list(range(H,H*W+1,H))
    while row[i:=0] < N:
        i += 1
    j = N - row[i]

    col = list(range(1,H+1))
    Y = col[j-1]
    XX = format(int(row[i]/H),'02')
    print(str(Y)+str(XX))
    # target = 2
    # format(target, '03') >>> 002
    # '{0:06d}'.format(target) >>> 000002