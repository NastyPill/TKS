package com.tks.tks.model.Nm;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tks.tks.model.Dm.BlockDm;
import com.tks.tks.model.Dm.TransactionDm;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Builder
@Data
@AllArgsConstructor
public class TransactionNm {

    @JsonIgnore
    private long id;
    private String hash;
    private long nonce;
    private long transactionIndex;
    private String from;
    private String to;
    private long value;
    private long gasPrice;
    private long gas;
    private String input;
    private String creates;
    private String publicKey;
    private String raw;
    private String r;
    private String s;
    private long v;

    public static TransactionNm toNm(TransactionDm transactionDm) {
        return TransactionNm.builder()
                .hash(transactionDm.getHash())
                .nonce(transactionDm.getNonce())
                .transactionIndex(transactionDm.getTransactionIndex())
                .from(transactionDm.getFrom())
                .to(transactionDm.getTo())
                .value(transactionDm.getValue())
                .gasPrice(transactionDm.getGasPrice())
                .gas(transactionDm.getGas())
                .input(transactionDm.getInput())
                .creates(transactionDm.getCreates())
                .publicKey(transactionDm.getPublicKey())
                .raw(transactionDm.getRaw())
                .r(transactionDm.getR())
                .s(transactionDm.getS())
                .v(transactionDm.getV())
                .build();
    }

}
