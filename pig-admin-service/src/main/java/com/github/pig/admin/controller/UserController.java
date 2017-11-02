package com.github.pig.admin.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.github.pig.admin.entity.SysUser;
import com.github.pig.admin.service.UserService;
import com.github.pig.common.vo.UserVo;
import com.github.pig.common.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lengleng
 * @date 2017/10/28
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {
    @Autowired
    private UserService userService;

    @GetMapping
    public String user() {
        return getUser();
    }

    /**
     * 通过用户名查询用户及其角色信息
     *
     * @param username 用户名
     * @return UseVo 对象
     */
    @RequestMapping("/findUserByUsername/{username}")
    public UserVo findUserByUsername(@PathVariable String username) {
        return userService.findUserByUsername(username);
    }

    /**
     * 分页查询用户
     *
     * @param page    页码
     * @param limit   每页数量
     * @param sysUser 检索条件
     * @return 用户集合
     */
    @RequestMapping("/userList")
    public Page<SysUser> userList(Integer page, Integer limit, SysUser sysUser) {
        return userService.selectPage(new Page<SysUser>(page, limit), new EntityWrapper<SysUser>(sysUser));
    }
}
