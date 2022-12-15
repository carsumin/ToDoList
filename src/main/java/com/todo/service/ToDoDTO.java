package com.todo.service;

import org.apache.ibatis.type.Alias;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Alias("ToDoDTO")
public class ToDoDTO {
        private Long idx;
        private String item;
        private String status;
}
