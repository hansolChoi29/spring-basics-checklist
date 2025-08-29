package com.example.springbasicstraining.labs.step9_request_response.Service;

import com.example.springbasicstraining.labs.step9_request_response.dto.MemoRequest;
import com.example.springbasicstraining.labs.step9_request_response.dto.MemoResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class MemoService {
    private final Map<Long, MemoResponse> store = new ConcurrentHashMap<>();
    private final AtomicLong seq = new AtomicLong(1);

    public MemoResponse create(MemoRequest req) {
        long id = seq.getAndIncrement();
        MemoResponse created = new MemoResponse(id, req.title(), req.content());
        store.put(id, created);
        return created;
    }

    public MemoResponse read(Long id) {
        MemoResponse found = store.get(id);
        if (found == null) throw new org.springframework.web.server.ResponseStatusException(
                org.springframework.http.HttpStatus.NOT_FOUND, "Memo not found");
        return found;
    }

    public List<MemoResponse> list() {
        return new ArrayList<>(store.values());
    }

    public List<MemoResponse> search(String keyword, int page) {
        String k = keyword == null ? "" : keyword.toLowerCase();
        return store.values().stream()
                .filter(m -> m.title().toLowerCase().contains(k) || m.content().toLowerCase().contains(k))
                .skip((long) page * 10)
                .limit(10)
                .toList();
    }

    public MemoResponse update(Long id, MemoRequest req) {
        if (!store.containsKey(id)) throw new org.springframework.web.server.ResponseStatusException(
                org.springframework.http.HttpStatus.NOT_FOUND, "Memo not found");
        MemoResponse updated = new MemoResponse(id, req.title(), req.content());
        store.put(id, updated);
        return updated;
    }

    public void delete(Long id) {
        if (store.remove(id) == null) throw new org.springframework.web.server.ResponseStatusException(
                org.springframework.http.HttpStatus.NOT_FOUND, "Memo not found");
    }
}
