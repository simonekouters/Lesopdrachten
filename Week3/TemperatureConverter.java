public class TemperatureConverter {
    public static void main(String[] args) {
        System.out.println(convertFahrenheitToCelcius(100.5));
        System.out.println(convertFahrenheitToCelcius(22.6));
    }
    
    private static double convertFahrenheitToCelcius(double fahrenheit) {
        return (fahrenheit - 32) * 5/9;
    }

    private static double convertCelciusToFahrenheit(double celcius) {
        return (celcius * 9 / 5) + 32;
    }
}

