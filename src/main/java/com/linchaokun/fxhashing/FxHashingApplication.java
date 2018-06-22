package com.linchaokun.fxhashing;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by linchaokun on 2018/6/20.
 */
public class FxHashingApplication extends Application{
    private static Stage primaryStage;

    public static Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        primaryStage.setScene(new Scene(loadFxml(),500,300));
        primaryStage.setTitle("MD5文件Hash值计算----By:埖落一笑");
        primaryStage.show();
    }


    private Parent loadFxml() throws IOException {
        return FXMLLoader.load(
                getClass().getResource("/fxml/main.fxml")
        );
    }
}
