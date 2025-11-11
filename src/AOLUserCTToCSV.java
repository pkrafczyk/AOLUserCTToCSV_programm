package src.AOLUserCTToCSV;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.List;
import java.util.zip.GZIPInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class AOLUserCTToCSV {

        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        public static void main(String[] args) throws IOException {
            // Pfad zum AOL-Ordner anpassen


            //https://github.com/pkrafczyk/AOLUserCTToCSV_programm/tree/dc886f20df89e2f3c7a66589b90deb48ece26e77/csv

            String inputDir = "...\\csv\\AOL-user-ct-collection\\AOL-user-ct-collection";
            String outputFile = "...\\csv\\aol_user_ct_full.csv";


            try (BufferedWriter writer = Files.newBufferedWriter(
                    Paths.get(outputFile), StandardCharsets.UTF_8)) {

                // CSV-Kopfzeile schreiben
                writer.write("AnonID,Query,QueryTime,ItemRank,ClickURL");
                writer.newLine();

                File folder = new File(inputDir);
                File[] files = folder.listFiles((dir, name) ->
                        name.endsWith(".txt") || name.endsWith(".gz"));

                if (files == null || files.length == 0) {
                    System.out.println("⚠️ Keine Dateien gefunden!");
                    return;
                }

                java.util.Arrays.sort(files);

                for (File file : files) {
                    System.out.println("➡️ Verarbeite: " + file.getName());
                    processFile(file, writer);
                }

                System.out.println("✅ CSV-Datei erstellt: " + outputFile);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private static void processFile(File file, BufferedWriter writer) throws IOException {
            InputStream inputStream;

            if (file.getName().endsWith(".gz")) {
                inputStream = new GZIPInputStream(new FileInputStream(file));
            } else {
                inputStream = new FileInputStream(file);
            }

            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {

                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split("\t");
                    if (parts.length == 5) {
                        writer.write(escapeCSV(parts[0]) + "," +
                                escapeCSV(parts[1]) + "," +
                                escapeCSV(parts[2]) + "," +
                                escapeCSV(parts[3]) + "," +
                                escapeCSV(parts[4]));
                        writer.newLine();
                    }
                }
            }
        }

        private static String escapeCSV(String field) {
            if (field == null) return "";
            field = field.replace("\"", "\"\"");
            if (field.contains(",") || field.contains("\"") || field.contains("\n")) {
                field = "\"" + field + "\"";
            }
            return field;
        }
    }

