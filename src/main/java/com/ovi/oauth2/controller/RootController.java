package com.ovi.oauth2.controller;

import java.security.Principal;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ovi.oauth2.utility.RestMsg;

@RestController
public class RootController {
	
    @GetMapping("/")
    public RestMsg hello(){
    	return new RestMsg("Hello World!");
    }

    @GetMapping("/api/test")
    public RestMsg apitest(){
    	return new RestMsg("Hello apiTest!");
    }

    @GetMapping(value = "/api/hello", produces = "application/json")
    public RestMsg helloUser(){
    	// The authenticated user can be fetched using the SecurityContextHolder
    	String username = SecurityContextHolder.getContext().getAuthentication().getName();
    	return new RestMsg(String.format("Hello '%s'!", username));
    }

    @GetMapping("/api/admin")
    // If a controller request asks for the Principal user in
    // the method declaration Spring security will provide it.
    public RestMsg helloAdmin(Principal principal){
    	return new RestMsg(String.format("Welcome '%s'!", principal.getName()));
    }
    
    
    // test method security
    //@Secured annotation is used to specify a list of roles on a method
    // Both @PreAuthorize and @PostAuthorize annotations provide expression-based access control.
    
    @Secured("ROLE_USER")					
    //@PreAuthorize("hasRole('USER')")
    @GetMapping("/api/testUser")
    public String testUser(){
    	return "Test User";
    }

}
