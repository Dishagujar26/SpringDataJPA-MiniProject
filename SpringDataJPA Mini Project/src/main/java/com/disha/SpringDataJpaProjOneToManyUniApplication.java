
package com.disha;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.disha.models.Department;
import com.disha.models.Employee;
import com.disha.service.DepartmentService;

@SpringBootApplication
public class SpringDataJpaProjOneToManyUniApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext container = 
		SpringApplication.run(SpringDataJpaProjOneToManyUniApplication.class, args);
		DepartmentService service = container.getBean(DepartmentService.class);
		
		// Create Department with Employees- Part 1
		List<String> empNames = List.of("Joey Tribbiani", "Rachel Green");
		Department dept = service.createDepartmentWithEmps("IT", empNames);
		System.out.println("Created Department : "+dept.getName());
		
		empNames = List.of("Chandler M Bing", "Monica Geller");
		Department dept2 = service.createDepartmentWithEmps("HR", empNames);
		System.out.println("Created Department : "+dept2.getName());
		
		// Get all Departments- Part 2
        System.out.println("All Departments :");
        List<Department>deptList = service.getAllDepartments();
        for(Department deptDepartment : deptList) {
        	System.out.println("Department Name " + deptDepartment.getName());
        	System.out.println("Employee in "+deptDepartment.getName()+" is : " + deptDepartment.getEmpList());
        	System.out.println();
        }
        
//        // Update Department Name- Part 3
        String name = dept.getName();
        service.updateDepartment(dept.getId(), "Sales");
        System.out.println("Updated Department " + name +" to Sales ! ");
//        
//       // Add Employee to Department- Part 4
        service.addEmployeeToDepartment(dept2.getId(), "Phoebe Buffay");
        System.out.println("Employee added Phoebe Buffay !");
//        
       // Remove Employee from Department – Part 5
       Employee empToRemove = dept.getEmpList().get(0); // first employee
       service.removeEmployeeDromDepartment(dept.getId(), empToRemove.getId());
//       
//      // Delete Department – Part 6
       String nameString = dept2.getName();
       service.deleteDepartment(dept2.getId());
       System.out.println("Deleted Department !" + nameString);

  

	}

}
