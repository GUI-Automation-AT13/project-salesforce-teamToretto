/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package core.api;

/**
 * This enum defines possible SalesForce Methods.
 */
public enum ApiMethod {
    POST("POST"),
    DELETE("DELETE"),
    PATCH("PATCH");

    private String name;

    ApiMethod(final String newName) {
        this.name = newName;
    }

    /**
     * Gets the api method.
     *
     * @return the request method.
     */
    public String toName() {
        return name;
    }
}
