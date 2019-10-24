package hello.login;

import hello.register.UserRegister;
import hello.register.UserRegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Iterator;
@Controller
public class userLoginController {
    @Autowired
    private UserRegisterRepository userRegisterRepository;

    @GetMapping("/hello/login")
    public String Login(Model model){
        UserLogin user = new UserLogin();
        model.addAttribute("user",user);
        return "login/loginPage.html";
    }

    @PostMapping("/hello/login")
    public String Login(@ModelAttribute("user") UserLogin userLogin) {
        Iterator<UserRegister> iteratorUserRegister = userRegisterRepository.findAll().iterator();
        while (iteratorUserRegister.hasNext()) {
            UserRegister userRegister = iteratorUserRegister.next();
            if (userRegister.getUserName().equals(userLogin.getUserName())){
                if(userRegister.getPassword().equals(userLogin.getPassword())){
                    return "login/loginSuccessful";
                }
                return "login/passwordWrong";
            }
        }
        return "login/userNameDoesNotExist";
    }

}
