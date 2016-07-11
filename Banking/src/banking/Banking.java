/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banking;

/**
 *
 * @author SAPRIYA
 */
abstract class Account{
    private long balance;
    private String holderName;
    public Account(String name){
        this.holderName = name;
    }
    public String getName(){
        return this.holderName;
    }
    public final void transaction(String message,long amount ){
        System.out.println("Holder's Name: "+this.holderName);
        System.out.println("Transaction Message: "+message);
        System.out.println("Amount: "+amount);
        balance = balance + amount;
        if(balance<0){
        System.out.println("Covered by overdraft");}
        System.out.println("Resulting balance: "+balance);
    }
    public long getBalance(){return balance;};
    public abstract boolean deposit(long amount);
    public abstract boolean withdraw(long amount); 
}

class CheckingAccount extends Account{
    long overdraftedAmount;
    CheckingAccount(String holderName, long authorizedoverdraftAmount){
        super(holderName);
        this.overdraftedAmount = authorizedoverdraftAmount;
    }
    
    @Override
    public boolean deposit(long amount){
        transaction("Checking Deposit",amount);
        return true;
    }
    
    @Override
    public boolean withdraw(long amount){
        if(amount > getBalance()+overdraftedAmount)
            return false;
        else {
        transaction("Checking Withdrawal",amount*-1);
        return true;
        }
    }
}

class MortgageAccount extends Account{
    long intialBorrowedAmount;
    MortgageAccount(String holderName, long initilaborrowedAmount){
        super(holderName);
        this.intialBorrowedAmount = initilaborrowedAmount ;
        System.out.println("Initial borrowed Amount"+initilaborrowedAmount);
        
    }
    @Override
   public boolean deposit(long amount){
       transaction("Mortgage Payment",amount);
       return true;
   }
   
    @Override
   public boolean withdraw(long amount){
       return false;
   }
}

public class Banking {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Account[] differentHolders = {
           new MortgageAccount ("Sam",100000),
           new CheckingAccount ("Tom",200),
           new CheckingAccount ("Jill",1000)
       };
       
       for(int a=0;a<3;a++){
       System.out.println(differentHolders[a].deposit(1000));
       System.out.println(differentHolders[a].withdraw(500));
       System.out.println(differentHolders[a].withdraw(1000));
       System.out.println(differentHolders[a].withdraw(2000));
       }
    }
    
}
