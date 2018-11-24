package com.icolodro.SunhillCodingChallenge;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.icolodro.SunhillCodingChallenge.account.Account;
import com.icolodro.SunhillCodingChallenge.account.AccountBuilder;
import com.icolodro.SunhillCodingChallenge.account.AccountType;

public class AccountTest
{
    private Account account;
    
    @Before
    public void setUp()
    {
        account = new AccountBuilder(AccountType.SAVING).numberAccount(AccountBuilder.idIncrementer)
                                                        .owner("Ivan")
                                                        .openWithBalance(200D)
                                                        .build();
    }
    
    
    @Test
    public void shouldBeNotNull()
    {
        Assert.assertNotNull(account);
    }
    
    @Test
    public void shouldDeposit500()
    {
        account.deposit(500D);
        
        //Should be the deposit + initial balance 
        Assert.assertEquals(700D, account.getBalance(), 0D);
    }   
    
    @Test
    public void shouldFailWithdrawal()
    {
        Assert.assertFalse(account.withdraw(300D));
    } 
    
    @Test
    public void shouldWithdraw()
    {
        Assert.assertTrue(account.withdraw(100D));
    }  
}
