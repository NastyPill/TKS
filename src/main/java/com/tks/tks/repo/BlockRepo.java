package com.tks.tks.repo;

import com.tks.tks.model.Dm.BlockDm;
import com.tks.tks.model.Nm.BlockNm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface BlockRepo extends JpaRepository<BlockDm, Long> {

    BlockDm findByHash(String hash);

    List<BlockDm> findByMiner(String miner);

    BlockDm findByNumber(Long number);

    List<BlockDm> findByTimestampBetween(Timestamp from, Timestamp to);
}
