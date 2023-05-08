package com.educationloan.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.educationloan.model.LoanApplicationModel;
import com.educationloan.service.AdminService;
import com.educationloan.service.LoanApplicationModelService;

@RestController
public class LoanApplicationController 
{
  @Autowired
  AdminService aService;
  @Autowired 
  LoanApplicationModelService lser;
  @GetMapping("/getAdminDetails")
  public List<LoanApplicationModel> getAdmin()
  {
	  List<LoanApplicationModel> adminList = aService.getAdmin();
 	   return adminList;
  }
  @PostMapping("/addUser")
  public LoanApplicationModel saveDetails(@RequestBody LoanApplicationModel lm)
  {
	  return aService.saveDeatils(lm);
  }
  @GetMapping("/getAdminDetails/{id}")
  public Optional<LoanApplicationModel> getAdmin(@PathVariable int id)
  {
	  Optional<LoanApplicationModel> adminList = lser.getAdmin(id);
 	   return adminList;
  }
  @PutMapping("/addUser")
  public LoanApplicationModel updaeDetails(@RequestBody LoanApplicationModel lm)
  {
	  return lser.updateDetails(lm);
  }
  @DeleteMapping("/ldelete/{id}")
  public void deleteVal(@PathVariable int id)
  {
	  lser.deleteVal(id);
  }
}