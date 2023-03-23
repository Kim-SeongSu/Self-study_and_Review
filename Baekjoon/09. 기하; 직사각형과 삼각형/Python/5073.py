while (A:=input()) != '0 0 0':
    a,b,c = map(int,A.split())
    if a+b+c <= 2 * max(a,b,c):
        print('Invalid')
    else:
        if a == b == c:
            print('Equilateral')
        elif (a!=b) & (a!=c) & (b!=c):
            print('Scalene')
        else:
            print('Isosceles')