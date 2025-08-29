package com.example.springbasicstraining.labs.step11_entity_repository.service;

import com.example.springbasicstraining.labs.step11_entity_repository.entity.Note;
import com.example.springbasicstraining.labs.step11_entity_repository.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor //생성자 자동 생성해서 레포 주입
public class NoteService {
    
    private  final NoteRepository noteRepository;

    @Transactional
    public Note create(Note note) {
        return noteRepository.save(note);
    }

    public List<Note> findAll() {
        return noteRepository.findAll();
    }
    public Optional<Note> findById(Long id) {
        return noteRepository.findById(id);
    }

    @Transactional
    public boolean delete(Long id) {
        if (!noteRepository.existsById(id)) return false;
        noteRepository.deleteById(id);
        return true;
    }
}
