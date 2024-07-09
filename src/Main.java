import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {

    private static final String API_URL = "https://v6.exchangerate-api.com/v6/ba71e8401fd1504e8f82e77a/latest/USD";
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest currencyRequest = HttpRequest.newBuilder()
                    .uri(new URI(API_URL))
                    .build();
            HttpResponse<String> currencyResponse = client.send(currencyRequest, HttpResponse.BodyHandlers.ofString());
            String responseBody = currencyResponse.body();

            Gson gson = new Gson();
            CurrencyRequestResponse currencyData = gson.fromJson(responseBody, CurrencyRequestResponse.class);

            displayMenu();

            while (true) {
                int option = getUserOption();

                switch (option) {
                    case 1:
                        convertDollarTo(currencyData, "Peso Colombiano", currencyData.conversion_rates.cOP, currencyData.base_code);
                        break;
                    case 2:
                        convertCurrencyToDollar("Peso Colombiano", currencyData.conversion_rates.cOP, currencyData.base_code);
                        break;
                    case 3:
                        convertDollarTo(currencyData, "Peso Argentino", currencyData.conversion_rates.aRS, currencyData.base_code);
                        break;
                    case 4:
                        convertCurrencyToDollar("Peso Argentino", currencyData.conversion_rates.aRS, currencyData.base_code);
                        break;
                    case 5:
                        convertDollarTo(currencyData, "Peso Chileno", currencyData.conversion_rates.cLP, currencyData.base_code);
                        break;
                    case 6:
                        convertCurrencyToDollar("Peso Chileno", currencyData.conversion_rates.cLP, currencyData.base_code);
                        break;
                    case 7:
                        System.out.println("Gracias por usar el conversor de moneda.");
                        return;
                    default:
                        System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
                }
                System.out.println("Presione enter para continuar...");
                scanner.nextLine(); // Consumir el salto de línea después de la entrada del usuario
            }
        } catch (Exception e) {
            System.out.println("Error al procesar la solicitud: " + e.getMessage());
        }
    }

    private static void displayMenu() {
        System.out.println("**********************************************************");
        System.out.println("Sea bienvenido/a al Conversor de Moneda =]");
        System.out.println();
        System.out.println("1) Dolar ==> Peso Colombiano");
        System.out.println("2) Peso Colombiano ==> Dolar");
        System.out.println("3) Dolar ==> Peso Argentino");
        System.out.println("4) Peso Argentino ==> Dolar");
        System.out.println("5) Dolar ==> Peso Chileno");
        System.out.println("6) Peso Chileno ==> Dolar");
        System.out.println("7) Salir");
        System.out.println("Ingrese la opción deseada: ");
        System.out.println("**********************************************************");
    }

    private static int getUserOption() {
        int option;
        while (true) {
            try {
                option = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un número válido.");
            }
        }
        return option;
    }

    private static void convertDollarTo(CurrencyRequestResponse currencyData, String targetCurrency, double rate, String baseCode) {
        System.out.println("Ingrese la cantidad de dolares: ");
        double dollars = scanner.nextDouble();
        double convertedAmount = dollars * rate;
        System.out.printf("Tienes $%.2f (%s)%n", convertedAmount, targetCurrency, baseCode);
        scanner.nextLine(); // Consumir el salto de línea después de la entrada del usuario
    }

    private static void convertCurrencyToDollar(String sourceCurrency, double rate, String baseCode) {
        System.out.println("Ingrese la cantidad de " + sourceCurrency + ": ");
        double amount = scanner.nextDouble();
        double dollars = amount / rate;
        System.out.printf("Tienes $%.2f USD (%s)%n", dollars, baseCode);
        scanner.nextLine(); // Consumir el salto de línea después de la entrada del usuario
    }
}
