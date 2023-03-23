## enumerate() 사용
# T = int(input())

# import sys

# testcases = [map(int, sys.stdin.readline().split()) for _ in range(T)]

# for index, testcase in enumerate(testcases ,1):
#     print(f'Case #{index}: {testcase[0]} + {testcase[1]} = {sum(testcase)}')


T = int(input())

import sys

for x in range(1,T+1):
    A,B = map(int, sys.stdin.readline().split())
    print(f'Case #{x}: {A} + {B} = {A+B}')