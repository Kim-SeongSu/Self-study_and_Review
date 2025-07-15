// 정보처리기사 실기 C++ 기출문제 //

/* 2025년도 - 1회 10

개념)
for 문에서의 전위 증가(++i; 반환값 증가 후)와 후위 증가(i++; 반환값 증가 전)는 차이가 없다!
*/

// 풀이)
#include <stdio.h>
char Data[5] = {'B', 'A', 'D', 'E'}; // Data= {'B', 'A', 'D', 'E', Null}
char c;

int main(){
    int i, temp, temp2;

    c = 'C';
    printf("%d\n", Data[3] - Data[1]); // Data[3]='E', Data[1]='A'
                                       // 'E' - 'A' = 4 ( ASCII 기준: 69 - 65 = 4)
                                       // '4' 출력(+줄바꿈)

    for (i = 0; i < 5; ++i){ // i=0부터 4까지 1씩 증가, Data[i]가 'C'보다 클 때 정지
        if (Data[i] > c)     // Data[2]='D'에서 정지 ('D' > 'C')
            break;
    }

    temp = Data[i]; // temp = 'D'
    Data[i] = c;    // Data[2] = 'C'    →   Data= {'B', 'A', 'C', 'E', Null}
    i++;            // i=3

    for (; i < 5; ++i){  // i=3부터 4까지 1씩 증가,
        temp2 = Data[i]; // temp2 = Data[3] = 'E'
        Data[i] = temp;  // Data[3] = temp = 'D'
        temp = temp2;    // temp = temp2 = 'E'
    }                    // 결과) Data= {'B', 'A', 'C', 'D', 'E'}

    for (i = 0; i < 5; i++){
        printf("%c", Data[i]); // BACDE
    }
}

/* 정답)
4
BACDE

~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~ */

/* 2025년도 - 1회 11

개념)
int* data : int 배열 (1차원)를 가리키는 포인터
    ex. int data[] = {5, 2, 7, ...}를 int*로 받을 수 있음

int** arr : int 포인터들의 배열 = 2차원 배열 표현

set(): 특이한 인덱싱 방식으로 2차원 배열에 데이터를 배치
malloc(): 메모리의 동적 할당
free(): 메모리 반납
*/

// 풀이)
#include <stdio.h>
#include <stdlib.h>

void set(int **arr, int *data, int rows, int cols){
    for (int i = 0; i < rows * cols; ++i){                                                           // for (int i = 0; i < 3 * 3; ++i)
        arr[((i + 1) / rows) % rows][(i + 1) % cols] = data[i]; // data[0] = arr[(1/3)%3][1%3] = arr[0][1]
    }
}

/*
data[0] = 5 = arr[(1/3)%3][1%3] = arr[0][1]
data[1] = 2 = arr[(2/3)%3][2%3] = arr[0][2]
data[2] = 7 = arr[(3/3)%3][3%3] = arr[1][0]
data[3] = 4 = arr[(4/3)%3][4%3] = arr[1][1]
data[4] = 1 = arr[(5/3)%3][5%3] = arr[1][2]
data[5] = 8 = arr[(6/3)%3][6%3] = arr[2][0]
data[6] = 3 = arr[(7/3)%3][7%3] = arr[2][1]
data[7] = 6 = arr[(8/3)%3][8%3] = arr[2][2]
data[8] = 9 = arr[(9/3)%3][9%3] = arr[0][0]

arr = [
    [9, 5, 2]
    ,[7, 4, 1]
    ,[8, 3, 6]]
*/

