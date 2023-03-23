a,b,c = int(input()),int(input()),int(input())
if a+b+c != 180:
    print('Error')
else:
    if a == b == c:
        print('Equilateral')
    elif (a != b) & (a != c) & (b != c):
        print('Scalene')
    else:
        print('Isosceles')