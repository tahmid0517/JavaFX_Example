import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class TextInput extends Application
{
	public void start(Stage window)
	{
		window.setHeight(400);
		window.setWidth(350);
		Group rootNode = new Group();
		Scene scene = new Scene(rootNode);
		window.setScene(scene);
		TextField textField = new TextField();
		textField.setPromptText("ENTER SOMETHING");
		textField.setFocusTraversable(false);
		Button submit = new Button();
		submit.setText("SUBMIT");
		submit.setOnAction(e -> submitText(textField));
		submit.setLayoutY(40);
		submit.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>()
		{
			@Override
			public void handle(KeyEvent e)
			{
				if(e.getCode() == KeyCode.ENTER)
					submitText(textField);
			}
		});
		rootNode.getChildren().addAll(textField,submit);
		window.show();
	}
	
	public static void main(String args[])
	{
		launch(args);
	}
	
	public void submitText(TextField field)
	{
		System.out.println(field.getText());
		field.setText("");
	}
}
