package cloud.simple.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cloud.simple.model.User;
@FeignClient(value = "cloud-simple-service", fallback =ServiceUserInfo.class)
public interface ServiceUser {

	@RequestMapping(value = "/user",method = RequestMethod.GET)
	public List<User> readUserInfo();
	
}
