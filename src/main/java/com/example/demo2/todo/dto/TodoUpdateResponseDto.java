package com.example.demo2.todo.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

@Getter
public class TodoUpdateResponseDto {

    private final Long id;
    private final String content;

    public TodoUpdateResponseDto(Long id, String content) {
        this.id = id;
        this.content = content;
    }
}
