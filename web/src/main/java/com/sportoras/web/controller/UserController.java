package com.sportoras.web.controller;

import com.sportoras.database.entity.User;
import com.sportoras.service.dto.userDto.UserBasicDto;
import com.sportoras.service.dto.userDto.UserCreateDto;
import com.sportoras.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/users")
    public String getAllUsers(Model model) {
        List<UserBasicDto> users = userService.allUsers();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/user-info")
    public String productInfo(Model model, Long id) {
        User user = userService.findUserById(id);
        model.addAttribute("user", user);
        return "/user-info";
    }

    @GetMapping("/user-save")
    public String openUserSave(Model model) {
        model.addAttribute("userCreateDto", new UserCreateDto());
        return "/user-save";
    }

    @PostMapping("/user-save")
    public String saveNewProduct(UserCreateDto userCreateDto) {
        userService.saveUser(userCreateDto);
        return "redirect:/users";
    }
}
