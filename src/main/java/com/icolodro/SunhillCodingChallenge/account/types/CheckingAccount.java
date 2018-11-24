package com.icolodro.SunhillCodingChallenge.account.types;

import com.icolodro.SunhillCodingChallenge.account.Account;

/**
 * <p>This class extend from Account.</p>
 * 
 * <p> especific operations are added to this class. An overdraftLimit and transfer operations
 * 
 * @author ivan.colodro
 * 
 * @see Account
 *
 */
public class CheckingAccount extends Account
{
    
    private static final Double DEFAUL_OVERDRAFT_LIMIT = -1000D;
    
    private Double overdraftLimit;
    
    /**
     * set overdraftLimit to default value : -1000
     * 
     */
    public CheckingAccount()
    {
        super();
        overdraftLimit = DEFAUL_OVERDRAFT_LIMIT;
    }
    
    @Override
    public synchronized boolean withdraw(Double amount)
    {
        boolean isPossible = false;
        
        if(balance - amount >= overdraftLimit)
        {
            balance -= amount;
            isPossible = true;
        }
       
        return isPossible;
    }
    
    @Override
    public Double getAvailableFunds()
    {
        return balance + Math.abs(overdraftLimit);
    }
    
    /**
     * 
     * @param account destination
     * @param amount
     * @return True if the transfer was done successfully, false the oposite.
     */
    public boolean transferTo(Account account, Double amount)
    {       
        boolean transferDone = false;
        
        if(withdraw(amount))
        {
            account.deposit(amount);
            transferDone = true;
        }
        
        return transferDone;
    }

    public Double getOverdraftLimit()
    {
        return overdraftLimit;
    }

    public void setOverdraftLimit(Double overdraftLimit)
    {
        this.overdraftLimit = overdraftLimit;
    }
}
