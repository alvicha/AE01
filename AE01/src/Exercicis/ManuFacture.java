package Exercicis;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ManuFacture {
    private ArrayList<String> listaPecesFabricades = new ArrayList<String>();

    /**
     * Constructor de ManuFacture
     *
     * @param cantidadI Cantidad de peces del tipus I a fabricar.
     * @param cantidadO Cantidad de peces del tipus O a fabricar.
     * @param cantidadT Cantidad de peces del tipus T a fabricar.
     * @param cantidadJ Cantidad de peces del tipus J a fabricar.
     * @param cantidadL Cantidad de peces del tipus L a fabricar.
     * @param cantidadS Cantidad de peces del tipus S a fabricar.
     * @param cantidadZ Cantidad de peces del tipus Z a fabricar.
     */
    public ManuFacture(int cantidadI, int cantidadO, int cantidadT, int cantidadJ, int cantidadL, int cantidadS,
                       int cantidadZ) {
        fabricarPeces("I", cantidadI);
        fabricarPeces("O", cantidadO);
        fabricarPeces("T", cantidadT);
        fabricarPeces("J", cantidadJ);
        fabricarPeces("L", cantidadL);
        fabricarPeces("S", cantidadS);
        fabricarPeces("Z", cantidadZ);
    }

    /**
     * Inicia el proceso de fabricación de las peces del tipus especificat amb la
     * cantidad donada.
     *
     * @param tipus     Tipus de la peca a fabricar.
     * @param quantitat Cantidad de peces a fabricar del tipus especificat.
     */
    public void fabricarPeces(String tipus, int quantitat) {
        int numMaquines = 8;
        ExecutorService executor = Executors.newFixedThreadPool(numMaquines);
        for (int i = 0; i < quantitat; i++) {
            Peca peca = new Peca(tipus, listaPecesFabricades);
            executor.execute(peca);
        }

        executor.shutdown();
        while (!executor.isTerminated()) {
        }
    }

    /**
     * Escritura de las peces fabricades en un archivo.
     *
     * @param arxiu Nombre del archivo donde se escribiran las peces fabricadas. Si el nombre es
     *              vacío, se genera un archivo con el nombre "LOG_YYYYMMDD_HHmmss.txt"
     *              basado en la data y hora actuales.
     */
    public void escriureArxiu(String arxiu) {
        File file;
        if (arxiu.isEmpty()) {
            String timeStamp = getTimeStamp();
            file = new File("LOG_" + timeStamp + ".txt");
        } else {
            file = new File(arxiu);
        }

        try {
            FileWriter fw = new FileWriter(file);
            BufferedWriter bf = new BufferedWriter(fw);
            for (String piece : listaPecesFabricades) {
                bf.write(piece + "\n");
            }
            bf.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Obtiene la marca de temps en formato "yyyyMMdd_HHmmss".
     *
     * @return La marca de temps actual en el formato especificat.
     */
    public String getTimeStamp() {
        SimpleDateFormat formatData = new SimpleDateFormat("yyyyMMdd_HHmmss");
        return formatData.format(System.currentTimeMillis());
    }
}
