/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package salesforce.api;

import static io.restassured.RestAssured.given;

import core.utils.PropertiesReader;
import java.util.Properties;
import salesforce.api.entities.Token;

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
                .when()
                .post(properties.getProperty("LOGIN"))
                .as(Token.class);
    }
}
