package com.example.springbasicstraining.labs.step10_response_entity.service;

import com.example.springbasicstraining.labs.step10_response_entity.dto.BookRequest;
import com.example.springbasicstraining.labs.step10_response_entity.dto.BookResponse;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class BookService {
    //store: 책 데이터를 임시로 저장하는 Map
    //key: Long (id)
    //value: BookResponse
    //DB 대신 사용하는 임시 메모리 저장소.
    private final Map<Long, BookResponse> store = new ConcurrentHashMap<>();
    //seq.getAndIncrement() 호출할 때마다 1씩 증가해서 id값을 고유하게 생성.
    private final AtomicLong seq = new AtomicLong(1);

    public BookResponse create(BookRequest req) {
        long id = seq.getAndIncrement(); //고유 id생성
        BookResponse book = new BookResponse(id, req.title(), req.author(),"내용없음");
        store.put(id, book); // Map에 저장
        return book; // 생성된 객체 반환
    }

    //단건조회
    public Optional<BookResponse> find(Long id) {
        return Optional.ofNullable(store.get(id)); //store.get(id) 해당 책 꺼냄, 값이 없을 수 있으니 Optional로 감싸서 반환
        // 컨트롤러는 orElse, map, ifPresent같은 메서드로 안전하게 처리
    }

    public boolean delete(Long id) {
        return store.remove(id) != null;
        // id 책을 map에서 제거
        // 제거 성공하면 BookResponse객체가 반환되고 없으면 null.
        // 따라서 !=null로 검사해서 삭제/성공/실패 여부를 boolean으로 반환
    }
}
