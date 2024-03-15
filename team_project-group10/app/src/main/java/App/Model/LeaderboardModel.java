package App.Model;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class LeaderboardModel {
    private ArrayList<LeaderboardEntry> entries;
    private final String filename = "src/main/java/App/Model/leaderboard.txt";

    public LeaderboardModel() {
        entries = loadEntries();
    }

    public ArrayList<LeaderboardEntry> getEntries() {
        return entries;
    }

    public void addEntry(LeaderboardEntry entry) {
        entries.add(entry);
        saveEntries();
    }

    public void clearEntries() {
        entries.clear();
        saveEntries();
    }

    private ArrayList<LeaderboardEntry> loadEntries() {
        ArrayList<LeaderboardEntry> loadedEntries = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length == 4) {
                    int xSize = Integer.parseInt(fields[0]);
                    int ySize = Integer.parseInt(fields[1]);
                    int zSize = Integer.parseInt(fields[2]);
                    String time = fields[3];
                    loadedEntries.add(new LeaderboardEntry(xSize, ySize, zSize, time));
                }
            }
        } catch (IOException e) {
            System.out.println("Unable to load leaderboard.");
        }

        Collections.sort(loadedEntries, new Comparator<LeaderboardEntry>() {
            public int compare(LeaderboardEntry entry1, LeaderboardEntry entry2) {
                int size1 = entry1.getXSize() * entry1.getYSize() * entry1.getZSize();
                int size2 = entry2.getXSize() * entry2.getYSize() * entry2.getZSize();
                return Integer.compare(size1, size2);
            }
        });

        return loadedEntries;
    }

    private void saveEntries() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (LeaderboardEntry entry : entries) {
                writer.write(entry.getXSize() + "," + entry.getYSize() + "," + entry.getZSize() + "," + entry.getTime());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Unable to save leaderboard.");
        }
    }
}
