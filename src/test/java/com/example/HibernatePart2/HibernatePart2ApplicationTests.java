package com.example.HibernatePart2;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.example.HibernatePart2.entities.employee.Address;
import com.example.HibernatePart2.entities.employee.Employee;
import com.example.HibernatePart2.entities.inheritance.Check;
import com.example.HibernatePart2.entities.inheritance.CreditCard;
import com.example.HibernatePart2.entities.many2many.Programmer;
import com.example.HibernatePart2.entities.many2many.Project;
import com.example.HibernatePart2.entities.one2many.Customer;
import com.example.HibernatePart2.entities.one2many.PhoneNumber;
import com.example.HibernatePart2.entities.one2one.License;
import com.example.HibernatePart2.entities.one2one.Person;
import com.example.HibernatePart2.entities.transactionmanagement.Student;
import com.example.HibernatePart2.repos.CustomerRepo;
import com.example.HibernatePart2.repos.EmployeeRepo;
import com.example.HibernatePart2.repos.LicenseRepo;
import com.example.HibernatePart2.repos.PaymentRepo;
import com.example.HibernatePart2.repos.ProgrammerRepo;
import com.example.HibernatePart2.repos.StudentRepo;

@SpringBootTest
class HibernatePart2ApplicationTests {
	@Autowired
	StudentRepo repo;
	@Autowired
	PaymentRepo paymentRepo;
	@Autowired
	EmployeeRepo employeeRepo;
	@Autowired
	CustomerRepo customerRepo;
	@Autowired
	ProgrammerRepo programmerRepo;
	@Autowired
	LicenseRepo licenseRepo;

	@Test
	void testStudentCreate() {
		Student student = new Student();
		student.setFirstname("Ram");
		student.setLastname("SINGH");
		student.setScore(65);
		Student student2 = new Student();
		student2.setFirstname("Mahesh");
		student2.setLastname("Gupta");
		student2.setScore(85);

		repo.save(student);
		repo.save(student2);
	}

	@Test
	void testFindAllStudents() {
		repo.findAllStudents(PageRequest.of(0, 10, Direction.DESC, "id")).forEach(ele -> System.out.println(ele));

	}

	@Test
	void testFindAllStudentsNativeQuery() {
		repo.findAllStudents().forEach(ele -> System.out.println(ele));

	}

	@Test
	void testFindAllStudentsPartial() {
		repo.findAllStudentPartial().forEach(ele -> System.out.println(ele[0] + " , " + ele[1]));

	}

	@Test
	void testFindAllStudentsByfirstname() {
		repo.findAllStudentByfirstname("Rishabh").forEach(ele -> System.out.println(ele));
	}

	@Test
	void testFindAllStudentsByScoreRange() {
		repo.findStudentForGivenScore(60, 100).forEach(ele -> System.out.println(ele));
	}

	@Test
	@Transactional
	@Rollback(false)
	void testdelStuByFirstname() {
		repo.deleteStudentbyfirstname("Ram");
	}

	@Test
	void testFindAllStudentsByfirstnameQ() {
		repo.findAllStudentByfirstnameQ("Rishabh").forEach(ele -> System.out.println(ele));
	}

	// PAYMENTS TEST
	@Test
	void testCreatePayment() {
		CreditCard cc = new CreditCard();
		cc.setAmount(1000);
		cc.setCardNumbe("123456789");
		paymentRepo.save(cc);
	}

	@Test
	void testCreateCheckPayment() {
		Check cc = new Check();
		cc.setAmount(1000);
		cc.setCheckNumber("987654321");
		paymentRepo.save(cc);
	}

	// EMPLOYEE
	@Test
	void testsaveEmployee() {
		Employee employee = new Employee();
		Address address = new Address();
		address.setCity("new Delhi");
		address.setState("Delhi");
		address.setStreetAddress("Mayur vihar");
		address.setCountry("India");
		address.setZipcode("12345");
		employee.setName("Rishabh");
		employee.setAddress(address);
		employeeRepo.save(employee);
	}

	// Customer test joinning columns
	@Test
	public void createCustomer() {
		for (int i = 0; i <= 5; i++) {
			Customer customer = new Customer();
			customer.setName("User " + i);

			// customer.setNumbers(numbers);
			customer.addPhoneNumber(new PhoneNumber("9599549549", "cell", customer));
			customer.addPhoneNumber(new PhoneNumber("54490580954", "cell", customer));

			customerRepo.save(customer);
		}

	}

	@Test
	@Transactional
	void loadCustomers() {
		System.out.println(customerRepo.findById(403L));
	}

	// PROGRAMMER MANY TO MANY
	@Test
	void TestcreateProgrammer() {
		Programmer programmer = new Programmer("Rishabh Singh", 100000);
		programmer.addProject(new Project("REST API 1"));
		programmer.addProject(new Project("REST API 2"));
		programmerRepo.save(programmer);

	}

	@Test
	@Transactional
	void findProgrammer() {
		Programmer programmer = programmerRepo.findById(152);
		System.out.println(programmer);
		System.out.println(programmer.getProjects());
	}

	// One to One PERSON AND LICESNSE
	@Test
	void createLicense() {
		License license = new License();
		license.setType("CAR");
		license.setValidfrom(new Date());                                
		license.setValidTo(new Date());

		license.setPerson(new Person("RISHABH", "SINGH", 20));
		licenseRepo.save(license);
	}

	// Couse Spring data

}
