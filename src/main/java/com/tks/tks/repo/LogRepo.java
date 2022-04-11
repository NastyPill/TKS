package com.tks.tks.repo;

import com.tks.tks.model.Dm.LogDm;
import com.tks.tks.model.Nm.LogNm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogRepo extends JpaRepository<LogDm, Long> {

    List<LogDm> findByBlockNumber(Long blockNumber);

    List<LogDm> findByBlockHash(String blockHash);

    LogDm findByTransactionHash(String transactionHash);

    List<LogDm> findByAddress(String address);

}
