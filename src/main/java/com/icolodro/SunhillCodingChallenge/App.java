package com.icolodro.SunhillCodingChallenge;

import java.util.ArrayList;
import java.util.List;

import com.icolodro.SunhillCodingChallenge.account.Account;
import com.icolodro.SunhillCodingChallenge.account.AccountBuilder;
import com.icolodro.SunhillCodingChallenge.account.AccountType;
import com.icolodro.SunhillCodingChallenge.account.types.*;

public class App 
{
    @SuppressWarnings("serial")
    public static void main( String[] args )
    {
       
        List<Account> accounts = new ArrayList<Account>()
        {{    
            add(new AccountBuilder(AccountType.SAVING).numberAccount(AccountBuilder.idIncrementer++).owner("John").openWithBalance(5000D).build()); 
            add(new AccountBuilder(AccountType.CHECKING).numberAccount(AccountBuilder.idIncrementer++).owner("Ivan").build());
            add(new AccountBuilder(AccountType.CHECKING).numberAccount(AccountBuilder.idIncrementer++).owner("Jessica").openWithBalance(1500D).build());         
        }};
        
        Account johnAccount = accounts.stream().filter(a -> a.getNumberAccount().equals(1L)).findFirst().get();
        
        System.out.println("------ Begin operations with account  : " + johnAccount.getOwner() + " ----------");
        
        //should print 5000, initial Balance
        System.out.println("Available funds : " + johnAccount.getAvailableFunds());
        
        //this case is going to be false the balance is 5000
        if(!johnAccount.withdraw(5100D))
            System.out.println("there are not enough funds for a withdrawal of : " + 5100D);
        
        //default interest rate is 0.055
        ((SavingAccount) johnAccount).payInterest();
        
        System.out.println("Balance after paying interest : " + johnAccount.getBalance());
        
        System.out.println("------ End operations with account  : " + johnAccount.getOwner() + " ----------");
        
        
        Account ivanAccount = accounts.stream().filter(a -> a.getOwner().equals("Ivan")).findFirst().get();
        
        System.out.println("------ Begin operations with account  : " + ivanAccount.getOwner() + " ----------");
        
        ivanAccount.deposit(100D);
        
        System.out.println("Balance : " + ivanAccount.getBalance());
        //Should print 1100 (overdraft + balance)
        System.out.println("Available funds : " + ivanAccount.getAvailableFunds());
        
        //this case is going to be true because overdraft limit is -1000
        if(ivanAccount.withdraw(500D))
            System.out.println("The withdrawal of 500 has been done successfully!");
        
        System.out.println("Balance : " + ivanAccount.getBalance());
                 
        System.out.println("------ End operations with account  : " + ivanAccount.getOwner() + " ----------");
        
        CheckingAccount jessicaAccount = (CheckingAccount) accounts.stream().filter(a -> a.getOwner().equals("Jessica")).findFirst().get();
        
        System.out.println("------ Begin operations with account  : " + jessicaAccount.getOwner() + " ----------");
        
        if(jessicaAccount.transferTo(ivanAccount, 600D))
            System.out.println("Transfer of 600 has been done succcessfully!");
        else
            System.out.println("Transfer of 600 has not been done because thera are not enought founds!");
               
        System.out.println("------ End operations with account  : " + jessicaAccount.getOwner() + " ----------");
        
        System.out.println(ivanAccount.getOwner() + " balance : " + ivanAccount.getBalance());
           
    }
    
    
}
