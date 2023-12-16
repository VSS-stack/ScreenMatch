package ScreenMatch.Main;

import ScreenMatch.Exception.YearConversionException;
import ScreenMatch.Template.Title;
import ScreenMatch.Template.TitleOmbd;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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

        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();
        TitleOmbd myTitleOmdb = gson.fromJson(response.body(), TitleOmbd.class);
        System.out.println(myTitleOmdb);

        try {
            Title myTitle = new Title(myTitleOmdb);
            System.out.println("Converted title:");
            System.out.println(myTitle);
        } catch (NumberFormatException e) {
            System.out.println("An error occurred: " + e.getMessage());
        } catch (YearConversionException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
