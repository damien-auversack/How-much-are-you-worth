package vue;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import application.SceneManager;

public class HomeAP extends AnchorPane {
	
	private Text txtTitle;
	private Button btnStartGame;
	private Button btnGameRule;
	private Button btnQuit;
	private Button btnOption;

	public HomeAP() {
		
		this.getStyleClass().add("pane");
		this.getChildren().addAll(getTxtTitle(),getBtnStartGame(),getBtnGameRule(),getBtnOptions(),getBtnQuit());
		
		//title		
		getTxtTitle().getStyleClass().add("title2-style");
		AnchorPane.setTopAnchor(getTxtTitle(), 100.0 );
		AnchorPane.setLeftAnchor(getTxtTitle(), 177.0 );
		
		//BtnStartGame
		getBtnStartGame().getStyleClass().add("btn-style");
		AnchorPane.setTopAnchor(getBtnStartGame(), 350.0 );
		AnchorPane.setRightAnchor(getBtnStartGame(), 700.0 );
		AnchorPane.setLeftAnchor(getBtnStartGame(), 700.0 );
		
		//BtnGameRule
		getBtnGameRule().getStyleClass().add("btn-style");
		AnchorPane.setTopAnchor(getBtnGameRule(), 550.0 );
		AnchorPane.setRightAnchor(getBtnGameRule(), 700.0 );
		AnchorPane.setLeftAnchor(getBtnGameRule(), 700.0 );
		
		//BtnOptions
		getBtnOptions().getStyleClass().add("btn-style");
		AnchorPane.setTopAnchor(getBtnOptions(), 750.0 );
		AnchorPane.setRightAnchor(getBtnOptions(), 700.0 );
		AnchorPane.setLeftAnchor(getBtnOptions(), 700.0 );
		
		//BtnQuit
		getBtnQuit().getStyleClass().add("btn-style");
		AnchorPane.setTopAnchor(getBtnQuit(), 900.0 );
		AnchorPane.setRightAnchor(getBtnQuit(), 50.0 );
		AnchorPane.setLeftAnchor(getBtnQuit(), 1600.0 );
		
	}

	public Text getTxtTitle() {
		if (txtTitle == null) {
			txtTitle = new Text("How much are you worth ?");
		}
		return txtTitle;
	}

	public Button getBtnStartGame() {
		if (btnStartGame == null) {
			btnStartGame = new Button("Start Game");
		}
		btnStartGame.setOnAction(new EventHandler<ActionEvent>(){
	        public void handle(ActionEvent event) {
	            SceneManager.getSceneRoot().setRoot(SceneManager.getStackAddPlayers());
	            }
			});
		return btnStartGame;
	}

	public Button getBtnGameRule() {
		if (btnGameRule == null) {
			btnGameRule = new Button("Game rules");
		}
		btnGameRule.setOnAction(new EventHandler<ActionEvent>(){
	        public void handle(ActionEvent event) {
	            SceneManager.getSceneRoot().setRoot(SceneManager.getStackGameRule());
	            }
			});
		return btnGameRule;
	}

	public Button getBtnQuit() {
		if (btnQuit == null) {
			btnQuit = new Button("Quit");
		}
		return btnQuit;
	}

	public Button getBtnOptions() {
		if (btnOption == null) {
			btnOption = new Button("Options");
		}
		btnOption.setOnAction(new EventHandler<ActionEvent>(){
        public void handle(ActionEvent event) {
            SceneManager.getSceneRoot().setRoot(SceneManager.getStackOptions());
            }
		});
		
		return btnOption;
	}

}
