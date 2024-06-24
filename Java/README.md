<div align='center'>
<img src="https://capsule-render.vercel.app/api?type=transparent&color=timeAuto&height=100&section=header&fontSize=50&descAlign=60&descSize=20&descAlignY=83&text=Java%20Study&desc=Basic%20grammar"/>

</div>
<br><br>

## Java 기본 개념

> **Class** (클래스)

 - 클래스 <br>
   : `유사한 특징을 가진 객체들`의 속성을 묶어 놓은 `집합체`
   - 특징 <br>
     1. 자바는 모든 코드를 **클래스 단위로 구현**
     2. **main 메소드**를 포함하는 클래스를 가장 먼저 실행
     3. 클래스는 **틀(frame) 제공** 역할, 데이터는 인스턴스화를 통해 구현
        
   - 구성 <br>
     1. **멤버 변수** - 객체의 `상태, 수치, 특성`을 나타내는 변수
     2. **멤버 메소드** - 객체에서 발생하는 모든 `제어 및 기능, 요청 행위`(함수와 같은 기능?) <br>
        *멤버는 일반적으로 클래스의 외부 접근이 불가하도록 캡슐화(접근 제한)해야 한다. 
     3. **접근제한자** - `클래스 내 멤버들의 접근 수준`을 결정하는 토큰 <br>
        *프로그램 → 패키지 → 하위 클래스 → 자신의 클래스 순으로 접근 수준 결정
        - **public**: `프로그램 내 모든 객체`에서 접근 가능
        - **default**(생략 가능):`같은 패키지 내`에서만 접근 가능
        - **protected**: `자신`과 `하위 클래스`에서만 접근 가능
        - **private**: `자신의 클래스`에서만 접근 가능
<br>

<details><summary>예시</summary>
    
```Java
public class Circle{                            // Circle 클래스 정의 (main 메소드 포함되었으므로 시작 되는 클래스)
    public static void main(String[] args){
        double pi = 3.141592;                              // 멤버 변수 정의
        private double radius;                                 // 외부 접근 불가
    }

    void volume(){
        System.out.println(radius * radius * pi);
    }

    public void set_radius(double r){                       // private 멤버 접근을 위한 메소드
        radius = r;
    }
} 

```

</details>

> Instance (인스턴스)


> Constructor (생성자 메소드)

## Java 객체지향 기술

> 상속

> 추상 클래스

> 인터페이스

> 예외 처리

> Thread (스레드)

``` Java
import java.util.*;
import java.lang.*;
import java.io.*;

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
if ( 조건식 1 && 조건식 2 || 조건식 3) {
} else if ( 조건식 n ){
    조건식 n = True 일 때 수행할 문장;
} else {
    모두 만족 못 할 때 수행할 문장;
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


## Java 클래스 및 함수
> `print() / println() / printf()` (기본 출력 메소드)
``` Java
int x = 123;
int y = 456;
double a = 3.141592;
String name = "kimss"

# print()  - 출력
System.out.print(n);


# println()  - 출력 + 줄바꿈
System.out.println(n);
System.out.println("출력값은 " + x + y + "입니다.");   # 변수 여러개 출력 안됨.

# printf()  - 서식에 의한 출력
System.out.printf("출력값은 %d입니다.", n);
System.out.printf("printf는 다중 출력(%d %d %.2f %s)이 된다.", x, y, a, name);  # 변수 타입을 출력하고자 하는 순서대로 기입


```
<br><br>



> `Scanner` (입력)
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
