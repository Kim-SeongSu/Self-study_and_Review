N = int(input())

ten, one = N // 10 , N % 10
counts, new_number = 0, -1

while True:
    if new_number != N:
        new_number = one*10 + (ten+one)%10
        ten, one = new_number // 10 , new_number % 10
        counts += 1
    else:
        break

print(counts)
