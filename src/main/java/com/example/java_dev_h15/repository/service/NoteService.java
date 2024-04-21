package com.example.java_dev_h15.repository.service;


import com.example.java_dev_h15.repository.entity.Note;
import com.example.java_dev_h15.repository.database.FakeDB;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService implements NoteCrudService{
    private static final Logger LOGGER = LoggerFactory.getLogger(NoteService.class);
    private final FakeDB fakeDB = FakeDB.getInstance();

    @Override
    public void add(Note note) {
        Long id = fakeDB.generateId();
        note.setId(id);
        List<Note> notes = fakeDB.getNotes();
        if (!notes.contains(note)){
            notes.add(note);
            LOGGER.info("Added new note to todo list. Note: {}", note);
        } else {
            LOGGER.info("Note wasn't added. Please check if you have already added this note to your todo list. Note: {}", note);
        }
    }

    @Override
    public Note getById(Long noteId) {
        for (Note note: fakeDB.getNotes()){
            if (note.getId().equals(noteId)){
                LOGGER.info("Note retrieved from DB. Note: {}", note);
                return note;
            }
        }
        throw new IllegalArgumentException("Invalid id. Please enter existing id");
    }

    @Override
    public List<Note> listAll() {
        List<Note> notes = fakeDB.getNotes();

        LOGGER.info("Todo list retrieved from DB");
        return notes;
    }

    @Override
    public void update(Note note) {
        Long noteId = note.getId();
        Note noteInDB = getById(noteId);

        noteInDB.setTitle(note.getTitle());
        noteInDB.setContent(note.getContent());

        LOGGER.info("Note with id {} updated", noteId);
    }

    @Override
    public void deleteById(Long noteId) {
        Note note = getById(noteId);
        List<Note> notes = fakeDB.getNotes();

        notes.remove(note);

        LOGGER.info("Note with id {} removed", noteId);
    }
}