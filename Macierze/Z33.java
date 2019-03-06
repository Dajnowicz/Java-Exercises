package z33;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Z33 {

    public static void main(String[] args) throws IOException, FileNotFoundException {
        Macierz macierz = new Macierz();
        
        System.out.println("Ile wierszy ?");
        Scanner Wiersze = new Scanner(System.in);
        int wiersze = Wiersze.nextInt();
        
        System.out.println("Ile kolumn ?");
        Scanner Kolumny = new Scanner(System.in);
        int kolumny = Kolumny.nextInt();
        
        int[][] tab = new int[wiersze][kolumny];
        
        macierz.UtworzMacierz(wiersze,kolumny);
        
        System.out.print("Podaj numer wiersza w której wstawic liczbe: ");
        Scanner NowyWiersz = new Scanner (System.in);
        int nowyWiersz = NowyWiersz.nextInt();
        
        System.out.print("Podaj numer kolumny w której wstawic liczbe: ");
        Scanner NowaKolumna = new Scanner (System.in);
        int nowaKolumna = NowaKolumna.nextInt();
        
        System.out.print("Podaj liczbe która wstawic: ");
        Scanner Liczba = new Scanner (System.in);
        int liczba = Liczba.nextInt();
        
        
        System.out.println("Umieszczam nowa liczbe do starej:");
        macierz.UtworzNowyMacierz(wiersze, kolumny, nowyWiersz, nowaKolumna, liczba, tab);
        
        
        macierz.Sumy(wiersze, kolumny, tab);
        
        
        
    
    }
}
        class Macierz {
        
        public static void UtworzMacierz(int wiersze, int kolumny) {
               
        for (int i =0; i <wiersze; i++) 
        {
        for (int j =0; j <kolumny; j++) 
            {
            System.out.print(0 +"  ");
            }
        System.out.println(" ");
        }
        
        }
        
        public static void UtworzNowyMacierz(int wiersze, int kolumny, int nowyWiersz, int nowaKolumna, int liczba, int tab[][]) {
        for (int i=0; i<=wiersze; i++) {
            for (int j = 0; j<=kolumny; j++) {
                if (i == nowyWiersz -1 && j == nowaKolumna -1)
                tab[i][j] = liczba;
                }
            }
        
    for (int i =0; i <wiersze; i++) 
        {
        for (int j =0; j <kolumny; j++) 
            {
            System.out.print(tab[i][j] +"  ");
            }
        System.out.println(" ");
        }      
        
        }
        
        
        public static void Sumy(int wiersze, int kolumny, int tab[][]) throws IOException, FileNotFoundException {
        
        System.out.println("Katalog ?");
        Scanner Katalog = new Scanner(System.in);
        String katalog = Katalog.next();
        
        File kat= new File("C:/" + katalog);
        kat.mkdirs();
        
        System.out.println("Plik?");
        Scanner Nplik = new Scanner(System.in);
        String nplik = Nplik.next();
        
        File pli= new File("C:/" + katalog +"/" + nplik +".txt");
        
        
        
        FileWriter plik = new FileWriter(pli);
        BufferedWriter bufor = new BufferedWriter(plik);
        
        int sumaPoPrzekatnej = 0;
        for (int i =0; i<wiersze; i++) {
            for (int j =0; j <kolumny; j++) {
                if(i==j) {
            sumaPoPrzekatnej +=tab[i][j];
                }
            }
        }
        int sumaWKolumnie = 0;
        for (int i =0; i<wiersze; i++) {
            for (int j =0; j <kolumny; j++) {
                if(j==0)
            sumaWKolumnie +=tab[i][j];
                }
            }
        int sumaWWierszu = 0;
        for (int i =0; i<wiersze; i++) {
            for (int j =0; j <kolumny; j++) {
                if(i==0)
            sumaWWierszu +=tab[i][j];
                }
            }
        
        System.out.println("Suma po przekatnej: " + sumaPoPrzekatnej);
        bufor.write("Suma po przekatnej: " + sumaPoPrzekatnej);
        bufor.newLine();
        System.out.println("Suma cyfr w kolumnie : " + sumaWKolumnie);
        bufor.write("Suma cyfr w kolumnie : " + sumaWKolumnie);
        bufor.newLine();
        System.out.println("Suma cyfr w wierszu  : "+  sumaWWierszu);
        bufor.write("Suma cyfr w wierszu " + sumaWWierszu);
        bufor.close();
        bufor.close();
        
        }
}  



