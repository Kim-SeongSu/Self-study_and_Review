# 0506
# 1330
N = int(input())

for i in range(1,N+1):
  print(i)

######################################
#0507
# 2742
N = int(input())
list = []

for i in range(1,N+1):
  list.insert(0,i)
for i in range(1,N+1):
  print(list[i-1])


# 11021
T = int(input())
list = []

for i in range(1,T+1):
  A,B = map(int,input().split( ))
  list.append(A+B)
for i in range(1,T+1):
  print(f'Case #{i}: {list[i-1]}')


# 11022
T = int(input())
list = []

for i in range(1,T+1):
  A,B = map(int,input().split( ))
  C = A+B
  list.append([A,B,C])
for i in range(1,T+1):
  print(f'Case #{i}: {list[i-1][0]} + {list[i-1][1]} = {list[i-1][2]}')

###########################################################