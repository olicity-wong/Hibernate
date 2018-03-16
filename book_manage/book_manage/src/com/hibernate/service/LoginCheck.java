//登录检查
package com.hibernate.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;


import com.hibernate.pojo.User;
import com.hibernate.util.HibernateSessionFactory;

public class LoginCheck {
	private Session se;

	public boolean loginc(User u) {
		se = HibernateSessionFactory.getSession();
		Query q = se.createQuery("from User u where u.username = ? and u.userpass = ?");
		q.setString(0, u.getUsername());		//获取数据库表中用户名
		q.setString(1, u.getUserpass());		//获取数据库表中用户密码
		List<User> list = q.list();
		
		if (list.size() >= 1) {		//查询到匹配的用户名和密码
			return true;
		} else {
			return false;
		}
	}
}