package com.framgia.fitm;

import java.util.List;

import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.framgia.fitm.model.User;
import com.framgia.fitm.service.UserService;
import com.framgia.fitm.util.Constants;

@Controller
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String init(Model model) {
	logger.info("home page");
	List<User> userList = userService.getUserList();
	if (userList.isEmpty()) {
	    model.addAttribute("css", "danger");
	    model.addAttribute("msg", "Users not found");
	}
	model.addAttribute("user", new User());
	model.addAttribute("users", userList);
	return "home";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String showUser(@PathVariable("id") int id, Model model) {
	logger.info("detail user");
	User user = userService.showUser(id);
	if (user == null) {
	    model.addAttribute("css", "danger");
	    model.addAttribute("msg", "User not found");
	}
	model.addAttribute("user", user);
	return "/user";
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable("id") int id, final RedirectAttributes redirectAttributes) {
	logger.info("delete user");
	if (userService.deleteUser(id)) {
	    redirectAttributes.addFlashAttribute("css", "success");
	    redirectAttributes.addFlashAttribute("msg", "user is deleted!");
	} else {
	    redirectAttributes.addFlashAttribute("css", "error");
	    redirectAttributes.addFlashAttribute("msg", "Delete user fails!!!!");
	}
	return "redirect:/";
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
    public String showUpdateUserForm(@PathVariable("id") int id, Model model) {
	User user = userService.showUser(id);
	model.addAttribute("userForm", user);
	model.addAttribute("status", Constants.EDIT);
	return "userform";
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String saveOrUpdateUser(@ModelAttribute("userForm") @Valid User userForm, BindingResult result, Model model,
	    final RedirectAttributes redirectAttributes) {

	logger.info("create or update");
	if (result.hasErrors()) {
	    if (userForm.getUser_id() == null)
		model.addAttribute("status", Constants.ADD);
	    else
		model.addAttribute("status", Constants.EDIT);
	    return "userform";
	} else {

	    if (userForm.getUser_id() == null) {
		// new
		redirectAttributes.addFlashAttribute("msg", "User added successfully!");
	    } else {
		// update
		redirectAttributes.addFlashAttribute("msg", "User updated successfully!");
	    }
	    userService.saveOrupdateUser(userForm);
	    return "redirect:/";
	}
    }

    @RequestMapping(value = "/user/add", method = RequestMethod.GET)
    public String showAddUserForm(Model model) {
	logger.info("showAddUserForm()");
	model.addAttribute("userForm", new User());
	model.addAttribute("status", Constants.ADD);
	return "userform";
    }
}
