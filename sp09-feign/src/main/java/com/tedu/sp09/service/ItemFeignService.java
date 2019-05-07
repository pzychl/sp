package com.tedu.sp09.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.tedu.sp01.pojo.Item;
import com.tedu.web.util.JsonResult;
/**
 * 当你调用接口的getItems()方法时,根据springMVC注解会调用
 * 
 * localhost:8001服务器的/{orderId}
 * 和商品微服务控制器代码一致.接口去掉方法体
 *
 */
@FeignClient(name="item-service",fallback=ItemFeignServiceFB.class)
public interface ItemFeignService {
	@GetMapping("/{orderId}")
	JsonResult<List<Item>> getItems(@PathVariable String orderId);

	@PostMapping("/decreaseNumber")
	JsonResult decreaseNumber(@RequestBody List<Item> items);
}