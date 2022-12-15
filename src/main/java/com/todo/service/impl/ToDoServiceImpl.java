package com.todo.service.impl;

import com.todo.service.ToDoDTO;
import com.todo.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoServiceImpl implements ToDoService {

    int queryResult = 0;
    @Autowired
    private ToDoMapper toDoMapper;

    /* 리스트 가져오기 */
    @Override
    public List<ToDoDTO> getToDoList(){
        List<ToDoDTO> todoList = toDoMapper.selectToDoList();

        return todoList;
    }

    /* 리스트 추가하기 */
    @Override
    public boolean insertToDoList(ToDoDTO params) {
        if(params != null)
            queryResult = toDoMapper.insertToDoList(params);

        return (queryResult == 1) ? true : false;
    }

    /* 리스트 상태(할일 수행 여부) 업데이트 */
    @Override
    public boolean updateToDoList(ToDoDTO params) {
        if (params != null)
            queryResult = toDoMapper.updateToDoList(params);

        return (queryResult == 1) ? true : false;
    }

    /* 리스트 삭제하기 */
    @Override
    public boolean deleteToDoList(Long idx) {
        if (idx != null)
            queryResult = toDoMapper.deleteToDoList(idx);

        return (queryResult == 1) ? true : false;
    }
}
