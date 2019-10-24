package hello.register;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Controller
public class UserRegisterController {
    @Autowired
    private UserRegisterRepository userRegisterRepository;

    private List<UserRegister> init(){
        Iterator<UserRegister> iteratorUserRegister = userRegisterRepository.findAll().iterator();
        List<UserRegister> listUserRegister = new ArrayList<UserRegister>();
        int i = 0;
        while (iteratorUserRegister.hasNext()){
            UserRegister user = iteratorUserRegister.next();
            listUserRegister.add(user);
        }
        return  listUserRegister;
    }

    private boolean checkExistUser (UserRegister user){
        Iterator<UserRegister> iteratorUserRegister = userRegisterRepository.findAll().iterator();
        while (iteratorUserRegister.hasNext()){
            UserRegister userCur = iteratorUserRegister.next();
            if(userCur.getUserName().equals(user.getUserName())){
                return false;
            }
        }
        return true;
    }

    @GetMapping("/hello/register")
    public String register(Model model){
        UserRegister user = new UserRegister();
        model.addAttribute("user",user);

        String checkPassword = new String();
        model.addAttribute("checkPassword",checkPassword);
        return "register/userRegister";
    }

    @PostMapping("/hello/register")
    public String register(@ModelAttribute("userRegister") UserRegister userRegister, @ModelAttribute("checkPassword") String checkPassword){
        if(!checkPassword.equals(userRegister.getPassword()) ){

            return "register/registerPasswordFail";
        }
        if(!checkExistUser(userRegister)){
            return "register/registerUserExist";
        }
        userRegisterRepository.save(userRegister);
        return "register/registerSuccessful";
    }



}
