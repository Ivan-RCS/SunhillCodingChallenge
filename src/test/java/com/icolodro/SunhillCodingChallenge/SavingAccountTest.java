package com.icolodro.SunhillCodingChallenge;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.icolodro.SunhillCodingChallenge.account.AccountBuilder;
import com.icolodro.SunhillCodingChallenge.account.AccountType;
import com.icolodro.SunhillCodingChallenge.account.types.SavingAccount;

public class SavingAccountTest
{
    private SavingAccount savingAccount;
    
    @Before
    public void setUp()
    {
        savingAccount = (SavingAccount) new AccountBuilder(AccountType.SAVING).numberAccount(AccountBuilder.idIncrementer)
                                                                              .owner("Ivan")
                                                                              .openWithBalance(1000D)
                                                                              .build();
    }
    
    @Test
    public void shouldPayInterest()
    {
        //default interest is 0.055
        Double expectedBalance = savingAccount.getBalance() + (savingAccount.getInterestRate() * savingAccount.getBalance());
        
        savingAccount.payInterest();
        
        Assert.assertEquals(expectedBalance, savingAccount.getBalance(), 0D);
    }
    
    @Test
    public void shouldPayInterestWithInterest10()
    {
        
        savingAccount.setInterestRate(0.1D);
        Double expectedBalance = savingAccount.getBalance() + (savingAccount.getInterestRate() * savingAccount.getBalance());
        
        savingAccount.payInterest();
        
        Assert.assertEquals(expectedBalance, savingAccount.getBalance(), 0D);
    }
}
