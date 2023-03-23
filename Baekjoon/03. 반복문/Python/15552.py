import sys

T = int(input())
testcase = [map(int,sys.stdin.readline().rstrip().split()) for _ in range(T)]

for A, B in testcase:
    print(A+B)