package z34;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Z34 {
    public static void main(String[] args) throws IOException, FileNotFoundException {
        int wybor = 0;
        PrzychodniaWizyty przychodniaWizyty=new PrzychodniaWizyty();
        PrzychodniaPacjenci przychodniaPacjenci= new PrzychodniaPacjenci();
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
                        przychodniaPacjenci.DodajDoListyPacjentow(new Pacjenci(imie,nazwisko,ulica,numer));
                    }
                    break;
                case 2:
                    przychodniaPacjenci.PokazListePacjentow();
                    break;
                    
                case 3:
                System.out.print("Którą osobę usunąć: ");
                Scanner Osoba=new Scanner(System.in);
                int osoba=Osoba.nextInt();
                
                for(int i=osoba; i<=osoba; i++)
                {
                 przychodniaPacjenci.UsuńZListyPacjentow(i);
                }
                    break;
                    
                case 4:
                System.out.print("Którą osobę chcesz zobaczyc: ");
                Scanner Osoba2=new Scanner(System.in);
                int osoba2=Osoba2.nextInt();
                przychodniaPacjenci.PokazOsobe(osoba2-1);
                    break;
                case 5:
                        System.out.print("Podaj Numer Osoby z bazy: ");
                        Scanner Numer=new Scanner(System.in);
                        String numer = Numer.next();
                        System.out.print("Podaj imie doktora: ");
                        Scanner ImieDoc=new Scanner(System.in);
                        String imieDoc = ImieDoc.next();
                        System.out.print("Podaj nazwisko doktora: ");
                        Scanner NazwiskoDoc=new Scanner(System.in);
                        String nazwiskoDoc = NazwiskoDoc.next();
                        System.out.print("Podaj godzine: ");
                        Scanner Godzina=new Scanner(System.in);
                        String godzina = Godzina.next();
                        System.out.print("Podaj date: ");
                        Scanner Data=new Scanner(System.in);
                        String data = Data.next();
                        
                        przychodniaWizyty.DodajDoListyWizyt(new Wizyty(imieDoc,nazwiskoDoc,godzina,data));
                    break;
                case 6:
                    przychodniaWizyty.PokazListeWizyt();
                    break;
                    
                case 7:
                    System.out.print("Którą wizyte chcesz zobaczyc: ");
                Scanner Wizyta=new Scanner(System.in);
                int wizyta=Wizyta.nextInt();
                przychodniaWizyty.PokazOsobe(wizyta-1);
                    break;
                case 8:
                    System.out.print("Którą wizyte usunąć: ");
                Scanner Wizyta2=new Scanner(System.in);
                int wizyta2=Wizyta2.nextInt();
                
                for(int i=wizyta2; i<=wizyta2; i++)
                {
                 przychodniaWizyty.UsuńZListyWizyt(i-1);
                }
                    break;
            }
            
        }while(wybor !=9);
    }


public static void MenuKA() {
System.out.println("Wybór 1 - Dodaj");
System.out.println("Wybór 2 - Wyswietl Wszystkich pacjentow");
System.out.println("Wybór 3 - Usun danego pacjenta");
System.out.println("Wybór 4 - Wyswietl dane pacjenta");
System.out.println("Wybór 5 - Umów na wizte");
System.out.println("Wybór 6 - Zobacz Wszystkie Wizyty");
System.out.println("Wybór 7 - Zobacz konkretna wizyte");
System.out.println("Wybór 8 - Usun konkretna wizyte");
System.out.println("Wybór 9 - Zakoncz");
}


}
class PrzychodniaWizyty {
    private List<Wizyty> listaWizyt = new ArrayList<>();

public void DodajDoListyWizyt(Wizyty wizyty){
        listaWizyt.add(wizyty); 
    }

public void UsuńZListyWizyt(int i){
        listaWizyt.remove(i);
    }
public void PokazListeWizyt() throws IOException, FileNotFoundException {
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
        
        for(int i=0;i<listaWizyt.size();i++){
            bufor.write("\nImie Doktora: " + listaWizyt.get(i).getImieDoc());
            bufor.newLine();
            bufor.write("\nNazwisko Doktora: " + listaWizyt.get(i).getNazwiskoDoc());
            bufor.newLine();
            bufor.write("\nGodzina: " +listaWizyt.get(i).getGodzina()); 
            bufor.newLine();
            bufor.write("\nData: " +listaWizyt.get(i).getData()+"\n");
            bufor.newLine();
            bufor.newLine();
            System.out.println("\nImie: " + listaWizyt.get(i).getImieDoc() +"\nNazwisko: " + listaWizyt.get(i).getNazwiskoDoc()+ "\nUlica: " +listaWizyt.get(i).getGodzina() + "\nNumer: " +listaWizyt.get(i).getData()+"\n");
        }
        bufor.close();
    }
    public void PokazOsobe(int osoba2)  {
            System.out.println("\nImie: " + listaWizyt.get(osoba2).getImieDoc() +"\nNazwisko: " + listaWizyt.get(osoba2).getNazwiskoDoc()+ "\nUlica: " +listaWizyt.get(osoba2).getGodzina() + "\nNumer: " +listaWizyt.get(osoba2).getData()+"\n");
    }    

}

