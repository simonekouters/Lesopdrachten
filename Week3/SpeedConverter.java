import java.util.Scanner;

public class SpeedConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Invoer afstand in meters: ");
        double meters = Double.parseDouble(scanner.nextLine());
        
        System.out.print("Invoer uren: ");
        double uren = Double.parseDouble(scanner.nextLine());
        
        System.out.print("Invoer minuten: ");
        double minuten = Double.parseDouble(scanner.nextLine());
        
        System.out.print("Invoer seconden: ");
        double seconden = Double.parseDouble(scanner.nextLine());
        
        double totaleSeconden = uren * 60 * 60 + minuten * 60 + seconden;
        double totaleUren = totaleSeconden / 60 / 60;
        
        double metersPerSeconde = meters / totaleSeconden;
        
        double afstandInKilometers = meters / 1000;
        double kilometersPerUur = afstandInKilometers / totaleUren;
        
        double mijlen = meters / 1609;
        double mijlenPerUur = mijlen / totaleUren;
        
        System.out.println("Verwachte resultaten: ");
        System.out.println("Uw snelheid in meter/seconde is " + metersPerSeconde);
        System.out.println("Uw snelheid in km/uur is " + kilometersPerUur);
        System.out.println("Uw snelheid in mijl/uur is " + mijlenPerUur);
    }
}