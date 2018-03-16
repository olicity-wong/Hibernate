//被调用的方法
package com.hibernate.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.pojo.Book;
import com.hibernate.util.HibernateSessionFactory;

public class Service {
	private Session se;

	public void show()		//展示图书信息
	{
		Service serv100 = new Service();
		List<Book> getL = serv100.getAll();
		// System.out.println(getL.size());
		if (getL.size() > 0) {
			System.out.println();
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
	}
	
	public List<Book> getAll() {		//从数据库中查询全部图书信息
		se = HibernateSessionFactory.getSession();
		Query q = se.createQuery("from Book");
		List<Book> l = q.list();
		return l;
	}

	public boolean add(Book b) {		//添加图书信息
		se = HibernateSessionFactory.getSession();
		Transaction tc = se.beginTransaction();
		Integer id = (Integer) se.save(b);
		System.out.println();
		System.out.println("添加信息如下：");
		System.out.println("ID:" + b.getId());
		System.out.println("书名:" + b.getName());
		System.out.println("价格:" + b.getPrice());
		System.out.println("出版社:" + b.getPress());
		System.out.println("作者:" + b.getAuthor());
		tc.commit();		
		se.close();
		if (id != null) {
			return true;
		} else {
			return false;
		}
	}

	public boolean delete(int id) {		//删除图书信息
		se = HibernateSessionFactory.getSession();
		Book b = (Book) se.get(Book.class, id);
		boolean c = true;
		try {
			Transaction tc = se.beginTransaction();
			System.out.println();
			System.out.println("删除信息如下：");
			System.out.println("ID:" + b.getId());
			System.out.println("书名:" + b.getName());
			System.out.println("价格:" + b.getPrice());
			System.out.println("出版社:" + b.getPress());
			System.out.println("作者:" + b.getAuthor());
			se.delete(b);
			tc.commit();
		} catch (Exception e) {
			c = false;
		}
		se.close();
		return c;
	}
	
	
	public boolean change(int id, String name, float price,
	    String press, String author) {		//修改图书信息
		se = HibernateSessionFactory.getSession();
		Book b = (Book) se.get(Book.class, id);
		System.out.println();
		System.out.println("此书原信息如下：");
		System.out.println("ID:" + b.getId());
		System.out.println("书名:" + b.getName());
		System.out.println("价格:" + b.getPrice());
		System.out.println("出版社:" + b.getPress());
		System.out.println("作者:" + b.getAuthor());
		
		b.setName(name);
		b.setPrice(price);
		b.setPress(press);
		b.setAuthor(author);
		boolean c = true;
		try {
			Transaction tc = se.beginTransaction();
			se.update(b);
			System.out.println();
			System.out.println("修改后信息如下：");
			System.out.println("ID:" + b.getId());
			System.out.println("书名:" + b.getName());
			System.out.println("价格:" + b.getPrice());
			System.out.println("出版社:" + b.getPress());
			System.out.println("作者:" + b.getAuthor());
			tc.commit();
		} catch (Exception e) {
			c = false;
		}
		se.close();
		return c;
	}

	public List<Book> find(String key) {		//通过关键词模糊查询图书信息
		se = HibernateSessionFactory.getSession();
		Query q = se.createQuery("from Book b where b.name like '%" + key
				+ "%' or b.price like '%" + key
				+ "%' or b.press like '%" + key
				+ "%' or b.author like '%" + key + "%' ");
		//q.setString(0, "%"+xxx+"%");
		List<Book> l = q.list();
		return l;
		}
	public List<Book> find_1(String key1,String key2)		//通过图书名和作者关键字查询图书信息
		{
			se=HibernateSessionFactory.getSession();
			Query q=se.createQuery("from Book book where book.name like '%"+key1+"%'and book.author like '%"+key2+"%' ");
			List l=q.list();
			return l;
		}
}
