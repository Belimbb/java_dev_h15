package com.example.java_dev_h15.controller.control.test;

import com.example.java_dev_h15.controller.control.NoteRestController;
import com.example.java_dev_h15.controller.entity.NoteDTO;
import com.example.java_dev_h15.repository.service.NoteService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestNoteRestController implements NoteRestController {
    private final NoteService noteService;

    @PostMapping
    @Override
    public ModelAndView createNote(@RequestParam(name = "title") String title, @RequestParam(name = "content") String content) {

        return null;
    }

    @GetMapping()
    @Override
    public ModelAndView getNote(Long id) {
        ModelAndView result = new ModelAndView("test.html");
        return result;
    }

    @Override
    public ModelAndView listAll() {
        return null;
    }

    @PutMapping()
    @Override
    public ModelAndView updateNote(@RequestParam(name = "id") Long id,
                                   @RequestParam(name = "title") String title,
                                   @RequestParam(name = "content") String content) {
        return null;
    }

    @DeleteMapping()
    @Override
    public ModelAndView deleteNote(Long id) {
        return null;
    }
}