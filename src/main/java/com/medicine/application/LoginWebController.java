package com.medicine.application;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


import java.util.Map;


@Controller
public class LoginWebController implements WebMvcConfigurer {
    @Autowired // This means to get the bean called userRepository
//    // Which is auto-generated by Spring, we will use it to handle the data
    private UserService userService;
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/result").setViewName("result");
    }

    @GetMapping("/")
    public String frontPage(){
        return "redirect:/login";
    }
    @GetMapping("/login")
    public String loginPage(@ModelAttribute("LoginPersonData") LoginPersonData personForm,
                            @ModelAttribute("errorMessage") errorMessage message)
    {

        return "login";
    }

    @PostMapping("/login")
    public String checkLoginPersonInfo(HttpServletRequest request, HttpServletResponse response,
                                       @Valid @ModelAttribute("LoginPersonData") LoginPersonData personForm,
                                       BindingResult bindingResult, @ModelAttribute("errorMessage") errorMessage message) {
        if (bindingResult.hasErrors()) {
            return "login";
        }
        if(!userService.existsByUserEmail(personForm.getEmail())||!userService.isLoginEmailMatchPassword(personForm.getEmail(), personForm.getPassword())) {
            message.setErrorMessage("账号不存在或者密码错误");
            return "login";
        }
        // 登录成功，调用处理成功的逻辑
        User loggedInUser = userService.getUserByEmail(personForm.getEmail());
        loginSuccess(request, response, loggedInUser);
        return "redirect:/result";
    }
    public void loginSuccess(HttpServletRequest request, HttpServletResponse response, User user) {
        // 获取或创建会话
        HttpSession session = request.getSession(true);

        // 将用户信息存储在会话中
        session.setAttribute("user", user);

        // 可以设置会话的过期时间，例如：
        // session.setMaxInactiveInterval(30 * 60); // 30分钟的会话过期时间
    }
}