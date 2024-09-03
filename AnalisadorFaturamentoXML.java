import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AnalisadorFaturamentoXML {

    public static void main(String[] args) {
        try {
            File xmlFile = new File("dados_faturamento.xml"); 
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getElementsByTagName("dia"); 
            List<Double> faturamento = new ArrayList<>();
            for (int i = 0; i < nodeList.getLength(); i++) {
                Element element = (Element) nodeList.item(i);
                double valor = Double.parseDouble(element.getTextContent());
                faturamento.add(valor);
            }

            double menorFaturamento = calcularMenorFaturamento(faturamento);
            double maiorFaturamento = calcularMaiorFaturamento(faturamento);
            double mediaFaturamento = calcularMediaFaturamento(faturamento);
            int diasAcimaDaMedia = calcularDiasAcimaDaMedia(faturamento);

            System.out.println("Menor faturamento: " + menorFaturamento);
            System.out.println("Maior faturamento: " + maiorFaturamento);
            System.out.println("Média de faturamento: " + mediaFaturamento);
            System.out.println("Dias com faturamento acima da média: " + diasAcimaDaMedia);

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    public static double calcularMenorFaturamento(List<Double> faturamento) {
        double menor = Double.MAX_VALUE;
        for (double valor : faturamento) {
            if (valor > 0 && valor < menor) {
                menor = valor;
            }
        }
        return menor;
    }

    public static double calcularMaiorFaturamento(List<Double> faturamento) {
        double maior = Double.MIN_VALUE;
        for (double valor : faturamento) {
            if (valor > 0 && valor > maior) {
                maior = valor;
            }
        }
        return maior;
    }

    public static double calcularMediaFaturamento(List<Double> faturamento) {
        double soma = 0;
        int diasComFaturamento = 0;
        for (double valor : faturamento) {
            if (valor > 0) {
                soma += valor;
                diasComFaturamento++;
            }
        }
        if (diasComFaturamento == 0) {
            return 0; // Evita divisão por zero
        }
        return soma / diasComFaturamento;
    }

    public static int calcularDiasAcimaDaMedia(List<Double> faturamento) {
        double media = calcularMediaFaturamento(faturamento);

        int diasAcimaDaMedia = 0;
        for (double valor : faturamento) {
            if (valor > media) {
                diasAcimaDaMedia++;
            }
        }
        return diasAcimaDaMedia;
    }
}
