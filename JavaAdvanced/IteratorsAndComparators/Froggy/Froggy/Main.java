package IteratorsAndComparators.Froggy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] nums = Arrays.stream(reader.readLine().split(", +")).mapToInt(Integer::parseInt).toArray();

        Lake lake = new Lake(nums);

        List<Integer> output = new ArrayList<>();

        for (Integer integer : lake) {
            output.add(integer);
        }

        String asd = output.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));

        System.out.println(asd);
    }
}
