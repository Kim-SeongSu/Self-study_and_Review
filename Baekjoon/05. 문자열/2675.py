for _ in range(int(input())):
    R, S = input().split()
    for i in S:
        print(i*int(R), end='')
    print()