package ui.steps;
import com.codeborne.selenide.Condition;
import ui.elements.LoginElements;
import utils.EnvProperties;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
public class LoginPage extends LoginElements{
    public LoginPage openLoginPage() {
        open(EnvProperties.BASE_URL);
        return new LoginPage();
    }

    public <T> T loginByUser(String username, String password, Class<T> clazz) throws InvocationTargetException, InstantiationException, IllegalAccessException {
        userField().shouldBe(visible).sendKeys(username);
        passwordField().sendKeys(password);
        signInButton().click();

        T instance = null;
        Constructor<T>[] constructors = (Constructor<T>[]) clazz.getDeclaredConstructors();
        Constructor<T> constructor = null;
        for (Constructor cstr : constructors) {
            //Only if default constructor
            if (cstr.getParameters().length == 0) {
                constructor = (Constructor<T>) cstr;
                break;
            }
        }
        if (constructor != null) {
            constructor.setAccessible(true);
            instance = constructor.newInstance();
        }

        return instance;
    }

    public LoginPage assertLoginPageIsOpened() {
        loginPage().shouldBe(Condition.visible);
        return this;
    }
}
