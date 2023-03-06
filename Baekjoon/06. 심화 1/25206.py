rating ={'A+':4.5,'A0':4,'B+':3.5,'B0':3,'C+':2.5,'C0':2,'D+':1.5,'D0':1,'F':0}
credit, total= 0,0
for _ in range(20):
    score = input().split()
    if score[-1] != 'P':
        credit += int(score[1][0])
        total += int(score[1][0])*rating[score[-1]]
print(f'{total/credit:0.6f}')