package sda.pl.com.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by RENT on 2016-12-19.
 */
@Service
public class UserService {
    @Value("${auth.username}")
    private String authenticatedUsername;

    @Autowired
    private UserRemoteService userRemoteService;

    public String getAuthenticatedUsername(){
        return authenticatedUsername;
    }

    public List<String> getAll(){
        return userRemoteService.getAllUsernames();
    }
}
