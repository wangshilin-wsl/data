package jiedan2;

abstract class Bank{
	float rest;

	abstract void deposit(float n);
	abstract void withdraw(float n);

	void checkBalances(){
		System.out.println(rest);
	}

	public static void main(String args[]){
		Bank b1 = new ChinaBank();
		Bank b2 = new ConstructionBank();
		b1.deposit(-100);
		b1.withdraw(50);
		b1.checkBalances();
		b2.deposit(100);
		b2.withdraw(50);
		b2.checkBalances();
	}
}

class ChinaBank extends Bank{
	void deposit(float n){
		if(n<0){
			try {
				throw new MoneyIllegalException();
			} catch (MoneyIllegalException e) {

			}
		}else{
			rest += n*1.03;
		}
	}
	void withdraw(float n){
		if(n<0){
			try {
				throw new MoneyIllegalException();
			} catch (MoneyIllegalException e) {
			}
		}else if(n>rest){
			try {
				throw new MoneyNotEnoughException();
			} catch (MoneyNotEnoughException e) {
			}
		}else{
			rest -= n*0.95;
		}

	}
}

class ConstructionBank extends Bank{
	void deposit(float n){
		if(n<0){
			try {
				throw new MoneyIllegalException();
			} catch (MoneyIllegalException e) {
			}
		}else{
			rest += n*1.05;
		}
	}
	void withdraw(float n){
		if(n<0){
			try {
				throw new MoneyIllegalException();
			} catch (MoneyIllegalException e) {
			}
		}else if(n>rest){
			try {
				throw new MoneyNotEnoughException();
			} catch (MoneyNotEnoughException e) {
			}
		}else{
			rest -= n*0.97;
		}
	}
}
class MoneyIllegalException extends Exception{
	public MoneyIllegalException() {
		System.out.println("The number is illegal");
	}
}
class MoneyNotEnoughException extends Exception{
	public MoneyNotEnoughException() {
		System.out.println("Your money is not enough");
	}
}