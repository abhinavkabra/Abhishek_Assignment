package com.example.Transaction.service;

import org.springframework.stereotype.Service;

import com.example.Transaction.entity.TransactionDetailsEntity;
import com.example.Transaction.repository.TransactionRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TransactionService {

	private TransactionRepository transactionRepo;
	
	public TransactionDetailsEntity addTransaction(TransactionDetailsEntity transactionDetailsEntity) {
		return transactionRepo.save(transactionDetailsEntity);
	}
	
	public TransactionDetailsEntity getTransaction(int id) {
		return transactionRepo.findById(id).get();
	}
	
}
