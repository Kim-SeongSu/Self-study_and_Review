alphabet = [chr(i).upper() for i in range(97,123)]
first = [['A',2],['D',3],['G',4],['J',5],['M',6],['P',7],['T',8],['W',9]]
dials = [dict.fromkeys(alphabet[alphabet.index(i):alphabet.index(i)+3], j)  for i,j in first]
dial = {'S':7,'Z':9}
for i in dials:
    dial.update(i)

S = input()
print(sum(dial.get(i)+1 for i in S))