package Temples;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AddObjects extends Application {



        @Override
        public void start(Stage frame) throws Exception {
            Group groupOfNodes = new Group();
            Scene scene = new Scene(groupOfNodes, 600,600, Color.SKYBLUE);


            //Create Text and Modify
            Text text = new Text();
            text.setText("Hello World");
            text.setX(50);
            text.setY(50);
            text.setFont(Font.font("Verdana" ,50));
            text.setFill(Color.LIMEGREEN);

            // Create a Line and Modify
            Line line = new Line();
            line.setStartX(200);
            line.setStartY(200);
            line.setEndX(500);
            line.setEndY(200);
            line.setStrokeWidth(5);
            line.setStroke(Color.RED);
            line.setOpacity(0.5);
            line.setRotate(45);

            // Create Rectangle and Modify
            Rectangle rectangle = new Rectangle();
            rectangle.setX(50);
            rectangle.setY(150);
            rectangle.setWidth(200);
            rectangle.setHeight(100);
            rectangle.setFill(Color.YELLOW);
            rectangle.setStrokeWidth(5);
            rectangle.setStroke(Color.BLACK);

            // Create triangle and modify
            Polygon triangle = new Polygon();
            triangle.getPoints().setAll(
                    300.0,300.0,
                    400.0, 400.0,
                    300.0, 400.0);
            triangle.setFill(Color.BROWN);

            // Create a Circle and modify
            Circle circle = new Circle(350);
            circle.setCenterX(150);
            circle.setCenterY(350);
            circle.setRadius(50);
            circle.setFill(Color.ORANGE);

            // add Image to the scene
            Image image = new Image("C:\\Dev\\Projects\\JavaFX\\test\\src\\main\\java\\com\\example\\test\\PizzaSlice.jpg");
            ImageView imageView = new ImageView(image);
            imageView.setX(400);
            imageView.setY(400);


            // add Objects to the scene
            groupOfNodes.getChildren().addAll(text,line,rectangle,triangle,circle);

            // set and show the scene
            frame.setScene(scene);
            frame.show();
        }
    }
