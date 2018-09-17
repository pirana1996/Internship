package mk.finki.emt.phoneshop.repository.mock.impl;

import mk.finki.emt.phoneshop.model.Category;
import mk.finki.emt.phoneshop.repository.mock.CategoryRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.*;

@Profile("mock")
@Component
public class MockCategoryImplementation implements CategoryRepository {

    private static Map<Long,Category> categoryMap = new HashMap<>();
    private static Long idSequencer = 0l;

    @Override
    public Collection<Category> findAll() {
        return categoryMap.values();
    }

    @Override
    public Optional<Category> findById(Long id) {
        return Optional.ofNullable(categoryMap.get(id));
    }

    @Override
    public Category save(Category category) {
        if (category.getId()==null) {
                category.setId(getNextIdValue());
        }
        categoryMap.put(category.getId(),category);
        return category;
    }

    private synchronized Long getNextIdValue() {
        return ++idSequencer;
    }
}
