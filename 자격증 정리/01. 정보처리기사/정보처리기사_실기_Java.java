// 정보처리기사 실기 Java 기출문제 //

/* 2025년도 - 1회
5. 다음은 Java 코드에 대한 문제이다. 아래 코드를 확인하여 알맞는 출력값을 작성하시오.

public class Main {
  public static void main(String[] args) {
 
    int a=5,b=0;
 
    try{
      System.out.print(a/b);
    }catch(ArithmeticException e){
      System.out.print("출력1");
    }catch(ArrayIndexOutOfBoundsException e) {
      System.out.print("출력2");
    }catch(NumberFormatException e) {
      System.out.print("출력3");
    }catch(Exception e){
      System.out.print("출력4");
    }finally{
      System.out.print("출력5");
    }
  }
}


개념)
Exception e - 자바의 모든 일반적인 예외의 최상위 클래스 (모든 예외를 포괄적으로 처리)
ArithmeticException e - 산술 연산 예외 (0으로 나눌 때)
ArrayIndexOutOfBoundsException e - 배열 인덱스 초과
NumberFormatException e - 숫자 변환 실패 (문자형을 숫자형으로 변경 시 발생)
NullPointerException e - 널 포인터 접근
FileNotFoundException e - 파일 없음
ClassCastException e - 형 변환 오류
*/

// 풀이)
public class Main {
  public static void main(String[] args) {
 
    int a=5,b=0;    
 
    try{
      System.out.print(a/b);                    // 오류 발생
    }catch(ArithmeticException e){              // a/b  → 5/0 연산 오류이므로 해당 예외처리 수행
      System.out.print("출력1");
    }catch(ArrayIndexOutOfBoundsException e) {
      System.out.print("출력2");
    }catch(NumberFormatException e) {
      System.out.print("출력3");
    }catch(Exception e){
      System.out.print("출력4");                // 위에서 1개 이상의 예외 처리 수행했으므로 수행 X
    }finally{
      System.out.print("출력5");                // 무조건 수행
    }
  }
}

/* 정답) 
출력1출력5

~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~ */

/* 2025년도 - 1회
13. 다음은 Java 코드에 대한 문제이다. 아래 코드를 확인하여 알맞는 출력값을 작성하시오.

public class Main {
    public static void main(String[] args) {
        new Child();
        System.out.println(Parent.total);
    }
}
 
class Parent {
    static int total = 0;
    int v = 1;
 
    public Parent() {
        total += (++v);
        show();    
    }
 
    public void show() {
        total += total;
    }
}
 
class Child extends Parent {
    int v = 10;
 
    public Child() {
        v += 2;
        total += v++;
        show();
    }
 
    @Override
    public void show() {
        total += total * 2;
    }
}

개념)
extends (상속): Child 클래스 호출 시, Parent 클래스 상속
@Override (오버라이딩): Parent 클래스 함수 호출 시, Child의 함수 호출 (부모 클래스에서도 적용!!)
*/

// 풀이)
public class Main {
    public static void main(String[] args) {
        new Child();                            // 1. Child 클래스 호출
        System.out.println(Parent.total);       // 9. Parent.total 출력
                                                    // 9-1. 54
    }
}
 
class Parent {                                  // 3. Parent 클래스 호출
    static int total = 0;                           // 3-1. total=0 (static으로 고정) , v=1
    int v = 1;
 
    public Parent() {
        total += (++v);                         // 4. Parent 생성자 호출
                                                    // 4-1. total=0, v=2
                                                    // 4-2. total=2, v=2
        show();                                 // 5. Child show() 호출 (오버라이딩)  "total += total * 2"
                                                    // 5-1. total (=2) += 2 * 2
                                                    // 5-2. total = 6, v=2
    }
 
    public void show() {                      
        total += total;
    }
}
 
class Child extends Parent {                    // 2. Child: Parent 클래스 상속
                                                // 6. Child 클래스 호출
    int v = 10;                                     // total = 6 (Parent 에서 넘어옴) , v=10 (Child 클래스 변수 선언으로 초기화)
 
    public Child() {                            // 7. Child 생성자 호출
        v += 2;                                     // 7-1. total = 6, v=12
        total += v++;                               // 7-2. total = 18, v=13
        show();                                 // 8. Child show() 호출
                                                    // 8-1. total = 18 + 18*2 = 54
    }
 
    @Override                                   
    public void show() {
        total += total * 2;
    }
}

/* 정답) 
54

~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~ */


/* 2025년도 - 1회
16. 다음은 Java 코드에 대한 문제이다. 아래 코드를 확인하여 알맞는 출력값을 작성하시오.

public class Main {
    public static void main(String[] args) {
        int[] data = {3, 5, 8, 12, 17};
        System.out.println(func(data, 0, data.length - 1));
    }
 
    static int func(int[] a, int st, int end) {
        if (st >= end) return 0;
        int mid = (st + end) / 2;
        return a[mid] + Math.max(func(a, st, mid), func(a, mid + 1, end));
    } 
}

개념)

*/

// 풀이)
public class Main {
    public static void main(String[] args) {
        int[] data = {3, 5, 8, 12, 17};
        System.out.println(func(data, 0, data.length - 1));                 // func(data, 0, 4)
    }
 
    static int func(int[] a, int st, int end) {
        if (st >= end) return 0;                                            
        int mid = (st + end) / 2;
        return a[mid] + Math.max(func(a, st, mid), func(a, mid + 1, end));
    } 
}

/*
func(data, 0, 4)
    return a[2] + Math.max(func(data, 0, 2), func(data, 3, 4))

    func(data, 0, 2)
        return  a[1] + Math.max(func(data, 0, 1), func(data, 2, 2))

            func(data, 0, 1)
                return a[0] + Math.max(func(data, 0, 0), func(data, 1, 1))
                = 3

            func(data, 2, 2)
                return 0
        = 5 + Math.max(3,0)
        = 8

    func(data, 3, 4)
        return  a[3] + Math.max(func(data, 3, 3), func(data, 4, 4))

            func(data, 3, 3)
                return 0

            func(data, 4, 4)
                return 0
        = 12 

    = 8 + Math.max(8,12)
    = 20
*/

/* 정답) 
20

~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~ */



