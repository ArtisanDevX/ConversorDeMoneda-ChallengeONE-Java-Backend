import com.google.gson.annotations.SerializedName;

public class CurrencyRequestResponse {
    public String result;
    public String base_code;
    public ConversionRates conversion_rates;

    public static class ConversionRates{
        @SerializedName("USD")
        public int uSD;
        @SerializedName("ARS")
        public double aRS;
        @SerializedName("CLP")
        public double cLP;
        @SerializedName("COP")
        public double cOP;
    }
}
