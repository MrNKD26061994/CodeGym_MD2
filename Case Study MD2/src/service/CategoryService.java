package service;

import database.CategoryDB;
import model.Category;

import java.util.List;

public class CategoryService{
    private static CategoryService categoryService;
    private final CategoryDB categoryDB;
    private final List<Category> categories;
    public CategoryService() {
        categoryDB = new CategoryDB();
        categories = categoryDB.findAll("Categories.txt");
    }
    public static CategoryService categoryServiceInstance() {
        if(categoryService == null) {
            categoryService = new CategoryService();
        }
        return categoryService;
    }

    public void create(Category category) {
        category.setId(createNewId());
        categoryDB.writeFile("Categories.txt", category);
        categories.add(category);
    }

    public void update(Category category) {
        for (int i = 0; i < categories.size() - 1; i++) {
            if(categories.get(i).getId() == category.getId()) {
                categories.set(i, category);
                break;
            }
        }
        categoryDB.writeFile("Categories.txt", categories);
    }
    private int createNewId() {
        if(categories.isEmpty()){
            return 1;
        } else {
            return categories.stream().max((o1, o2) -> o1.getId() - o2.getId()).get().getId() + 1;
        }
    }

    public boolean existsById(int id) {
        for(Category item : categories) {
            if(item.getId() == id) return true;
        }
        return false;
    }

    public Category getCategoryById(int id) {
        for (Category item : categories){
            if(item.getId() == id) {
                return item;
            }
        }
        return null;
    }


    public List<Category> getCategories() {
        return categories;
    }
}
