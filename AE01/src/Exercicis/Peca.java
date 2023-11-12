package Exercicis;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Peca implements Runnable {
    private String tipus;
    private ArrayList<String> listaPeces = new ArrayList<String>();
    private int tempsFabricacio;

    /**
     * Constructor de la peca.
     *
     * @param tipus      Tipus de la peca a fabricar.
     * @param listaPeces Llista de les peces fabricades.
     */
    Peca(String tipus, ArrayList<String> listaPeces) {
        this.tipus = tipus;
        this.listaPeces = listaPeces;
        this.tempsFabricacio = tempsFabricacio(tipus);
    }

    /**
     * Mètode que simula el procés de fabricació segons el temps indicat.
     *
     * @param tempsFabricacio Temps de fabricació de la peça.
     */
    public static void procesFabricacio(int tempsFabricacio) {
        long tempsInici = System.currentTimeMillis();
        long tempsFinal = tempsInici + tempsFabricacio;
        int iteracions = 0;
        while (System.currentTimeMillis() < tempsFinal) {
            iteracions++;
        }
    }

    /**
     * Mètode que retorna el temps de fabricació segons el tipus de peça.
     *
     * @param tipusPeca Tipus de la peça.
     * @return Temps de fabricació de la peça segons el tipus.
     */
    private int tempsFabricacio(String tipusPeca) {
        switch (tipusPeca) {
            case "I":
                return 1000;
            case "O":
                return 2000;
            case "T":
                return 3000;
            case "J":
            case "L":
                return 4000;
            case "S":
            case "Z":
                return 5000;
            default:
                return 0;
        }
    }

    /**
     * Mètode que inicia la fabricació de la peça. S'obté el timeStamp actual,
     * s'afegeix a la llista i es mostra per consola.
     */
    public void run() {
        procesFabricacio(tempsFabricacio);
        synchronized (listaPeces) {
            String peca = tipus + "_" + getTimeStamp();
            listaPeces.add(peca);
            System.out.println(peca);
        }
    }

    /**
     * Obté la marca de temps en format "yyyyMMdd_HHmmss".
     *
     * @return La marca de temps actual en el format especificat.
     */
    public String getTimeStamp() {
        SimpleDateFormat formatData = new SimpleDateFormat("yyyyMMdd_HHmmss");
        return formatData.format(System.currentTimeMillis());
    }

}
