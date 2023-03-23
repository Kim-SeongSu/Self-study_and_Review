# replace()
Croatia = ['c=','c-','dz=','d-','lj','nj','s=','z=']
S = input()
for i in Croatia:
    S = S.replace(i,'*')
print(len(S))



# 조건문 사용
'''
Croatia = ['c=','c-','dz=','d-','lj','nj','s=','z=']
S = list(input())
for i in range(len(S)-2):
    if ''.join(S[i:i+3]) in Croatia:
        S[i:i+3] = '*'

print(len(S) - sum(1 for i in range(len(S)-1) if ''.join(S[i:i+2]) in Croatia))
'''