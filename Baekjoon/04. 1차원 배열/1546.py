N = int(input())
arr = list(map(int,input().split()))
max_score = max(arr)
print(sum(x / max_score for x in arr)/N*100)