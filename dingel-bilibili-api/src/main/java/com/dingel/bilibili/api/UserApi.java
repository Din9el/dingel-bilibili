package com.dingel.bilibili.api;


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


    @GetMapping("/rsa-pks")
    public JsonResponse<String> getRsaPublickey(){
        String pk = RSAUtil.getPublicKeyStr();
        return new JsonResponse<>(pk);
    }


    @PostMapping("/users")
    public JsonResponse<String> addUser(@RequestBody User user){
        userService.addUser(user);
        return JsonResponse.success();
    }




}
