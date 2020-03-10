package github.com;

import org.apache.http.entity.ContentType;
import org.jbehave.core.annotations.*;

import java.io.IOException;

import static github.com.Statuscode.getGithubUserProfile;
import static org.junit.Assert.assertEquals;

public class MediaType {
    private String api;
    private String mediatype;


    @Given("github profile")
    public void givenGithubProfile() {
        api = "https://api.github.com/users/%s";
    }

    @When("I searche for a user as <user>")
    public void whenISearcheForAUserAsuser(@Named("user") String user) throws IOException {
        mediatype = ContentType
                .getOrDefault(getGithubUserProfile(api, user).getEntity())
                .getMimeType();
    }

    @Then("github respond data of type json <json>")
    public void thenGithubRespondDataOfTypeJsonjson(@Named("json") String json) {
        assertEquals(json,mediatype );
    }

}
