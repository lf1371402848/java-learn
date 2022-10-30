package com.test.feign;

import com.test.bean.DsmsCars;
import com.test.bean.DsmsCarsExample;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Component
@FeignClient(contextId = "dsms-Car-Service9080-9060", value = "dsms-Car-Service9080")
public interface CarService {
    @RequestMapping(value = "/findAllCars")
    public List<DsmsCars> findAllCars();

    @RequestMapping(value = "/findCarById/{id}")
    public DsmsCars findCarById(@PathVariable long id);

    @RequestMapping(value = "/selectByExample")
    public List<DsmsCars> selectByExample(@RequestBody DsmsCarsExample example);

    @RequestMapping(value = "/updateByPrimaryKey")
    public void updateByPrimaryKey(@RequestBody DsmsCars car);

    @RequestMapping(value = "/updateByPrimaryKeySelective")
    public void updateByPrimaryKeySelective(@RequestBody DsmsCars car);

    @RequestMapping(value = "/countByExample")
    public long countByExample(@RequestBody DsmsCarsExample example);

}
