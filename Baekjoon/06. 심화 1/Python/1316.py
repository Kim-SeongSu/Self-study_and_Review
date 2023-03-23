'''
# 방법 1
result = 0
for _ in range(int(input())):
    word = input()
    test = [word[0] if len(word) == 1 else word[-1]]
    for i in range(len(word)-1):
        if word[i] != word[i+1]:
            test.append(word[i])
    
    if len(test) == len(set(test)):
        result += 1
print(result)
'''




'''
#방법 2
result = 0
for _ in range(int(input())):
    word = input(); temp = len(word)
    for i in range(len(word)-1):
        if word[i] == word[i+1]:
            temp -=1
    if len(set(word)) == temp:
        result +=1

print(result)
'''


# 참고해볼 코드
def g(a): return list(a)==sorted(a,key=a.find)
print(sum(g(input()) for _ in range(int(input()))))