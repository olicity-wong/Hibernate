//登录界面
package com.hibernate.test;

import java.util.List;
import java.util.Scanner;

import com.hibernate.pojo.Book;
import com.hibernate.pojo.User;
import com.hibernate.service.LoginCheck;
import com.hibernate.service.Opera;
import com.hibernate.service.Service;

public class TestMain {

	public static void main(String args[]) {
		System.out.println(" 				 -------------------");
		System.out.println("				|欢迎来到wzy辣鸡图书管理系统|");
		System.out.println(" 				 -------------------");
		System.out.println("请先登录再操作!");
		Scanner sc = new Scanner(System.in);
		User u = new User();
		Opera o = new Opera();
		int count = 0;
		while (true) {
			System.out.println("请输入用户名:");
			u.setUsername(sc.next());
			System.out.println("请输入密码:");
			u.setUserpass(sc.next());
			LoginCheck lc = new LoginCheck();
			if (lc.loginc(u)) {
				System.out.println();
				System.out.println("欢迎," + u.username + "!");
				System.out.println();
				o.opera(u);
			} else {
				count++;
				System.out.println("密码错误!请重新输入！");
				if (count == 3) {		//三次密码输入错误结束程序
					System.out.println();
					System.out.println("三次密码错误，请联系管理员!");
					break;
				}

			}
		}
	}
}
