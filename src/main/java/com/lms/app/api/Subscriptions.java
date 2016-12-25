/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lms.app.api;

import com.lms.app.data.subscription.SubscriptionOrder;
import com.lms.app.data.subscription.SubscriptionOrderStatus;
import com.lms.app.db.dao.SubscriptionDAO;
import com.lms.app.oauth.OAuthSigner;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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
            
            /**boolean verify = new OAuthSigner().verify(servletRequest);
            
            if (!verify) {
                return Response.status(Response.Status.UNAUTHORIZED).build();
            }*/
            
            MultivaluedMap<String, String> queryParameters = uriInfo.getQueryParameters(true);
            String eventUrl = queryParameters.getFirst(EVENT_URL);

            SubscriptionOrder subscriptionOrder = new OAuthSigner().sendSignedRequest(eventUrl);

            SubscriptionOrderStatus status = subscriptionDAO.create(subscriptionOrder);

            return Response.ok(status, MediaType.APPLICATION_JSON).build();
        } catch (Exception e) {
            String status = "{\"success\": false, \"reason\": \"%s\", \"stack\": \"%s\"";
            return Response.ok(String.format(status, e.getClass().getName(), ""), MediaType.TEXT_PLAIN).build();
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
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response cancel(@Context UriInfo uriInfo) {
        try {
            
            /**boolean verify = new OAuthSigner().verify(servletRequest);
            
            if (!verify) {
                return Response.status(Response.Status.UNAUTHORIZED).build();
            }*/
            
            // Request URL contains event url
            MultivaluedMap<String, String> queryParameters = uriInfo.getQueryParameters(true);
            String eventUrl = queryParameters.getFirst(EVENT_URL);

            SubscriptionOrder subscriptionOrder = new OAuthSigner().sendSignedRequest(eventUrl);

            SubscriptionOrderStatus cancel = subscriptionDAO.cancel(subscriptionOrder);

            return Response.ok(cancel, MediaType.APPLICATION_JSON).build();
        } catch (Exception e) {
            String status = "{\"success\": false, \"reason\": \"%s\"}";
            return Response.ok(String.format(status, e.getMessage()), MediaType.TEXT_PLAIN).build();
        }
    }
}