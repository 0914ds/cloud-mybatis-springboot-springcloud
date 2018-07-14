/*
 * Copyright 2012-2020 the original author or authors.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * @author lzhoumail@126.com/zhouli
 * Git http://git.oschina.net/zhou666/spring-cloud-7simple
 */

package cloud.simple.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cloud.simple.model.User;
import cloud.simple.service.ServiceUser;
import cloud.simple.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;



@RestController
@Api("swaggerDemoController相关的api")
public class UserController {
		
	@Autowired(required=true)
	UserService userService;
	@Autowired
	ServiceUser serviceuser;
	//@Autowired
	//FeignUserService feignUserService;
	
	//整合swagger 通过http://localhost:8080/swagger-ui.html访问接口定义
	//通过ribbon 的 tempelate 实现负债均衡
	@ApiOperation(value="查询所有user",notes="查询所有用户信息")
	//@ApiImplicitParam(name = "", value = "", paramType = "path", required = true, dataType = "Integer")
	@RequestMapping(value="/users",method=RequestMethod.GET)
	public ResponseEntity<List<User>> readUserInfo(){
		List<User> users=userService.readUserInfo();		
		return new ResponseEntity<List<User>>(users,HttpStatus.OK);
	}
	//通过fein实现负载均衡
	@RequestMapping(value="/user",method=RequestMethod.GET)
	public ResponseEntity<List<User>> readUser(){
		List<User> users=serviceuser.readUserInfo();
		return new ResponseEntity<List<User>>(users,HttpStatus.OK);
	}
	
	
	
}
