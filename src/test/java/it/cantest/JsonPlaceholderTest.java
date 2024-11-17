package it.cantest;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class JsonPlaceholderTest {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }

    @Test
    public void verifyPostsEndpoint() {
        given()
                .filter(new AllureRestAssured())
                .when()
                .get("/posts/1")
                .then()
                .statusCode(200)
                .body("userId", equalTo(1))
                .body("id", equalTo(1))
                .body("title", notNullValue())
                .body("body", notNullValue());
    }

    @Test
    public void verifyCommentsEndpoint() {
        given()
                .filter(new AllureRestAssured())
                .when()
                .get("/comments/1")
                .then()
                .statusCode(200)
                .body("postId", equalTo(1))
                .body("id", equalTo(1))
                .body("name", notNullValue())
                .body("email", notNullValue())
                .body("body", notNullValue());
    }

    @Test
    public void verifyAlbumsEndpoint() {
        given()
                .filter(new AllureRestAssured())
                .when()
                .get("/albums/1")
                .then()
                .statusCode(200)
                .body("userId", equalTo(1))
                .body("id", equalTo(1))
                .body("title", notNullValue());
    }

    @Test
    public void verifyPhotosEndpoint() {
        given()
                .filter(new AllureRestAssured())
                .when()
                .get("/photos/1")
                .then()
                .statusCode(200)
                .body("albumId", equalTo(1))
                .body("id", equalTo(1))
                .body("title", notNullValue())
                .body("url", notNullValue())
                .body("thumbnailUrl", notNullValue());
    }

    @Test
    public void verifyTodosEndpoint() {
        given()
                .filter(new AllureRestAssured())
                .when()
                .get("/todos/1")
                .then()
                .statusCode(200)
                .body("userId", equalTo(1))
                .body("id", equalTo(1))
                .body("title", notNullValue())
                .body("completed", notNullValue());
    }

    @Test
    public void verifyUsersEndpoint() {
        given()
                .filter(new AllureRestAssured())
                .when()
                .get("/users/1")
                .then()
                .statusCode(200)
                .body("id", equalTo(1))
                .body("name", notNullValue())
                .body("username", notNullValue())
                .body("email", notNullValue())
                .body("address", notNullValue())
                .body("phone", notNullValue())
                .body("website", notNullValue())
                .body("company", notNullValue());
    }
}
