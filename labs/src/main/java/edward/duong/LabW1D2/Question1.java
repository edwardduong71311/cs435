package edward.duong.LabW1D2;

import java.util.*;

public class Question1 {
    public static void main(String[] args) {
        algorithm1(Arrays.asList(7, 20, 18, 4, 20, 19, 20, 3));
        algorithm1(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));

        System.out.println();
        algorithm2(Arrays.asList(7, 20, 18, 4, 20, 19, 20, 3));
        algorithm2(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));

        System.out.println();
        algorithm3(Arrays.asList(7, 20, 18, 4, 20, 19, 20, 3));
        algorithm3(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
    }

    private static void algorithm1(List<Integer> data) {
        List<Integer> avoids = new ArrayList<>();

        int firstMax = -1;
        int firstMaxIndex = -1;
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i) > firstMax) {
                firstMax = data.get(i);
                firstMaxIndex = i;
            }
        }
        avoids.add(firstMaxIndex);

        int secondMax = -1;
        int secondMaxIndex = -1;
        for (int i = 0; i < data.size(); i++) {
            if (avoids.contains(i)) {
                continue;
            }

            if (data.get(i) > secondMax) {
                secondMax = data.get(i);
                secondMaxIndex = i;
            }
        }
        avoids.add(secondMaxIndex);

        int thirdMax = -1;
        for (int i = 0; i < data.size(); i++) {
            if (avoids.contains(i)) {
                continue;
            }

            if (data.get(i) > thirdMax) {
                thirdMax = data.get(i);
            }
        }

        System.out.println(firstMax + " " + secondMax + " " + thirdMax);
    }

    private static void algorithm2(List<Integer> data) {
        int max = -1;
        int preMax = -1;
        int prePreMax = -1;

        for (Integer num : data) {
            if (num > max) {
                prePreMax = preMax;
                preMax = max;
                max = num;
            } else if (num > preMax) {
                prePreMax = preMax;
                preMax = num;
            } else if (num > prePreMax) {
                prePreMax = num;
            }
        }

        System.out.println(max + " " + preMax + " " + prePreMax);
    }

    private static void algorithm3(List<Integer> data) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : data) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> sorted = new ArrayList<>(map.entrySet());
        sorted.sort((a, b) -> b.getKey().compareTo(a.getKey()));

        int count = 3;
        int index = 0;
        while (count > 0) {
            System.out.println(sorted.get(index).getKey());
            if (sorted.get(index).getValue() > 1) {
                sorted.get(index).setValue(sorted.get(index).getValue() - 1);
            } else if (sorted.get(index).getValue() == 1) {
                index += 1;
            }
            count -= 1;
        }
    }
}
