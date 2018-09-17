package mk.finki.emt.phoneshop.web.controllers;

import mk.finki.emt.phoneshop.config.Layout;
import mk.finki.emt.phoneshop.model.Category;
import mk.finki.emt.phoneshop.model.Device;
import mk.finki.emt.phoneshop.model.User;
import mk.finki.emt.phoneshop.model.UserRole;
import mk.finki.emt.phoneshop.service.CategoryService;
import mk.finki.emt.phoneshop.service.DeviceService;
import mk.finki.emt.phoneshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class LandingController {

  @Autowired
  private CategoryService categoryService;

  @Autowired
  private DeviceService deviceService;

  @Autowired
  private UserService userService;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Layout("layout/master")
  @GetMapping("/")
  public String index(Model model, @RequestParam(required = false, defaultValue = "World") String helloTo) {
    List<Category> categoryList = new ArrayList<>(categoryService.findAll());
    List<Device> devices = new ArrayList<>(deviceService.findAll());
    model.addAttribute("categories", categoryList);
    model.addAttribute("helloTo", helloTo);
    model.addAttribute("devices",devices);
    return "index";
  }


  @GetMapping("/category/{id}")
  public String categoryItems(Model model, @PathVariable Long id) {
    Optional<Category> optCategory = categoryService.findById(id);

    Category noCategory = new Category();
    noCategory.setName("No category with id: " + id);

    model.addAttribute("category", optCategory.orElse(noCategory));
    return "category";
  }

  @Layout("layout/master")
  @GetMapping("/device/{id}")
  public String deviceView(Model model, @PathVariable Long id) {
    Device device = deviceService.findOne(id);
    model.addAttribute("device",device);
    return "device";
  }

  @Layout("layout/master")
  @GetMapping("/login")
  public String login(Model model) {
    return "login";
  }

  @Layout("layout/master")
  @GetMapping("/register")
  public String register(Model model) {
    return "register";
  }

  @Layout("layout/master")
  @PostMapping("/register")
  public String registerPost(@ModelAttribute User user, Model model) {
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    userService.save(user);
    return "index";
  }

  @RequestMapping("/logout")
  public String logout(HttpServletRequest request, HttpServletResponse response) {
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    if (auth != null){
      new SecurityContextLogoutHandler().logout(request, response, auth);
    }
    return "redirect:/";
  }

}
