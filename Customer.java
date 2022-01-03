
package question;

public class Customer {
	
	//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE
	private int ID;
	private String name;
	private int age;
	private Operator operator;
	private Bill bill;
	private double totalAmountPaid;
	private int totalMinutesTalked;
	private int totalMessagesSent;
	private double totalMBsUsed;
	/**
	 * Constructor which takes 5 parameters to create an object of Customer class. 
	 * @param ID Customer's ID
	 * @param name Customer's name
	 * @param age Customer's age
	 * @param operator The operator which customer uses.
	 * @param limitingAmount Bill limit.
	 */
	public Customer(int ID, String name, int age, Operator operator, double limitingAmount) {
		this.ID = ID;
		this.age = age;
		this.name = name;
		this.operator = operator;
		this.bill = new Bill(limitingAmount);
		this.totalAmountPaid = 0;
		this.totalMinutesTalked = 0;
		this.totalMessagesSent = 0;
		this.totalMBsUsed = 0;
	}
	/**
	 * for customers to talk via operator.In addition this method adds talkingCost of customers to their bills and adds minutes to both 
	 * customers' and operators' total talk time.  
	 * @param minute Talking time in minutes.
	 * @param other Other customer which talks to this customer.
	 */
	public void talk(int minute, Customer other) {
		if(this != other) { 
			Operator operator1 = this.getOperator();
			Operator operator2 = other.getOperator();
			Bill bill1 = this.getBill();
			double talkingCost1 = operator1.calculateTalkingCost(minute, this);

			if(bill1.check(talkingCost1)) {
				bill1.add(talkingCost1);
				this.totalMinutesTalked = this.totalMinutesTalked + minute;
				other.totalMinutesTalked = other.totalMinutesTalked + minute;
				operator1.setTotalMinutesTalked(operator1.getTotalMinutesTalked()+minute);
				operator2.setTotalMinutesTalked(operator2.getTotalMinutesTalked()+minute);

			}
		}
	}
	/**
	 * for customers to send message.In addition this method adds the number of messages sent by customers to both 
	 * customers' and operators' total message numbers. 
	 * @param quantity Number of message sent.
	 * @param other The customer who recieves message(s).
	 */
	public void message(int quantity, Customer other) { 
		if(this != other) {
			Operator operator = this.getOperator();
			double messageCost = operator.calculateMessageCost(quantity, this, other);
			if(this.bill.check(messageCost)) {
				Bill bill = this.getBill();
				bill.add(messageCost);
				this.totalMessagesSent = this.totalMessagesSent + quantity;
				operator.setTotalMessagesSent(operator.getTotalMessagesSent() + quantity);
			}
		}
			
	}
	/**
	 * for customers to connect the Internet.In addition this method adds the amount of Internet usage as MBs to both 
	 * customers' and operators' total Internet usage.
	 * @param amount The amount spent on Internet.
	 */
	public void connection(double amount) {
		Operator operator = this.getOperator();
		double networkCost = operator.calculateNetworkCost(amount);
		Bill bill = this.getBill();
		if(bill.check(networkCost)) {
			bill.add(networkCost);
			this.totalMBsUsed = this.totalMBsUsed + amount;
			operator.setTotalMBsUsed(operator.getTotalMBsUsed() + amount);
		}
		
	}
	/**
	 * for customers to pay their bills. Also this method calculates the total amount paid by customers. 
	 * @param amount The amount paid by customer.
	 */
	public void payBill(double amount) {
		Bill bill = this.getBill();
		double currentDept = bill.getCurrentDebt();
		if(amount>currentDept)amount = currentDept;
		bill.pay(amount);
		this.totalAmountPaid = this.totalAmountPaid + amount;
	}
	/**
	 * Setter method for age.
	 * @param age Customer's age
	 */
	public void setAge(int age) {
		this.age = age;
	}
	/**
	 * Getter method for age.
	 * @return Customer's age
	 */
	public int getAge() {
		return this.age;
	}
	/**
	 * Setter method for operator.
	 * @param operator Customer's operator.
	 */
	public void setOperator(Operator operator) {
		this.operator = operator;
	}
	/**
	 * Getter method for operator.
	 * @return Customer's operator
	 */
	public Operator getOperator() {
		return this.operator;
	}
	/**
	 * Setter method for bill.
	 * @param bill Customer's bill
	 */
	public void setBill(Bill bill) {
		this.bill = bill;
	}
	/**
	 * Getter method for bill.
	 * @return Customer's bill
	 */
	public Bill getBill() {
		return this.bill;
	}
	/**
	 * for customers to change their Bill limits.
	 * @param amount The limit of bill
	 */
	public void changeTheLimit(double amount) {
		if(this.bill.getCurrentDebt()<=amount) {
			this.bill.changeTheLimit(amount);
		}
	}
	/**
	 * Setter method for totalAmountPaid.
	 * @param totalAmount Total amount paid by customer.
	 */
	public void setTotalAmountPaid(double totalAmount) {
		this.totalAmountPaid = totalAmount;
	}
	/**
	 * Getter method for totalAmountPaid.
	 * @return Total amount paid by customer.
	 */
	public double getTotalAmountPaid() {
		return this.totalAmountPaid;
	}
	/**
	 * Setter method for totalMinutesTalked.
	 * @param totalMinutesTalked Total minutes spent talking.
	 */
	public void setTotalMinutesTalked(int totalMinutesTalked) {
		this.totalMinutesTalked = totalMinutesTalked;
	}
	/**
	 * Getter method for totalMinutesTalked.
	 * @return Total minutes spent talking.
	 */
	public int getTotalMinutesTalked() {
		return this.totalMinutesTalked;
	}
	/**
	 * Setter method for totalMessageSent.
	 * @param totalMessagesSent Total number of messages sent by customer.
	 */
	public void setTotalMessageSent(int totalMessagesSent) {
		this.totalMessagesSent = totalMessagesSent;
	}
	/**
	 * Getter method for totalMessageSent.
	 * @return Total number of messages sent by customer.
	 */
	public int getTotalMessageSent() {
		return this.totalMessagesSent;
	}
	/**
	 * Setter method for totalMBsUsed.
	 * @param totalMBsUsed Total MBs used by customer.
	 */
	public void setTotalMBsUsed(double totalMBsUsed) {
		this.totalMBsUsed = totalMBsUsed;
	}
	/**
	 * Getter method for totalMBsUsed.
	 * @return totalMBsUsed Total MBs used by customer.
	 */
	public double getTotalMBsUsed() {
		return this.totalMBsUsed;
	}
	/**
	 * Getter method for name.
	 * @return Customer's name
	 */
	public String getName() {
		return this.name;
	}
	/**
	 * Getter method for ID.
	 * @return Customer's ID
	 */
	public int getID() {
		return this.ID;
	}
	//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE
}

