package com.todo.controller;

import com.todo.service.ToDoDTO;
import com.todo.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ToDoController {

    @Autowired
    private ToDoService toDoService;

    /* 메인페이지로 맵핑 */
    @GetMapping(value = "/")
    public String todoList(Model model){
        List<ToDoDTO> toDoList = toDoService.getToDoList();
        model.addAttribute("toDoList", toDoList); //보냄
        model.addAttribute("todo", new ToDoDTO()); //객체받음

        return "index";
    }

    /* 할 일 등록 */
    @PostMapping(value = "todo/register.do")
    public String insertToDoList(Model model, ToDoDTO params){
        toDoService.insertToDoList(params);

        return "redirect:/";
    }

    /* 수정된 할 일 업데이트 */
    @PostMapping(value = "/todo/update.do")
    public String updateToDoList(@RequestParam(value="idx", required = false) Long idx, ToDoDTO params){
        System.out.print("check");
        System.out.println(idx);
        toDoService.updateToDoList(params);

        return "redirect:/";
    }

    /* 고유번호로 할 일 삭제 */
    @PostMapping(value = "/todo.delete.do")
    public String deleteToDoList(@RequestParam(value = "idx", required = false)Long idx){
        System.out.println("삭제" + idx);
        toDoService.deleteToDoList(idx);

        return "redirect:/";
    }

}
