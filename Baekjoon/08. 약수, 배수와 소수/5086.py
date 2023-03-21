while True:
    A,B = map(int,input().split())
    if (A != 0) and (B != 0):
        if (B // A > 0) and (B % A == 0):
            print('factor')
        elif (A // B > 0) and (A % B == 0):
            print('multiple') 
        else:
            print('neither')
    else:
        break

'''
while True:
    a,b=map(int,input().split())
    if a==b==0:break
    print('factor'if b%a==0 else'multiple'if a%b==0 else'neither')

'''