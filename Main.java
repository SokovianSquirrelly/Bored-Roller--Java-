import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Main {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean proceed = true;
        boolean quit = false;

        FileReader task_file = new FileReader("Tasks.txt");
        ArrayList<String> task_list = task_file.LoadFile();

        FileReader tv_file = new FileReader("TV_Shows.txt");
        ArrayList<String> tv_list = tv_file.LoadFile();

        FileReader game_file = new FileReader("Video_Games.txt");
        ArrayList<String> game_list = game_file.LoadFile();

        if (task_list == null || tv_list == null || game_list == null)
        {
            System.out.println("An error occured.");
            proceed = false;
        }

        if (proceed)
        {
            System.out.println("Welcome to the Bored Roller!");
            System.out.println();
        }
        else
        {
            quit = true;
        }

        while (!quit)
        {
            Random rand = new Random();
            int upperbound = 6;

            int random_int = rand.nextInt(upperbound);

            switch (random_int)
            {
                case 0:     // The Productivity Case
                    System.out.print("You might wanna do something productive...such as ");
                    int rand_task = rand.nextInt(task_list.size());
                    System.out.print(task_list.get(rand_task));
                    System.out.print(".\n");
                    break;

                case 1:     // The Photo-Organizing Case
                    System.out.println("Organize photos on your phone or computer.");
                    break;

                case 2:     // The TV Case
                    System.out.print("Go ahead and watch an episode or two of ");
                    int rand_tv = rand.nextInt(tv_list.size());
                    System.out.print(tv_list.get(rand_tv));
                    System.out.print(".\n");
                    break;

                case 3:     // The Video Game Case
                    System.out.print("You could play some ");
                    int rand_game = rand.nextInt(game_list.size());
                    System.out.print(game_list.get(rand_game));
                    System.out.print(".\n");
                    break;

                case 4:     // The Book Case...no pun intended
                    System.out.println("Read a book you nerd!");
                    break;

                case 5:     // The Music Playlist Case
                    System.out.println("Continue putting your music playlist together.");
                    break;
            }

            boolean invalid = true;

            while(invalid)
            {
                System.out.print("\nWould you like to go again? (y/n) ");
                char response = scanner.next().charAt(0);
                
                if (response == 'n')
                {
                    invalid = false;
                    quit = true;
                }
                else if (response == 'y')
                {
                    invalid = false;
                }
                else
                {
                    System.out.println("That response isn't valid.");
                }
            }

            System.out.println();
        }

        System.out.println("Thanks for participating!");

        scanner.close();
    }
}