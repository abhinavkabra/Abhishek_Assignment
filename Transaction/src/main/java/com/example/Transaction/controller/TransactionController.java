package com.example.Transaction.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.Transaction.entity.TransactionDetailsEntity;
import com.example.Transaction.service.TransactionService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/payment")
@AllArgsConstructor
public class TransactionController {

	private TransactionService transactionService;
	
	@PostMapping("/transaction")
	@ResponseStatus(code = HttpStatus.CREATED)
	public int addTransaction(@RequestBody TransactionDetailsEntity transactionDetailsEntity) {
		return transactionService.addTransaction(transactionDetailsEntity).getTransactionId();
	}
	
	@GetMapping("/transaction/{transactionId}")
	public ResponseEntity<TransactionDetailsEntity> getTransaction(@PathVariable int transactionId) {
		return new ResponseEntity<>(transactionService.getTransaction(transactionId),HttpStatus.OK);
	}
}
