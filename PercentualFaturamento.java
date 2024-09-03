public class PercentualFaturamento {

    public static void main(String[] args) {
        
        double sp = 67836.43;
        double rj = 36678.66;
        double mg = 29229.88;
        double es = 27165.48;
        double outros = 19849.53;

        
        double total = sp + rj + mg + es + outros;

        
        System.out.println("SP: " + String.format("%.2f", (sp / total) * 100) + "%");
        System.out.println("RJ: " + String.format("%.2f", (rj / total) * 100) + "%");
        System.out.println("MG: " + String.format("%.2f", (mg / total) * 100) + "%");
        System.out.println("ES: " + String.format("%.2f", (es / total) * 100) + "%");
        System.out.println("Outros: " + String.format("%.2f", (outros / total) * 100) + "%");
    }
}