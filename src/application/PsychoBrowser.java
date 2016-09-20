package application;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class PsychoBrowser {

	private final IntegerProperty logicalRef;
	private final StringProperty name;
	private final StringProperty surname;

	public PsychoBrowser(int logicalRef, String name, String surname) {
		this.logicalRef = new SimpleIntegerProperty(logicalRef);
		this.name = new SimpleStringProperty(name);
		this.surname = new SimpleStringProperty(surname);
	}

	public int getLogicalRef() {
		return logicalRef.get();
	}

	public String getName() {
		return name.get();
	}

	public String getSurname() {
		return surname.get();
	}

	public IntegerProperty logicalRefProperty(){
		return logicalRef;
	}

	public StringProperty nameProperty(){
		return name;
	}

	public StringProperty surnameProperty(){
		return surname;
	}


}
