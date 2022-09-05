package com.dingel.bilibili.api;

import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RestfulDemoApi {

    private final Map<Integer,Map<String,Object>> dataMap;


    public RestfulDemoApi(){
        dataMap = new HashMap<>();
        for(int i=1;1<4;i++){
            Map<String,Object> data = new HashMap<>();
            data.put("id",i);
            data.put("name","name"+i);
            dataMap.put(i,data);
        }
    }

    @GetMapping("/obj/{id}")
    public Map<String,Object> getData(@PathVariable Integer id){
        return dataMap.get(id);
    }

    @DeleteMapping("/obj/{id}")
    public String DeleteData(@PathVariable Integer id){
        dataMap.remove(id);
        return "delete success";
    }

    @PostMapping("/obj")
    public String postData(@RequestBody Map<String,Object> data){
        Integer [] idArray = dataMap.keySet().toArray(new Integer[0]);
        Arrays.sort(idArray);
        int nextId = idArray[idArray.length-1]+1;
        dataMap.put(nextId,data);
        return "post success";
    }




}
