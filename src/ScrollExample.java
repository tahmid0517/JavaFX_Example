import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ScrollExample extends Application
{
	public void start(Stage window)
	{
		Group rootNode = new Group();
		Scene scene = new Scene(rootNode,400,400);
		VBox buttonBox = new VBox();
		buttonBox.setPadding(new Insets(20,0,20,10));
		buttonBox.setSpacing(20);
		buttonBox.setPrefSize(300,300);
		ScrollPane scroller = new ScrollPane(buttonBox);
		scroller.setLayoutX(50);
		scroller.setLayoutY(50);
		scroller.setFitToHeight(true);
		scroller.setFitToWidth(true);
		for(int i = 0;i < 10;i++)
		{
			Button button = new Button();
			int num = i + 1;
			button.setText(String.valueOf(num));
			button.setPrefSize(250,100);
			button.setFont(new Font(30));
			buttonBox.getChildren().add(button);
			button.setFocusTraversable(false);
			button.setOnAction(e -> System.out.println("You pressed Button " + num));
		}
		
		rootNode.getChildren().add(scroller);
		window.setScene(scene);
		window.show();
		
	}
	
	public static void main(String args[])
	{
		launch(args);
	}
}
