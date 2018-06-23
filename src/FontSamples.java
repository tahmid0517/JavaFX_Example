import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class FontSamples extends Application
{
	@Override
	public void start(Stage window)
	{
		VBox vBox = new VBox();
		ScrollPane scrollPane = new ScrollPane(vBox);
		Scene scene = new Scene(scrollPane,500,600);
		window.setScene(scene);
		for(int i = 0;i < Font.getFamilies().size();i++)
		{
			Label label = new Label();
			label.setText(i + ") " +Font.getFamilies().get(i));
			Font font = new Font(Font.getFamilies().get(i),30);
			label.setFont(font);
			vBox.getChildren().add(label);
		}
		window.show();
	}

	public static void main(String args[])
	{
		launch(args);
	}
}
