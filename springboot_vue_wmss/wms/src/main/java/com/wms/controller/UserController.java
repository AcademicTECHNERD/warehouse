package com.wms.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wms.common.QueryPageParam;
import com.wms.common.Result;
import com.wms.entity.User;
import com.wms.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author THX
 * @since 2024-07-20
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;
    @GetMapping("/query")
    public List<User> list(){
        return userService.list();
    }
    @GetMapping("/findByNo")
    public Result findByNo(@RequestParam String no) {
        List list = userService.lambdaQuery().eq(User::getNo,no).list();
        return list.size()>0?Result.suc(list):Result.fail();
    }
    //新增
    @PostMapping("/save")
    public Result save(@RequestBody User user) {
        return userService.save(user)?Result.suc():Result.fail();
    }
    //更新数据
    @PostMapping("/update")
    public Result update(@RequestBody User user) {
        return userService.updateById(user)?Result.suc():Result.fail();
    }
    //删除数据
    @GetMapping("/del")
    public Result del(@RequestParam String id) {
        return userService.removeById(id)?Result.suc():Result.fail();
    }
    //登录
    @PostMapping("/login")
    public Result login(@RequestBody User user) {
        List list = userService.lambdaQuery()
                .eq(User::getNo,user.getNo())
                .eq(User::getPassword,user.getPassword()).list();
        return list.size()>0?Result.suc(list.get(0)):Result.fail();
    }
    //修改
    @PostMapping("/mod")
    public boolean mod(@RequestBody User user) {
        return userService.updateById(user);
    }
    //新增或修改
    @PostMapping("/saveOrMod")
    public boolean save0rMod(@RequestBody User user){
        return userService.saveOrUpdate(user);
    }
    //删除
    @GetMapping("/delete")
    public boolean delete(Integer id){
        return userService.removeById(id);
    }
    //模糊查询
    @PostMapping("/query_vague")
    public List<User> query_vague(@RequestBody User user){
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        // 使用 lambdaQueryWrapper 实例调用 like 方法，也可以用其他查询方法
        if (user.getName() != null && !user.getName().isEmpty()) {
            lambdaQueryWrapper.like(User::getName, user.getName());
        }
        List<User> result = userService.list(lambdaQueryWrapper);
//        return userService.list(lambdaQueryWrapper);
        return result;
    }

    //分页查询
    @PostMapping("/listpaging")
    public Result listpaging(@RequestBody QueryPageParam query){
        // 打印接收到的 QueryPageParam 对象
        System.out.println("Received query: " + query);
        System.out.println("Page number: " + query.getPageNum());
        System.out.println("Page size: " + query.getPageSize());

        // 获取查询参数
        HashMap<String, Object> param = query.getParam();
        if (param == null) {
            param = new HashMap<>();
        }
        String name = (String) param.get("name");
        System.out.println("Name: " + name);

        // 设置分页对象
        Page<User> page = new Page<>();
        page.setCurrent(query.getPageNum());
        page.setSize(query.getPageSize());

        // 设置查询条件
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        if (StringUtils.isNotBlank(name)) {
            lambdaQueryWrapper.like(User::getName, name);
        }

        // 查询数据
        IPage<User> result = userService.page(page, lambdaQueryWrapper);
        System.out.println("Total: " + result.getTotal());

        // 返回结果
        return Result.suc(result);
    }
    //post跨域测试
    @PostMapping("/query_post_kuayu")
    public Result query_post_kuayu(@RequestBody User user){
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        // 使用 lambdaQueryWrapper 实例调用 like 方法，也可以用其他查询方法
        if(StringUtils.isNotBlank(user.getName())){
            lambdaQueryWrapper.like(User::getName, user.getName());
        }
        List<User> result = userService.list(lambdaQueryWrapper);
        return Result.suc(result);
    }
    @PostMapping("/listpage_getTorF_Result")
    public Result listpageresult(@RequestBody QueryPageParam query){
        HashMap param = query.getParam();
        String name = (String)param.get("name");
        System.out.println("name==="+(String)param.get("name"));

        Page<User> page = new Page();
        page.setCurrent(query.getPageNum());
        page.setSize(query.getPageSize());
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        // 使用 lambdaQueryWrapper 实例调用 like 方法
        lambdaQueryWrapper.like(User::getName, name);
        IPage result = userService.page(page,lambdaQueryWrapper);
        System.out.println("total=="+result.getTotal());
        return Result.suc(result.getRecords(), result.getTotal());
    }

}
