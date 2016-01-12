package xyz.zrui.explore.common.dao;


import java.sql.SQLException;

import xyz.zrui.explore.common.entity.User;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class UserMapperTest {
	
	@Resource
	private UserMapper userMapeer;
	
	@Resource
	private DataSource dataSource;
	
	@Test
	public void testDataSouce() throws SQLException{
		
		System.out.println(dataSource.getConnection());
		
	}

	@Test
	public void testDeleteByPrimaryKey() {
	}

	@Test
	public void testInsert() {
		
	}

	@Test
	public void testInsertSelective() {
	}

	@Test
	public void testSelectByPrimaryKey() {
		User  user =  userMapeer.selectByPrimaryKey("1");
		System.out.println(user.getUsername());
		
	}

	@Test
	public void testUpdateByPrimaryKeySelective() {
	}

	@Test
	public void testUpdateByPrimaryKey() {
	}

}
