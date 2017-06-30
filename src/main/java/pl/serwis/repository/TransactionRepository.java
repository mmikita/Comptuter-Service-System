package pl.serwis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.serwis.model.Transaction;


@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> 
{

}
