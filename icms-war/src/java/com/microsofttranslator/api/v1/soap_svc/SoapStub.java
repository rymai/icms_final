/**
 * SoapStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.1  Built on : Oct 19, 2009 (10:59:00 EDT)
 */
package com.microsofttranslator.api.v1.soap_svc;

/*
 *  SoapStub java implementation
 */
public class SoapStub extends org.apache.axis2.client.Stub {

    protected org.apache.axis2.description.AxisOperation[] _operations;
    //hashmaps to keep the fault mapping
    private java.util.HashMap faultExceptionNameMap = new java.util.HashMap();
    private java.util.HashMap faultExceptionClassNameMap = new java.util.HashMap();
    private java.util.HashMap faultMessageMap = new java.util.HashMap();
    private static int counter = 0;

    private static synchronized java.lang.String getUniqueSuffix() {
        // reset the counter if it is greater than 99999
        if (counter > 99999) {
            counter = 0;
        }
        counter = counter + 1;
        return java.lang.Long.toString(System.currentTimeMillis()) + "_" + counter;
    }

    private void populateAxisService() throws org.apache.axis2.AxisFault {

        //creating the Service with a unique name
        _service = new org.apache.axis2.description.AxisService("Soap" + getUniqueSuffix());
        addAnonymousOperations();

        //creating the operations
        org.apache.axis2.description.AxisOperation __operation;

        _operations = new org.apache.axis2.description.AxisOperation[4];

        __operation = new org.apache.axis2.description.OutInAxisOperation();


        __operation.setName(new javax.xml.namespace.QName(
                "http://api.microsofttranslator.com/v1/soap.svc", "detect"));
        _service.addOperation(__operation);




        _operations[0] = __operation;


        __operation = new org.apache.axis2.description.OutInAxisOperation();


        __operation.setName(new javax.xml.namespace.QName(
                "http://api.microsofttranslator.com/v1/soap.svc", "translate"));
        _service.addOperation(__operation);




        _operations[1] = __operation;


        __operation = new org.apache.axis2.description.OutInAxisOperation();


        __operation.setName(new javax.xml.namespace.QName(
                "http://api.microsofttranslator.com/v1/soap.svc", "getLanguageNames"));
        _service.addOperation(__operation);




        _operations[2] = __operation;


        __operation = new org.apache.axis2.description.OutInAxisOperation();


        __operation.setName(new javax.xml.namespace.QName(
                "http://api.microsofttranslator.com/v1/soap.svc", "getLanguages"));
        _service.addOperation(__operation);




        _operations[3] = __operation;


    }

    //populates the faults
    private void populateFaults() {
    }

    /**
     *Constructor that takes in a configContext
     */
    public SoapStub(org.apache.axis2.context.ConfigurationContext configurationContext,
                    java.lang.String targetEndpoint)
            throws org.apache.axis2.AxisFault {
        this(configurationContext, targetEndpoint, false);
    }

    /**
     * Constructor that takes in a configContext  and useseperate listner
     */
    public SoapStub(org.apache.axis2.context.ConfigurationContext configurationContext,
                    java.lang.String targetEndpoint, boolean useSeparateListener)
            throws org.apache.axis2.AxisFault {
        //To populate AxisService
        populateAxisService();
        populateFaults();

        _serviceClient = new org.apache.axis2.client.ServiceClient(configurationContext, _service);


        _serviceClient.getOptions().setTo(new org.apache.axis2.addressing.EndpointReference(
                targetEndpoint));
        _serviceClient.getOptions().setUseSeparateListener(useSeparateListener);


    }

    /**
     * Default Constructor
     */
    public SoapStub(org.apache.axis2.context.ConfigurationContext configurationContext) throws
            org.apache.axis2.AxisFault {

        this(configurationContext, "http://api.microsofttranslator.com/V1/Soap.svc");

    }

    /**
     * Default Constructor
     */
    public SoapStub() throws org.apache.axis2.AxisFault {

        this("http://api.microsofttranslator.com/V1/Soap.svc");

    }

    /**
     * Constructor taking the target endpoint
     */
    public SoapStub(java.lang.String targetEndpoint) throws org.apache.axis2.AxisFault {
        this(null, targetEndpoint);
    }

    /**
     * Auto generated method signature
     *
     * @see com.microsofttranslator.api.v1.soap_svc.Soap#detect
     * @param detect0

     */
    public com.microsofttranslator.api.v1.soap_svc.SoapStub.DetectResponse detect(
            com.microsofttranslator.api.v1.soap_svc.SoapStub.Detect detect0)
            throws java.rmi.RemoteException {
        org.apache.axis2.context.MessageContext _messageContext = null;
        try {
            org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[0].
                    getName());
            _operationClient.getOptions().setAction(
                    "http://api.microsofttranslator.com/v1/soap.svc/LanguageService/Detect");
            _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);



            addPropertyToOperationClient(_operationClient,
                                         org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
                                         "&");


            // create a message context
            _messageContext = new org.apache.axis2.context.MessageContext();



            // create SOAP envelope with that payload
            org.apache.axiom.soap.SOAPEnvelope env = null;


