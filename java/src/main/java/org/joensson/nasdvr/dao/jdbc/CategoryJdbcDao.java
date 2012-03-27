package org.joensson.nasdvr.dao.jdbc;

import org.joensson.nasdvr.dao.CategoryRepository;
import org.joensson.nasdvr.model.Category;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoryJdbcDao extends AbstractRowMappingJdbcRepository<Category> implements CategoryRepository {

    public List<Category> fetchAll() {
        List<Category> results = jdbcTemplate.query("SELECT * FROM category", rowMapper);
        return results;
    }

    public Category find(int id) {
        List<Category> results = jdbcTemplate.query("SELECT * FROM category WHERE id=?", rowMapper, id);
        return results.get(0);
    }

    public List<Category> find(String category) {
        List<Category> results = jdbcTemplate.query("SELECT * FROM category WHERE name=?", rowMapper, category);
        return results;
    }

    public void save(Category category) {
        if (category.getId() == 0) {
            jdbcTemplate.update("INSERT INTO category (name) VALUES(?)", category.getName());
        } else {
            jdbcTemplate.update("UPDATE category SET name = ? WHERE id = ?", category.getName(), category.getId());
        }

    }
}
