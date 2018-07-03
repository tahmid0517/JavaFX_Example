

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlertBox 
{
	public static void display()
	{
		Group root = new Group();
		Scene scene = new Scene(root);
		Label label = new Label("This is an alert!");
		root.getChildren().add(label);
		Stage window = new Stage();
		window.setScene(scene);
		window.initModality(Modality.APPLICATION_MODAL);
		window.show();
	}
}
