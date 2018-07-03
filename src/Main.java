
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) 
	{
		PrimaryStage.init(primaryStage);
		Button button = new Button();
		button.setMinSize(100,100);
		button.setLayoutX(PrimaryStage.APP_WIDTH / 2 - 50);
		button.setLayoutY(PrimaryStage.APP_HEIGHT / 2 - 75);
		button.setText("CLICK ME!");
		button.setOnAction(new ButtonHandler());
		Button button2 = new Button();
		button2.setText("MINI ME!");
		button2.setOnAction(new EventHandler<ActionEvent>()
				{
					@Override
					public void handle(ActionEvent e)
					{
						System.out.println("the other button!");
						System.out.println(ConfirmBox.display());
					}
				});
		Button button3 = new Button();
		Group layout2 = new Group();
		Scene scene2 = new Scene(layout2,PrimaryStage.APP_WIDTH,PrimaryStage.APP_HEIGHT);
		button3.setOnAction(e -> PrimaryStage.getInstance().setScene(scene2));
		Group layout = new Group();
		layout.getChildren().add(button);
		layout.getChildren().add(button2);
		layout.getChildren().add(button3);
		FirstScene.initScene(layout);
		PrimaryStage.getInstance().setScene(FirstScene.getInstance());
		PrimaryStage.getInstance().show();
	}
	
	public static void main(String[] args) 
	{
		launch(args);
	}
}
