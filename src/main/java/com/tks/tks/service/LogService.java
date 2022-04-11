package com.tks.tks.service;

import com.tks.tks.model.Dm.LogDm;
import com.tks.tks.model.Nm.LogNm;
import com.tks.tks.repo.LogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.tks.tks.service.utils.ServiceUtils.checkNull;
import static com.tks.tks.service.utils.ServiceUtils.checkSize;

@Service
public class LogService {
    @Autowired
    LogRepo logRepo;

    public List<LogNm> getLogsByBlockHash(String hash) {
        List<LogDm> logDm = logRepo.findByBlockHash(hash);
        checkSize(logDm);
        return logDm.stream().map(LogNm::toNm).collect(Collectors.toList());
    }

    public List<LogNm> getLogsByBlockNumber(Long number) {
        List<LogDm> logDm = logRepo.findByBlockNumber(number);
        checkSize(logDm);
        return logDm.stream().map(LogNm::toNm).collect(Collectors.toList());
    }

    public LogNm getLogsByTransactionHash(String hash) {
        LogDm logDm = logRepo.findByTransactionHash(hash);
        checkNull(logDm);
        return LogNm.toNm(logRepo.findByTransactionHash(hash));
    }

    public List<LogNm> getLogsByAddress(String address) {
        List<LogDm> logDm = logRepo.findByAddress(address);
        checkSize(logDm);
        return logDm.stream().map(LogNm::toNm).collect(Collectors.toList());
    }
}
