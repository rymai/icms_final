package icms_helper;

import java.io.*;
import java.net.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.*;

/**
 * Cette classe permet de recuperer diverses infos sur la meteo dans une ville
 * donnee lors de l'instanciation de l'objet WeatherHelper
 */
public class WeatherHelper {

    private String city;
    private Document apiResponse;

    public WeatherHelper(String city) throws MalformedURLException, IOException,
                                           ParserConfigurationException, SAXException {
        this.city = city;
        URL url = new URL(
                "http://www.google.fr/ig/api?weather=" + city);
        this.apiResponse = DocumentBuilderFactory.newInstance().newDocumentBuilder().
                parse(new InputSource(new BufferedReader(new InputStreamReader(url.openStream()))));
    }

    public String currentCondition() {
        return currentConditions() == null ? "" : currentConditions().getChildNodes().item(0).getAttributes().getNamedItem("data").
                getTextContent();
    }

    public String currentTemperature() {
        return currentConditions() == null ? "" : currentConditions().getChildNodes().item(2).getAttributes().getNamedItem("data").
                getTextContent();
    }

    private Node currentConditions() {
        return apiResponse.getElementsByTagName("current_conditions").item(0);
    }
}
