package com.example.task8adao;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * Класс "HelloController" управляет взаимодействием между UI и данными.
 * Обрабатывает ввод, обновление и удаление товаров.
 */
public class HelloController {

    @FXML private TableView<Product> table;
    @FXML private TableColumn<Product, String> colName;
    @FXML private TableColumn<Product, Integer> colCount;
    @FXML private TableColumn<Product, String> colTag;
    @FXML private TextField nameField;
    @FXML private TextField countField;
    @FXML private ComboBox<Tag> tagComboBox;

    private ProductDAO productDAO = new ListProductDAO(); // Используем интерфейс

    @FXML
    public void initialize() {
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colCount.setCellValueFactory(new PropertyValueFactory<>("count"));
        colTag.setCellValueFactory(cellData ->
                new javafx.beans.property.SimpleStringProperty(cellData.getValue().getTag().getName()));

        table.setItems(productDAO.getProducts());
        tagComboBox.setItems(productDAO.getTags());

        // Добавляем теги
        productDAO.addTag(1, "Электроника");
        productDAO.addTag(2, "Одежда");
        productDAO.addTag(3, "Мебель");
        productDAO.addTag(4, "Книги");
        productDAO.addTag(5, "Спорт");

        // Добавляем продукты
        productDAO.addProduct(1, "Ноутбук", 5, productDAO.getTags().get(0)); // Электроника
        productDAO.addProduct(2, "Футболка", 10, productDAO.getTags().get(1)); // Одежда
        productDAO.addProduct(3, "Смартфон", 8, productDAO.getTags().get(0)); // Электроника
        productDAO.addProduct(4, "Джинсы", 15, productDAO.getTags().get(1)); // Одежда
        productDAO.addProduct(5, "Диван", 3, productDAO.getTags().get(2)); // Мебель
        productDAO.addProduct(6, "Кресло", 7, productDAO.getTags().get(2)); // Мебель
        productDAO.addProduct(7, "Война и мир", 20, productDAO.getTags().get(3)); // Книги
        productDAO.addProduct(8, "1984", 12, productDAO.getTags().get(3)); // Книги
        productDAO.addProduct(9, "Мяч футбольный", 25, productDAO.getTags().get(4)); // Спорт
        productDAO.addProduct(10, "Гантели", 30, productDAO.getTags().get(4)); // Спорт
    }

    @FXML
    private void addProduct() {
        String name = nameField.getText();
        String countText = countField.getText();
        Tag tag = tagComboBox.getValue();

        if (name.isEmpty() || countText.isEmpty() || tag == null) {
            showAlert("Ошибка", "Заполните все поля!");
            return;
        }

        try {
            int count = Integer.parseInt(countText);
            productDAO.addProduct(productDAO.getProducts().size() + 1, name, count, tag);
            table.refresh();
        } catch (NumberFormatException e) {
            showAlert("Ошибка", "Количество должно быть числом!");
        }
    }

    @FXML
    private void updateProduct() {
        Product selected = table.getSelectionModel().getSelectedItem();
        if (selected == null) {
            showAlert("Ошибка", "Выберите продукт для редактирования!");
            return;
        }

        String newName = nameField.getText();
        String countText = countField.getText();
        Tag newTag = tagComboBox.getValue();

        if (newName.isEmpty() || countText.isEmpty() || newTag == null) {
            showAlert("Ошибка", "Заполните все поля!");
            return;
        }

        try {
            int newCount = Integer.parseInt(countText);
            productDAO.updateProduct(selected, newName, newCount, newTag);
            table.refresh();
        } catch (NumberFormatException e) {
            showAlert("Ошибка", "Количество должно быть числом!");
        }
    }

    @FXML
    private void deleteProduct() {
        Product selected = table.getSelectionModel().getSelectedItem();
        if (selected != null) {
            productDAO.deleteProduct(selected);
            table.getItems().remove(selected);
        } else {
            showAlert("Ошибка", "Выберите продукт для удаления!");
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
