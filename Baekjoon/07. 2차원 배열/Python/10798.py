A,result = [],''
for _ in range(5):
    A.append(input())

for j in range(max(X := len(i) for i in A)):
    for i in range(5):
        try:
            result += A[i][j]
        except:
            result += ''
print(result)


'''
x=['']*75
i=0
while i<5:
 j=0;s=input()
 while j<len(s):x[j*5+i]=s[j];j+=1
 i+=1
print("".join(x))
'''