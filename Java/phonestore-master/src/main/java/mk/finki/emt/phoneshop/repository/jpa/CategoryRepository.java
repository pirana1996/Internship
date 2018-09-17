package mk.finki.emt.phoneshop.repository.jpa;

import mk.finki.emt.phoneshop.model.Category;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@Profile("jpa")
public interface CategoryRepository extends JpaRepository<Category,Long> {
    List<Category> findByName(String name);

}
