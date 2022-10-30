package com.test.feign;

import com.test.bean.DsmsCars;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Component
@FeignClient(contextId = "dsms-Car-Service9080-9060", value = "dsms-Car-Service9080")
public interface CarService {
    @RequestMapping(value = "/findAllCars")
    @ResponseBody
    public List<DsmsCars> findAllCars();

    @RequestMapping(value = "/car/findCarByTrainerId/{id}")
    @ResponseBody
    public DsmsCars findCarByTrainerId(@PathVariable long id);
}
