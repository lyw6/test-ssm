package cn.itcast.service.impl;

import cn.itcast.dao.AccountDao;
import cn.itcast.domain.Account;
import cn.itcast.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("accountService")//上次写到了dao接口上了
public class AccountServiceImpl implements AccountService {
    //注入dao对象，进行测试
    @Autowired
    private AccountDao accountDao;


    public List<Account> findAll() {
        System.out.println("业务层:查询所有账户...");
        return accountDao.findAll();
    }

    public void savaAccount(Account account) {
        System.out.println("业务层:保存账户...");
        accountDao.savaAccount(account);
    }
}
