package ch08;

public class OrderInfo {
	
	public int orderReciptionNumber;
	public int orderPhoneNumber;
	public String orderAdress;
	public int orderDate;
	public int orderTime;
	public int orderPrice;
	public String orderMenuNumber;
	
	
	public OrderInfo(
			int orderPhoneNumber,
			String orderAdress,
			int orderDate,
			int orderTime,
			int orderPrice,
			String orderMenuNumber) {
		// this.orderReciptionNumber = orderReciptionNumber;
		
		this.orderPhoneNumber = orderPhoneNumber;
		this.orderAdress = orderAdress;
		this.orderDate = orderDate;
		this.orderTime = orderTime;
		this.orderPrice = orderPrice;
		this.orderMenuNumber = orderMenuNumber;
		
	}
	
	public String showOrderInfo() {
		return "주문 접수 번호 : " + orderDate+orderMenuNumber + "\n" +
				"주문 핸드폰 번호 : " + orderPhoneNumber + "\n" +
				"주문 집 주소 : " + orderAdress + "\n" +
				"주문 날짜 : " + orderDate + "\n" +
				"주문 시간 : " + orderTime + "\n" +
				"주문 가격 : " + orderPrice + "\n" +
				"메뉴 번호 : " + orderMenuNumber + "\n";
		
	}

}
