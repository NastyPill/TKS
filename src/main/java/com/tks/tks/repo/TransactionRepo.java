package com.tks.tks.repo;

import com.tks.tks.model.Dm.BlockDm;
import com.tks.tks.model.Dm.TransactionDm;
import com.tks.tks.model.Nm.BlockNm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface TransactionRepo extends JpaRepository<TransactionDm, Long> {

    TransactionDm findByHash(String hash);

    TransactionDm findByBlockNumberAndTransactionIndex(Long number, Long transactionIndex);

    List<TransactionDm> findByBlockNumber(Long number);

    List<TransactionDm> findByFrom(String from);
}
