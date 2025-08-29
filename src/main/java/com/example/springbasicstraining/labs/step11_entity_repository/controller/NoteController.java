package com.example.springbasicstraining.labs.step11_entity_repository.controller;

import com.example.springbasicstraining.labs.step11_entity_repository.entity.Note;
import com.example.springbasicstraining.labs.step11_entity_repository.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/notes")
public class NoteController {
    private final NoteRepository noteRepository;

    @PostMapping
    public ResponseEntity<Note> createNote(@RequestBody Note note) {
        return ResponseEntity.ok(noteRepository.save(note));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Note> getNoteById(@PathVariable Long id) {
        return noteRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteNoteById(@PathVariable Long id) {
       if(noteRepository.existsById(id)){ //존재하는 경우
           noteRepository.deleteById(id); //삭제 후
        return ResponseEntity.ok().build();// 응답코드 204
       }else{
           return ResponseEntity.notFound().build(); //404
       }
    }
}
