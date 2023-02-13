'''
N = int(input())
integer_list = map(int,input().split())
find_num = int(input())
counts = 0

for x in integer_list:
    if x == find_num:
        counts += 1
    else:
        pass

print(counts)
'''


N = int(input())
integer_list = list(map(int,input().split()))
find_num = int(input())

print(integer_list.count(find_num))


'''
N = int(input())
arr = map(int,input().split())
v = int(input())

print(sum(1 if x==v else 0 for x in arr))
'''

