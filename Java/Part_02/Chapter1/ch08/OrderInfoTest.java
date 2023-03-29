package ch08;

public class OrderInfoTest {

	public static void main(String[] args) {
		
		OrderInfo order_001 = new OrderInfo(01023450001,"서울시 강남구 역삼동 111-333",20201102,130258,35000,"0003");
	
		System.out.println(order_001.showOrderInfo());
	}
}
