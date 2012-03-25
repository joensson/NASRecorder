package org.joensson.nasdvr.dao;

import org.joensson.nasdvr.model.Category;

import java.util.List;

/**
 * User: frj
 * Date: 3/25/12
 * Time: 9:15 PM
 *
 * @Author frj
 */
public interface CategoryRepository extends NasDvrRepository<Category> {

    public List<Category> find(String category);

}
