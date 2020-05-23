package DataMining.task2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class SortByValue {
    public static void sortByValue() throws IOException {
        FileWriter fileWriter = new FileWriter("tabl.csv");
        HashMap map = ReadExel.read();
        List<Map.Entry<String, Integer>> list =

                new LinkedList<Map.Entry<String, Integer>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2) {
                return (o1.getValue()).compareTo(o2.getValue());
            }

        });
        HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }

        for (Map.Entry<String, Integer> en : temp.entrySet()) {
            fileWriter.write(en.getKey() +
                    ";" + en.getValue() + "\n");

        }
        fileWriter.close();
    }
}

