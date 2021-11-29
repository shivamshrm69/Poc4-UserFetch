package com.poc4.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-address",url = "http://localhost:9000/address")
public interface FeignClientRequest {

	@DeleteMapping("/deleteAddressByUserId/{user_id}")
	public void deleteAddressByUserId(@PathVariable int user_id);
}
