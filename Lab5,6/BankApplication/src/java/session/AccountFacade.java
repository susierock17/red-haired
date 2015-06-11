/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entities.Account;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Kira
 */
@Stateless
public class AccountFacade extends AbstractFacade<Account> {
    @PersistenceContext(unitName = "BankApplicationPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AccountFacade() {
        super(Account.class);
    }
    
    public Account openAccount(String ownername, int balance)
    {
        Account acc = new Account();
        acc.setBalance(balance);
        acc.setOwnername(ownername);
        em.persist(acc);
        return acc;
    }
    
    public void deposit(int accountNumber, int amount)
    {
        Account account = em.find(Account.class, accountNumber);
        account.deposit(amount);
    }
    
    public int withdraw(int accountNum, int amount)
    {
        Account account = em.find(Account.class, accountNum);
        return account.withdraw(amount);
    }
    
    public void closeAccount(int accountNumber)
    {
        Account account = em.find(Account.class, accountNumber);
        em.remove(account);
    }
    
    public List<Account> getAllAccounts()
    {
        Query query = em.createQuery("SELECT a FROM Account a");
        return query.getResultList();
    }
}
