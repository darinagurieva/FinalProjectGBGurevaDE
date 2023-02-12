package ApiTest;

import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;


public class LoginTest extends InitTest {

    @Test
    @Story("Невалидные креды")
    void postTest1() {
        given()
                .contentType("application/x-www-form-urlencoded")
                .formParam("username", getNoValidLogin())
                .formParam("password", getNoValidPassword())
                .when()
                .post(getEndUrlOne())
                .then()
                .statusCode(401);

    }

    @Test
    @Story("Username must be provided")
    void postTest2() {
        String mess = given()
                .contentType("application/x-www-form-urlencoded")
                .formParam("Username", getNoValidLogin())
                .formParam("Password", getNoValidPassword())
                .when()
                .post(getEndUrlOne())
                .then().extract()
                .jsonPath()
                .get("message")
                .toString();
        assertThat(mess, equalTo("The key \"username\" must be provided."));

    }

    @Test
    @Story("Упавший тест")
    void zpostForFeil() {
        String mess = given()
                .contentType("application/x-www-form-urlencoded")
                .formParam("Username", getNoValidLogin())
                .formParam("Password", getNoValidPassword())
                .when()
                .post(getEndUrlOne())
                .then().extract()
                .jsonPath()
                .get("message")
                .toString();
        assertThat(mess, equalTo("The key \"username\" must be painted."));

    }
}