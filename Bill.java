
package question;

public class Bill {

	//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE
	
	private double limitingAmount;
	private double currentDebt;
	/**
	 * Constructor that takes one parameter to creat  object of the Bill Class.  
	 * @param limitingAmount Bill limit which is not possible to be exceeded.
	 * If currentDept exceeds this limit no action occurs. 
	 */
	public Bill(double limitingAmount) {
		this.limitingAmount= limitingAmount;
		this.currentDebt = 0;
	}
	/**
	 * To check whether the limitingAmount is exceeded or not.
	 * @param amount The amount to be paid after the last action. 
	 * @return true if limit is not exceeded, else false.
	 */
	public boolean check(double amount) {
		return this.currentDebt+amount <= this.limitingAmount;
	}
	/**
	 * To add debts to the bill.
	 * @param amount The amount to be paid.
	 */
	public void add(double amount) {
			this.currentDebt+= amount;
	}
	/**
	 * To pay the bills with given amount.
	 * @param amount The amount that paid by customer.
	 */
	public void pay(double amount) {
			this.currentDebt-=amount;
	}
	/**
	 * To change the limitingAmount.
	 * @param amount New amount of the limit.
	 */
	public void changeTheLimit(double amount) {
		this.limitingAmount = amount;
	}
	/**
	 * Getter method for limitingAmount.
	 * @return limitingAmount
	 */
	public double getLimitingAmount() {
		return this.limitingAmount;
	}
	/**
	 * Getter method for currentDept.
	 * @return currentDept
	 */
	public double getCurrentDebt() {
		return this.currentDebt;
	}
	//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE
}

