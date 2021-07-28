package api.salesforce;

import api.salesforce.entities.Token;
import core.utils.PropertiesReader;
import java.util.Properties;

import static io.restassured.RestAssured.given;

/**
 * This class builds a token.
 */
public class Authentication {

    public static Token token;

    /**
     * Sets the salesforce token.
     */
    public void getAuth() {
        Properties properties = PropertiesReader.getProperties("config.properties");
        token = given().urlEncodingEnabled(true)
                .param("username", properties.getProperty("user"))
                .param("password", properties.getProperty("password"))
                .param("client_id", properties.getProperty("CLIENT_ID"))
                .param("client_secret", properties.getProperty("CLIENT_SECRET"))
                .param("grant_type", "password")
                .header("Accept", "application/json")
                .header("Content-Type", "application/x-www-form-urlencoded")
                .log().all()
                .when().
                        post(properties.getProperty("LOGIN"))
                .as(Token.class);
    }
}
