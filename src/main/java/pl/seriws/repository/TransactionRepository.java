package pl.seriws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.seriws.model.Transaction;


@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> 
{

}
