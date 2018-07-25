package sda.pl.com.message;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by RENT on 2016-12-17.
 */
@Repository
public class MessageDao {

    @PersistenceContext
    EntityManager em;

    public void create(Message message){
        em.persist(message);
    }
    @SuppressWarnings(value = "unchecked")
    public List<Message> getAllMessages(){
        return em.createNativeQuery("SELECT * FROM message",Message.class)
                .getResultList();
    }
}
