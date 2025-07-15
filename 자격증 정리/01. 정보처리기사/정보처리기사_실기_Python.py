## 정보처리기사 실기 Python 기출문제 ## 

'''2025년도 - 1회 17

'''

# 풀이)
class Node:
    def __init__(self, value):                              # Node 클래스 생성자 (value 값 전달 받을 시) 
        self.value = value                                      # value에 전달받은 value 입력, children에 빈 배열 생성
        self.children = []
 
def tree(li):                                               # tree 생성 함수 (이진 완전 트리: 부모 인덱스 = (자식 인덱스 -1) // 2)
    nodes = [Node(i) for i in li]                           #   nodes = [Node(3), Node(5), ... , Node(21)]
    for i in range(1, len(li)):                             #   for i in range(1,7): 1부터 6까지
        nodes[(i - 1) // 2].children.append(nodes[i])       #       nodes[0].children.append(nodes[1])
                                                            #       nodes[0].children.append(nodes[2])  
                                                            #       nodes[1].children.append(nodes[3])
                                                            #       nodes[1].children.append(nodes[4])
                                                            #       nodes[2].children.append(nodes[5])
                                                            #       nodes[2].children.append(nodes[6]) 
    return nodes[0]

'''
- tree 모양
Lv 0.                     Node(3)
Lv 1.            Node(5)            Node(8)
Lv 2.      Node(12)  Node(15)   Node(18)  Node(21)
'''

def calc(node, level=0):                                    # node level이 홀수인 값 들의 총 합
    if node is None:
        return 0
    return (node.value if level % 2 == 1 else 0) + sum(calc(n, level + 1) for n in node.children)
 
li = [3, 5, 8, 12, 15, 18, 21]
 
root = tree(li)
 
print(calc(root))                                           # print(calc(root)) = 5 + 8 = 13

''' 정답)
13

~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~ '''
'''2024년도 - 3회 2

개념) 
'''

# 풀이)
def func(lst):                              # 앞 뒤 순서 바꾸는 함수
  for i in range(len(lst) //2):             # for i in range(3)    (0,1,2)
    lst[i], lst[-i-1] = lst[-i-1], lst[i]   # lst[0] <--> lst[-1]   >> lst = [6,2,3,4,5,1]
                                            # lst[1] <--> lst[-2]   >> lst = [6,5,3,4,2,1]
                                            # lst[2] <--> lst[-3]   >> lst = [6,5,4,3,2,1]
 
lst = [1,2,3,4,5,6] 
func(lst)
print(sum(lst[::2]) - sum(lst[1::2]))       # (index 0부터 2씩 index 증가한 값들의 합) - (index 0부터 2씩 index 증가한 값들의 합)
                                            # (6 + 4 + 2) - (5 + 3 + 1) = 3
''' 정답)
3
~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~ '''
'''2024년도 - 회 

개념) 
'''

# 풀이)

''' 정답)

~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~ '''