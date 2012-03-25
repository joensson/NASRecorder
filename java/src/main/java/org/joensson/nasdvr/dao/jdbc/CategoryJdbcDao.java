package org.joensson.nasdvr.dao.jdbc;

import org.joensson.nasdvr.dao.CategoryRepository;
import org.joensson.nasdvr.model.Category;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * User: frj
 * Date: 3/25/12
 * Time: 9:18 PM
 *
 * @Author frj
 */
@Component
public class CategoryJdbcDao extends AbstractJdbcRepository<Category> implements CategoryRepository {

    public Category find(int id) {
        List<Category> results = jdbcTemplate.query("SELECT * FROM category WHERE id=?", rowMapper, id);
        return results.get(0);
    }

    public List<Category> find(String category) {
        List<Category> results = jdbcTemplate.query("SELECT * FROM category WHERE name=?", rowMapper, category);
        return results;
    }

    public void save(Category category) {
        if (category.getEntityId() == 0) {
            jdbcTemplate.update("INSERT INTO category (name) VALUES(?)", category.getName());
        } else {
            jdbcTemplate.update("UPDATE category SET name = ? WHERE id = ?", category.getName(), category.getEntityId());
        }

    }
}
