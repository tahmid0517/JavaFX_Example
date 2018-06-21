import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class CustomButtonExample extends Application
{
	final double SCENE_WIDTH = 300;
	final double SCENE_HEIGHT = 300;
	Stage window;
	Group rootNode;
	Scene scene;
	ImageView customBtn;
	Image mouseOnBtn, mouseOffBtn;
	public void start(Stage window)
	{
		this.window = window;
		rootNode = new Group();
		scene = new Scene(rootNode,SCENE_WIDTH,SCENE_HEIGHT);
		window.setScene(scene);
		window.sizeToScene();
		scene.setFill(Color.GREENYELLOW);
		window.show();
		CustomButton customBtn = new CustomButton(100,100,"res/onBtn.png","res/offBtn.png") {
			@Override
			public void onClick() 
			{
				System.out.println("I'm using the CustomButton class.");
			}
		};
		rootNode.getChildren().add(customBtn.getNode());
		customBtn.setLocation(SCENE_WIDTH / 2 - (customBtn.getWidth() / 2), SCENE_HEIGHT / 2 - (customBtn.getHeight() / 2));
	}
	
	public static void main(String args[])
	{
		launch(args);
	}
}