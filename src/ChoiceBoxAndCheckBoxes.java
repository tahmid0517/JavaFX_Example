import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

public class ChoiceBoxAndCheckBoxes extends Application 
{
	final double WINDOW_HEIGHT = 400;
	final double WINDOW_WIDTH = 600;
	@Override
	public void start(Stage window) throws Exception 
	{
		Group rootNode = new Group();
		Scene scene = new Scene(rootNode);
		window.setScene(scene);
		window.setHeight(WINDOW_HEIGHT);
		window.setWidth(WINDOW_WIDTH);
		CheckBox checkBox = new CheckBox();
		checkBox.setText("I am brown.");
		rootNode.getChildren().add(checkBox);
		setLocation(checkBox,200,100);
		setSize(checkBox,200,30);
		ChoiceBox<String> choiceBox = new ChoiceBox<String>();
		choiceBox.getItems().add("A");
		choiceBox.getItems().add("B");
		choiceBox.getItems().add("C");
		choiceBox.getItems().add("D");
		choiceBox.getItems().addAll("E","F","G","H");
		rootNode.getChildren().add(choiceBox);
		setLocation(choiceBox,40,20);
		window.setOnCloseRequest(e -> System.out.println(checkBox.isSelected() + " " + choiceBox.getValue()));
		window.show();
	}
	
	/*public static void main(String args[])
	{
		launch(args);
	}*/
	
	public static void setLocation(Node node,double x,double y)
	{
		node.setLayoutX(x);
		node.setLayoutY(y);
	}
	
	public static void setSize(Region region,double width,double height)
	{
		region.setMinHeight(height);
		region.setMaxHeight(height);
		region.setMinWidth(width);
		region.setMaxWidth(width);
	}
}
