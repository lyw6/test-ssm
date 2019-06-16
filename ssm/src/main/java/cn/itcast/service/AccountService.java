package cn.itcast.service;

import cn.itcast.domain.Account;
import org.springframework.stereotype.Service;

import java.util.List;


public interface AccountService {
    //查询所有账号
    public List<Account> findAll();
    //保存所有账户信息
    public void savaAccount(Account account);
}
