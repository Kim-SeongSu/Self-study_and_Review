S = input()

# string 모듈 사용                                # 아스키 코드 사용
from string import ascii_lowercase               # alphbet = [chr(x) for x in range(97, 123)]
alphabet = list(ascii_lowercase)

for i in alphabet:
    print(S.find(i), end=' ')