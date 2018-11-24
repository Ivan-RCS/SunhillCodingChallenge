package com.icolodro.SunhillCodingChallenge.account.types;

import com.icolodro.SunhillCodingChallenge.account.Account;

/**
 * <p>This class extend from Account.</p>
 * 
 * <p> especific operations are added to this class. Interest Rate and associated payments.
 * 
 * @author ivan.colodro
 * 
 * @see Account
 *
 */
public class SavingAccount extends Account
{
    
    private static final Double DEFAULT_INTEREST_RATE = 0.055;
    
    private Double interestRate;
     
    /**
     * set interest rate to default value : 0.055
     * 
     */
    public SavingAccount()
    {
        super();
        interestRate = DEFAULT_INTEREST_RATE;
    }

    @Override
    public synchronized boolean withdraw(Double amount)
    {
        boolean isPossible = false;
        
        if(amount <= balance)
        {
            balance -= amount;
            isPossible = true;
        }
       
        return isPossible;
    }
    
    @Override
    public Double getAvailableFunds()
    {
        return balance;
    }
    
    /**
     * This method increase the balance according to the interest rate.
     */
    public void payInterest()
    {
        balance += balance * interestRate;
    }

    public Double getInterestRate()
    {
        return interestRate;
    }

    public void setInterestRate(Double interestRate)
    {
        this.interestRate = interestRate;
    }
}
