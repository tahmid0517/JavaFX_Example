

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ConfirmBox 
{
	static String answer;
	public static String display()
	{
		VBox layout = new VBox();
		Stage window = new Stage();
		Scene scene = new Scene(layout);
		Button yes = new Button();
		yes.setText("YES");
		Button no = new Button();
		no.setText("NO");
		yes.setOnAction(e -> 
			{
				answer = "YES";
				window.close();
			});
		no.setOnAction(e -> 
			{
				answer = "NO";
				window.close();
			});
		layout.getChildren().addAll(yes,no);
		window.setScene(scene);
		window.showAndWait();
		return answer;
	}
}
