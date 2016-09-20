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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

public class MainMenuController implements Initializable {

	@FXML
	private StackPane centerSP;

	public void showRecordPage() throws IOException {
		FXMLLoader fXMLLoader = new FXMLLoader();
		fXMLLoader.load(getClass().getResource("Records.fxml").openStream());
		AnchorPane anchorPane = fXMLLoader.getRoot();
		centerSP.getChildren().clear();
		centerSP.getChildren().add(anchorPane);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			showRecordPage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	public void exitProgram(MouseEvent event) {
		Platform.exit();
		System.exit(0);
	}

}
