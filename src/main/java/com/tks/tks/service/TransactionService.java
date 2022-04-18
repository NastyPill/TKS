package com.tks.tks.service;

import com.tks.tks.model.Dm.BlockDm;
import com.tks.tks.model.Dm.TransactionDm;
import com.tks.tks.model.Nm.TransactionNm;
import com.tks.tks.repo.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import static com.tks.tks.service.utils.ServiceUtils.checkNull;
import static com.tks.tks.service.utils.ServiceUtils.checkSize;

@Service
public class TransactionService {

    @Autowired
    TransactionRepo transactionRepo;

    @Autowired
    BlockService blockService;

    public TransactionNm getTransactionByHash(String hash) {
        TransactionDm transactionDm = transactionRepo.findByHash(hash);
        checkNull(transactionDm);
        return TransactionNm.toNm(transactionDm);
    }

    public TransactionNm getByBlockAndNumber(Long number, Long blockNumber) {
        TransactionDm transactionDm = transactionRepo.findByBlockNumberAndTransactionIndex(blockNumber, number);
        checkNull(transactionDm);
        return TransactionNm.toNm(transactionDm);
    }

    public List<TransactionNm> getAll() {
        List<TransactionDm> transactionDm = transactionRepo.findAll();
        checkSize(transactionDm);
        return transactionDm.stream().map(TransactionNm::toNm).collect(Collectors.toList());
    }

    public List<TransactionNm> getByBlockNumber(Long number) {
        List<TransactionDm> transactionDm = transactionRepo.findByBlockNumber(number);
        return transactionDm.stream().map(TransactionNm::toNm).collect(Collectors.toList());
    }

    public List<TransactionNm> getTransactionByTimestamp(String from, String to) {
        List<TransactionNm> transactionNm = new LinkedList<>();
        blockService.getBlockByTimerange(from, to).stream().map(x -> getByBlockNumber(x.getNumber())).forEach(transactionNm::addAll);
        return transactionNm;
    }

    public List<TransactionNm> getByFrom(String from) {
        List<TransactionDm> transactionDm = transactionRepo.findByFrom(from);
        checkSize(transactionDm);
        return transactionDm.stream().map(TransactionNm::toNm).collect(Collectors.toList());
    }
}