            env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                             detect0,
                             optimizeContent(new javax.xml.namespace.QName(
                    "http://api.microsofttranslator.com/v1/soap.svc",
                                                                           "detect")));

            //adding SOAP soap_headers
            _serviceClient.addHeadersToEnvelope(env);
            // set the message context with that soap envelope
            _messageContext.setEnvelope(env);

            // add the message contxt to the operation client
            _operationClient.addMessageContext(_messageContext);

            //execute the operation client
            _operationClient.execute(true);


            org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.
                    getMessageContext(
                    org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
            org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();


            java.lang.Object object = fromOM(
                    _returnEnv.getBody().getFirstElement(),
                    com.microsofttranslator.api.v1.soap_svc.SoapStub.DetectResponse.class,
                    getEnvelopeNamespaces(_returnEnv));


            return (com.microsofttranslator.api.v1.soap_svc.SoapStub.DetectResponse) object;

        } catch (org.apache.axis2.AxisFault f) {

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt != null) {
                if (faultExceptionNameMap.containsKey(faultElt.getQName())) {
                    //make the fault by reflection
                    try {
                        java.lang.String exceptionClassName = (java.lang.String) faultExceptionClassNameMap.
                                get(faultElt.getQName());
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.Exception ex =
                                            (java.lang.Exception) exceptionClass.newInstance();
                        //message class
                        java.lang.String messageClassName = (java.lang.String) faultMessageMap.get(faultElt.
                                getQName());
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt, messageClass, null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                                                              new java.lang.Class[]{
                                    messageClass});
                        m.invoke(ex, new java.lang.Object[]{messageObject});


                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    } catch (java.lang.ClassCastException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                } else {
                    throw f;
                }
            } else {
                throw f;
            }
        } finally {
            _messageContext.getTransportOut().getSender().cleanup(_messageContext);
        }
    }

    /**
     * Auto generated method signature for Asynchronous Invocations
     *
     * @see com.microsofttranslator.api.v1.soap_svc.Soap#startdetect
     * @param detect0

     */
    public void startdetect(
            com.microsofttranslator.api.v1.soap_svc.SoapStub.Detect detect0,
            final com.microsofttranslator.api.v1.soap_svc.SoapCallbackHandler callback)
            throws java.rmi.RemoteException {

        org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[0].
                getName());
        _operationClient.getOptions().setAction(
                "http://api.microsofttranslator.com/v1/soap.svc/LanguageService/Detect");
        _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);



        addPropertyToOperationClient(_operationClient,
                                     org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
                                     "&");



        // create SOAP envelope with that payload
        org.apache.axiom.soap.SOAPEnvelope env = null;
        final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();


        //Style is Doc.


        env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                         detect0,
                         optimizeContent(new javax.xml.namespace.QName(
                "http://api.microsofttranslator.com/v1/soap.svc",
                                                                       "detect")));

        // adding SOAP soap_headers
        _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);



        _operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {

            public void onMessage(org.apache.axis2.context.MessageContext resultContext) {
                try {
                    org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();

                    java.lang.Object object = fromOM(resultEnv.getBody().getFirstElement(),
                                                     com.microsofttranslator.api.v1.soap_svc.SoapStub.DetectResponse.class,
                                                     getEnvelopeNamespaces(resultEnv));
                    callback.receiveResultdetect(
                            (com.microsofttranslator.api.v1.soap_svc.SoapStub.DetectResponse) object);

                } catch (org.apache.axis2.AxisFault e) {
                    callback.receiveErrordetect(e);
                }
            }

            public void onError(java.lang.Exception error) {
                if (error instanceof org.apache.axis2.AxisFault) {
                    org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
                    org.apache.axiom.om.OMElement faultElt = f.getDetail();
                    if (faultElt != null) {
                        if (faultExceptionNameMap.containsKey(faultElt.getQName())) {
                            //make the fault by reflection
                            try {
                                java.lang.String exceptionClassName = (java.lang.String) faultExceptionClassNameMap.
                                        get(faultElt.getQName());
                                java.lang.Class exceptionClass = java.lang.Class.forName(
                                        exceptionClassName);
                                java.lang.Exception ex =
                                                    (java.lang.Exception) exceptionClass.newInstance();
                                //message class
                                java.lang.String messageClassName = (java.lang.String) faultMessageMap.
                                        get(faultElt.getQName());
                                java.lang.Class messageClass = java.lang.Class.forName(
                                        messageClassName);
                                java.lang.Object messageObject = fromOM(faultElt, messageClass, null);
                                java.lang.reflect.Method m = exceptionClass.getMethod(
                                        "setFaultMessage",
                                                                                      new java.lang.Class[]{
                                            messageClass});
                                m.invoke(ex, new java.lang.Object[]{messageObject});


                                callback.receiveErrordetect(new java.rmi.RemoteException(ex.
                                        getMessage(), ex));
                            } catch (java.lang.ClassCastException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrordetect(f);
                            } catch (java.lang.ClassNotFoundException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrordetect(f);
                            } catch (java.lang.NoSuchMethodException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrordetect(f);
                            } catch (java.lang.reflect.InvocationTargetException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrordetect(f);
                            } catch (java.lang.IllegalAccessException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrordetect(f);
                            } catch (java.lang.InstantiationException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrordetect(f);
                            } catch (org.apache.axis2.AxisFault e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrordetect(f);
                            }
                        } else {
                            callback.receiveErrordetect(f);
                        }
                    } else {
                        callback.receiveErrordetect(f);
                    }
                } else {
                    callback.receiveErrordetect(error);
                }
            }

            public void onFault(org.apache.axis2.context.MessageContext faultContext) {
                org.apache.axis2.AxisFault fault = org.apache.axis2.util.Utils.
                        getInboundFaultFromMessageContext(faultContext);
                onError(fault);
            }

            public void onComplete() {
                try {
                    _messageContext.getTransportOut().getSender().cleanup(_messageContext);
                } catch (org.apache.axis2.AxisFault axisFault) {
                    callback.receiveErrordetect(axisFault);
                }
            }
        });


        org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
        if (_operations[0].getMessageReceiver() == null && _operationClient.getOptions().
                isUseSeparateListener()) {
            _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
            _operations[0].setMessageReceiver(
                    _callbackReceiver);
        }

        //execute the operation client
        _operationClient.execute(false);

    }

    /**
     * Auto generated method signature
     *
     * @see com.microsofttranslator.api.v1.soap_svc.Soap#translate
     * @param translate2

     */
    public com.microsofttranslator.api.v1.soap_svc.SoapStub.TranslateResponse translate(
            com.microsofttranslator.api.v1.soap_svc.SoapStub.Translate translate2)
            throws java.rmi.RemoteException {
        org.apache.axis2.context.MessageContext _messageContext = null;
        try {
            org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[1].
                    getName());
            _operationClient.getOptions().setAction(
                    "http://api.microsofttranslator.com/v1/soap.svc/LanguageService/Translate");
            _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);



            addPropertyToOperationClient(_operationClient,
                                         org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
                                         "&");


            // create a message context
            _messageContext = new org.apache.axis2.context.MessageContext();



            // create SOAP envelope with that payload
            org.apache.axiom.soap.SOAPEnvelope env = null;


            env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                             translate2,
                             optimizeContent(new javax.xml.namespace.QName(
                    "http://api.microsofttranslator.com/v1/soap.svc",
                                                                           "translate")));

            //adding SOAP soap_headers
            _serviceClient.addHeadersToEnvelope(env);
            // set the message context with that soap envelope
            _messageContext.setEnvelope(env);

            // add the message contxt to the operation client
            _operationClient.addMessageContext(_messageContext);

            //execute the operation client
            _operationClient.execute(true);


            org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.
                    getMessageContext(
                    org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
            org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();


            java.lang.Object object = fromOM(
                    _returnEnv.getBody().getFirstElement(),
                    com.microsofttranslator.api.v1.soap_svc.SoapStub.TranslateResponse.class,
                    getEnvelopeNamespaces(_returnEnv));


            return (com.microsofttranslator.api.v1.soap_svc.SoapStub.TranslateResponse) object;

        } catch (org.apache.axis2.AxisFault f) {

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt != null) {
                if (faultExceptionNameMap.containsKey(faultElt.getQName())) {
                    //make the fault by reflection
                    try {
                        java.lang.String exceptionClassName = (java.lang.String) faultExceptionClassNameMap.
                                get(faultElt.getQName());
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.Exception ex =
                                            (java.lang.Exception) exceptionClass.newInstance();
                        //message class
                        java.lang.String messageClassName = (java.lang.String) faultMessageMap.get(faultElt.
                                getQName());
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt, messageClass, null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                                                              new java.lang.Class[]{
                                    messageClass});
                        m.invoke(ex, new java.lang.Object[]{messageObject});


                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    } catch (java.lang.ClassCastException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                } else {
                    throw f;
                }
            } else {
                throw f;
            }
        } finally {
            _messageContext.getTransportOut().getSender().cleanup(_messageContext);
        }
    }

    /**
     * Auto generated method signature for Asynchronous Invocations
     *
     * @see com.microsofttranslator.api.v1.soap_svc.Soap#starttranslate
     * @param translate2

     */
    public void starttranslate(
            com.microsofttranslator.api.v1.soap_svc.SoapStub.Translate translate2,
            final com.microsofttranslator.api.v1.soap_svc.SoapCallbackHandler callback)
            throws java.rmi.RemoteException {

        org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[1].
                getName());
        _operationClient.getOptions().setAction(
                "http://api.microsofttranslator.com/v1/soap.svc/LanguageService/Translate");
        _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);



        addPropertyToOperationClient(_operationClient,
                                     org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
                                     "&");



        // create SOAP envelope with that payload
        org.apache.axiom.soap.SOAPEnvelope env = null;
        final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();


        //Style is Doc.


        env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                         translate2,
                         optimizeContent(new javax.xml.namespace.QName(
                "http://api.microsofttranslator.com/v1/soap.svc",
                                                                       "translate")));

        // adding SOAP soap_headers
        _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);



        _operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {

            public void onMessage(org.apache.axis2.context.MessageContext resultContext) {
                try {
                    org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();

                    java.lang.Object object = fromOM(resultEnv.getBody().getFirstElement(),
                                                     com.microsofttranslator.api.v1.soap_svc.SoapStub.TranslateResponse.class,
                                                     getEnvelopeNamespaces(resultEnv));
                    callback.receiveResulttranslate(
                            (com.microsofttranslator.api.v1.soap_svc.SoapStub.TranslateResponse) object);

                } catch (org.apache.axis2.AxisFault e) {
                    callback.receiveErrortranslate(e);
                }
            }

            public void onError(java.lang.Exception error) {
                if (error instanceof org.apache.axis2.AxisFault) {
                    org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
                    org.apache.axiom.om.OMElement faultElt = f.getDetail();
                    if (faultElt != null) {
                        if (faultExceptionNameMap.containsKey(faultElt.getQName())) {
                            //make the fault by reflection
                            try {
                                java.lang.String exceptionClassName = (java.lang.String) faultExceptionClassNameMap.
                                        get(faultElt.getQName());
                                java.lang.Class exceptionClass = java.lang.Class.forName(
                                        exceptionClassName);
                                java.lang.Exception ex =
                                                    (java.lang.Exception) exceptionClass.newInstance();
                                //message class
                                java.lang.String messageClassName = (java.lang.String) faultMessageMap.
                                        get(faultElt.getQName());
                                java.lang.Class messageClass = java.lang.Class.forName(
                                        messageClassName);
                                java.lang.Object messageObject = fromOM(faultElt, messageClass, null);
                                java.lang.reflect.Method m = exceptionClass.getMethod(
                                        "setFaultMessage",
                                                                                      new java.lang.Class[]{
                                            messageClass});
                                m.invoke(ex, new java.lang.Object[]{messageObject});


                                callback.receiveErrortranslate(new java.rmi.RemoteException(ex.
                                        getMessage(), ex));
                            } catch (java.lang.ClassCastException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrortranslate(f);
                            } catch (java.lang.ClassNotFoundException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrortranslate(f);
                            } catch (java.lang.NoSuchMethodException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrortranslate(f);
                            } catch (java.lang.reflect.InvocationTargetException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrortranslate(f);
                            } catch (java.lang.IllegalAccessException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrortranslate(f);
                            } catch (java.lang.InstantiationException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrortranslate(f);
                            } catch (org.apache.axis2.AxisFault e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrortranslate(f);
                            }
                        } else {
                            callback.receiveErrortranslate(f);
                        }
                    } else {
                        callback.receiveErrortranslate(f);
                    }
                } else {
                    callback.receiveErrortranslate(error);
                }
            }

            public void onFault(org.apache.axis2.context.MessageContext faultContext) {
                org.apache.axis2.AxisFault fault = org.apache.axis2.util.Utils.
                        getInboundFaultFromMessageContext(faultContext);
                onError(fault);
            }

            public void onComplete() {
                try {
                    _messageContext.getTransportOut().getSender().cleanup(_messageContext);
                } catch (org.apache.axis2.AxisFault axisFault) {
                    callback.receiveErrortranslate(axisFault);
                }
            }
        });


        org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
        if (_operations[1].getMessageReceiver() == null && _operationClient.getOptions().
                isUseSeparateListener()) {
            _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
            _operations[1].setMessageReceiver(
                    _callbackReceiver);
        }

        //execute the operation client
        _operationClient.execute(false);

    }

    /**
     * Auto generated method signature
     *
     * @see com.microsofttranslator.api.v1.soap_svc.Soap#getLanguageNames
     * @param getLanguageNames4

     */
    public com.microsofttranslator.api.v1.soap_svc.SoapStub.GetLanguageNamesResponse getLanguageNames(
            com.microsofttranslator.api.v1.soap_svc.SoapStub.GetLanguageNames getLanguageNames4)
            throws java.rmi.RemoteException {
        org.apache.axis2.context.MessageContext _messageContext = null;
        try {
            org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[2].
                    getName());
            _operationClient.getOptions().setAction(
                    "http://api.microsofttranslator.com/v1/soap.svc/LanguageService/GetLanguageNames");
            _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);



            addPropertyToOperationClient(_operationClient,
                                         org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
                                         "&");


            // create a message context
            _messageContext = new org.apache.axis2.context.MessageContext();



            // create SOAP envelope with that payload
            org.apache.axiom.soap.SOAPEnvelope env = null;


            env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                             getLanguageNames4,
                             optimizeContent(new javax.xml.namespace.QName(
                    "http://api.microsofttranslator.com/v1/soap.svc",
                                                                           "getLanguageNames")));

            //adding SOAP soap_headers
            _serviceClient.addHeadersToEnvelope(env);
            // set the message context with that soap envelope
            _messageContext.setEnvelope(env);

            // add the message contxt to the operation client
            _operationClient.addMessageContext(_messageContext);

            //execute the operation client
            _operationClient.execute(true);


            org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.
                    getMessageContext(
                    org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
            org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();


            java.lang.Object object = fromOM(
                    _returnEnv.getBody().getFirstElement(),
                    com.microsofttranslator.api.v1.soap_svc.SoapStub.GetLanguageNamesResponse.class,
                    getEnvelopeNamespaces(_returnEnv));


            return (com.microsofttranslator.api.v1.soap_svc.SoapStub.GetLanguageNamesResponse) object;

        } catch (org.apache.axis2.AxisFault f) {

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt != null) {
                if (faultExceptionNameMap.containsKey(faultElt.getQName())) {
                    //make the fault by reflection
                    try {
                        java.lang.String exceptionClassName = (java.lang.String) faultExceptionClassNameMap.
                                get(faultElt.getQName());
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.Exception ex =
                                            (java.lang.Exception) exceptionClass.newInstance();
                        //message class
                        java.lang.String messageClassName = (java.lang.String) faultMessageMap.get(faultElt.
                                getQName());
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt, messageClass, null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                                                              new java.lang.Class[]{
                                    messageClass});
                        m.invoke(ex, new java.lang.Object[]{messageObject});


                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    } catch (java.lang.ClassCastException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                } else {
                    throw f;
                }
            } else {
                throw f;
            }
        } finally {
            _messageContext.getTransportOut().getSender().cleanup(_messageContext);
        }
    }

    /**
     * Auto generated method signature for Asynchronous Invocations
     *
     * @see com.microsofttranslator.api.v1.soap_svc.Soap#startgetLanguageNames
     * @param getLanguageNames4

     */
    public void startgetLanguageNames(
            com.microsofttranslator.api.v1.soap_svc.SoapStub.GetLanguageNames getLanguageNames4,
            final com.microsofttranslator.api.v1.soap_svc.SoapCallbackHandler callback)
            throws java.rmi.RemoteException {

        org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[2].
                getName());
        _operationClient.getOptions().setAction(
                "http://api.microsofttranslator.com/v1/soap.svc/LanguageService/GetLanguageNames");
        _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);



        addPropertyToOperationClient(_operationClient,
                                     org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
                                     "&");



        // create SOAP envelope with that payload
        org.apache.axiom.soap.SOAPEnvelope env = null;
        final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();


        //Style is Doc.


        env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                         getLanguageNames4,
                         optimizeContent(new javax.xml.namespace.QName(
                "http://api.microsofttranslator.com/v1/soap.svc",
                                                                       "getLanguageNames")));

        // adding SOAP soap_headers
        _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);



        _operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {

            public void onMessage(org.apache.axis2.context.MessageContext resultContext) {
                try {
                    org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();

                    java.lang.Object object = fromOM(resultEnv.getBody().getFirstElement(),
                                                     com.microsofttranslator.api.v1.soap_svc.SoapStub.GetLanguageNamesResponse.class,
                                                     getEnvelopeNamespaces(resultEnv));
                    callback.receiveResultgetLanguageNames(
                            (com.microsofttranslator.api.v1.soap_svc.SoapStub.GetLanguageNamesResponse) object);

                } catch (org.apache.axis2.AxisFault e) {
                    callback.receiveErrorgetLanguageNames(e);
                }
            }

            public void onError(java.lang.Exception error) {
                if (error instanceof org.apache.axis2.AxisFault) {
                    org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
                    org.apache.axiom.om.OMElement faultElt = f.getDetail();
                    if (faultElt != null) {
                        if (faultExceptionNameMap.containsKey(faultElt.getQName())) {
                            //make the fault by reflection
                            try {
                                java.lang.String exceptionClassName = (java.lang.String) faultExceptionClassNameMap.
                                        get(faultElt.getQName());
                                java.lang.Class exceptionClass = java.lang.Class.forName(
                                        exceptionClassName);
                                java.lang.Exception ex =
                                                    (java.lang.Exception) exceptionClass.newInstance();
                                //message class
                                java.lang.String messageClassName = (java.lang.String) faultMessageMap.
                                        get(faultElt.getQName());
                                java.lang.Class messageClass = java.lang.Class.forName(
                                        messageClassName);
                                java.lang.Object messageObject = fromOM(faultElt, messageClass, null);
                                java.lang.reflect.Method m = exceptionClass.getMethod(
                                        "setFaultMessage",
                                                                                      new java.lang.Class[]{
                                            messageClass});
                                m.invoke(ex, new java.lang.Object[]{messageObject});


                                callback.receiveErrorgetLanguageNames(new java.rmi.RemoteException(ex.
                                        getMessage(), ex));
                            } catch (java.lang.ClassCastException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorgetLanguageNames(f);
                            } catch (java.lang.ClassNotFoundException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorgetLanguageNames(f);
                            } catch (java.lang.NoSuchMethodException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorgetLanguageNames(f);
                            } catch (java.lang.reflect.InvocationTargetException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorgetLanguageNames(f);
                            } catch (java.lang.IllegalAccessException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorgetLanguageNames(f);
                            } catch (java.lang.InstantiationException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorgetLanguageNames(f);
                            } catch (org.apache.axis2.AxisFault e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorgetLanguageNames(f);
                            }
                        } else {
                            callback.receiveErrorgetLanguageNames(f);
                        }
                    } else {
                        callback.receiveErrorgetLanguageNames(f);
                    }
                } else {
                    callback.receiveErrorgetLanguageNames(error);
                }
            }

            public void onFault(org.apache.axis2.context.MessageContext faultContext) {
                org.apache.axis2.AxisFault fault = org.apache.axis2.util.Utils.
                        getInboundFaultFromMessageContext(faultContext);
                onError(fault);
            }

            public void onComplete() {
                try {
                    _messageContext.getTransportOut().getSender().cleanup(_messageContext);
                } catch (org.apache.axis2.AxisFault axisFault) {
                    callback.receiveErrorgetLanguageNames(axisFault);
                }
            }
        });


        org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
        if (_operations[2].getMessageReceiver() == null && _operationClient.getOptions().
                isUseSeparateListener()) {
            _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
            _operations[2].setMessageReceiver(
                    _callbackReceiver);
        }

        //execute the operation client
        _operationClient.execute(false);

    }

    /**
     * Auto generated method signature
     *
     * @see com.microsofttranslator.api.v1.soap_svc.Soap#getLanguages
     * @param getLanguages6

     */
    public com.microsofttranslator.api.v1.soap_svc.SoapStub.GetLanguagesResponse getLanguages(
            com.microsofttranslator.api.v1.soap_svc.SoapStub.GetLanguages getLanguages6)
            throws java.rmi.RemoteException {
        org.apache.axis2.context.MessageContext _messageContext = null;
        try {
            org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[3].
                    getName());
            _operationClient.getOptions().setAction(
                    "http://api.microsofttranslator.com/v1/soap.svc/LanguageService/GetLanguages");
            _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);



            addPropertyToOperationClient(_operationClient,
                                         org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
                                         "&");


            // create a message context
            _messageContext = new org.apache.axis2.context.MessageContext();



            // create SOAP envelope with that payload
            org.apache.axiom.soap.SOAPEnvelope env = null;


            env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                             getLanguages6,
                             optimizeContent(new javax.xml.namespace.QName(
                    "http://api.microsofttranslator.com/v1/soap.svc",
                                                                           "getLanguages")));

            //adding SOAP soap_headers
            _serviceClient.addHeadersToEnvelope(env);
            // set the message context with that soap envelope
            _messageContext.setEnvelope(env);

            // add the message contxt to the operation client
            _operationClient.addMessageContext(_messageContext);

            //execute the operation client
            _operationClient.execute(true);


            org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.
                    getMessageContext(
                    org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
            org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();


            java.lang.Object object = fromOM(
                    _returnEnv.getBody().getFirstElement(),
                    com.microsofttranslator.api.v1.soap_svc.SoapStub.GetLanguagesResponse.class,
                    getEnvelopeNamespaces(_returnEnv));


            return (com.microsofttranslator.api.v1.soap_svc.SoapStub.GetLanguagesResponse) object;

        } catch (org.apache.axis2.AxisFault f) {

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt != null) {
                if (faultExceptionNameMap.containsKey(faultElt.getQName())) {
                    //make the fault by reflection
                    try {
                        java.lang.String exceptionClassName = (java.lang.String) faultExceptionClassNameMap.
                                get(faultElt.getQName());
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.Exception ex =
                                            (java.lang.Exception) exceptionClass.newInstance();
                        //message class
                        java.lang.String messageClassName = (java.lang.String) faultMessageMap.get(faultElt.
                                getQName());
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt, messageClass, null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                                                              new java.lang.Class[]{
                                    messageClass});
                        m.invoke(ex, new java.lang.Object[]{messageObject});


                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    } catch (java.lang.ClassCastException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                } else {
                    throw f;
                }
            } else {
                throw f;
            }
        } finally {
            _messageContext.getTransportOut().getSender().cleanup(_messageContext);
        }
    }

    /**
     * Auto generated method signature for Asynchronous Invocations
     *
     * @see com.microsofttranslator.api.v1.soap_svc.Soap#startgetLanguages
     * @param getLanguages6

     */
    public void startgetLanguages(
            com.microsofttranslator.api.v1.soap_svc.SoapStub.GetLanguages getLanguages6,
            final com.microsofttranslator.api.v1.soap_svc.SoapCallbackHandler callback)
            throws java.rmi.RemoteException {

        org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[3].
                getName());
        _operationClient.getOptions().setAction(
                "http://api.microsofttranslator.com/v1/soap.svc/LanguageService/GetLanguages");
        _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);



        addPropertyToOperationClient(_operationClient,
                                     org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
                                     "&");



        // create SOAP envelope with that payload
        org.apache.axiom.soap.SOAPEnvelope env = null;
        final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();


        //Style is Doc.


        env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                         getLanguages6,
                         optimizeContent(new javax.xml.namespace.QName(
                "http://api.microsofttranslator.com/v1/soap.svc",
                                                                       "getLanguages")));

        // adding SOAP soap_headers
        _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);



        _operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {

            public void onMessage(org.apache.axis2.context.MessageContext resultContext) {
                try {
                    org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();

                    java.lang.Object object = fromOM(resultEnv.getBody().getFirstElement(),
                                                     com.microsofttranslator.api.v1.soap_svc.SoapStub.GetLanguagesResponse.class,
                                                     getEnvelopeNamespaces(resultEnv));
                    callback.receiveResultgetLanguages(
                            (com.microsofttranslator.api.v1.soap_svc.SoapStub.GetLanguagesResponse) object);

                } catch (org.apache.axis2.AxisFault e) {
                    callback.receiveErrorgetLanguages(e);
                }
            }

            public void onError(java.lang.Exception error) {
                if (error instanceof org.apache.axis2.AxisFault) {
                    org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
                    org.apache.axiom.om.OMElement faultElt = f.getDetail();
                    if (faultElt != null) {
                        if (faultExceptionNameMap.containsKey(faultElt.getQName())) {
                            //make the fault by reflection
                            try {
                                java.lang.String exceptionClassName = (java.lang.String) faultExceptionClassNameMap.
                                        get(faultElt.getQName());
                                java.lang.Class exceptionClass = java.lang.Class.forName(
                                        exceptionClassName);
                                java.lang.Exception ex =
                                                    (java.lang.Exception) exceptionClass.newInstance();
                                //message class
                                java.lang.String messageClassName = (java.lang.String) faultMessageMap.
                                        get(faultElt.getQName());
                                java.lang.Class messageClass = java.lang.Class.forName(
                                        messageClassName);
                                java.lang.Object messageObject = fromOM(faultElt, messageClass, null);
                                java.lang.reflect.Method m = exceptionClass.getMethod(
                                        "setFaultMessage",
                                                                                      new java.lang.Class[]{
                                            messageClass});
                                m.invoke(ex, new java.lang.Object[]{messageObject});


                                callback.receiveErrorgetLanguages(new java.rmi.RemoteException(ex.
                                        getMessage(), ex));
                            } catch (java.lang.ClassCastException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorgetLanguages(f);
                            } catch (java.lang.ClassNotFoundException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorgetLanguages(f);
                            } catch (java.lang.NoSuchMethodException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorgetLanguages(f);
                            } catch (java.lang.reflect.InvocationTargetException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorgetLanguages(f);
                            } catch (java.lang.IllegalAccessException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorgetLanguages(f);
                            } catch (java.lang.InstantiationException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorgetLanguages(f);
                            } catch (org.apache.axis2.AxisFault e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorgetLanguages(f);
                            }
                        } else {
                            callback.receiveErrorgetLanguages(f);
                        }
                    } else {
                        callback.receiveErrorgetLanguages(f);
                    }
                } else {
                    callback.receiveErrorgetLanguages(error);
                }
            }

            public void onFault(org.apache.axis2.context.MessageContext faultContext) {
                org.apache.axis2.AxisFault fault = org.apache.axis2.util.Utils.
                        getInboundFaultFromMessageContext(faultContext);
                onError(fault);
            }

            public void onComplete() {
                try {
                    _messageContext.getTransportOut().getSender().cleanup(_messageContext);
                } catch (org.apache.axis2.AxisFault axisFault) {
                    callback.receiveErrorgetLanguages(axisFault);
                }
            }
        });


        org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
        if (_operations[3].getMessageReceiver() == null && _operationClient.getOptions().
                isUseSeparateListener()) {
            _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
            _operations[3].setMessageReceiver(
                    _callbackReceiver);
        }

        //execute the operation client
        _operationClient.execute(false);

    }

    /**
     *  A utility method that copies the namepaces from the SOAPEnvelope
     */
    private java.util.Map getEnvelopeNamespaces(org.apache.axiom.soap.SOAPEnvelope env) {
        java.util.Map returnMap = new java.util.HashMap();
        java.util.Iterator namespaceIterator = env.getAllDeclaredNamespaces();
        while (namespaceIterator.hasNext()) {
            org.apache.axiom.om.OMNamespace ns = (org.apache.axiom.om.OMNamespace) namespaceIterator.
                    next();
            returnMap.put(ns.getPrefix(), ns.getNamespaceURI());
        }
        return returnMap;
    }
    private javax.xml.namespace.QName[] opNameArray = null;

    private boolean optimizeContent(javax.xml.namespace.QName opName) {


        if (opNameArray == null) {
            return false;
        }
        for (int i = 0; i < opNameArray.length; i++) {
            if (opName.equals(opNameArray[i])) {
                return true;
            }
        }
        return false;
    }
    //http://api.microsofttranslator.com/V1/Soap.svc

    public static class UnsignedInt
            implements org.apache.axis2.databinding.ADBBean {

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "http://schemas.microsoft.com/2003/10/Serialization/",
                "unsignedInt",
                "ns3");

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if (namespace.equals("http://schemas.microsoft.com/2003/10/Serialization/")) {
                return "ns3";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }
        /**
         * field for UnsignedInt
         */
        protected org.apache.axis2.databinding.types.UnsignedInt localUnsignedInt;

        /**
         * Auto generated getter method
         * @return org.apache.axis2.databinding.types.UnsignedInt
         */
        public org.apache.axis2.databinding.types.UnsignedInt getUnsignedInt() {
            return localUnsignedInt;
        }

        /**
         * Auto generated setter method
         * @param param UnsignedInt
         */
        public void setUnsignedInt(org.apache.axis2.databinding.types.UnsignedInt param) {

            this.localUnsignedInt = param;


        }

        /**
         * isReaderMTOMAware
         * @return true if the reader supports MTOM
         */
        public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
            boolean isReaderMTOMAware = false;

            try {
                isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(
                        org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
            } catch (java.lang.IllegalArgumentException e) {
                isReaderMTOMAware = false;
            }
            return isReaderMTOMAware;
        }

        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory) throws
                org.apache.axis2.databinding.ADBException {



            org.apache.axiom.om.OMDataSource dataSource =
                                             new org.apache.axis2.databinding.ADBDataSource(this,
                                                                                            MY_QNAME) {

                public void serialize(
                        org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                        throws javax.xml.stream.XMLStreamException {
                    UnsignedInt.this.serialize(MY_QNAME, factory, xmlWriter);
                }
            };
            return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
                    MY_QNAME, factory, dataSource);

        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              final org.apache.axiom.om.OMFactory factory,
                              org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException,
                       org.apache.axis2.databinding.ADBException {
            serialize(parentQName, factory, xmlWriter, false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              final org.apache.axiom.om.OMFactory factory,
                              org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                              boolean serializeType)
                throws javax.xml.stream.XMLStreamException,
                       org.apache.axis2.databinding.ADBException {


            //We can safely assume an element has only one type associated with it

            java.lang.String namespace = "http://schemas.microsoft.com/2003/10/Serialization/";
            java.lang.String localName = "unsignedInt";

            if (!namespace.equals("")) {
                java.lang.String prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    xmlWriter.writeStartElement(prefix, localName, namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);

                } else {
                    xmlWriter.writeStartElement(namespace, localName);
                }

            } else {
                xmlWriter.writeStartElement(localName);
            }

            // add the type details if this is used in a simple type
            if (serializeType) {
                java.lang.String namespacePrefix = registerPrefix(xmlWriter,
                                                                  "http://schemas.microsoft.com/2003/10/Serialization/");
                if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                                   namespacePrefix + ":unsignedInt",
                                   xmlWriter);
                } else {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                                   "unsignedInt",
                                   xmlWriter);
                }
            }

            if (localUnsignedInt == null) {

                // write the nil attribute
                writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                               xmlWriter);

            } else {

                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.
                        convertToString(localUnsignedInt));

            }

            xmlWriter.writeEndElement();



        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(java.lang.String prefix, java.lang.String namespace,
                                    java.lang.String attName,
                                    java.lang.String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);

            }

            xmlWriter.writeAttribute(namespace, attName, attValue);

        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace, java.lang.String attName,
                                    java.lang.String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                         javax.xml.namespace.QName qname,
                                         javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         *  method to handle Qnames
         */
        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.
                            convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.
                            convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.
                        convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.
                                    convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.
                                    convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.
                                convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }

        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter,
                                                java.lang.String namespace) throws
                javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);

            if (prefix == null) {
                prefix = generatePrefix(namespace);

                while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }

                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         *
         */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                throws org.apache.axis2.databinding.ADBException {




            //We can safely assume an element has only one type associated with it

            if (localUnsignedInt == null) {
                return new org.apache.axis2.databinding.utils.reader.NullXMLStreamReader(MY_QNAME);
            } else {
                return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(MY_QNAME,
                                                                                            new java.lang.Object[]{
                            org.apache.axis2.databinding.utils.reader.ADBXMLStreamReader.ELEMENT_TEXT,
                            org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                            localUnsignedInt)
                        },
                                                                                            null);
            }


        }

        /**
         *  Factory class that keeps the parse method
         */
        public static class Factory {

            /**
             * static method to create the object
             * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
             *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
             * Postcondition: If this object is an element, the reader is positioned at its end element
             *                If this object is a complex type, the reader is positioned at the end element of its outer element
             */
            public static UnsignedInt parse(javax.xml.stream.XMLStreamReader reader) throws
                    java.lang.Exception {
                UnsignedInt object =
                            new UnsignedInt();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while (!reader.isStartElement() && !reader.isEndElement()) {
                        reader.next();
                    }


                    nillableValue = reader.getAttributeValue(
                            "http://www.w3.org/2001/XMLSchema-instance", "nil");
                    if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                        // Skip the element and report the null value.  It cannot have subelements.
                        while (!reader.isEndElement()) {
                            reader.next();
                        }

                        return object;


                    }



                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();



                    while (!reader.isEndElement()) {
                        if (reader.isStartElement()) {

                            if (reader.isStartElement() && new javax.xml.namespace.QName(
                                    "http://schemas.microsoft.com/2003/10/Serialization/",
                                                                                         "unsignedInt").
                                    equals(reader.getName())) {

                                nillableValue = reader.getAttributeValue(
                                        "http://www.w3.org/2001/XMLSchema-instance", "nil");
                                if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

                                    java.lang.String content = reader.getElementText();

                                    object.setUnsignedInt(
                                            org.apache.axis2.databinding.utils.ConverterUtil.
                                            convertToUnsignedInt(content));

                                } else {


                                    reader.getElementText(); // throw away text nodes if any.
                                }

                            } // End of if for expected property start element
                            else {
                                // A start element we are not expecting indicates an invalid parameter was passed
                                throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.
                                        getLocalName());
                            }

                        } else {
                            reader.next();
                        }
                    }  // end of while loop




                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }
        }//end of factory class

    }

    public static class UnsignedLong
            implements org.apache.axis2.databinding.ADBBean {

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "http://schemas.microsoft.com/2003/10/Serialization/",
                "unsignedLong",
                "ns3");

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if (namespace.equals("http://schemas.microsoft.com/2003/10/Serialization/")) {
                return "ns3";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }
        /**
         * field for UnsignedLong
         */
        protected org.apache.axis2.databinding.types.UnsignedLong localUnsignedLong;

        /**
         * Auto generated getter method
         * @return org.apache.axis2.databinding.types.UnsignedLong
         */
        public org.apache.axis2.databinding.types.UnsignedLong getUnsignedLong() {
            return localUnsignedLong;
        }

        /**
         * Auto generated setter method
         * @param param UnsignedLong
         */
        public void setUnsignedLong(org.apache.axis2.databinding.types.UnsignedLong param) {

            this.localUnsignedLong = param;


        }

        /**
         * isReaderMTOMAware
         * @return true if the reader supports MTOM
         */
        public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
            boolean isReaderMTOMAware = false;

            try {
                isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(
                        org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
            } catch (java.lang.IllegalArgumentException e) {
                isReaderMTOMAware = false;
            }
            return isReaderMTOMAware;
        }

        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory) throws
                org.apache.axis2.databinding.ADBException {



            org.apache.axiom.om.OMDataSource dataSource =
                                             new org.apache.axis2.databinding.ADBDataSource(this,
                                                                                            MY_QNAME) {

                public void serialize(
                        org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                        throws javax.xml.stream.XMLStreamException {
                    UnsignedLong.this.serialize(MY_QNAME, factory, xmlWriter);
                }
            };
            return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
                    MY_QNAME, factory, dataSource);

        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              final org.apache.axiom.om.OMFactory factory,
                              org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException,
                       org.apache.axis2.databinding.ADBException {
            serialize(parentQName, factory, xmlWriter, false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              final org.apache.axiom.om.OMFactory factory,
                              org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                              boolean serializeType)
                throws javax.xml.stream.XMLStreamException,
                       org.apache.axis2.databinding.ADBException {


            //We can safely assume an element has only one type associated with it

            java.lang.String namespace = "http://schemas.microsoft.com/2003/10/Serialization/";
            java.lang.String localName = "unsignedLong";

            if (!namespace.equals("")) {
                java.lang.String prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    xmlWriter.writeStartElement(prefix, localName, namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);

                } else {
                    xmlWriter.writeStartElement(namespace, localName);
                }

            } else {
                xmlWriter.writeStartElement(localName);
            }

            // add the type details if this is used in a simple type
            if (serializeType) {
                java.lang.String namespacePrefix = registerPrefix(xmlWriter,
                                                                  "http://schemas.microsoft.com/2003/10/Serialization/");
                if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                                   namespacePrefix + ":unsignedLong",
                                   xmlWriter);
                } else {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                                   "unsignedLong",
                                   xmlWriter);
                }
            }

            if (localUnsignedLong == null) {

                // write the nil attribute
                writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                               xmlWriter);

            } else {

                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.
                        convertToString(localUnsignedLong));

            }

            xmlWriter.writeEndElement();



        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(java.lang.String prefix, java.lang.String namespace,
                                    java.lang.String attName,
                                    java.lang.String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);

            }

            xmlWriter.writeAttribute(namespace, attName, attValue);

        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace, java.lang.String attName,
                                    java.lang.String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                         javax.xml.namespace.QName qname,
                                         javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         *  method to handle Qnames
         */
        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.
                            convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.
                            convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.
                        convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.
                                    convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.
                                    convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.
                                convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }

        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter,
                                                java.lang.String namespace) throws
                javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);

            if (prefix == null) {
                prefix = generatePrefix(namespace);

                while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }

                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         *
         */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                throws org.apache.axis2.databinding.ADBException {




            //We can safely assume an element has only one type associated with it

            if (localUnsignedLong == null) {
                return new org.apache.axis2.databinding.utils.reader.NullXMLStreamReader(MY_QNAME);
            } else {
                return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(MY_QNAME,
                                                                                            new java.lang.Object[]{
                            org.apache.axis2.databinding.utils.reader.ADBXMLStreamReader.ELEMENT_TEXT,
                            org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                            localUnsignedLong)
                        },
                                                                                            null);
            }


        }

        /**
         *  Factory class that keeps the parse method
         */
        public static class Factory {

            /**
             * static method to create the object
             * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
             *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
             * Postcondition: If this object is an element, the reader is positioned at its end element
             *                If this object is a complex type, the reader is positioned at the end element of its outer element
             */
            public static UnsignedLong parse(javax.xml.stream.XMLStreamReader reader) throws
                    java.lang.Exception {
                UnsignedLong object =
                             new UnsignedLong();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while (!reader.isStartElement() && !reader.isEndElement()) {
                        reader.next();
                    }


                    nillableValue = reader.getAttributeValue(
                            "http://www.w3.org/2001/XMLSchema-instance", "nil");
                    if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                        // Skip the element and report the null value.  It cannot have subelements.
                        while (!reader.isEndElement()) {
                            reader.next();
                        }

                        return object;


                    }



                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();



                    while (!reader.isEndElement()) {
                        if (reader.isStartElement()) {

                            if (reader.isStartElement() && new javax.xml.namespace.QName(
                                    "http://schemas.microsoft.com/2003/10/Serialization/",
                                                                                         "unsignedLong").
                                    equals(reader.getName())) {

                                nillableValue = reader.getAttributeValue(
                                        "http://www.w3.org/2001/XMLSchema-instance", "nil");
                                if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

                                    java.lang.String content = reader.getElementText();

                                    object.setUnsignedLong(
                                            org.apache.axis2.databinding.utils.ConverterUtil.
                                            convertToUnsignedLong(content));

                                } else {


                                    reader.getElementText(); // throw away text nodes if any.
                                }

                            } // End of if for expected property start element
                            else {
                                // A start element we are not expecting indicates an invalid parameter was passed
                                throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.
                                        getLocalName());
                            }

                        } else {
                            reader.next();
                        }
                    }  // end of while loop




                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }
        }//end of factory class

    }

    public static class AnyType
            implements org.apache.axis2.databinding.ADBBean {

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "http://schemas.microsoft.com/2003/10/Serialization/",
                "anyType",
                "ns3");

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if (namespace.equals("http://schemas.microsoft.com/2003/10/Serialization/")) {
                return "ns3";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }
        /**
         * field for AnyType
         */
        protected java.lang.Object localAnyType;

        /**
         * Auto generated getter method
         * @return java.lang.Object
         */
        public java.lang.Object getAnyType() {
            return localAnyType;
        }

        /**
         * Auto generated setter method
         * @param param AnyType
         */
        public void setAnyType(java.lang.Object param) {

            this.localAnyType = param;


        }

        /**
         * isReaderMTOMAware
         * @return true if the reader supports MTOM
         */
        public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
            boolean isReaderMTOMAware = false;

            try {
                isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(
                        org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
            } catch (java.lang.IllegalArgumentException e) {
                isReaderMTOMAware = false;
            }
            return isReaderMTOMAware;
        }

        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory) throws
                org.apache.axis2.databinding.ADBException {



            org.apache.axiom.om.OMDataSource dataSource =
                                             new org.apache.axis2.databinding.ADBDataSource(this,
                                                                                            MY_QNAME) {

                public void serialize(
                        org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                        throws javax.xml.stream.XMLStreamException {
                    AnyType.this.serialize(MY_QNAME, factory, xmlWriter);
                }
            };
            return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
                    MY_QNAME, factory, dataSource);

        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              final org.apache.axiom.om.OMFactory factory,
                              org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException,
                       org.apache.axis2.databinding.ADBException {
            serialize(parentQName, factory, xmlWriter, false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              final org.apache.axiom.om.OMFactory factory,
                              org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                              boolean serializeType)
                throws javax.xml.stream.XMLStreamException,
                       org.apache.axis2.databinding.ADBException {


            //We can safely assume an element has only one type associated with it

            java.lang.String namespace = "http://schemas.microsoft.com/2003/10/Serialization/";
            java.lang.String localName = "anyType";

            if (!namespace.equals("")) {
                java.lang.String prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    xmlWriter.writeStartElement(prefix, localName, namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);

                } else {
                    xmlWriter.writeStartElement(namespace, localName);
                }

            } else {
                xmlWriter.writeStartElement(localName);
            }

            // add the type details if this is used in a simple type
            if (serializeType) {
                java.lang.String namespacePrefix = registerPrefix(xmlWriter,
                                                                  "http://schemas.microsoft.com/2003/10/Serialization/");
                if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                                   namespacePrefix + ":anyType",
                                   xmlWriter);
                } else {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                                   "anyType",
                                   xmlWriter);
                }
            }

            if (localAnyType == null) {

                // write the nil attribute
                writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                               xmlWriter);

            } else {

                org.apache.axis2.databinding.utils.ConverterUtil.serializeAnyType(localAnyType,
                                                                                  xmlWriter);

            }

            xmlWriter.writeEndElement();



        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(java.lang.String prefix, java.lang.String namespace,
                                    java.lang.String attName,
                                    java.lang.String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);

            }

            xmlWriter.writeAttribute(namespace, attName, attValue);

        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace, java.lang.String attName,
                                    java.lang.String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                         javax.xml.namespace.QName qname,
                                         javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         *  method to handle Qnames
         */
        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.
                            convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.
                            convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.
                        convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.
                                    convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.
                                    convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.
                                convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }

        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter,
                                                java.lang.String namespace) throws
                javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);

            if (prefix == null) {
                prefix = generatePrefix(namespace);

                while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }

                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         *
         */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                throws org.apache.axis2.databinding.ADBException {




            //We can safely assume an element has only one type associated with it

            if (localAnyType == null) {
                return new org.apache.axis2.databinding.utils.reader.NullXMLStreamReader(MY_QNAME);
            } else {
                return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(MY_QNAME,
                                                                                            new java.lang.Object[]{
                            org.apache.axis2.databinding.utils.reader.ADBXMLStreamReader.ELEMENT_TEXT,
                            org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                            localAnyType)
                        },
                                                                                            null);
            }


        }

        /**
         *  Factory class that keeps the parse method
         */
        public static class Factory {

            /**
             * static method to create the object
             * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
             *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
             * Postcondition: If this object is an element, the reader is positioned at its end element
             *                If this object is a complex type, the reader is positioned at the end element of its outer element
             */
            public static AnyType parse(javax.xml.stream.XMLStreamReader reader) throws
                    java.lang.Exception {
                AnyType object =
                        new AnyType();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while (!reader.isStartElement() && !reader.isEndElement()) {
                        reader.next();
                    }


                    nillableValue = reader.getAttributeValue(
                            "http://www.w3.org/2001/XMLSchema-instance", "nil");
                    if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                        // Skip the element and report the null value.  It cannot have subelements.
                        while (!reader.isEndElement()) {
                            reader.next();
                        }

                        return object;


                    }



                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();



                    while (!reader.isEndElement()) {
                        if (reader.isStartElement()) {

                            if (reader.isStartElement() && new javax.xml.namespace.QName(
                                    "http://schemas.microsoft.com/2003/10/Serialization/", "anyType").
                                    equals(reader.getName())) {

                                object.setAnyType(org.apache.axis2.databinding.utils.ConverterUtil.
                                        getAnyTypeObject(reader,
                                                         ExtensionMapper.class));

                            } // End of if for expected property start element
                            else {
                                // A start element we are not expecting indicates an invalid parameter was passed
                                throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.
                                        getLocalName());
                            }

                        } else {
                            reader.next();
                        }
                    }  // end of while loop




                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }
        }//end of factory class

    }

    public static class GetLanguagesResponse
            implements org.apache.axis2.databinding.ADBBean {

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "http://api.microsofttranslator.com/v1/soap.svc",
                "GetLanguagesResponse",
                "ns2");

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if (namespace.equals("http://api.microsofttranslator.com/v1/soap.svc")) {
                return "ns2";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }
        /**
         * field for GetLanguagesResult
         */
        protected ArrayOfstring localGetLanguagesResult;
        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localGetLanguagesResultTracker = false;

        /**
         * Auto generated getter method
         * @return ArrayOfstring
         */
        public ArrayOfstring getGetLanguagesResult() {
            return localGetLanguagesResult;
        }

        /**
         * Auto generated setter method
         * @param param GetLanguagesResult
         */
        public void setGetLanguagesResult(ArrayOfstring param) {

            if (param != null) {
                //update the setting tracker
                localGetLanguagesResultTracker = true;
            } else {
                localGetLanguagesResultTracker = true;

            }

            this.localGetLanguagesResult = param;


        }

        /**
         * isReaderMTOMAware
         * @return true if the reader supports MTOM
         */
        public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
            boolean isReaderMTOMAware = false;

            try {
                isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(
                        org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
            } catch (java.lang.IllegalArgumentException e) {
                isReaderMTOMAware = false;
            }
            return isReaderMTOMAware;
        }

        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory) throws
                org.apache.axis2.databinding.ADBException {



            org.apache.axiom.om.OMDataSource dataSource =
                                             new org.apache.axis2.databinding.ADBDataSource(this,
                                                                                            MY_QNAME) {

                public void serialize(
                        org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                        throws javax.xml.stream.XMLStreamException {
                    GetLanguagesResponse.this.serialize(MY_QNAME, factory, xmlWriter);
                }
            };
            return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
                    MY_QNAME, factory, dataSource);

        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              final org.apache.axiom.om.OMFactory factory,
                              org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException,
                       org.apache.axis2.databinding.ADBException {
            serialize(parentQName, factory, xmlWriter, false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              final org.apache.axiom.om.OMFactory factory,
                              org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                              boolean serializeType)
                throws javax.xml.stream.XMLStreamException,
                       org.apache.axis2.databinding.ADBException {




            java.lang.String prefix = null;
            java.lang.String namespace = null;


            prefix = parentQName.getPrefix();
            namespace = parentQName.getNamespaceURI();

            if ((namespace != null) && (namespace.trim().length() > 0)) {
                java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
                if (writerPrefix != null) {
                    xmlWriter.writeStartElement(namespace, parentQName.getLocalPart());
                } else {
                    if (prefix == null) {
                        prefix = generatePrefix(namespace);
                    }

                    xmlWriter.writeStartElement(prefix, parentQName.getLocalPart(), namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);
                }
            } else {
                xmlWriter.writeStartElement(parentQName.getLocalPart());
            }

            if (serializeType) {


                java.lang.String namespacePrefix = registerPrefix(xmlWriter,
                                                                  "http://api.microsofttranslator.com/v1/soap.svc");
                if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                                   namespacePrefix + ":GetLanguagesResponse",
                                   xmlWriter);
                } else {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                                   "GetLanguagesResponse",
                                   xmlWriter);
                }


            }
            if (localGetLanguagesResultTracker) {
                if (localGetLanguagesResult == null) {

                    java.lang.String namespace2 = "http://api.microsofttranslator.com/v1/soap.svc";

                    if (!namespace2.equals("")) {
                        java.lang.String prefix2 = xmlWriter.getPrefix(namespace2);

                        if (prefix2 == null) {
                            prefix2 = generatePrefix(namespace2);

                            xmlWriter.writeStartElement(prefix2, "GetLanguagesResult", namespace2);
                            xmlWriter.writeNamespace(prefix2, namespace2);
                            xmlWriter.setPrefix(prefix2, namespace2);

                        } else {
                            xmlWriter.writeStartElement(namespace2, "GetLanguagesResult");
                        }

                    } else {
                        xmlWriter.writeStartElement("GetLanguagesResult");
                    }


                    // write the nil attribute
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                                   xmlWriter);
                    xmlWriter.writeEndElement();
                } else {
                    localGetLanguagesResult.serialize(new javax.xml.namespace.QName(
                            "http://api.microsofttranslator.com/v1/soap.svc", "GetLanguagesResult"),
                                                      factory, xmlWriter);
                }
            }
            xmlWriter.writeEndElement();


        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(java.lang.String prefix, java.lang.String namespace,
                                    java.lang.String attName,
                                    java.lang.String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);

            }

            xmlWriter.writeAttribute(namespace, attName, attValue);

        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace, java.lang.String attName,
                                    java.lang.String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                         javax.xml.namespace.QName qname,
                                         javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         *  method to handle Qnames
         */
        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.
                            convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.
                            convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.
                        convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.
                                    convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.
                                    convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.
                                convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }

        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter,
                                                java.lang.String namespace) throws
                javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);

            if (prefix == null) {
                prefix = generatePrefix(namespace);

                while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }

                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         *
         */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                throws org.apache.axis2.databinding.ADBException {



            java.util.ArrayList elementList = new java.util.ArrayList();
            java.util.ArrayList attribList = new java.util.ArrayList();

            if (localGetLanguagesResultTracker) {
                elementList.add(new javax.xml.namespace.QName(
                        "http://api.microsofttranslator.com/v1/soap.svc",
                                                              "GetLanguagesResult"));


                elementList.add(localGetLanguagesResult == null ? null : localGetLanguagesResult);
            }

            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName,
                                                                                        elementList.
                    toArray(), attribList.toArray());



        }

        /**
         *  Factory class that keeps the parse method
         */
        public static class Factory {

            /**
             * static method to create the object
             * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
             *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
             * Postcondition: If this object is an element, the reader is positioned at its end element
             *                If this object is a complex type, the reader is positioned at the end element of its outer element
             */
            public static GetLanguagesResponse parse(javax.xml.stream.XMLStreamReader reader) throws
                    java.lang.Exception {
                GetLanguagesResponse object =
                                     new GetLanguagesResponse();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while (!reader.isStartElement() && !reader.isEndElement()) {
                        reader.next();
                    }


                    if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type") != null) {
                        java.lang.String fullTypeName = reader.getAttributeValue(
                                "http://www.w3.org/2001/XMLSchema-instance",
                                                                                 "type");
                        if (fullTypeName != null) {
                            java.lang.String nsPrefix = null;
                            if (fullTypeName.indexOf(":") > -1) {
                                nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
                            }
                            nsPrefix = nsPrefix == null ? "" : nsPrefix;

                            java.lang.String type = fullTypeName.substring(
                                    fullTypeName.indexOf(":") + 1);

                            if (!"GetLanguagesResponse".equals(type)) {
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().
                                        getNamespaceURI(nsPrefix);
                                return (GetLanguagesResponse) ExtensionMapper.getTypeObject(
                                        nsUri, type, reader);
                            }


                        }


                    }




                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();




                    reader.next();


                    while (!reader.isStartElement() && !reader.isEndElement()) {
                        reader.next();
                    }

                    if (reader.isStartElement() && new javax.xml.namespace.QName(
                            "http://api.microsofttranslator.com/v1/soap.svc", "GetLanguagesResult").
                            equals(reader.getName())) {

                        nillableValue = reader.getAttributeValue(
                                "http://www.w3.org/2001/XMLSchema-instance", "nil");
                        if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                            object.setGetLanguagesResult(null);
                            reader.next();

                            reader.next();

                        } else {

                            object.setGetLanguagesResult(ArrayOfstring.Factory.parse(reader));

                            reader.next();
                        }
                    } // End of if for expected property start element
                    else {
                    }

                    while (!reader.isStartElement() && !reader.isEndElement()) {
                        reader.next();
                    }

                    if (reader.isStartElement()) // A start element we are not expecting indicates a trailing invalid property
                    {
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.
                                getLocalName());
                    }




                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }
        }//end of factory class

    }

    public static class QName
            implements org.apache.axis2.databinding.ADBBean {

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "http://schemas.microsoft.com/2003/10/Serialization/",
                "QName",
                "ns3");

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if (namespace.equals("http://schemas.microsoft.com/2003/10/Serialization/")) {
                return "ns3";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }
        /**
         * field for QName
         */
        protected javax.xml.namespace.QName localQName;

        /**
         * Auto generated getter method
         * @return javax.xml.namespace.QName
         */
        public javax.xml.namespace.QName getQName() {
            return localQName;
        }

        /**
         * Auto generated setter method
         * @param param QName
         */
        public void setQName(javax.xml.namespace.QName param) {

            this.localQName = param;


        }

        /**
         * isReaderMTOMAware
         * @return true if the reader supports MTOM
         */
        public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
            boolean isReaderMTOMAware = false;

            try {
                isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(
                        org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
            } catch (java.lang.IllegalArgumentException e) {
                isReaderMTOMAware = false;
            }
            return isReaderMTOMAware;
        }

        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory) throws
                org.apache.axis2.databinding.ADBException {



            org.apache.axiom.om.OMDataSource dataSource =
                                             new org.apache.axis2.databinding.ADBDataSource(this,
                                                                                            MY_QNAME) {

                public void serialize(
                        org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                        throws javax.xml.stream.XMLStreamException {
                    QName.this.serialize(MY_QNAME, factory, xmlWriter);
                }
            };
            return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
                    MY_QNAME, factory, dataSource);

        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              final org.apache.axiom.om.OMFactory factory,
                              org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException,
                       org.apache.axis2.databinding.ADBException {
            serialize(parentQName, factory, xmlWriter, false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              final org.apache.axiom.om.OMFactory factory,
                              org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                              boolean serializeType)
                throws javax.xml.stream.XMLStreamException,
                       org.apache.axis2.databinding.ADBException {


            //We can safely assume an element has only one type associated with it

            java.lang.String namespace = "http://schemas.microsoft.com/2003/10/Serialization/";
            java.lang.String localName = "QName";

            if (!namespace.equals("")) {
                java.lang.String prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    xmlWriter.writeStartElement(prefix, localName, namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);

                } else {
                    xmlWriter.writeStartElement(namespace, localName);
                }

            } else {
                xmlWriter.writeStartElement(localName);
            }

            // add the type details if this is used in a simple type
            if (serializeType) {
                java.lang.String namespacePrefix = registerPrefix(xmlWriter,
                                                                  "http://schemas.microsoft.com/2003/10/Serialization/");
                if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                                   namespacePrefix + ":QName",
                                   xmlWriter);
                } else {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                                   "QName",
                                   xmlWriter);
                }
            }

            if (localQName == null) {

                // write the nil attribute
                writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                               xmlWriter);

            } else {

                writeQName(localQName, xmlWriter);

            }

            xmlWriter.writeEndElement();



        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(java.lang.String prefix, java.lang.String namespace,
                                    java.lang.String attName,
                                    java.lang.String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);

            }

            xmlWriter.writeAttribute(namespace, attName, attValue);

        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace, java.lang.String attName,
                                    java.lang.String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                         javax.xml.namespace.QName qname,
                                         javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         *  method to handle Qnames
         */
        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.
                            convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.
                            convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.
                        convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.
                                    convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.
                                    convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.
                                convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }

        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter,
                                                java.lang.String namespace) throws
                javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);

            if (prefix == null) {
                prefix = generatePrefix(namespace);

                while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }

                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         *
         */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                throws org.apache.axis2.databinding.ADBException {




            //We can safely assume an element has only one type associated with it

            if (localQName == null) {
                return new org.apache.axis2.databinding.utils.reader.NullXMLStreamReader(MY_QNAME);
            } else {
                return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(MY_QNAME,
                                                                                            new java.lang.Object[]{
                            org.apache.axis2.databinding.utils.reader.ADBXMLStreamReader.ELEMENT_TEXT,
                            org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                            localQName)
                        },
                                                                                            null);
            }


        }

        /**
         *  Factory class that keeps the parse method
         */
        public static class Factory {

            /**
             * static method to create the object
             * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
             *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
             * Postcondition: If this object is an element, the reader is positioned at its end element
             *                If this object is a complex type, the reader is positioned at the end element of its outer element
             */
            public static QName parse(javax.xml.stream.XMLStreamReader reader) throws
                    java.lang.Exception {
                QName object =
                      new QName();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while (!reader.isStartElement() && !reader.isEndElement()) {
                        reader.next();
                    }


                    nillableValue = reader.getAttributeValue(
                            "http://www.w3.org/2001/XMLSchema-instance", "nil");
                    if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                        // Skip the element and report the null value.  It cannot have subelements.
                        while (!reader.isEndElement()) {
                            reader.next();
                        }

                        return object;


                    }



                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();



                    while (!reader.isEndElement()) {
                        if (reader.isStartElement()) {

                            if (reader.isStartElement() && new javax.xml.namespace.QName(
                                    "http://schemas.microsoft.com/2003/10/Serialization/", "QName").
                                    equals(reader.getName())) {

                                nillableValue = reader.getAttributeValue(
                                        "http://www.w3.org/2001/XMLSchema-instance", "nil");
                                if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

                                    java.lang.String content = reader.getElementText();

                                    int index = content.indexOf(":");
                                    if (index > 0) {
                                        prefix = content.substring(0, index);
                                    } else {
                                        prefix = "";
                                    }
                                    namespaceuri = reader.getNamespaceURI(prefix);
                                    object.setQName(
                                            org.apache.axis2.databinding.utils.ConverterUtil.
                                            convertToQName(content, namespaceuri));

                                } else {


                                    reader.getElementText(); // throw away text nodes if any.
                                }

                            } // End of if for expected property start element
                            else {
                                // A start element we are not expecting indicates an invalid parameter was passed
                                throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.
                                        getLocalName());
                            }

                        } else {
                            reader.next();
                        }
                    }  // end of while loop




                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }
        }//end of factory class

    }

    public static class _byte
            implements org.apache.axis2.databinding.ADBBean {

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "http://schemas.microsoft.com/2003/10/Serialization/",
                "byte",
                "ns3");

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if (namespace.equals("http://schemas.microsoft.com/2003/10/Serialization/")) {
                return "ns3";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }
        /**
         * field for _byte
         */
        protected byte local_byte;

        /**
         * Auto generated getter method
         * @return byte
         */
        public byte get_byte() {
            return local_byte;
        }

        /**
         * Auto generated setter method
         * @param param _byte
         */
        public void set_byte(byte param) {

            this.local_byte = param;


        }

        /**
         * isReaderMTOMAware
         * @return true if the reader supports MTOM
         */
        public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
            boolean isReaderMTOMAware = false;

            try {
                isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(
                        org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
            } catch (java.lang.IllegalArgumentException e) {
                isReaderMTOMAware = false;
            }
            return isReaderMTOMAware;
        }

        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory) throws
                org.apache.axis2.databinding.ADBException {



            org.apache.axiom.om.OMDataSource dataSource =
                                             new org.apache.axis2.databinding.ADBDataSource(this,
                                                                                            MY_QNAME) {

                public void serialize(
                        org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                        throws javax.xml.stream.XMLStreamException {
                    _byte.this.serialize(MY_QNAME, factory, xmlWriter);
                }
            };
            return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
                    MY_QNAME, factory, dataSource);

        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              final org.apache.axiom.om.OMFactory factory,
                              org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException,
                       org.apache.axis2.databinding.ADBException {
            serialize(parentQName, factory, xmlWriter, false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              final org.apache.axiom.om.OMFactory factory,
                              org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                              boolean serializeType)
                throws javax.xml.stream.XMLStreamException,
                       org.apache.axis2.databinding.ADBException {


            //We can safely assume an element has only one type associated with it

            java.lang.String namespace = "http://schemas.microsoft.com/2003/10/Serialization/";
            java.lang.String localName = "byte";

            if (!namespace.equals("")) {
                java.lang.String prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    xmlWriter.writeStartElement(prefix, localName, namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);

                } else {
                    xmlWriter.writeStartElement(namespace, localName);
                }

            } else {
                xmlWriter.writeStartElement(localName);
            }

            // add the type details if this is used in a simple type
            if (serializeType) {
                java.lang.String namespacePrefix = registerPrefix(xmlWriter,
                                                                  "http://schemas.microsoft.com/2003/10/Serialization/");
                if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                                   namespacePrefix + ":byte",
                                   xmlWriter);
                } else {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                                   "byte",
                                   xmlWriter);
                }
            }

            if (local_byte == java.lang.Byte.MIN_VALUE) {

                writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                               xmlWriter);

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.
                        convertToString(local_byte));
            }

            xmlWriter.writeEndElement();



        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(java.lang.String prefix, java.lang.String namespace,
                                    java.lang.String attName,
                                    java.lang.String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);

            }

            xmlWriter.writeAttribute(namespace, attName, attValue);

        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace, java.lang.String attName,
                                    java.lang.String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                         javax.xml.namespace.QName qname,
                                         javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         *  method to handle Qnames
         */
        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.
                            convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.
                            convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.
                        convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.
                                    convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.
                                    convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.
                                convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }

        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter,
                                                java.lang.String namespace) throws
                javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);

            if (prefix == null) {
                prefix = generatePrefix(namespace);

                while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }

                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         *
         */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                throws org.apache.axis2.databinding.ADBException {




            //We can safely assume an element has only one type associated with it
            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(MY_QNAME,
                                                                                        new java.lang.Object[]{
                        org.apache.axis2.databinding.utils.reader.ADBXMLStreamReader.ELEMENT_TEXT,
                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString(local_byte)
                    },
                                                                                        null);

        }

        /**
         *  Factory class that keeps the parse method
         */
        public static class Factory {

            /**
             * static method to create the object
             * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
             *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
             * Postcondition: If this object is an element, the reader is positioned at its end element
             *                If this object is a complex type, the reader is positioned at the end element of its outer element
             */
            public static _byte parse(javax.xml.stream.XMLStreamReader reader) throws
                    java.lang.Exception {
                _byte object =
                      new _byte();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while (!reader.isStartElement() && !reader.isEndElement()) {
                        reader.next();
                    }


                    nillableValue = reader.getAttributeValue(
                            "http://www.w3.org/2001/XMLSchema-instance", "nil");
                    if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                        // Skip the element and report the null value.  It cannot have subelements.
                        while (!reader.isEndElement()) {
                            reader.next();
                        }

                        object.set_byte(java.lang.Byte.MIN_VALUE);

                        return object;


                    }



                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();



                    while (!reader.isEndElement()) {
                        if (reader.isStartElement()) {

                            if (reader.isStartElement() && new javax.xml.namespace.QName(
                                    "http://schemas.microsoft.com/2003/10/Serialization/", "byte").
                                    equals(reader.getName())) {

                                nillableValue = reader.getAttributeValue(
                                        "http://www.w3.org/2001/XMLSchema-instance", "nil");
                                if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

                                    java.lang.String content = reader.getElementText();

                                    object.set_byte(
                                            org.apache.axis2.databinding.utils.ConverterUtil.
                                            convertToByte(content));

                                } else {


                                    object.set_byte(java.lang.Byte.MIN_VALUE);

                                    reader.getElementText(); // throw away text nodes if any.
                                }

                            } // End of if for expected property start element
                            else {
                                // A start element we are not expecting indicates an invalid parameter was passed
                                throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.
                                        getLocalName());
                            }

                        } else {
                            reader.next();
                        }
                    }  // end of while loop




                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }
        }//end of factory class

    }

    public static class Guid
            implements org.apache.axis2.databinding.ADBBean {

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "http://schemas.microsoft.com/2003/10/Serialization/",
                "guid",
                "ns3");

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if (namespace.equals("http://schemas.microsoft.com/2003/10/Serialization/")) {
                return "ns3";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }
        /**
         * field for Guid
         */
        protected java.lang.String localGuid;

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getGuid() {
            return localGuid;
        }

        /**
         * Auto generated setter method
         * @param param Guid
         */
        public void setGuid(java.lang.String param) {

            if (org.apache.axis2.databinding.utils.ConverterUtil.convertToString(param).matches(
                    "[\\da-fA-F]{8}-[\\da-fA-F]{4}-[\\da-fA-F]{4}-[\\da-fA-F]{4}-[\\da-fA-F]{12}")) {
                this.localGuid = param;
            } else {
                throw new java.lang.RuntimeException();
            }


        }

        public java.lang.String toString() {

            return localGuid.toString();

        }

        /**
         * isReaderMTOMAware
         * @return true if the reader supports MTOM
         */
        public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
            boolean isReaderMTOMAware = false;

            try {
                isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(
                        org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
            } catch (java.lang.IllegalArgumentException e) {
                isReaderMTOMAware = false;
            }
            return isReaderMTOMAware;
        }

        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory) throws
                org.apache.axis2.databinding.ADBException {



            org.apache.axiom.om.OMDataSource dataSource =
                                             new org.apache.axis2.databinding.ADBDataSource(this,
                                                                                            MY_QNAME) {

                public void serialize(
                        org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                        throws javax.xml.stream.XMLStreamException {
                    Guid.this.serialize(MY_QNAME, factory, xmlWriter);
                }
            };
            return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
                    MY_QNAME, factory, dataSource);

        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              final org.apache.axiom.om.OMFactory factory,
                              org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException,
                       org.apache.axis2.databinding.ADBException {
            serialize(parentQName, factory, xmlWriter, false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              final org.apache.axiom.om.OMFactory factory,
                              org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                              boolean serializeType)
                throws javax.xml.stream.XMLStreamException,
                       org.apache.axis2.databinding.ADBException {


            //We can safely assume an element has only one type associated with it

            java.lang.String namespace = parentQName.getNamespaceURI();
            java.lang.String localName = parentQName.getLocalPart();

            if (!namespace.equals("")) {
                java.lang.String prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    xmlWriter.writeStartElement(prefix, localName, namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);

                } else {
                    xmlWriter.writeStartElement(namespace, localName);
                }

            } else {
                xmlWriter.writeStartElement(localName);
            }

            // add the type details if this is used in a simple type
            if (serializeType) {
                java.lang.String namespacePrefix = registerPrefix(xmlWriter,
                                                                  "http://schemas.microsoft.com/2003/10/Serialization/");
                if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                                   namespacePrefix + ":guid",
                                   xmlWriter);
                } else {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                                   "guid",
                                   xmlWriter);
                }
            }

            if (localGuid == null) {

                throw new org.apache.axis2.databinding.ADBException("Value cannot be null !!");

            } else {

                xmlWriter.writeCharacters(localGuid);

            }

            xmlWriter.writeEndElement();



        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(java.lang.String prefix, java.lang.String namespace,
                                    java.lang.String attName,
                                    java.lang.String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);

            }

            xmlWriter.writeAttribute(namespace, attName, attValue);

        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace, java.lang.String attName,
                                    java.lang.String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                         javax.xml.namespace.QName qname,
                                         javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         *  method to handle Qnames
         */
        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.
                            convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.
                            convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.
                        convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.
                                    convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.
                                    convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.
                                convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }

        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter,
                                                java.lang.String namespace) throws
                javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);

            if (prefix == null) {
                prefix = generatePrefix(namespace);

                while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }

                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         *
         */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                throws org.apache.axis2.databinding.ADBException {




            //We can safely assume an element has only one type associated with it
            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(MY_QNAME,
                                                                                        new java.lang.Object[]{
                        org.apache.axis2.databinding.utils.reader.ADBXMLStreamReader.ELEMENT_TEXT,
                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localGuid)
                    },
                                                                                        null);

        }

        /**
         *  Factory class that keeps the parse method
         */
        public static class Factory {

            public static Guid fromString(java.lang.String value,
                                          java.lang.String namespaceURI) {
                Guid returnValue = new Guid();

                returnValue.setGuid(
                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString(value));


                return returnValue;
            }

            public static Guid fromString(javax.xml.stream.XMLStreamReader xmlStreamReader,
                                          java.lang.String content) {
                if (content.indexOf(":") > -1) {
                    java.lang.String prefix = content.substring(0, content.indexOf(":"));
                    java.lang.String namespaceUri = xmlStreamReader.getNamespaceContext().
                            getNamespaceURI(prefix);
                    return Guid.Factory.fromString(content, namespaceUri);
                } else {
                    return Guid.Factory.fromString(content, "");
                }
            }

            /**
             * static method to create the object
             * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
             *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
             * Postcondition: If this object is an element, the reader is positioned at its end element
             *                If this object is a complex type, the reader is positioned at the end element of its outer element
             */
            public static Guid parse(javax.xml.stream.XMLStreamReader reader) throws
                    java.lang.Exception {
                Guid object =
                     new Guid();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while (!reader.isStartElement() && !reader.isEndElement()) {
                        reader.next();
                    }




                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();



                    while (!reader.isEndElement()) {
                        if (reader.isStartElement() || reader.hasText()) {

                            if (reader.isStartElement() || reader.hasText()) {

                                java.lang.String content = reader.getElementText();

                                object.setGuid(
                                        org.apache.axis2.databinding.utils.ConverterUtil.
                                        convertToString(content));

                            } // End of if for expected property start element
                            else {
                                // A start element we are not expecting indicates an invalid parameter was passed
                                throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.
                                        getLocalName());
                            }

                        } else {
                            reader.next();
                        }
                    }  // end of while loop




                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }
        }//end of factory class

    }

    public static class Decimal
            implements org.apache.axis2.databinding.ADBBean {

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "http://schemas.microsoft.com/2003/10/Serialization/",
                "decimal",
                "ns3");

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if (namespace.equals("http://schemas.microsoft.com/2003/10/Serialization/")) {
                return "ns3";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }
        /**
         * field for Decimal
         */
        protected java.math.BigDecimal localDecimal;

        /**
         * Auto generated getter method
         * @return java.math.BigDecimal
         */
        public java.math.BigDecimal getDecimal() {
            return localDecimal;
        }

        /**
         * Auto generated setter method
         * @param param Decimal
         */
        public void setDecimal(java.math.BigDecimal param) {

            this.localDecimal = param;


        }

        /**
         * isReaderMTOMAware
         * @return true if the reader supports MTOM
         */
        public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
            boolean isReaderMTOMAware = false;

            try {
                isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(
                        org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
            } catch (java.lang.IllegalArgumentException e) {
                isReaderMTOMAware = false;
            }
            return isReaderMTOMAware;
        }

        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory) throws
                org.apache.axis2.databinding.ADBException {



            org.apache.axiom.om.OMDataSource dataSource =
                                             new org.apache.axis2.databinding.ADBDataSource(this,
                                                                                            MY_QNAME) {

                public void serialize(
                        org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                        throws javax.xml.stream.XMLStreamException {
                    Decimal.this.serialize(MY_QNAME, factory, xmlWriter);
                }
            };
            return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
                    MY_QNAME, factory, dataSource);

        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              final org.apache.axiom.om.OMFactory factory,
                              org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException,
                       org.apache.axis2.databinding.ADBException {
            serialize(parentQName, factory, xmlWriter, false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              final org.apache.axiom.om.OMFactory factory,
                              org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                              boolean serializeType)
                throws javax.xml.stream.XMLStreamException,
                       org.apache.axis2.databinding.ADBException {


            //We can safely assume an element has only one type associated with it

            java.lang.String namespace = "http://schemas.microsoft.com/2003/10/Serialization/";
            java.lang.String localName = "decimal";

            if (!namespace.equals("")) {
                java.lang.String prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    xmlWriter.writeStartElement(prefix, localName, namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);

                } else {
                    xmlWriter.writeStartElement(namespace, localName);
                }

            } else {
                xmlWriter.writeStartElement(localName);
            }

            // add the type details if this is used in a simple type
            if (serializeType) {
                java.lang.String namespacePrefix = registerPrefix(xmlWriter,
                                                                  "http://schemas.microsoft.com/2003/10/Serialization/");
                if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                                   namespacePrefix + ":decimal",
                                   xmlWriter);
                } else {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                                   "decimal",
                                   xmlWriter);
                }
            }

            if (localDecimal == null) {

                // write the nil attribute
                writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                               xmlWriter);

            } else {

                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.
                        convertToString(localDecimal));

            }

            xmlWriter.writeEndElement();



        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(java.lang.String prefix, java.lang.String namespace,
                                    java.lang.String attName,
                                    java.lang.String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);

            }

            xmlWriter.writeAttribute(namespace, attName, attValue);

        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace, java.lang.String attName,
                                    java.lang.String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                         javax.xml.namespace.QName qname,
                                         javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         *  method to handle Qnames
         */
        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.
                            convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.
                            convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.
                        convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.
                                    convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.
                                    convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.
                                convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }

        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter,
                                                java.lang.String namespace) throws
                javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);

            if (prefix == null) {
                prefix = generatePrefix(namespace);

                while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }

                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         *
         */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                throws org.apache.axis2.databinding.ADBException {




            //We can safely assume an element has only one type associated with it

            if (localDecimal == null) {
                return new org.apache.axis2.databinding.utils.reader.NullXMLStreamReader(MY_QNAME);
            } else {
                return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(MY_QNAME,
                                                                                            new java.lang.Object[]{
                            org.apache.axis2.databinding.utils.reader.ADBXMLStreamReader.ELEMENT_TEXT,
                            org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                            localDecimal)
                        },
                                                                                            null);
            }


        }

        /**
         *  Factory class that keeps the parse method
         */
        public static class Factory {

            /**
             * static method to create the object
             * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
             *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
             * Postcondition: If this object is an element, the reader is positioned at its end element
             *                If this object is a complex type, the reader is positioned at the end element of its outer element
             */
            public static Decimal parse(javax.xml.stream.XMLStreamReader reader) throws
                    java.lang.Exception {
                Decimal object =
                        new Decimal();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while (!reader.isStartElement() && !reader.isEndElement()) {
                        reader.next();
                    }


                    nillableValue = reader.getAttributeValue(
                            "http://www.w3.org/2001/XMLSchema-instance", "nil");
                    if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                        // Skip the element and report the null value.  It cannot have subelements.
                        while (!reader.isEndElement()) {
                            reader.next();
                        }

                        return object;


                    }



                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();



                    while (!reader.isEndElement()) {
                        if (reader.isStartElement()) {

                            if (reader.isStartElement() && new javax.xml.namespace.QName(
                                    "http://schemas.microsoft.com/2003/10/Serialization/", "decimal").
                                    equals(reader.getName())) {

                                nillableValue = reader.getAttributeValue(
                                        "http://www.w3.org/2001/XMLSchema-instance", "nil");
                                if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

                                    java.lang.String content = reader.getElementText();

                                    object.setDecimal(
                                            org.apache.axis2.databinding.utils.ConverterUtil.
                                            convertToDecimal(content));

                                } else {


                                    reader.getElementText(); // throw away text nodes if any.
                                }

                            } // End of if for expected property start element
                            else {
                                // A start element we are not expecting indicates an invalid parameter was passed
                                throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.
                                        getLocalName());
                            }

                        } else {
                            reader.next();
                        }
                    }  // end of while loop




                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }
        }//end of factory class

    }

    public static class DateTime
            implements org.apache.axis2.databinding.ADBBean {

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "http://schemas.microsoft.com/2003/10/Serialization/",
                "dateTime",
                "ns3");

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if (namespace.equals("http://schemas.microsoft.com/2003/10/Serialization/")) {
                return "ns3";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }
        /**
         * field for DateTime
         */
        protected java.util.Calendar localDateTime;

        /**
         * Auto generated getter method
         * @return java.util.Calendar
         */
        public java.util.Calendar getDateTime() {
            return localDateTime;
        }

        /**
         * Auto generated setter method
         * @param param DateTime
         */
        public void setDateTime(java.util.Calendar param) {

            this.localDateTime = param;


        }

        /**
         * isReaderMTOMAware
         * @return true if the reader supports MTOM
         */
        public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
            boolean isReaderMTOMAware = false;

            try {
                isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(
                        org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
            } catch (java.lang.IllegalArgumentException e) {
                isReaderMTOMAware = false;
            }
            return isReaderMTOMAware;
        }

        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory) throws
                org.apache.axis2.databinding.ADBException {



            org.apache.axiom.om.OMDataSource dataSource =
                                             new org.apache.axis2.databinding.ADBDataSource(this,
                                                                                            MY_QNAME) {

                public void serialize(
                        org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                        throws javax.xml.stream.XMLStreamException {
                    DateTime.this.serialize(MY_QNAME, factory, xmlWriter);
                }
            };
            return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
                    MY_QNAME, factory, dataSource);

        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              final org.apache.axiom.om.OMFactory factory,
                              org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException,
                       org.apache.axis2.databinding.ADBException {
            serialize(parentQName, factory, xmlWriter, false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              final org.apache.axiom.om.OMFactory factory,
                              org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                              boolean serializeType)
                throws javax.xml.stream.XMLStreamException,
                       org.apache.axis2.databinding.ADBException {


            //We can safely assume an element has only one type associated with it

            java.lang.String namespace = "http://schemas.microsoft.com/2003/10/Serialization/";
            java.lang.String localName = "dateTime";

            if (!namespace.equals("")) {
                java.lang.String prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    xmlWriter.writeStartElement(prefix, localName, namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);

                } else {
                    xmlWriter.writeStartElement(namespace, localName);
                }

            } else {
                xmlWriter.writeStartElement(localName);
            }

            // add the type details if this is used in a simple type
            if (serializeType) {
                java.lang.String namespacePrefix = registerPrefix(xmlWriter,
                                                                  "http://schemas.microsoft.com/2003/10/Serialization/");
                if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                                   namespacePrefix + ":dateTime",
                                   xmlWriter);
                } else {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                                   "dateTime",
                                   xmlWriter);
                }
            }

            if (localDateTime == null) {

                // write the nil attribute
                writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                               xmlWriter);

            } else {

                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.
                        convertToString(localDateTime));

            }

            xmlWriter.writeEndElement();



        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(java.lang.String prefix, java.lang.String namespace,
                                    java.lang.String attName,
                                    java.lang.String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);

            }

            xmlWriter.writeAttribute(namespace, attName, attValue);

        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace, java.lang.String attName,
                                    java.lang.String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                         javax.xml.namespace.QName qname,
                                         javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         *  method to handle Qnames
         */
        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.
                            convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.
                            convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.
                        convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.
                                    convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.
                                    convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.
                                convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }

        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter,
                                                java.lang.String namespace) throws
                javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);

            if (prefix == null) {
                prefix = generatePrefix(namespace);

                while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }

                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         *
         */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                throws org.apache.axis2.databinding.ADBException {




            //We can safely assume an element has only one type associated with it

            if (localDateTime == null) {
                return new org.apache.axis2.databinding.utils.reader.NullXMLStreamReader(MY_QNAME);
            } else {
                return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(MY_QNAME,
                                                                                            new java.lang.Object[]{
                            org.apache.axis2.databinding.utils.reader.ADBXMLStreamReader.ELEMENT_TEXT,
                            org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                            localDateTime)
                        },
                                                                                            null);
            }


        }

        /**
         *  Factory class that keeps the parse method
         */
        public static class Factory {

            /**
             * static method to create the object
             * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
             *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
             * Postcondition: If this object is an element, the reader is positioned at its end element
             *                If this object is a complex type, the reader is positioned at the end element of its outer element
             */
            public static DateTime parse(javax.xml.stream.XMLStreamReader reader) throws
                    java.lang.Exception {
                DateTime object =
                         new DateTime();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while (!reader.isStartElement() && !reader.isEndElement()) {
                        reader.next();
                    }


                    nillableValue = reader.getAttributeValue(
                            "http://www.w3.org/2001/XMLSchema-instance", "nil");
                    if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                        // Skip the element and report the null value.  It cannot have subelements.
                        while (!reader.isEndElement()) {
                            reader.next();
                        }

                        return object;


                    }



                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();



                    while (!reader.isEndElement()) {
                        if (reader.isStartElement()) {

                            if (reader.isStartElement() && new javax.xml.namespace.QName(
                                    "http://schemas.microsoft.com/2003/10/Serialization/",
                                                                                         "dateTime").
                                    equals(reader.getName())) {

                                nillableValue = reader.getAttributeValue(
                                        "http://www.w3.org/2001/XMLSchema-instance", "nil");
                                if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

                                    java.lang.String content = reader.getElementText();

                                    object.setDateTime(
                                            org.apache.axis2.databinding.utils.ConverterUtil.
                                            convertToDateTime(content));

                                } else {


                                    reader.getElementText(); // throw away text nodes if any.
                                }

                            } // End of if for expected property start element
                            else {
                                // A start element we are not expecting indicates an invalid parameter was passed
                                throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.
                                        getLocalName());
                            }

                        } else {
                            reader.next();
                        }
                    }  // end of while loop




                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }
        }//end of factory class

    }

    public static class _long
            implements org.apache.axis2.databinding.ADBBean {

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "http://schemas.microsoft.com/2003/10/Serialization/",
                "long",
                "ns3");

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if (namespace.equals("http://schemas.microsoft.com/2003/10/Serialization/")) {
                return "ns3";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }
        /**
         * field for _long
         */
        protected long local_long;

        /**
         * Auto generated getter method
         * @return long
         */
        public long get_long() {
            return local_long;
        }

        /**
         * Auto generated setter method
         * @param param _long
         */
        public void set_long(long param) {

            this.local_long = param;


        }

        /**
         * isReaderMTOMAware
         * @return true if the reader supports MTOM
         */
        public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
            boolean isReaderMTOMAware = false;

            try {
                isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(
                        org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
            } catch (java.lang.IllegalArgumentException e) {
                isReaderMTOMAware = false;
            }
            return isReaderMTOMAware;
        }

        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory) throws
                org.apache.axis2.databinding.ADBException {



            org.apache.axiom.om.OMDataSource dataSource =
                                             new org.apache.axis2.databinding.ADBDataSource(this,
                                                                                            MY_QNAME) {

                public void serialize(
                        org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                        throws javax.xml.stream.XMLStreamException {
                    _long.this.serialize(MY_QNAME, factory, xmlWriter);
                }
            };
            return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
                    MY_QNAME, factory, dataSource);

        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              final org.apache.axiom.om.OMFactory factory,
                              org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException,
                       org.apache.axis2.databinding.ADBException {
            serialize(parentQName, factory, xmlWriter, false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              final org.apache.axiom.om.OMFactory factory,
                              org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                              boolean serializeType)
                throws javax.xml.stream.XMLStreamException,
                       org.apache.axis2.databinding.ADBException {


            //We can safely assume an element has only one type associated with it

            java.lang.String namespace = "http://schemas.microsoft.com/2003/10/Serialization/";
            java.lang.String localName = "long";

            if (!namespace.equals("")) {
                java.lang.String prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    xmlWriter.writeStartElement(prefix, localName, namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);

                } else {
                    xmlWriter.writeStartElement(namespace, localName);
                }

            } else {
                xmlWriter.writeStartElement(localName);
            }

            // add the type details if this is used in a simple type
            if (serializeType) {
                java.lang.String namespacePrefix = registerPrefix(xmlWriter,
                                                                  "http://schemas.microsoft.com/2003/10/Serialization/");
                if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                                   namespacePrefix + ":long",
                                   xmlWriter);
                } else {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                                   "long",
                                   xmlWriter);
                }
            }

            if (local_long == java.lang.Long.MIN_VALUE) {

                writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                               xmlWriter);

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.
                        convertToString(local_long));
            }

            xmlWriter.writeEndElement();



        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(java.lang.String prefix, java.lang.String namespace,
                                    java.lang.String attName,
                                    java.lang.String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);

            }

            xmlWriter.writeAttribute(namespace, attName, attValue);

        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace, java.lang.String attName,
                                    java.lang.String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                         javax.xml.namespace.QName qname,
                                         javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         *  method to handle Qnames
         */
        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.
                            convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.
                            convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.
                        convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.
                                    convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.
                                    convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.
                                convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }

        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter,
                                                java.lang.String namespace) throws
                javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);

            if (prefix == null) {
                prefix = generatePrefix(namespace);

                while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }

                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         *
         */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                throws org.apache.axis2.databinding.ADBException {




            //We can safely assume an element has only one type associated with it
            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(MY_QNAME,
                                                                                        new java.lang.Object[]{
                        org.apache.axis2.databinding.utils.reader.ADBXMLStreamReader.ELEMENT_TEXT,
                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString(local_long)
                    },
                                                                                        null);

        }

        /**
         *  Factory class that keeps the parse method
         */
        public static class Factory {

            /**
             * static method to create the object
             * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
             *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
             * Postcondition: If this object is an element, the reader is positioned at its end element
             *                If this object is a complex type, the reader is positioned at the end element of its outer element
             */
            public static _long parse(javax.xml.stream.XMLStreamReader reader) throws
                    java.lang.Exception {
                _long object =
                      new _long();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while (!reader.isStartElement() && !reader.isEndElement()) {
                        reader.next();
                    }


                    nillableValue = reader.getAttributeValue(
                            "http://www.w3.org/2001/XMLSchema-instance", "nil");
                    if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                        // Skip the element and report the null value.  It cannot have subelements.
                        while (!reader.isEndElement()) {
                            reader.next();
                        }

                        object.set_long(java.lang.Long.MIN_VALUE);

                        return object;


                    }



                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();



                    while (!reader.isEndElement()) {
                        if (reader.isStartElement()) {

                            if (reader.isStartElement() && new javax.xml.namespace.QName(
                                    "http://schemas.microsoft.com/2003/10/Serialization/", "long").
                                    equals(reader.getName())) {

                                nillableValue = reader.getAttributeValue(
                                        "http://www.w3.org/2001/XMLSchema-instance", "nil");
                                if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

                                    java.lang.String content = reader.getElementText();

                                    object.set_long(
                                            org.apache.axis2.databinding.utils.ConverterUtil.
                                            convertToLong(content));

                                } else {


                                    object.set_long(java.lang.Long.MIN_VALUE);

                                    reader.getElementText(); // throw away text nodes if any.
                                }

                            } // End of if for expected property start element
                            else {
                                // A start element we are not expecting indicates an invalid parameter was passed
                                throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.
                                        getLocalName());
                            }

                        } else {
                            reader.next();
                        }
                    }  // end of while loop




                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }
        }//end of factory class

    }

    public static class Duration
            implements org.apache.axis2.databinding.ADBBean {

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "http://schemas.microsoft.com/2003/10/Serialization/",
                "duration",
                "ns3");

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if (namespace.equals("http://schemas.microsoft.com/2003/10/Serialization/")) {
                return "ns3";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }
        /**
         * field for Duration
         */
        protected org.apache.axis2.databinding.types.Duration localDuration;

        /**
         * Auto generated getter method
         * @return org.apache.axis2.databinding.types.Duration
         */
        public org.apache.axis2.databinding.types.Duration getDuration() {
            return localDuration;
        }

        /**
         * Auto generated setter method
         * @param param Duration
         */
        public void setDuration(org.apache.axis2.databinding.types.Duration param) {

            if (org.apache.axis2.databinding.utils.ConverterUtil.convertToString(param).matches(
                    "\\-?P(\\d*D)?(T(\\d*H)?(\\d*M)?(\\d*(\\.\\d*)?S)?)?")) {
                this.localDuration = param;
            } else {
                throw new java.lang.RuntimeException();
            }


        }

        public java.lang.String toString() {

            return localDuration.toString();

        }

        /**
         * isReaderMTOMAware
         * @return true if the reader supports MTOM
         */
        public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
            boolean isReaderMTOMAware = false;

            try {
                isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(
                        org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
            } catch (java.lang.IllegalArgumentException e) {
                isReaderMTOMAware = false;
            }
            return isReaderMTOMAware;
        }

        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory) throws
                org.apache.axis2.databinding.ADBException {



            org.apache.axiom.om.OMDataSource dataSource =
                                             new org.apache.axis2.databinding.ADBDataSource(this,
                                                                                            MY_QNAME) {

                public void serialize(
                        org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                        throws javax.xml.stream.XMLStreamException {
                    Duration.this.serialize(MY_QNAME, factory, xmlWriter);
                }
            };
            return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
                    MY_QNAME, factory, dataSource);

        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              final org.apache.axiom.om.OMFactory factory,
                              org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException,
                       org.apache.axis2.databinding.ADBException {
            serialize(parentQName, factory, xmlWriter, false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              final org.apache.axiom.om.OMFactory factory,
                              org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                              boolean serializeType)
                throws javax.xml.stream.XMLStreamException,
                       org.apache.axis2.databinding.ADBException {


            //We can safely assume an element has only one type associated with it

            java.lang.String namespace = parentQName.getNamespaceURI();
            java.lang.String localName = parentQName.getLocalPart();

            if (!namespace.equals("")) {
                java.lang.String prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    xmlWriter.writeStartElement(prefix, localName, namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);

                } else {
                    xmlWriter.writeStartElement(namespace, localName);
                }

            } else {
                xmlWriter.writeStartElement(localName);
            }

            // add the type details if this is used in a simple type
            if (serializeType) {
                java.lang.String namespacePrefix = registerPrefix(xmlWriter,
                                                                  "http://schemas.microsoft.com/2003/10/Serialization/");
                if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                                   namespacePrefix + ":duration",
                                   xmlWriter);
                } else {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                                   "duration",
                                   xmlWriter);
                }
            }

            if (localDuration == null) {

                throw new org.apache.axis2.databinding.ADBException("Value cannot be null !!");

            } else {

                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.
                        convertToString(localDuration));

            }

            xmlWriter.writeEndElement();



        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(java.lang.String prefix, java.lang.String namespace,
                                    java.lang.String attName,
                                    java.lang.String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);

            }

            xmlWriter.writeAttribute(namespace, attName, attValue);

        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace, java.lang.String attName,
                                    java.lang.String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                         javax.xml.namespace.QName qname,
                                         javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         *  method to handle Qnames
         */
        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.
                            convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.
                            convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.
                        convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.
                                    convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.
                                    convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.
                                convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }

        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter,
                                                java.lang.String namespace) throws
                javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);

            if (prefix == null) {
                prefix = generatePrefix(namespace);

                while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }

                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         *
         */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                throws org.apache.axis2.databinding.ADBException {




            //We can safely assume an element has only one type associated with it
            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(MY_QNAME,
                                                                                        new java.lang.Object[]{
                        org.apache.axis2.databinding.utils.reader.ADBXMLStreamReader.ELEMENT_TEXT,
                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                        localDuration)
                    },
                                                                                        null);

        }

        /**
         *  Factory class that keeps the parse method
         */
        public static class Factory {

            public static Duration fromString(java.lang.String value,
                                              java.lang.String namespaceURI) {
                Duration returnValue = new Duration();

                returnValue.setDuration(
                        org.apache.axis2.databinding.utils.ConverterUtil.convertToDuration(value));


                return returnValue;
            }

            public static Duration fromString(javax.xml.stream.XMLStreamReader xmlStreamReader,
                                              java.lang.String content) {
                if (content.indexOf(":") > -1) {
                    java.lang.String prefix = content.substring(0, content.indexOf(":"));
                    java.lang.String namespaceUri = xmlStreamReader.getNamespaceContext().
                            getNamespaceURI(prefix);
                    return Duration.Factory.fromString(content, namespaceUri);
                } else {
                    return Duration.Factory.fromString(content, "");
                }
            }

            /**
             * static method to create the object
             * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
             *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
             * Postcondition: If this object is an element, the reader is positioned at its end element
             *                If this object is a complex type, the reader is positioned at the end element of its outer element
             */
            public static Duration parse(javax.xml.stream.XMLStreamReader reader) throws
                    java.lang.Exception {
                Duration object =
                         new Duration();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while (!reader.isStartElement() && !reader.isEndElement()) {
                        reader.next();
                    }




                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();



                    while (!reader.isEndElement()) {
                        if (reader.isStartElement() || reader.hasText()) {

                            if (reader.isStartElement() || reader.hasText()) {

                                java.lang.String content = reader.getElementText();

                                object.setDuration(
                                        org.apache.axis2.databinding.utils.ConverterUtil.
                                        convertToDuration(content));

                            } // End of if for expected property start element
                            else {
                                // A start element we are not expecting indicates an invalid parameter was passed
                                throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.
                                        getLocalName());
                            }

                        } else {
                            reader.next();
                        }
                    }  // end of while loop




                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }
        }//end of factory class

    }

    public static class ExtensionMapper {

        public static java.lang.Object getTypeObject(java.lang.String namespaceURI,
                                                     java.lang.String typeName,
                                                     javax.xml.stream.XMLStreamReader reader) throws
                java.lang.Exception {


            if ("http://schemas.microsoft.com/2003/10/Serialization/".equals(namespaceURI) &&
                "guid".equals(typeName)) {

                return Guid.Factory.parse(reader);


            }


            if ("http://schemas.microsoft.com/2003/10/Serialization/".equals(namespaceURI) &&
                "duration".equals(typeName)) {

                return Duration.Factory.parse(reader);


            }


            if ("http://schemas.microsoft.com/2003/10/Serialization/".equals(namespaceURI) &&
                "char".equals(typeName)) {

                return _char.Factory.parse(reader);


            }


            if ("http://schemas.microsoft.com/2003/10/Serialization/Arrays".equals(namespaceURI) &&
                "ArrayOfstring".equals(typeName)) {

                return ArrayOfstring.Factory.parse(reader);


            }


            throw new org.apache.axis2.databinding.ADBException(
                    "Unsupported type " + namespaceURI + " " + typeName);
        }
    }

    public static class _float
            implements org.apache.axis2.databinding.ADBBean {

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "http://schemas.microsoft.com/2003/10/Serialization/",
                "float",
                "ns3");

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if (namespace.equals("http://schemas.microsoft.com/2003/10/Serialization/")) {
                return "ns3";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }
        /**
         * field for _float
         */
        protected float local_float;

        /**
         * Auto generated getter method
         * @return float
         */
        public float get_float() {
            return local_float;
        }

        /**
         * Auto generated setter method
         * @param param _float
         */
        public void set_float(float param) {

            this.local_float = param;


        }

        /**
         * isReaderMTOMAware
         * @return true if the reader supports MTOM
         */
        public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
            boolean isReaderMTOMAware = false;

            try {
                isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(
                        org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
            } catch (java.lang.IllegalArgumentException e) {
                isReaderMTOMAware = false;
            }
            return isReaderMTOMAware;
        }

        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory) throws
                org.apache.axis2.databinding.ADBException {



            org.apache.axiom.om.OMDataSource dataSource =
                                             new org.apache.axis2.databinding.ADBDataSource(this,
                                                                                            MY_QNAME) {

                public void serialize(
                        org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                        throws javax.xml.stream.XMLStreamException {
                    _float.this.serialize(MY_QNAME, factory, xmlWriter);
                }
            };
            return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
                    MY_QNAME, factory, dataSource);

        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              final org.apache.axiom.om.OMFactory factory,
                              org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException,
                       org.apache.axis2.databinding.ADBException {
            serialize(parentQName, factory, xmlWriter, false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              final org.apache.axiom.om.OMFactory factory,
                              org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                              boolean serializeType)
                throws javax.xml.stream.XMLStreamException,
                       org.apache.axis2.databinding.ADBException {


            //We can safely assume an element has only one type associated with it

            java.lang.String namespace = "http://schemas.microsoft.com/2003/10/Serialization/";
            java.lang.String localName = "float";

            if (!namespace.equals("")) {
                java.lang.String prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    xmlWriter.writeStartElement(prefix, localName, namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);

                } else {
                    xmlWriter.writeStartElement(namespace, localName);
                }

            } else {
                xmlWriter.writeStartElement(localName);
            }

            // add the type details if this is used in a simple type
            if (serializeType) {
                java.lang.String namespacePrefix = registerPrefix(xmlWriter,
                                                                  "http://schemas.microsoft.com/2003/10/Serialization/");
                if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                                   namespacePrefix + ":float",
                                   xmlWriter);
                } else {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                                   "float",
                                   xmlWriter);
                }
            }

            if (java.lang.Float.isNaN(local_float)) {

                writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                               xmlWriter);

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.
                        convertToString(local_float));
            }

            xmlWriter.writeEndElement();



        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(java.lang.String prefix, java.lang.String namespace,
                                    java.lang.String attName,
                                    java.lang.String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);

            }

            xmlWriter.writeAttribute(namespace, attName, attValue);

        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace, java.lang.String attName,
                                    java.lang.String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                         javax.xml.namespace.QName qname,
                                         javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         *  method to handle Qnames
         */
        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.
                            convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.
                            convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.
                        convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.
                                    convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.
                                    convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.
                                convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }

        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter,
                                                java.lang.String namespace) throws
                javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);

            if (prefix == null) {
                prefix = generatePrefix(namespace);

                while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }

                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         *
         */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                throws org.apache.axis2.databinding.ADBException {




            //We can safely assume an element has only one type associated with it
            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(MY_QNAME,
                                                                                        new java.lang.Object[]{
                        org.apache.axis2.databinding.utils.reader.ADBXMLStreamReader.ELEMENT_TEXT,
                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString(local_float)
                    },
                                                                                        null);

        }

        /**
         *  Factory class that keeps the parse method
         */
        public static class Factory {

            /**
             * static method to create the object
             * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
             *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
             * Postcondition: If this object is an element, the reader is positioned at its end element
             *                If this object is a complex type, the reader is positioned at the end element of its outer element
             */
            public static _float parse(javax.xml.stream.XMLStreamReader reader) throws
                    java.lang.Exception {
                _float object =
                       new _float();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while (!reader.isStartElement() && !reader.isEndElement()) {
                        reader.next();
                    }


                    nillableValue = reader.getAttributeValue(
                            "http://www.w3.org/2001/XMLSchema-instance", "nil");
                    if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                        // Skip the element and report the null value.  It cannot have subelements.
                        while (!reader.isEndElement()) {
                            reader.next();
                        }

                        object.set_float(java.lang.Float.NaN);

                        return object;


                    }



                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();



                    while (!reader.isEndElement()) {
                        if (reader.isStartElement()) {

                            if (reader.isStartElement() && new javax.xml.namespace.QName(
                                    "http://schemas.microsoft.com/2003/10/Serialization/", "float").
                                    equals(reader.getName())) {

                                nillableValue = reader.getAttributeValue(
                                        "http://www.w3.org/2001/XMLSchema-instance", "nil");
                                if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

                                    java.lang.String content = reader.getElementText();

                                    object.set_float(
                                            org.apache.axis2.databinding.utils.ConverterUtil.
                                            convertToFloat(content));

                                } else {


                                    object.set_float(java.lang.Float.NaN);

                                    reader.getElementText(); // throw away text nodes if any.
                                }

                            } // End of if for expected property start element
                            else {
                                // A start element we are not expecting indicates an invalid parameter was passed
                                throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.
                                        getLocalName());
                            }

                        } else {
                            reader.next();
                        }
                    }  // end of while loop




                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }
        }//end of factory class

    }

    public static class _short
            implements org.apache.axis2.databinding.ADBBean {

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "http://schemas.microsoft.com/2003/10/Serialization/",
                "short",
                "ns3");

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if (namespace.equals("http://schemas.microsoft.com/2003/10/Serialization/")) {
                return "ns3";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }
        /**
         * field for _short
         */
        protected short local_short;

        /**
         * Auto generated getter method
         * @return short
         */
        public short get_short() {
            return local_short;
        }

        /**
         * Auto generated setter method
         * @param param _short
         */
        public void set_short(short param) {

            this.local_short = param;


        }

        /**
         * isReaderMTOMAware
         * @return true if the reader supports MTOM
         */
        public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
            boolean isReaderMTOMAware = false;

            try {
                isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(
                        org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
            } catch (java.lang.IllegalArgumentException e) {
                isReaderMTOMAware = false;
            }
            return isReaderMTOMAware;
        }

        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory) throws
                org.apache.axis2.databinding.ADBException {



            org.apache.axiom.om.OMDataSource dataSource =
                                             new org.apache.axis2.databinding.ADBDataSource(this,
                                                                                            MY_QNAME) {

                public void serialize(
                        org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                        throws javax.xml.stream.XMLStreamException {
                    _short.this.serialize(MY_QNAME, factory, xmlWriter);
                }
            };
            return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
                    MY_QNAME, factory, dataSource);

        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              final org.apache.axiom.om.OMFactory factory,
                              org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException,
                       org.apache.axis2.databinding.ADBException {
            serialize(parentQName, factory, xmlWriter, false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              final org.apache.axiom.om.OMFactory factory,
                              org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                              boolean serializeType)
                throws javax.xml.stream.XMLStreamException,
                       org.apache.axis2.databinding.ADBException {


            //We can safely assume an element has only one type associated with it

            java.lang.String namespace = "http://schemas.microsoft.com/2003/10/Serialization/";
            java.lang.String localName = "short";

            if (!namespace.equals("")) {
                java.lang.String prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    xmlWriter.writeStartElement(prefix, localName, namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);

                } else {
                    xmlWriter.writeStartElement(namespace, localName);
                }

            } else {
                xmlWriter.writeStartElement(localName);
            }

            // add the type details if this is used in a simple type
            if (serializeType) {
                java.lang.String namespacePrefix = registerPrefix(xmlWriter,
                                                                  "http://schemas.microsoft.com/2003/10/Serialization/");
                if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                                   namespacePrefix + ":short",
                                   xmlWriter);
                } else {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                                   "short",
                                   xmlWriter);
                }
            }

            if (local_short == java.lang.Short.MIN_VALUE) {

                writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                               xmlWriter);

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.
                        convertToString(local_short));
            }

            xmlWriter.writeEndElement();



        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(java.lang.String prefix, java.lang.String namespace,
                                    java.lang.String attName,
                                    java.lang.String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);

            }

            xmlWriter.writeAttribute(namespace, attName, attValue);

        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace, java.lang.String attName,
                                    java.lang.String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                         javax.xml.namespace.QName qname,
                                         javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         *  method to handle Qnames
         */
        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.
                            convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.
                            convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.
                        convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.
                                    convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.
                                    convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.
                                convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }

        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter,
                                                java.lang.String namespace) throws
                javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);

            if (prefix == null) {
                prefix = generatePrefix(namespace);

                while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }

                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         *
         */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                throws org.apache.axis2.databinding.ADBException {




            //We can safely assume an element has only one type associated with it
            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(MY_QNAME,
                                                                                        new java.lang.Object[]{
                        org.apache.axis2.databinding.utils.reader.ADBXMLStreamReader.ELEMENT_TEXT,
                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString(local_short)
                    },
                                                                                        null);

        }

        /**
         *  Factory class that keeps the parse method
         */
        public static class Factory {

            /**
             * static method to create the object
             * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
             *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
             * Postcondition: If this object is an element, the reader is positioned at its end element
             *                If this object is a complex type, the reader is positioned at the end element of its outer element
             */
            public static _short parse(javax.xml.stream.XMLStreamReader reader) throws
                    java.lang.Exception {
                _short object =
                       new _short();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while (!reader.isStartElement() && !reader.isEndElement()) {
                        reader.next();
                    }


                    nillableValue = reader.getAttributeValue(
                            "http://www.w3.org/2001/XMLSchema-instance", "nil");
                    if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                        // Skip the element and report the null value.  It cannot have subelements.
                        while (!reader.isEndElement()) {
                            reader.next();
                        }

                        object.set_short(java.lang.Short.MIN_VALUE);

                        return object;


                    }



                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();



                    while (!reader.isEndElement()) {
                        if (reader.isStartElement()) {

                            if (reader.isStartElement() && new javax.xml.namespace.QName(
                                    "http://schemas.microsoft.com/2003/10/Serialization/", "short").
                                    equals(reader.getName())) {

                                nillableValue = reader.getAttributeValue(
                                        "http://www.w3.org/2001/XMLSchema-instance", "nil");
                                if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

                                    java.lang.String content = reader.getElementText();

                                    object.set_short(
                                            org.apache.axis2.databinding.utils.ConverterUtil.
                                            convertToShort(content));

                                } else {


                                    object.set_short(java.lang.Short.MIN_VALUE);

                                    reader.getElementText(); // throw away text nodes if any.
                                }

                            } // End of if for expected property start element
                            else {
                                // A start element we are not expecting indicates an invalid parameter was passed
                                throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.
                                        getLocalName());
                            }

                        } else {
                            reader.next();
                        }
                    }  // end of while loop




                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }
        }//end of factory class

    }

    public static class Translate
            implements org.apache.axis2.databinding.ADBBean {

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "http://api.microsofttranslator.com/v1/soap.svc",
                "Translate",
                "ns2");

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if (namespace.equals("http://api.microsofttranslator.com/v1/soap.svc")) {
                return "ns2";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }
        /**
         * field for AppId
         */
        protected java.lang.String localAppId;
        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localAppIdTracker = false;

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getAppId() {
            return localAppId;
        }

        /**
         * Auto generated setter method
         * @param param AppId
         */
        public void setAppId(java.lang.String param) {

            if (param != null) {
                //update the setting tracker
                localAppIdTracker = true;
            } else {
                localAppIdTracker = true;

            }

            this.localAppId = param;


        }
        /**
         * field for Text
         */
        protected java.lang.String localText;
        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localTextTracker = false;

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getText() {
            return localText;
        }

        /**
         * Auto generated setter method
         * @param param Text
         */
        public void setText(java.lang.String param) {

            if (param != null) {
                //update the setting tracker
                localTextTracker = true;
            } else {
                localTextTracker = true;

            }

            this.localText = param;


        }
        /**
         * field for From
         */
        protected java.lang.String localFrom;
        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localFromTracker = false;

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getFrom() {
            return localFrom;
        }

        /**
         * Auto generated setter method
         * @param param From
         */
        public void setFrom(java.lang.String param) {

            if (param != null) {
                //update the setting tracker
                localFromTracker = true;
            } else {
                localFromTracker = true;

            }

            this.localFrom = param;


        }
        /**
         * field for To
         */
        protected java.lang.String localTo;
        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localToTracker = false;

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getTo() {
            return localTo;
        }

        /**
         * Auto generated setter method
         * @param param To
         */
        public void setTo(java.lang.String param) {

            if (param != null) {
                //update the setting tracker
                localToTracker = true;
            } else {
                localToTracker = true;

            }

            this.localTo = param;


        }

        /**
         * isReaderMTOMAware
         * @return true if the reader supports MTOM
         */
        public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
            boolean isReaderMTOMAware = false;

            try {
                isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(
                        org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
            } catch (java.lang.IllegalArgumentException e) {
                isReaderMTOMAware = false;
            }
            return isReaderMTOMAware;
        }

        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory) throws
                org.apache.axis2.databinding.ADBException {



            org.apache.axiom.om.OMDataSource dataSource =
                                             new org.apache.axis2.databinding.ADBDataSource(this,
                                                                                            MY_QNAME) {

                public void serialize(
                        org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                        throws javax.xml.stream.XMLStreamException {
                    Translate.this.serialize(MY_QNAME, factory, xmlWriter);
                }
            };
            return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
                    MY_QNAME, factory, dataSource);

        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              final org.apache.axiom.om.OMFactory factory,
                              org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException,
                       org.apache.axis2.databinding.ADBException {
            serialize(parentQName, factory, xmlWriter, false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              final org.apache.axiom.om.OMFactory factory,
                              org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                              boolean serializeType)
                throws javax.xml.stream.XMLStreamException,
                       org.apache.axis2.databinding.ADBException {




            java.lang.String prefix = null;
            java.lang.String namespace = null;


            prefix = parentQName.getPrefix();
            namespace = parentQName.getNamespaceURI();

            if ((namespace != null) && (namespace.trim().length() > 0)) {
                java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
                if (writerPrefix != null) {
                    xmlWriter.writeStartElement(namespace, parentQName.getLocalPart());
                } else {
                    if (prefix == null) {
                        prefix = generatePrefix(namespace);
                    }

                    xmlWriter.writeStartElement(prefix, parentQName.getLocalPart(), namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);
                }
            } else {
                xmlWriter.writeStartElement(parentQName.getLocalPart());
            }

            if (serializeType) {


                java.lang.String namespacePrefix = registerPrefix(xmlWriter,
                                                                  "http://api.microsofttranslator.com/v1/soap.svc");
                if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                                   namespacePrefix + ":Translate",
                                   xmlWriter);
                } else {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                                   "Translate",
                                   xmlWriter);
                }


            }
            if (localAppIdTracker) {
                namespace = "http://api.microsofttranslator.com/v1/soap.svc";
                if (!namespace.equals("")) {
                    prefix = xmlWriter.getPrefix(namespace);

                    if (prefix == null) {
                        prefix = generatePrefix(namespace);

                        xmlWriter.writeStartElement(prefix, "appId", namespace);
                        xmlWriter.writeNamespace(prefix, namespace);
                        xmlWriter.setPrefix(prefix, namespace);

                    } else {
                        xmlWriter.writeStartElement(namespace, "appId");
                    }

                } else {
                    xmlWriter.writeStartElement("appId");
                }


                if (localAppId == null) {
                    // write the nil attribute

                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                                   xmlWriter);

                } else {


                    xmlWriter.writeCharacters(localAppId);

                }

                xmlWriter.writeEndElement();
            }
            if (localTextTracker) {
                namespace = "http://api.microsofttranslator.com/v1/soap.svc";
                if (!namespace.equals("")) {
                    prefix = xmlWriter.getPrefix(namespace);

                    if (prefix == null) {
                        prefix = generatePrefix(namespace);

                        xmlWriter.writeStartElement(prefix, "text", namespace);
                        xmlWriter.writeNamespace(prefix, namespace);
                        xmlWriter.setPrefix(prefix, namespace);

                    } else {
                        xmlWriter.writeStartElement(namespace, "text");
                    }

                } else {
                    xmlWriter.writeStartElement("text");
                }


                if (localText == null) {
                    // write the nil attribute

                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                                   xmlWriter);

                } else {


                    xmlWriter.writeCharacters(localText);

                }

                xmlWriter.writeEndElement();
            }
            if (localFromTracker) {
                namespace = "http://api.microsofttranslator.com/v1/soap.svc";
                if (!namespace.equals("")) {
                    prefix = xmlWriter.getPrefix(namespace);

                    if (prefix == null) {
                        prefix = generatePrefix(namespace);

                        xmlWriter.writeStartElement(prefix, "from", namespace);
                        xmlWriter.writeNamespace(prefix, namespace);
                        xmlWriter.setPrefix(prefix, namespace);

                    } else {
                        xmlWriter.writeStartElement(namespace, "from");
                    }

                } else {
                    xmlWriter.writeStartElement("from");
                }


                if (localFrom == null) {
                    // write the nil attribute

                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                                   xmlWriter);

                } else {


                    xmlWriter.writeCharacters(localFrom);

                }

                xmlWriter.writeEndElement();
            }
            if (localToTracker) {
                namespace = "http://api.microsofttranslator.com/v1/soap.svc";
                if (!namespace.equals("")) {
                    prefix = xmlWriter.getPrefix(namespace);

                    if (prefix == null) {
                        prefix = generatePrefix(namespace);

                        xmlWriter.writeStartElement(prefix, "to", namespace);
                        xmlWriter.writeNamespace(prefix, namespace);
                        xmlWriter.setPrefix(prefix, namespace);

                    } else {
                        xmlWriter.writeStartElement(namespace, "to");
                    }

                } else {
                    xmlWriter.writeStartElement("to");
                }


                if (localTo == null) {
                    // write the nil attribute

                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                                   xmlWriter);

                } else {


                    xmlWriter.writeCharacters(localTo);

                }

                xmlWriter.writeEndElement();
            }
            xmlWriter.writeEndElement();


        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(java.lang.String prefix, java.lang.String namespace,
                                    java.lang.String attName,
                                    java.lang.String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);

            }

            xmlWriter.writeAttribute(namespace, attName, attValue);

        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace, java.lang.String attName,
                                    java.lang.String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                         javax.xml.namespace.QName qname,
                                         javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         *  method to handle Qnames
         */
        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.
                            convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.
                            convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.
                        convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.
                                    convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.
                                    convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.
                                convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }

        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter,
                                                java.lang.String namespace) throws
                javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);

            if (prefix == null) {
                prefix = generatePrefix(namespace);

                while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }

                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         *
         */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                throws org.apache.axis2.databinding.ADBException {



            java.util.ArrayList elementList = new java.util.ArrayList();
            java.util.ArrayList attribList = new java.util.ArrayList();

            if (localAppIdTracker) {
                elementList.add(new javax.xml.namespace.QName(
                        "http://api.microsofttranslator.com/v1/soap.svc",
                                                              "appId"));

                elementList.add(localAppId == null ? null : org.apache.axis2.databinding.utils.ConverterUtil.
                        convertToString(localAppId));
            }
            if (localTextTracker) {
                elementList.add(new javax.xml.namespace.QName(
                        "http://api.microsofttranslator.com/v1/soap.svc",
                                                              "text"));

                elementList.add(localText == null ? null : org.apache.axis2.databinding.utils.ConverterUtil.
                        convertToString(localText));
            }
            if (localFromTracker) {
                elementList.add(new javax.xml.namespace.QName(
                        "http://api.microsofttranslator.com/v1/soap.svc",
                                                              "from"));

                elementList.add(localFrom == null ? null : org.apache.axis2.databinding.utils.ConverterUtil.
                        convertToString(localFrom));
            }
            if (localToTracker) {
                elementList.add(new javax.xml.namespace.QName(
                        "http://api.microsofttranslator.com/v1/soap.svc",
                                                              "to"));

                elementList.add(localTo == null ? null : org.apache.axis2.databinding.utils.ConverterUtil.
                        convertToString(localTo));
            }

            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName,
                                                                                        elementList.
                    toArray(), attribList.toArray());



        }

        /**
         *  Factory class that keeps the parse method
         */
        public static class Factory {

            /**
             * static method to create the object
             * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
             *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
             * Postcondition: If this object is an element, the reader is positioned at its end element
             *                If this object is a complex type, the reader is positioned at the end element of its outer element
             */
            public static Translate parse(javax.xml.stream.XMLStreamReader reader) throws
                    java.lang.Exception {
                Translate object =
                          new Translate();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while (!reader.isStartElement() && !reader.isEndElement()) {
                        reader.next();
                    }


                    if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type") != null) {
                        java.lang.String fullTypeName = reader.getAttributeValue(
                                "http://www.w3.org/2001/XMLSchema-instance",
                                                                                 "type");
                        if (fullTypeName != null) {
                            java.lang.String nsPrefix = null;
                            if (fullTypeName.indexOf(":") > -1) {
                                nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
                            }
                            nsPrefix = nsPrefix == null ? "" : nsPrefix;

                            java.lang.String type = fullTypeName.substring(
                                    fullTypeName.indexOf(":") + 1);

                            if (!"Translate".equals(type)) {
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().
                                        getNamespaceURI(nsPrefix);
                                return (Translate) ExtensionMapper.getTypeObject(
                                        nsUri, type, reader);
                            }


                        }


                    }




                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();




                    reader.next();


                    while (!reader.isStartElement() && !reader.isEndElement()) {
                        reader.next();
                    }

                    if (reader.isStartElement() && new javax.xml.namespace.QName(
                            "http://api.microsofttranslator.com/v1/soap.svc", "appId").equals(reader.
                            getName())) {

                        nillableValue = reader.getAttributeValue(
                                "http://www.w3.org/2001/XMLSchema-instance", "nil");
                        if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

                            java.lang.String content = reader.getElementText();

                            object.setAppId(
                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                    content));

                        } else {


                            reader.getElementText(); // throw away text nodes if any.
                        }

                        reader.next();

                    } // End of if for expected property start element
                    else {
                    }


                    while (!reader.isStartElement() && !reader.isEndElement()) {
                        reader.next();
                    }

                    if (reader.isStartElement() && new javax.xml.namespace.QName(
                            "http://api.microsofttranslator.com/v1/soap.svc", "text").equals(reader.
                            getName())) {

                        nillableValue = reader.getAttributeValue(
                                "http://www.w3.org/2001/XMLSchema-instance", "nil");
                        if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

                            java.lang.String content = reader.getElementText();

                            object.setText(
                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                    content));

                        } else {


                            reader.getElementText(); // throw away text nodes if any.
                        }

                        reader.next();

                    } // End of if for expected property start element
                    else {
                    }


                    while (!reader.isStartElement() && !reader.isEndElement()) {
                        reader.next();
                    }

                    if (reader.isStartElement() && new javax.xml.namespace.QName(
                            "http://api.microsofttranslator.com/v1/soap.svc", "from").equals(reader.
                            getName())) {

                        nillableValue = reader.getAttributeValue(
                                "http://www.w3.org/2001/XMLSchema-instance", "nil");
                        if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

                            java.lang.String content = reader.getElementText();

                            object.setFrom(
                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                    content));

                        } else {


                            reader.getElementText(); // throw away text nodes if any.
                        }

                        reader.next();

                    } // End of if for expected property start element
                    else {
                    }


                    while (!reader.isStartElement() && !reader.isEndElement()) {
                        reader.next();
                    }

                    if (reader.isStartElement() && new javax.xml.namespace.QName(
                            "http://api.microsofttranslator.com/v1/soap.svc", "to").equals(reader.
                            getName())) {

                        nillableValue = reader.getAttributeValue(
                                "http://www.w3.org/2001/XMLSchema-instance", "nil");
                        if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

                            java.lang.String content = reader.getElementText();

                            object.setTo(
                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                    content));

                        } else {


                            reader.getElementText(); // throw away text nodes if any.
                        }

                        reader.next();

                    } // End of if for expected property start element
                    else {
                    }

                    while (!reader.isStartElement() && !reader.isEndElement()) {
                        reader.next();
                    }

                    if (reader.isStartElement()) // A start element we are not expecting indicates a trailing invalid property
                    {
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.
                                getLocalName());
                    }




                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }
        }//end of factory class

    }

    public static class GetLanguageNames
            implements org.apache.axis2.databinding.ADBBean {

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "http://api.microsofttranslator.com/v1/soap.svc",
                "GetLanguageNames",
                "ns2");

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if (namespace.equals("http://api.microsofttranslator.com/v1/soap.svc")) {
                return "ns2";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }
        /**
         * field for AppId
         */
        protected java.lang.String localAppId;
        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localAppIdTracker = false;

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getAppId() {
            return localAppId;
        }

        /**
         * Auto generated setter method
         * @param param AppId
         */
        public void setAppId(java.lang.String param) {

            if (param != null) {
                //update the setting tracker
                localAppIdTracker = true;
            } else {
                localAppIdTracker = true;

            }

            this.localAppId = param;


        }
        /**
         * field for Locale
         */
        protected java.lang.String localLocale;
        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localLocaleTracker = false;

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getLocale() {
            return localLocale;
        }

        /**
         * Auto generated setter method
         * @param param Locale
         */
        public void setLocale(java.lang.String param) {

            if (param != null) {
                //update the setting tracker
                localLocaleTracker = true;
            } else {
                localLocaleTracker = true;

            }

            this.localLocale = param;


        }

        /**
         * isReaderMTOMAware
         * @return true if the reader supports MTOM
         */
        public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
            boolean isReaderMTOMAware = false;

            try {
                isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(
                        org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
            } catch (java.lang.IllegalArgumentException e) {
                isReaderMTOMAware = false;
            }
            return isReaderMTOMAware;
        }

        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory) throws
                org.apache.axis2.databinding.ADBException {



            org.apache.axiom.om.OMDataSource dataSource =
                                             new org.apache.axis2.databinding.ADBDataSource(this,
                                                                                            MY_QNAME) {

                public void serialize(
                        org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                        throws javax.xml.stream.XMLStreamException {
                    GetLanguageNames.this.serialize(MY_QNAME, factory, xmlWriter);
                }
            };
            return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
                    MY_QNAME, factory, dataSource);

        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              final org.apache.axiom.om.OMFactory factory,
                              org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException,
                       org.apache.axis2.databinding.ADBException {
            serialize(parentQName, factory, xmlWriter, false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              final org.apache.axiom.om.OMFactory factory,
                              org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                              boolean serializeType)
                throws javax.xml.stream.XMLStreamException,
                       org.apache.axis2.databinding.ADBException {




            java.lang.String prefix = null;
            java.lang.String namespace = null;


            prefix = parentQName.getPrefix();
            namespace = parentQName.getNamespaceURI();

            if ((namespace != null) && (namespace.trim().length() > 0)) {
                java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
                if (writerPrefix != null) {
                    xmlWriter.writeStartElement(namespace, parentQName.getLocalPart());
                } else {
                    if (prefix == null) {
                        prefix = generatePrefix(namespace);
                    }

                    xmlWriter.writeStartElement(prefix, parentQName.getLocalPart(), namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);
                }
            } else {
                xmlWriter.writeStartElement(parentQName.getLocalPart());
            }

            if (serializeType) {


                java.lang.String namespacePrefix = registerPrefix(xmlWriter,
                                                                  "http://api.microsofttranslator.com/v1/soap.svc");
                if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                                   namespacePrefix + ":GetLanguageNames",
                                   xmlWriter);
                } else {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                                   "GetLanguageNames",
                                   xmlWriter);
                }


            }
            if (localAppIdTracker) {
                namespace = "http://api.microsofttranslator.com/v1/soap.svc";
                if (!namespace.equals("")) {
                    prefix = xmlWriter.getPrefix(namespace);

                    if (prefix == null) {
                        prefix = generatePrefix(namespace);

                        xmlWriter.writeStartElement(prefix, "appId", namespace);
                        xmlWriter.writeNamespace(prefix, namespace);
                        xmlWriter.setPrefix(prefix, namespace);

                    } else {
                        xmlWriter.writeStartElement(namespace, "appId");
                    }

                } else {
                    xmlWriter.writeStartElement("appId");
                }


                if (localAppId == null) {
                    // write the nil attribute

                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                                   xmlWriter);

                } else {


                    xmlWriter.writeCharacters(localAppId);

                }

                xmlWriter.writeEndElement();
            }
            if (localLocaleTracker) {
                namespace = "http://api.microsofttranslator.com/v1/soap.svc";
                if (!namespace.equals("")) {
                    prefix = xmlWriter.getPrefix(namespace);

                    if (prefix == null) {
                        prefix = generatePrefix(namespace);

                        xmlWriter.writeStartElement(prefix, "locale", namespace);
                        xmlWriter.writeNamespace(prefix, namespace);
                        xmlWriter.setPrefix(prefix, namespace);

                    } else {
                        xmlWriter.writeStartElement(namespace, "locale");
                    }

                } else {
                    xmlWriter.writeStartElement("locale");
                }


                if (localLocale == null) {
                    // write the nil attribute

                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                                   xmlWriter);

                } else {


                    xmlWriter.writeCharacters(localLocale);

                }

                xmlWriter.writeEndElement();
            }
            xmlWriter.writeEndElement();


        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(java.lang.String prefix, java.lang.String namespace,
                                    java.lang.String attName,
                                    java.lang.String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);

            }

            xmlWriter.writeAttribute(namespace, attName, attValue);

        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace, java.lang.String attName,
                                    java.lang.String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                         javax.xml.namespace.QName qname,
                                         javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         *  method to handle Qnames
         */
        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.
                            convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.
                            convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.
                        convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.
                                    convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.
                                    convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.
                                convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }

        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter,
                                                java.lang.String namespace) throws
                javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);

            if (prefix == null) {
                prefix = generatePrefix(namespace);

                while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }

                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         *
         */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                throws org.apache.axis2.databinding.ADBException {



            java.util.ArrayList elementList = new java.util.ArrayList();
            java.util.ArrayList attribList = new java.util.ArrayList();

            if (localAppIdTracker) {
                elementList.add(new javax.xml.namespace.QName(
                        "http://api.microsofttranslator.com/v1/soap.svc",
                                                              "appId"));

                elementList.add(localAppId == null ? null : org.apache.axis2.databinding.utils.ConverterUtil.
                        convertToString(localAppId));
            }
            if (localLocaleTracker) {
                elementList.add(new javax.xml.namespace.QName(
                        "http://api.microsofttranslator.com/v1/soap.svc",
                                                              "locale"));

                elementList.add(localLocale == null ? null : org.apache.axis2.databinding.utils.ConverterUtil.
                        convertToString(localLocale));
            }

            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName,
                                                                                        elementList.
                    toArray(), attribList.toArray());



        }

        /**
         *  Factory class that keeps the parse method
         */
        public static class Factory {

            /**
             * static method to create the object
             * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
             *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
             * Postcondition: If this object is an element, the reader is positioned at its end element
             *                If this object is a complex type, the reader is positioned at the end element of its outer element
             */
            public static GetLanguageNames parse(javax.xml.stream.XMLStreamReader reader) throws
                    java.lang.Exception {
                GetLanguageNames object =
                                 new GetLanguageNames();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while (!reader.isStartElement() && !reader.isEndElement()) {
                        reader.next();
                    }


                    if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type") != null) {
                        java.lang.String fullTypeName = reader.getAttributeValue(
                                "http://www.w3.org/2001/XMLSchema-instance",
                                                                                 "type");
                        if (fullTypeName != null) {
                            java.lang.String nsPrefix = null;
                            if (fullTypeName.indexOf(":") > -1) {
                                nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
                            }
                            nsPrefix = nsPrefix == null ? "" : nsPrefix;

                            java.lang.String type = fullTypeName.substring(
                                    fullTypeName.indexOf(":") + 1);

                            if (!"GetLanguageNames".equals(type)) {
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().
                                        getNamespaceURI(nsPrefix);
                                return (GetLanguageNames) ExtensionMapper.getTypeObject(
                                        nsUri, type, reader);
                            }


                        }


                    }




                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();




                    reader.next();


                    while (!reader.isStartElement() && !reader.isEndElement()) {
                        reader.next();
                    }

                    if (reader.isStartElement() && new javax.xml.namespace.QName(
                            "http://api.microsofttranslator.com/v1/soap.svc", "appId").equals(reader.
                            getName())) {

                        nillableValue = reader.getAttributeValue(
                                "http://www.w3.org/2001/XMLSchema-instance", "nil");
                        if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

                            java.lang.String content = reader.getElementText();

                            object.setAppId(
                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                    content));

                        } else {


                            reader.getElementText(); // throw away text nodes if any.
                        }

                        reader.next();

                    } // End of if for expected property start element
                    else {
                    }


                    while (!reader.isStartElement() && !reader.isEndElement()) {
                        reader.next();
                    }

                    if (reader.isStartElement() && new javax.xml.namespace.QName(
                            "http://api.microsofttranslator.com/v1/soap.svc", "locale").equals(reader.
                            getName())) {

                        nillableValue = reader.getAttributeValue(
                                "http://www.w3.org/2001/XMLSchema-instance", "nil");
                        if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

                            java.lang.String content = reader.getElementText();

                            object.setLocale(
                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                    content));

                        } else {


                            reader.getElementText(); // throw away text nodes if any.
                        }

                        reader.next();

                    } // End of if for expected property start element
                    else {
                    }

                    while (!reader.isStartElement() && !reader.isEndElement()) {
                        reader.next();
                    }

                    if (reader.isStartElement()) // A start element we are not expecting indicates a trailing invalid property
                    {
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.
                                getLocalName());
                    }




                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }
        }//end of factory class

    }

    public static class _charE
            implements org.apache.axis2.databinding.ADBBean {

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "http://schemas.microsoft.com/2003/10/Serialization/",
                "char",
                "ns3");

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if (namespace.equals("http://schemas.microsoft.com/2003/10/Serialization/")) {
                return "ns3";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }
        /**
         * field for _char
         */
        protected _char local_char;

        /**
         * Auto generated getter method
         * @return _char
         */
        public _char get_char() {
            return local_char;
        }

        /**
         * Auto generated setter method
         * @param param _char
         */
        public void set_char(_char param) {

            this.local_char = param;


        }

        /**
         * isReaderMTOMAware
         * @return true if the reader supports MTOM
         */
        public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
            boolean isReaderMTOMAware = false;

            try {
                isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(
                        org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
            } catch (java.lang.IllegalArgumentException e) {
                isReaderMTOMAware = false;
            }
            return isReaderMTOMAware;
        }

        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory) throws
                org.apache.axis2.databinding.ADBException {



            org.apache.axiom.om.OMDataSource dataSource =
                                             new org.apache.axis2.databinding.ADBDataSource(this,
                                                                                            MY_QNAME) {

                public void serialize(
                        org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                        throws javax.xml.stream.XMLStreamException {
                    _charE.this.serialize(MY_QNAME, factory, xmlWriter);
                }
            };
            return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
                    MY_QNAME, factory, dataSource);

        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              final org.apache.axiom.om.OMFactory factory,
                              org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException,
                       org.apache.axis2.databinding.ADBException {
            serialize(parentQName, factory, xmlWriter, false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              final org.apache.axiom.om.OMFactory factory,
                              org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                              boolean serializeType)
                throws javax.xml.stream.XMLStreamException,
                       org.apache.axis2.databinding.ADBException {


            //We can safely assume an element has only one type associated with it

            if (local_char == null) {
                java.lang.String namespace = "http://schemas.microsoft.com/2003/10/Serialization/";

                if (!namespace.equals("")) {
                    java.lang.String prefix = xmlWriter.getPrefix(namespace);

                    if (prefix == null) {
                        prefix = generatePrefix(namespace);

                        xmlWriter.writeStartElement(prefix, "char", namespace);
                        xmlWriter.writeNamespace(prefix, namespace);
                        xmlWriter.setPrefix(prefix, namespace);

                    } else {
                        xmlWriter.writeStartElement(namespace, "char");
                    }

                } else {
                    xmlWriter.writeStartElement("char");
                }

                // write the nil attribute
                writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                               xmlWriter);
                xmlWriter.writeEndElement();
            } else {
                local_char.serialize(MY_QNAME, factory, xmlWriter);
            }


        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(java.lang.String prefix, java.lang.String namespace,
                                    java.lang.String attName,
                                    java.lang.String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);

            }

            xmlWriter.writeAttribute(namespace, attName, attValue);

        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace, java.lang.String attName,
                                    java.lang.String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                         javax.xml.namespace.QName qname,
                                         javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         *  method to handle Qnames
         */
        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.
                            convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.
                            convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.
                        convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.
                                    convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.
                                    convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.
                                convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }

        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter,
                                                java.lang.String namespace) throws
                javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);

            if (prefix == null) {
                prefix = generatePrefix(namespace);

                while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }

                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         *
         */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                throws org.apache.axis2.databinding.ADBException {




            //We can safely assume an element has only one type associated with it

            if (local_char == null) {
                return new org.apache.axis2.databinding.utils.reader.NullXMLStreamReader(MY_QNAME);
            } else {
                return local_char.getPullParser(MY_QNAME);
            }


        }

        /**
         *  Factory class that keeps the parse method
         */
        public static class Factory {

            /**
             * static method to create the object
             * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
             *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
             * Postcondition: If this object is an element, the reader is positioned at its end element
             *                If this object is a complex type, the reader is positioned at the end element of its outer element
             */
            public static _charE parse(javax.xml.stream.XMLStreamReader reader) throws
                    java.lang.Exception {
                _charE object =
                       new _charE();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while (!reader.isStartElement() && !reader.isEndElement()) {
                        reader.next();
                    }


                    nillableValue = reader.getAttributeValue(
                            "http://www.w3.org/2001/XMLSchema-instance", "nil");
                    if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                        // Skip the element and report the null value.  It cannot have subelements.
                        while (!reader.isEndElement()) {
                            reader.next();
                        }

                        return object;


                    }



                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();



                    while (!reader.isEndElement()) {
                        if (reader.isStartElement()) {

                            if (reader.isStartElement() && new javax.xml.namespace.QName(
                                    "http://schemas.microsoft.com/2003/10/Serialization/", "char").
                                    equals(reader.getName())) {

                                nillableValue = reader.getAttributeValue(
                                        "http://www.w3.org/2001/XMLSchema-instance", "nil");
                                if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                                    object.set_char(null);
                                    reader.next();

                                } else {

                                    object.set_char(_char.Factory.parse(reader));
                                }
                            } // End of if for expected property start element
                            else {
                                // A start element we are not expecting indicates an invalid parameter was passed
                                throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.
                                        getLocalName());
                            }

                        } else {
                            reader.next();
                        }
                    }  // end of while loop




                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }
        }//end of factory class

    }

    public static class TranslateResponse
            implements org.apache.axis2.databinding.ADBBean {

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "http://api.microsofttranslator.com/v1/soap.svc",
                "TranslateResponse",
                "ns2");

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if (namespace.equals("http://api.microsofttranslator.com/v1/soap.svc")) {
                return "ns2";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }
        /**
         * field for TranslateResult
         */
        protected java.lang.String localTranslateResult;
        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localTranslateResultTracker = false;

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getTranslateResult() {
            return localTranslateResult;
        }

        /**
         * Auto generated setter method
         * @param param TranslateResult
         */
        public void setTranslateResult(java.lang.String param) {

            if (param != null) {
                //update the setting tracker
                localTranslateResultTracker = true;
            } else {
                localTranslateResultTracker = true;

            }

            this.localTranslateResult = param;


        }

        /**
         * isReaderMTOMAware
         * @return true if the reader supports MTOM
         */
        public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
            boolean isReaderMTOMAware = false;

            try {
                isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(
                        org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
            } catch (java.lang.IllegalArgumentException e) {
                isReaderMTOMAware = false;
            }
            return isReaderMTOMAware;
        }

        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory) throws
                org.apache.axis2.databinding.ADBException {



            org.apache.axiom.om.OMDataSource dataSource =
                                             new org.apache.axis2.databinding.ADBDataSource(this,
                                                                                            MY_QNAME) {

                public void serialize(
                        org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                        throws javax.xml.stream.XMLStreamException {
                    TranslateResponse.this.serialize(MY_QNAME, factory, xmlWriter);
                }
            };
            return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
                    MY_QNAME, factory, dataSource);

        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              final org.apache.axiom.om.OMFactory factory,
                              org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException,
                       org.apache.axis2.databinding.ADBException {
            serialize(parentQName, factory, xmlWriter, false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              final org.apache.axiom.om.OMFactory factory,
                              org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                              boolean serializeType)
                throws javax.xml.stream.XMLStreamException,
                       org.apache.axis2.databinding.ADBException {




            java.lang.String prefix = null;
            java.lang.String namespace = null;


            prefix = parentQName.getPrefix();
            namespace = parentQName.getNamespaceURI();

            if ((namespace != null) && (namespace.trim().length() > 0)) {
                java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
                if (writerPrefix != null) {
                    xmlWriter.writeStartElement(namespace, parentQName.getLocalPart());
                } else {
                    if (prefix == null) {
                        prefix = generatePrefix(namespace);
                    }

                    xmlWriter.writeStartElement(prefix, parentQName.getLocalPart(), namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);
                }
            } else {
                xmlWriter.writeStartElement(parentQName.getLocalPart());
            }

            if (serializeType) {


                java.lang.String namespacePrefix = registerPrefix(xmlWriter,
                                                                  "http://api.microsofttranslator.com/v1/soap.svc");
                if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                                   namespacePrefix + ":TranslateResponse",
                                   xmlWriter);
                } else {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                                   "TranslateResponse",
                                   xmlWriter);
                }


            }
            if (localTranslateResultTracker) {
                namespace = "http://api.microsofttranslator.com/v1/soap.svc";
                if (!namespace.equals("")) {
                    prefix = xmlWriter.getPrefix(namespace);

                    if (prefix == null) {
                        prefix = generatePrefix(namespace);

                        xmlWriter.writeStartElement(prefix, "TranslateResult", namespace);
                        xmlWriter.writeNamespace(prefix, namespace);
                        xmlWriter.setPrefix(prefix, namespace);

                    } else {
                        xmlWriter.writeStartElement(namespace, "TranslateResult");
                    }

                } else {
                    xmlWriter.writeStartElement("TranslateResult");
                }


                if (localTranslateResult == null) {
                    // write the nil attribute

                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                                   xmlWriter);

                } else {


                    xmlWriter.writeCharacters(localTranslateResult);

                }

                xmlWriter.writeEndElement();
            }
            xmlWriter.writeEndElement();


        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(java.lang.String prefix, java.lang.String namespace,
                                    java.lang.String attName,
                                    java.lang.String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);

            }

            xmlWriter.writeAttribute(namespace, attName, attValue);

        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace, java.lang.String attName,
                                    java.lang.String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                         javax.xml.namespace.QName qname,
                                         javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         *  method to handle Qnames
         */
        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.
                            convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.
                            convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.
                        convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.
                                    convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.
                                    convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.
                                convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }

        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter,
                                                java.lang.String namespace) throws
                javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);

            if (prefix == null) {
                prefix = generatePrefix(namespace);

                while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }

                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         *
         */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                throws org.apache.axis2.databinding.ADBException {



            java.util.ArrayList elementList = new java.util.ArrayList();
            java.util.ArrayList attribList = new java.util.ArrayList();

            if (localTranslateResultTracker) {
                elementList.add(new javax.xml.namespace.QName(
                        "http://api.microsofttranslator.com/v1/soap.svc",
                                                              "TranslateResult"));

                elementList.add(localTranslateResult == null ? null : org.apache.axis2.databinding.utils.ConverterUtil.
                        convertToString(localTranslateResult));
            }

            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName,
                                                                                        elementList.
                    toArray(), attribList.toArray());



        }

        /**
         *  Factory class that keeps the parse method
         */
        public static class Factory {

            /**
             * static method to create the object
             * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
             *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
             * Postcondition: If this object is an element, the reader is positioned at its end element
             *                If this object is a complex type, the reader is positioned at the end element of its outer element
             */
            public static TranslateResponse parse(javax.xml.stream.XMLStreamReader reader) throws
                    java.lang.Exception {
                TranslateResponse object =
                                  new TranslateResponse();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while (!reader.isStartElement() && !reader.isEndElement()) {
                        reader.next();
                    }


                    if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type") != null) {
                        java.lang.String fullTypeName = reader.getAttributeValue(
                                "http://www.w3.org/2001/XMLSchema-instance",
                                                                                 "type");
                        if (fullTypeName != null) {
                            java.lang.String nsPrefix = null;
                            if (fullTypeName.indexOf(":") > -1) {
                                nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
                            }
                            nsPrefix = nsPrefix == null ? "" : nsPrefix;

                            java.lang.String type = fullTypeName.substring(
                                    fullTypeName.indexOf(":") + 1);

                            if (!"TranslateResponse".equals(type)) {
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().
                                        getNamespaceURI(nsPrefix);
                                return (TranslateResponse) ExtensionMapper.getTypeObject(
                                        nsUri, type, reader);
                            }


                        }


                    }




                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();




                    reader.next();


                    while (!reader.isStartElement() && !reader.isEndElement()) {
                        reader.next();
                    }

                    if (reader.isStartElement() && new javax.xml.namespace.QName(
                            "http://api.microsofttranslator.com/v1/soap.svc", "TranslateResult").
                            equals(reader.getName())) {

                        nillableValue = reader.getAttributeValue(
                                "http://www.w3.org/2001/XMLSchema-instance", "nil");
                        if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

                            java.lang.String content = reader.getElementText();

                            object.setTranslateResult(
                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                    content));

                        } else {


                            reader.getElementText(); // throw away text nodes if any.
                        }

                        reader.next();

                    } // End of if for expected property start element
                    else {
                    }

                    while (!reader.isStartElement() && !reader.isEndElement()) {
                        reader.next();
                    }

                    if (reader.isStartElement()) // A start element we are not expecting indicates a trailing invalid property
                    {
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.
                                getLocalName());
                    }




                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }
        }//end of factory class

    }

    public static class UnsignedByte
            implements org.apache.axis2.databinding.ADBBean {

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "http://schemas.microsoft.com/2003/10/Serialization/",
                "unsignedByte",
                "ns3");

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if (namespace.equals("http://schemas.microsoft.com/2003/10/Serialization/")) {
                return "ns3";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }
        /**
         * field for UnsignedByte
         */
        protected org.apache.axis2.databinding.types.UnsignedByte localUnsignedByte;

        /**
         * Auto generated getter method
         * @return org.apache.axis2.databinding.types.UnsignedByte
         */
        public org.apache.axis2.databinding.types.UnsignedByte getUnsignedByte() {
            return localUnsignedByte;
        }

        /**
         * Auto generated setter method
         * @param param UnsignedByte
         */
        public void setUnsignedByte(org.apache.axis2.databinding.types.UnsignedByte param) {

            this.localUnsignedByte = param;


        }

        /**
         * isReaderMTOMAware
         * @return true if the reader supports MTOM
         */
        public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
            boolean isReaderMTOMAware = false;

            try {
                isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(
                        org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
            } catch (java.lang.IllegalArgumentException e) {
                isReaderMTOMAware = false;
            }
            return isReaderMTOMAware;
        }

        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory) throws
                org.apache.axis2.databinding.ADBException {



            org.apache.axiom.om.OMDataSource dataSource =
                                             new org.apache.axis2.databinding.ADBDataSource(this,
                                                                                            MY_QNAME) {

                public void serialize(
                        org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                        throws javax.xml.stream.XMLStreamException {
                    UnsignedByte.this.serialize(MY_QNAME, factory, xmlWriter);
                }
            };
            return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
                    MY_QNAME, factory, dataSource);

        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              final org.apache.axiom.om.OMFactory factory,
                              org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException,
                       org.apache.axis2.databinding.ADBException {
            serialize(parentQName, factory, xmlWriter, false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              final org.apache.axiom.om.OMFactory factory,
                              org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                              boolean serializeType)
                throws javax.xml.stream.XMLStreamException,
                       org.apache.axis2.databinding.ADBException {


            //We can safely assume an element has only one type associated with it

            java.lang.String namespace = "http://schemas.microsoft.com/2003/10/Serialization/";
            java.lang.String localName = "unsignedByte";

            if (!namespace.equals("")) {
                java.lang.String prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    xmlWriter.writeStartElement(prefix, localName, namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);

                } else {
                    xmlWriter.writeStartElement(namespace, localName);
                }

            } else {
                xmlWriter.writeStartElement(localName);
            }

            // add the type details if this is used in a simple type
            if (serializeType) {
                java.lang.String namespacePrefix = registerPrefix(xmlWriter,
                                                                  "http://schemas.microsoft.com/2003/10/Serialization/");
                if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                                   namespacePrefix + ":unsignedByte",
                                   xmlWriter);
                } else {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                                   "unsignedByte",
                                   xmlWriter);
                }
            }

            if (localUnsignedByte == null) {

                // write the nil attribute
                writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                               xmlWriter);

            } else {

                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.
                        convertToString(localUnsignedByte));

            }

            xmlWriter.writeEndElement();



        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(java.lang.String prefix, java.lang.String namespace,
                                    java.lang.String attName,
                                    java.lang.String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);

            }

            xmlWriter.writeAttribute(namespace, attName, attValue);

        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace, java.lang.String attName,
                                    java.lang.String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                         javax.xml.namespace.QName qname,
                                         javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         *  method to handle Qnames
         */
        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.
                            convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.
                            convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.
                        convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.
                                    convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.
                                    convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.
                                convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }

        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter,
                                                java.lang.String namespace) throws
                javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);

            if (prefix == null) {
                prefix = generatePrefix(namespace);

                while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }

                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         *
         */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                throws org.apache.axis2.databinding.ADBException {




            //We can safely assume an element has only one type associated with it

            if (localUnsignedByte == null) {
                return new org.apache.axis2.databinding.utils.reader.NullXMLStreamReader(MY_QNAME);
            } else {
                return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(MY_QNAME,
                                                                                            new java.lang.Object[]{
                            org.apache.axis2.databinding.utils.reader.ADBXMLStreamReader.ELEMENT_TEXT,
                            org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                            localUnsignedByte)
                        },
                                                                                            null);
            }


        }

        /**
         *  Factory class that keeps the parse method
         */
        public static class Factory {

            /**
             * static method to create the object
             * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
             *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
             * Postcondition: If this object is an element, the reader is positioned at its end element
             *                If this object is a complex type, the reader is positioned at the end element of its outer element
             */
            public static UnsignedByte parse(javax.xml.stream.XMLStreamReader reader) throws
                    java.lang.Exception {
                UnsignedByte object =
                             new UnsignedByte();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while (!reader.isStartElement() && !reader.isEndElement()) {
                        reader.next();
                    }


                    nillableValue = reader.getAttributeValue(
                            "http://www.w3.org/2001/XMLSchema-instance", "nil");
                    if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                        // Skip the element and report the null value.  It cannot have subelements.
                        while (!reader.isEndElement()) {
                            reader.next();
                        }

                        return object;


                    }



                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();



                    while (!reader.isEndElement()) {
                        if (reader.isStartElement()) {

                            if (reader.isStartElement() && new javax.xml.namespace.QName(
                                    "http://schemas.microsoft.com/2003/10/Serialization/",
                                                                                         "unsignedByte").
                                    equals(reader.getName())) {

                                nillableValue = reader.getAttributeValue(
                                        "http://www.w3.org/2001/XMLSchema-instance", "nil");
                                if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

                                    java.lang.String content = reader.getElementText();

                                    object.setUnsignedByte(
                                            org.apache.axis2.databinding.utils.ConverterUtil.
                                            convertToUnsignedByte(content));

                                } else {


                                    reader.getElementText(); // throw away text nodes if any.
                                }

                            } // End of if for expected property start element
                            else {
                                // A start element we are not expecting indicates an invalid parameter was passed
                                throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.
                                        getLocalName());
                            }

                        } else {
                            reader.next();
                        }
                    }  // end of while loop




                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }
        }//end of factory class

    }

    public static class AnyURI
            implements org.apache.axis2.databinding.ADBBean {

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "http://schemas.microsoft.com/2003/10/Serialization/",
                "anyURI",
                "ns3");

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if (namespace.equals("http://schemas.microsoft.com/2003/10/Serialization/")) {
                return "ns3";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }
        /**
         * field for AnyURI
         */
        protected org.apache.axis2.databinding.types.URI localAnyURI;

        /**
         * Auto generated getter method
         * @return org.apache.axis2.databinding.types.URI
         */
        public org.apache.axis2.databinding.types.URI getAnyURI() {
            return localAnyURI;
        }

        /**
         * Auto generated setter method
         * @param param AnyURI
         */
        public void setAnyURI(org.apache.axis2.databinding.types.URI param) {

            this.localAnyURI = param;


        }

        /**
         * isReaderMTOMAware
         * @return true if the reader supports MTOM
         */
        public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
            boolean isReaderMTOMAware = false;

            try {
                isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(
                        org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
            } catch (java.lang.IllegalArgumentException e) {
                isReaderMTOMAware = false;
            }
            return isReaderMTOMAware;
        }

        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory) throws
                org.apache.axis2.databinding.ADBException {



            org.apache.axiom.om.OMDataSource dataSource =
                                             new org.apache.axis2.databinding.ADBDataSource(this,
                                                                                            MY_QNAME) {

                public void serialize(
                        org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                        throws javax.xml.stream.XMLStreamException {
                    AnyURI.this.serialize(MY_QNAME, factory, xmlWriter);
                }
            };
            return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
                    MY_QNAME, factory, dataSource);

        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              final org.apache.axiom.om.OMFactory factory,
                              org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException,
                       org.apache.axis2.databinding.ADBException {
            serialize(parentQName, factory, xmlWriter, false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              final org.apache.axiom.om.OMFactory factory,
                              org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                              boolean serializeType)
                throws javax.xml.stream.XMLStreamException,
                       org.apache.axis2.databinding.ADBException {


            //We can safely assume an element has only one type associated with it

            java.lang.String namespace = "http://schemas.microsoft.com/2003/10/Serialization/";
            java.lang.String localName = "anyURI";

            if (!namespace.equals("")) {
                java.lang.String prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    xmlWriter.writeStartElement(prefix, localName, namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);

                } else {
                    xmlWriter.writeStartElement(namespace, localName);
                }

            } else {
                xmlWriter.writeStartElement(localName);
            }

            // add the type details if this is used in a simple type
            if (serializeType) {
                java.lang.String namespacePrefix = registerPrefix(xmlWriter,
                                                                  "http://schemas.microsoft.com/2003/10/Serialization/");
                if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                                   namespacePrefix + ":anyURI",
                                   xmlWriter);
                } else {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                                   "anyURI",
                                   xmlWriter);
                }
            }

            if (localAnyURI == null) {

                // write the nil attribute
                writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                               xmlWriter);

            } else {

                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.
                        convertToString(localAnyURI));

            }

            xmlWriter.writeEndElement();



        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(java.lang.String prefix, java.lang.String namespace,
                                    java.lang.String attName,
                                    java.lang.String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);

            }

            xmlWriter.writeAttribute(namespace, attName, attValue);

        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace, java.lang.String attName,
                                    java.lang.String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                         javax.xml.namespace.QName qname,
                                         javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         *  method to handle Qnames
         */
        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.
                            convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.
                            convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.
                        convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.
                                    convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.
                                    convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.
                                convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }

        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter,
                                                java.lang.String namespace) throws
                javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);

            if (prefix == null) {
                prefix = generatePrefix(namespace);

                while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }

                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         *
         */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                throws org.apache.axis2.databinding.ADBException {




            //We can safely assume an element has only one type associated with it

            if (localAnyURI == null) {
                return new org.apache.axis2.databinding.utils.reader.NullXMLStreamReader(MY_QNAME);
            } else {
                return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(MY_QNAME,
                                                                                            new java.lang.Object[]{
                            org.apache.axis2.databinding.utils.reader.ADBXMLStreamReader.ELEMENT_TEXT,
                            org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                            localAnyURI)
                        },
                                                                                            null);
            }


        }

        /**
         *  Factory class that keeps the parse method
         */
        public static class Factory {

            /**
             * static method to create the object
             * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
             *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
             * Postcondition: If this object is an element, the reader is positioned at its end element
             *                If this object is a complex type, the reader is positioned at the end element of its outer element
             */
            public static AnyURI parse(javax.xml.stream.XMLStreamReader reader) throws
                    java.lang.Exception {
                AnyURI object =
                       new AnyURI();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while (!reader.isStartElement() && !reader.isEndElement()) {
                        reader.next();
                    }


                    nillableValue = reader.getAttributeValue(
                            "http://www.w3.org/2001/XMLSchema-instance", "nil");
                    if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                        // Skip the element and report the null value.  It cannot have subelements.
                        while (!reader.isEndElement()) {
                            reader.next();
                        }

                        return object;


                    }



                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();



                    while (!reader.isEndElement()) {
                        if (reader.isStartElement()) {

                            if (reader.isStartElement() && new javax.xml.namespace.QName(
                                    "http://schemas.microsoft.com/2003/10/Serialization/", "anyURI").
                                    equals(reader.getName())) {

                                nillableValue = reader.getAttributeValue(
                                        "http://www.w3.org/2001/XMLSchema-instance", "nil");
                                if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

                                    java.lang.String content = reader.getElementText();

                                    object.setAnyURI(
                                            org.apache.axis2.databinding.utils.ConverterUtil.
                                            convertToAnyURI(content));

                                } else {


                                    reader.getElementText(); // throw away text nodes if any.
                                }

                            } // End of if for expected property start element
                            else {
                                // A start element we are not expecting indicates an invalid parameter was passed
                                throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.
                                        getLocalName());
                            }

                        } else {
                            reader.next();
                        }
                    }  // end of while loop




                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }
        }//end of factory class

    }

    public static class Base64Binary
            implements org.apache.axis2.databinding.ADBBean {

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "http://schemas.microsoft.com/2003/10/Serialization/",
                "base64Binary",
                "ns3");

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if (namespace.equals("http://schemas.microsoft.com/2003/10/Serialization/")) {
                return "ns3";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }
        /**
         * field for Base64Binary
         */
        protected javax.activation.DataHandler localBase64Binary;

        /**
         * Auto generated getter method
         * @return javax.activation.DataHandler
         */
        public javax.activation.DataHandler getBase64Binary() {
            return localBase64Binary;
        }

        /**
         * Auto generated setter method
         * @param param Base64Binary
         */
        public void setBase64Binary(javax.activation.DataHandler param) {

            this.localBase64Binary = param;


        }

        /**
         * isReaderMTOMAware
         * @return true if the reader supports MTOM
         */
        public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
            boolean isReaderMTOMAware = false;

            try {
                isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(
                        org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
            } catch (java.lang.IllegalArgumentException e) {
                isReaderMTOMAware = false;
            }
            return isReaderMTOMAware;
        }

        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory) throws
                org.apache.axis2.databinding.ADBException {



            org.apache.axiom.om.OMDataSource dataSource =
                                             new org.apache.axis2.databinding.ADBDataSource(this,
                                                                                            MY_QNAME) {

                public void serialize(
                        org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                        throws javax.xml.stream.XMLStreamException {
                    Base64Binary.this.serialize(MY_QNAME, factory, xmlWriter);
                }
            };
            return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
                    MY_QNAME, factory, dataSource);

        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              final org.apache.axiom.om.OMFactory factory,
                              org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException,
                       org.apache.axis2.databinding.ADBException {
            serialize(parentQName, factory, xmlWriter, false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              final org.apache.axiom.om.OMFactory factory,
                              org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                              boolean serializeType)
                throws javax.xml.stream.XMLStreamException,
                       org.apache.axis2.databinding.ADBException {


            //We can safely assume an element has only one type associated with it

            java.lang.String namespace = "http://schemas.microsoft.com/2003/10/Serialization/";
            java.lang.String localName = "base64Binary";

            if (!namespace.equals("")) {
                java.lang.String prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    xmlWriter.writeStartElement(prefix, localName, namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);

                } else {
                    xmlWriter.writeStartElement(namespace, localName);
                }

            } else {
                xmlWriter.writeStartElement(localName);
            }

            // add the type details if this is used in a simple type
            if (serializeType) {
                java.lang.String namespacePrefix = registerPrefix(xmlWriter,
                                                                  "http://schemas.microsoft.com/2003/10/Serialization/");
                if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                                   namespacePrefix + ":base64Binary",
                                   xmlWriter);
                } else {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                                   "base64Binary",
                                   xmlWriter);
                }
            }

            if (localBase64Binary == null) {

                // write the nil attribute
                writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                               xmlWriter);

            } else {


                if (localBase64Binary != null) {
                    xmlWriter.writeDataHandler(localBase64Binary);
                }

            }

            xmlWriter.writeEndElement();



        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(java.lang.String prefix, java.lang.String namespace,
                                    java.lang.String attName,
                                    java.lang.String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);

            }

            xmlWriter.writeAttribute(namespace, attName, attValue);

        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace, java.lang.String attName,
                                    java.lang.String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                         javax.xml.namespace.QName qname,
                                         javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         *  method to handle Qnames
         */
        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.
                            convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.
                            convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.
                        convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.
                                    convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.
                                    convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.
                                convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }

        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter,
                                                java.lang.String namespace) throws
                javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);

            if (prefix == null) {
                prefix = generatePrefix(namespace);

                while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }

                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         *
         */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                throws org.apache.axis2.databinding.ADBException {




            //We can safely assume an element has only one type associated with it

            if (localBase64Binary == null) {
                return new org.apache.axis2.databinding.utils.reader.NullXMLStreamReader(MY_QNAME);
            } else {
                return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(MY_QNAME,
                                                                                            new java.lang.Object[]{
                            org.apache.axis2.databinding.utils.reader.ADBXMLStreamReader.ELEMENT_TEXT,
                            org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                            localBase64Binary)
                        },
                                                                                            null);
            }


        }

        /**
         *  Factory class that keeps the parse method
         */
        public static class Factory {

            /**
             * static method to create the object
             * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
             *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
             * Postcondition: If this object is an element, the reader is positioned at its end element
             *                If this object is a complex type, the reader is positioned at the end element of its outer element
             */
            public static Base64Binary parse(javax.xml.stream.XMLStreamReader reader) throws
                    java.lang.Exception {
                Base64Binary object =
                             new Base64Binary();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while (!reader.isStartElement() && !reader.isEndElement()) {
                        reader.next();
                    }


                    nillableValue = reader.getAttributeValue(
                            "http://www.w3.org/2001/XMLSchema-instance", "nil");
                    if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                        // Skip the element and report the null value.  It cannot have subelements.
                        while (!reader.isEndElement()) {
                            reader.next();
                        }

                        return object;


                    }



                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();



                    while (!reader.isEndElement()) {
                        if (reader.isStartElement()) {

                            if (reader.isStartElement() && new javax.xml.namespace.QName(
                                    "http://schemas.microsoft.com/2003/10/Serialization/",
                                                                                         "base64Binary").
                                    equals(reader.getName())) {
                                reader.next();
                                if (isReaderMTOMAware(reader) &&
                                    java.lang.Boolean.TRUE.equals(reader.getProperty(
                                        org.apache.axiom.om.OMConstants.IS_BINARY))) {
                                    //MTOM aware reader - get the datahandler directly and put it in the object
                                    object.setBase64Binary(
                                            (javax.activation.DataHandler) reader.getProperty(
                                            org.apache.axiom.om.OMConstants.DATA_HANDLER));
                                } else {
                                    if (reader.getEventType() == javax.xml.stream.XMLStreamConstants.START_ELEMENT && reader.
                                            getName().equals(
                                            new javax.xml.namespace.QName(
                                            org.apache.axiom.om.impl.MTOMConstants.XOP_NAMESPACE_URI,
                                                                          org.apache.axiom.om.impl.MTOMConstants.XOP_INCLUDE))) {
                                        java.lang.String id = org.apache.axiom.om.util.ElementHelper.
                                                getContentID(reader, "UTF-8");
                                        object.setBase64Binary(((org.apache.axiom.soap.impl.builder.MTOMStAXSOAPModelBuilder) ((org.apache.axiom.om.impl.llom.OMStAXWrapper) reader).
                                                getBuilder()).getDataHandler(id));
                                        reader.next();

                                    } else if (reader.hasText()) {
                                        //Do the usual conversion
                                        java.lang.String content = reader.getText();
                                        object.setBase64Binary(
                                                org.apache.axis2.databinding.utils.ConverterUtil.
                                                convertToBase64Binary(content));

                                    }
                                }


                            } // End of if for expected property start element
                            else {
                                // A start element we are not expecting indicates an invalid parameter was passed
                                throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.
                                        getLocalName());
                            }

                        } else {
                            reader.next();
                        }
                    }  // end of while loop




                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }
        }//end of factory class

    }

    public static class Detect
            implements org.apache.axis2.databinding.ADBBean {

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "http://api.microsofttranslator.com/v1/soap.svc",
                "Detect",
                "ns2");

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if (namespace.equals("http://api.microsofttranslator.com/v1/soap.svc")) {
                return "ns2";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }
        /**
         * field for AppId
         */
        protected java.lang.String localAppId;
        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localAppIdTracker = false;

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getAppId() {
            return localAppId;
        }

        /**
         * Auto generated setter method
         * @param param AppId
         */
        public void setAppId(java.lang.String param) {

            if (param != null) {
                //update the setting tracker
                localAppIdTracker = true;
            } else {
                localAppIdTracker = true;

            }

            this.localAppId = param;


        }
        /**
         * field for Text
         */
        protected java.lang.String localText;
        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localTextTracker = false;

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getText() {
            return localText;
        }

        /**
         * Auto generated setter method
         * @param param Text
         */
        public void setText(java.lang.String param) {

            if (param != null) {
                //update the setting tracker
                localTextTracker = true;
            } else {
                localTextTracker = true;

            }

            this.localText = param;


        }

        /**
         * isReaderMTOMAware
         * @return true if the reader supports MTOM
         */
        public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
            boolean isReaderMTOMAware = false;

            try {
                isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(
                        org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
            } catch (java.lang.IllegalArgumentException e) {
                isReaderMTOMAware = false;
            }
            return isReaderMTOMAware;
        }

        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory) throws
                org.apache.axis2.databinding.ADBException {



            org.apache.axiom.om.OMDataSource dataSource =
                                             new org.apache.axis2.databinding.ADBDataSource(this,
                                                                                            MY_QNAME) {

                public void serialize(
                        org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                        throws javax.xml.stream.XMLStreamException {
                    Detect.this.serialize(MY_QNAME, factory, xmlWriter);
                }
            };
            return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
                    MY_QNAME, factory, dataSource);

        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              final org.apache.axiom.om.OMFactory factory,
                              org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException,
                       org.apache.axis2.databinding.ADBException {
            serialize(parentQName, factory, xmlWriter, false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              final org.apache.axiom.om.OMFactory factory,
                              org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                              boolean serializeType)
                throws javax.xml.stream.XMLStreamException,
                       org.apache.axis2.databinding.ADBException {




            java.lang.String prefix = null;
            java.lang.String namespace = null;


            prefix = parentQName.getPrefix();
            namespace = parentQName.getNamespaceURI();

            if ((namespace != null) && (namespace.trim().length() > 0)) {
                java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
                if (writerPrefix != null) {
                    xmlWriter.writeStartElement(namespace, parentQName.getLocalPart());
                } else {
                    if (prefix == null) {
                        prefix = generatePrefix(namespace);
                    }

                    xmlWriter.writeStartElement(prefix, parentQName.getLocalPart(), namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);
                }
            } else {
                xmlWriter.writeStartElement(parentQName.getLocalPart());
            }

            if (serializeType) {


                java.lang.String namespacePrefix = registerPrefix(xmlWriter,
                                                                  "http://api.microsofttranslator.com/v1/soap.svc");
                if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                                   namespacePrefix + ":Detect",
                                   xmlWriter);
                } else {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                                   "Detect",
                                   xmlWriter);
                }


            }
            if (localAppIdTracker) {
                namespace = "http://api.microsofttranslator.com/v1/soap.svc";
                if (!namespace.equals("")) {
                    prefix = xmlWriter.getPrefix(namespace);

                    if (prefix == null) {
                        prefix = generatePrefix(namespace);

                        xmlWriter.writeStartElement(prefix, "appId", namespace);
                        xmlWriter.writeNamespace(prefix, namespace);
                        xmlWriter.setPrefix(prefix, namespace);

                    } else {
                        xmlWriter.writeStartElement(namespace, "appId");
                    }

                } else {
                    xmlWriter.writeStartElement("appId");
                }


                if (localAppId == null) {
                    // write the nil attribute

                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                                   xmlWriter);

                } else {


                    xmlWriter.writeCharacters(localAppId);

                }

                xmlWriter.writeEndElement();
            }
            if (localTextTracker) {
                namespace = "http://api.microsofttranslator.com/v1/soap.svc";
                if (!namespace.equals("")) {
                    prefix = xmlWriter.getPrefix(namespace);

                    if (prefix == null) {
                        prefix = generatePrefix(namespace);

                        xmlWriter.writeStartElement(prefix, "text", namespace);
                        xmlWriter.writeNamespace(prefix, namespace);
                        xmlWriter.setPrefix(prefix, namespace);

                    } else {
                        xmlWriter.writeStartElement(namespace, "text");
                    }

                } else {
                    xmlWriter.writeStartElement("text");
                }


                if (localText == null) {
                    // write the nil attribute

                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                                   xmlWriter);

                } else {


                    xmlWriter.writeCharacters(localText);

                }

                xmlWriter.writeEndElement();
            }
            xmlWriter.writeEndElement();


        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(java.lang.String prefix, java.lang.String namespace,
                                    java.lang.String attName,
                                    java.lang.String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);

            }

            xmlWriter.writeAttribute(namespace, attName, attValue);

        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace, java.lang.String attName,
                                    java.lang.String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                         javax.xml.namespace.QName qname,
                                         javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         *  method to handle Qnames
         */
        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.
                            convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.
                            convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.
                        convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.
                                    convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.
                                    convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.
                                convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }

        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter,
                                                java.lang.String namespace) throws
                javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);

            if (prefix == null) {
                prefix = generatePrefix(namespace);

                while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }

                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         *
         */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                throws org.apache.axis2.databinding.ADBException {



            java.util.ArrayList elementList = new java.util.ArrayList();
            java.util.ArrayList attribList = new java.util.ArrayList();

            if (localAppIdTracker) {
                elementList.add(new javax.xml.namespace.QName(
                        "http://api.microsofttranslator.com/v1/soap.svc",
                                                              "appId"));

                elementList.add(localAppId == null ? null : org.apache.axis2.databinding.utils.ConverterUtil.
                        convertToString(localAppId));
            }
            if (localTextTracker) {
                elementList.add(new javax.xml.namespace.QName(
                        "http://api.microsofttranslator.com/v1/soap.svc",
                                                              "text"));

                elementList.add(localText == null ? null : org.apache.axis2.databinding.utils.ConverterUtil.
                        convertToString(localText));
            }

            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName,
                                                                                        elementList.
                    toArray(), attribList.toArray());



        }

        /**
         *  Factory class that keeps the parse method
         */
        public static class Factory {

            /**
             * static method to create the object
             * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
             *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
             * Postcondition: If this object is an element, the reader is positioned at its end element
             *                If this object is a complex type, the reader is positioned at the end element of its outer element
             */
            public static Detect parse(javax.xml.stream.XMLStreamReader reader) throws
                    java.lang.Exception {
                Detect object =
                       new Detect();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while (!reader.isStartElement() && !reader.isEndElement()) {
                        reader.next();
                    }


                    if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type") != null) {
                        java.lang.String fullTypeName = reader.getAttributeValue(
                                "http://www.w3.org/2001/XMLSchema-instance",
                                                                                 "type");
                        if (fullTypeName != null) {
                            java.lang.String nsPrefix = null;
                            if (fullTypeName.indexOf(":") > -1) {
                                nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
                            }
                            nsPrefix = nsPrefix == null ? "" : nsPrefix;

                            java.lang.String type = fullTypeName.substring(
                                    fullTypeName.indexOf(":") + 1);

                            if (!"Detect".equals(type)) {
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().
                                        getNamespaceURI(nsPrefix);
                                return (Detect) ExtensionMapper.getTypeObject(
                                        nsUri, type, reader);
                            }


                        }


                    }




                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();




                    reader.next();


                    while (!reader.isStartElement() && !reader.isEndElement()) {
                        reader.next();
                    }

                    if (reader.isStartElement() && new javax.xml.namespace.QName(
                            "http://api.microsofttranslator.com/v1/soap.svc", "appId").equals(reader.
                            getName())) {

                        nillableValue = reader.getAttributeValue(
                                "http://www.w3.org/2001/XMLSchema-instance", "nil");
                        if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

                            java.lang.String content = reader.getElementText();

                            object.setAppId(
                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                    content));

                        } else {


                            reader.getElementText(); // throw away text nodes if any.
                        }

                        reader.next();

                    } // End of if for expected property start element
                    else {
                    }


                    while (!reader.isStartElement() && !reader.isEndElement()) {
                        reader.next();
                    }

                    if (reader.isStartElement() && new javax.xml.namespace.QName(
                            "http://api.microsofttranslator.com/v1/soap.svc", "text").equals(reader.
                            getName())) {

                        nillableValue = reader.getAttributeValue(
                                "http://www.w3.org/2001/XMLSchema-instance", "nil");
                        if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

                            java.lang.String content = reader.getElementText();

                            object.setText(
                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                    content));

                        } else {


                            reader.getElementText(); // throw away text nodes if any.
                        }

                        reader.next();

                    } // End of if for expected property start element
                    else {
                    }

                    while (!reader.isStartElement() && !reader.isEndElement()) {
                        reader.next();
                    }

                    if (reader.isStartElement()) // A start element we are not expecting indicates a trailing invalid property
                    {
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.
                                getLocalName());
                    }




                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }
        }//end of factory class

    }

    public static class _int
            implements org.apache.axis2.databinding.ADBBean {

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "http://schemas.microsoft.com/2003/10/Serialization/",
                "int",
                "ns3");

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if (namespace.equals("http://schemas.microsoft.com/2003/10/Serialization/")) {
                return "ns3";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }
        /**
         * field for _int
         */
        protected int local_int;

        /**
         * Auto generated getter method
         * @return int
         */
        public int get_int() {
            return local_int;
        }

        /**
         * Auto generated setter method
         * @param param _int
         */
        public void set_int(int param) {

            this.local_int = param;


        }

        /**
         * isReaderMTOMAware
         * @return true if the reader supports MTOM
         */
        public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
            boolean isReaderMTOMAware = false;

            try {
                isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(
                        org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
            } catch (java.lang.IllegalArgumentException e) {
                isReaderMTOMAware = false;
            }
            return isReaderMTOMAware;
        }

        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory) throws
                org.apache.axis2.databinding.ADBException {



            org.apache.axiom.om.OMDataSource dataSource =
                                             new org.apache.axis2.databinding.ADBDataSource(this,
                                                                                            MY_QNAME) {

                public void serialize(
                        org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                        throws javax.xml.stream.XMLStreamException {
                    _int.this.serialize(MY_QNAME, factory, xmlWriter);
                }
            };
            return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
                    MY_QNAME, factory, dataSource);

        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              final org.apache.axiom.om.OMFactory factory,
                              org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException,
                       org.apache.axis2.databinding.ADBException {
            serialize(parentQName, factory, xmlWriter, false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              final org.apache.axiom.om.OMFactory factory,
                              org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                              boolean serializeType)
                throws javax.xml.stream.XMLStreamException,
                       org.apache.axis2.databinding.ADBException {


            //We can safely assume an element has only one type associated with it

            java.lang.String namespace = "http://schemas.microsoft.com/2003/10/Serialization/";
            java.lang.String localName = "int";

            if (!namespace.equals("")) {
                java.lang.String prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    xmlWriter.writeStartElement(prefix, localName, namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);

                } else {
                    xmlWriter.writeStartElement(namespace, localName);
                }

            } else {
                xmlWriter.writeStartElement(localName);
            }

            // add the type details if this is used in a simple type
            if (serializeType) {
                java.lang.String namespacePrefix = registerPrefix(xmlWriter,
                                                                  "http://schemas.microsoft.com/2003/10/Serialization/");
                if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                                   namespacePrefix + ":int",
                                   xmlWriter);
                } else {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                                   "int",
                                   xmlWriter);
                }
            }

            if (local_int == java.lang.Integer.MIN_VALUE) {

                writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                               xmlWriter);

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.
                        convertToString(local_int));
            }

            xmlWriter.writeEndElement();



        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(java.lang.String prefix, java.lang.String namespace,
                                    java.lang.String attName,
                                    java.lang.String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);

            }

            xmlWriter.writeAttribute(namespace, attName, attValue);

        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace, java.lang.String attName,
                                    java.lang.String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                         javax.xml.namespace.QName qname,
                                         javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         *  method to handle Qnames
         */
        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.
                            convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.
                            convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.
                        convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.
                                    convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.
                                    convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.
                                convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }

        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter,
                                                java.lang.String namespace) throws
                javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);

            if (prefix == null) {
                prefix = generatePrefix(namespace);

                while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }

                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         *
         */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                throws org.apache.axis2.databinding.ADBException {




            //We can safely assume an element has only one type associated with it
            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(MY_QNAME,
                                                                                        new java.lang.Object[]{
                        org.apache.axis2.databinding.utils.reader.ADBXMLStreamReader.ELEMENT_TEXT,
                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString(local_int)
                    },
                                                                                        null);

        }

        /**
         *  Factory class that keeps the parse method
         */
        public static class Factory {

            /**
             * static method to create the object
             * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
             *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
             * Postcondition: If this object is an element, the reader is positioned at its end element
             *                If this object is a complex type, the reader is positioned at the end element of its outer element
             */
            public static _int parse(javax.xml.stream.XMLStreamReader reader) throws
                    java.lang.Exception {
                _int object =
                     new _int();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while (!reader.isStartElement() && !reader.isEndElement()) {
                        reader.next();
                    }


                    nillableValue = reader.getAttributeValue(
                            "http://www.w3.org/2001/XMLSchema-instance", "nil");
                    if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                        // Skip the element and report the null value.  It cannot have subelements.
                        while (!reader.isEndElement()) {
                            reader.next();
                        }

                        object.set_int(java.lang.Integer.MIN_VALUE);

                        return object;


                    }



                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();



                    while (!reader.isEndElement()) {
                        if (reader.isStartElement()) {

                            if (reader.isStartElement() && new javax.xml.namespace.QName(
                                    "http://schemas.microsoft.com/2003/10/Serialization/", "int").
                                    equals(reader.getName())) {

                                nillableValue = reader.getAttributeValue(
                                        "http://www.w3.org/2001/XMLSchema-instance", "nil");
                                if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

                                    java.lang.String content = reader.getElementText();

                                    object.set_int(
                                            org.apache.axis2.databinding.utils.ConverterUtil.
                                            convertToInt(content));

                                } else {


                                    object.set_int(java.lang.Integer.MIN_VALUE);

                                    reader.getElementText(); // throw away text nodes if any.
                                }

                            } // End of if for expected property start element
                            else {
                                // A start element we are not expecting indicates an invalid parameter was passed
                                throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.
                                        getLocalName());
                            }

                        } else {
                            reader.next();
                        }
                    }  // end of while loop




                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }
        }//end of factory class

    }

    public static class _char
            implements org.apache.axis2.databinding.ADBBean {

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "http://schemas.microsoft.com/2003/10/Serialization/",
                "char",
                "ns3");

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if (namespace.equals("http://schemas.microsoft.com/2003/10/Serialization/")) {
                return "ns3";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }
        /**
         * field for _char
         */
        protected int local_char;

        /**
         * Auto generated getter method
         * @return int
         */
        public int get_char() {
            return local_char;
        }

        /**
         * Auto generated setter method
         * @param param _char
         */
        public void set_char(int param) {

            this.local_char = param;


        }

        public java.lang.String toString() {

            return local_char + "";

        }

        /**
         * isReaderMTOMAware
         * @return true if the reader supports MTOM
         */
        public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
            boolean isReaderMTOMAware = false;

            try {
                isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(
                        org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
            } catch (java.lang.IllegalArgumentException e) {
                isReaderMTOMAware = false;
            }
            return isReaderMTOMAware;
        }

        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory) throws
                org.apache.axis2.databinding.ADBException {



            org.apache.axiom.om.OMDataSource dataSource =
                                             new org.apache.axis2.databinding.ADBDataSource(this,
                                                                                            MY_QNAME) {

                public void serialize(
                        org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                        throws javax.xml.stream.XMLStreamException {
                    _char.this.serialize(MY_QNAME, factory, xmlWriter);
                }
            };
            return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
                    MY_QNAME, factory, dataSource);

        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              final org.apache.axiom.om.OMFactory factory,
                              org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException,
                       org.apache.axis2.databinding.ADBException {
            serialize(parentQName, factory, xmlWriter, false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              final org.apache.axiom.om.OMFactory factory,
                              org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                              boolean serializeType)
                throws javax.xml.stream.XMLStreamException,
                       org.apache.axis2.databinding.ADBException {


            //We can safely assume an element has only one type associated with it

            java.lang.String namespace = parentQName.getNamespaceURI();
            java.lang.String localName = parentQName.getLocalPart();

            if (!namespace.equals("")) {
                java.lang.String prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    xmlWriter.writeStartElement(prefix, localName, namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);

                } else {
                    xmlWriter.writeStartElement(namespace, localName);
                }

            } else {
                xmlWriter.writeStartElement(localName);
            }

            // add the type details if this is used in a simple type
            if (serializeType) {
                java.lang.String namespacePrefix = registerPrefix(xmlWriter,
                                                                  "http://schemas.microsoft.com/2003/10/Serialization/");
                if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                                   namespacePrefix + ":char",
                                   xmlWriter);
                } else {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                                   "char",
                                   xmlWriter);
                }
            }

            if (local_char == java.lang.Integer.MIN_VALUE) {

                throw new org.apache.axis2.databinding.ADBException(
                        "property value cannot be null!!");

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.
                        convertToString(local_char));
            }

            xmlWriter.writeEndElement();



        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(java.lang.String prefix, java.lang.String namespace,
                                    java.lang.String attName,
                                    java.lang.String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);

            }

            xmlWriter.writeAttribute(namespace, attName, attValue);

        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace, java.lang.String attName,
                                    java.lang.String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                         javax.xml.namespace.QName qname,
                                         javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         *  method to handle Qnames
         */
        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.
                            convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.
                            convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.
                        convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.
                                    convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.
                                    convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.
                                convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }

        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter,
                                                java.lang.String namespace) throws
                javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);

            if (prefix == null) {
                prefix = generatePrefix(namespace);

                while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }

                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         *
         */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                throws org.apache.axis2.databinding.ADBException {




            //We can safely assume an element has only one type associated with it
            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(MY_QNAME,
                                                                                        new java.lang.Object[]{
                        org.apache.axis2.databinding.utils.reader.ADBXMLStreamReader.ELEMENT_TEXT,
                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString(local_char)
                    },
                                                                                        null);

        }

        /**
         *  Factory class that keeps the parse method
         */
        public static class Factory {

            public static _char fromString(java.lang.String value,
                                           java.lang.String namespaceURI) {
                _char returnValue = new _char();

                returnValue.set_char(
                        org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(value));


                return returnValue;
            }

            public static _char fromString(javax.xml.stream.XMLStreamReader xmlStreamReader,
                                           java.lang.String content) {
                if (content.indexOf(":") > -1) {
                    java.lang.String prefix = content.substring(0, content.indexOf(":"));
                    java.lang.String namespaceUri = xmlStreamReader.getNamespaceContext().
                            getNamespaceURI(prefix);
                    return _char.Factory.fromString(content, namespaceUri);
                } else {
                    return _char.Factory.fromString(content, "");
                }
            }

            /**
             * static method to create the object
             * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
             *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
             * Postcondition: If this object is an element, the reader is positioned at its end element
             *                If this object is a complex type, the reader is positioned at the end element of its outer element
             */
            public static _char parse(javax.xml.stream.XMLStreamReader reader) throws
                    java.lang.Exception {
                _char object =
                      new _char();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while (!reader.isStartElement() && !reader.isEndElement()) {
                        reader.next();
                    }




                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();



                    while (!reader.isEndElement()) {
                        if (reader.isStartElement() || reader.hasText()) {

                            if (reader.isStartElement() || reader.hasText()) {

                                java.lang.String content = reader.getElementText();

                                object.set_char(
                                        org.apache.axis2.databinding.utils.ConverterUtil.
                                        convertToInt(content));

                            } // End of if for expected property start element
                            else {
                                // A start element we are not expecting indicates an invalid parameter was passed
                                throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.
                                        getLocalName());
                            }

                        } else {
                            reader.next();
                        }
                    }  // end of while loop




                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }
        }//end of factory class

    }

    public static class _double
            implements org.apache.axis2.databinding.ADBBean {

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "http://schemas.microsoft.com/2003/10/Serialization/",
                "double",
                "ns3");

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if (namespace.equals("http://schemas.microsoft.com/2003/10/Serialization/")) {
                return "ns3";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }
        /**
         * field for _double
         */
        protected double local_double;

        /**
         * Auto generated getter method
         * @return double
         */
        public double get_double() {
            return local_double;
        }

        /**
         * Auto generated setter method
         * @param param _double
         */
        public void set_double(double param) {

            this.local_double = param;


        }

        /**
         * isReaderMTOMAware
         * @return true if the reader supports MTOM
         */
        public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
            boolean isReaderMTOMAware = false;

            try {
                isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(
                        org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
            } catch (java.lang.IllegalArgumentException e) {
                isReaderMTOMAware = false;
            }
            return isReaderMTOMAware;
        }

        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory) throws
                org.apache.axis2.databinding.ADBException {



            org.apache.axiom.om.OMDataSource dataSource =
                                             new org.apache.axis2.databinding.ADBDataSource(this,
                                                                                            MY_QNAME) {

                public void serialize(
                        org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                        throws javax.xml.stream.XMLStreamException {
                    _double.this.serialize(MY_QNAME, factory, xmlWriter);
                }
            };
            return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
                    MY_QNAME, factory, dataSource);

        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              final org.apache.axiom.om.OMFactory factory,
                              org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException,
                       org.apache.axis2.databinding.ADBException {
            serialize(parentQName, factory, xmlWriter, false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              final org.apache.axiom.om.OMFactory factory,
                              org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                              boolean serializeType)
                throws javax.xml.stream.XMLStreamException,
                       org.apache.axis2.databinding.ADBException {


            //We can safely assume an element has only one type associated with it

            java.lang.String namespace = "http://schemas.microsoft.com/2003/10/Serialization/";
            java.lang.String localName = "double";

            if (!namespace.equals("")) {
                java.lang.String prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    xmlWriter.writeStartElement(prefix, localName, namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);

                } else {
                    xmlWriter.writeStartElement(namespace, localName);
                }

            } else {
                xmlWriter.writeStartElement(localName);
            }

            // add the type details if this is used in a simple type
            if (serializeType) {
                java.lang.String namespacePrefix = registerPrefix(xmlWriter,
                                                                  "http://schemas.microsoft.com/2003/10/Serialization/");
                if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                                   namespacePrefix + ":double",
                                   xmlWriter);
                } else {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                                   "double",
                                   xmlWriter);
                }
            }

            if (java.lang.Double.isNaN(local_double)) {

                writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                               xmlWriter);

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.
                        convertToString(local_double));
            }

            xmlWriter.writeEndElement();



        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(java.lang.String prefix, java.lang.String namespace,
                                    java.lang.String attName,
                                    java.lang.String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);

            }

            xmlWriter.writeAttribute(namespace, attName, attValue);

        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace, java.lang.String attName,
                                    java.lang.String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                         javax.xml.namespace.QName qname,
                                         javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         *  method to handle Qnames
         */
        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.
                            convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.
                            convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.
                        convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.
                                    convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.
                                    convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.
                                convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }

        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter,
                                                java.lang.String namespace) throws
                javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);

            if (prefix == null) {
                prefix = generatePrefix(namespace);

                while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }

                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         *
         */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                throws org.apache.axis2.databinding.ADBException {




            //We can safely assume an element has only one type associated with it
            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(MY_QNAME,
                                                                                        new java.lang.Object[]{
                        org.apache.axis2.databinding.utils.reader.ADBXMLStreamReader.ELEMENT_TEXT,
                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                        local_double)
                    },
                                                                                        null);

        }

        /**
         *  Factory class that keeps the parse method
         */
        public static class Factory {

            /**
             * static method to create the object
             * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
             *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
             * Postcondition: If this object is an element, the reader is positioned at its end element
             *                If this object is a complex type, the reader is positioned at the end element of its outer element
             */
            public static _double parse(javax.xml.stream.XMLStreamReader reader) throws
                    java.lang.Exception {
                _double object =
                        new _double();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while (!reader.isStartElement() && !reader.isEndElement()) {
                        reader.next();
                    }


                    nillableValue = reader.getAttributeValue(
                            "http://www.w3.org/2001/XMLSchema-instance", "nil");
                    if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                        // Skip the element and report the null value.  It cannot have subelements.
                        while (!reader.isEndElement()) {
                            reader.next();
                        }

                        object.set_double(java.lang.Double.NaN);

                        return object;


                    }



                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();



                    while (!reader.isEndElement()) {
                        if (reader.isStartElement()) {

                            if (reader.isStartElement() && new javax.xml.namespace.QName(
                                    "http://schemas.microsoft.com/2003/10/Serialization/", "double").
                                    equals(reader.getName())) {

                                nillableValue = reader.getAttributeValue(
                                        "http://www.w3.org/2001/XMLSchema-instance", "nil");
                                if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

                                    java.lang.String content = reader.getElementText();

                                    object.set_double(
                                            org.apache.axis2.databinding.utils.ConverterUtil.
                                            convertToDouble(content));

                                } else {


                                    object.set_double(java.lang.Double.NaN);

                                    reader.getElementText(); // throw away text nodes if any.
                                }

                            } // End of if for expected property start element
                            else {
                                // A start element we are not expecting indicates an invalid parameter was passed
                                throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.
                                        getLocalName());
                            }

                        } else {
                            reader.next();
                        }
                    }  // end of while loop




                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }
        }//end of factory class

    }

    public static class ArrayOfstring
            implements org.apache.axis2.databinding.ADBBean {
        /* This type was generated from the piece of schema that had
        name = ArrayOfstring
        Namespace URI = http://schemas.microsoft.com/2003/10/Serialization/Arrays
        Namespace Prefix = ns1
         */

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if (namespace.equals("http://schemas.microsoft.com/2003/10/Serialization/Arrays")) {
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }
        /**
         * field for String
         * This was an Array!
         */
        protected java.lang.String[] localString;
        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localStringTracker = false;

        /**
         * Auto generated getter method
         * @return java.lang.String[]
         */
        public java.lang.String[] getString() {
            return localString;
        }

        /**
         * validate the array for String
         */
        protected void validateString(java.lang.String[] param) {
        }

        /**
         * Auto generated setter method
         * @param param String
         */
        public void setString(java.lang.String[] param) {

            validateString(param);


            if (param != null) {
                //update the setting tracker
                localStringTracker = true;
            } else {
                localStringTracker = true;

            }

            this.localString = param;
        }

        /**
         * Auto generated add method for the array for convenience
         * @param param java.lang.String
         */
        public void addString(java.lang.String param) {
            if (localString == null) {
                localString = new java.lang.String[]{};
            }


            //update the setting tracker
            localStringTracker = true;


            java.util.List list =
                           org.apache.axis2.databinding.utils.ConverterUtil.toList(localString);
            list.add(param);
            this.localString =
            (java.lang.String[]) list.toArray(
                    new java.lang.String[list.size()]);

        }

        /**
         * isReaderMTOMAware
         * @return true if the reader supports MTOM
         */
        public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
            boolean isReaderMTOMAware = false;

            try {
                isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(
                        org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
            } catch (java.lang.IllegalArgumentException e) {
                isReaderMTOMAware = false;
            }
            return isReaderMTOMAware;
        }

        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory) throws
                org.apache.axis2.databinding.ADBException {



            org.apache.axiom.om.OMDataSource dataSource =
                                             new org.apache.axis2.databinding.ADBDataSource(this,
                                                                                            parentQName) {

                public void serialize(
                        org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                        throws javax.xml.stream.XMLStreamException {
                    ArrayOfstring.this.serialize(parentQName, factory, xmlWriter);
                }
            };
            return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
                    parentQName, factory, dataSource);

        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              final org.apache.axiom.om.OMFactory factory,
                              org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException,
                       org.apache.axis2.databinding.ADBException {
            serialize(parentQName, factory, xmlWriter, false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              final org.apache.axiom.om.OMFactory factory,
                              org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                              boolean serializeType)
                throws javax.xml.stream.XMLStreamException,
                       org.apache.axis2.databinding.ADBException {




            java.lang.String prefix = null;
            java.lang.String namespace = null;


            prefix = parentQName.getPrefix();
            namespace = parentQName.getNamespaceURI();

            if ((namespace != null) && (namespace.trim().length() > 0)) {
                java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
                if (writerPrefix != null) {
                    xmlWriter.writeStartElement(namespace, parentQName.getLocalPart());
                } else {
                    if (prefix == null) {
                        prefix = generatePrefix(namespace);
                    }

                    xmlWriter.writeStartElement(prefix, parentQName.getLocalPart(), namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);
                }
            } else {
                xmlWriter.writeStartElement(parentQName.getLocalPart());
            }

            if (serializeType) {


                java.lang.String namespacePrefix = registerPrefix(xmlWriter,
                                                                  "http://schemas.microsoft.com/2003/10/Serialization/Arrays");
                if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                                   namespacePrefix + ":ArrayOfstring",
                                   xmlWriter);
                } else {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                                   "ArrayOfstring",
                                   xmlWriter);
                }


            }
            if (localStringTracker) {
                if (localString != null) {
                    namespace = "http://schemas.microsoft.com/2003/10/Serialization/Arrays";
                    boolean emptyNamespace = namespace == null || namespace.length() == 0;
                    prefix = emptyNamespace ? null : xmlWriter.getPrefix(namespace);
                    for (int i = 0; i < localString.length; i++) {

                        if (localString[i] != null) {

                            if (!emptyNamespace) {
                                if (prefix == null) {
                                    java.lang.String prefix2 = generatePrefix(namespace);

                                    xmlWriter.writeStartElement(prefix2, "string", namespace);
                                    xmlWriter.writeNamespace(prefix2, namespace);
                                    xmlWriter.setPrefix(prefix2, namespace);

                                } else {
                                    xmlWriter.writeStartElement(namespace, "string");
                                }

                            } else {
                                xmlWriter.writeStartElement("string");
                            }


                            xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.
                                    convertToString(localString[i]));

                            xmlWriter.writeEndElement();

                        } else {

                            // write null attribute
                            namespace = "http://schemas.microsoft.com/2003/10/Serialization/Arrays";
                            if (!namespace.equals("")) {
                                prefix = xmlWriter.getPrefix(namespace);

                                if (prefix == null) {
                                    prefix = generatePrefix(namespace);

                                    xmlWriter.writeStartElement(prefix, "string", namespace);
                                    xmlWriter.writeNamespace(prefix, namespace);
                                    xmlWriter.setPrefix(prefix, namespace);

                                } else {
                                    xmlWriter.writeStartElement(namespace, "string");
                                }

                            } else {
                                xmlWriter.writeStartElement("string");
                            }
                            writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil",
                                           "1", xmlWriter);
                            xmlWriter.writeEndElement();

                        }

                    }
                } else {

                    // write the null attribute
                    // write null attribute
                    java.lang.String namespace2 = "http://schemas.microsoft.com/2003/10/Serialization/Arrays";
                    if (!namespace2.equals("")) {
                        java.lang.String prefix2 = xmlWriter.getPrefix(namespace2);

                        if (prefix2 == null) {
                            prefix2 = generatePrefix(namespace2);

                            xmlWriter.writeStartElement(prefix2, "string", namespace2);
                            xmlWriter.writeNamespace(prefix2, namespace2);
                            xmlWriter.setPrefix(prefix2, namespace2);

                        } else {
                            xmlWriter.writeStartElement(namespace2, "string");
                        }

                    } else {
                        xmlWriter.writeStartElement("string");
                    }

                    // write the nil attribute
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                                   xmlWriter);
                    xmlWriter.writeEndElement();

                }

            }
            xmlWriter.writeEndElement();


        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(java.lang.String prefix, java.lang.String namespace,
                                    java.lang.String attName,
                                    java.lang.String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);

            }

            xmlWriter.writeAttribute(namespace, attName, attValue);

        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace, java.lang.String attName,
                                    java.lang.String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                         javax.xml.namespace.QName qname,
                                         javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         *  method to handle Qnames
         */
        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.
                            convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.
                            convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.
                        convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.
                                    convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.
                                    convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.
                                convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }

        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter,
                                                java.lang.String namespace) throws
                javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);

            if (prefix == null) {
                prefix = generatePrefix(namespace);

                while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }

                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         *
         */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                throws org.apache.axis2.databinding.ADBException {



            java.util.ArrayList elementList = new java.util.ArrayList();
            java.util.ArrayList attribList = new java.util.ArrayList();

            if (localStringTracker) {
                if (localString != null) {
                    for (int i = 0; i < localString.length; i++) {

                        if (localString[i] != null) {
                            elementList.add(new javax.xml.namespace.QName(
                                    "http://schemas.microsoft.com/2003/10/Serialization/Arrays",
                                                                          "string"));
                            elementList.add(
                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                    localString[i]));
                        } else {

                            elementList.add(new javax.xml.namespace.QName(
                                    "http://schemas.microsoft.com/2003/10/Serialization/Arrays",
                                                                          "string"));
                            elementList.add(null);

                        }


                    }
                } else {

                    elementList.add(new javax.xml.namespace.QName(
                            "http://schemas.microsoft.com/2003/10/Serialization/Arrays",
                                                                  "string"));
                    elementList.add(null);

                }

            }

            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName,
                                                                                        elementList.
                    toArray(), attribList.toArray());



        }

        /**
         *  Factory class that keeps the parse method
         */
        public static class Factory {

            /**
             * static method to create the object
             * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
             *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
             * Postcondition: If this object is an element, the reader is positioned at its end element
             *                If this object is a complex type, the reader is positioned at the end element of its outer element
             */
            public static ArrayOfstring parse(javax.xml.stream.XMLStreamReader reader) throws
                    java.lang.Exception {
                ArrayOfstring object =
                              new ArrayOfstring();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while (!reader.isStartElement() && !reader.isEndElement()) {
                        reader.next();
                    }


                    if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type") != null) {
                        java.lang.String fullTypeName = reader.getAttributeValue(
                                "http://www.w3.org/2001/XMLSchema-instance",
                                                                                 "type");
                        if (fullTypeName != null) {
                            java.lang.String nsPrefix = null;
                            if (fullTypeName.indexOf(":") > -1) {
                                nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
                            }
                            nsPrefix = nsPrefix == null ? "" : nsPrefix;

                            java.lang.String type = fullTypeName.substring(
                                    fullTypeName.indexOf(":") + 1);

                            if (!"ArrayOfstring".equals(type)) {
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().
                                        getNamespaceURI(nsPrefix);
                                return (ArrayOfstring) ExtensionMapper.getTypeObject(
                                        nsUri, type, reader);
                            }


                        }


                    }




                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();




                    reader.next();

                    java.util.ArrayList list1 = new java.util.ArrayList();


                    while (!reader.isStartElement() && !reader.isEndElement()) {
                        reader.next();
                    }

                    if (reader.isStartElement() && new javax.xml.namespace.QName(
                            "http://schemas.microsoft.com/2003/10/Serialization/Arrays", "string").
                            equals(reader.getName())) {



                        // Process the array and step past its final element's end.

                        nillableValue = reader.getAttributeValue(
                                "http://www.w3.org/2001/XMLSchema-instance", "nil");
                        if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                            list1.add(null);

                            reader.next();
                        } else {
                            list1.add(reader.getElementText());
                        }
                        //loop until we find a start element that is not part of this array
                        boolean loopDone1 = false;
                        while (!loopDone1) {
                            // Ensure we are at the EndElement
                            while (!reader.isEndElement()) {
                                reader.next();
                            }
                            // Step out of this element
                            reader.next();
                            // Step to next element event.
                            while (!reader.isStartElement() && !reader.isEndElement()) {
                                reader.next();
                            }
                            if (reader.isEndElement()) {
                                //two continuous end elements means we are exiting the xml structure
                                loopDone1 = true;
                            } else {
                                if (new javax.xml.namespace.QName(
                                        "http://schemas.microsoft.com/2003/10/Serialization/Arrays",
                                                                  "string").equals(reader.getName())) {

                                    nillableValue = reader.getAttributeValue(
                                            "http://www.w3.org/2001/XMLSchema-instance", "nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                                        list1.add(null);

                                        reader.next();
                                    } else {
                                        list1.add(reader.getElementText());
                                    }
                                } else {
                                    loopDone1 = true;
                                }
                            }
                        }
                        // call the converter utility  to convert and set the array

                        object.setString((java.lang.String[]) list1.toArray(new java.lang.String[list1.
                                size()]));

                    } // End of if for expected property start element
                    else {
                    }

                    while (!reader.isStartElement() && !reader.isEndElement()) {
                        reader.next();
                    }

                    if (reader.isStartElement()) // A start element we are not expecting indicates a trailing invalid property
                    {
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.
                                getLocalName());
                    }




                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }
        }//end of factory class

    }

    public static class DurationE
            implements org.apache.axis2.databinding.ADBBean {

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "http://schemas.microsoft.com/2003/10/Serialization/",
                "duration",
                "ns3");

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if (namespace.equals("http://schemas.microsoft.com/2003/10/Serialization/")) {
                return "ns3";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }
        /**
         * field for Duration
         */
        protected Duration localDuration;

        /**
         * Auto generated getter method
         * @return Duration
         */
        public Duration getDuration() {
            return localDuration;
        }

        /**
         * Auto generated setter method
         * @param param Duration
         */
        public void setDuration(Duration param) {

            this.localDuration = param;


        }

        /**
         * isReaderMTOMAware
         * @return true if the reader supports MTOM
         */
        public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
            boolean isReaderMTOMAware = false;

            try {
                isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(
                        org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
            } catch (java.lang.IllegalArgumentException e) {
                isReaderMTOMAware = false;
            }
            return isReaderMTOMAware;
        }

        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory) throws
                org.apache.axis2.databinding.ADBException {



            org.apache.axiom.om.OMDataSource dataSource =
                                             new org.apache.axis2.databinding.ADBDataSource(this,
                                                                                            MY_QNAME) {

                public void serialize(
                        org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                        throws javax.xml.stream.XMLStreamException {
                    DurationE.this.serialize(MY_QNAME, factory, xmlWriter);
                }
            };
            return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
                    MY_QNAME, factory, dataSource);

        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              final org.apache.axiom.om.OMFactory factory,
                              org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException,
                       org.apache.axis2.databinding.ADBException {
            serialize(parentQName, factory, xmlWriter, false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              final org.apache.axiom.om.OMFactory factory,
                              org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                              boolean serializeType)
                throws javax.xml.stream.XMLStreamException,
                       org.apache.axis2.databinding.ADBException {


            //We can safely assume an element has only one type associated with it

            if (localDuration == null) {
                java.lang.String namespace = "http://schemas.microsoft.com/2003/10/Serialization/";

                if (!namespace.equals("")) {
                    java.lang.String prefix = xmlWriter.getPrefix(namespace);

                    if (prefix == null) {
                        prefix = generatePrefix(namespace);

                        xmlWriter.writeStartElement(prefix, "duration", namespace);
                        xmlWriter.writeNamespace(prefix, namespace);
                        xmlWriter.setPrefix(prefix, namespace);

                    } else {
                        xmlWriter.writeStartElement(namespace, "duration");
                    }

                } else {
                    xmlWriter.writeStartElement("duration");
                }

                // write the nil attribute
                writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                               xmlWriter);
                xmlWriter.writeEndElement();
            } else {
                localDuration.serialize(MY_QNAME, factory, xmlWriter);
            }


        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(java.lang.String prefix, java.lang.String namespace,
                                    java.lang.String attName,
                                    java.lang.String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);

            }

            xmlWriter.writeAttribute(namespace, attName, attValue);

        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace, java.lang.String attName,
                                    java.lang.String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                         javax.xml.namespace.QName qname,
                                         javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         *  method to handle Qnames
         */
        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.
                            convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.
                            convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.
                        convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.
                                    convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.
                                    convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.
                                convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }

        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter,
                                                java.lang.String namespace) throws
                javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);

            if (prefix == null) {
                prefix = generatePrefix(namespace);

                while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }

                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         *
         */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                throws org.apache.axis2.databinding.ADBException {




            //We can safely assume an element has only one type associated with it

            if (localDuration == null) {
                return new org.apache.axis2.databinding.utils.reader.NullXMLStreamReader(MY_QNAME);
            } else {
                return localDuration.getPullParser(MY_QNAME);
            }


        }

        /**
         *  Factory class that keeps the parse method
         */
        public static class Factory {

            /**
             * static method to create the object
             * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
             *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
             * Postcondition: If this object is an element, the reader is positioned at its end element
             *                If this object is a complex type, the reader is positioned at the end element of its outer element
             */
            public static DurationE parse(javax.xml.stream.XMLStreamReader reader) throws
                    java.lang.Exception {
                DurationE object =
                          new DurationE();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while (!reader.isStartElement() && !reader.isEndElement()) {
                        reader.next();
                    }


                    nillableValue = reader.getAttributeValue(
                            "http://www.w3.org/2001/XMLSchema-instance", "nil");
                    if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                        // Skip the element and report the null value.  It cannot have subelements.
                        while (!reader.isEndElement()) {
                            reader.next();
                        }

                        return object;


                    }



                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();



                    while (!reader.isEndElement()) {
                        if (reader.isStartElement()) {

                            if (reader.isStartElement() && new javax.xml.namespace.QName(
                                    "http://schemas.microsoft.com/2003/10/Serialization/",
                                                                                         "duration").
                                    equals(reader.getName())) {

                                nillableValue = reader.getAttributeValue(
                                        "http://www.w3.org/2001/XMLSchema-instance", "nil");
                                if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                                    object.setDuration(null);
                                    reader.next();

                                } else {

                                    object.setDuration(Duration.Factory.parse(reader));
                                }
                            } // End of if for expected property start element
                            else {
                                // A start element we are not expecting indicates an invalid parameter was passed
                                throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.
                                        getLocalName());
                            }

                        } else {
                            reader.next();
                        }
                    }  // end of while loop




                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }
        }//end of factory class

    }

    public static class GuidE
            implements org.apache.axis2.databinding.ADBBean {

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "http://schemas.microsoft.com/2003/10/Serialization/",
                "guid",
                "ns3");

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if (namespace.equals("http://schemas.microsoft.com/2003/10/Serialization/")) {
                return "ns3";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }
        /**
         * field for Guid
         */
        protected Guid localGuid;

        /**
         * Auto generated getter method
         * @return Guid
         */
        public Guid getGuid() {
            return localGuid;
        }

        /**
         * Auto generated setter method
         * @param param Guid
         */
        public void setGuid(Guid param) {

            this.localGuid = param;


        }

        /**
         * isReaderMTOMAware
         * @return true if the reader supports MTOM
         */
        public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
            boolean isReaderMTOMAware = false;

            try {
                isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(
                        org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
            } catch (java.lang.IllegalArgumentException e) {
                isReaderMTOMAware = false;
            }
            return isReaderMTOMAware;
        }

        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory) throws
                org.apache.axis2.databinding.ADBException {



            org.apache.axiom.om.OMDataSource dataSource =
                                             new org.apache.axis2.databinding.ADBDataSource(this,
                                                                                            MY_QNAME) {

                public void serialize(
                        org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                        throws javax.xml.stream.XMLStreamException {
                    GuidE.this.serialize(MY_QNAME, factory, xmlWriter);
                }
            };
            return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
                    MY_QNAME, factory, dataSource);

        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              final org.apache.axiom.om.OMFactory factory,
                              org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException,
                       org.apache.axis2.databinding.ADBException {
            serialize(parentQName, factory, xmlWriter, false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              final org.apache.axiom.om.OMFactory factory,
                              org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                              boolean serializeType)
                throws javax.xml.stream.XMLStreamException,
                       org.apache.axis2.databinding.ADBException {


            //We can safely assume an element has only one type associated with it

            if (localGuid == null) {
                java.lang.String namespace = "http://schemas.microsoft.com/2003/10/Serialization/";

                if (!namespace.equals("")) {
                    java.lang.String prefix = xmlWriter.getPrefix(namespace);

                    if (prefix == null) {
                        prefix = generatePrefix(namespace);

                        xmlWriter.writeStartElement(prefix, "guid", namespace);
                        xmlWriter.writeNamespace(prefix, namespace);
                        xmlWriter.setPrefix(prefix, namespace);

                    } else {
                        xmlWriter.writeStartElement(namespace, "guid");
                    }

                } else {
                    xmlWriter.writeStartElement("guid");
                }

                // write the nil attribute
                writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                               xmlWriter);
                xmlWriter.writeEndElement();
            } else {
                localGuid.serialize(MY_QNAME, factory, xmlWriter);
            }


        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(java.lang.String prefix, java.lang.String namespace,
                                    java.lang.String attName,
                                    java.lang.String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);

            }

            xmlWriter.writeAttribute(namespace, attName, attValue);

        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace, java.lang.String attName,
                                    java.lang.String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                         javax.xml.namespace.QName qname,
                                         javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         *  method to handle Qnames
         */
        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.
                            convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.
                            convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.
                        convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.
                                    convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.
                                    convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.
                                convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }

        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter,
                                                java.lang.String namespace) throws
                javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);

            if (prefix == null) {
                prefix = generatePrefix(namespace);

                while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }

                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         *
         */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                throws org.apache.axis2.databinding.ADBException {




            //We can safely assume an element has only one type associated with it

            if (localGuid == null) {
                return new org.apache.axis2.databinding.utils.reader.NullXMLStreamReader(MY_QNAME);
            } else {
                return localGuid.getPullParser(MY_QNAME);
            }


        }

        /**
         *  Factory class that keeps the parse method
         */
        public static class Factory {

            /**
             * static method to create the object
             * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
             *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
             * Postcondition: If this object is an element, the reader is positioned at its end element
             *                If this object is a complex type, the reader is positioned at the end element of its outer element
             */
            public static GuidE parse(javax.xml.stream.XMLStreamReader reader) throws
                    java.lang.Exception {
                GuidE object =
                      new GuidE();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while (!reader.isStartElement() && !reader.isEndElement()) {
                        reader.next();
                    }


                    nillableValue = reader.getAttributeValue(
                            "http://www.w3.org/2001/XMLSchema-instance", "nil");
                    if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                        // Skip the element and report the null value.  It cannot have subelements.
                        while (!reader.isEndElement()) {
                            reader.next();
                        }

                        return object;


                    }



                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();



                    while (!reader.isEndElement()) {
                        if (reader.isStartElement()) {

                            if (reader.isStartElement() && new javax.xml.namespace.QName(
                                    "http://schemas.microsoft.com/2003/10/Serialization/", "guid").
                                    equals(reader.getName())) {

                                nillableValue = reader.getAttributeValue(
                                        "http://www.w3.org/2001/XMLSchema-instance", "nil");
                                if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                                    object.setGuid(null);
                                    reader.next();

                                } else {

                                    object.setGuid(Guid.Factory.parse(reader));
                                }
                            } // End of if for expected property start element
                            else {
                                // A start element we are not expecting indicates an invalid parameter was passed
                                throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.
                                        getLocalName());
                            }

                        } else {
                            reader.next();
                        }
                    }  // end of while loop




                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }
        }//end of factory class

    }

    public static class _boolean
            implements org.apache.axis2.databinding.ADBBean {

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "http://schemas.microsoft.com/2003/10/Serialization/",
                "boolean",
                "ns3");

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if (namespace.equals("http://schemas.microsoft.com/2003/10/Serialization/")) {
                return "ns3";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }
        /**
         * field for _boolean
         */
        protected boolean local_boolean;

        /**
         * Auto generated getter method
         * @return boolean
         */
        public boolean get_boolean() {
            return local_boolean;
        }

        /**
         * Auto generated setter method
         * @param param _boolean
         */
        public void set_boolean(boolean param) {

            this.local_boolean = param;


        }

        /**
         * isReaderMTOMAware
         * @return true if the reader supports MTOM
         */
        public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
            boolean isReaderMTOMAware = false;

            try {
                isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(
                        org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
            } catch (java.lang.IllegalArgumentException e) {
                isReaderMTOMAware = false;
            }
            return isReaderMTOMAware;
        }

        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory) throws
                org.apache.axis2.databinding.ADBException {



            org.apache.axiom.om.OMDataSource dataSource =
                                             new org.apache.axis2.databinding.ADBDataSource(this,
                                                                                            MY_QNAME) {

                public void serialize(
                        org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                        throws javax.xml.stream.XMLStreamException {
                    _boolean.this.serialize(MY_QNAME, factory, xmlWriter);
                }
            };
            return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
                    MY_QNAME, factory, dataSource);

        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              final org.apache.axiom.om.OMFactory factory,
                              org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException,
                       org.apache.axis2.databinding.ADBException {
            serialize(parentQName, factory, xmlWriter, false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              final org.apache.axiom.om.OMFactory factory,
                              org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                              boolean serializeType)
                throws javax.xml.stream.XMLStreamException,
                       org.apache.axis2.databinding.ADBException {


            //We can safely assume an element has only one type associated with it

            java.lang.String namespace = "http://schemas.microsoft.com/2003/10/Serialization/";
            java.lang.String localName = "boolean";

            if (!namespace.equals("")) {
                java.lang.String prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    xmlWriter.writeStartElement(prefix, localName, namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);

                } else {
                    xmlWriter.writeStartElement(namespace, localName);
                }

            } else {
                xmlWriter.writeStartElement(localName);
            }

            // add the type details if this is used in a simple type
            if (serializeType) {
                java.lang.String namespacePrefix = registerPrefix(xmlWriter,
                                                                  "http://schemas.microsoft.com/2003/10/Serialization/");
                if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                                   namespacePrefix + ":boolean",
                                   xmlWriter);
                } else {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                                   "boolean",
                                   xmlWriter);
                }
            }

            if (false) {

                writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                               xmlWriter);

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.
                        convertToString(local_boolean));
            }

            xmlWriter.writeEndElement();



        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(java.lang.String prefix, java.lang.String namespace,
                                    java.lang.String attName,
                                    java.lang.String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);

            }

            xmlWriter.writeAttribute(namespace, attName, attValue);

        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace, java.lang.String attName,
                                    java.lang.String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                         javax.xml.namespace.QName qname,
                                         javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         *  method to handle Qnames
         */
        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.
                            convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.
                            convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.
                        convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.
                                    convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.
                                    convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.
                                convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }

        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter,
                                                java.lang.String namespace) throws
                javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);

            if (prefix == null) {
                prefix = generatePrefix(namespace);

                while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }

                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         *
         */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                throws org.apache.axis2.databinding.ADBException {




            //We can safely assume an element has only one type associated with it
            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(MY_QNAME,
                                                                                        new java.lang.Object[]{
                        org.apache.axis2.databinding.utils.reader.ADBXMLStreamReader.ELEMENT_TEXT,
                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                        local_boolean)
                    },
                                                                                        null);

        }

        /**
         *  Factory class that keeps the parse method
         */
        public static class Factory {

            /**
             * static method to create the object
             * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
             *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
             * Postcondition: If this object is an element, the reader is positioned at its end element
             *                If this object is a complex type, the reader is positioned at the end element of its outer element
             */
            public static _boolean parse(javax.xml.stream.XMLStreamReader reader) throws
                    java.lang.Exception {
                _boolean object =
                         new _boolean();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while (!reader.isStartElement() && !reader.isEndElement()) {
                        reader.next();
                    }


                    nillableValue = reader.getAttributeValue(
                            "http://www.w3.org/2001/XMLSchema-instance", "nil");
                    if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                        // Skip the element and report the null value.  It cannot have subelements.
                        while (!reader.isEndElement()) {
                            reader.next();
                        }

                        return object;


                    }



                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();



                    while (!reader.isEndElement()) {
                        if (reader.isStartElement()) {

                            if (reader.isStartElement() && new javax.xml.namespace.QName(
                                    "http://schemas.microsoft.com/2003/10/Serialization/", "boolean").
                                    equals(reader.getName())) {

                                nillableValue = reader.getAttributeValue(
                                        "http://www.w3.org/2001/XMLSchema-instance", "nil");
                                if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

                                    java.lang.String content = reader.getElementText();

                                    object.set_boolean(
                                            org.apache.axis2.databinding.utils.ConverterUtil.
                                            convertToBoolean(content));

                                } else {


                                    reader.getElementText(); // throw away text nodes if any.
                                }

                            } // End of if for expected property start element
                            else {
                                // A start element we are not expecting indicates an invalid parameter was passed
                                throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.
                                        getLocalName());
                            }

                        } else {
                            reader.next();
                        }
                    }  // end of while loop




                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }
        }//end of factory class

    }

    public static class DetectResponse
            implements org.apache.axis2.databinding.ADBBean {

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "http://api.microsofttranslator.com/v1/soap.svc",
                "DetectResponse",
                "ns2");

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if (namespace.equals("http://api.microsofttranslator.com/v1/soap.svc")) {
                return "ns2";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }
        /**
         * field for DetectResult
         */
        protected java.lang.String localDetectResult;
        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localDetectResultTracker = false;

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getDetectResult() {
            return localDetectResult;
        }

        /**
         * Auto generated setter method
         * @param param DetectResult
         */
        public void setDetectResult(java.lang.String param) {

            if (param != null) {
                //update the setting tracker
                localDetectResultTracker = true;
            } else {
                localDetectResultTracker = true;

            }

            this.localDetectResult = param;


        }

        /**
         * isReaderMTOMAware
         * @return true if the reader supports MTOM
         */
        public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
            boolean isReaderMTOMAware = false;

            try {
                isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(
                        org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
            } catch (java.lang.IllegalArgumentException e) {
                isReaderMTOMAware = false;
            }
            return isReaderMTOMAware;
        }

        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory) throws
                org.apache.axis2.databinding.ADBException {



            org.apache.axiom.om.OMDataSource dataSource =
                                             new org.apache.axis2.databinding.ADBDataSource(this,
                                                                                            MY_QNAME) {

                public void serialize(
                        org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                        throws javax.xml.stream.XMLStreamException {
                    DetectResponse.this.serialize(MY_QNAME, factory, xmlWriter);
                }
            };
            return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
                    MY_QNAME, factory, dataSource);

        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              final org.apache.axiom.om.OMFactory factory,
                              org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException,
                       org.apache.axis2.databinding.ADBException {
            serialize(parentQName, factory, xmlWriter, false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              final org.apache.axiom.om.OMFactory factory,
                              org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                              boolean serializeType)
                throws javax.xml.stream.XMLStreamException,
                       org.apache.axis2.databinding.ADBException {




            java.lang.String prefix = null;
            java.lang.String namespace = null;


            prefix = parentQName.getPrefix();
            namespace = parentQName.getNamespaceURI();

            if ((namespace != null) && (namespace.trim().length() > 0)) {
                java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
                if (writerPrefix != null) {
                    xmlWriter.writeStartElement(namespace, parentQName.getLocalPart());
                } else {
                    if (prefix == null) {
                        prefix = generatePrefix(namespace);
                    }

                    xmlWriter.writeStartElement(prefix, parentQName.getLocalPart(), namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);
                }
            } else {
                xmlWriter.writeStartElement(parentQName.getLocalPart());
            }

            if (serializeType) {


                java.lang.String namespacePrefix = registerPrefix(xmlWriter,
                                                                  "http://api.microsofttranslator.com/v1/soap.svc");
                if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                                   namespacePrefix + ":DetectResponse",
                                   xmlWriter);
                } else {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                                   "DetectResponse",
                                   xmlWriter);
                }


            }
            if (localDetectResultTracker) {
                namespace = "http://api.microsofttranslator.com/v1/soap.svc";
                if (!namespace.equals("")) {
                    prefix = xmlWriter.getPrefix(namespace);

                    if (prefix == null) {
                        prefix = generatePrefix(namespace);

                        xmlWriter.writeStartElement(prefix, "DetectResult", namespace);
                        xmlWriter.writeNamespace(prefix, namespace);
                        xmlWriter.setPrefix(prefix, namespace);

                    } else {
                        xmlWriter.writeStartElement(namespace, "DetectResult");
                    }

                } else {
                    xmlWriter.writeStartElement("DetectResult");
                }


                if (localDetectResult == null) {
                    // write the nil attribute

                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                                   xmlWriter);

                } else {


                    xmlWriter.writeCharacters(localDetectResult);

                }

                xmlWriter.writeEndElement();
            }
            xmlWriter.writeEndElement();


        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(java.lang.String prefix, java.lang.String namespace,
                                    java.lang.String attName,
                                    java.lang.String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);

            }

            xmlWriter.writeAttribute(namespace, attName, attValue);

        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace, java.lang.String attName,
                                    java.lang.String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                         javax.xml.namespace.QName qname,
                                         javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         *  method to handle Qnames
         */
        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.
                            convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.
                            convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.
                        convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.
                                    convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.
                                    convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.
                                convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }

        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter,
                                                java.lang.String namespace) throws
                javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);

            if (prefix == null) {
                prefix = generatePrefix(namespace);

                while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }

                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         *
         */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                throws org.apache.axis2.databinding.ADBException {



            java.util.ArrayList elementList = new java.util.ArrayList();
            java.util.ArrayList attribList = new java.util.ArrayList();

            if (localDetectResultTracker) {
                elementList.add(new javax.xml.namespace.QName(
                        "http://api.microsofttranslator.com/v1/soap.svc",
                                                              "DetectResult"));

                elementList.add(localDetectResult == null ? null : org.apache.axis2.databinding.utils.ConverterUtil.
                        convertToString(localDetectResult));
            }

            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName,
                                                                                        elementList.
                    toArray(), attribList.toArray());



        }

        /**
         *  Factory class that keeps the parse method
         */
        public static class Factory {

            /**
             * static method to create the object
             * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
             *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
             * Postcondition: If this object is an element, the reader is positioned at its end element
             *                If this object is a complex type, the reader is positioned at the end element of its outer element
             */
            public static DetectResponse parse(javax.xml.stream.XMLStreamReader reader) throws
                    java.lang.Exception {
                DetectResponse object =
                               new DetectResponse();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while (!reader.isStartElement() && !reader.isEndElement()) {
                        reader.next();
                    }


                    if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type") != null) {
                        java.lang.String fullTypeName = reader.getAttributeValue(
                                "http://www.w3.org/2001/XMLSchema-instance",
                                                                                 "type");
                        if (fullTypeName != null) {
                            java.lang.String nsPrefix = null;
                            if (fullTypeName.indexOf(":") > -1) {
                                nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
                            }
                            nsPrefix = nsPrefix == null ? "" : nsPrefix;

                            java.lang.String type = fullTypeName.substring(
                                    fullTypeName.indexOf(":") + 1);

                            if (!"DetectResponse".equals(type)) {
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().
                                        getNamespaceURI(nsPrefix);
                                return (DetectResponse) ExtensionMapper.getTypeObject(
                                        nsUri, type, reader);
                            }


                        }


                    }




                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();




                    reader.next();


                    while (!reader.isStartElement() && !reader.isEndElement()) {
                        reader.next();
                    }

                    if (reader.isStartElement() && new javax.xml.namespace.QName(
                            "http://api.microsofttranslator.com/v1/soap.svc", "DetectResult").equals(reader.
                            getName())) {

                        nillableValue = reader.getAttributeValue(
                                "http://www.w3.org/2001/XMLSchema-instance", "nil");
                        if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

                            java.lang.String content = reader.getElementText();

                            object.setDetectResult(
                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                    content));

                        } else {


                            reader.getElementText(); // throw away text nodes if any.
                        }

                        reader.next();

                    } // End of if for expected property start element
                    else {
                    }

                    while (!reader.isStartElement() && !reader.isEndElement()) {
                        reader.next();
                    }

                    if (reader.isStartElement()) // A start element we are not expecting indicates a trailing invalid property
                    {
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.
                                getLocalName());
                    }




                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }
        }//end of factory class

    }

    public static class GetLanguageNamesResponse
            implements org.apache.axis2.databinding.ADBBean {

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "http://api.microsofttranslator.com/v1/soap.svc",
                "GetLanguageNamesResponse",
                "ns2");

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if (namespace.equals("http://api.microsofttranslator.com/v1/soap.svc")) {
                return "ns2";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }
        /**
         * field for GetLanguageNamesResult
         */
        protected ArrayOfstring localGetLanguageNamesResult;
        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localGetLanguageNamesResultTracker = false;

        /**
         * Auto generated getter method
         * @return ArrayOfstring
         */
        public ArrayOfstring getGetLanguageNamesResult() {
            return localGetLanguageNamesResult;
        }

        /**
         * Auto generated setter method
         * @param param GetLanguageNamesResult
         */
        public void setGetLanguageNamesResult(ArrayOfstring param) {

            if (param != null) {
                //update the setting tracker
                localGetLanguageNamesResultTracker = true;
            } else {
                localGetLanguageNamesResultTracker = true;

            }

            this.localGetLanguageNamesResult = param;


        }

        /**
         * isReaderMTOMAware
         * @return true if the reader supports MTOM
         */
        public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
            boolean isReaderMTOMAware = false;

            try {
                isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(
                        org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
            } catch (java.lang.IllegalArgumentException e) {
                isReaderMTOMAware = false;
            }
            return isReaderMTOMAware;
        }

        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory) throws
                org.apache.axis2.databinding.ADBException {



            org.apache.axiom.om.OMDataSource dataSource =
                                             new org.apache.axis2.databinding.ADBDataSource(this,
                                                                                            MY_QNAME) {

                public void serialize(
                        org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                        throws javax.xml.stream.XMLStreamException {
                    GetLanguageNamesResponse.this.serialize(MY_QNAME, factory, xmlWriter);
                }
            };
            return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
                    MY_QNAME, factory, dataSource);

        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              final org.apache.axiom.om.OMFactory factory,
                              org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException,
                       org.apache.axis2.databinding.ADBException {
            serialize(parentQName, factory, xmlWriter, false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              final org.apache.axiom.om.OMFactory factory,
                              org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                              boolean serializeType)
                throws javax.xml.stream.XMLStreamException,
                       org.apache.axis2.databinding.ADBException {




            java.lang.String prefix = null;
            java.lang.String namespace = null;


            prefix = parentQName.getPrefix();
            namespace = parentQName.getNamespaceURI();

            if ((namespace != null) && (namespace.trim().length() > 0)) {
                java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
                if (writerPrefix != null) {
                    xmlWriter.writeStartElement(namespace, parentQName.getLocalPart());
                } else {
                    if (prefix == null) {
                        prefix = generatePrefix(namespace);
                    }

                    xmlWriter.writeStartElement(prefix, parentQName.getLocalPart(), namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);
                }
            } else {
                xmlWriter.writeStartElement(parentQName.getLocalPart());
            }

            if (serializeType) {


                java.lang.String namespacePrefix = registerPrefix(xmlWriter,
                                                                  "http://api.microsofttranslator.com/v1/soap.svc");
                if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                                   namespacePrefix + ":GetLanguageNamesResponse",
                                   xmlWriter);
                } else {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                                   "GetLanguageNamesResponse",
                                   xmlWriter);
                }


            }
            if (localGetLanguageNamesResultTracker) {
                if (localGetLanguageNamesResult == null) {

                    java.lang.String namespace2 = "http://api.microsofttranslator.com/v1/soap.svc";

                    if (!namespace2.equals("")) {
                        java.lang.String prefix2 = xmlWriter.getPrefix(namespace2);

                        if (prefix2 == null) {
                            prefix2 = generatePrefix(namespace2);

                            xmlWriter.writeStartElement(prefix2, "GetLanguageNamesResult",
                                                        namespace2);
                            xmlWriter.writeNamespace(prefix2, namespace2);
                            xmlWriter.setPrefix(prefix2, namespace2);

                        } else {
                            xmlWriter.writeStartElement(namespace2, "GetLanguageNamesResult");
                        }

                    } else {
                        xmlWriter.writeStartElement("GetLanguageNamesResult");
                    }


                    // write the nil attribute
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                                   xmlWriter);
                    xmlWriter.writeEndElement();
                } else {
                    localGetLanguageNamesResult.serialize(
                            new javax.xml.namespace.QName(
                            "http://api.microsofttranslator.com/v1/soap.svc",
                                                          "GetLanguageNamesResult"),
                                                          factory, xmlWriter);
                }
            }
            xmlWriter.writeEndElement();


        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(java.lang.String prefix, java.lang.String namespace,
                                    java.lang.String attName,
                                    java.lang.String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);

            }

            xmlWriter.writeAttribute(namespace, attName, attValue);

        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace, java.lang.String attName,
                                    java.lang.String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                         javax.xml.namespace.QName qname,
                                         javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         *  method to handle Qnames
         */
        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.
                            convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.
                            convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.
                        convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.
                                    convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.
                                    convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.
                                convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }

        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter,
                                                java.lang.String namespace) throws
                javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);

            if (prefix == null) {
                prefix = generatePrefix(namespace);

                while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }

                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         *
         */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                throws org.apache.axis2.databinding.ADBException {



            java.util.ArrayList elementList = new java.util.ArrayList();
            java.util.ArrayList attribList = new java.util.ArrayList();

            if (localGetLanguageNamesResultTracker) {
                elementList.add(new javax.xml.namespace.QName(
                        "http://api.microsofttranslator.com/v1/soap.svc",
                                                              "GetLanguageNamesResult"));


                elementList.add(
                        localGetLanguageNamesResult == null ? null : localGetLanguageNamesResult);
            }

            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName,
                                                                                        elementList.
                    toArray(), attribList.toArray());



        }

        /**
         *  Factory class that keeps the parse method
         */
        public static class Factory {

            /**
             * static method to create the object
             * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
             *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
             * Postcondition: If this object is an element, the reader is positioned at its end element
             *                If this object is a complex type, the reader is positioned at the end element of its outer element
             */
            public static GetLanguageNamesResponse parse(javax.xml.stream.XMLStreamReader reader)
                    throws java.lang.Exception {
                GetLanguageNamesResponse object =
                                         new GetLanguageNamesResponse();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while (!reader.isStartElement() && !reader.isEndElement()) {
                        reader.next();
                    }


                    if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type") != null) {
                        java.lang.String fullTypeName = reader.getAttributeValue(
                                "http://www.w3.org/2001/XMLSchema-instance",
                                                                                 "type");
                        if (fullTypeName != null) {
                            java.lang.String nsPrefix = null;
                            if (fullTypeName.indexOf(":") > -1) {
                                nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
                            }
                            nsPrefix = nsPrefix == null ? "" : nsPrefix;

                            java.lang.String type = fullTypeName.substring(
                                    fullTypeName.indexOf(":") + 1);

                            if (!"GetLanguageNamesResponse".equals(type)) {
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().
                                        getNamespaceURI(nsPrefix);
                                return (GetLanguageNamesResponse) ExtensionMapper.getTypeObject(
                                        nsUri, type, reader);
                            }


                        }


                    }




                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();




                    reader.next();


                    while (!reader.isStartElement() && !reader.isEndElement()) {
                        reader.next();
                    }

                    if (reader.isStartElement() && new javax.xml.namespace.QName(
                            "http://api.microsofttranslator.com/v1/soap.svc",
                                                                                 "GetLanguageNamesResult").
                            equals(reader.getName())) {

                        nillableValue = reader.getAttributeValue(
                                "http://www.w3.org/2001/XMLSchema-instance", "nil");
                        if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                            object.setGetLanguageNamesResult(null);
                            reader.next();

                            reader.next();

                        } else {

                            object.setGetLanguageNamesResult(ArrayOfstring.Factory.parse(reader));

                            reader.next();
                        }
                    } // End of if for expected property start element
                    else {
                    }

                    while (!reader.isStartElement() && !reader.isEndElement()) {
                        reader.next();
                    }

                    if (reader.isStartElement()) // A start element we are not expecting indicates a trailing invalid property
                    {
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.
                                getLocalName());
                    }




                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }
        }//end of factory class

    }

    public static class UnsignedShort
            implements org.apache.axis2.databinding.ADBBean {

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "http://schemas.microsoft.com/2003/10/Serialization/",
                "unsignedShort",
                "ns3");

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if (namespace.equals("http://schemas.microsoft.com/2003/10/Serialization/")) {
                return "ns3";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }
        /**
         * field for UnsignedShort
         */
        protected org.apache.axis2.databinding.types.UnsignedShort localUnsignedShort;

        /**
         * Auto generated getter method
         * @return org.apache.axis2.databinding.types.UnsignedShort
         */
        public org.apache.axis2.databinding.types.UnsignedShort getUnsignedShort() {
            return localUnsignedShort;
        }

        /**
         * Auto generated setter method
         * @param param UnsignedShort
         */
        public void setUnsignedShort(org.apache.axis2.databinding.types.UnsignedShort param) {

            this.localUnsignedShort = param;


        }

        /**
         * isReaderMTOMAware
         * @return true if the reader supports MTOM
         */
        public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
            boolean isReaderMTOMAware = false;

            try {
                isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(
                        org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
            } catch (java.lang.IllegalArgumentException e) {
                isReaderMTOMAware = false;
            }
            return isReaderMTOMAware;
        }

        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory) throws
                org.apache.axis2.databinding.ADBException {



            org.apache.axiom.om.OMDataSource dataSource =
                                             new org.apache.axis2.databinding.ADBDataSource(this,
                                                                                            MY_QNAME) {

                public void serialize(
                        org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                        throws javax.xml.stream.XMLStreamException {
                    UnsignedShort.this.serialize(MY_QNAME, factory, xmlWriter);
                }
            };
            return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
                    MY_QNAME, factory, dataSource);

        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              final org.apache.axiom.om.OMFactory factory,
                              org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException,
                       org.apache.axis2.databinding.ADBException {
            serialize(parentQName, factory, xmlWriter, false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              final org.apache.axiom.om.OMFactory factory,
                              org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                              boolean serializeType)
                throws javax.xml.stream.XMLStreamException,
                       org.apache.axis2.databinding.ADBException {


            //We can safely assume an element has only one type associated with it

            java.lang.String namespace = "http://schemas.microsoft.com/2003/10/Serialization/";
            java.lang.String localName = "unsignedShort";

            if (!namespace.equals("")) {
                java.lang.String prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    xmlWriter.writeStartElement(prefix, localName, namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);

                } else {
                    xmlWriter.writeStartElement(namespace, localName);
                }

            } else {
                xmlWriter.writeStartElement(localName);
            }

            // add the type details if this is used in a simple type
            if (serializeType) {
                java.lang.String namespacePrefix = registerPrefix(xmlWriter,
                                                                  "http://schemas.microsoft.com/2003/10/Serialization/");
                if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                                   namespacePrefix + ":unsignedShort",
                                   xmlWriter);
                } else {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                                   "unsignedShort",
                                   xmlWriter);
                }
            }

            if (localUnsignedShort == null) {

                // write the nil attribute
                writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                               xmlWriter);

            } else {

                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.
                        convertToString(localUnsignedShort));

            }

            xmlWriter.writeEndElement();



        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(java.lang.String prefix, java.lang.String namespace,
                                    java.lang.String attName,
                                    java.lang.String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);

            }

            xmlWriter.writeAttribute(namespace, attName, attValue);

        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace, java.lang.String attName,
                                    java.lang.String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                         javax.xml.namespace.QName qname,
                                         javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         *  method to handle Qnames
         */
        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.
                            convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.
                            convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.
                        convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.
                                    convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.
                                    convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.
                                convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }

        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter,
                                                java.lang.String namespace) throws
                javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);

            if (prefix == null) {
                prefix = generatePrefix(namespace);

                while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }

                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         *
         */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                throws org.apache.axis2.databinding.ADBException {




            //We can safely assume an element has only one type associated with it

            if (localUnsignedShort == null) {
                return new org.apache.axis2.databinding.utils.reader.NullXMLStreamReader(MY_QNAME);
            } else {
                return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(MY_QNAME,
                                                                                            new java.lang.Object[]{
                            org.apache.axis2.databinding.utils.reader.ADBXMLStreamReader.ELEMENT_TEXT,
                            org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                            localUnsignedShort)
                        },
                                                                                            null);
            }


        }

        /**
         *  Factory class that keeps the parse method
         */
        public static class Factory {

            /**
             * static method to create the object
             * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
             *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
             * Postcondition: If this object is an element, the reader is positioned at its end element
             *                If this object is a complex type, the reader is positioned at the end element of its outer element
             */
            public static UnsignedShort parse(javax.xml.stream.XMLStreamReader reader) throws
                    java.lang.Exception {
                UnsignedShort object =
                              new UnsignedShort();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while (!reader.isStartElement() && !reader.isEndElement()) {
                        reader.next();
                    }


                    nillableValue = reader.getAttributeValue(
                            "http://www.w3.org/2001/XMLSchema-instance", "nil");
                    if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                        // Skip the element and report the null value.  It cannot have subelements.
                        while (!reader.isEndElement()) {
                            reader.next();
                        }

                        return object;


                    }



                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();



                    while (!reader.isEndElement()) {
                        if (reader.isStartElement()) {

                            if (reader.isStartElement() && new javax.xml.namespace.QName(
                                    "http://schemas.microsoft.com/2003/10/Serialization/",
                                                                                         "unsignedShort").
                                    equals(reader.getName())) {

                                nillableValue = reader.getAttributeValue(
                                        "http://www.w3.org/2001/XMLSchema-instance", "nil");
                                if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

                                    java.lang.String content = reader.getElementText();

                                    object.setUnsignedShort(
                                            org.apache.axis2.databinding.utils.ConverterUtil.
                                            convertToUnsignedShort(content));

                                } else {


                                    reader.getElementText(); // throw away text nodes if any.
                                }

                            } // End of if for expected property start element
                            else {
                                // A start element we are not expecting indicates an invalid parameter was passed
                                throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.
                                        getLocalName());
                            }

                        } else {
                            reader.next();
                        }
                    }  // end of while loop




                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }
        }//end of factory class

    }

    public static class GetLanguages
            implements org.apache.axis2.databinding.ADBBean {

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "http://api.microsofttranslator.com/v1/soap.svc",
                "GetLanguages",
                "ns2");

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if (namespace.equals("http://api.microsofttranslator.com/v1/soap.svc")) {
                return "ns2";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }
        /**
         * field for AppId
         */
        protected java.lang.String localAppId;
        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localAppIdTracker = false;

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getAppId() {
            return localAppId;
        }

        /**
         * Auto generated setter method
         * @param param AppId
         */
        public void setAppId(java.lang.String param) {

            if (param != null) {
                //update the setting tracker
                localAppIdTracker = true;
            } else {
                localAppIdTracker = true;

            }

            this.localAppId = param;


        }

        /**
         * isReaderMTOMAware
         * @return true if the reader supports MTOM
         */
        public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
            boolean isReaderMTOMAware = false;

            try {
                isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(
                        org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
            } catch (java.lang.IllegalArgumentException e) {
                isReaderMTOMAware = false;
            }
            return isReaderMTOMAware;
        }

        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory) throws
                org.apache.axis2.databinding.ADBException {



            org.apache.axiom.om.OMDataSource dataSource =
                                             new org.apache.axis2.databinding.ADBDataSource(this,
                                                                                            MY_QNAME) {

                public void serialize(
                        org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                        throws javax.xml.stream.XMLStreamException {
                    GetLanguages.this.serialize(MY_QNAME, factory, xmlWriter);
                }
            };
            return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
                    MY_QNAME, factory, dataSource);

        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              final org.apache.axiom.om.OMFactory factory,
                              org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException,
                       org.apache.axis2.databinding.ADBException {
            serialize(parentQName, factory, xmlWriter, false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              final org.apache.axiom.om.OMFactory factory,
                              org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                              boolean serializeType)
                throws javax.xml.stream.XMLStreamException,
                       org.apache.axis2.databinding.ADBException {




            java.lang.String prefix = null;
            java.lang.String namespace = null;


            prefix = parentQName.getPrefix();
            namespace = parentQName.getNamespaceURI();

            if ((namespace != null) && (namespace.trim().length() > 0)) {
                java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
                if (writerPrefix != null) {
                    xmlWriter.writeStartElement(namespace, parentQName.getLocalPart());
                } else {
                    if (prefix == null) {
                        prefix = generatePrefix(namespace);
                    }

                    xmlWriter.writeStartElement(prefix, parentQName.getLocalPart(), namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);
                }
            } else {
                xmlWriter.writeStartElement(parentQName.getLocalPart());
            }

            if (serializeType) {


                java.lang.String namespacePrefix = registerPrefix(xmlWriter,
                                                                  "http://api.microsofttranslator.com/v1/soap.svc");
                if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                                   namespacePrefix + ":GetLanguages",
                                   xmlWriter);
                } else {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                                   "GetLanguages",
                                   xmlWriter);
                }


            }
            if (localAppIdTracker) {
                namespace = "http://api.microsofttranslator.com/v1/soap.svc";
                if (!namespace.equals("")) {
                    prefix = xmlWriter.getPrefix(namespace);

                    if (prefix == null) {
                        prefix = generatePrefix(namespace);

                        xmlWriter.writeStartElement(prefix, "appId", namespace);
                        xmlWriter.writeNamespace(prefix, namespace);
                        xmlWriter.setPrefix(prefix, namespace);

                    } else {
                        xmlWriter.writeStartElement(namespace, "appId");
                    }

                } else {
                    xmlWriter.writeStartElement("appId");
                }


                if (localAppId == null) {
                    // write the nil attribute

                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                                   xmlWriter);

                } else {


                    xmlWriter.writeCharacters(localAppId);

                }

                xmlWriter.writeEndElement();
            }
            xmlWriter.writeEndElement();


        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(java.lang.String prefix, java.lang.String namespace,
                                    java.lang.String attName,
                                    java.lang.String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);

            }

            xmlWriter.writeAttribute(namespace, attName, attValue);

        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace, java.lang.String attName,
                                    java.lang.String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                         javax.xml.namespace.QName qname,
                                         javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         *  method to handle Qnames
         */
        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.
                            convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.
                            convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.
                        convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.
                                    convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.
                                    convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.
                                convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }

        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter,
                                                java.lang.String namespace) throws
                javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);

            if (prefix == null) {
                prefix = generatePrefix(namespace);

                while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }

                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         *
         */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                throws org.apache.axis2.databinding.ADBException {



            java.util.ArrayList elementList = new java.util.ArrayList();
            java.util.ArrayList attribList = new java.util.ArrayList();

            if (localAppIdTracker) {
                elementList.add(new javax.xml.namespace.QName(
                        "http://api.microsofttranslator.com/v1/soap.svc",
                                                              "appId"));

                elementList.add(localAppId == null ? null : org.apache.axis2.databinding.utils.ConverterUtil.
                        convertToString(localAppId));
            }

            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName,
                                                                                        elementList.
                    toArray(), attribList.toArray());



        }

        /**
         *  Factory class that keeps the parse method
         */
        public static class Factory {

            /**
             * static method to create the object
             * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
             *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
             * Postcondition: If this object is an element, the reader is positioned at its end element
             *                If this object is a complex type, the reader is positioned at the end element of its outer element
             */
            public static GetLanguages parse(javax.xml.stream.XMLStreamReader reader) throws
                    java.lang.Exception {
                GetLanguages object =
                             new GetLanguages();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while (!reader.isStartElement() && !reader.isEndElement()) {
                        reader.next();
                    }


                    if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type") != null) {
                        java.lang.String fullTypeName = reader.getAttributeValue(
                                "http://www.w3.org/2001/XMLSchema-instance",
                                                                                 "type");
                        if (fullTypeName != null) {
                            java.lang.String nsPrefix = null;
                            if (fullTypeName.indexOf(":") > -1) {
                                nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
                            }
                            nsPrefix = nsPrefix == null ? "" : nsPrefix;

                            java.lang.String type = fullTypeName.substring(
                                    fullTypeName.indexOf(":") + 1);

                            if (!"GetLanguages".equals(type)) {
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().
                                        getNamespaceURI(nsPrefix);
                                return (GetLanguages) ExtensionMapper.getTypeObject(
                                        nsUri, type, reader);
                            }


                        }


                    }




                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();




                    reader.next();


                    while (!reader.isStartElement() && !reader.isEndElement()) {
                        reader.next();
                    }

                    if (reader.isStartElement() && new javax.xml.namespace.QName(
                            "http://api.microsofttranslator.com/v1/soap.svc", "appId").equals(reader.
                            getName())) {

                        nillableValue = reader.getAttributeValue(
                                "http://www.w3.org/2001/XMLSchema-instance", "nil");
                        if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

                            java.lang.String content = reader.getElementText();

                            object.setAppId(
                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                    content));

                        } else {


                            reader.getElementText(); // throw away text nodes if any.
                        }

                        reader.next();

                    } // End of if for expected property start element
                    else {
                    }

                    while (!reader.isStartElement() && !reader.isEndElement()) {
                        reader.next();
                    }

                    if (reader.isStartElement()) // A start element we are not expecting indicates a trailing invalid property
                    {
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.
                                getLocalName());
                    }




                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }
        }//end of factory class

    }

    public static class String
            implements org.apache.axis2.databinding.ADBBean {

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "http://schemas.microsoft.com/2003/10/Serialization/",
                "string",
                "ns3");

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if (namespace.equals("http://schemas.microsoft.com/2003/10/Serialization/")) {
                return "ns3";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }
        /**
         * field for String
         */
        protected java.lang.String localString;

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getString() {
            return localString;
        }

        /**
         * Auto generated setter method
         * @param param String
         */
        public void setString(java.lang.String param) {

            this.localString = param;


        }

        /**
         * isReaderMTOMAware
         * @return true if the reader supports MTOM
         */
        public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
            boolean isReaderMTOMAware = false;

            try {
                isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(
                        org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
            } catch (java.lang.IllegalArgumentException e) {
                isReaderMTOMAware = false;
            }
            return isReaderMTOMAware;
        }

        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory) throws
                org.apache.axis2.databinding.ADBException {



            org.apache.axiom.om.OMDataSource dataSource =
                                             new org.apache.axis2.databinding.ADBDataSource(this,
                                                                                            MY_QNAME) {

                public void serialize(
                        org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                        throws javax.xml.stream.XMLStreamException {
                    String.this.serialize(MY_QNAME, factory, xmlWriter);
                }
            };
            return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
                    MY_QNAME, factory, dataSource);

        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              final org.apache.axiom.om.OMFactory factory,
                              org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException,
                       org.apache.axis2.databinding.ADBException {
            serialize(parentQName, factory, xmlWriter, false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              final org.apache.axiom.om.OMFactory factory,
                              org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                              boolean serializeType)
                throws javax.xml.stream.XMLStreamException,
                       org.apache.axis2.databinding.ADBException {


            //We can safely assume an element has only one type associated with it

            java.lang.String namespace = "http://schemas.microsoft.com/2003/10/Serialization/";
            java.lang.String localName = "string";

            if (!namespace.equals("")) {
                java.lang.String prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    xmlWriter.writeStartElement(prefix, localName, namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);

                } else {
                    xmlWriter.writeStartElement(namespace, localName);
                }

            } else {
                xmlWriter.writeStartElement(localName);
            }

            // add the type details if this is used in a simple type
            if (serializeType) {
                java.lang.String namespacePrefix = registerPrefix(xmlWriter,
                                                                  "http://schemas.microsoft.com/2003/10/Serialization/");
                if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                                   namespacePrefix + ":string",
                                   xmlWriter);
                } else {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                                   "string",
                                   xmlWriter);
                }
            }

            if (localString == null) {

                // write the nil attribute
                writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                               xmlWriter);

            } else {

                xmlWriter.writeCharacters(localString);

            }

            xmlWriter.writeEndElement();



        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(java.lang.String prefix, java.lang.String namespace,
                                    java.lang.String attName,
                                    java.lang.String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);

            }

            xmlWriter.writeAttribute(namespace, attName, attValue);

        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace, java.lang.String attName,
                                    java.lang.String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                         javax.xml.namespace.QName qname,
                                         javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         *  method to handle Qnames
         */
        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.
                            convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.
                            convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.
                        convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.
                                    convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.
                                    convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.
                                convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }

        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter,
                                                java.lang.String namespace) throws
                javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);

            if (prefix == null) {
                prefix = generatePrefix(namespace);

                while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }

                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         *
         */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                throws org.apache.axis2.databinding.ADBException {




            //We can safely assume an element has only one type associated with it

            if (localString == null) {
                return new org.apache.axis2.databinding.utils.reader.NullXMLStreamReader(MY_QNAME);
            } else {
                return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(MY_QNAME,
                                                                                            new java.lang.Object[]{
                            org.apache.axis2.databinding.utils.reader.ADBXMLStreamReader.ELEMENT_TEXT,
                            org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                            localString)
                        },
                                                                                            null);
            }


        }

        /**
         *  Factory class that keeps the parse method
         */
        public static class Factory {

            /**
             * static method to create the object
             * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
             *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
             * Postcondition: If this object is an element, the reader is positioned at its end element
             *                If this object is a complex type, the reader is positioned at the end element of its outer element
             */
            public static String parse(javax.xml.stream.XMLStreamReader reader) throws
                    java.lang.Exception {
                String object =
                       new String();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while (!reader.isStartElement() && !reader.isEndElement()) {
                        reader.next();
                    }


                    nillableValue = reader.getAttributeValue(
                            "http://www.w3.org/2001/XMLSchema-instance", "nil");
                    if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                        // Skip the element and report the null value.  It cannot have subelements.
                        while (!reader.isEndElement()) {
                            reader.next();
                        }

                        return object;


                    }



                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();



                    while (!reader.isEndElement()) {
                        if (reader.isStartElement()) {

                            if (reader.isStartElement() && new javax.xml.namespace.QName(
                                    "http://schemas.microsoft.com/2003/10/Serialization/", "string").
                                    equals(reader.getName())) {

                                nillableValue = reader.getAttributeValue(
                                        "http://www.w3.org/2001/XMLSchema-instance", "nil");
                                if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

                                    java.lang.String content = reader.getElementText();

                                    object.setString(
                                            org.apache.axis2.databinding.utils.ConverterUtil.
                                            convertToString(content));

                                } else {


                                    reader.getElementText(); // throw away text nodes if any.
                                }

                            } // End of if for expected property start element
                            else {
                                // A start element we are not expecting indicates an invalid parameter was passed
                                throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.
                                        getLocalName());
                            }

                        } else {
                            reader.next();
                        }
                    }  // end of while loop




                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }
        }//end of factory class

    }

    public static class ArrayOfstringE
            implements org.apache.axis2.databinding.ADBBean {

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "http://schemas.microsoft.com/2003/10/Serialization/Arrays",
                "ArrayOfstring",
                "ns1");

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if (namespace.equals("http://schemas.microsoft.com/2003/10/Serialization/Arrays")) {
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }
        /**
         * field for ArrayOfstring
         */
        protected ArrayOfstring localArrayOfstring;

        /**
         * Auto generated getter method
         * @return ArrayOfstring
         */
        public ArrayOfstring getArrayOfstring() {
            return localArrayOfstring;
        }

        /**
         * Auto generated setter method
         * @param param ArrayOfstring
         */
        public void setArrayOfstring(ArrayOfstring param) {

            this.localArrayOfstring = param;


        }

        /**
         * isReaderMTOMAware
         * @return true if the reader supports MTOM
         */
        public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
            boolean isReaderMTOMAware = false;

            try {
                isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(
                        org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
            } catch (java.lang.IllegalArgumentException e) {
                isReaderMTOMAware = false;
            }
            return isReaderMTOMAware;
        }

        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory) throws
                org.apache.axis2.databinding.ADBException {



            org.apache.axiom.om.OMDataSource dataSource =
                                             new org.apache.axis2.databinding.ADBDataSource(this,
                                                                                            MY_QNAME) {

                public void serialize(
                        org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                        throws javax.xml.stream.XMLStreamException {
                    ArrayOfstringE.this.serialize(MY_QNAME, factory, xmlWriter);
                }
            };
            return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
                    MY_QNAME, factory, dataSource);

        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              final org.apache.axiom.om.OMFactory factory,
                              org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException,
                       org.apache.axis2.databinding.ADBException {
            serialize(parentQName, factory, xmlWriter, false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              final org.apache.axiom.om.OMFactory factory,
                              org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                              boolean serializeType)
                throws javax.xml.stream.XMLStreamException,
                       org.apache.axis2.databinding.ADBException {


            //We can safely assume an element has only one type associated with it

            if (localArrayOfstring == null) {
                java.lang.String namespace = "http://schemas.microsoft.com/2003/10/Serialization/Arrays";

                if (!namespace.equals("")) {
                    java.lang.String prefix = xmlWriter.getPrefix(namespace);

                    if (prefix == null) {
                        prefix = generatePrefix(namespace);

                        xmlWriter.writeStartElement(prefix, "ArrayOfstring", namespace);
                        xmlWriter.writeNamespace(prefix, namespace);
                        xmlWriter.setPrefix(prefix, namespace);

                    } else {
                        xmlWriter.writeStartElement(namespace, "ArrayOfstring");
                    }

                } else {
                    xmlWriter.writeStartElement("ArrayOfstring");
                }

                // write the nil attribute
                writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                               xmlWriter);
                xmlWriter.writeEndElement();
            } else {
                localArrayOfstring.serialize(MY_QNAME, factory, xmlWriter);
            }


        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(java.lang.String prefix, java.lang.String namespace,
                                    java.lang.String attName,
                                    java.lang.String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);

            }

            xmlWriter.writeAttribute(namespace, attName, attValue);

        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace, java.lang.String attName,
                                    java.lang.String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                         javax.xml.namespace.QName qname,
                                         javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         *  method to handle Qnames
         */
        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.
                            convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.
                            convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.
                        convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws
                javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.
                                    convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.
                                    convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.
                                convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }

        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter,
                                                java.lang.String namespace) throws
                javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);

            if (prefix == null) {
                prefix = generatePrefix(namespace);

                while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }

                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         *
         */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                throws org.apache.axis2.databinding.ADBException {




            //We can safely assume an element has only one type associated with it

            if (localArrayOfstring == null) {
                return new org.apache.axis2.databinding.utils.reader.NullXMLStreamReader(MY_QNAME);
            } else {
                return localArrayOfstring.getPullParser(MY_QNAME);
            }


        }

        /**
         *  Factory class that keeps the parse method
         */
        public static class Factory {

            /**
             * static method to create the object
             * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
             *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
             * Postcondition: If this object is an element, the reader is positioned at its end element
             *                If this object is a complex type, the reader is positioned at the end element of its outer element
             */
            public static ArrayOfstringE parse(javax.xml.stream.XMLStreamReader reader) throws
                    java.lang.Exception {
                ArrayOfstringE object =
                               new ArrayOfstringE();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while (!reader.isStartElement() && !reader.isEndElement()) {
                        reader.next();
                    }


                    nillableValue = reader.getAttributeValue(
                            "http://www.w3.org/2001/XMLSchema-instance", "nil");
                    if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                        // Skip the element and report the null value.  It cannot have subelements.
                        while (!reader.isEndElement()) {
                            reader.next();
                        }

                        return object;


                    }



                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();



                    while (!reader.isEndElement()) {
                        if (reader.isStartElement()) {

                            if (reader.isStartElement() && new javax.xml.namespace.QName(
                                    "http://schemas.microsoft.com/2003/10/Serialization/Arrays",
                                                                                         "ArrayOfstring").
                                    equals(reader.getName())) {

                                nillableValue = reader.getAttributeValue(
                                        "http://www.w3.org/2001/XMLSchema-instance", "nil");
                                if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                                    object.setArrayOfstring(null);
                                    reader.next();

                                } else {

                                    object.setArrayOfstring(ArrayOfstring.Factory.parse(reader));
                                }
                            } // End of if for expected property start element
                            else {
                                // A start element we are not expecting indicates an invalid parameter was passed
                                throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.
                                        getLocalName());
                            }

                        } else {
                            reader.next();
                        }
                    }  // end of while loop




                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }
        }//end of factory class

    }

    private org.apache.axiom.om.OMElement toOM(
            com.microsofttranslator.api.v1.soap_svc.SoapStub.Detect param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {


        try {
            return param.getOMElement(
                    com.microsofttranslator.api.v1.soap_svc.SoapStub.Detect.MY_QNAME,
                                      org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }


    }

    private org.apache.axiom.om.OMElement toOM(
            com.microsofttranslator.api.v1.soap_svc.SoapStub.DetectResponse param,
                                               boolean optimizeContent)
            throws org.apache.axis2.AxisFault {


        try {
            return param.getOMElement(
                    com.microsofttranslator.api.v1.soap_svc.SoapStub.DetectResponse.MY_QNAME,
                                      org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }


    }

    private org.apache.axiom.om.OMElement toOM(
            com.microsofttranslator.api.v1.soap_svc.SoapStub.Translate param,
                                               boolean optimizeContent)
            throws org.apache.axis2.AxisFault {


        try {
            return param.getOMElement(
                    com.microsofttranslator.api.v1.soap_svc.SoapStub.Translate.MY_QNAME,
                                      org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }


    }

    private org.apache.axiom.om.OMElement toOM(
            com.microsofttranslator.api.v1.soap_svc.SoapStub.TranslateResponse param,
                                               boolean optimizeContent)
            throws org.apache.axis2.AxisFault {


        try {
            return param.getOMElement(
                    com.microsofttranslator.api.v1.soap_svc.SoapStub.TranslateResponse.MY_QNAME,
                                      org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }


    }

    private org.apache.axiom.om.OMElement toOM(
            com.microsofttranslator.api.v1.soap_svc.SoapStub.GetLanguageNames param,
                                               boolean optimizeContent)
            throws org.apache.axis2.AxisFault {


        try {
            return param.getOMElement(
                    com.microsofttranslator.api.v1.soap_svc.SoapStub.GetLanguageNames.MY_QNAME,
                                      org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }


    }

    private org.apache.axiom.om.OMElement toOM(
            com.microsofttranslator.api.v1.soap_svc.SoapStub.GetLanguageNamesResponse param,
                                               boolean optimizeContent)
            throws org.apache.axis2.AxisFault {


        try {
            return param.getOMElement(
                    com.microsofttranslator.api.v1.soap_svc.SoapStub.GetLanguageNamesResponse.MY_QNAME,
                                      org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }


    }

    private org.apache.axiom.om.OMElement toOM(
            com.microsofttranslator.api.v1.soap_svc.SoapStub.GetLanguages param,
                                               boolean optimizeContent)
            throws org.apache.axis2.AxisFault {


        try {
            return param.getOMElement(
                    com.microsofttranslator.api.v1.soap_svc.SoapStub.GetLanguages.MY_QNAME,
                                      org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }


    }

    private org.apache.axiom.om.OMElement toOM(
            com.microsofttranslator.api.v1.soap_svc.SoapStub.GetLanguagesResponse param,
                                               boolean optimizeContent)
            throws org.apache.axis2.AxisFault {


        try {
            return param.getOMElement(
                    com.microsofttranslator.api.v1.soap_svc.SoapStub.GetLanguagesResponse.MY_QNAME,
                                      org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }


    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory,
                                                          com.microsofttranslator.api.v1.soap_svc.SoapStub.Detect param,
                                                          boolean optimizeContent)
            throws org.apache.axis2.AxisFault {


        try {

            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
            emptyEnvelope.getBody().addChild(param.getOMElement(
                    com.microsofttranslator.api.v1.soap_svc.SoapStub.Detect.MY_QNAME, factory));
            return emptyEnvelope;
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }


    }

    /* methods to provide back word compatibility */
    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory,
                                                          com.microsofttranslator.api.v1.soap_svc.SoapStub.Translate param,
                                                          boolean optimizeContent)
            throws org.apache.axis2.AxisFault {


        try {

            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
            emptyEnvelope.getBody().addChild(param.getOMElement(
                    com.microsofttranslator.api.v1.soap_svc.SoapStub.Translate.MY_QNAME, factory));
            return emptyEnvelope;
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }


    }

    /* methods to provide back word compatibility */
    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory,
                                                          com.microsofttranslator.api.v1.soap_svc.SoapStub.GetLanguageNames param,
                                                          boolean optimizeContent)
            throws org.apache.axis2.AxisFault {


        try {

            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
            emptyEnvelope.getBody().addChild(param.getOMElement(
                    com.microsofttranslator.api.v1.soap_svc.SoapStub.GetLanguageNames.MY_QNAME,
                                                                factory));
            return emptyEnvelope;
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }


    }

    /* methods to provide back word compatibility */
    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory,
                                                          com.microsofttranslator.api.v1.soap_svc.SoapStub.GetLanguages param,
                                                          boolean optimizeContent)
            throws org.apache.axis2.AxisFault {


        try {

            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
            emptyEnvelope.getBody().addChild(param.getOMElement(
                    com.microsofttranslator.api.v1.soap_svc.SoapStub.GetLanguages.MY_QNAME, factory));
            return emptyEnvelope;
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }


    }

    /* methods to provide back word compatibility */
    /**
     *  get the default envelope
     */
    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory) {
        return factory.getDefaultEnvelope();
    }

    private java.lang.Object fromOM(
            org.apache.axiom.om.OMElement param,
            java.lang.Class type,
            java.util.Map extraNamespaces) throws org.apache.axis2.AxisFault {

        try {

            if (com.microsofttranslator.api.v1.soap_svc.SoapStub.Detect.class.equals(type)) {

                return com.microsofttranslator.api.v1.soap_svc.SoapStub.Detect.Factory.parse(param.
                        getXMLStreamReaderWithoutCaching());


            }

            if (com.microsofttranslator.api.v1.soap_svc.SoapStub.DetectResponse.class.equals(type)) {

                return com.microsofttranslator.api.v1.soap_svc.SoapStub.DetectResponse.Factory.parse(param.
                        getXMLStreamReaderWithoutCaching());


            }

            if (com.microsofttranslator.api.v1.soap_svc.SoapStub.Translate.class.equals(type)) {

                return com.microsofttranslator.api.v1.soap_svc.SoapStub.Translate.Factory.parse(param.
                        getXMLStreamReaderWithoutCaching());


            }

            if (com.microsofttranslator.api.v1.soap_svc.SoapStub.TranslateResponse.class.equals(type)) {

                return com.microsofttranslator.api.v1.soap_svc.SoapStub.TranslateResponse.Factory.
                        parse(param.getXMLStreamReaderWithoutCaching());


            }

            if (com.microsofttranslator.api.v1.soap_svc.SoapStub.GetLanguageNames.class.equals(type)) {

                return com.microsofttranslator.api.v1.soap_svc.SoapStub.GetLanguageNames.Factory.
                        parse(param.getXMLStreamReaderWithoutCaching());


            }

            if (com.microsofttranslator.api.v1.soap_svc.SoapStub.GetLanguageNamesResponse.class.
                    equals(type)) {

                return com.microsofttranslator.api.v1.soap_svc.SoapStub.GetLanguageNamesResponse.Factory.
                        parse(param.getXMLStreamReaderWithoutCaching());


            }

            if (com.microsofttranslator.api.v1.soap_svc.SoapStub.GetLanguages.class.equals(type)) {

                return com.microsofttranslator.api.v1.soap_svc.SoapStub.GetLanguages.Factory.parse(param.
                        getXMLStreamReaderWithoutCaching());


            }

            if (com.microsofttranslator.api.v1.soap_svc.SoapStub.GetLanguagesResponse.class.equals(
                    type)) {

                return com.microsofttranslator.api.v1.soap_svc.SoapStub.GetLanguagesResponse.Factory.
                        parse(param.getXMLStreamReaderWithoutCaching());


            }

        } catch (java.lang.Exception e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
        return null;
    }
}
   