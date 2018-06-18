import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MenuTutorial extends Application
{
	@Override
	public void start(Stage window)
	{
		window.setHeight(400);
		window.setWidth(600);
		BorderPane rootNode = new BorderPane();
		Scene scene = new Scene(rootNode);
		//First Menu
		Menu projectMenu = new Menu("Project");
		projectMenu.getItems().add(new MenuItem("Item A"));
		projectMenu.getItems().add(new MenuItem("Item B"));
		projectMenu.getItems().add(new MenuItem("Item C"));
		projectMenu.getItems().add(new MenuItem("Item D"));
		projectMenu.getItems().add(new MenuItem("Item E"));
		CheckMenuItem checkItem =new CheckMenuItem("Check this");
		checkItem.setOnAction(e ->
		{
			if(checkItem.isSelected())
				System.out.println("This item is checked now.");
			else
				System.out.println("This item is NOT checked now.");
		});		
		projectMenu.getItems().add(checkItem);
		MenuItem exit = new MenuItem("Exit");
		exit.setOnAction(e ->
		{
			window.close();
			System.exit(0);
		});
		projectMenu.getItems().add(exit);
		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().add(projectMenu);
		//Second menu
		Menu toggleMenu = new Menu("Toggle");
		ToggleGroup toggleGroup = new ToggleGroup();
		RadioMenuItem toggleA = new RadioMenuItem("Toggle A");
		RadioMenuItem toggleB = new RadioMenuItem("Toggle B");
		RadioMenuItem toggleC = new RadioMenuItem("Toggle C");
		toggleA.setToggleGroup(toggleGroup);
		toggleB.setToggleGroup(toggleGroup);
		toggleC.setToggleGroup(toggleGroup);
		toggleA.setOnAction(e -> System.out.println("Toggle A is selected"));
		toggleB.setOnAction(e -> System.out.println("Toggle B is selected"));
		toggleC.setOnAction(e -> System.out.println("Toggle C is selected"));
		toggleMenu.getItems().addAll(toggleA,toggleB,toggleC);
		menuBar.getMenus().add(toggleMenu);
		rootNode.setTop(menuBar);
		window.setScene(scene);
		window.show();
	}
	
	public static void main(String args[])
	{
		launch(args);
	}
}
