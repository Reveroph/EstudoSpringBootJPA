package com.estudo.service;

import com.estudo.domain.Todo;
import com.estudo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class TodoService {

    @Autowired
    private TodoRepository repository;

    public String saveTodo(Todo todo) {

        if(Objects.nonNull(todo)) {
            return "OK";
        }

        return String.format("O objeto de entrada veio inválido: {%s}", todo);
    }
}
