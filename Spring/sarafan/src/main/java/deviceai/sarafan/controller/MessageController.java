package deviceai.sarafan.controller;

import deviceai.sarafan.domain.Message;
import deviceai.sarafan.repo.MessageRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("message")
public class MessageController {

    private final MessageRepo messageRepo;
    @Autowired
    public MessageController(MessageRepo messageRepo) {
        this.messageRepo = messageRepo;
    }

    //Counter for message id
    private int counter = 4;

    //GET ALL MESSAGES
    @GetMapping
    public List<Message> list() {
        return messageRepo.findAll();
    }
    //GET MESSAGE BY ID
    @GetMapping("{id}")
    public Message getOne (@PathVariable("id") Message message){
        return message;
    }
    //CREATING MESSAGE
    @PostMapping
    public Message create (@RequestBody Message message){
        return messageRepo.save(message);
    }
    //UPDATING MESSAGE
    //@PutMapping({"id"}) - annotation not work
    @RequestMapping(value="{id}", method=RequestMethod.PUT)
    public Message update (
            @PathVariable("id") Message messageFromDb,
            @RequestBody Message message
            ){

        BeanUtils.copyProperties(message, messageFromDb, "id");

        return messageRepo.save(messageFromDb);
    }
    //DELETING MESSAGES
    //@DeleteMapping({"id"}) - annotation not work
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete (@PathVariable("id") Message message){
        messageRepo.delete(message);

    }

}

// Browser console commands:
// fetch('/message', { method: 'POST', headers: {'Content-Type': 'application/json'}, body: JSON.stringify({ text: 'second message' })}).then(result => console.log(result))
