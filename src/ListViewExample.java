import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.stage.Stage;

public class ListViewExample extends Application
{
	@Override
	public void start(Stage window)
	{
		window.setTitle("ListView Example");
		window.setWidth(600);
		window.setHeight(400);
		Group rootNode = new Group();
		Scene scene = new Scene(rootNode);
		window.setScene(scene);
		ListView<String> listView = new ListView<String>();
		listView.getItems().addAll("A","B","C","D","E");
		listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		rootNode.getChildren().add(listView);
		window.setOnCloseRequest(e -> printSelected(listView));
		window.show();
	}
	
	public static void main(String args[])
	{
		launch(args);
	}
	
	public void printSelected(ListView<String> listView)
	{
		ObservableList<String> list = listView.getSelectionModel().getSelectedItems();
		for(int i = 0;i < list.size();i++)
		{
			System.out.print(list.get(i) + " ");
		}
		System.out.println();
	}
}
