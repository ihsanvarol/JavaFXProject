package application;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class RecordsController implements Initializable {

	@FXML
	private Button refreshButton;
	@FXML
	private Label dbstatus;

	@FXML
	private TableView<PsychoBrowser> tablePsycho;

	@FXML
	private TableColumn<PsychoBrowser, Integer> columnLRef;

	@FXML
	private TableColumn<PsychoBrowser, String> columnName;

	@FXML
	private TableColumn<PsychoBrowser, String> columnSurname;

	private ObservableList<PsychoBrowser> psychoData;

	public PsychoModel psycho = new PsychoModel();

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	private void connectDB() {
		if (psycho.isDBConnected())
			dbstatus.setText("Baðlantý Baþarýlý");
		else
			dbstatus.setText("Baðlantý Baþarýsýz");
	}

	@FXML
	public void loadDataFromDataBase(ActionEvent event) {
		psychoData = FXCollections.observableArrayList();
		try {
			connectDB();
			ResultSet rs = psycho.connection.createStatement()
					.executeQuery("SELECT LOGICALREF AS logicalRef,NAME AS name, SURNAME AS surname FROM Psycho");
			while (rs.next()) {
				psychoData.add(new PsychoBrowser(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		columnLRef.setCellValueFactory(new PropertyValueFactory<>("logicalRef"));
		columnName.setCellValueFactory(new PropertyValueFactory<>("name"));
		columnSurname.setCellValueFactory(new PropertyValueFactory<>("surname"));

		tablePsycho.setItems(null);
		tablePsycho.setItems(psychoData);

	}

	@FXML
	public void onDblClick(ActionEvent event) {

	}

	@FXML
	public void onUpdate(ActionEvent event) {
		try {
			// Load the fxml file and create a new stage for the popup dialog.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("Card.fxml"));
			//loader.load(getClass().getResource("Card.fxml").openStream());
			AnchorPane page = (AnchorPane) loader.load();

			// Create the dialog Stage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Edit Person");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(null);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			// Set the person into the controller.
			CardController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.cardData = tablePsycho.getSelectionModel().getSelectedItem();
			controller.setCardInfo();
			// Show the dialog and wait until the user closes it
			dialogStage.showAndWait();

			//return controller.isOkClicked();
		} catch (IOException e) {
			e.printStackTrace();
			//return false;
		}

	}

}
