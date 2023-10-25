package wineshop.client;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import utilities.Costanti;
import utilities.Response;
import model.Utenti;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.Objects;
public class AggiornaController {
    @FXML
    private Button CambioPass_Btn;

    @FXML
    private Button CambioPass_BtnIndietro;

    @FXML
    private PasswordField CambioPass_ConfPass;

    @FXML
    private CheckBox CambioPass_Mostra;

    @FXML
    private PasswordField CambioPass_Password;

    @FXML
    private TextField CambioPass_Username;

    @FXML
    private TextField CambioPass_MostraConfPass;

    @FXML
    private TextField CambioPass_MostraPassword;

    private RequestController requestController;

    public void setRequestController(RequestController controller) {
        this.requestController = controller;
    }

    public void OnCambioPass_BtnIndietroClick(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
        Parent LogGui = loader.load();
        Object controller = loader.getController();
        Scene scene = new Scene(LogGui, 346, 600);
        ((LoginController) controller).setRequestController(this.requestController);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    public void OnCambioPass_MostraClick(){
        if(CambioPass_Mostra.isSelected())
        {
            CambioPass_MostraPassword.setText(CambioPass_Password.getText());
            CambioPass_MostraPassword.setVisible(true);
            CambioPass_Password.setVisible(false);

            CambioPass_MostraConfPass.setText(CambioPass_ConfPass.getText());
            CambioPass_MostraConfPass.setVisible(true);
            CambioPass_ConfPass.setVisible(false);
        } else {
            CambioPass_Password.setText(CambioPass_MostraPassword.getText());
            CambioPass_MostraPassword.setVisible(false);
            CambioPass_Password.setVisible(true);

            CambioPass_ConfPass.setText(CambioPass_MostraConfPass.getText());
            CambioPass_MostraConfPass.setVisible(false);
            CambioPass_ConfPass.setVisible(true);
        }
    }
}
