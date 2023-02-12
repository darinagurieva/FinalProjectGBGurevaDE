package ApiTest;

import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import org.apache.http.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;


public class FeedPages extends InitTest {

    @Test
    @Story("Мои посты - Валидные креды")
    void getTest_1() {
        given()
                .queryParam("sort", "createdAt")
                .queryParam("order", "ASC")
                .queryParam("page", "1")
                .when()
                .header("X-Auth-Token", "99530f37840ca98dba40f6f7dcbb7bb6")
                .get("https://test-stand.gb.ru/api/posts")
                .then()
                .statusCode(200);
        }

        @Test
        @Story("Мои посты - Без токена")
        void getTest_2() {
        given()
                .queryParam("sort", "createdAt")
                .queryParam("order", "ASC")
                .queryParam("page", "1")
                .when()
                .get("https://test-stand.gb.ru/api/posts")
                .then()
                .statusCode(401);
    }

    @Test
    @Story("Мои посты - page = 2")
    void getTest_3() {
        given()
                .queryParam("sort", "createdAt")
                .queryParam("order", "ASC")
                .queryParam("page", "2")
                .when()
                .header("X-Auth-Token", "99530f37840ca98dba40f6f7dcbb7bb6")
                .get("https://test-stand.gb.ru/api/posts")
                .then()
                .statusCode(200);
    }

    @Test
    @Story("Мои посты - order = desc")
    void getTest_4() {
        given()
                .queryParam("sort", "createdAt")
                .queryParam("order", "DESC")
                .queryParam("page", "1")
                .when()
                .header("X-Auth-Token", "99530f37840ca98dba40f6f7dcbb7bb6")
                .get("https://test-stand.gb.ru/api/posts")
                .then()
                .statusCode(200);
    }

    @Test
    @Story("Мои посты - page = null")
    void getTest_5() {
        given()
                .queryParam("sort", "createdAt")
                .queryParam("order", "DESC")
                .queryParam("page", "null")
                .when()
                .header("X-Auth-Token", "99530f37840ca98dba40f6f7dcbb7bb6")
                .get("https://test-stand.gb.ru/api/posts")
                .then()
                .statusCode(404);
    }

    @Test
    @Story("Чужие посты - Валидные креды")
    void getTest_6() {
        given()
                .queryParam("owner", "notMe")
                .queryParam("sort", "createdAt")
                .queryParam("order", "ASC")
                .queryParam("page", "1")
                .when()
                .header("X-Auth-Token", "99530f37840ca98dba40f6f7dcbb7bb6")
                .get("https://test-stand.gb.ru/api/posts")
                .then()
                .statusCode(200);
    }

    @Test
    @Story("Чужие посты - Без токена")
    void getTest_7() {
        given()
                .queryParam("owner", "notMe")
                .queryParam("sort", "createdAt")
                .queryParam("order", "ASC")
                .queryParam("page", "1")
                .when()
                .get("https://test-stand.gb.ru/api/posts")
                .then()
                .statusCode(401);
    }

    @Test
    @Story("Чужие посты - page=2")
    void getTest_8() {
        given()
                .queryParam("owner", "notMe")
                .queryParam("sort", "createdAt")
                .queryParam("order", "ASC")
                .queryParam("page", "2")
                .when()
                .header("X-Auth-Token", "99530f37840ca98dba40f6f7dcbb7bb6")
                .get("https://test-stand.gb.ru/api/posts")
                .then()
                .statusCode(200);
    }

    @Test
    @Story("Чужие посты - order=DESC")
    void getTest_9() {
        given()
                .queryParam("owner", "notMe")
                .queryParam("sort", "createdAt")
                .queryParam("order", "DESC")
                .queryParam("page", "1")
                .when()
                .header("X-Auth-Token", "99530f37840ca98dba40f6f7dcbb7bb6")
                .get("https://test-stand.gb.ru/api/posts")
                .then()
                .statusCode(200);
    }

    @Test
    @Story("Чужие посты - Page=null")
    void getTest_10() {
        given()
                .queryParam("owner", "notMe")
                .queryParam("sort", "createdAt")
                .queryParam("order", "ASC")
                .queryParam("page", "null")
                .when()
                .header("X-Auth-Token", "99530f37840ca98dba40f6f7dcbb7bb6")
                .get("https://test-stand.gb.ru/api/posts")
                .then()
                .statusCode(404);
    }
}