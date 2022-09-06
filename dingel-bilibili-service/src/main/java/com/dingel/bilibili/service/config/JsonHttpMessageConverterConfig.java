package com.dingel.bilibili.service.config;


import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class JsonHttpMessageConverterConfig {

    @Bean
    @Primary
    public HttpMessageConverters fastJsonHttpMessageConvertes(){
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setDateFormat("yyyy-MM-dd HH:mm:ss");
        fastJsonConfig.setSerializerFeatures(
                SerializerFeature.PrettyFormat,             //Json数据需要格式化输出
                SerializerFeature.WriteNullStringAsEmpty,   //输出的值为null时转换成空字符串
                SerializerFeature.WriteNullListAsEmpty,     //没有数据的列表时转换成空字符串
                SerializerFeature.WriteMapNullValue,        //没有数据的map时转换成空字符串
                SerializerFeature.MapSortField,             //map的键值对排序
                SerializerFeature.DisableCircularReferenceDetect        //循环引用
        );
        fastConverter.setFastJsonConfig(fastJsonConfig);
        return new HttpMessageConverters();
    }


}
