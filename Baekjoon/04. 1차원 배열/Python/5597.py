'''
arr = [int(input()) for _ in range(28)]
arr.sort()

for x in range(1,31):
    if x not in arr:
        print(x)
    else:
        pass
'''

arr = list(map(int,range(1,31)))

for _ in range(28):
    arr.remove(int(input()))
arr.sort()
print(arr[0],arr[1],sep='\n')