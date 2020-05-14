package deviceai.sarafan.controller;

import deviceai.sarafan.exceptions.NotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("message")
public class MessageController {

    //Creating some list of messages
    private List<Map<String,String>> messages = new ArrayList<Map<String, String>>(){{
        add(new HashMap<String, String>() {{ put("id", "1"); put("text", "first message");}});
        add(new HashMap<String, String>() {{ put("id", "2"); put("text", "second message");}});
        add(new HashMap<String, String>() {{ put("id", "3"); put("text", "third message");}});
    }};

    //Counter for message id
    private int counter = 4;

    //GET ALL MESSAGES
    @GetMapping
    public List<Map<String, String>> list() {
        return messages;
    }
    //GET MESSAGE BY ID
    @GetMapping("{id}")
    public Map<String, String> getOne (@PathVariable String id){
        return messages.stream()
                .filter(message -> message.get("id").equals(id))
                .findFirst()
                .orElseThrow(NotFoundException::new);
    }
    //CREATING MESSAGE
    @PostMapping
    public Map<String, String> create (@RequestBody Map<String, String> message){
        message.put("id", String.valueOf(counter++));
        messages.add(message);

        return message;
    }
    //UPDATING MESSAGE
    //@PutMapping({"id"}) - annotation not work
    @RequestMapping(value="{id}", method=RequestMethod.PUT)
    public Map<String, String> update (
            @PathVariable String id,
            @RequestBody Map<String, String> message
            ){

        Map<String, String> messageFromList = getMessage(id);
        messageFromList.putAll(message);
        messageFromList.put("id", id);

        return message;
    }
    //DELETING MESSAGES
    //@DeleteMapping({"id"}) - annotation not work
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete (@PathVariable String id){

        Map<String, String> messageFromList = messages.stream()
                .filter(message -> message.get("id").equals(id))
                .findFirst()
                .orElseThrow(NotFoundException::new);

        messages.remove(messageFromList);
    }

    //FUNCTION return message by id
    private Map<String, String> getMessage (@PathVariable String id){
        return messages.stream()
                .filter(message -> message.get("id").equals(id))
                .findFirst()
                .orElseThrow(NotFoundException::new);
    }
}

// Browser console commands:
// fetch('/message', { method: 'POST', headers: {'Content-Type': 'application/json'}, body: JSON.stringify({ text: 'second message' })}).then(result => console.log(result))
