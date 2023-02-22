S = input().lower()
result ={}
alphbet = [chr(x) for x in range(97, 123)]
for i in alphbet:
    if i in S:
        result[i] = S.count(i)
    else:
        pass
print(k.upper() for k,v in result.items() if v == str(max(result.values())))