package com.example.NestTaskBackend.controller;


import com.example.NestTaskBackend.dao.EmployeeDao;
import com.example.NestTaskBackend.dao.TaskDao;
import com.example.NestTaskBackend.model.EmployeeModel;
import com.example.NestTaskBackend.model.TaskModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

@RestController
public class TaskController {

    @Autowired
    private TaskDao tdao;

    @Autowired
    private EmployeeDao edao;

    @CrossOrigin("*")
    @PostMapping(path = "/addTask",consumes = "application/json",produces = "application/json")
    public HashMap<String,String> addTask(@RequestBody TaskModel tm){
        HashMap<String,String>  mp=new HashMap<>();
        int empCode=tm.getEmpId();
        String name=(String) tdao.addTaskCheck(empCode);
        System.out.println(name);
        if (name!=null){
            LocalDate date=LocalDate.now();
            tm.setAssignDate(String.valueOf(date));
            tdao.save(tm);
            System.out.println(tm.getAssignDate());
            System.out.println(tm.getTaskDueDate());
            mp.put("status","success");

        }
        else{
            mp.put("status","failed");
        }
        return mp;

    }


    @CrossOrigin(origins = "*")
    @GetMapping(path = "/viewAllTask")
    public List<TaskModel> viewAllTask(){
        List<TaskModel> task=(List<TaskModel>) tdao.findAll();
        return task;

    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/viewMyTask",consumes = "application/json",produces = "application/json")
    public List<TaskModel> viewMyTask(@RequestBody TaskModel tm){
        HashMap<String,String> map=new HashMap<>();
        List<TaskModel> value=(List<TaskModel>) tdao.viewMyTask(tm.getEmpId());
        return value;
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/updateTaskStatus",produces = "application/json",consumes = "application/json")
    HashMap<String,String> updateTaskStatus(@RequestBody TaskModel t){
        HashMap<String,String> map=new HashMap<>();
        tdao.updateTaskStatus(t.getStatus(),t.getEmpId());
        map.put("status","updated");
        return map;
    }



}
