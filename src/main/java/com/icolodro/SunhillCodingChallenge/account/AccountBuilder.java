package com.icolodro.SunhillCodingChallenge.account;

import java.util.Optional;

import com.icolodro.SunhillCodingChallenge.account.types.CheckingAccount;
import com.icolodro.SunhillCodingChallenge.account.types.SavingAccount;

/**
 * <p> This class is a strategy to creat the diferrent types of accounts. Mix a Abstract Factory with
 * a builder desing pattern. </p>
 * 
 * <p> numberAcccount and owner must be mandatory to build the object properly </p>
 * 
 * @author ivan.colodro
 *
 */
public class AccountBuilder
{   
    public static Long idIncrementer = 1L;
    
    private AccountType accountType;
    
    private Long numberAccount;
    
    private String owner;
    
    private Optional<Double> balance;
    
    /**
     * 
     * @param accountType to build a especific type of account.
     */
    public AccountBuilder(AccountType accountType)
    {
        this.accountType = accountType;
        this.balance = Optional.empty();
    }
      
    public AccountBuilder numberAccount(Long numberAccount)
    {
        this.numberAccount = numberAccount;
        return this;
    }
    
    public AccountBuilder owner(String owner)
    {
        this.owner = owner;
        return this;
    }
    
    public AccountBuilder openWithBalance(Double balance)
    {
        this.balance = Optional.ofNullable(balance);
        return this;
    }
    
    public Account build()
    {
        Account account;
        
        switch (accountType)
        {
            default:
            case CHECKING:
                
                account = new CheckingAccount();
                break;
                            
            case SAVING:
                
                account = new SavingAccount();
                break;       
        }
        
        account.setNumberAccount(numberAccount);
        account.setOwner(owner);
        balance.ifPresent(b -> account.setBalance(b));
        
        return account;
    }
}
