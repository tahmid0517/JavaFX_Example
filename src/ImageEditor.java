import java.io.File;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class ImageEditor extends Application 
{
	final double SCENE_WIDTH_PADDING = 30;
	final double SCENE_TOP_PADDING = 20;
	final double SCENE_BOTTOM_PADDING = 50;
	double SCENE_WIDTH;
	double SCENE_HEIGHT;
	Stage window;
	Group rootNode;
	Pane canvas;
	ImageView imageView;
	Image image;
	ArrayList<Rectangle> editedPixels;
	ChoiceBox<String> colourChoices;
	public void start(Stage window)
	{
		this.window = window;
		window.setResizable(false);
		window.setTitle("Ghetto Image Editor");
		rootNode = new Group();
		File imageFile = selectImagePath();
		image = createImage(imageFile);
		SCENE_WIDTH = image.getWidth() + (SCENE_WIDTH_PADDING * 2);
		SCENE_HEIGHT = image.getHeight() + SCENE_TOP_PADDING + SCENE_BOTTOM_PADDING;
		Scene scene = new Scene(rootNode,SCENE_WIDTH,SCENE_HEIGHT);
		window.setScene(scene);
		window.sizeToScene();
		canvas = new Pane();
		editedPixels = new ArrayList<Rectangle>();
		canvas.addEventFilter(MouseEvent.MOUSE_DRAGGED,new EventHandler<MouseEvent>()
		{
			@Override
			public void handle(MouseEvent event)
			{
				Rectangle blob = new Rectangle(event.getX(),event.getY(),12,12);
				editedPixels.add(blob);
				canvas.getChildren().add(blob);
				blob.setFill(getSelectedColour());
				blob.toFront();
			}
		});
		imageView = new ImageView();
		canvas.setStyle("-fx-background-color:white");
		scene.setFill(Color.AQUA);
		rootNode.getChildren().add(canvas);
		uploadImage(image);
		createButtonBar();
		window.show();
	}
	
	public static void main(String args[])
	{
		launch(args);
	}
	
	public void createButtonBar()
	{
		Button saveBtn = new Button();
		saveBtn.setText("SAVE");
		double btnWidth = 80;
		saveBtn.setPrefWidth(btnWidth);
		saveBtn.setOnAction(e -> saveImage());
		Button clearBtn = new Button();
		clearBtn.setText("CLEAR");
		clearBtn.setPrefWidth(btnWidth);
		clearBtn.setOnAction(e -> clearCanvas());
		colourChoices = new ChoiceBox<String>();
		colourChoices.getItems().addAll("RED","PURPLE","GREEN","YELLOW","BLACK","WHITE","VIOLET");
		colourChoices.setValue("PURPLE");
		colourChoices.setPrefWidth(90);
		HBox hBox = new HBox(12);
		double sidePadding = (SCENE_WIDTH - 272) / 2;
		hBox.setPadding(new Insets(10,sidePadding,10,sidePadding));
		hBox.getChildren().addAll(colourChoices,clearBtn,saveBtn);
		hBox.setLayoutY(canvas.getLayoutY() + image.getHeight());
		rootNode.getChildren().add(hBox);
	}
	
	public Color getSelectedColour()
	{
		String choice = colourChoices.getValue();
		if(choice.equals("RED"))
			return Color.RED;
		if(choice.equals("PURPLE"))
			return Color.PURPLE;
		if(choice.equals("GREEN"))
			return Color.GREEN;
		if(choice.equals("YELLOW"))
			return Color.YELLOW;
		if(choice.equals("BLACK"))
			return Color.BLACK;
		if(choice.equals("WHITE"))
			return Color.WHITE;
		if(choice.equals("VIOLET"))
			return Color.VIOLET;
		return null;
	}
	
	public void clearCanvas()
	{
		int size = editedPixels.size();
		for(int i = 0;i < size;i++)
		{
			canvas.getChildren().remove(editedPixels.get(0));
			editedPixels.remove(0);
		}
	}
	
	public void saveImage()
	{
		WritableImage image = canvas.snapshot(new SnapshotParameters(),null);
		FileChooser fileChooser = new FileChooser();
		fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PNG Files","*png"));
		try
		{
			File file = fileChooser.showSaveDialog(window);
			if(!file.getName().contains("."))
			{
				file = new File(file.getAbsolutePath() + ".png");
			}
			ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", file);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public Image createImage(File file)
	{
		double maxHeight = 900;
		double maxWidth = 1100;
		image = new Image(file.toURI().toString());
		if(image.getHeight() > maxHeight || image.getWidth() > maxWidth)
			image = new Image(file.toURI().toString(),maxHeight,maxWidth,true,true);
		return image;
	}
	
	public void uploadImage(Image image)
	{
		imageView.setImage(image);
		canvas.getChildren().add(imageView);
		double xCoordinate = (SCENE_WIDTH / 2) - (image.getWidth() / 2);
		double yCoordinate = (SCENE_HEIGHT / 2) - (image.getHeight() / 2) - ((SCENE_BOTTOM_PADDING - SCENE_TOP_PADDING) / 2);
		imageView.setLayoutX(0);
		imageView.setLayoutY(0);
		canvas.setLayoutX(xCoordinate);
		canvas.setLayoutY(yCoordinate);
		canvas.setPrefSize(image.getWidth(),image.getHeight());
	}
	
	public File selectImagePath()
	{
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Pick a picture");
		fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files","*jpeg","*png","*jpg","*bmp"));
		File file = fileChooser.showOpenDialog(window);
		return file;
	}
}