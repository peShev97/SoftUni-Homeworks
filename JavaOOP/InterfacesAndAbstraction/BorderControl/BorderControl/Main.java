package InterfacesAndAbstraction.BorderControl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Identifiable> allObjects = new ArrayList<>();

        String command = "";

        while (!"End".equals(command=reader.readLine())) {
            String[] info = command.split("\\s+");

            switch (info.length) {
                case 2:
                    allObjects.add(new Robot(info[0], info[1]));
                    break;
                case 3:
                    allObjects.add(new Citizen(info[0], Integer.parseInt(info[1]), info[2]));
                    break;
            }
        }

        List<String> fakeIDs = new ArrayList<>();

        String searchedID = reader.readLine();

        for (Identifiable object : allObjects) {
            if (object.getId().substring(object.getId().length() - searchedID.length()).equals(searchedID)) {
                fakeIDs.add(object.getId());
            }
        }

        for (String fakeID : fakeIDs) {
            System.out.println(fakeID);
        }
    }
}