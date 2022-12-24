package com.example.NestTaskBackend.dao;

import com.example.NestTaskBackend.model.EmployeeModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeDao extends CrudRepository<EmployeeModel,Integer> {

    @Query(value = "SELECT `id`, `designation`, `emp_code`, `emp_email`, `emp_name`, `emp_phone`, `emp_salary`, `password`, `username` FROM `employee` WHERE `username`=:username AND `password`=:password",nativeQuery = true)
    List<EmployeeModel> empLogin(@Param("username") String username,@Param("password") String password);

    @Query(value = "SELECT  `id`,`designation`, `emp_code`, `emp_email`, `emp_name`, `emp_phone`, `emp_salary`, `password`,  `username` FROM `employee` WHERE `id`=:id",nativeQuery = true)
    List<EmployeeModel> myProfile(@Param("id")Integer id);

    @Query(value = "SELECT `id`, `designation`, `emp_code`, `emp_email`, `emp_name`, `emp_phone`, `emp_salary`, `password`, `username` FROM `employee` WHERE `emp_name` LIKE %:name% ",nativeQuery = true)
    List<EmployeeModel> search(@Param("name")String name);
}
