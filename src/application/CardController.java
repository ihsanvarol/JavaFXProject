package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CardController implements Initializable {
	@FXML
	private TextField Text1;
	@FXML
	private TextField Text2;
	@FXML
	private TextField Text3;

	public static PsychoBrowser cardData;
	private Stage dialogStage;
	private boolean okClicked = false;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		if (cardData != null) {
			Text1.setText(Integer.toString(cardData.getLogicalRef()));
			Text2.setText(cardData.getName());
			Text3.setText(cardData.getSurname());
		}
	}

	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	@FXML
	private void handleCancel() {
		dialogStage.close();
	}

	@FXML
	private void handleOk() {
		setOkClicked(true);
		dialogStage.close();
	}

	public boolean isOkClicked() {
		return okClicked;
	}

	public void setOkClicked(boolean okClicked) {
		this.okClicked = okClicked;
	}

	public void setCardInfo()
	{
		if (cardData != null) {
			Text1.setText(Integer.toString(cardData.getLogicalRef()));
			Text2.setText(cardData.getName());
			Text3.setText(cardData.getSurname());
		}
	}

}
