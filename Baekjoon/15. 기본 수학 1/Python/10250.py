'''
for _ in range(int(input())):
    H, W, N = map(int,input().split())
    row = list(range(H,H*W+1,H))

    i = 0
    while row[i] < N:
        i += 1
    j = N - row[i] -1


    col = list(range(1,H+1))
    Y = col[j]
    XX = format(int(row[i]/H),'02')
    print(str(Y)+str(XX))
    
    # target = 2
    # format(target, '03') >>> 002
    # '{0:06d}'.format(target) >>> 000002
'''    



from sys import stdin
input = stdin.readline

for t in range(int(input())):
    H, W, N = map(int, input().split())
    print(((N-1)%H+1)*100+((N-1)//H+1))