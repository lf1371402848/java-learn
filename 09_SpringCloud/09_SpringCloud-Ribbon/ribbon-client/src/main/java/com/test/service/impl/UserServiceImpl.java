package com.test.service.impl;

import com.test.bean.User;
import com.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    /**
     * 是Ribbon技术中的负载均衡客户端对象。其中封装了从Eureka Server上发现的所有的服务地址列表
     * 包括服务的名称，IP，端口等。
     */
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    /**
     * 远程方法调用。访问application service，访问的地址是：http://localhost:8080/user/save
     * @param user
     * @return
     */
    @Override
    public Map<String, Object> save(User user) {
        // 根据服务的名称，获取服务实例。服务名称就是配置文件yml中的spring.application.name
        // 服务实例包括，这个名称的所有服务地址和端口。
        ServiceInstance instance = this.loadBalancerClient.choose("ribbon-service");
        // 访问地址拼接
        StringBuilder builder = new StringBuilder("");
        builder.append("http://ribbon-service")
                .append("/user/save")
                .append("?username=").append(user.getUsername())
                .append("&password=").append(user.getPassword())
                .append("&remark=").append(user.getRemark());
        System.out.println("本地访问地址：" + builder.toString());

        // 创建一个Rest访问客户端模板对象。
        RestTemplate template = new RestTemplate();

        // 约束响应结果类型
        ParameterizedTypeReference<Map<String, Object>> responseType =
                new ParameterizedTypeReference<Map<String, Object>>() {
                };

        // 远程访问application service。
        ResponseEntity<Map<String, Object>> response =
                template.exchange(builder.toString(), HttpMethod.GET,
                        null, responseType);

        Map<String, Object> result = response.getBody();
        return result;
    }
}
