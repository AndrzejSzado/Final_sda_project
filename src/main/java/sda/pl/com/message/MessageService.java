package sda.pl.com.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by RENT on 2016-12-17.
 */
@Service
@Transactional
public class MessageService {

    @Autowired
    private  MessageDao messageDao;


    private RemoteMessageService remoteMessageService;

    public void create(Message message){
        messageDao.create(message);
    }

    public List<Message> getAllMessages(){
        return messageDao.getAllMessages();
    }
}
