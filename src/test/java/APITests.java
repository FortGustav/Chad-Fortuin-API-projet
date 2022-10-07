import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.junit.Assert;
import org.junit.Test;
import static com.mashape.unirest.http.Unirest.*;


public class APITests {

    @Test
    public void API_TestGet() throws UnirestException {
        Unirest.setTimeouts(0, 0);
        HttpResponse<String> response = get("https://jsonplaceholder.typicode.com/posts")
                .asString();
        Assert.assertEquals(200, response.getStatus());
        System.out.println(response.getBody());

    }

    @Test
    public void API_TestGetId() throws UnirestException {
        Unirest.setTimeouts(0, 0);
        HttpResponse<String> response = get("https://jsonplaceholder.typicode.com/posts?id=11")
                .asString();
        Assert.assertEquals(200, response.getStatus());
        System.out.println(response.getBody());

    }

    @Test
    public void API_TestPost() throws UnirestException {
        Unirest.setTimeouts(0, 0);
        HttpResponse<String> response = Unirest.post("https://jsonplaceholder.typicode.com/posts")
                .field("title", "foo")
                .field("body", "bar")
                .field("userid", "1")
                .asString();
        Assert.assertEquals(201, response.getStatus());
        System.out.println(response.getBody());

    }

    @Test
    public void API_TestDelete() throws UnirestException {
        Unirest.setTimeouts(0, 0);
        HttpResponse<String> response = Unirest.delete("https://jsonplaceholder.typicode.com/posts")
                .field("title", "foo")
                .field("body", "bar")
                .field("userid", "1")
                .asString();
        Assert.assertEquals(404, response.getStatus());
        System.out.println(response.getBody());

    }

}
