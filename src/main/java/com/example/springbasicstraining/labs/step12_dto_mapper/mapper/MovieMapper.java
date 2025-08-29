package com.example.springbasicstraining.labs.step12_dto_mapper.mapper;
//Controller ←→ Service ←→ Repository ←→ DB
// 1) 이 클래스가 필요한 이유
// DB에 저장하는 건 Entity(JPA관리 대상)
// API로 주고 받는 건 DTO(클라이언트 계약용)
// Entity와 DTO는 모양이 비슷해 보이지만 역할이 다르기 때문에 분리해 둬야 함
//그래서 변환이 필요하고 그 변환을 한 군데 모아둔 게 mapper.

// 2) mapper가 없으면?
// Service나 Controller 코드에 변환 로직이 막 섞임

import com.example.springbasicstraining.labs.step12_dto_mapper.dto.MovieRequest;
import com.example.springbasicstraining.labs.step12_dto_mapper.dto.MovieResponse;
import com.example.springbasicstraining.labs.step12_dto_mapper.entity.Movie;

public class MovieMapper {
    private MovieMapper() {}

    // DTO → Entity (클라이언트 요청 → DB저장용)
    public static Movie toEntity(MovieRequest movieRequest) {
        return new Movie(movieRequest.title(), movieRequest.director(), movieRequest.year(), movieRequest.rating());
    }

    //Entity → DTO (DB조회 결과 → 클라이언트 응답)
    public static MovieResponse toResponse(Movie movie) {
        return new MovieResponse(movie.getId(), movie.getTitle(), movie.getDirector(), movie.getYear(), movie.getRating());
    }
}

// 코드가 커지면 변환 로직이 여기저기 흩어져서 지저분해짐
// 한 군데 모아 관리하면 편하다라는 리펙토링/실무 관점의 테크닉임
// 1) Mapper 없이 — 초급 과정에서 흔히 하는 방식
// 2) Mapper 추가 — 실무/프로젝트 커지면 선호

//해당 mapper는 수동임
//자동으로 구현해야 될 경우 class-> interface로 변경하고 의존성을 추가하면 됨
// @Mapper(componentModel="string")

