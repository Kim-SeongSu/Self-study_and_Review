# 3    1 5 15 35 70    4 10 20 35  6 10 15
# 2    1 4 10 20 35    3 6 10 15   2+ 1 2 3 4
# 1    1 3  6 10 15    2 3 4 5 6   1+ 1 2 3 4
# 0    1 2  3  4  5    1 1 1 1 1
import sys
input = sys.stdin.readline

for _ in range(int(input())):
    k,n = int(input()),int(input())
    arr = list(range(1,1+n))

    # k층의 n-1호 :A
    # k-1층의 b호 :B 
    # k층의 n호: C = A + B
    
    for _ in range(k):
        for i in range(1,n):
            arr[i] += arr[i-1]

    '''
    floor = 0
    while floor < k:
        new_arr = []
        for i in range(1,1+n):
            if i == 1:
                new_arr.append(1)
            else:
                new_arr.append(sum(arr[:i]))    
        floor += 1
        arr = new_arr
    '''
    print(arr[-1])