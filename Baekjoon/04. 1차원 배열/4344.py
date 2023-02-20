for _ in range(int(input())):
    N,*testcase = map(int,input().split())
    std = sum(testcase)/N
    result = sum(1 if x > std else 0 for x in testcase) / N * 100
    print(f'{result:.3f}%')