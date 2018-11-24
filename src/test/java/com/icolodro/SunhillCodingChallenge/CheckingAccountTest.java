package com.icolodro.SunhillCodingChallenge;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.icolodro.SunhillCodingChallenge.account.Account;
import com.icolodro.SunhillCodingChallenge.account.AccountBuilder;
import com.icolodro.SunhillCodingChallenge.account.AccountType;
import com.icolodro.SunhillCodingChallenge.account.types.CheckingAccount;

public class CheckingAccountTest
{
    
    private CheckingAccount checkingAccount;
    
    @Before
    public void setUp()
    {
        checkingAccount = (CheckingAccount) new AccountBuilder(AccountType.CHECKING).numberAccount(AccountBuilder.idIncrementer)
                                                                                    .owner("Ivan")
                                                                                    .openWithBalance(200D)
                                                                                    .build();
    }
    
    
    @Test
    public void shouldSetOverdraftLimitAndHasExpandedFunds()
    {
        checkingAccount.setOverdraftLimit(-500D);
        
        Assert.assertEquals(700D, checkingAccount.getAvailableFunds(), 0D);
    }
    
    @Test
    public void shouldFailTransfer()
    {
        Account ca = new AccountBuilder(AccountType.CHECKING).numberAccount(AccountBuilder.idIncrementer)
                                                             .owner("Jessica")
                                                             .build();
        
        checkingAccount.setOverdraftLimit(0D);
        Assert.assertFalse(checkingAccount.transferTo(ca, 500D));
        
    }
    
    @Test
    public void shouldDoTransfer()
    {
        Account ca = new AccountBuilder(AccountType.CHECKING).numberAccount(AccountBuilder.idIncrementer)
                                                             .owner("Jessica")
                                                             .build();

        Assert.assertTrue(checkingAccount.transferTo(ca, 200D));
    }
   
}
