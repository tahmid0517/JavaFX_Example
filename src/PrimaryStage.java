

import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class PrimaryStage 
{
	private static Stage stage;
	public static final double APP_HEIGHT = 300;
	public static final double APP_WIDTH = 500;
	public static void init(Stage stage)
	{
		PrimaryStage.stage = stage;
		stage.setTitle("TITLE");
		stage.setMinHeight(APP_HEIGHT);
		stage.setMinWidth(APP_WIDTH);
		stage.setResizable(false);
	}
	public static Stage getInstance()
	{
		if(stage == null)
		{
			System.out.println("ERROR: Primary stage was not initialized.");
			return null;
		}
		return stage;
	}
	public static void setNewScene(Scene scene)
	{
		scene.setFill(Color.WHITE);
		stage.setScene(scene);
	}
}
