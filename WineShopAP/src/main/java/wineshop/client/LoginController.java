package wineshop.client;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.Utenti;
import utilities.Costanti;
import utilities.Response;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.Objects;

public class LoginController {
    //@FXML
    //private Button Login_BtnLogin;

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

    private RequestController requestController;
    private Utenti UtenteLoggato;

    public void setRequestController(RequestController controller) {
        this.requestController = controller;
    }

    public void setUtenteLoggato(Utenti utente) {
        UtenteLoggato = utente;
    }

    /*public void OnLogin_BtnRegClick(ActionEvent event) throws Exception {
        String username = this.Login_Username.getText();
        String password = this.Login_Password.getText();

        Response r = this.requestController.makeRequest(Costanti.Login, new Utenti(username, password));

        if (r.getStatusCode() == Costanti.Successo)
        {
            System.out.println("Login avvenuto con successo");
            UtenteLoggato = (Utenti) r.getPayload();
        }else {
            System.out.println("Login fallito");
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

            if (Objects.equals(UtenteLoggato.getTipo(), "cliente"))
            {
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
                /*((HomeCustomerGuiController) controller).setRequestController(this.requestController);
                ((HomeCustomerGuiController) controller).setLoggedUser(loggedUser);
            } else if (Objects.equals(UtenteLoggato.getTipo(), "amministratore"))
            {
                /*((HomeVendorGuiController) controller).setRequestController(this.requestController);
                ((HomeVendorGuiController) controller).setLoggedUser(loggedUser);
            }

            stage.setTitle(UtenteLoggato.getUsername().toUpperCase() + " - " + UtenteLoggato.getTipo().toUpperCase() + " - WineShop");
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();

            if (Objects.equals(UtenteLoggato.getTipo(), "cliente"))
            {
                //((HomeCustomerGuiController) controller).initialize();
            } else if (Objects.equals(UtenteLoggato.getTipo(), "amministratore"))
            {
                //((HomeVendorGuiController) controller).initialize();
            } else if (r.getStatusCode() == Costanti.RichiestaErrata)
            {
                return;
            } else if (r.getStatusCode() == Costanti.ErroriServer)
            {
                return;
            }
        }
    }

    public void OnLogin_BtnRegClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Registrazione.fxml"));
        Parent userGui = loader.load();
        Object controller = loader.getController();
        Scene scene = new Scene(userGui);
        ((RegistrazioneController) controller).setRequestController(this.requestController);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }*/
}