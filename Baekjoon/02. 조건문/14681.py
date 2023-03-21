x_coordinate, y_coordinate = int(input()), int(input())

if x_coordinate > 0:
    print('1' if y_coordinate > 0 else '4')
elif x_coordinate < 0:
    print('2' if y_coordinate > 0 else '3')
else:
    print('0')
    
    
    