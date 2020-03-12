package com.esamejava;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    // Valori con cui lavorare
    static Desk[][] deskMatrix;
    static LinkedList<Replyer> projectManagers;
    static LinkedList<Replyer> developers;
    static int width;
    static int height;

    public static void main(String[] args) throws FileNotFoundException {
        readFile();

        System.out.print(developers.size()+" "+projectManagers.size());

        // 1) Lettura del file Simone => produco mappa senza rep
        // 2) Posizionano i repleyer => IN : Matrice(bxh) Desk vuota, => Inserire il replayer giusto in base ai permessi => OUT matrice riempi
        // 3) Stampa file =>
    }

    // Simone e Vittorio
    static void readFile() throws FileNotFoundException {
        File input  = new File("input.txt");

        Scanner scanner = new Scanner(input);

        String[] mapDimensionStrings = scanner.nextLine().split(" ");

        width = Integer.parseInt(mapDimensionStrings[0]);
        height = Integer.parseInt(mapDimensionStrings[1]);

        deskMatrix = new Desk[height][width];

        for(int i = 0; i < height; i++){
            var mapLine = scanner.nextLine().toCharArray();

            Desk[]  deskLine = new Desk[width];

            for(int j = 0 ; j < width ; j++){
                ReplyerType repType;

                switch (mapLine[j]){
                    case 'M': repType = ReplyerType.PROJECT_MANAGER; break;
                    case '_':   repType = ReplyerType.DEVELOPER; break;
                    default:
                        repType = ReplyerType.NONE;
                }

                deskLine[j] = new Desk(repType);
            }

            deskMatrix[i] = deskLine;
        }

        int devs = Integer.parseInt(scanner.nextLine());
        developers = new LinkedList<>();

        for(int i = 0 ; i < devs; i++){
            String[] devValues = scanner.nextLine().split(" ");

            String company = devValues[0];
            int bonus = Integer.parseInt(devValues[1]);

            int skillsCount = Integer.parseInt(devValues[2]);
            HashSet<String> skillsSet = new HashSet<>();

            for(int j = 0; j < skillsCount; j++){
                skillsSet.add(devValues[j+3]);
            }

            developers.add(new Replyer(ReplyerType.DEVELOPER, bonus, skillsSet));
        }

        int pms = Integer.parseInt(scanner.nextLine());
        projectManagers = new LinkedList<>();

        for(int i = 0 ; i < pms; i++){
            String[] pmValues = scanner.nextLine().split(" ");

            String company = pmValues[0];
            int bonus = Integer.parseInt(pmValues[1]);

            projectManagers.add(new Replyer(ReplyerType.PROJECT_MANAGER, bonus, null));
        }

        scanner.close();
    }

    // Emilia e Samuele
    static void riempiMatrice(){

    }

    // Il primo che finisce poi si vede
    static void printFile(){
        // generi file output
        // lavori con la mappa  (2 for annidati)
        // per ogni desk non vuota
    }
}
