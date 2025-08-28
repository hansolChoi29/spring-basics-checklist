package com.example.springbasicstraining.labs.step7_aop_basics.controller;

import com.example.springbasicstraining.labs.step7_aop_basics.service.TxCallerService;
import com.example.springbasicstraining.labs.step7_aop_basics.service.TxInnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/labs/step7")
public class TxTestController {
    private final TxInnerService inner;
    private final TxCallerService caller;

    @PostMapping("/reset")
    public String reset() {
        inner.deleteAll();
        return "DB reset 완료";
    }

    @GetMapping("/count")
    public long count() {
        return inner.count();
    }

    @PostMapping("/runtime")
    public ResponseEntity<String> runtimeRollback() {
        try {
            inner.runtimeFail();//여기서 RuntimeException 터짐
            return ResponseEntity.ok("성공");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("롤백됨 (runtime). count=" + inner.count());
        }
    }

    @PostMapping("/checked")
    public ResponseEntity<String> checkedRollback() {
        try {
            inner.checkedFail();
            return ResponseEntity.ok("성공");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("롤백됨 (checked via rollbackFor). count=" + inner.count());
        }
    }

    @PostMapping("/requires-new/outer-fails")
    public ResponseEntity<String> requiresNewOuterFails() {
        try {
            caller.outerCallsRequiresNewAndFails();
            return ResponseEntity.ok("성공");
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                    .body("OUTER 롤백, INNER는 커밋됨. count=" + inner.count());
        }
    }
}
