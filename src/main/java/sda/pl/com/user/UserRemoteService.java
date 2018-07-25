package sda.pl.com.user;

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
public class UserRemoteService extends AbstractRemoteService{
    private static final String USER_RESOURCE_URL = "/api/user";
    private RestTemplate restTemplate = new RestTemplate();

    public List<String> getAllUsernames(){
        HttpHeaders headers = getDefaultHeaders();
        URI url = prepareUrl(USER_RESOURCE_URL);
        RequestEntity<Void> requestEntity = new RequestEntity<>(headers, HttpMethod.GET,url);
        ResponseEntity<List<String>> response=
                restTemplate.exchange(requestEntity, new ParameterizedTypeReference<List<String>>() {
        });
        return response.getBody();
    }
}
