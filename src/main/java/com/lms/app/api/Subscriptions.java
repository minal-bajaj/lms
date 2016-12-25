/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lms.app.api;

import com.lms.app.data.subscription.SubscriptionOrder;
import com.lms.app.data.subscription.SubscriptionOrderStatus;
import com.lms.app.db.dao.SubscriptionDAO;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author Minal
@ */
@Path("/subscription")
public class Subscriptions {
    
    private final static String EVENT_URL = "url";
    private SubscriptionDAO subscriptionDAO;

    public Subscriptions() {
        subscriptionDAO = new SubscriptionDAO();
    }
    
    @Path("create")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(@Context UriInfo uriInfo) {

        // Request URL contains event url
        try {
            MultivaluedMap<String, String> queryParameters = uriInfo.getQueryParameters(true);
            String eventUrl = queryParameters.getFirst(EVENT_URL);

            Client client = ClientBuilder.newClient();
            WebTarget target = client.target(eventUrl);
            SubscriptionOrder subscriptionOrder = target.request(MediaType.APPLICATION_JSON).get(SubscriptionOrder.class);

            SubscriptionOrderStatus status = subscriptionDAO.create(subscriptionOrder);

            return Response.ok(status, MediaType.APPLICATION_JSON).build();
        } catch (Exception e) {
            String status = "{\"success\": false, \"reason\": \"%s\"}";
            return Response.ok(String.format(status, e.getMessage()), MediaType.TEXT_PLAIN).build();
        }
    }
    
    @Path("change")
    public Response change() {
        return null;
    }
    
    @Path("status")
    public Response status() {
        return Response.ok("success").build();
    }
    
    @Path("cancel")
    public Response cancel(@Context UriInfo uriInfo) {
        // Request URL contains event url
        MultivaluedMap<String, String> queryParameters = uriInfo.getQueryParameters(true);
        String eventUrl = queryParameters.getFirst(EVENT_URL);
        
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(eventUrl);
        SubscriptionOrder subscriptionOrder = target.request(MediaType.APPLICATION_JSON).get(SubscriptionOrder.class);
        
        SubscriptionOrderStatus cancel = subscriptionDAO.cancel(subscriptionOrder);
        
        return Response.ok(cancel, MediaType.APPLICATION_JSON).build();
    }
}