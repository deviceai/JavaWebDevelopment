package com.example.sweater.controllers;

import com.example.sweater.domain.Message;
import com.example.sweater.repo.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class MainController {

    @Autowired
    private MessageRepo messageRepo;

    @GetMapping("/")
    public String home(Map<String, Object> model) {
        Iterable<Message> messages = messageRepo.findAll();

        model.put("messages", messages);
        return "home";
    }

    @PostMapping("add")
    public String addMessage(
            @RequestParam String text,
            @RequestParam String tag,
            Map<String, Object> model
    ){
        //Create new message
        Message message = new Message(text, tag);
        messageRepo.save(message);

        //Get all messages
        Iterable<Message> messages = messageRepo.findAll();
        model.put("message", messages);

        return "redirect:/";
    }

    @PostMapping("filter")
    public String filterMessages(
            @RequestParam String filter,
            Map<String, Object> model
    ){
        Iterable<Message> messages;
        if(filter!=null && !filter.isEmpty()){
            messages = messageRepo.findByTag(filter);
        }
        else {
            messages = messageRepo.findAll();
        }
        model.put("messages", messages);
        return "home";
    }

}
