package DowanloadPicture;

import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class DirectoryChoose extends Application{
    @Override
    public void start(Stage primaryStage) throws Exception {
        Stage stage = new Stage();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select directory for save");
        fileChooser.setInitialFileName("decryptImage");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image", "*.jpg"));
        File file = fileChooser.showSaveDialog(stage);

        if (file != null) {
            ImageView imageView = new ImageView();
            URL url = null;
            try {
                url = new URL("https://www.google.by/images/branding/googlelogo/2x/googlelogo_color_120x44dp.png");
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
            }}

}

    public static void main(String[] args) {
        launch(args);
    }
}