class Wizyty {
    private String imieDoc;
    private String nazwiskoDoc;
    private String godzina;
    private String data;
    
    public String getImieDoc(){
        return imieDoc;
    }
    
    public void setImieDoc(String imieDoc){
        this.imieDoc = imieDoc;
    }
    public String getNazwiskoDoc(){
        return nazwiskoDoc;
    }
    
    public void setNazwiskoDoc(String nazwiskoDoc) {
        this.nazwiskoDoc=nazwiskoDoc;
    }
    
    public String getGodzina() {
        return godzina;
    }
    
    public void setGodzina(String godzina) {
        this.godzina = godzina;
    }
    
    public String getData() {
        return data;
    }
    
    public void setData (String data) {
        this.data= data;
    }
    
    public Wizyty(String ImieDoc, String NazwiskoDoc, String Godzina, String Data) {
        imieDoc = ImieDoc;
        nazwiskoDoc = NazwiskoDoc;
        godzina = Godzina;
        data = Data;
    }
    
    
}


class PrzychodniaPacjenci 
{
    private List<Pacjenci> listaPacjentow = new ArrayList<>();
    
    public void DodajDoListyPacjentow(Pacjenci pacjenci){
        listaPacjentow.add(pacjenci); 
    }
    
    public void UsuńZListyPacjentow(int i){
        listaPacjentow.remove(i);
    }
    
    public void PokazListePacjentow() throws IOException, FileNotFoundException {
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
        for(int i=0;i<listaPacjentow.size();i++){
            bufor.write("\nImie: " + listaPacjentow.get(i).getImie());
            bufor.newLine();
            bufor.write("\nNazwisko: " + listaPacjentow.get(i).getNazwisko());
            bufor.newLine();
            bufor.write("\nUlica: " +listaPacjentow.get(i).getUlica()); 
            bufor.newLine();
            bufor.write("\nNumer: " +listaPacjentow.get(i).getNumer()+"\n");
            bufor.newLine();
            bufor.newLine();
            System.out.println("\nImie: " + listaPacjentow.get(i).getImie() +"\nNazwisko: " + listaPacjentow.get(i).getNazwisko()+ "\nUlica: " +listaPacjentow.get(i).getUlica() + "\nNumer: " +listaPacjentow.get(i).getNumer()+"\n");
        }
        bufor.close();
    }
    public void PokazOsobe(int osoba2)  {
            System.out.println("\nImie: " + listaPacjentow.get(osoba2).getImie() +"\nNazwisko: " + listaPacjentow.get(osoba2).getNazwisko()+ "\nUlica: " +listaPacjentow.get(osoba2).getUlica() + "\nNumer: " +listaPacjentow.get(osoba2).getNumer()+"\n");
       
    }
}

class Pacjenci {
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
    
    public Pacjenci(String Imie, String Nazwisko, String Ulica, int Numer) {
        imie = Imie;
        nazwisko = Nazwisko;
        ulica = Ulica;
        numer = Numer;
    }
    }
     
   





