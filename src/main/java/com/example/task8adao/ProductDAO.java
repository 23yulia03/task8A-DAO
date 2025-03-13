package com.example.task8adao;

import javafx.collections.ObservableList;

/**
 * Интерфейс "ProductDAO" определяет методы для работы с товарами и категориями.
 * Обеспечивает абстракцию для хранения и управления списком продуктов.
 */
public interface ProductDAO {
    // Получить список всех продуктов.
    ObservableList<Product> getProducts();

    //Получить список всех тегов (категорий).
    ObservableList<Tag> getTags();

    void addProduct(int id, String name, int count, Tag tag);

    void updateProduct(Product product, String newName, int newCount, Tag newTag);

    void deleteProduct(Product product);

    void addTag(int id, String name);
}
