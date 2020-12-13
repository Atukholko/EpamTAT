package com.epam.framework.test;

import com.epam.framework.model.User;
import com.epam.framework.page.MainPage;
import com.epam.framework.service.UserCreator;
import org.testng.Assert;
import org.testng.annotations.Test;


public class UserAccessTests extends CommonConditions{

    @Test
    public void oneCanSignIn() {
        User testUser = UserCreator.withCredentialsFromProperty();
        String  loggedInUserEmail = new MainPage(driver)
                .openPage()
                .signIn(testUser)
                .getCurrentUserEmail();
        Assert.assertEquals(loggedInUserEmail, testUser.getEmail());
    }

}
