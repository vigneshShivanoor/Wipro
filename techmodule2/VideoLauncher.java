import java.util.ArrayList;
import java.util.Scanner;

class Video {
    private String videoName;
    private boolean checkout;
    private int rating;

    public Video(String name) {
        this.videoName = name;
        this.checkout = false;
        this.rating = 0;
    }

   
    public String getName() {
        return videoName;
    }

    public void doCheckout() {
        this.checkout = true;
    }

    public void doReturn() {
        this.checkout = false;
    }

    public void receiveRating(int rating) {
        this.rating = rating;
    }

   
    public int getRating() {
        return rating;
    }

   
    public boolean getCheckout() {
        return checkout;
    }
}


class VideoStore {
    private ArrayList<Video> store;

    public VideoStore() {
        store = new ArrayList<>();
    }

    public void addVideo(String name) {
        Video video = new Video(name);
        store.add(video);
        System.out.println("Video " + name + " added successfully.");
    }

    public void doCheckout(String name) {
        for (Video video : store) {
            if (video.getName().equals(name)) {
                video.doCheckout();
                System.out.println("Video " + name + " checked out successfully.");
                return;
            }
        }
        System.out.println("Video " + name + " not found.");
    }

    public void doReturn(String name) {
        for (Video video : store) {
            if (video.getName().equals(name)) {
                video.doReturn();
                System.out.println("Video " + name + " returned successfully.");
                return;
            }
        }
        System.out.println("Video " + name + " not found.");
    }

    public void receiveRating(String name, int rating) {
        for (Video video : store) {
            if (video.getName().equals(name)) {
                video.receiveRating(rating);
                System.out.println("Rating " + rating + " has been mapped to video " + name + ".");
                return;
            }
        }
        System.out.println("Video " + name + " not found.");
    }

    public void listInventory() {
        System.out.println("Video Name | Checkout Status | Rating");
        for (Video video : store) {
            System.out.println(video.getName() + " | " + (video.getCheckout() ? "Checked Out" : "Available") + " | " + video.getRating());
        }
    }
}

public class VideoLauncher {
    public static void main(String[] args) {
        VideoStore videoStore = new VideoStore();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nVIDEO STORE MENU");
            System.out.println("1. Add Video");
            System.out.println("2. Checkout Video");
            System.out.println("3. Return Video");
            System.out.println("4. Receive Rating");
            System.out.println("5. List Inventory");
            System.out.println("6. Exit");
            System.out.print("Enter your choice (1-6): ");
            choice = sc.nextInt();
            sc.nextLine();  

            switch (choice) {
                case 1:
                    System.out.print("Enter the name of the video to add: ");
                    String name = sc.nextLine();
                    videoStore.addVideo(name);
                    break;
                case 2:
                    System.out.print("Enter the name of the video to checkout: ");
                    name = sc.nextLine();
                    videoStore.doCheckout(name);
                    break;
                case 3:
                    System.out.print("Enter the name of the video to return: ");
                    name = sc.nextLine();
                    videoStore.doReturn(name);
                    break;
                case 4:
                    System.out.print("Enter the name of the video to rate: ");
                    name = sc.nextLine();
                    System.out.print("Enter the rating for this video (1-5): ");
                    int rating = sc.nextInt();
                    videoStore.receiveRating(name, rating);
                    break;
                case 5:
                    videoStore.listInventory();
                    break;
                case 6:
                    System.out.println("Exiting Video Store. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        } while (choice != 6);

        sc.close();
    }
}
