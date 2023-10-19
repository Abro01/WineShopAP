package wineshop.client;

import utilities.Costanti;
import utilities.Response;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

/**
 * Is the controller for the Login gui, contains all the handlers
 * that manage all the javafx components
 *
 * @author Riccardo Versetti, Rocco Carpi
 */
public class LoginGuiController {
    private RequestController requestController;
    private Impiegati_Amministratori loggedUser;

    @FXML
    private TextField txtUsername;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private Label lblStatus;

    /**
     * it sets the request controller
     *
     * @param controller the request controller reference
     */
    public void setRequestController(RequestController controller) {
        this.requestController = controller;
    }

    /**
     * it sets the logged user
     *
     * @param user the user that is logged
     */
    public void setLoggedUser(Impiegati_Amministratori user) {
        this.loggedUser = user;
    }

    /**
     * Handles the click of the login button
     *
     * @param event the click event
     * @throws Exception exception
     */
    public void OnBtnLoginClick(ActionEvent event) throws Exception {
        String username = this.txtUsername.getText();
        String password = this.txtPassword.getText();
        this.lblStatus.setText("");

        Response r = this.requestController.makeRequest(Costanti.LoginAmministratore, new Impiegati_Amministratori(username, password));

        if (r.getStatusCode() == Costanti.Successo) {
            System.out.println("Login successfull");
            loggedUser = (Impiegati_Amministratori) r.getPayload(); // assign the user credentials
        } else {
            System.out.println("Login failed");
            this.lblStatus.setText("Login failed");
            txtUsername.setText("");
            txtPassword.setText("");
        }

        if (r.getStatusCode() == Costanti.Successo) {
            // now check the user role and show the correct gui
            String gui = "";
            loggedUser = (Impiegati_Amministratori) r.getPayload();

            // check which gui to show
            if (Objects.equals(loggedUser.getUserType(), "customer")) gui = "HomeCustomerGui.fxml";
            else if (Objects.equals(loggedUser.getUserType(), "vendor")) gui = "HomeVendorGui.fxml";
            else if (Objects.equals(loggedUser.getUserType(), "admin")) gui = "HomeAdminGui.fxml";

            FXMLLoader loader = new FXMLLoader(getClass().getResource(gui));
            Parent guiToShow = loader.load();
            Object controller = loader.getController();
            Scene scene = new Scene(guiToShow);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // set the request controller and the logged user
            if (Objects.equals(loggedUser.getUserType(), "customer")) {
                // customer case
                ((HomeCustomerGuiController) controller).setRequestController(this.requestController);
                ((HomeCustomerGuiController) controller).setLoggedUser(loggedUser);
            } else if (Objects.equals(loggedUser.getUserType(), "vendor")) {
                // vendor case
                ((HomeVendorGuiController) controller).setRequestController(this.requestController);
                ((HomeVendorGuiController) controller).setLoggedUser(loggedUser);
            }
            stage.setTitle(loggedUser.getUsername().toUpperCase() + " - " + loggedUser.getUserType().toUpperCase() + " - WineDemo");
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();

            if (loggedUser.getUserType().equals("customer")) ((HomeCustomerGuiController) controller).initialize();
            else if (loggedUser.getUserType().equals("vendor")) ((HomeVendorGuiController) controller).initialize();
        } else if (r.getStatusCode() == Constants.BAD_REQUEST) {
            this.lblStatus.setText("Wrong username or password!");
        } else if (r.getStatusCode() == Constants.INTERNAL_SERVER_ERROR) {
            this.lblStatus.setText("Server error!");
        }
    }

    /**
     * Handles the click of the sign up button and shows the sign up gui
     *
     * @param event the click event
     * @throws IOException if the gui is not found
     */
    public void OnBtnSignINClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("SignInGui.fxml"));
        Parent userGui = loader.load();
        Object controller = loader.getController();
        Scene scene = new Scene(userGui);
        ((SignINController) controller).setRequestController(this.requestController);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
}
