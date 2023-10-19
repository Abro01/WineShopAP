package utilities;

//costanti per la comunicazione tra server e client
public class Costanti {
    public static final int AddWine = 0;
    public static final int UpdateWine = 1;
    public static final int DeleteWine = 2;
    public static final int getViniDisponibili = 3;
    public static final int getWineByID = 4;
    public static final int CercaVino = 5;
    public static final int AddRecensioneVino = 6;
    public static final int getRecensioneVino = 7;
    public static final int AddCarrello = 8;
    public static final int RimuoviCarrello = 9;
    public static final int getCarrello = 10;
    public static final int PlaceOrder = 11;
    public static final int getCronologiaOrdini = 12;
    public static final int UpdateAccount = 13;
    public static final int getAccount = 14;
    public static final int Login = 15;
    public static final int Logout = 16;
    public static final int Registrazione = 17;
    public static final int AddOfferta = 18;
    public static final int RimuoviOfferta = 19;
    public static final int MostraOfferta = 20;
    public static final int SpedizioneOrdine = 21;
    public static final int MostraOrdini = 22;
    public static final int MostraViniDaRifornire = 23;
    public static final int RifornireVino = 24;
    public static final int CompraVino = 25;
    public static final int getOnlineVenditori = 26;
    public static final int VendiVino = 27;
    public static final int MostraOrdiniClienti = 28;
    public static final int getNomiVini = 29;
    public static final int AddVinoPreferito = 30;
    public static final int getVinoPreferito = 31;
    public static final int Successo = 200;
    public static final int Fallimento = 201;
    public static final int RichiestaErrata = 400;
    public static final int ErroriServer = 500;
    public static final int NoRighe = 998;
    public static final int Cambi = 6990;
    /**
     * Request was unsuccessful the connection is closed.
     */
    public static int CloseConnessione = 999;
}
