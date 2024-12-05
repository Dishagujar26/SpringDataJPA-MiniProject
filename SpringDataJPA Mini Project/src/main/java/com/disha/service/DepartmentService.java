package com.disha.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.disha.models.Department;
import com.disha.models.Employee;
import com.disha.repository.DepartmentRepository;

@Service
public class DepartmentService {
      private DepartmentRepository repo;
      
      @Autowired
      public DepartmentService(DepartmentRepository repo) {
    	  this.repo=repo;
      }
      public DepartmentService(){
    	  
	  }
      public Department createDepartmentWithEmps(String deptName, List<String> empName){
             Department department = new Department(deptName); 
             for(String e : empName) {
            	 department.addEmp(new Employee(e));
             }
		     return repo.save(department);
	  }
      public List<Department> getAllDepartments() {
    		return repo.findAll();
    	}
      public Department updateDepartment(Integer deptId, String newName) {
    	  Optional<Department> dept = repo.findById(deptId);
    	  if(dept.isEmpty()) {
    		  System.out.println("Department not found !");
    		  return null;
    	  }
    	  Department department = dept.get();
    	  department.setName(newName);
    	 return repo.save(department);
    	  
      }
      
      public void deleteDepartment(Integer deptId) {
    	  repo.deleteById(deptId);
      }
      public void addEmployeeToDepartment(Integer deptId, String empName) {
    	  Optional<Department> dept = repo.findById(deptId);
    	  if(dept.isEmpty()) {
    		  System.out.println("Department not found !");
    		  return;
    	  }
    	  Department department = dept.get();
    	  department.addEmp(new Employee(empName ));
    	  repo.save(department);
      }
      public void removeEmployeeDromDepartment(Integer deptId,Integer empId) {
    	  Optional<Department> dept = repo.findById(deptId);
    	  if(dept.isEmpty()) {
    		  System.out.println("Department not found !");
    		  return;
    	  }
    	  Department department = dept.get();
    	  List<Employee> empList = department.getEmpList();
    	  for(Employee employee : empList) {
    		  if(employee.getId() == empId) {
    			  department.removeEmp(employee);
    			  repo.save(department);
    			  System.out.println("Employee removed !");
    			  return;
    		  }
    	  }
    	  System.out.println("Employee is not found !");
      }
      
}
