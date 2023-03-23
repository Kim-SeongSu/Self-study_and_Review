T = int(input())

testcases = [map(int, input().split()) for _ in range(T)]

for index, testcase in enumerate(testcases ,1):
    print(f'Case #{index}: {sum(testcase)}')