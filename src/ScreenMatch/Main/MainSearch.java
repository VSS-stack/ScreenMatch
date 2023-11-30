package ScreenMatch.Main;

import ScreenMatch.Template.Title;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class MainSearch {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner input = new Scanner(System.in);

        System.out.println("Write the name of the film:");
        var search = input.nextLine().replaceAll("\\s", "+"); //regex to change empty spaces to "+"

        /* Do a GET request */
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://www.omdbapi.com/?t=" + search + "&apikey=306f71f9"))
                .build();

        /* Handle the response */
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());

        Gson gson = new Gson();
        Title myTitle = gson.fromJson(response.body(), Title.class);
        System.out.println(myTitle);
    }
}
