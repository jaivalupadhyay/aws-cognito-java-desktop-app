package com.amazonaws.sample.cognitoui;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import com.amazonaws.services.cognitoidentity.model.Credentials;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import org.json.JSONObject;


public class MainForm extends Application {

    public static void main(String[] args) {
        launch(args);
    }


    static void ShowUserBuckets(Credentials credentails) {

        CognitoHelper helper = new CognitoHelper();
        String message = helper.ListBucketsForUser(credentails);

        BucketListForm.display("Cognito -  Returned Credentials", message);

    }
    @Override
    public void start(Stage primaryStage) throws URISyntaxException, IOException {

        CognitoHelper helper = new CognitoHelper();


        if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
            Desktop.getDesktop().browse(new URI(helper.GetHostedSignInURL()));
        }
//
    }


}
