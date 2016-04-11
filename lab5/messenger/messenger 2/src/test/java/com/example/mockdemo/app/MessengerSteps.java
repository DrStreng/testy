package com.example.mockdemo.app;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.either;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import com.example.mockdemo.messenger.MessageService;
import com.example.mockdemo.messenger.MessageServiceSimpleImpl;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class MessengerSteps {

//    private static final String VALID_SERVER = "inf.ug.edu.pl";
//    private static final String INVALID_SERVER = "inf.ug.edu.eu";
//
//    private static final String VALID_MESSAGE = "some message";
//    private static final String INVALID_MESSAGE = "ab";

    private String testServer;
    private String testMessage;

    private Messenger messenger;
    private MessageService message;

    @Given("a messenger")
    public void setUp(){
    	messenger = new Messenger(new MessageServiceSimpleImpl());
    }

    @When("test connect VALID_SERVER")
    public void serverValid(){
        testServer = "inf.ug.edu.pl";
    }
    
    @When("test connect INVALID_SERVER")
    public void serverInvalid(){
        testServer = "inf.ug.edu.eu";
    }
    
    @Then("connection return $var")
    public void checkServerTestValid(int var){
        assertEquals(var, messenger.testConnection(testServer));
    }
    
    @When("test message is VALID_MESSAGE")
    public void messageValid(){
    	testMessage = "some message";
    }
    
    @When("test message is INVALID_MESSAGE")
    public void messageInvalid(){
    	testMessage = "ab";
    }
    
    @Then("send message return $var1 or $var2")
    public void checkMessageTestValid(int var1, int var2){
    	assertThat(messenger.sendMessage("inf.ug.edu.pl", testMessage), either(equalTo(var1)).or(equalTo(var2)));
    }
    
    @Then("send message return $var1")
    public void checkMessageTestValid(int var1){
    	assertEquals(var1, messenger.sendMessage("inf.ug.edu.pl", testMessage));
    }

    

   
    
}
    
    
    


