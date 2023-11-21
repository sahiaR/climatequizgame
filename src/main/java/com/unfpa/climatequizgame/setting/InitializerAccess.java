package com.unfpa.climatequizgame.setting;

import com.unfpa.climatequizgame.model.Role;
import com.unfpa.climatequizgame.model.User;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import com.unfpa.climatequizgame.service.UserService;

import java.util.Optional;

@Component
public class InitializerAccess {
    
    private final UserService userService;

    public InitializerAccess(UserService userService) {
        this.userService = userService;
    }

    @PostConstruct
    private void postConstruct() {
        createuser();
    }


    private void createuser()
    {
        Optional<User> admin = userService.getUserByLoginName("admin");
        try
        {
            if(admin.isEmpty())
            {
                // admin
                User admin1 = new User();
                admin1.setId(1);
                admin1.setLoginName("admin");
                admin1.setPassword("1234");
                admin1.setRole(Role.ADMIN);
                userService.saveUser(admin1);
                // user 1
                User user1 = new User();
                user1.setId(1);
                user1.setLoginName("user1");
                user1.setPassword("1234");
                user1.setRole(Role.USER);
                userService.saveUser(user1);
                // user 2
                User user2 = new User();
                user2.setId(1);
                user2.setLoginName("user2");
                user2.setPassword("1234");
                user2.setRole(Role.USER);
                userService.saveUser(user2);
            }
            
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("Errors occurred during initialization. System verification is required.");
        }
    }


}
