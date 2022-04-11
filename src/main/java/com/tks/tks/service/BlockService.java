package com.tks.tks.service;

import com.tks.tks.model.Dm.BlockDm;
import com.tks.tks.model.Nm.BlockNm;
import com.tks.tks.model.exceptions.EntityNotFoundException;
import com.tks.tks.repo.BlockRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Block;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

import static com.tks.tks.service.utils.ServiceUtils.checkNull;
import static com.tks.tks.service.utils.ServiceUtils.checkSize;

@Service
public class BlockService {

    @Autowired
    BlockRepo blockRepo;

    public BlockNm getBlockByHash(String hash) {
        BlockDm blockDm = blockRepo.findByHash(hash);
        checkNull(blockDm);
        return BlockNm.toNm(blockDm);
    }

    public List<BlockNm> getBlockByMiner(String miner) {
        List<BlockDm> blockDm = blockRepo.findByMiner(miner);
        checkSize(blockDm);
        return blockDm.stream().map(BlockNm::toNm).collect(Collectors.toList());
    }

    public BlockNm getBlockByNumber(Long number) {
        BlockDm blockDm = blockRepo.findByNumber(number);
        checkNull(blockDm);
        return BlockNm.toNm(blockDm);
    }

    public List<BlockNm> getAll() {
        List<BlockDm> blockDm = blockRepo.findAll();
        checkSize(blockDm);
        return blockDm.stream().map(BlockNm::toNm).collect(Collectors.toList());
    }

    public List<BlockNm> getBlockByTimerange(String from, String to) {
        List<BlockDm> blockDm = blockRepo.findByTimestampBetween(Timestamp.valueOf(from), Timestamp.valueOf(to));
        checkSize(blockDm);
        return blockDm.stream().map(BlockNm::toNm).collect(Collectors.toList());
    }
}
