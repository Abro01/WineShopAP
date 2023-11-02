package wineshop.client;

import utilities.Costanti;
import utilities.Response;
import model.Utenti;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class LoginController {
    private RequestController requestController;
    private Utenti UtenteLoggato;
    @FXML
    private Button Login_BtnLogin;

    @FXML
    private Button Login_BtnReg;

    @FXML
    private Hyperlink Login_Link;

    @FXML
    private CheckBox Login_Mostra;

    @FXML
    private PasswordField Login_Password;

    @FXML
    private TextField Login_Username;

    @FXML
    private TextField Login_MostraPassword;

    @FXML
    private Label lblLogin;

    public void setRequestController(RequestController controller) {
        this.requestController = controller;
    }

    public void setUtenteLoggato(Utenti utente) {
        this.UtenteLoggato = utente;
    }

    public void OnLogin_Login_BtnLogin(ActionEvent event) throws Exception {
        String username = this.Login_Username.getText();
        String password = this.Login_Password.getText();
        this.lblLogin.setText("");

        Response r  = this.requestController.makeRequest(Costanti.Login, new Utenti(username, password));

        System.out.println("Valore status code: " + r);

        if (r.getStatusCode() == Costanti.Successo)
        {
            System.out.println("Login avvenuto con successo");
            UtenteLoggato = (Utenti) r.getPayload();
        }else {
            System.out.println("Login fallito");
            this.lblLogin.setText("Login fallito");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Errore di login");
            alert.setHeaderText(null);
            alert.setContentText("L'utente potrebbe non essere registrato nel sistema");
            alert.showAndWait();
            Login_Username.setText("");
            Login_Password.setText("");
        }

        if(r.getStatusCode() == Costanti.Successo)
        {
            String gui = "";
            UtenteLoggato = (Utenti) r.getPayload();

            if (Objects.equals(UtenteLoggato.getTipo(), "cliente")) {
                gui = "HomeCliente.fxml";
            } else if (Objects.equals(UtenteLoggato.getTipo(), "amministratore")) {
                gui = "HomeAmministratore.fxml";
            } else if (Objects.equals(UtenteLoggato.getTipo(), "impiegato")) {
                gui = "HomeImpiegato.fxml";
            }

            FXMLLoader loader = new FXMLLoader(getClass().getResource(gui));
            Parent guiToShow = loader.load();
            Object controller = loader.getController();
            Scene scene = new Scene(guiToShow);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            if (Objects.equals(UtenteLoggato.getTipo(), "cliente"))
            {
                ((HomeClienteController) controller).setRequestController(this.requestController);
                ((HomeClienteController) controller).setUtenteLoggato(UtenteLoggato);
            } else if (Objects.equals(UtenteLoggato.getTipo(), "amministratore"))
            {
                ((HomeAdminController) controller).setRequestController(this.requestController);
                ((HomeAdminController) controller).setUtenteLoggato(UtenteLoggato);
            } else if (Objects.equals(UtenteLoggato.getTipo(), "impiegato"))
            {
                ((HomeImpiegatoController) controller).setRequestController(this.requestController);
                ((HomeImpiegatoController) controller).setUtenteLoggato(UtenteLoggato);
            }

            stage.setTitle(UtenteLoggato.getUsername().toUpperCase() + " - " + UtenteLoggato.getTipo().toUpperCase() + " - WineShop");
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();

            if (Objects.equals(UtenteLoggato.getTipo(), "cliente"))
            {
                ((HomeClienteController) controller).initialize();
            } else if (Objects.equals(UtenteLoggato.getTipo(), "amministratore"))
            {
                ((HomeAdminController) controller).initialize();
            } else if (r.getStatusCode() == Costanti.RichiestaErrata)
            {
                this.lblLogin.setText("Username e/o password errati");
            } else if (r.getStatusCode() == Costanti.ErroriServer)
            {
                this.lblLogin.setText("Server error");
            }
        }
    }
    public void OnLogin_BtnRegClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Registrazione.fxml"));
        Parent RegGui = loader.load();
        Object controller = loader.getController();
        Scene scene = new Scene(RegGui, 346, 600);
        ((RegistrazioneController) controller).setRequestController(this.requestController);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
    public void OnLogin_LinkClick(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AggiornaPassword.fxml"));
        Parent AggPassGui = loader.load();
        Object controller = loader.getController();
        Scene scene = new Scene(AggPassGui, 346, 600);
        ((AggiornaController) controller).setRequestController(this.requestController);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    public void OnLogin_MostraClick() {
        if (Login_Mostra.isSelected()) {
            Login_MostraPassword.setText(Login_Password.getText());
            Login_MostraPassword.setVisible(true);
            Login_Password.setVisible(false);
        } else {
            Login_MostraPassword.setText(Login_Password.getText());
            Login_MostraPassword.setVisible(false);
            Login_Password.setVisible(true);
        }
    }
}