package sda.pl.com.message;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import sda.pl.com.chat.AbstractRemoteService;

import java.net.URI;
import java.util.List;


/**
 * Created by RENT on 2016-12-19.
 */
@Service
public class RemoteMessageService extends AbstractRemoteService {
    private static final String USER_RESOURCE_URL = "/api/message";
    private RestTemplate restTemplate = new RestTemplate();

    public Message setMessage(Message messages){
        HttpHeaders headers = getDefaultHeaders();
        URI url = prepareUrl(USER_RESOURCE_URL);
        RequestEntity<Message> requestEntity = new RequestEntity<Message>(messages,headers, HttpMethod.POST,url);
        Message response=
                restTemplate.postForObject(url,requestEntity,Message.class);
        return response;
    }

    public List<Message> getAllMessagesRemote(){
        HttpHeaders headers = getDefaultHeaders();
        URI url = prepareUrl(USER_RESOURCE_URL);
        RequestEntity<Void> requestEntity = new RequestEntity<>(headers, HttpMethod.GET,url);
        ResponseEntity<List<Message>> response=
                restTemplate.exchange(requestEntity, new ParameterizedTypeReference<List<Message>>() {
                });
        return response.getBody();
    }
}
