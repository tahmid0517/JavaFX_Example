import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class DotGenerator extends Application 
{
	@Override
	public void start(Stage window)
	{
		window.setHeight(550);
		window.setWidth(500);
		Group rootNode = new Group();
		Scene scene = new Scene(rootNode);
		Pane pane = new Pane();
		pane.setPrefHeight(300);
		pane.setPrefWidth(300);
		pane.setLayoutX(100);
		pane.setLayoutY(100);
		pane.setVisible(true);
		pane.setStyle("-fx-background-color:white");
		pane.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>()
		{
			 @Override
			    public void handle(MouseEvent mouseEvent) 
			    {
			        Circle circle = new Circle();
			        circle.setRadius(8);
			        circle.setFill(Color.YELLOW);
			        circle.setLayoutX(mouseEvent.getX());
			        circle.setLayoutY(mouseEvent.getY());
			        pane.getChildren().add(circle);
			    }
		});
		Button clearButton = new Button();
		clearButton.setText("CLEAR");
		clearButton.setLayoutX(210);
		clearButton.setLayoutY(410);
		clearButton.setPrefSize(80,30);
		clearButton.setOnAction(e -> clearPane(pane));
		rootNode.getChildren().addAll(pane,clearButton);
		scene.setFill(Color.AQUA);
		window.setScene(scene);
		window.show();
	}
	
	public static void main(String args[])
	{
		launch(args);
	}
	
	public void clearPane(Pane pane)
	{
		while(pane.getChildren().size() > 0)
			pane.getChildren().remove(0);
	}
}