int main(){
    int rows = 3, cols = 3, sum = 0;
    int data[] = {5, 2, 7, 4, 1, 8, 3, 6, 9};
    int **arr;

    arr = (int **)malloc(sizeof(int *) * rows);

    for (int i = 0; i < cols; i++){ // arr 각 행에 int 배열 할당
        arr[i] = (int *)malloc(sizeof(int) * cols);
    }

    set(arr, data, rows, cols);

    for (int i = 0; i < rows * cols; i++){
        sum += arr[i / rows][i % cols] * (i % 2 == 0 ? 1 : -1); // 홀수면 -1, 짝수면 1 곱해주기
    }

    /*
    arr[0 / 3][0 % 3] * 1   = arr[0][0] = 9
    arr[(1/3)%3][1%3] * -1  = arr[0][1] = -5
    arr[(2/3)%3][2%3] * 1   = arr[0][2] = 2
    arr[(3/3)%3][3%3] * -1  = arr[1][0] = -7
    arr[(4/3)%3][4%3] * 1   = arr[1][1] = 4
    arr[(5/3)%3][5%3] * -1  = arr[1][2] = -1
    arr[(6/3)%3][6%3] * 1   = arr[2][0] = 8
    arr[(7/3)%3][7%3] * -1  = arr[2][1] = -3
    arr[(8/3)%3][8%3] * 1   = arr[2][2] = 6

    sum = 9 - 5 + 2 - 7 + 4 - 1 + 8 - 3 + 6
        = 13

    */

    for (int i = 0; i < rows; i++){ // 메모리 반납 (각 행)
        free(arr[i]);
    }
    free(arr); // 메모리 반납 (배열)

    printf("%d", sum);
}

/* 정답)
13

~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~ */

/* 2025년도 - 1회 18

개념)
1. 포인터 (pointer)
+---------+-----------------------------------+--------------------------+
|  연산자  |           의미                     |           예시           |
+---------+-----------------------------------+--------------------------+
|    *    | 포인터 선언 or 역 참조               | *p = 10;                |
|         | 포인터가 가리키는 대상에 접근하는 연산자 | *p = 10;                |
|    &    | 변수의 주소를 가져오는 연산자          | p = &a;                 |
|    []   | 배열/포인터의 인덱스 접근             | arr[2], *(arr + 2)       |
+---------+-----------------------------------+--------------------------+

포인터 예시)
int *p;                         // p는 int형을 가리키는 포인터 (스타일 차이 - C)            (포인터 선언)
int* p;                         // p는 int형을 가리키는 포인터 (스타일 차이 - java & C++)

int* p1, p2;                    // p1: 포인터 p2: 그냥 int
int *p1, *p2;                   // p1과 p2 모두 포인터


int a = 42;
int *p = &a;                    // &a : 변수 a의 주소 → p에 저장  (역참조; 포인터가 가리키는 값에 접근)
int **pp = &p;

printf("%d\n", a);              // a   : 42 (실제 값)
printf("%d\n", *p);             // *p  : p(= &a)가 가리키는 값    = a의 주소값이 가리키는 값    = a (= 42)
printf("%d\n", **pp);           // **pp: p의 주소값(= &a) 

    a   : 실제 값
    p   : &a (a의 주소값)   ->  *p  : a의 주소값이 가리키는 값 = a
    pp  : &p (p의 주소값)   ->  *pp : p의 주소값이 가리키는 값 = &a = p  ->  **pp :  a의 주소값이 가리키는 값 = a

**pp = 11;

printf("%d\n", a);              // 11
printf("%d\n", *p);             // 11
printf("%d\n", **pp);           // 11

int arr[] = {1, 2, 3};

printf("%d\n", arr[1]);         // 2
printf("%d\n", *(arr + 1));     // 2 (동일함)


2. -> : 포인터로 구조체 멤버에 접근할 때 쓰는 간단한 표기법
    *예시) new_node->value = value;
        =  (*new_node).value = value;
        =  new_node가 가리키는 구조체의 value 멤버에 접근해서 값을 대입

    c의 '->'는 객체의 주소(포인터) 를 통해 접근 (간접 접근)
    java와 python의 '.'은 객체가 실제로 존재할 때 사용 (객체 직접 접근)

3. 단일 연결 리스트:	노드가 한 방향으로만 연결됨 (next)
4. 포인터 조작	prev, curr 포인터를 사용해 링크 구조를 재배치
5. 동적 메모리	malloc()으로 노드 동적 할당
*/

// 풀이)
#include <stdio.h>
#include <stdlib.h>

typedef struct Data{                // 연결 리스트의 노드 구조
    int value;                      // value는 저장된 값, next는 다음 노드를 가리키는 포인터
    struct Data *next;
} Data;

