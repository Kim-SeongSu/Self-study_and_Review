package ch20;

public class NestedLoopTest {

	public static void main(String[] args) {

		int dan;
		int count;
		
		for(dan = 2; dan < 10; dan++) {
			for(count = 1; count < 10; count++) {
				System.out.println(dan + "X" + count + "=" + dan * count);
			}
			System.out.println();
		}
			
			
			

//		int dan = 2;
//		int count;
//	 
//		while(dan <10){
//			count = 1; // 여기서 count값을 1로 지정하지 않으면 한번만 실행되고 멈춘다.
//			while(count <10){
//		 	System.out.println(dan + "X" + count + "=" + dan * count);
//		 	count++;
//		 	}
//		 	dan++;
//		 	System.out.println();
//		}

	}
}