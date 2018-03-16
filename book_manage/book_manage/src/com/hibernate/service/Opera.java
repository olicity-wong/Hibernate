//展示界面和读取用户操作
package com.hibernate.service;

import java.util.List;
import java.util.Scanner;

import com.hibernate.pojo.Book;
import com.hibernate.pojo.User;


public class Opera {
	public static void opera(User u) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out
				.println(" -----------------------------------------------------------------------------------");
		System.out
				.println(" |1.展示图书信息|   |2.添加图书信息|   |3.删除图书信息|   |4.修改图书信息|   |5.查看图书信息|   |6.退出|");
		System.out
				.println(" -----------------------------------------------------------------------------------");
		System.out.println("请输入操作编号:");

		while (sc.hasNext()) {
			int num = sc.nextInt();
			switch (num) {
			case 1:		//展示图书信息
				Service serv4 = new Service();
				List<Book> getL = serv4.getAll();
				// System.out.println(getL.size());
				if (getL.size() > 0) {
					System.out.println("已有图书信息如下：");
					for (Book book : getL) {
						System.out.println("ID:" + book.getId());
						System.out.println("书名:" + book.getName());
						System.out.println("价格:" + book.getPrice());
						System.out.println("出版社:" + book.getPress());
						System.out.println("作者:" + book.getAuthor());
						System.out.println();
					}
				} else {
					System.out.println("不存在图书信息!");
				}
				break;
			case 2:		//添加图书信息
				System.out.println(" --------");
				System.out.println("|添加图书信息|");
				System.out.println(" --------");
				Book b = new Book();
				b.setId(0);
				System.out.println("请输入书名： ");
				b.setName(sc.next());
				System.out.println("请输入价格： ");
				b.setPrice(sc.nextFloat());
				System.out.println("请输入出版社： ");
				b.setPress(sc.next());
				System.out.println("请输入作者： ");
				b.setAuthor(sc.next());
				Service serv = new Service();
				if (serv.add(b)) {
					System.out.println("添加图书信息成功！");
					//serv.show();
				} else
					System.out.println("添加图书信息失败!");

				System.out.println();
				break;

			case 3:		//删除图书信息
				System.out.println(" --------");
				System.out.println("|删除图书信息|");
				System.out.println(" --------");
				System.out.println("请输入要删除图书的编号：");
				int id = sc.nextInt();
				Service serv1 = new Service();
				if (serv1.delete(id)) {
					System.out.println("删除图书信息成功!");
					//serv1.show();
				} else
					System.out.println("删除图书信息失败");
				System.out.println();
				break;

			case 4:		//修改图书信息
				System.out.println(" --------");
				System.out.println("|修改图书信息|");
				System.out.println(" --------");
				System.out.println("请输入要更改图书的编号：");
				int id1 = sc.nextInt();
				System.out.println("请输入需要更改的名字：");
				String name = sc.next();
				System.out.println("请输入需要更改的价格：");
				float price = sc.nextFloat();
				System.out.println("请输入需要更改的出版社：");
				String press = sc.next();
				System.out.println("请输入需要更改的作者：");
				String author = sc.next();
				Service serv2 = new Service();
				if (serv2.change(id1, name, price, press, author)) {
					//serv2.show();
					System.out.println("修改图书信息成功！");
				} else
					System.out.println("修改图书信息失败！");
				System.out.println();
				break;

			case 5:		//查看图书信息
				System.out.println(" ---------");
				System.out.println("|查看图书信息|");
				System.out.println(" ---------");
				System.out.println("请选择查找方式:	1.按关键字查找	2.按书名和作者查找");
				int n = sc.nextInt();
				if (n == 1) {
					System.out.println("请输入要查找的关键字:");
					String key = sc.next();
					Service serv3 = new Service();
					List<Book> l = serv3.find(key);
					if (l.size() > 0) {
						System.out.println();
						System.out.println("已找到该图书，信息如下：");
						for (Book book : l) {
							System.out.println("ID:" + book.getId());
							System.out.println("书名:" + book.getName());
							System.out.println("价格:" + book.getPrice());
							System.out.println("出版社:" + book.getPress());
							System.out.println("作者:" + book.getAuthor());
						}
					} else
						System.out.println("查看图书信息失败!");
					System.out.println();
				} else {
					System.out.println("请输入要查看图书的书名:");
					String key_1 = sc.next();
					System.out.println("请输入要查看图书的作者:");
					String key_2 = sc.next();
					Service serv3 = new Service();
					List<Book> l = serv3.find_1(key_1, key_2);
					if (l.size() > 0) {
						System.out.println();
						System.out.println("已找到该图书，信息如下：");
						for (Book book : l) {
							System.out.println("ID:" + book.getId());
							System.out.println("书名:" + book.getName());
							System.out.println("价格:" + book.getPrice());
							System.out.println("出版社:" + book.getPress());
							System.out.println("作者:" + book.getAuthor());
						}
					} else
						System.out.println("查看图书信息失败!");
					System.out.println();
				}
				break;
			case 6:		//结束运行
				System.out.println("辣鸡图书管理系统结束运行，感谢使用!");
				System.exit(0);
				break;

			}
		}
	}
}