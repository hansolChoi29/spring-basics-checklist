package com.example.springbasicstraining.labs.step9_request_response.controller;


import com.example.springbasicstraining.labs.step9_request_response.Service.MemoService;
import com.example.springbasicstraining.labs.step9_request_response.dto.MemoRequest;
import com.example.springbasicstraining.labs.step9_request_response.dto.MemoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

// 컨트롤러에 서비스 빈을 등록하여 사용하려면
//컨트롤러의 생성자가 필요한데, 코드 간결성을 위해 RequiredArgsConstructor어노테이션을 이용한다.
@RestController
@RequestMapping("/api/memos")
@RequiredArgsConstructor
public class MemoController {
    private final MemoService memoService;

    //@RequestBody : 생성
    @PostMapping
    public MemoResponse create(@RequestBody MemoRequest req) {
        return memoService.create(req);
    }
// 컨트롤러는 문자열이 아니라 DTO객체를 받아서 가공해야 함 그래서 서비스가 필요해짐
    
    //@PathVariable: 단건조회
    @GetMapping("/{id}")
    public MemoResponse read(@PathVariable Long id) {
        return memoService.read(id);
    }

    @GetMapping
    public List<MemoResponse> list() {
        return memoService.list();
    }

    @GetMapping("/search")
    public List<MemoResponse> search(
            @RequestParam(defaultValue = "") String keyword,
            @RequestParam(defaultValue = "0") int page
    ) {
        return memoService.search(keyword, page);
    }

    @PutMapping("/{id}")
    public MemoResponse update(@PathVariable Long id, @RequestBody MemoRequest req) {
        return memoService.update(id, req);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        memoService.delete(id);
    }
}

// 처음에는 서비스 없이 컨트롤러만 있었다.
// 컨트롤러 안에 있던 Map이 중간에 초기화돼서(핫리로드 등) 저장된 메모가 사라짐
// 그럼 서비스로 해결 본 이유는 무엇일까?
// @Service는 싱글톤(앱 내 하나)이라 Map이 안날아감-> 저장된 데이터 유지
// MemoService만들고 Map/시퀀스 거기로 이동
// 컨트롤러에서 @RequiredArgsConstructor로 Memoservice 주입해서 씀

//즉, 컨트롤러 내부 상태(맵)-> 리로드에 취약-> 서비스(싱글톤)로 빼면 안정적