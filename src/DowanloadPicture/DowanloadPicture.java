package DowanloadPicture;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.IOException;


    public class DowanloadPicture extends Application {

        @Override
        public void start(Stage primaryStage) throws IOException {
            primaryStage.setTitle("DOWANLOAD");
            primaryStage.setWidth(300);
            primaryStage.setHeight(300);

            Pane root = new Pane();
            Button btn = new Button();
            Button btn1 = new Button();
            btn.setText("DOWANLOAD PICTURE");
            btn.setTranslateX(80);
            btn.setTranslateY(80);
            btn.setOnAction(event -> {
                DirectoryChoose start= new DirectoryChoose();

                try {
                    start.start(primaryStage);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
                Scene scene = new Scene(root);
                root.getChildren().addAll(btn,btn1);
                primaryStage.setScene(scene);
                primaryStage.show();
            }


        public static void main(String[] args) {
            launch(args);
        }
    }