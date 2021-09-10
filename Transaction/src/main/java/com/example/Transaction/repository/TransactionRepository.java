package com.example.Transaction.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Transaction.entity.TransactionDetailsEntity;

public interface TransactionRepository extends JpaRepository<TransactionDetailsEntity, Integer> {

}
