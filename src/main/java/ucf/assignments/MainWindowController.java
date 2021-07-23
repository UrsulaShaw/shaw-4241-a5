package ucf.assignments;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.math.BigDecimal;

public class MainWindowController {

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





    @FXML
    public void addItemButtonClicked(ActionEvent actionEvent) {
    }

    @FXML
    public void sortSerialNumberButtonClicked(ActionEvent actionEvent) {
    }

    @FXML
    public void sortNameButtonClicked(ActionEvent actionEvent) {
    }


    public void editSerialNumber(TableColumn.CellEditEvent cell) {
        Item itemSelected = inventory.getSelectionModel().getSelectedItem();
        itemSelected.setSerialNumber(cell.getNewValue().toString());
    }

    public void editName(TableColumn.CellEditEvent cell) {
        Item itemSelected = inventory.getSelectionModel().getSelectedItem();
        itemSelected.setName(cell.getNewValue().toString());
    }

    public Item addNewItem(String serialNumber, String name, BigDecimal value) {
        return new Item(serialNumber, name, value);
    }
}
