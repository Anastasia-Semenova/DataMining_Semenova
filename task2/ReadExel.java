package DataMining.task2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class ReadExel {
    public static HashMap read() throws FileNotFoundException {
        File file = new File("src/DataMining/task2/transactions.csv");
        Scanner scanner = new Scanner(file);
        HashMap<String, Integer> bd = new HashMap<>();
        scanner.nextLine();
        while (scanner.hasNextLine()) {
            String string = scanner.next();
            String[] st = string.split(";");
            if (!bd.containsKey(st[0])) {
                bd.put(st[0], 0);
            } else {
                bd.put(st[0], bd.get(st[0]) + 1);
            }
            scanner.nextLine();
        }

        scanner.close();
        return bd;
    }
}
