package github.com;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.jbehave.core.annotations.*;


import java.io.IOException;

import static org.junit.Assert.*;

public class Statuscode {

    private String api;
    private int statusCode;

    @Given("a github user profile api")
    public void givenAGithubUserProfileApi() {
        api = "https://api.github.com/users/%s";
    }

    @When("I search for a user <user> via the api")
    public void whenISearchForAUseruserViaTheApi(@Named("user") String user) throws IOException {
        statusCode = getGithubUserProfile(this.api, user)
                .getStatusLine()
                .getStatusCode();
    }

    @Then("I should get status code as <statuscode>")
    public void thenIShouldGetStatusCodeAsstatuscode(@Named("statuscode") int statuscode) {
        assertTrue(this.statusCode == statuscode);
    }

    static HttpResponse getGithubUserProfile(String api, String username) throws IOException{
        HttpUriRequest request = new HttpGet(String.format(api, username));
        return HttpClientBuilder
                .create()
                .build()
                .execute(request);
    }
}
