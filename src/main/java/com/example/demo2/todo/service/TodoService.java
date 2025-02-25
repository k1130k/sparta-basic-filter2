package com.example.demo2.todo.service;

import com.example.demo2.todo.dto.*;
import com.example.demo2.todo.entity.Todo;
import com.example.demo2.todo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    @Transactional
    public TodoSaveResponseDto save(TodoSaveRequestDto dto) {
        Todo todo = new Todo(dto.getContent());
        Todo savedTodo = todoRepository.save(todo);
        return new TodoSaveResponseDto(
                savedTodo.getId(),
                savedTodo.getContent()
        );
    }

    @Transactional(readOnly = true)
    public List<TodoResponseDto> findAll() {
        List<Todo> todos = todoRepository.findAll();
        List<TodoResponseDto> dtos = new ArrayList<>();
        for (Todo todo : todos) {
            dtos.add(new TodoResponseDto(
                    todo.getId(),
                    todo.getContent()
            ));
        }
        return dtos;
    }

    @Transactional(readOnly = true)
    public TodoResponseDto findById(Long todoId) {
        Todo todo = todoRepository.findById(todoId).orElseThrow(
                () -> new IllegalArgumentException("그런 Todo 없습니다")
        );
        return new TodoResponseDto(
                todo.getId(),
                todo.getContent()
        );
    }

    @Transactional
    public TodoUpdateResponseDto update(TodoUpdateRequestDto dto, Long todoId) {
        Todo todo = todoRepository.findById(todoId).orElseThrow(
                () -> new IllegalArgumentException("그런 Todo 없습니다")
        );
        todo.update(dto.getContent());
        return new TodoUpdateResponseDto(
                todo.getId(),
                todo.getContent()
        );
    }

    public void deleteById(Long todoId) {
        if (!todoRepository.existsById(todoId)) {
            throw new IllegalArgumentException("존재하지 않은 Todo 입니다.")
        }
        todoRepository.deleteById(todoId);
    }
}
