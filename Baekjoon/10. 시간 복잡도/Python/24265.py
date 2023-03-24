'''
def MenOfPassion(A,n):
	sum = 0
	for i in range(1,n):
		for j in range(1,n+1):
			sum += A[i] * A[j]
			print(sum)
	return sum

A = [0,1,2,3,4,5,6,7,8,9]
MenOfPassion(A,4)
'''
print(f'{int((n:=int(input()))*(n-1)/2)}\n2')