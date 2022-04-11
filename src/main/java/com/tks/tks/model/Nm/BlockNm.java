package com.tks.tks.model.Nm;

import com.tks.tks.model.Dm.BlockDm;
import com.tks.tks.model.Dm.TransactionDm;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
public class BlockNm {

    private long number;
    private String hash;
    private String parentHash;
    private String nonce;
    private String sha3Uncles;
    private String logsBloom;
    private String transactionsRoot;
    private String stateRoot;
    private String receiptsRoot;
    private String author;
    private String miner;
    private String mixHash;
    private String difficulty;
    private String totalDifficulty;
    private String extraData;
    private long size;
    private long gasLimit;
    private long gasUsed;
    private Date timestamp;

    public static BlockNm toNm(BlockDm blockDm) {
        return BlockNm.builder()
                .number(blockDm.getNumber())
                .hash(blockDm.getHash())
                .parentHash(blockDm.getParentHash())
                .nonce(blockDm.getNonce())
                .sha3Uncles(blockDm.getSha3Uncles())
                .transactionsRoot(blockDm.getTransactionsRoot())
                .stateRoot(blockDm.getStateRoot())
                .receiptsRoot(blockDm.getReceiptsRoot())
                .author(blockDm.getAuthor())
                .miner(blockDm.getMiner())
                .mixHash(blockDm.getMixHash())
                .difficulty(blockDm.getDifficulty())
                .totalDifficulty(blockDm.getTotalDifficulty())
                .extraData(blockDm.getExtraData())
                .size(blockDm.getSize())
                .gasLimit(blockDm.getGasLimit())
                .gasUsed(blockDm.getGasUsed())
                .timestamp(blockDm.getTimestamp())
                .build();
    }

}
