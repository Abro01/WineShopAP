package utilities;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;

@SuppressWarnings("RisultatoDelMetodoChiamataIgnorata")
public class Log {
    private static final String Path_Base = "C:/Users/andre/OneDrive/Documenti/GitHub/WineShopAP/WineShopAP/log/";

    private static final String Estensione = "log";

    private static void checkDir()
    {
        try {
            if(!Files.exists(Paths.get(Path_Base.substring(0,Path_Base.length() - 1))))
            {
                new File(Path_Base.substring(0, Path_Base.length() - 1)).mkdirs();
            }
        }catch (Exception e)
        {
            System.err.println("Errore checkDir");
            e.printStackTrace();
        }
    }
    public static void ScritturaVerboServer(String s)
    {
        checkDir();
        try {
            File f = new File(Path_Base + "ServerVerb." + Estensione);
            f.createNewFile();
            FileWriter fw = new FileWriter(f, true);
            fw.write(new Date() + ": " + s + "\n");
            fw.close();
        }catch (IOException e)
        {
            System.err.println("Errore scrittura ServerVerb");
            e.printStackTrace();
        }
    }

    public static void ScritturaVerboClient(String s)
    {
        checkDir();
        try {
            File f = new File(Path_Base + "ClientVerb." + Estensione);
            f.createNewFile();
            FileWriter fw = new FileWriter(f, true);
            fw.write(new Date() + ": " + s + "\n");
            fw.close();
        }catch (IOException e)
        {
            System.err.println("Errore scrittura ClientVerb");
            e.printStackTrace();
        }
    }

    public static void ScritturaErroriServer(String s)
    {
        checkDir();
        try {
            File f = new File(Path_Base + "ErroriServer." + Estensione);
            f.createNewFile();
            FileWriter fw = new FileWriter(f, true);
            fw.write(new Date() + ": " + s + "\n");
            fw.close();
        }catch (IOException e)
        {
            System.err.println("Errore: ScritturaErroriServer");
            e.printStackTrace();
        }
    }

    public static void ScritturaErroriClient(String s)
    {
        checkDir();
        try {
            File f = new File(Path_Base + "ErroriClient." + Estensione);
            f.createNewFile();
            FileWriter fw = new FileWriter(f, true);
            fw.write(new Date() + ": " + s + "\n");
            fw.close();
        }catch (IOException e)
        {
            System.err.println("Errore: ScritturaErroriClient");
            e.printStackTrace();
        }
    }
}
