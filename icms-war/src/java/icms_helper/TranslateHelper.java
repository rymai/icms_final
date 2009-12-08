package icms_helper;

import com.microsofttranslator.api.v1.soap_svc.SoapStub;
import java.rmi.RemoteException;
import java.util.logging.*;
import org.apache.axis2.AxisFault;

/**
 *
 * @author remy
 */
public class TranslateHelper {

    SoapStub.Translate translate_config;
    String appID, langFrom, langTo, lastTranslation;

    private void init() {
        translate_config = new SoapStub.Translate();
        appID = "BD061A8446F9FA67F9CD39B278237C98599FAFEA";
        langFrom = "fr";
        langTo = "en";
    }

    public void setAppID(String appID) {
        this.appID = appID;
    }

    public void setLangFrom(String langFrom) {
        this.langFrom = langFrom;
    }

    public void setLangTo(String langTo) {
        this.langTo = langTo;
    }

    public String getLastTranslation() {
        return lastTranslation;
    }
    
    public TranslateHelper() {
        init();
    }

    public TranslateHelper(String to) {
        init();
        setLangTo(to);
    }

    public TranslateHelper(String from, String to) {
        init();
        setLangFrom(from);
        setLangTo(to);
    }

    public void translate(String text) {
        try {
            translate_config.setAppId(appID);
            translate_config.setFrom(langFrom);
            translate_config.setTo(langTo);
            translate_config.setText(text);
            lastTranslation = new SoapStub().translate(translate_config).getTranslateResult();
        } catch (AxisFault ex) {
            Logger.getLogger(TranslateHelper.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(TranslateHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String translateAndGet(String text) {
        translate(text);
        return lastTranslation;
    }

}