Data* insert(Data* head, int value){ // 항상 리스트 맨 앞에 새 노드 추가
    Data* new_node = (Data*)malloc(sizeof(Data));
    new_node->value = value;        // (*new_node).value = value; 와 같음
    new_node->next = head;          // (*new_node).next = head; 와 같음             새로운 노드 -> 기존 노드 -> ...
    return new_node;
}

Data* reconnect(Data* head, int value){         // 특정 값을 가진 노드를 찾아서 리스트 맨 앞으로 옮김
    if (head == NULL || head->value == value)   // ㄱ
        return head;
    Data *prev = NULL, *curr = head;
    while (curr != NULL && curr->value != value){
        prev = curr;
        curr = curr->next;      // curr = (*curr).next; 
    }

    if (curr != NULL && prev != NULL){
        prev->next = curr->next;    // (*prev).next = (*curr).next
        curr->next = head;
        head = curr;
    }
    return head;
}

int main(){

    Data *head = NULL, *curr;
    for (int i = 1; i <= 5; i++)    
        head = insert(head, i);     // 삽입 순서: 1 → 2 → 3 → 4 → 5 (스택처럼 앞에 붙임)     >>   54321
    head = reconnect(head, 3);      // 3을 찾아서 맨 앞으로 이동        >>   35421
    for (curr = head; curr != NULL; curr = curr->next)
        printf("%d", curr->value);
    return 0;
}

/* 정답)
35421
~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~ */
/* 2025년도 - 1회 19

개념)
1.기본 진법 표현 방식

2진수   0b1010
8진수   012 또는 0o12
10진수  10
16진수  0xA0

2. 16진수 2진수 변환 (16진수 = 2진수 4자리)
+--------+------+-------+
| 16진수 | 2진수 | 10진수 |
+--------+------+-------+
| 0      | 0000 | 0     |
| 1      | 0001 | 1     |
| 2      | 0010 | 2     |
| 3      | 0011 | 3     |
| 4      | 0100 | 4     |
| 5      | 0101 | 5     |
| 6      | 0110 | 6     |
| 7      | 0111 | 7     |
| 8      | 1000 | 8     |
| 9      | 1001 | 9     |
| A (10) | 1010 | 10    |
| B (11) | 1011 | 11    |
| C (12) | 1100 | 12    |
| D (13) | 1101 | 13    |
| E (14) | 1110 | 14    |
| F (15) | 1111 | 15    |
+--------+------+-------+


*/

// 풀이)
#include <stdio.h>
 
typedef struct student {
    char* name;
    int score[3];
} Student;
 
int dec(int enc) {      // 입력된 수와 10100101의 AND 연산 리턴
    return enc & 0xA5;      // 0xA5 >>> A: 10 (1010) 5: (0101)  >>> 10100101 (= 128 + 32 + 4 + 1 = 160)
}
 
int sum(Student* p) {
    return dec(p->score[0]) + dec(p->score[1]) + dec(p->score[2]);  // 학생의 모든 점수 더하기( with. dec 연산)
}
 
int main() {
    Student s[2] = { "Kim", {0xA0, 0xA5, 0xDB}, "Lee", {0xA0, 0xED, 0x81} };    // kim: 10100000, 10100101, 11011011
                                                                                // lee: 10100000, 11101101, 10000001
    Student* p = s;
    int result = 0;
 
    for (int i = 0; i < 2; i++) {
        result += sum(&s[i]);       // result = 454 + 454 = 908

        /*
        kim
        10100000 & 10100101 = 10100000 = 160
        10100101 & 10100101 = 10100101 = 165
        11011011 & 10100101 = 10000001 = 129
        return 160 + 165 + 129 = 454

        lee
        10100000 & 10100101 = 160
        11101101 & 10100101 = 10100101 = 165
        10000001 & 10100101 = 10000001 = 129
        return 160 + 165 + 129 = 454
        */
    }
    printf("%d", result);
    return 0;
}

/* 정답)
908

~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~ */
/* 2024년도 - 회 

개념)

*/

// 풀이)




/* 정답)
~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~ */