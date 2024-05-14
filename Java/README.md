<div align='center'>
<img src="https://capsule-render.vercel.app/api?type=transparent&color=timeAuto&height=100&section=header&fontSize=50&descAlign=60&descSize=20&descAlignY=83&text=Java%20Study&desc=Basic%20grammar"/>

</div>
<br><br>

## Java 기본 구조
``` Java
public class Main {
    public static void main(String[] args) {
        # 자료형
        String s = ""          # String
        int i = 0              # int
        int[] arr = {1,2,3,4}  # 숫자로 이루어진 배열
    }
}
```
<br><br><br>

## Java 기본 문법
> `if 문`
``` Java
# 중괄호 생략 가능!
if ( 조건식 1) {
    조건식 1 = True 일 때 수행할 문장;
} elif ( 조건식 2 ){
    조건식 1 = False
    조건식 2 = True 일 때 수행할 문장;
} else {
    조건식 1 = 조건식 2 = False
    거짓일 때 수행할 문장;
}
```
<br><br>

> `for 문`
``` Java
for (int i=0; i < 10; i++){
  수행할 문장;
}
```
<br><br>

> `switch 문`
``` Java
switch ( 실행할 연산 ) {
    case 연산 결과:
        수행할 문장;
        break;          # switch 문 벗어나기
    default:            # else 와 같은 역할
        수행할 문장;
}
```
<br><br><br>


## Java 라이브러리 및 함수
> `Scanner` (input 함수)
``` Java
# util 라이브러리 import
import java.util.Scanner;

# Scanner 함수를 'sc'라는 변수로 새롭게 지정 
Scanner sc = new Scanner(System.in);

# 자료형별 입력 함수
sc.nextInt();     # Int 이어서 입력 받기
sc.next();        # String 이어서 입력 받기
sc.nextLine();    # 한 줄 전체 입력 받기
sc.nextBoolean(); # Boolean 이어서 받기
```
<br><br>


> `BigInteger` (큰 정수 값)
``` Java
# math 라이브러리 
import java.math.BigInteger;

BigInteger a = sc.nextBigInteger();
BigInteger b = sc.nextBigInteger();

# BigInteger는 고유한 연산과정 갖음!
a.add(b);       # a+b
a.subtract(b);  # a-b
a.multiply(b);  # a*b
a.divide(b);    # a/b
a.remainder(b); # a%b

a.divide(BigInteger.valueOf(2)) # 만약 정수로 나누고싶다면, valueOf() 사용
```
<br><br>

> `toUpperCase() / toLowerCase()` (대/소문자 변환)
``` Java
s.toUpperCase()
s.toLowerCase()
```
<br><br>

> `trim()` (공백 제거)
``` Java
s.trim()
```
<br><br>
