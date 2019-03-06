package z32;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Z32 {
    public static void main(String[] args) throws IOException, FileNotFoundException {
        int wybor = 0;
        KsiazkaAdresowa ksiazkaAdresowa=new KsiazkaAdresowa();
        
        
        
        
        do {
            MenuKA();
            Scanner liczba = new Scanner(System.in);
            wybor=liczba.nextInt();
            
            switch (wybor)
            {
                case 1:
                    System.out.println("Ile osob chciesz dodac?");
                    Scanner liczba2 = new Scanner(System.in);
                    int ileosob = liczba2.nextInt();
                    
                    for (int i=0; i<ileosob; i++ ){
                        System.out.print("Podaj imie: ");
                        Scanner Imie=new Scanner(System.in);
                        String imie = Imie.next();
                        System.out.print("Podaj nazwisko: ");
                        Scanner Nazwisko=new Scanner(System.in);
                        String nazwisko = Nazwisko.next();
                        System.out.print("Podaj ulice: ");
                        Scanner Ulica=new Scanner(System.in);
                        String ulica = Ulica.next();
                        System.out.print("Podaj numer: ");
                        Scanner Numer=new Scanner(System.in);
                        int numer = Numer.nextInt();
                        ksiazkaAdresowa.DodajDoListyAdresow(new Adresy(imie,nazwisko,ulica,numer));
                    }
                    break;
                case 2:
                    ksiazkaAdresowa.PokazListe();
                    break;
                    
                case 3:
                System.out.print("Którą osobę usunąć: ");
                Scanner Osoba=new Scanner(System.in);
                int osoba=Osoba.nextInt();
                
                for(int i=osoba; i<=osoba; i++)
                {
                 ksiazkaAdresowa.UsuńZListyAdresow(i);
                }
                    break;
                    
                case 4:
                System.out.print("Którą osobę chcesz zobaczyc: ");
                Scanner Osoba2=new Scanner(System.in);
                int osoba2=Osoba2.nextInt();
                 ksiazkaAdresowa.PokazOsobe(osoba2-1);
                    break;
            }
            
        }while(wybor !=5);
    }


public static void MenuKA() {
System.out.println("Wybór 1 - Dodaj");
System.out.println("Wybór 2 - Wyswietl Wszystko");
System.out.println("Wybór 3 - Usun dana pozycje");
System.out.println("Wybór 4 - Wyswietl dana pozycje");
System.out.println("Wybór 5 - Zakoncz");
}


}

class KsiazkaAdresowa 
{
    private List<Adresy> listaAdresow = new ArrayList<>();
    
    public void DodajDoListyAdresow(Adresy adresy){
        listaAdresow.add(adresy);
        
        
    }
    
    public void UsuńZListyAdresow(int i){
        listaAdresow.remove(i);
    }
    
    public void PokazListe() throws IOException, FileNotFoundException {
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
        for(int i=0;i<listaAdresow.size();i++){
            bufor.write("\nImie: " + listaAdresow.get(i).getImie());
            bufor.newLine();
            bufor.write("\nNazwisko: " + listaAdresow.get(i).getNazwisko());
            bufor.newLine();
            bufor.write("\nUlica: " +listaAdresow.get(i).getUlica()); 
            bufor.newLine();
            bufor.write("\nNumer: " +listaAdresow.get(i).getNumer()+"\n");
            bufor.newLine();
            bufor.newLine();
            System.out.println("\nImie: " + listaAdresow.get(i).getImie() +"\nNazwisko: " + listaAdresow.get(i).getNazwisko()+ "\nUlica: " +listaAdresow.get(i).getUlica() + "\nNumer: " +listaAdresow.get(i).getNumer()+"\n");
        }
        bufor.close();
    }
    public void PokazOsobe(int osoba2)  {
            System.out.println("\nImie: " + listaAdresow.get(osoba2).getImie() +"\nNazwisko: " + listaAdresow.get(osoba2).getNazwisko()+ "\nUlica: " +listaAdresow.get(osoba2).getUlica() + "\nNumer: " +listaAdresow.get(osoba2).getNumer()+"\n");
       
    }
}

class Adresy {
    private String imie;
    private String nazwisko;
    private String ulica;
    private int numer;
    
    public String getImie(){
        return imie;
    }
    
    public void setImie(String imie){
        this.imie = imie;
    }
    public String getNazwisko(){
        return nazwisko;
    }
    
    public void setNazwisko(String nazwisko) {
        this.nazwisko=nazwisko;
    }
    
    public String getUlica() {
        return ulica;
    }
    
    public void setUlica(String ulica) {
        this.ulica = ulica;
    }
    
    public int getNumer() {
        return numer;
    }
    
    public void setNumer(int numer) {
        this.numer= numer;
    }
    
    public Adresy(String Imie, String Nazwisko, String Ulica, int Numer) {
        imie = Imie;
        nazwisko = Nazwisko;
        ulica = Ulica;
        numer = Numer;
    }
    }
     
   





