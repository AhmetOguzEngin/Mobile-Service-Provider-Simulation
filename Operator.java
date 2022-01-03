
package question;

public class Operator {
	//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE
	private int ID;
	private double talkingCharge;
	private double messageCost;
	private double networkCharge;
	private int discountRate;
	private int totalMinutesTalked;
	private double totalMBsUsed;
	private int totalMessagesSent;
	/**
	 * Constructor which takes 5 parameters to create an object of Operator Class.
	 * @param ID Operator's ID
	 * @param talkingCharge Call price per minute 
	 * @param messageCost fee per message
	 * @param networkCharge fee per MB
	 * @param discountRate Discount rate in percent for special cases.
	 */
	public Operator(int ID, double talkingCharge, double messageCost, double networkCharge, int discountRate) {
		this.ID = ID;
		this.talkingCharge = talkingCharge;
		this.messageCost = messageCost;
		this.networkCharge = networkCharge;
		this.discountRate = discountRate;
		this.totalMinutesTalked = 0;
		this.totalMBsUsed = 0;
		this.totalMessagesSent = 0;
	}
	/**
	 * To calculate the total amount to pay for talking. 
	 * @param minute Minutes spent talking in minutes.
	 * @param customer Customer who made the call.
	 * @return Cost of the phone call.
	 */
	 
	public double calculateTalkingCost(int minute, Customer customer) {
		int age = customer.getAge();
		double talkingCost;
		if(age<18 || age>65) {
			talkingCost = this.talkingCharge*minute*(100-this.discountRate)/100; 
		}
		else {
			talkingCost = this.talkingCharge*minute;
		}
		return talkingCost;
	}
	/**
	 * To calculate the total amount to pay for sending messages.
	 * @param quantity Number of messages sent by customer
	 * @param customer Customer who sends message(s).
	 * @param other Customer who recieves message(s).
	 * @return Cost of messages sent.
	 */
	public double calculateMessageCost(int quantity, Customer customer, Customer other) {
		double messageCost;
		Operator Operator1 = customer.getOperator();
		Operator Operator2 = other.getOperator();
		if(Operator1 == Operator2) {
			messageCost = quantity*Operator1.getMessageCost()*(100-Operator1.getDiscountRate())/100;
		}
		else {
			messageCost = quantity*(Operator1.messageCost);
		}
		return messageCost;
	}
	/**
	 * To calculate the total amount to pay for using the Internet.
	 * @param amount Minutes spent on Internet.
	 * @return Cost of Internet use.
	 */
	public double calculateNetworkCost(double amount) {
		double networkCost = amount*this.networkCharge;
		return networkCost;
	}
	
	/**
	 * Setter method for talkingCharge.
	 * @param talkingCharge The charge of talking
	 */
	public void setTalkingCharge(double talkingCharge) {
		this.talkingCharge = talkingCharge;
	}
	/**
	 * Getter method for talkingCharge.
	 * @return The charge of talking
	 */
	public double getTalkingCharge() {
		return this.talkingCharge;
	}
	/**
	 * Setter method for messageCost.
	 * @param messageCost The cost of message
	 */
	public void setMessageCost(double messageCost) {
		this.messageCost = messageCost;
	}
	/**
	 * Getter method for messageCost.
	 * @return The cost of message
	 */
	public double getMessageCost() {
		return this.messageCost;
	}
	/**
	 * Setter method for networkCharge.
	 * @param networkCharge The charge of network use
	 */
	public void setNetworkCharge(double networkCharge) {
		this.networkCharge = networkCharge;
	}
	/**
	 * Getter method for networkCharge.
	 * @return The charge of network use
	 */
	public double getNetworkCharge() {
		return this.networkCharge;
	}
	/**
	 * Setter method for discountRate.
	 * @param discountRate The discount rate in percent
	 */
	public void setDiscountRate(int discountRate) {
		this.discountRate = discountRate;
	}
	/**
	 * Getter method for discountRate.
	 * @return The discount rate in percent.
	 */
	public int getDiscountRate() {
		return this.discountRate;
	}
	/**
	 * Getter method for ID.
	 * @return Operator's ID
	 */
	public int getID() {
		return this.ID;
	}
	/**
	 * Getter method for totalMinutesTalked.
	 * @return Total minutes talked throughout this operator
	 */
	public int getTotalMinutesTalked() {
		return this.totalMinutesTalked;
	}
	/**
	 * Setter method for totalMinutesTalked.
	 * @param totalMinutesTalked Total minutes talked throughout this operator
	 */
	public void setTotalMinutesTalked(int totalMinutesTalked) {
		this.totalMinutesTalked = totalMinutesTalked;
	}
	/**
	 * Getter method for totalMBsUsed.
	 * @return Total MBs used
	 */
	public double getTotalMBsUsed() {
		return  this.totalMBsUsed;
	}
	/**
	 * Setter method for totalMBsUsed.
	 * @param totalMBsUsed Total MBs used
	 */
	public void setTotalMBsUsed(double totalMBsUsed) {
		this.totalMBsUsed = totalMBsUsed;
	}
	/**
	 * Getter method for totalMessageSent.
	 * @return The number of messages sent
	 */
	public int getTotalMessagesSent() {
		return this.totalMessagesSent;
	}
	/**
	 * Setter method for totalMessageSent.
	 * @param totalMessagesSent The number of messages sent.
	 */
	public void setTotalMessagesSent(int totalMessagesSent) {
		this.totalMessagesSent = totalMessagesSent;
	}
	
	//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE
}

