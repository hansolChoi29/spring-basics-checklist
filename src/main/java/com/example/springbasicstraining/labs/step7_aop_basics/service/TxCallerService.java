package com.example.springbasicstraining.labs.step7_aop_basics.service;
import com.example.springbasicstraining.labs.step7_aop_basics.repository.TodoRepository;

import com.example.springbasicstraining.labs.step7_aop_basics.entity.TodoStep7;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TxCallerService {
    private final TodoRepository todoRepository;
    private final TxInnerService inner;

    @Transactional
    public void outerCallsRequiresNewAndFails() {
        todoRepository.save(TodoStep7.create("OUTER-BEFORE"));

        inner.innerRequiresNew(); // 별도 트랜잭션 → 커밋

        throw new IllegalStateException("OUTER 실패 → OUTER 롤백, INNER는 유지");
    }
}
