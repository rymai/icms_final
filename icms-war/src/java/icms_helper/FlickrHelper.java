package icms_helper;

import com.aetrion.flickr.*;
import com.aetrion.flickr.photos.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
//import quicktime.streaming.Stream;

/**
 *
 * @author remy
 */
public class FlickrHelper {

    private static final String FLICKR_KEY = "c6f7bf2330b720bc069579c6f7387523";
    private static final String FLICKR_SECRET = "921968124ea4c38c";
    int NB_PER_ROW_FLICKR = 8;
    int NB_ROWS_FLICKR = 1;
    int NB_RESULTS_FLICKR = NB_PER_ROW_FLICKR * NB_ROWS_FLICKR;
    ArrayList<String> searchTerms;
    String flickrResults;
    Flickr flickr;

    public FlickrHelper(String search_terms) {
        try {
            String[] tmp = search_terms.split(",");
            this.searchTerms = new ArrayList<String>(tmp.length);
            this.searchTerms.add(0, "");
            this.flickr = new Flickr(FLICKR_KEY, FLICKR_SECRET, new REST());
            for (String s : tmp) {
                this.searchTerms.add(s);
            }
            searchFlickr();
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(FlickrHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void searchFlickr() {
        PhotoList photoList = getPhotoList();
        while (photoList.isEmpty() && !searchTerms.isEmpty()) {
            photoList = getPhotoList();
        }

        int i = 0;
        flickrResults = "<p><strong>Quelques photos li&eacute;es...</strong></p>";
        flickrResults += "<table>";
        for (Object o : photoList) {
            Photo p = (Photo) o;

            if (i == 0) {
                flickrResults += "<tr>";
            }

            flickrResults += "<td id=\"flickr_" + p.getId() + "\" class=\"flickr_item\">";

            flickrResults += "<a href=\"" + p.getUrl() + "\"><img id=\"thumb_flickr_" + p.getId() + "\" class=\"flickr_thumb\" src=\"" + p.
                    getSmallSquareUrl() + "\"></a>";

            // Description (caché)
            flickrResults +=
            "<div id=\"description_flickr_" + p.getId() + "\" class=\"description hidden\"><img class=\"flickr_zoom\" src=\"" + p.
                    getMediumUrl() + "\"><p>" + p.getTitle() + "</p></div>";

            // Zoom (caché)
//                    flickrResults +=
//                    "<div id=\"masterpiece_flickr_" + p.getId() + "\" class=\"masterpiece hidden\"><img class=\"flickr_zoom\" src=\"" + p.
//                            getMediumUrl() + "\"></div>";
            flickrResults += "</td>";
            i++;
            if (i >= NB_PER_ROW_FLICKR) {
                flickrResults += "</tr>";
                i = 0;
            }
        }
        flickrResults += "</table>";
    }

    public String getFlickrResults() {
        return flickrResults;
    }

    @SuppressWarnings("empty-statement")
    private PhotoList getPhotoList() {
        try {
            searchTerms.remove(0);
            
            PhotosInterface pi = flickr.getPhotosInterface();
            SearchParameters sp = new SearchParameters();
            String tmp = "";
            String[] tmp_arr = new String[searchTerms.size()];
            int i = 0;
            for (int j = 0; j < 2 && j < searchTerms.size(); j++) {
                tmp += searchTerms.get(j) + ",";
                tmp_arr[i++] = searchTerms.get(j);
            }
            sp.setTags(tmp_arr);
            sp.setText(tmp);
            System.out.println("Searching on : " + tmp);
            return pi.search(sp, NB_RESULTS_FLICKR, 1);
        } catch (IOException ex) {
            Logger.getLogger(FlickrHelper.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(FlickrHelper.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FlickrException ex) {
            Logger.getLogger(FlickrHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new PhotoList();
    }
}
