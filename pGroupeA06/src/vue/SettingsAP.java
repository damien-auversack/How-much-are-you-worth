package vue;

import application.SceneManager;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import util.Constants;

public class SettingsAP extends AnchorPane {
	private Slider slVolume, slVolumeEffects;
	private Text txtTitle, txtVolume, txtVolumeEffects;
	private Button btnBack,btnMainMenu;

	public SettingsAP() {

		
		this.getStyleClass().add("pane");
		this.getChildren().addAll(getTxtTitle(), getBtnBack(null), getTxtVolume(), getSlVolume(),getBtnMainMenu(),getTxtVolumeEffects(), getSlVolumeEffects());

		// title
		txtTitle.getStyleClass().add("title-style");
		AnchorPane.setTopAnchor(getTxtTitle(), 100.0);
		AnchorPane.setRightAnchor(getTxtTitle(), 700.0);
		AnchorPane.setLeftAnchor(getTxtTitle(), 700.0);

		// BtnBack
		btnBack.getStyleClass().add("btn-style");
		AnchorPane.setTopAnchor(getBtnBack(null), 870.0);
		AnchorPane.setRightAnchor(getBtnBack(null), 650.0);
		AnchorPane.setLeftAnchor(getBtnBack(null), 650.0);
		
		// BtnMainMenu
		btnMainMenu.getStyleClass().add("btn-style");
		AnchorPane.setTopAnchor(getBtnMainMenu(),695.0);
		AnchorPane.setRightAnchor(getBtnMainMenu(), 650.0);
		AnchorPane.setLeftAnchor(getBtnMainMenu(), 650.0);

		// SlVolume
		slVolume.setValue(Constants.INITIAL_VOLUME);
		slVolume.getStyleClass().add("slider-style");
		AnchorPane.setTopAnchor(getSlVolume(), 410.0);
		AnchorPane.setRightAnchor(getSlVolume(), 550.0);
		AnchorPane.setLeftAnchor(getSlVolume(), 600.0);
		
		// SlVolumeEffects
		slVolumeEffects.setValue(Constants.INITIAL_VOLUME_EFFECTS);
		slVolumeEffects.getStyleClass().add("slider-style");
		AnchorPane.setTopAnchor(getSlVolumeEffects(), 560.0);
		AnchorPane.setRightAnchor(getSlVolumeEffects(), 550.0);
		AnchorPane.setLeftAnchor(getSlVolumeEffects(), 600.0);

		// TxtVolume
		txtVolume.getStyleClass().add("h1");
		AnchorPane.setTopAnchor(getTxtVolume(), 400.0);
		AnchorPane.setRightAnchor(getTxtVolume(), 1400.0);
		AnchorPane.setLeftAnchor(getTxtVolume(), 200.0);	
		
		// TxtVolumeEffects
		txtVolumeEffects.getStyleClass().add("h1");
		AnchorPane.setTopAnchor(getTxtVolumeEffects(), 550.0);
		AnchorPane.setRightAnchor(getTxtVolumeEffects(), 1400.0);
		AnchorPane.setLeftAnchor(getTxtVolumeEffects(), 200.0);
		
		

	}

	public Text getTxtTitle() {
		if (txtTitle == null) {
			txtTitle = new Text("Options");
		}
		return txtTitle;
	}

	public Button getBtnBack(StackPane sp) {
		if (btnBack == null) {
			btnBack = new Button("Resume");
		}
		btnBack.setOnAction(new EventHandler<ActionEvent>(){
	        public void handle(ActionEvent event) {
	        	SceneManager.getSceneRoot().setRoot(sp);  	
	        }
		});
		return btnBack;
	}
	
	public Button getBtnMainMenu() {
		if (btnMainMenu == null) {
			btnMainMenu = new Button("Main Menu");
		}
		btnMainMenu.setOnAction(new EventHandler<ActionEvent>(){
	        public void handle(ActionEvent event) {
	            SceneManager.getSceneRoot().setRoot(SceneManager.getStackRoot());
	            }
		});
		return btnMainMenu;
	}

	public Text getTxtVolume() {
		if (txtVolume == null) {
			txtVolume = new Text("Volume : ");
		}
		return txtVolume;
	}

	public Slider getSlVolume() {
		if (slVolume == null) {
			slVolume = new Slider();
		}
		return slVolume;
	}
	
	public Text getTxtVolumeEffects() {
		if (txtVolumeEffects == null) {
			txtVolumeEffects = new Text("Effects : ");
		}
		return txtVolumeEffects;
	}

	public Slider getSlVolumeEffects() {
		if (slVolumeEffects == null) {
			slVolumeEffects = new Slider();
		}
		return slVolumeEffects;
	}

}

