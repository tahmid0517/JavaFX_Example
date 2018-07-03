

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;

public class FirstScene
{
	private static Scene scene;
	private static final String SCENE_TITLE = "The First Scene";
	// Constants
	public static final String TITLE = "The First Scene";
	
	public static void initScene(Parent root)
	{
		scene = new Scene(root);
		scene.setFill(Color.DEEPSKYBLUE);
	}
	public static Scene getInstance()
	{
		return scene;
	}
	public static void showTitle()
	{
		PrimaryStage.getInstance().setTitle(SCENE_TITLE);
	}
}
