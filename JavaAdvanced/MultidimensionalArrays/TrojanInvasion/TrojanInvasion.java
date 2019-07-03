import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class TrojanInvasion {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int waves = Integer.parseInt(reader.readLine());

        List<Integer> plates = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<List<Integer>> warriors = new ArrayList<>();

        boolean isBrakeNeeded = false;
        warriors.add(Arrays.stream(reader.readLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList()));
        for (int i = 0; i < waves; i++) {
            if ((i + 1) % 3 == 0) {
                plates.add(Integer.parseInt(reader.readLine()));
            }

            for (int j = warriors.get(i).size() - 1; j >= 0; j--) {
                if (plates.size() == 0) {
                    for (int k = i + 1; k < warriors.size(); k++) {
                        warriors.remove(k);
                        k--;
                    }
                    isBrakeNeeded = true;
                    break;
                }

                if (warriors.get(i).get(j) > plates.get(0)) {
                    warriors.get(i).set(j, warriors.get(i).get(j) - plates.get(0));
                    plates.remove(0);
                    j++;
                } else if (warriors.get(i).get(j) < plates.get(0)) {
                    plates.set(0, plates.get(0) - warriors.get(i).get(j));
                    warriors.get(i).remove(j);
                } else {
                    warriors.get(i).remove(j);
                    plates.remove(0);
                }
            }

            if (i == waves - 1) {
                break;
            }

            if (warriors.get(i).size() == 0) {
                warriors.add(Arrays.stream(reader.readLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList()));
            } else {
                i--;
            }

            if (isBrakeNeeded) {
                break;
            }
        }

        for (int i = 0; i < warriors.size(); i++) {
            if (warriors.get(i).size() == 0) {
                warriors.remove(i);
                i--;
            }
        }

        if (warriors.size() == 0) {
            System.out.println("The Spartans successfully repulsed the Trojan attack.");
            System.out.print("Plates left: ");
            System.out.println(plates.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        } else {
            System.out.println("The Trojans successfully destroyed the Spartan defense.");
            System.out.print("Warriors left: ");
            Collections.reverse(warriors.get(0));
            System.out.println(warriors.get(0).stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }
    }
}