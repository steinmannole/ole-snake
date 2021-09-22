package actions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

import javax.swing.JFileChooser;

import game.Snake;

public class Data {

    File folder = new File("C:/Tools/finish/Snake/data");
    File file = new File("C:/Tools/finish/Snake/data/save.txt");
    StringBuilder sb = new StringBuilder();

    public static void safeData() {

        Data data = new Data();

        // Create
        if (!data.folder.exists()) {
            data.folder.mkdirs();
        }

        if (!data.file.exists()) {
            try {
                data.file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //Speichern
        data.sb.append(Snake.bestscore);
        data.sb.append("\n");

        try {
            OutputStream stream = new FileOutputStream(data.file);
            String s = data.sb.toString();

            stream.write(s.getBytes());
            stream.close();

            System.out.println("Daten gesichert!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadData() {
        JFileChooser chooser = new JFileChooser();

        int temp = chooser.showOpenDialog(null);
        if (temp == JFileChooser.APPROVE_OPTION) {
            String s = chooser.getSelectedFile().getAbsolutePath();
            if (s.endsWith("C:/Tools/finish/Snake/Data/save.txt")) {

                File file = new File(s);
                try {
                    @SuppressWarnings("resource")
					Scanner sc = new Scanner(file);

                    Snake.bestscore = Integer.parseInt(sc.nextLine());
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

            } else {
                System.out.println("Fehler beim Einlesen!");
            }
        }
    }

    public static void loadStart() {

        File save = new File("C:/Tools/finish/Snake/Data/safe.txt");
        if(save.exists()) {
            try {
                @SuppressWarnings("resource")
				Scanner sc = new Scanner(save);
                Snake.bestscore = Integer.parseInt(sc.nextLine());

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        }
    }
}
