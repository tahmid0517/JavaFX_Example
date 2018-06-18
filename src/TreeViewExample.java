import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.stage.Stage;

public class TreeViewExample extends Application 
{
	@SuppressWarnings("unchecked")
	@Override
	public void start(Stage window)
	{
		window.setWidth(600);
		window.setHeight(400);
		Group rootNode = new Group();
		Scene scene = new Scene(rootNode);
		window.setScene(scene);
		TreeItem<String> A = new TreeItem<String>("A");
		TreeItem<String> B = new TreeItem<String>("B");
		TreeItem<String> C = new TreeItem<String>("C");
		TreeItem<String> root = new TreeItem<String>();
		root.getChildren().addAll(A,B,C);
		root.setExpanded(true);
		addStringChildren(A,new String[] {"A1","A2","A3"});
		A.setExpanded(true);
		addStringChildren(B,new String[] {"B1","B2","B3"});
		B.setExpanded(true);
		addStringChildren(C,new String[] {"C1","C2","C3"});
		C.setExpanded(true);
		TreeView<String> tree = new TreeView<>(root);
		tree.setShowRoot(false);
		tree.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		rootNode.getChildren().add(tree);
		window.setOnCloseRequest(e -> printSelection(tree));
		window.show();
	}
	
	public static void main(String args[])
	{
		launch(args);
	}
	
	public void addStringChildren(TreeItem<String> parent,String children[])
	{
		for(int i = 0;i < children.length;i++)
		{
			TreeItem<String> child = new TreeItem<String>(children[i]);
			parent.getChildren().add(child);
		}
	}
	
	public void printSelection(TreeView<String> treeView)
	{
		ObservableList<TreeItem<String>> selectedItems = treeView.getSelectionModel().getSelectedItems();
		for(int i = 0;i < selectedItems.size();i++)
		{
			System.out.print(selectedItems.get(i).getValue() + " ");
		}
		System.out.println();
	}
}
