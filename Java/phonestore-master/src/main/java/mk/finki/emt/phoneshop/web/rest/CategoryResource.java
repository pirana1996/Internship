package mk.finki.emt.phoneshop.web.rest;

import mk.finki.emt.phoneshop.exceptions.EntityNotFoundException;
import mk.finki.emt.phoneshop.model.Category;
import mk.finki.emt.phoneshop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rest/category")
public class CategoryResource {

  @Autowired
  private CategoryService categoryService;

  @RequestMapping(value = "/list",
    method = RequestMethod.GET,
    produces = MediaType.APPLICATION_JSON_VALUE)
  public List<Category> getAllCategories() {
    return new ArrayList(categoryService.findAll());
  }

  @RequestMapping(value = {"/save", "/"},
    method = RequestMethod.POST, produces = "application/json")
  public Category save(@RequestBody @Valid Category category) {
    categoryService.save(category);
    return category;
  }

  @GetMapping(value = "/{id}[\\d+]",
    produces = "application/json")
  public Category findById(@PathVariable(name = "id") Long id) {
    Optional<Category> optCategory = categoryService.findById(id);

    return optCategory
      .orElseThrow(() -> new EntityNotFoundException("No category with id: " + id));
  }


  @GetMapping(value = "/byId",
    produces = "application/json")
  public Category findByIdFromRequest(@RequestParam Long id) {
    Optional<Category> optCategory = categoryService.findById(id);

    return optCategory
      .orElseThrow(() -> new EntityNotFoundException("No category with id: " + id));
  }


}
