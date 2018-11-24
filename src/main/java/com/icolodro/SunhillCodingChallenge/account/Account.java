package com.icolodro.SunhillCodingChallenge.account;

/**
 * This is the super class of an account. Common attributes and operations are
 * declared and/or implemented
 * 
 * @author ivan.colodro
 *
 */
public abstract class Account
{    
    protected Long numberAccount;
    
    protected String owner;
    
    protected Double balance;
    
    public Account()
    {
        this.balance = 0D;
    }
    
    /**
     * This method increase the balance. 
     * 
     * @param amount
     */
    public synchronized void deposit(Double amount)
    {
        balance += amount;
    }
    
    /**
     * This method is abstract, each child should implement its own funcionality because
     * the availble funds can be different.
     * 
     * @param amount
     * @return boolean, true if the operation was done successfully, false the oposite.
     */
    public abstract boolean withdraw(Double amount);
    
    /**
     * This method return the available funds, depends of the balance but not the same thing. Each child
     * can different ways of calculating this data, it depends of the business logic.
     * 
     * @return available funds
     */
    public abstract Double getAvailableFunds();
       
    public Long getNumberAccount()
    {
        return numberAccount;
    }

    public void setNumberAccount(Long numberAccount)
    {
        this.numberAccount = numberAccount;
    }

    public String getOwner()
    {
        return owner;
    }

    public void setOwner(String owner)
    {
        this.owner = owner;
    }

    public Double getBalance()
    {
        return balance;
    }

    public void setBalance(Double balance)
    {
        this.balance = balance;
    } 
}
