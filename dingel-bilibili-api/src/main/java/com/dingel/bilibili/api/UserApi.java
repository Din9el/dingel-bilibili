package com.dingel.bilibili.api;


import com.dingel.bilibili.api.support.UserSupport;
import com.dingel.bilibili.domain.JsonResponse;
import com.dingel.bilibili.domain.User;
import com.dingel.bilibili.service.UserService;
import com.dingel.bilibili.service.util.RSAUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserApi {

    @Autowired
    private UserService userService;

    @Autowired
    private UserSupport userSupport;

    //获取用户信息
    @GetMapping("/users")
    public JsonResponse<User> getUserInfo(){
        Long userId = userSupport.getCurrentUserId();
        User user = userService.getUserInfo(userId);
        return new JsonResponse<>(user);
    }



    @GetMapping("/rsa-pks")
    public JsonResponse<String> getRsaPublickey(){
        String pk = RSAUtil.getPublicKeyStr();
        return new JsonResponse<>(pk);
    }

    //注册用户
    @PostMapping("/users")
    public JsonResponse<String> addUser(@RequestBody User user){
        userService.addUser(user);
        return JsonResponse.success();
    }


    //用户登陆
    @PostMapping("/user-tokens")
    public JsonResponse<String> login(@RequestBody User user) throws Exception{
        String token = userService.login(user);
        return new JsonResponse<>(token);
    }





}
