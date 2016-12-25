/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lms.app.oauth;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import org.glassfish.jersey.oauth1.signature.OAuth1Request;

/**
 *
 * @author Minal
 */
public class ConcreteOAuthRequest implements OAuth1Request {

    private HttpServletRequest servletRequest;
    
    public ConcreteOAuthRequest(HttpServletRequest servletRequest) {
        this.servletRequest = servletRequest;
    }

    @Override
    public String getRequestMethod() {
        return this.servletRequest.getMethod();
    }

    @Override
    public URL getRequestURL() {
        try {
            return new URL(this.servletRequest.getRequestURL().toString());
        } catch (MalformedURLException ex) {
            ex.printStackTrace();
        }
        
        return null;
    }

    @Override
    public Set<String> getParameterNames() {
        Set<String> parameterNames = new HashSet<>();
        
        Enumeration<String> parameters = this.servletRequest.getParameterNames();
        
        while (parameters.hasMoreElements()) {
            parameterNames.add(parameters.nextElement());
        }
        
        return parameterNames;
    }

    @Override
    public List<String> getParameterValues(String string) {
        return Arrays.asList(this.servletRequest.getParameterValues(string));
    }

    @Override
    public List<String> getHeaderValues(String string) {
        List<String> headers = new ArrayList<>();
        
        Enumeration<String> parameters = this.servletRequest.getHeaders(string);
        
        while (parameters.hasMoreElements()) {
            headers.add(parameters.nextElement());
        }
        
        return headers;
    }

    @Override
    public void addHeaderValue(String string, String string1) throws IllegalStateException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
