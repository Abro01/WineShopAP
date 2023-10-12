package server;

public class VariabiliServer {
    public static final String IndirizzoDB = "localhost";
    public static final String NomeDB = "wine_shop";
    public static final int PortaDB = 3306;
    public static final String UserDB = "root";
    public static final String PasswordDB = "";

    //tempo dopo aver eseguito una dinamica di controllo per gestire i prezzi dei vini
    public static final long TempoAggiornoPrezzo= 1000 * 60 * 60 * 24;

    //tempo dopo che è stata eseguita una dinamica di controllo per verificare le date degli assegnamenti
    public static final long TempoAggiornoAssegnamento = 1000 * 60 * 60;

    //tempo trascorso dopo che è stata eseguita una dinamica di controllo per verificare la soglia del vino
    public static final long TempoControlloSoglia = 1000 * 60 * 10;

    //dopo un tot di tempo l'ordine verrà assegnato a un altro dipendente
    public final static int GiornoDopoRiassegnazione = 1;

    //percentuale utilizzata per aumentare il prezzo del vino più venduto durante il controllo
    public final static int PercentualeAumentoPrezzo = 5;

    //percentuale utilizzata per diminuire il prezzo del vino più venduto durante il controllo
    public final static int PercentualediminuzionePrezzo = 5;

    //prezzo massimo per un vino
    public final static double PrezzoMassimo = 250.0;

    //calcolo del più e meno vino venduto sarà calcolato tra oggi e (oggi - GiornoControlloPrezzoDinamico) giorni prima
    public final static int GiornoControlloPrezzoDinamico = 10;

    //quantita minima di soglia da ricomprare quando la quantita del vino non è sufficiente
    public final static int QuantitaMinima = 5;

    //numero bottiglie caso minore
    public final static int CasoMinore = 6;

    //numero bottiglie caso maggiore
    public final static int CasoMaggiore = 12;

    //sconto dopo l'acquisto di più vini dello stesso tipo in un singolo caso minore
    public final static int ScontoCasoMinore1 = 5;

    //sconto dopo l'acquisto di più vini dello stesso tipo in un singolo caso maggiore
    public final static int ScontoCasoMaggiore1 = 10;

    //sconto dopo l'acquisto di più vini dello stesso tipo in più casi minori
    public final static int ScontoCasoMinore2 = 2;

    //sconto dopo l'acquisto di più vini dello stesso tipo in più casi maggiori
    public final static int ScontoCasoMaggiore2 = 3;

    //numero di threads allocati pronti a rispondere al client
    public static final int ThreadsMassimi = 100;

    public static final long TempoInattivita = 5000;

    //porta che aspetta la richiesta
    public static final int Porta = 1234;

    //anni dopo che la password deve essere cambiata
    public static final int AnnoCambioPass = 1;
}
