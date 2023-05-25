package lk.ijse.dep10;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.InnerShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.apache.commons.io.FilenameUtils;

import java.io.File;

public class AppInitializer extends Application {
    private SimpleBooleanProperty isMute = new SimpleBooleanProperty(false);

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        mainScene(primaryStage);
        primaryStage.setTitle("Media Player");
        primaryStage.centerOnScreen();
        primaryStage.show();

    }

    private void mainScene(Stage stage) {
        Button btnOpen = new Button("OPEN");
        btnOpen.setPrefWidth(80);
        btnOpen.setPrefHeight(20);

        Label lblDisplayMediaName = new Label();
        lblDisplayMediaName.setPrefWidth(250);
        lblDisplayMediaName.setPrefHeight(25);
        lblDisplayMediaName.setBorder(Border.stroke(Color.BLACK));
        lblDisplayMediaName.setTextFill(Color.BLACK);
        lblDisplayMediaName.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        lblDisplayMediaName.setFont(new Font(10));

        HBox hBox1 = new HBox(btnOpen, lblDisplayMediaName);
        hBox1.setPadding(new Insets(20));
        hBox1.setSpacing(20);
        hBox1.setPrefWidth(350);
        hBox1.setPrefHeight(100);
        hBox1.setAlignment(Pos.CENTER);

        Button btnPlay = new Button();
        ImageView imgPlay = new ImageView();
        Image imagePlay = new Image(this.getClass().getResource("/img/101play.png").toString());
        imgPlay.setImage(imagePlay);
        imgPlay.setFitWidth(50);
        imgPlay.setFitHeight(50);
        btnPlay.setGraphic(imgPlay);
        btnPlay.setCursor(Cursor.HAND);
        btnPlay.setTooltip(new Tooltip("Play"));
        btnPlay.setOnMouseEntered(event -> {
            imgPlay.setOpacity(0.8);
            btnPlay.setBorder(Border.stroke(Color.RED));
            btnPlay.setPrefWidth(52);
            btnPlay.setPrefHeight(52);
        });
        btnPlay.setOnMouseExited(event -> {
            imgPlay.setOpacity(1);
            btnPlay.setBorder(Border.stroke(Color.BLACK));
            btnPlay.setPrefWidth(50);
            btnPlay.setPrefHeight(50);
        });
        btnPlay.setOnMousePressed(event -> imgPlay.setEffect(new InnerShadow(10, Color.BLACK)));
        btnPlay.setBorder(Border.stroke(Color.BLUE));
        btnPlay.setPrefWidth(50);
        btnPlay.setPrefHeight(50);

        Button btnPause = new Button();
        ImageView imgPause = new ImageView();
        Image imagePause = new Image(this.getClass().getResource("/img/101pause.png").toString());
        imgPause.setImage(imagePause);
        imgPause.setFitWidth(50);
        imgPause.setFitHeight(50);
        btnPause.setGraphic(imgPause);
        btnPause.setCursor(Cursor.HAND);
        btnPause.setTooltip(new Tooltip("Pause"));
        btnPause.setOnMouseEntered(event -> {
            imgPause.setOpacity(0.8);
            btnPause.setBorder(Border.stroke(Color.RED));
            btnPause.setPrefWidth(52);
            btnPause.setPrefHeight(52);

        });
        btnPause.setOnMouseExited(event -> {
            imgPause.setOpacity(1);
            btnPause.setBorder(Border.stroke(Color.BLACK));
            btnPause.setPrefWidth(50);
            btnPause.setPrefHeight(50);
        });
        btnPause.setOnMousePressed(event -> imgPause.setEffect(new InnerShadow(10, Color.BLACK)));
        btnPause.setBorder(Border.stroke(Color.BLUE));
        btnPause.setPrefWidth(50);
        btnPause.setPrefHeight(50);

        Button btnStop = new Button();
        ImageView imgStop = new ImageView();
        Image imageStop = new Image(this.getClass().getResource("/img/101stop.png").toString());
        imgStop.setImage(imageStop);
        imgStop.setFitWidth(50);
        imgStop.setFitHeight(50);
        btnStop.setGraphic(imgStop);
        btnStop.setCursor(Cursor.HAND);
        btnStop.setTooltip(new Tooltip("Stop"));
        btnStop.setOnMouseEntered(event -> {
            imgStop.setOpacity(0.8);
            btnStop.setBorder(Border.stroke(Color.RED));
            btnStop.setPrefWidth(52);
            btnStop.setPrefHeight(52);
        });
        btnStop.setOnMouseExited(event -> {
            imgStop.setOpacity(1);
            btnStop.setBorder(Border.stroke(Color.BLACK));
            btnStop.setPrefWidth(50);
            btnStop.setPrefHeight(50);
        });
        btnStop.setOnMousePressed(event -> imgStop.setEffect(new InnerShadow(10, Color.BLACK)));
        btnStop.setBorder(Border.stroke(Color.BLUE));
        btnStop.setPrefWidth(50);
        btnStop.setPrefHeight(50);

        Button btnLoop = new Button();
        ImageView imgLoop = new ImageView();
        Image imageLoop = new Image(this.getClass().getResource("/img/101loop.png").toString());
        imgLoop.setImage(imageLoop);
        imgLoop.setFitWidth(50);
        imgLoop.setFitHeight(50);
        btnLoop.setGraphic(imgLoop);
        btnLoop.setCursor(Cursor.HAND);
        btnLoop.setTooltip(new Tooltip("Repeat"));
        btnLoop.setOnMouseEntered(event -> {
            imgLoop.setOpacity(0.8);
            btnLoop.setBorder(Border.stroke(Color.RED));
            btnLoop.setPrefWidth(52);
            btnLoop.setPrefHeight(52);
        });
        btnLoop.setOnMouseExited(event -> {
            imgLoop.setOpacity(1);
            btnLoop.setBorder(Border.stroke(Color.BLACK));
            btnLoop.setPrefWidth(50);
            btnLoop.setPrefHeight(50);
        });
        btnLoop.setOnMousePressed(event -> imgLoop.setEffect(new InnerShadow(10, Color.BLACK)));
        btnLoop.setBorder(Border.stroke(Color.BLUE));
        btnLoop.setPrefWidth(50);
        btnLoop.setPrefHeight(50);

        HBox hBox2 = new HBox(btnPlay, btnPause, btnStop, btnLoop);
        hBox2.setPrefWidth(300);
        hBox2.setPrefHeight(50);
        hBox2.setSpacing(20);
        hBox2.setAlignment(Pos.CENTER);
        hBox2.setPadding(new Insets(20));

        Label lblTime = new Label("Time :");
        lblTime.setTextFill(Color.WHITE);
        lblTime.setPrefWidth(80);

        Label lblTimeNumber = new Label();
        lblTimeNumber.setPrefWidth(80);
        lblTimeNumber.setTextFill(Color.WHITE);

        Button btnSpeaker = new Button();
        btnSpeaker.setBackground(Background.fill(Color.TRANSPARENT));
        ImageView imgSpeaker = new ImageView();
        Image imageSpeaker = new Image(this.getClass().getResource("/img/101sound.png").toString());
        imgSpeaker.setImage(imageSpeaker);
        imgSpeaker.setFitWidth(25);
        imgSpeaker.setFitHeight(25);
        btnSpeaker.setGraphic(imgSpeaker);
        btnSpeaker.setTooltip(new Tooltip("Sound"));
        btnSpeaker.setPrefHeight(25);
        btnSpeaker.setPrefWidth(25);

        Slider slider = new Slider(0, 1, 0.7);
        slider.setMaxWidth(Double.MAX_VALUE);

        HBox hBox3 = new HBox(lblTime, lblTimeNumber, btnSpeaker, slider);
        hBox3.setPrefWidth(250);
        hBox3.setPrefHeight(100);
        hBox3.setSpacing(5);
        hBox3.setPadding(new Insets(20));

        Image imgBackground = new Image("https://www.teahub.io/photos/full/105-1054627_musical-background.jpg");
        BackgroundImage bImg = new BackgroundImage(imgBackground,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        Background bGround = new Background(bImg);

        VBox root = new VBox(hBox1, hBox2, hBox3);
        root.setAlignment(Pos.CENTER);
        root.setSpacing(10);
        root.setPadding(new Insets(10));
        root.setBackground(bGround);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setMaxWidth(600);
        stage.setMaxHeight(800);

        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("MP3 File", "*.mp3"));

        btnOpen.setOnAction(e -> {

            File selectedFile = fileChooser.showOpenDialog(stage);

            if (selectedFile != null) {
                btnStop.fire();

                String fileExtension = FilenameUtils.getExtension(selectedFile.getAbsolutePath()); // returns "txt"

                if (fileExtension.equals("mp3")) {

                    lblDisplayMediaName.setText(selectedFile.getName());
                    Media media = new Media(new File(selectedFile.getAbsolutePath()).toURI().toString());
                    MediaPlayer player = new MediaPlayer(media);

                    player.play();


                    KeyFrame key1 = new KeyFrame(Duration.seconds(1), event -> {

                        lblTimeNumber.setText(String.valueOf(player.getCurrentTime().toMinutes()));
                    });

                    Timeline timeline = new Timeline(key1);
                    timeline.setCycleCount(Animation.INDEFINITE);
                    timeline.play();


                    player.volumeProperty().bind(slider.valueProperty());
                    player.muteProperty().bind(isMute);

                    btnStop.setOnAction(mouseEvent -> {

                        if (player != null) {

                            System.out.println("Stopped");
                            System.out.println(player);
                            player.stop();
                            timeline.stop();


                        }
                    });

                    btnPlay.setOnMouseClicked(mouseEvent -> {

                        if (player == null) return;

                        if (player.getStatus() == MediaPlayer.Status.PLAYING) {
                            player.pause();

                        } else {
                            player.play();

                        }
                    });

                    btnPause.setOnMouseClicked(mouseEvent -> {

                        if (player == null) return;

                        if (player.getStatus() == MediaPlayer.Status.PLAYING) {
                            player.pause();

                        } else {
                            player.play();

                        }
                    });

                    btnLoop.setOnMouseClicked(mouseEvent -> {
                        if (player == null) return;

                        if (player.getStatus() == MediaPlayer.Status.PLAYING) {
                            player.seek(Duration.seconds(0));

                        }

                    });
                }

            }
        });

        root.setOnDragOver(event -> {
            try {

                event.acceptTransferModes(TransferMode.ANY);

            } catch (NullPointerException e) {
                e.printStackTrace();
            }
        });
        root.setOnDragDropped(event -> {
            try {
                File droppedFile = event.getDragboard().getFiles().get(0);
                btnStop.fire();
                String fileextension = FilenameUtils.getExtension(droppedFile.getAbsolutePath()); // returns "txt"
                if (fileextension.equals("mp3")) {

                    lblDisplayMediaName.setText(droppedFile.getName());
                    Media media = new Media(new File(droppedFile.getAbsolutePath()).toURI().toString());
                    MediaPlayer player = new MediaPlayer(media);
                    player.play();


                    KeyFrame key1 = new KeyFrame(Duration.seconds(1), event1 -> {
                        lblTimeNumber.setText(String.valueOf(player.getCurrentTime().toMinutes()));
                    });

                    Timeline timeline = new Timeline(key1);
                    timeline.setCycleCount(Animation.INDEFINITE);

                    timeline.play();


                    player.volumeProperty().bind(slider.valueProperty().add(0.3));

                    player.muteProperty().bind(isMute);

                    btnStop.setOnAction(mouseEvent -> {

                        if (player != null) {

                            System.out.println("Stopped");
                            System.out.println(player);
                            player.stop();
                            timeline.stop();


                        }
                    });

                    btnPlay.setOnMouseClicked(mouseEvent -> {

                        if (player == null) return;

                        if (player.getStatus() == MediaPlayer.Status.PLAYING) {
                            player.pause();

                        } else {
                            player.play();

                        }
                    });

                    btnPause.setOnMouseClicked(mouseEvent -> {

                        if (player == null) return;

                        if (player.getStatus() == MediaPlayer.Status.PLAYING) {
                            player.pause();

                        } else {
                            player.play();

                        }
                    });

                    btnLoop.setOnMouseClicked(mouseEvent -> {
                        if (player == null) return;

                        if (player.getStatus() == MediaPlayer.Status.PLAYING) {
                            player.seek(Duration.seconds(0));

                        }

                    });
                } else {
                    new Alert(Alert.AlertType.ERROR, "This is not a .mp3 file").showAndWait();
                }

            } catch (NullPointerException e) {
                e.printStackTrace();
            }
        });


    }
}
