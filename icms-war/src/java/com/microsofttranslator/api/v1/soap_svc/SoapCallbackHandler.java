
/**
 * SoapCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.1  Built on : Oct 19, 2009 (10:59:00 EDT)
 */

    package com.microsofttranslator.api.v1.soap_svc;

    /**
     *  SoapCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class SoapCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public SoapCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public SoapCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for detect method
            * override this method for handling normal response from detect operation
            */
           public void receiveResultdetect(
                    com.microsofttranslator.api.v1.soap_svc.SoapStub.DetectResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from detect operation
           */
            public void receiveErrordetect(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for translate method
            * override this method for handling normal response from translate operation
            */
           public void receiveResulttranslate(
                    com.microsofttranslator.api.v1.soap_svc.SoapStub.TranslateResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from translate operation
           */
            public void receiveErrortranslate(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getLanguageNames method
            * override this method for handling normal response from getLanguageNames operation
            */
           public void receiveResultgetLanguageNames(
                    com.microsofttranslator.api.v1.soap_svc.SoapStub.GetLanguageNamesResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getLanguageNames operation
           */
            public void receiveErrorgetLanguageNames(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getLanguages method
            * override this method for handling normal response from getLanguages operation
            */
           public void receiveResultgetLanguages(
                    com.microsofttranslator.api.v1.soap_svc.SoapStub.GetLanguagesResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getLanguages operation
           */
            public void receiveErrorgetLanguages(java.lang.Exception e) {
            }
                


    }
    