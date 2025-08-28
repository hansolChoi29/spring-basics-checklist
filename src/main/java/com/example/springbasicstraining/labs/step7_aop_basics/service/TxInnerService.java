package com.example.springbasicstraining.labs.step7_aop_basics.service;



import com.example.springbasicstraining.labs.step7_aop_basics.entity.TodoStep7;
import com.example.springbasicstraining.labs.step7_aop_basics.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TxInnerService {
    private final TodoRepository todoRepository;

    @Transactional
    public void runtimeFail() {
        todoRepository.save(TodoStep7.create("A"));
        todoRepository.save(TodoStep7.create("B"));
        throw new IllegalStateException("강제 RuntimeException → 롤백");
    }

    @Transactional(rollbackFor = Exception.class)
    public void checkedFail() throws Exception {
        todoRepository.save(TodoStep7.create("C"));
        throw new Exception("강제 Checked Exception → rollbackFor 롤백");
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void innerRequiresNew() {
        todoRepository.save(TodoStep7.create("INNER-REQUIRES-NEW"));
    }

    @Transactional(readOnly = true)
    public long count() {
        return todoRepository.count();
    }

    @Transactional
    public void deleteAll() {
        todoRepository.deleteAll();
    }
}
