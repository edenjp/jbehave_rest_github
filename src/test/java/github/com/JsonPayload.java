package github.com;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.When;
import org.jbehave.core.annotations.Then;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import static github.com.Statuscode.getGithubUserProfile;
import static org.junit.Assert.*;

public class JsonPayload {

    private String api;
    HttpResponse response;
    private String result;

    @Given("github profile from user")
    public void givenGithubProfile() {
        this.api = "https://api.github.com/users/%s";
    }

    @When("I search for a user as <user>")
    public void whenISearcheForAUserAsuser(@Named("user") String user) throws IOException {
        this.response = getGithubUserProfile(api, user);
    }

    @Then("I should get the response with the same username <username>")
    public void thenIShouldGetTheResponseWithTheSameUsernameusername(@Named("username") String username) throws IOException {
        this.result = getJsonToString();
        assertTrue(this.result.contains(username));
    }

    @Then("the id <id> of the user")
    public void thenTheIdidOfTheUser(@Named("id") long id) {
        assertTrue(this.result.contains(Long.toString(id)));
    }

    private String getJsonToString () throws IOException {
        HttpEntity entity = this.response.getEntity();
        InputStream instream = entity.getContent();
        BufferedReader reader = new BufferedReader(new InputStreamReader(instream));

        StringBuilder content = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null){
            content.append(line);
        }
        return content.toString();
    }
}
