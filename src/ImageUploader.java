import java.io.File;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class ImageUploader extends Application
{
	final double SCENE_WIDTH = 600;
	final double SCENE_HEIGHT = 500;
	Stage window;
	Group rootNode;
	Pane canvas;
	ImageView imageView;
	public void start(Stage window)
	{
		this.window = window;
		window.setResizable(false);
		rootNode = new Group();
		Scene scene = new Scene(rootNode,SCENE_WIDTH,SCENE_HEIGHT);
		window.setScene(scene);
		window.sizeToScene();
		canvas = new Pane();
		canvas.setPrefSize(300,300);
		canvas.setLayoutX(SCENE_WIDTH / 2 - 150);
		canvas.setLayoutY(SCENE_HEIGHT / 2 - 150);
		imageView = new ImageView();
		canvas.setStyle("-fx-background-color:white");
		scene.setFill(Color.AQUA);
		rootNode.getChildren().add(canvas);
		window.show();
		selectImagePath();
	}
	
	public static void main(String args[])
	{
		launch(args);
	}
	
	public void uploadImage(File file)
	{
		Image image = new Image(file.toURI().toString(),450,450,true,true );
		imageView.setImage(image);
		rootNode.getChildren().remove(canvas);
		rootNode.getChildren().add(imageView);
		double xCoordinate = (SCENE_WIDTH / 2) - (image.getWidth() / 2);
		double yCoordinate = (SCENE_HEIGHT / 2) - (image.getHeight() / 2);
		imageView.setLayoutX(xCoordinate);
		imageView.setLayoutY(yCoordinate);
	}
	
	public void selectImagePath()
	{
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Pick a picture");
		fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files","*jpeg","*png","*jpg","*bmp"));
		File file = fileChooser.showOpenDialog(window);
		uploadImage(file);
	}
}
