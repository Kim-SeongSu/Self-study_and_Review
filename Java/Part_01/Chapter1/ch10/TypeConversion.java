package ch10;

public class TypeConversion {

	public static void main(String[] args) {
		
		// 묵시적 형 변환 (implicit type conversion, 자동 형 변환)
		// 바이트 크기가 작은 자료형에서 큰 자료형으로 형 변환
		byte bNum = 125;
		int iNum = bNum;
		
		System.out.println(iNum);
		
		
		
		/*
		 int iNum = 255;
		 byte bNum = iNum;
		 
		 위의 코드는 오류남
		 */
		
		// 명시적 형 변환 (explcit type conversion, 강제 형 변환)
		 int iNum_1 = 255;
		 byte bNum_1 = (byte)iNum_1;
		 
		 System.out.println(bNum_1);
		 
		 
		 double dNum = 3.14;
		 int iNum_2 = (int)dNum;
		 
		 System.out.println(iNum_2);
		 
		 
		 
		 double dNum_1 = 1.2;
		 float fNum = 0.9F;
		 
		 int iNum1 = (int)dNum_1 + (int)fNum;
		 int iNum2 = (int)(dNum_1 + fNum);
		 
		 System.out.println(iNum1);
		 System.out.println(iNum2);
		 // 첫번째 결과는 형 변환 된 값들을 연산한 것이고,
		 // 두번째 결과는 연산된 값을 형 변환 한 것이다.
	}

}
