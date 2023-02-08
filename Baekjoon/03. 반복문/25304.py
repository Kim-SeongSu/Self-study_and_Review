X, N = int(input()), int(input())

shopping_list = [map(int,input().split()) for _ in range(N)]

print('Yes' if sum(a*b for a, b in shopping_list) == X else 'No')