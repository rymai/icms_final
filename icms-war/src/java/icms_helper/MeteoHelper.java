package icms_helper;

import icms_servlet.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 * Cette classe permet de recuperer diverses infos sur la meteo dans une ville
 * donnee lors de l'instanciation de l'objet MeteoHelper
 */
public class MeteoHelper {

    private String ville;
    private Document apiResponse;

    public MeteoHelper(String ville) throws MalformedURLException, IOException, ParserConfigurationException, SAXException {
        this.ville = ville;
        URL url = new URL(
                "http://www.google.fr/ig/api?weather=" + SessionsServlet.getFromSession("ipCity"));
        this.apiResponse = DocumentBuilderFactory.newInstance().newDocumentBuilder().
                    parse(new InputSource(new BufferedReader(new InputStreamReader(url.openStream()))));
    }

    public String currentCondition() {
        return currentConditions().getChildNodes().item(0).getAttributes().getNamedItem("data").getTextContent();
    }

    public String currentTemperature() {
        return currentConditions().getChildNodes().item(2).getAttributes().getNamedItem("data").getTextContent();
    }

    private Node currentConditions() {
        return apiResponse.getElementsByTagName("current_conditions").item(0);
    }
}
