
package question;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class Main {


	public static void main(String args[]) {

		Customer[] customers;
		Operator[] operators;

		int C, O, N;

		File inFile = new File(args[0]);  // args[0] is the input file
		File outFile = new File(args[1]);  // args[1] is the output file
		try {
			PrintStream outstream = new PrintStream(outFile);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

		Scanner reader;
		try {
			reader = new Scanner(inFile);
		} catch (FileNotFoundException e) {
			System.out.println("Cannot find input file");
			return;
		}

		C = reader.nextInt();
		O = reader.nextInt();
		N = reader.nextInt();

		customers = new Customer[C];
		operators = new Operator[O];

		//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE
		
		
		int	operationNum;
		String name;
		int age;
		int ID;
		double limitingAmount;
		int customerID = 0;
		double talkingCharge, messageCost, networkCharge;
		int discountRate;
		int operatorID = 0;
		int firstCustomer, secondCustomer,newOperatorID;
		int time, quantity;
		double amount;
		int talkingTime, nOfMessages;
		double MBsUsed, amountPaid, currentDept;
		double maxMBsUsed = 0;
		int maxMinutes = 0, maxMessageSent = 0;
		
		for(int i = 0; i<N;i++) {
			//to determine which operation is to be executed.
			operationNum = reader.nextInt();
			if(operationNum == 1) {
				name = reader.next();
				age = reader.nextInt();
				ID = reader.nextInt();
				limitingAmount = reader.nextDouble();
				Customer customer = new Customer(customerID,name, age, operators[ID],limitingAmount);
				customers[customerID] = customer;
				customerID++;
			}
			else if(operationNum == 2) {
				talkingCharge = reader.nextDouble();
				messageCost = reader.nextDouble();
				networkCharge = reader.nextDouble();
				discountRate = reader.nextInt();
				Operator operator = new Operator(operatorID, talkingCharge, messageCost, networkCharge, discountRate);
				operators[operatorID] = operator;
				operatorID++;
			}
			else if(operationNum == 3) {
				firstCustomer = reader.nextInt();
				secondCustomer = reader.nextInt();
				time = reader.nextInt();
				customers[firstCustomer].talk(time, customers[secondCustomer]);
			}
			else if(operationNum == 4) {
				firstCustomer = reader.nextInt();
				secondCustomer = reader.nextInt();
				quantity = reader.nextInt();
				customers[firstCustomer].message(quantity, customers[secondCustomer]);
			}
			else if(operationNum == 5) {
				firstCustomer = reader.nextInt();
				amount = reader.nextDouble();
				customers[firstCustomer].connection(amount);
			}
			else if(operationNum == 6) {
				firstCustomer = reader.nextInt();
				amount = reader.nextDouble();
				customers[firstCustomer].payBill(amount);
			}
			else if(operationNum == 7) {
				firstCustomer = reader.nextInt();
				newOperatorID = reader.nextInt();
				customers[firstCustomer].setOperator(operators[newOperatorID]);
			}
			else if(operationNum == 8) {
				firstCustomer = reader.nextInt();
				amount = reader.nextDouble();
				customers[firstCustomer].changeTheLimit(amount);
			}
		}
		reader.close();
		String cmaxMBs=customers[0].getName(), cmaxTalking=customers[0].getName(), cmaxMessage=customers[0].getName();
		PrintStream outstream1;
		try {
			outstream1 = new PrintStream(outFile);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
			return;
		}
		for(Operator operator:operators) {
			operatorID = operator.getID(); 
			talkingTime = operator.getTotalMinutesTalked();
			nOfMessages = operator.getTotalMessagesSent();
			MBsUsed = operator.getTotalMBsUsed();
			outstream1.printf("Operator %d : %d %d %.2f%n",operatorID, talkingTime, nOfMessages, MBsUsed);
		}
		for(Customer customer:customers) {
			customerID = customer.getID();
			amountPaid = customer.getTotalAmountPaid();
			currentDept = customer.getBill().getCurrentDebt();
			outstream1.printf("Customer %d : %.2f %.2f%n", customerID, amountPaid, currentDept);
			if(customer.getTotalMBsUsed()> maxMBsUsed) {
				maxMBsUsed = customer.getTotalMBsUsed();
				cmaxMBs = customer.getName();
			}
			if(customer.getTotalMessageSent() > maxMessageSent) {
				maxMessageSent = customer.getTotalMessageSent();
				cmaxMessage = customer.getName();
			}
			if(customer.getTotalMinutesTalked() > maxMinutes) {
				maxMinutes = customer.getTotalMinutesTalked();
				cmaxTalking = customer.getName();
			}
		}
		outstream1.printf("%s : %d%n",cmaxTalking, maxMinutes);
		outstream1.printf("%s : %d%n",cmaxMessage, maxMessageSent);
		outstream1.printf("%s : %.2f%n",cmaxMBs, maxMBsUsed);
		outstream1.close();
		//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE
	} 
}

