package com.spring.mybatisplus;

import static org.junit.Assert.assertTrue;

import com.spring.mybatisplus.dao.EmplopyeeDao;
import com.spring.mybatisplus.entity.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-dao.xml"})
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Autowired
    private DataSource dataSource;

    @Autowired
    private EmplopyeeDao emplopyeeDao;

    @Test
    public void testDataSource() throws SQLException {
        System.out.println(dataSource.getConnection());
    }

    @Test
    public void testInsert(){
        Employee employee = new Employee();
        employee.setLastName("东方不败");
        employee.setEmail("dfbb@163.com");
        employee.setGender(1);
        employee.setAge(20);
        emplopyeeDao.insert(employee);
        //mybatisplus会自动把当前插入对象在数据库中的id写回到该实体中
        System.out.println(employee.getId());
    }
}
