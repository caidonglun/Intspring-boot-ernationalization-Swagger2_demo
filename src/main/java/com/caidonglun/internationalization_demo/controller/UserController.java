package com.caidonglun.internationalization_demo.controller;

import com.caidonglun.internationalization_demo.entity.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/users")     // 通过这里配置使下面的映射都在/users下，可去除
public class UserController {

    Logger logger=LoggerFactory.getLogger(getClass());


    @ApiOperation(value="更新用户详细信息", notes="根据url的id来指定更新对象，并根据传过来的user信息来更新用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "String")
    @RequestMapping(value="/user/{id}", method=RequestMethod.POST)
    @ResponseBody
    public String postUser(@PathVariable String id) {
        logger.info("id:"+id);
        return "{success:"+id+"}";
    }

    @ApiOperation(value="管理员详细信息", notes="根据url的id来指定更新对象，并根据传过来的user信息来更新用户详细信息")
    @ApiImplicitParam(name = "admin_id", value = "管理员ID", required = true, dataType = "String")
    @RequestMapping(value="/path/{admin_id}", method=RequestMethod.GET)
    @ResponseBody
    public String pathTest(@PathVariable String admin_id) {
        logger.info("id:"+admin_id);
        return "{success:"+admin_id+"}";
    }

    @ApiOperation(value="管理员最详细信息", notes="根据url的id来指定更新对象，并根据传过来的user信息来更新用户详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "admin_id", value = "管理员ID", required = true, dataType = "String"),
            @ApiImplicitParam(name = "user", value = "管理员整个对象", required = true, dataType = "User")
    })
    @RequestMapping(value="/adminPathAndUser/{admin_id}", method=RequestMethod.POST)
    @ResponseBody
    public String userTest(@PathVariable String admin_id, @RequestBody User user) {
        logger.info("id:"+admin_id+"  "+user.getPassword()+"  "+user.getUserid());
        return "success";
    }


    @ApiOperation(value="更新用户详细信息", notes="根据url的id来指定更新对象，并根据传过来的user信息来更新用户详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "String"),
            @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    })
    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public String putUser(@PathVariable String id, @RequestBody User user) {
        return "success";
    }

}