package com.test.feign;

import com.test.bean.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Component
@FeignClient(value = "RIBBON-SERVICE")
public interface UserServiceFeign {
    @RequestMapping(value = "/user/save",method = RequestMethod.POST)
    public Map<String, Object> save(@RequestBody User user);
}
