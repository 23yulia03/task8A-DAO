package com.example.task8adao;

/**
 * Класс "Продукт", содержит информацию о товаре.
 */
public class Product {
    private int id;
    private String name;
    private int count;
    private Tag tag;

    public Product(int id, String name, int count, Tag tag) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.tag = tag;
    }

    public int getId() {
        return id;
    }

    // Добавляем метод setId
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    public Tag getTag() {
        return tag;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    @Override
    public String toString() {
        return name + " (" + count + " шт, " + tag.getName() + ")";
    }
}