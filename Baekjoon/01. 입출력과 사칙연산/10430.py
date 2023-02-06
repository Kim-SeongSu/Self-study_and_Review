A, B, C = input().split()
A, B, C = int(A), int(B), int(C)
print(f'{(A+B)%C}\n{((A%C) + (B%C))%C}\n{(A*B)%C}\n{((A%C) * (B%C))%C}')