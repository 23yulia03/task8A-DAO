package com.example.task8adao;

import javafx.collections.ObservableList;

public interface ProductDAO {
    ObservableList<Product> getProducts();
    ObservableList<Tag> getTags();
    void addProduct(int id, String name, int count, Tag tag);
    void updateProduct(Product product, String newName, int newCount, Tag newTag);
    void deleteProduct(Product product);
    void addTag(int id, String name);
}
