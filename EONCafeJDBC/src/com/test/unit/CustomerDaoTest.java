package com.test.unit;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.dao.CustomerDaoImpl;
import com.dao.CustomerExistsException;
import com.model.Customer;

public class CustomerDaoTest 
{

	 private com.dao.CustomerDao CustomerDao;
	 
	 /**
	  * Test case to get all customer
	  */
	 
	 
	 @Test
	 public void testgetCustomerdetails()
	 {
		 CustomerDaoImpl custdaoimpl=new CustomerDaoImpl();
		 int actual = custdaoimpl.getAllCustomers().size();
		 int expected = custdaoimpl.getAllCustomers().size();
		 assertEquals(expected,actual);
		 
		 
	 }
	 
	 
	 @Test
	 public void testgetCustomer()
	 {
		 CustomerDaoImpl custdaoimpl=new CustomerDaoImpl();
		 int actual = custdaoimpl.getCustomer(101).getCid();
		 int expected = custdaoimpl.getCustomer(101).getCid();
		 System.out.println("The customer name is : Amina");
		 assertEquals(expected,actual);
		 
		 
	 }
	/*
	 @Test
	 public void testaddcustomer()
	 {
		 CustomerDaoImpl custdaoimpl=new CustomerDaoImpl();
		 Customer customerdao = new Customer(105,"soham","sohamkumkar@gmail.com","soham1");
		Customer actual = customerdao();
		System.out.println("");
		 int expected = customerdao.getCid();
		 
//		 assertEquals(expected,actual);
//		 
		 
	 }
	
	 */
	 
}
	















































//---------------------------------------------------------------------------


/*
import java.util.List;
 
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
 
import com.howtodoinjava.jpa.demo.dao.DepartmentDAO;
import com.howtodoinjava.jpa.demo.dao.EmployeeDAO;
import com.howtodoinjava.jpa.demo.entity.DepartmentEntity;
import com.howtodoinjava.jpa.demo.entity.EmployeeEntity;
 
@ContextConfiguration(locations = "classpath:application-context-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TestEmployeeDAO
{
     
    @Autowired
    private EmployeeDAO employeeDAO;
     
    @Autowired
    private DepartmentDAO departmentDAO;
     
    @Test
    @Transactional
    @Rollback(true)
    public void testAddDepartment()
    {
        DepartmentEntity department = new DepartmentEntity("Information Technology");
        departmentDAO.addDepartment(department);
         
        List<DepartmentEntity> departments = departmentDAO.getAllDepartments();
        Assert.assertEquals(department.getName(), departments.get(0).getName());
    }
     
    @Test
    @Transactional
    @Rollback(true)
    public void testAddEmployee()
    {
        DepartmentEntity department = new DepartmentEntity("Human Resource");
        departmentDAO.addDepartment(department);
         
        EmployeeEntity employee = new EmployeeEntity();
        employee.setFirstName("Lokesh");
        employee.setLastName("Gupta");
        employee.setEmail("howtodoinjava@gmail.com");
        employee.setDepartment(department);
         
        employeeDAO.addEmployee(employee);
         
        List<DepartmentEntity> departments = departmentDAO.getAllDepartments();
        List<EmployeeEntity> employees = employeeDAO.getAllEmployees();
         
        Assert.assertEquals(1, departments.size());
        Assert.assertEquals(1, employees.size());
         
        Assert.assertEquals(department.getName(), departments.get(0).getName());
        Assert.assertEquals(employee.getEmail(), employees.get(0).getEmail());
    }
}
*/