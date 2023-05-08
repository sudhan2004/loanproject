package com.educationloan.service;

import java.util.List;

//import java.util.List;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educationloan.model.LoanApplicationModel;
import com.educationloan.model.UserModel;
import com.educationloan.repository.LoanApplicationModelRepository;
import com.educationloan.repository.UserRepository;



@Service
public class UserService 
{
    @Autowired
    UserRepository uRep;
    @Autowired
    LoanApplicationModelRepository lamRep;
	public String validateUser(String email,String password) 
	{
		UserModel u = uRep.findByEmail(email);
		if(u == null)
		{
			return" No user found " ;
		}
		else
		{
			if(u.getPassword().equals(password))
			{
				return"Login Successfull" ;
			}
			else
			{
				return "Login Failed" ;
			}
		}
	}
	public UserModel newUser(UserModel user) 
	{
		return uRep.save(user);
	}
	public List<UserModel> getUserDetails() 
	{
		return uRep.findAll();
	}
	public LoanApplicationModel getLoan(int loanId)
    {
	 LoanApplicationModel l = lamRep.findById(loanId).get();
     return l;
    }
	public UserModel getProfile(int id) 
	{
		UserModel u = uRep.findById(id).get();
		return u;
	}
	public void delProfile(int id)
	{
		uRep.deleteById(id);
	}
	public UserModel updateVal(UserModel u)
	{
		return uRep.save(u);
	}
}