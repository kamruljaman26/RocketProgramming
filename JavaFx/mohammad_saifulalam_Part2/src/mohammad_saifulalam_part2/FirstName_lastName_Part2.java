package mohammad_saifulalam_part2;

import java.util.Random;
import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.PathTransition;
import javafx.animation.PathTransition.OrientationType;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class FirstName_lastName_Part2 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        // here we set images for our app background
        Image backimg =
                new Image("https://images.unsplash.com/photo-1553095066-5014bc7b7f2d?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8d2FsbCUyMGJhY2tncm91bmR8ZW58MHx8MHx8&w=1000&q=80");
        // here we set images for useing imagesview class
        Image imageVImage =
                new Image("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRw4Xaf0afxbWT0zXRo6apRDS4y8jJPcM0dWg&usqp=CAU");

        // Here we use  At list three method of imageView 
        ImageView imageView = new ImageView();
        imageView.setImage(imageVImage);
        imageView.setX(10);
        imageView.setY(10);
        imageView.setFitWidth(100);
        imageView.setPreserveRatio(true);

        GridPane gridPane = new GridPane();
        Polygon polygon = getPolygon();
        Circle circle = getCircle();
        Rectangle rectangle = getRectangle();

        // here we set poligon and image and circle shape .
        gridPane.addRow(0, imageView);
        gridPane.addRow(1, polygon);
        gridPane.addRow(2, circle);
        gridPane.addRow(3, rectangle);
        gridPane.setAlignment(Pos.CENTER);

        // here we set background image for javafx application 
        BackgroundImage bImg = new BackgroundImage(backimg,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);

        Background bGround = new Background(bImg);
        BorderPane borderPane = new BorderPane();
        borderPane.setBackground(bGround);
        borderPane.setCenter(gridPane);

        Scene scene = new Scene(borderPane, 400, 600);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    // By get Polygon method we create 8 side polygon
    public Polygon getPolygon() {

        Polygon polygon = new Polygon();
        polygon.getPoints().addAll(new Double[]{
            200.0, 50.0,
            400.0, 50.0,
            450.0, 150.0,
            400.0, 250.0,
            200.0, 250.0,
            150.0, 150.0,
            300.0, 100.0,
            200.0, 250.0,});

        polygon.setStroke(Color.WHITE);
        polygon.setFill(Color.BLUE);

        // here we use fadetransition to fade the polygon 
        FadeTransition fade = new FadeTransition();
        fade.setDuration(Duration.millis(5000));
        fade.setFromValue(10);
        fade.setToValue(0.1);
        fade.setCycleCount(1000);
        fade.setAutoReverse(true);
        fade.setNode(polygon);
        fade.play();

        return polygon;

    }

    // By het circle method we get circle shape
    public Circle getCircle() {

        Circle cir = new Circle(250, 120, 80);
        cir.setFill(Color.RED);
        cir.setStroke(Color.BLACK);

        // here we use path transition in  circle shape as a path 
        Path path = new Path();
        path.getElements().add(new MoveTo(150f, 70f));
        path.getElements().add(new CubicCurveTo(240f, 230f, 500f, 340f, 600, 50f));

        // here we use path transition class 
        PathTransition pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.millis(1000));
        pathTransition.setNode(cir);
        pathTransition.setPath(path);
        pathTransition.setOrientation(OrientationType.ORTHOGONAL_TO_TANGENT);
        pathTransition.setCycleCount(10);
        pathTransition.setAutoReverse(true);
        pathTransition.play();

        return cir;

    }

    // By get Rectangle  method to see every one sec its color changed
    public Rectangle getRectangle() {
        Rectangle rect = new Rectangle(100, 40, 100, 100);
        rect.setArcHeight(50);
        rect.setArcWidth(50);
        rect.setFill(Color.BLUE);
        Color[] palette = new Color[]{Color.RED, Color.BLUE, Color.ORANGE};
        Random rng = new Random();

        // here we use Timeline class 
        Timeline tt1 = new Timeline(
                new KeyFrame(
                        Duration.millis(1000),
                        e -> rect.setFill(palette[rng.nextInt(palette.length)]),
                        new KeyValue(rect.yProperty(), 1040)
                )
        );

        tt1.setCycleCount(Animation.INDEFINITE);
        tt1.setAutoReverse(false);
        tt1.play();

        return rect;
    }
}
