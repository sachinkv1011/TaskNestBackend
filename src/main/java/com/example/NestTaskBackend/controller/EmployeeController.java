package com.example.NestTaskBackend.controller;

import com.example.NestTaskBackend.dao.EmployeeDao;
import com.example.NestTaskBackend.model.EmployeeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeDao edao;

    @CrossOrigin(origins="*")
    @PostMapping(path="/addEmployee",produces = "application/json",consumes = "application/json")
    HashMap<String,String> addEmployee(@RequestBody EmployeeModel em){
        HashMap<String,String> map=new HashMap<>();
        List<EmployeeModel> result=(List<EmployeeModel>) edao.empLogin(em.getUsername(), em.getPassword());
        if (result.size()==0){
            edao.save(em);
            map.put("status","success");
        }
        else {
            map.put("status", "userExist");
        }
        return map;

    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/emplogin",produces = "application/json",consumes = "application/json")
    public HashMap<String,String> empLogin(@RequestBody EmployeeModel em){
        HashMap<String,String> map =new HashMap<>();
        List<EmployeeModel> result=(List<EmployeeModel>) edao.empLogin(em.getUsername(), em.getPassword());
        if (result.size()==0){
            map.put("status","failed-No user found");
        }
        else {
            int userId=result.get(0).getId();
            map.put("status","success");
            map.put("userId",String.valueOf(userId));
        }
        return map;
    }

    @CrossOrigin(origins="*")
    @PostMapping(path="/viewMyProfile",produces = "application/json",consumes = "application/json")
    List<EmployeeModel> myProfile(@RequestBody EmployeeModel e){
        List<EmployeeModel> profile= (List<EmployeeModel>) edao.myProfile(e.getId());
        return profile;
    }

    @CrossOrigin(origins="*")
    @GetMapping("/viewAllEmployee")
    public List<EmployeeModel> viewAllEmployee(){
        return (List<EmployeeModel>) edao.findAll();
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path= "/searchEmployee",produces = "application/json",consumes = "application/json")
    public List<EmployeeModel> searchEmployee(@RequestBody EmployeeModel em){
        HashMap<String,String> hm=new HashMap<>();
        List<EmployeeModel> search=(List<EmployeeModel>) edao.search(em.getEmpName());
        if (search.size()!=0){
            System.out.println("employee found");
            return search;


        }
        else {
            System.out.println("not found");
        }
        return search;
    }


}
