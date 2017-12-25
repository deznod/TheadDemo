package DowanloadPicture;

import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class DirectoryChoose extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane root = new GridPane();
        root.setPadding(new Insets(10, 10, 10, 10));
        root.setHgap(5);
        root.setVgap(5);

        TextField urlName = new TextField("Insert Your url");
        GridPane.setConstraints(urlName, 0, 0);

        Button btn1 = new Button();
        btn1.setText("DOWNLOAD PICTURE");
        btn1.setTranslateX(80);
        btn1.setTranslateY(80);
        btn1.setOnAction(event -> {
            Stage stage = new Stage();
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Select directory for save");
            fileChooser.setInitialFileName("decryptImage");
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image", "*.jpg"));
            File file = fileChooser.showSaveDialog(stage);
            String urlStringName = String.valueOf(urlName.getCharacters());
            //System.out.println(urlStringName);
            if (file != null) {
                ImageView imageView = new ImageView();
                URL url = null;
                try {
                    url = new URL(urlStringName);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }

                BufferedImage image = null;
                try {
                    image = ImageIO.read(url);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                imageView.setImage(SwingFXUtils.toFXImage(image, null));
                try {
                    ImageIO.write(SwingFXUtils.fromFXImage(imageView.getImage(),
                            null), "png", file);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        Scene scene = new Scene(root, 300, 300);
        root.getChildren().addAll(urlName, btn1);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
