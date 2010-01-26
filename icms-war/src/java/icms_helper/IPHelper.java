package icms_helper;

import com.maxmind.geoip.LookupService;
import icms_servlet.SessionsServlet;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class IPHelper {

    private String ip = "";
    private String country = "";
    private String city = "";
    //    private static String data = "C:/Users/Chouchou/icms_final/GeoLiteCity.dat";
    private static String data = "/Users/remy/Documents/Development/Java/M2 Miage/icms/GeoLiteCity.dat";

    public IPHelper() throws MalformedURLException, IOException {
        if (SessionsServlet.getFromSession("ip") == null) {
            URL url = new URL(
                    "http://www.afficheip.net/scripts/AfficheIP.php?taille=30&police=Times&color=000000&bg=FFFFFF");
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

            ip = in.readLine().trim();
            if (ip.length() >= 27) {
                ip = ip.substring(ip.length() - 27, ip.length() - 12);
                ip = ip.substring(ip.indexOf(">")).substring(2);
            }

            LookupService cl = new LookupService(data, LookupService.GEOIP_MEMORY_CACHE);
            SessionsServlet.setToSession("ip", ip);
            country = cl.getLocation(ip).countryName;
            SessionsServlet.setToSession("ipCountry", country);
            city = cl.getLocation(ip).city;
            SessionsServlet.setToSession("ipCity", city);
        }
    }
}
