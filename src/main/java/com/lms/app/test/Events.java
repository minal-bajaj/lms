/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lms.app.test;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author Minal
 */
@Path("/event")
public class Events {
    
    @Path("createInfo")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCreateInfo(@Context HttpHeaders httpHeaders) {
        
        MultivaluedMap<String, String> headerMap = httpHeaders.getRequestHeaders();
        
        String eventInfo = "{\n" +
"    \"type\": \"SUBSCRIPTION_ORDER\",\n" +
"    \"marketplace\": {\n" +
"      \"baseUrl\": \"https://www.acme.com\",\n" +
"      \"partner\": \"APPDIRECT\"\n" +
"    },\n" +
"    \"creator\": {\n" +
"      \"address\": {\n" +
"        \"firstName\": \"Sample\",\n" +
"        \"fullName\": \"Sample Tester\",\n" +
"        \"lastName\": \"Tester\"\n" +
"      },\n" +
"      \"email\": \"testuser@testco.com\",\n" +
"      \"firstName\": \"Sample\",\n" +
"      \"language\": \"en\",\n" +
"      \"lastName\": \"Tester\",\n" +
"      \"locale\": \"en_US\",\n" +
"      \"openId\": \"https://www.acme.com/openid/id/211aa367-f53b-4606-8887-80a381e0ef69\",\n" +
"      \"uuid\": \"211aa369-f53b-4606-8887-80a361e0ef66\"\n" +
"    },\n" +
"    \"payload\": {\n" +
"      \"company\": {\n" +
"        \"country\": \"US\",\n" +
"        \"name\": \"Sample Testing co.\",\n" +
"        \"uuid\": \"bd58b532-323b-4627-a828-57729489b27b\",\n" +
"        \"website\": \"www.testerco.com\"\n" +
"      },\n" +
"      \"order\": {\n" +
"        \"editionCode\": \"FREE\",\n" +
"        \"pricingDuration\": \"MONTHLY\"\n" +
"      }\n" +
"    }\n" +
"    }";
        
        return Response.ok(headerMap, MediaType.APPLICATION_JSON).build();
    }
    
    @Path("cancelInfo")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCancelInfo() {
        
     String eventInfo = "{\n" +
"    \"type\": \"SUBSCRIPTION_CHANGE\",\n" +
"    \"marketplace\": {\n" +
"      \"baseUrl\": \"https://www.acme.com\",\n" +
"      \"partner\": \"APPDIRECT\"\n" +
"    },\n" +
"    \"creator\": {\n" +
"      \"address\": {\n" +
"        \"city\": \"San Jose\",\n" +
"        \"country\": \"US\",\n" +
"        \"firstName\": \"Test\",\n" +
"        \"fullName\": \"Test User\",\n" +
"        \"lastName\": \"User\",\n" +
"        \"state\": \"CA\",\n" +
"        \"street1\": \"1 Main St\",\n" +
"        \"zip\": \"95131\"\n" +
"      },\n" +
"      \"email\": \"testuser@testco.com\",\n" +
"      \"firstName\": \"Test\",\n" +
"      \"language\": \"en\",\n" +
"      \"lastName\": \"User\",\n" +
"      \"locale\": \"en_US\",\n" +
"      \"openId\": \"https://www.acme.com/openid/id/7f59aad1-85cd-4c04-b35b-906ee53acc71\",\n" +
"      \"uuid\": \"7f59aad1-85cd-4c04-b35b-906ee53acc71\"\n" +
"    },\n" +
"    \"payload\": {\n" +
"      \"account\": {\n" +
"        \"accountIdentifier\": \"1\",\n" +
"        \"status\": \"ACTIVE\"\n" +
"      },\n" +
"      \"order\": {\n" +
"        \"editionCode\": \"DME\",\n" +
"        \"pricingDuration\": \"DAILY\",\n" +
"        \"items\": [{\n" +
"          \"quantity\": \"0\",\n" +
"          \"unit\": \"GIGABYTE\"\n" +
"        }]\n" +
"      }\n" +
"    }\n" +
"    }";
        
        return Response.ok(eventInfo, MediaType.APPLICATION_JSON).build();
    }
}