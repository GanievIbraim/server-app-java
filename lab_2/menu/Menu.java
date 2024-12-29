package menu;

import disk.MusicDisk;
import music.JazzTrack;
import music.RockTrack;
import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {
        MusicDisk disk = new MusicDisk();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n--- Music Disk Menu ---");
            System.out.println("1. Add Rock Track");
            System.out.println("2. Add Jazz Track");
            System.out.println("3. Show All Tracks");
            System.out.println("4. Show Total Length");
            System.out.println("5. Sort Tracks by Style");
            System.out.println("6. Find Tracks by Length Range");
            System.out.println("7. Exit");

            System.out.print("Select option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addRockTrack(disk, scanner);
                    break;
                case 2:
                    addJazzTrack(disk, scanner);
                    break;
                case 3:
                    disk.printTracks();
                    break;
                case 4:
                    System.out.println("Total Length: " + disk.getTotalLength() + " minutes");
                    break;
                case 5:
                    disk.sortTracksByStyle();
                    System.out.println("Tracks sorted by style.");
                    break;
                case 6:
                    findTracksByLengthRange(disk, scanner);
                    break;
                case 7:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    private static void addRockTrack(MusicDisk disk, Scanner scanner) {
        System.out.print("Enter track title: ");
        String title = scanner.next();
        System.out.print("Enter artist: ");
        String artist = scanner.next();
        System.out.print("Enter track length in minutes: ");
        double length = scanner.nextDouble();

        disk.addTrack(new RockTrack(title, artist, length));
        System.out.println("Rock track added.");
    }

    private static void addJazzTrack(MusicDisk disk, Scanner scanner) {
        System.out.print("Enter track title: ");
        String title = scanner.next();
        System.out.print("Enter artist: ");
        String artist = scanner.next();
        System.out.print("Enter track length in minutes: ");
        double length = scanner.nextDouble();

        disk.addTrack(new JazzTrack(title, artist, length));
        System.out.println("Jazz track added.");
    }

    private static void findTracksByLengthRange(MusicDisk disk, Scanner scanner) {
        System.out.print("Enter minimum length: ");
        double min = scanner.nextDouble();
        System.out.print("Enter maximum length: ");
        double max = scanner.nextDouble();

        disk.findTracksByLengthRange(min, max).forEach(System.out::println);
    }
}
