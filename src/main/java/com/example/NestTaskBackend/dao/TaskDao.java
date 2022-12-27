package com.example.NestTaskBackend.dao;

import com.example.NestTaskBackend.model.EmployeeModel;
import com.example.NestTaskBackend.model.TaskModel;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface TaskDao extends CrudRepository<TaskModel ,Integer> {

    @Query(value = "SELECT `id`,`emp_id`, `assign_date`, `remarks`, `status`, `task_due_date`, `task_title` FROM `task` WHERE `emp_id`=:empId",nativeQuery = true)
    List<TaskModel> viewMyTask(@Param("empId")Integer empId);

    @Transactional
    @Modifying
    @Query(value = "UPDATE `task` SET `status`=:status  WHERE `emp_id`=:empId",nativeQuery = true)
    void updateTaskStatus(@Param("status")String status,@Param("empId") Integer empId);

    @Query(value = "SELECT `emp_name` FROM `employee` WHERE `emp_code`=:empId",nativeQuery = true)
   String addTaskCheck(@Param("empId")Integer empId);

    @Query(value = "SELECT t.id, t.`assign_date`,t.`task_title`,t.`task_due_date`,t.`remarks`,t.`status`,t.emp_id,e.emp_name FROM `task` t JOIN employee e ON t.emp_id=e.emp_code",nativeQuery = true)
    List<Map<String,String>> viewAllTask();
}
