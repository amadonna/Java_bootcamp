package org;

import annotations.HtmlForm;
import annotations.HtmlInput;

@HtmlForm(filename = "user_from.html", action = "/users", method = "post")
public class UserForm {
    @HtmlInput(type = "text", name = "firs_name", placeholder = "Enter First Name")
    private String firstName;
    @HtmlInput(type = "text", name = "last_name", placeholder = "Enter Last Name")
    private String lastName;
    @HtmlInput(type = "password", name = "password", placeholder = "Enter Password")
    private String password;

}
