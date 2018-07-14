package cloud.simple.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import cloud.simple.model.User;

@Component
public class ServiceUserInfo implements ServiceUser {

	@Override
	public List<User> readUserInfo() {
		// TODO Auto-generated method stub
		User user =new User();
		List list = new ArrayList();
		user.setId("-1");
		list.add("fein 中的 断路器");
		return list;
	}

}
