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
     3. 클래스는 **틀(frame) 제공** 역할, 데이터는 인스턴스화를 통해 구현<br><br>
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
<p align="center"><img src="https://github.com/Kim-SeongSu/Self-study_and_Review/assets/104110605/35766fdf-2159-4210-abed-75de37e6539b" width="80%" height="80%"></p>

<details><summary>예시 코드</summary>
    
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

</details><br><br>



> Instance (인스턴스)

 - 인스턴스 <br>
   : 객체 지향 프로그래밍(Object Oriented Programming)에서 `class에 소속`된 개별적인 `객체`
   -  인스턴스 생성<br>
     : **새로운 인스턴스를 생성**하여 적절한 타입의 **참조형 변수에 할당**하는 작업<br>
     → `new` 키워드와 클래스명을 이용 (인스턴스가 생성되는 동시에 생성자가 호출 됨) <br>
         예시: `[클래스명] [변수명] = new [클래스명]();` <br>
     \* 참조형 변수[^1] vs 기본형 변수[^2]
   - 멤버 변수와 지역 변수 <br>
     1) 멤버 변수 - `클래스 내부`에 생성된 변수 (**인스턴스 변수**, **클래스 변수**)<br>
          \* 인스턴스 변수 - 인스턴스마다 독립적으로 존재. 일반적으로 접근 제한해 둠<br>
          \* 클래스 변수 - 같은 클래스 내부에서 모든 인스턴스가 공유하는 데이터를 클래스 변수에 지정<br>
              ex) `[접근제한자] static [자료형]    [변수명];`    ( 쉽게 말해 static이 붙으면 클래스 함수! )
     3) 지역 변수 - `클래스 내부에 있는 메소드 내부`에 생성된 변수<br>
     
> [!TIP]
> 클래스 내부에 새로운 메소드가 생성하면, 해당 구역은 독립된 지역으로 판단한다<br> 이러한 이유로 클래스 내에 같은 이름의 변수 생성이 가능하다! <br>    * 이름이 같을 경우 this 키워드로 구분할 수 있다. 예시) this.변수명[^3] (멤버 변수에 사용)

[^1]: Reference Variable; 주소값(메모리주소)을 저장
[^2]: Primitive Variable; 값을 저장하는 저장 공간 ex) 10, A, True 등 리터럴(실제값)이 저장됨<br><br>
[^3]: 외부에서 인스턴스의 멤버(변수 또는 메소드)에 직접 접근하기 위해서는 `객체변수.멤버이름`같은 방법을 통해 접근 가능하다<br>

         
<details><summary>예시 코드</summary>
    
```Java
public class Variable {
  int c;                                     // c: 인스턴스 변수 (멤버 변수)
    static String d;                           // d: 클래스 변수   (멤버 변수)
    void func(int c){                          // c: 매개 변수     (지역 변수)
      this.c = c;                              // 멤버 변수 c에 지역 변수 c값 할당
   }

public static void main(String args[]){
  int a=30;                                 // a: 정수형 변수   (지역 변수)
    Variable b = new Variable();              // b: 참조형 변수   (지역 변수)
    b.func(a);
  }
}
```
</details><br><br>


> Constructor (생성자 메소드) <br>

　　: 클래스 내부에 `클래스명과 같은 이름으로 존재`하는 특별한 `메소드`, 인스턴스 생성 시 **멤버변수 및 연관 객체들의 초기화** 작업에 사용
   -  특징 <br>
       1. 인스턴스가 생성될 때 자동으로 실행됨 (별도로 실행 불가)
       2. 리턴문 사용 불가
       3. 오버로딩[^4] 가능 (메소드라면 모두 가능)
<br> [^4]: 자바의 한 클래스 내에 이미 사용하려는 이름과 같은 이름을 가진 메소드가 있더라도 매개변수의 개수 또는 타입이 다르면, 같은 이름을 사용해서 메소드를 정의할 수 있다. (단, 리턴값만 다면 오버로딩 불가능)

<details><summary>예시 코드</summary>
    
```Java
class Circle{
	private double pi = 3.141592;
  	private double radius;

  	Circle(double radius){								// 실수 인수 전달 시(변수 입력될 때) 수행되는 생성자 메소드1																											
    	this.radius = radius;
    	System.out.println( "객체가 생성되었습니다.");
		}

	Circle(){											// 인수 전달 없을 시 수행되는 생성자 메소드2
  		this.radius = 3.0
  		System.out.println("기본 객체가 생성되었습니다.");
		}
	}

public class helloWorld{
	public static void main(String[] args){
    	Circle c1 new Circle(5.0);						// 인수가 주어졌으므로 생성자 1이 호출됨
    	Circle c2 = new Circle();						// 인수가 없으므로 생성자 2가 호출됨
  	}
}


결과 >>
	객체가 생성되었습니다.
	기본 객체가 생성되었습니다.

```
</details><br><br>





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
