S = input().upper()
results = {i: S.count(i) for i in set(S)}
result = [i for i in set(S) if S.count(i) == max(list(results.values()))]
print(result[0] if len(result) == 1 else '?')