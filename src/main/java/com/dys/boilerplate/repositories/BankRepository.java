package com.dys.boilerplate.repositories;

import com.dys.boilerplate.entities.Bank;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BankRepository extends CrudRepository<Bank, Integer> {
}
