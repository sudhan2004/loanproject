package com.educationloan.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educationloan.model.LoanApplicationModel;
import com.educationloan.repository.LoanApplicationModelRepository;

@Service
public class LoanApplicationModelService
{
	@Autowired
	LoanApplicationModelRepository lrep;
	public LoanApplicationModel updateDetails(LoanApplicationModel lm)
	{
		return lrep.save(lm);
	}
	public void deleteVal(int id)
	{
		lrep.deleteById(id);
	}
	public Optional<LoanApplicationModel> getAdmin(int id)
	{
		return lrep.findById(id);
	}

}