/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm_working;
import java.util.Scanner;

/**
 *
 * @author nandkk05
 */

class Amount
{
    int bal;
    Amount(int bal)
    {
        this.bal=bal;
    }
    boolean issufficientbalance(int amt)
    {
        if (bal>=amt)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    void withdraw (int amt)
    {
        bal=bal-amt;
        System.out.println("Withdraw money is "+amt);
        System.out.println("Your current balance is "+bal);
    }
}

    class customer implements Runnable
    {
        Amount amount;
        String name;
        
        public customer (Amount amount, String n){
            this.amount=amount;
            name=n;
        }
        
        
        @Override
        public void run() {
            Scanner t=new Scanner(System.in);
            System.out.println("Hey "+name+", Enter the amount to withdraw");
            int amt=t.nextInt();
            synchronized(amount)
            {
                if (amount.issufficientbalance(amt))
                {
                    System.out.println("Thanks for this transaction, "+name+ " ;-)");
                    amount.withdraw(amt);
                }
                else
                {
                    System.out.println("Insufficient Balance :-( ");
                }
            }
        }
        
    }

public class Atm_working {
    
    public static void main(String[] args) {
        
        // TODO code application logic here
        
        Amount k=new Amount(1000);
        customer g= new customer(k,"Pankaj");
        Thread h=new Thread(g);
        h.start();
        
    }
}