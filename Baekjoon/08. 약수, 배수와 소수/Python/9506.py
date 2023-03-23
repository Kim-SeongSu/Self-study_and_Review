while True:
    n = int(input())
    if n == -1: break
    arr = [str(i) for i in range(1,n+1) if n % i == 0]
    print(f"{arr[-1]} = {' + '.join(arr[:-1])}" if int(arr[-1]) == sum(map(int,arr[:-1])) else f'{arr[-1]} is NOT perfect.')