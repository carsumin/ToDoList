package com.todo.service.impl;

import com.todo.service.ToDoDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ToDoMapper {

    public List<ToDoDTO> selectToDoList();
    public int insertToDoList(ToDoDTO params);
    public int updateToDoList(ToDoDTO params);
    public int deleteToDoList(Long idx);

}
