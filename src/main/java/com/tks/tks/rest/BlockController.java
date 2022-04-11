package com.tks.tks.rest;

import com.tks.tks.model.Nm.BlockNm;
import com.tks.tks.repo.BlockRepo;
import com.tks.tks.service.BlockService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@RestController()
public class BlockController {

    private static Logger LOG = LoggerFactory.getLogger(BlockController.class);

    @Autowired
    BlockService blockService;

    @GetMapping("/api/block/getByHash")
    public ResponseEntity<BlockNm> getByHash(@RequestParam String hash) {
        return new ResponseEntity<>(blockService.getBlockByHash(hash), HttpStatus.OK);
    }

    @GetMapping("/api/block/getByMiner")
    public ResponseEntity<List<BlockNm>> getByMiner(@RequestParam String miner) {
        return new ResponseEntity<>(blockService.getBlockByMiner(miner), HttpStatus.OK);
    }

    @GetMapping("/api/block/getByNumber")
    public ResponseEntity<BlockNm> getByNumber(@RequestParam Long number) {
        return new ResponseEntity<>(blockService.getBlockByNumber(number), HttpStatus.OK);
    }

    @GetMapping("/api/block/getAll")
    public ResponseEntity<List<BlockNm>> getAll() {
        return new ResponseEntity<>(blockService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/api/block/getByTimeRange")
    public ResponseEntity<List<BlockNm>> getByTimeRange(@RequestParam String from, @RequestParam String to) {
        return new ResponseEntity<>(blockService.getBlockByTimerange(from, to), HttpStatus.OK);
    }
}