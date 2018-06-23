import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

public class SplashScreenExample extends Application
{	
	public void start(Stage window)
	{
		window.initStyle(StageStyle.UNDECORATED);
		Group rootNode = new Group();
		Scene scene = new Scene(rootNode);
		window.setScene(scene);
		window.sizeToScene();
		ImageView imageView = new ImageView();
		Image logo = new Image("res/splashScreen.png",400,400,true,true);
		imageView.setImage(logo);
		rootNode.getChildren().add(imageView);
		window.show();
		PauseTransition pause = new PauseTransition(Duration.seconds(2));
		pause.setOnFinished(e -> 
		{
			System.out.println("This is when the splash screen closes.");
			window.close();
			Stage newWindow = new Stage();
			newWindow.show();
		});
		pause.play();
	}
	
	public static void main(String args[])
	{
		launch(args);
	}
}
