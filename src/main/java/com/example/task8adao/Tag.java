package com.example.task8adao;

/**
 * Класс "Тег", представляет категорию товара.
 * Каждый тег имеет уникальный идентификатор и название.
 */
public class Tag {
    // Уникальный идентификатор тега
    private int id;

    // Название тега (категории)
    private String name;

    /**
     * Конструктор для создания нового тега.
     *
     * @param id   - уникальный идентификатор тега
     * @param name - название тега
     */
    public Tag(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}