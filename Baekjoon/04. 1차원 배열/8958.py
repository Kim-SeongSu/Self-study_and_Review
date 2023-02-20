'''
# 조건문 사용
for _ in range(int(input())):
    result, point = 0,0

    for i in input():
        if i == 'X':
            point = 0
        elif i == 'O' and point != 0:
            point += 1
        else:
            point = 1
        result += point
    print(result)
'''
# len() 사용
for _ in range(int(input())):
    point = 0
    testcase = input().split('X')
    for i in range(len(testcase)):
        point += sum(range(len(testcase[i])+1))

    print(point)