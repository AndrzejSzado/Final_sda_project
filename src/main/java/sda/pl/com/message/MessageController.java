package sda.pl.com.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.Date;
import java.util.List;

/**
 * Created by RENT on 2016-12-17.
 */
@RestController
@RequestMapping("/api/message")
public class MessageController {
    @Autowired
    private RemoteMessageService remoteMessageService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Message> getMessage(){
        List<Message> messageList= remoteMessageService.getAllMessagesRemote();
        messageList.forEach(message -> messageService.create(message));
        return messageService.getAllMessages();
    }



    @RequestMapping(method = RequestMethod.POST)
    public Message createMessageToUser(@RequestBody Message message){
        message.setCreated(new Date());
        Message messageRequest= remoteMessageService.setMessage(message);
        messageService.create(messageRequest);
        System.out.println(messageRequest);
        System.out.println(message);
        return message;

    }

    @Autowired
    private MessageService messageService;
    @RequestMapping(method = RequestMethod.GET,
            value = "/{senderId}/{reciverId}/{body}")
    public Message createMessage(@PathVariable String senderId, @PathVariable String reciverId, @PathVariable String body){
        Message message = new Message();
        message.setBody(body);
        message.setReceiverId(reciverId);
        message.setSenderId(senderId);
        message.setCreated(new Date());

        messageService.create(message);

        return message;
    }
}
