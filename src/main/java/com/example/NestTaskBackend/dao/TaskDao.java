package com.example.NestTaskBackend.dao;

import com.example.NestTaskBackend.model.TaskModel;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TaskDao extends CrudRepository<TaskModel ,Integer> {

    @Query(value = "SELECT `id`,`emp_id`, `assign_date`, `remarks`, `status`, `task_due_date`, `task_title` FROM `task` WHERE `emp_id`=:empCode",nativeQuery = true)
    List<TaskModel> viewMyTask(@Param("empCode")Integer empCode);

    @Transactional
    @Modifying
    @Query(value = "UPDATE `task` SET `status`=:status  WHERE `emp_id`=:empId",nativeQuery = true)
    void updateTaskStatus(@Param("status")String status,@Param("empId") Integer empId);
}
