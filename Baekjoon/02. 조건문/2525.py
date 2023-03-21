current_time_H, current_time_M = map(int,input().split())
cooking_time = int(input())


total_H, total_M = current_time_H + (current_time_M + cooking_time) // 60, (current_time_M + cooking_time) % 60

print(total_H if total_H < 24 else total_H - 24, total_M)