import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class CSS_Example extends Application
{
	@Override
	public void start(Stage window)
	{
		/*window.setHeight(400);
		window.setWidth(600);
		GridPane rootNode = new GridPane();
		Scene scene = new Scene(rootNode);
		Button setStyle1 = new Button();
		setStyle1.setText("Template Style");
		//setStyle1.setOnAction(e -> setUserAgentStylesheet(STYLESHEET_CASPIAN));
		Button setStyle2 = new Button();
		setStyle2.setText("Custom Style");
		//setStyle2.setLayoutY(50);
		rootNode.setId("root");
		//scene.getStylesheets().add("customStyle.css");
		window.setScene(scene);
		GridPane.setConstraints(setStyle1,1,1);
		GridPane.setConstraints(setStyle2,1,2);
		rootNode.setVgap(20);
		rootNode.getChildren().addAll(setStyle1,setStyle2);
		scene.setFill(Color.web("#008b8b"));
		window.show();*/
		window.setHeight(400);
		window.setWidth(600);
		Group rootNode = new Group();
		Scene scene = new Scene(rootNode);
		scene.setFill(Color.web("#008b8b"));
		scene.getStylesheets().add("customStyle.css");
		Button button = new Button();
		button.setText("fart");
		button.setLayoutX(300 - 100);
		button.setLayoutY(175 - 50);
		button.setOnAction(e -> System.out.println("fart"));
		rootNode.getChildren().add(button);
		scene.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
		    @Override
		    public void handle(MouseEvent mouseEvent) 
		    {
		        System.out.println(mouseEvent.getX() + "," + mouseEvent.getY());
		    }
		});
		button.setPrefHeight(100);
		button.setPrefWidth(200);
		window.setScene(scene);
		window.show();
	}
	
	public static void main(String args[])
	{
		launch(args);
	}
	
}
