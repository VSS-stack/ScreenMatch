package ScreenMatch.Main;

import ScreenMatch.Exception.YearConversionException;
import ScreenMatch.Template.Title;
import ScreenMatch.Template.TitleOmbd;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainSearch {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner input = new Scanner(System.in);
        String search = "";
        List<Title> titles = new ArrayList<>();

        /* Create a Gson object */
        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting() //Print the json in a more visual way
                .create();

        while (!search.equalsIgnoreCase("exit")) {
            System.out.println("Write the name of the film:");
            search = input.nextLine().replaceAll("\\s", "+"); //regex to change empty spaces to "+"

            /* Exit the loop */
            if (search.equalsIgnoreCase("exit")) {
                break;
            }

            /* Do a GET request */
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("http://www.omdbapi.com/?t=" + search + "&apikey=306f71f9"))
                    .build();

            /* Handle the response */
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());

            /* Transform the response into an object */
            TitleOmbd myTitleOmdb = gson.fromJson(response.body(), TitleOmbd.class);
            System.out.println(myTitleOmdb);

            try {
                /* Convert into a Title object */
                Title myTitle = new Title(myTitleOmdb);
                System.out.println("Converted title:");
                System.out.println(myTitle);

//                /* Write a file with the title atributes */
//                FileWriter newFile = new FileWriter("Movies.txt");
//                newFile.write(myTitle.toString());
//                newFile.close();

                /* Add title to list */
                titles.add(myTitle);

            } catch (NumberFormatException e) {
                System.out.println("An error occurred: " + e.getMessage());
            } catch (YearConversionException e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }
        System.out.println(titles);

        /* Write a file with a Json */
        FileWriter myFile = new FileWriter("Titles.json");
        myFile.write(gson.toJson(titles));
        myFile.close();

        System.out.println("The program ended correctly");
    }
}
