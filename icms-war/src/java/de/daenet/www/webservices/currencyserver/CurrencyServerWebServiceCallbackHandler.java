
/**
 * CurrencyServerWebServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.1  Built on : Oct 19, 2009 (10:59:00 EDT)
 */

    package de.daenet.www.webservices.currencyserver;

    /**
     *  CurrencyServerWebServiceCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class CurrencyServerWebServiceCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public CurrencyServerWebServiceCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public CurrencyServerWebServiceCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for getDollarValue method
            * override this method for handling normal response from getDollarValue operation
            */
           public void receiveResultgetDollarValue(
                    de.daenet.www.webservices.currencyserver.CurrencyServerWebServiceStub.GetDollarValueResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getDollarValue operation
           */
            public void receiveErrorgetDollarValue(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getProviderTimestamp method
            * override this method for handling normal response from getProviderTimestamp operation
            */
           public void receiveResultgetProviderTimestamp(
                    de.daenet.www.webservices.currencyserver.CurrencyServerWebServiceStub.GetProviderTimestampResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getProviderTimestamp operation
           */
            public void receiveErrorgetProviderTimestamp(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getProviderList method
            * override this method for handling normal response from getProviderList operation
            */
           public void receiveResultgetProviderList(
                    de.daenet.www.webservices.currencyserver.CurrencyServerWebServiceStub.GetProviderListResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getProviderList operation
           */
            public void receiveErrorgetProviderList(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getDataSet method
            * override this method for handling normal response from getDataSet operation
            */
           public void receiveResultgetDataSet(
                    de.daenet.www.webservices.currencyserver.CurrencyServerWebServiceStub.GetDataSetResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getDataSet operation
           */
            public void receiveErrorgetDataSet(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getXmlStream method
            * override this method for handling normal response from getXmlStream operation
            */
           public void receiveResultgetXmlStream(
                    de.daenet.www.webservices.currencyserver.CurrencyServerWebServiceStub.GetXmlStreamResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getXmlStream operation
           */
            public void receiveErrorgetXmlStream(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getCurrencyValue method
            * override this method for handling normal response from getCurrencyValue operation
            */
           public void receiveResultgetCurrencyValue(
                    de.daenet.www.webservices.currencyserver.CurrencyServerWebServiceStub.GetCurrencyValueResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getCurrencyValue operation
           */
            public void receiveErrorgetCurrencyValue(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getProviderDescription method
            * override this method for handling normal response from getProviderDescription operation
            */
           public void receiveResultgetProviderDescription(
                    de.daenet.www.webservices.currencyserver.CurrencyServerWebServiceStub.GetProviderDescriptionResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getProviderDescription operation
           */
            public void receiveErrorgetProviderDescription(java.lang.Exception e) {
            }
                


    }
    