/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lms.app.oauth;

import com.lms.app.data.subscription.SubscriptionOrder;
//import javax.inject.Inject;
//import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Feature;
import javax.ws.rs.core.MediaType;
import org.glassfish.jersey.client.oauth1.ConsumerCredentials;
import org.glassfish.jersey.client.oauth1.OAuth1ClientSupport;
import org.glassfish.jersey.jackson.JacksonFeature;
/*import org.glassfish.jersey.oauth1.signature.OAuth1Parameters;
import org.glassfish.jersey.oauth1.signature.OAuth1Request;
import org.glassfish.jersey.oauth1.signature.OAuth1Secrets;
import org.glassfish.jersey.oauth1.signature.OAuth1Signature;
import org.glassfish.jersey.oauth1.signature.OAuth1SignatureException;*/

/**
 *
 * @author Minal
 */
public class OAuthSigner {
    
    //@Inject
    //OAuth1Signature oAuthSignature;
    
    public SubscriptionOrder sendSignedRequest(String url) {
        
        final ConsumerCredentials consumerCredentials = new ConsumerCredentials(
                "leave-management-system-145694",
                "vsFEplriw6xWJ4Si");
        
        final Feature filterFeature = OAuth1ClientSupport.builder(consumerCredentials).feature().build();
        
        final Client client = ClientBuilder.newBuilder()
                .register(filterFeature)
                .register(JacksonFeature.class)
                .build();
    
        WebTarget target = client.target(url);
        
        Invocation.Builder request = target.request(MediaType.APPLICATION_JSON);
        
        return request.get(SubscriptionOrder.class);
    }
    
    /*public boolean verify(HttpServletRequest servletRequest) {
        try {
            OAuth1Request request = new ConcreteOAuthRequest(servletRequest);
            
            OAuth1Parameters params = new OAuth1Parameters().consumerKey("leave-management-system-145694")
                    .signatureMethod("HMAC-SHA1").version();
            
            OAuth1Secrets secrets = new OAuth1Secrets().consumerSecret("vsFEplriw6xWJ4Si");
            
            return oAuthSignature.verify(request, params, secrets);
        } catch (OAuth1SignatureException ex) {
            ex.printStackTrace();
        }
        
        return false;
    }*/
}