// 정보처리기사 실기 C++ 기출문제 //

/* 2025년도 - 1회
10. 다음은 C언어에 대한 문제이다. 아래 코드를 확인하여 알맞는 출력값을 작성하시오.

#include <stdio.h>
char Data[5] = {'B', 'A', 'D', 'E'};
char c;
 
int main(){
    int i, temp, temp2;
 
    c = 'C';
    printf("%d\n", Data[3]-Data[1]);
 
    for(i=0;i<5;++i){
        if(Data[i]>c)
            break;
    }
 
    temp = Data[i];
    Data[i] = c;
    i++;
 
    for(;i<5;++i){
        temp2 = Data[i];
        Data[i] = temp;
        temp = temp2;
    }
 
    for(i=0;i<5;i++){
        printf("%c", Data[i]);
    }
}


개념) 
for 문에서의 전위 증가(++i; 반환값 증가 후)와 후위 증가(i++; 반환값 증가 전)는 차이가 없다!
*/

// 풀이)
#include <stdio.h>
char Data[5] = {'B', 'A', 'D', 'E'};        // Data= {'B', 'A', 'D', 'E', Null}
char c;
 
int main(){
    int i, temp, temp2;
 
    c = 'C';
    printf("%d\n", Data[3]-Data[1]);        // Data[3]='E', Data[1]='A'
                                            // 'E' - 'A' = 4 ( ASCII 기준: 69 - 65 = 4)
                                            // '4' 출력(+줄바꿈)
 
    for(i=0;i<5;++i){                       // i=0부터 4까지 1씩 증가, Data[i]가 'C'보다 클 때 정지     
        if(Data[i]>c)                       // Data[2]='D'에서 정지 ('D' > 'C')
            break;
    }
 
    temp = Data[i];                         // temp = 'D'
    Data[i] = c;                            // Data[2] = 'C'    →   Data= {'B', 'A', 'C', 'E', Null}
    i++;                                    // i=3
 
    for(;i<5;++i){                          // i=3부터 4까지 1씩 증가, 
        temp2 = Data[i];                    // temp2 = Data[3] = 'E'
        Data[i] = temp;                     // Data[3] = temp = 'D'
        temp = temp2;                       // temp = temp2 = 'E'
    }                                       // 결과) Data= {'B', 'A', 'C', 'D', 'E'}
 
    for(i=0;i<5;i++){                       
        printf("%c", Data[i]);              // BACDE
    }
}

/* 정답) 
4
BACDE

~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~ */

/* 2025년도 - 1회
11. 다음은 C언어에 대한 문제이다. 아래 코드를 확인하여 알맞는 출력값을 작성하시오.

#include <stdio.h>
#include <stdlib.h>
 
void set(int** arr, int* data, int rows, int cols) {
    for (int i = 0; i < rows * cols; ++i) {
        arr[((i + 1) / rows) % rows][(i + 1) % cols] = data[i];
    }
}
 
int main() {
    int rows = 3, cols = 3, sum = 0;
    int data[] = {5, 2, 7, 4, 1, 8, 3, 6, 9}; 
    int** arr;
    arr = (int**) malloc(sizeof(int*) * rows);
    for (int i = 0; i < cols; i++) {
        arr[i] = (int*) malloc(sizeof(int) * cols);
    }
 
    set(arr, data, rows, cols);
 
    for (int i = 0; i < rows * cols; i++) {
        sum += arr[i / rows][i % cols] * (i % 2 == 0 ? 1 : -1);
    }
 
    for(int i=0; i<rows; i++) {
        free(arr[i]);
    }
    free(arr);
 
    printf("%d", sum);
}


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
 
void set(int** arr, int* data, int rows, int cols) {                
    for (int i = 0; i < rows * cols; ++i) {                         // for (int i = 0; i < 3 * 3; ++i)
        arr[((i + 1) / rows) % rows][(i + 1) % cols] = data[i];     // data[0] = arr[(1/3)%3][1%3] = arr[0][1]
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
    ,[8, 3, 6]
]

*/

int main() {
    int rows = 3, cols = 3, sum = 0;
    int data[] = {5, 2, 7, 4, 1, 8, 3, 6, 9}; 
    int** arr;

    arr = (int**) malloc(sizeof(int*) * rows);

    for (int i = 0; i < cols; i++) {                                // arr 각 행에 int 배열 할당 
        arr[i] = (int*) malloc(sizeof(int) * cols);
    }
 
    set(arr, data, rows, cols);
 
    for (int i = 0; i < rows * cols; i++) {
        sum += arr[i / rows][i % cols] * (i % 2 == 0 ? 1 : -1);     // 홀수면 -1, 짝수면 1 곱해주기
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
 
    for(int i=0; i<rows; i++) {                                     // 메모리 반납 (각 행)
        free(arr[i]);
    }
    free(arr);                                                      // 메모리 반납 (배열)
 
    printf("%d", sum);
}

/* 정답) 
13

~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~ */

