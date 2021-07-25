package ucf.assignments;

/*
 *  UCF COP3330 Summer 2021 Assignment 5 Solution
 *  Copyright 2021 Ursula Shaw
 */

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

import java.math.BigDecimal;
import java.net.URL;
import java.util.ResourceBundle;

public class MainWindowController implements Initializable {

    @FXML public TableView<Item> inventory;
    @FXML private TableColumn<Item, String> itemSerialNumberColumn;
    @FXML private TableColumn<Item, String> itemNameColumn;
    @FXML private TableColumn<Item, BigDecimal> itemValueColumn;

    @FXML public TextField searchBar;
    @FXML public TextField valueTextField;
    @FXML public TextField nameTextField;
    @FXML public TextField serialNumberTextField;

    @FXML public ToggleButton sortBySNToggleButton;
    @FXML public ToggleButton sortByNameToggleButton;

    @FXML public CheckBox searchBySNCheckbox;
    @FXML public CheckBox searchByNameCheckbox;

    @FXML public Button addItemButton;
    @FXML public Button deleteSelectedButton;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        itemNameColumn.setCellValueFactory(new PropertyValueFactory<Item, String>("name"));
        itemSerialNumberColumn.setCellValueFactory(new PropertyValueFactory<Item, String>("serialNumber"));
        itemValueColumn.setCellValueFactory(new PropertyValueFactory<Item, BigDecimal>("value"));

        inventory.setItems(getItems());

        inventory.setEditable(true);
        itemNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        itemSerialNumberColumn.setCellFactory(TextFieldTableCell.forTableColumn());

    }

    public ObservableList<Item> getItems() {
        return FXCollections.observableArrayList();
    }

    @FXML
    public void addItemButtonClicked(ActionEvent actionEvent) {
        addNewItem();
    }

    public void addNewItem() {
        // create a new item from the text fields
        Item newItem = new Item(nameTextField.getText(),
                serialNumberTextField.getText(),
                new BigDecimal(valueTextField.getText()));
        // get all the items in the inventory and add the new item
        inventory.getItems().add(newItem);
    }

    @FXML
    public void sortSerialNumberButtonClicked(ActionEvent actionEvent) {
    }

    @FXML
    public void sortNameButtonClicked(ActionEvent actionEvent) {
    }

    @FXML
    public void deleteSelectedButtonClicked(ActionEvent actionEvent) {
        deleteSelectedItem();
    }

    private void deleteSelectedItem() {
        // get all the items in the inventory
        ObservableList<Item> selectedItems, allItems;
        allItems = inventory.getItems();

        // get the selected items
        selectedItems = inventory.getSelectionModel().getSelectedItems();

        // remove selected items
        for (Item item: selectedItems) {
            allItems.remove(item);
        }
    }

    public void editSerialNumber(TableColumn.CellEditEvent cell) {
        Item itemSelected = inventory.getSelectionModel().getSelectedItem();
        itemSelected.setSerialNumber(cell.getNewValue().toString());
    }

    public void editName(TableColumn.CellEditEvent cell) {
        Item itemSelected = inventory.getSelectionModel().getSelectedItem();
        itemSelected.setName(cell.getNewValue().toString());
    }

    public void editValue(TableColumn.CellEditEvent cell) {
        Item itemSelected = inventory.getSelectionModel().getSelectedItem();
        itemSelected.setValue(new BigDecimal(cell.getNewValue().toString()));
    }

    public Item addNewItem(String serialNumber, String name, BigDecimal value) {
        return new Item(serialNumber, name, value);
    }


}
