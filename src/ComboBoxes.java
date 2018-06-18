import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class ComboBoxes extends Application
{
	@Override
	public void start(Stage window) throws Exception 
	{
		Group rootNode = new Group();
		Scene scene = new Scene(rootNode);
		window.setScene(scene);
		window.setHeight(300);
		window.setWidth(600);
		ComboBox<String> comboBox = new ComboBox<String>();
		comboBox.getItems().addAll("A","B","C","D");
		comboBox.setPromptText("Pick a letter:");
		comboBox.setLayoutX(100);
		comboBox.setLayoutY(100);
		comboBox.setEditable(true);
		rootNode.getChildren().add(comboBox);
		Button submitBtn = new Button();
		submitBtn.setText("SUBMIT");
		submitBtn.setOnAction(e -> System.out.println(comboBox.getValue()));
		rootNode.getChildren().add(submitBtn);
		window.show();
	}
	
	/*public static void main(String args[])
	{
		launch(args);
	}*/
}
