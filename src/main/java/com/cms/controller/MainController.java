package com.cms.controller;

import com.cms.repository.SysUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;

/**
 * Created by HOZANDUNG on 17/5/4.
 */
//@RestController
public class MainController {

    @Autowired
    SysUserRepository sysUserRepository;

    public String testV(BindingResult result) {
        return "";
    }

    //------------------------华丽的分割线------------------------

//    @RequestMapping(value = "/dashboard",method = RequestMethod.GET)
//    public String dashboard(Model model, Principal principal) {
//        model.addAttribute("principal", principal);
//        return "dashboard";
//    }
//
//    @RequestMapping(value = "/user",method = RequestMethod.GET)
//    public String user(Model model,Principal principal) {
//        String role = null;
//        SysUser users = sysUserRepository.findByUsername(principal.getName());
//        principal.getName();
//        List<SysRole> roles = users.getRoles();
//        for (SysRole sr:roles) {
//            role = sr.getName();
//        }
//        if (role.equals("ROLE_USER")) {
//            model.addAttribute("principal", principal);
//            model.addAttribute("user_role", role);
//        } else if(role.equals("ROLE_ADMIN")){
//            List userlist = sysUserRepository.findAll();
//            model.addAttribute("userList",userlist);
//        }
//        List userlist = sysUserRepository.findAll();
//        model.addAttribute("userList",userlist);
//        return "user";
//    }

//    @RequestMapping(value = "/table",method = RequestMethod.GET)
//    public String table() {
//        return "table";
//    }
//
//    @RequestMapping(value = "/typography",method = RequestMethod.GET)
//    public String typography() {
//        return "typography";
//    }
//
//    @RequestMapping(value = "/upgrade",method = RequestMethod.GET)
//    public String upgrade() {
//        return "upgrade";
//    }

    //------------------------华丽的分割线------------------------

//    @RequestMapping(value = "/home", method=RequestMethod.GET)
//    public String home(Model model, Principal principal){
//        Msg msg = new Msg("测试标题", "测试内容", "额外信息，只对管理员显示");
//
//        System.out.println("----------------------");
//        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        Collection authorities = userDetails.getAuthorities();
//        System.out.println(authorities);
//        System.out.println("-----------------------");
//
//        model.addAttribute("msg", msg);
//        model.addAttribute("principal", principal);
//        return "home";
//    }

}
