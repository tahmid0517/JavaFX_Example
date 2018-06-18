import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TestFX extends Application
{
	final double GRID_PADDING_TOP = 10;
	final double GRID_PADDING_RIGHT = 10;
	final double GRID_PADDING_BOTTOM = 10;
	final double GRID_PADDING_LEFT = 10;
	final double VERTICAL_CELL_GAP = 8;
	final double HORIZONTAL_CELL_GAP = 9;
	//GridPane tutorial
	@Override
	public void start(Stage window) throws Exception 
	{
		window.setTitle("Grid Pane Tutorial");
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(GRID_PADDING_TOP,GRID_PADDING_RIGHT,GRID_PADDING_BOTTOM,GRID_PADDING_LEFT));
		grid.setVgap(VERTICAL_CELL_GAP);
		grid.setHgap(HORIZONTAL_CELL_GAP);
		Scene scene = new Scene(grid,700,500);
		Button button1 = new Button();
		GridPane.setRowIndex(button1,200);
		GridPane.setColumnIndex(button1,20);
		grid.getChildren().add(button1);
		window.setScene(scene);
		window.show();
	}
	
	/*public static void main(String args[])
	{
		launch(args);
	}*/
}
