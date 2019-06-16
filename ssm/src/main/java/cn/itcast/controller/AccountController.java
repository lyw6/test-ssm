package cn.itcast.controller;

import cn.itcast.domain.Account;
import cn.itcast.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 账户web  控制器
 * 目的：在controller中能成功的调用service对象中的方法。
 */
@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;
   @RequestMapping("/findAll")
    public String findAll(Model model){
       System.out.println("表现层：查询所有账户...");
       //就可以调用service层的方法
       List<Account> list = accountService.findAll();
      model.addAttribute("list",list);
       return "list";
   }

    /**
     * 保存
     * @param account
     * @param request
     * @param response
     * @throws Exception
     */
   @RequestMapping("/save")
   public void  save(Account account, HttpServletRequest request, HttpServletResponse response) throws Exception {
       accountService.savaAccount(account);
       response.sendRedirect(request.getContextPath()+"/account/findAll");
       return;
   }




}
