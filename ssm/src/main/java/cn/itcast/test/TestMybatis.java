package cn.itcast.test;

import cn.itcast.dao.AccountDao;
import cn.itcast.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import java.io.InputStream;
import java.util.List;

public class TestMybatis {

    @Test
    public  void run1() throws Exception {
        //获取配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建工厂对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //创建sqlsession对象
        SqlSession session = factory.openSession();
        //获取代理对象
        AccountDao accountDao = session.getMapper(AccountDao.class);
        //调用方法
        List<Account> list = accountDao.findAll();
        for (Account account : list) {
            System.out.println(account);
        }
        //释放资源
        session.close();
        in.close();

    }

    @Test
    public  void run2() throws Exception {
        //创建有数据的account存入
        Account account = new Account();
        account.setName("梁朝伟");
        account.setMoney(1000d);
        //获取配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建工厂对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //创建sqlsession对象
        SqlSession session = factory.openSession();
        //获取代理对象
        AccountDao accountDao = session.getMapper(AccountDao.class);
        //调用方法
       accountDao.savaAccount(account);
        //释放资源
        //增删改需要提交事务
        session.commit();
        session.close();
        in.close();

    }


}
