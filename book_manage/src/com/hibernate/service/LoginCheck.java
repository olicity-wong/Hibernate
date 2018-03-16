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
		q.setString(0, u.getUsername());
		q.setString(1, u.getUserpass());
		List<User> list = q.list();
		if (list.size() >= 1) {
			return true;
		} else {
			return false;
		}
	}
}