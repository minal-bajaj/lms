/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lms.app.oauth;

import com.lms.app.data.subscription.SubscriptionOrder;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Feature;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import org.glassfish.jersey.client.oauth1.ConsumerCredentials;
import org.glassfish.jersey.client.oauth1.OAuth1ClientSupport;
import org.glassfish.jersey.jackson.JacksonFeature;

/**
 *
 * @author Minal
 */
public class OAuthSigner {
    
    public MultivaluedMap<String, String> sendSignedRequest(String url) {
        
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
        
        return request.get(MultivaluedMap.class);
    }
    
    public static void main(String[] args) {
        new OAuthSigner().sendSignedRequest("https://appdirectlms.herokuapp.com/Fevent/createInfo");
    }
}
