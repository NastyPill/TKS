package com.tks.tks.model.Nm;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tks.tks.model.Dm.LogDm;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
public class LogNm {

    @JsonIgnore
    private long id;
    private String address;
    private String blockHash;
    private long blockNumber;
    private String data;
    private long logIndex;
    private List<String> topics;
    private String transactionHash;
    private long transactionIndex;

    public static LogNm toNm(LogDm logDm) {
        return LogNm.builder()
                .address(logDm.getAddress())
                .blockHash(logDm.getBlockHash())
                .blockNumber(logDm.getBlockNumber())
                .data(logDm.getData())
                .logIndex(logDm.getLogIndex())
                .topics(logDm.getTopics())
                .transactionHash(logDm.getTransactionHash())
                .transactionIndex(logDm.getTransactionIndex())
                .build();
    }

}
