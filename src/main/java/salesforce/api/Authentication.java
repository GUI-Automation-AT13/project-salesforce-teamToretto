/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package salesforce.api;

import static io.restassured.RestAssured.given;

import core.config.EnvConfig;
import salesforce.api.entities.Token;

/**
 * This class builds a token.
 */
public final class Authentication {

    public static Token token;

    /**
     * Sets the salesforce token.
     */
    public static void getAuth() {
        EnvConfig.getInstance();
        token = given().urlEncodingEnabled(true)
                .param("username", EnvConfig.getInstance().getAdminUser().getUsername())
                .param("password", EnvConfig.getInstance().getAdminUser().getPassword())
                .param("client_id", EnvConfig.getInstance().getClientId())
                .param("client_secret", EnvConfig.getInstance().getClientSecret())
                .param("grant_type", "password")
                .header("Accept", "application/json")
                .header("Content-Type", "application/x-www-form-urlencoded")
                .log().all()
                .when()
                .post(EnvConfig.getInstance().getLoginApi())
                .as(Token.class);
    }
}
