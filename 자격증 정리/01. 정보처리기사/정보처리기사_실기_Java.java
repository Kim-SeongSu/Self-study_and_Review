// 정보처리기사 실기 Java 기출문제 //

/* 2025년도 - 1회 5

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

/* 2025년도 - 1회 13

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


/* 2025년도 - 1회 16

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

/* 2025년도 - 1회 20

개념)

*/

// 풀이)
public class Main {
  public static void main(String[] args) {
    System.out.println(calc("5"));
  }
 
  static int calc(int value) {        // calc(정수형): value가 1보다 작을 때까지 calc(value - 1) + calc(value - 2) 실행
    if (value <= 1) return value;
    return calc(value - 1) + calc(value - 2);
  }
 
  static int calc(String str) {       // calc(문자열): int로 변환 후 value가 1보다 작을 때까지 calc(value - 1) + calc(value - 3) 실행
    int value = Integer.valueOf(str);
    if (value <= 1) return value;
    return calc(value - 1) + calc(value - 3);
  }
}


/*
calc("5")
  = calc(4) + calc(2)
  = calc(3) + calc(2) + calc(1) + calc(0)
  = calc(2) + calc(1) + calc(1) + calc(0) + 1
  = calc(1) + calc(0) + 2 + 1
  = 1 + 2 + 1
  = 4

*/


/* 정답) 
4
~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~ */

/* 2024년도 - 3회 1

개념)
1. equals VS ==
equals()는 문자열 내용이 같은지를 비교
==는 두 참조(객체 주소)가 같은지를 비교
*/

// 풀이)
public class Main{
  static String[] s = new String[3];  // s = {null, null, null} 
 
  static void func(String[] s, int size){
    for(int i=1; i<size; i++){
      if(s[i-1].equals(s[i])){    // s[0].equals(s[1])  >> "A".equals("A")             : "O" .equals()는 단순히 같은 문자열인지 비교
        System.out.print("O");    // s[1].equals(s[2])  >> "A".equals(new String("A")) : "O"
      }else{                      
        System.out.print("N");
      }
    }
      for (String m : s){         // 문자열 s 출력    s = {"A", "A", "A"} 
        System.out.print(m);
      }
    }
  
 
  public static void main(String[] args){
    s[0] = "A";
    s[1] = "A";
    s[2] = new String("A");     // s = {"A", "A", "A"} 
 
    func(s, 3);
  }
}

/* 정답) 
OOAAA
~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~ */
/* 2024년도 - 1회 

개념)

*/

// 풀이)

/* 정답) 

~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~.~ */