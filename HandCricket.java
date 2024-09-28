import java.util.Random;
import java.util.Scanner;
import java.lang.String;

public class HandCricket {
    static String toss[] = {"HEADS", "TAILS"};
    static String ele[] = {"BAT", "BOWL"};
    static int score[] = {1, 2, 3, 4, 5, 6};
    static int player = 0;
    static int opponent = 0;
    static int rscore = 0;
    static int utotal = 0;
    static int count = 0;
    static Random r = new Random();
    static Scanner s = new Scanner(System.in);
    public static void main(String args[]) {
        System.out.print("Enter the players name : ");
        String name = s.next();
        System.out.println("Hello " + name);
        String game = "yes";
        while(game.equalsIgnoreCase("yes")) {
        System.out.print("Choose \"HEADS\" or \"TAILS\" : ");
        String tossn = s.next();
        int ctoss = r.nextInt(toss.length);
        int elect = r.nextInt(ele.length);
            if (tossn.equalsIgnoreCase(toss[ctoss])) {
                System.out.print("Congrats you have won the toss,Choose to \"BAT\" or \"BOWL\" first : ");
                String elec = s.next();
                if(elec.equalsIgnoreCase("bat" )|| elec.equalsIgnoreCase("bowl") ){
                    System.out.println("you have elected to " + elec + " first");
                    if (elec.equalsIgnoreCase("bat")) {
                        player_first_batting(name);
                    } else if (elec.equalsIgnoreCase("bowl")) {
                        opponent_first_batting(name);
                    }
                }else{
                    System.out.println("Choose to \"BAT\" or \"BOWL\" first : ");
                    elec = s.next();
                    if (elec.equalsIgnoreCase("bat")) {
                        player_first_batting(name);
                    } else if (elec.equalsIgnoreCase("bowl")) {
                        opponent_first_batting(name);
                    }
                }
            } else {
                System.out.println("Oops you have lose the toss,The oppenent elected to " + ele[elect] + " first ");
                int rscore = r.nextInt(score.length);
                int utotal = 0;
                if (ele[elect].equalsIgnoreCase("bowl")) {
                    player_first_batting(name);
                } else if (ele[elect].equalsIgnoreCase("bat")) {
                    opponent_first_batting(name);
                }
            }
            System.out.print("Choose if you want to have a rematch \"YES\" or \"NO\" : " );
            game = s.next();
        }
    }
    public static void player_first_batting(String name){
        rscore = r.nextInt(score.length);
        System.out.println("Start Batting (note : you want to choose only (o to 6) orelse you will lose )");
        int uscore = -1;
        while (uscore != rscore) {
            if (uscore > 6 || uscore < -1) {
                System.out.println("(note : you want to choose only (o to 6)");
                uscore = s.nextInt();
            }
            rscore = r.nextInt(score.length);
            uscore = s.nextInt();
            if (uscore > 6 || uscore < -1) {
                System.out.println("(note : you want to choose only (o to 6)");
                uscore = s.nextInt();
            }
            utotal += uscore;
            System.out.println(name + " : " + uscore);
            System.out.println("Opponent : " + rscore);
            if (uscore == 0 && uscore != rscore) {
                utotal += rscore;
            }
            if (uscore == rscore)
                utotal = utotal - uscore;
            System.out.println(name + "'s Total : " + utotal);
            count++;
        }
        player = utotal;
        System.out.printf(name+" have scored %d runs \nThe opponent needs %d runs to win\n", utotal, utotal + 1);
        System.out.println("Start Bowling");
        uscore = -1;
        utotal = 0;
        while (uscore != rscore) {
            if (uscore > 6 || uscore < -1) {
                System.out.println("(note : you want to choose only (o to 6)");
                uscore = s.nextInt();
            } else
                rscore = r.nextInt(score.length);
            uscore = s.nextInt();
            if (uscore > 6 || uscore < -1) {
                System.out.println("(note : you want to choose only (o to 6)");
                uscore = s.nextInt();
            }
            utotal += rscore;
            System.out.println("Opponent : " + rscore);
            System.out.println(name + " : " + uscore);
            if (rscore == 0 && uscore != rscore) {
                utotal += uscore;
            }
            if (uscore == rscore)
                utotal = utotal - rscore;
            System.out.println("Opponent's Total : " + utotal);
            if (uscore != rscore && utotal < player)
                System.out.printf("Opponent needs %d runs to win\n", player - utotal);
            if (player < utotal)
                break;
        }
        System.out.println("Opponent have scored " + utotal + " runs");
        opponent = utotal;
        if (player < opponent) {
            System.out.println("Oops you has Lose the match");
        } else if (player > opponent) {
            System.out.println("Congrats you have Won the match");
        } else {
            System.out.println("The match has Tied");
        }
    }
    public static void opponent_first_batting(String name) {
        System.out.println("Start Bowling (note : you want to choose only (o to 6) orelse you will lose )");
        int uscore = -1;
        while (uscore != rscore) {
            rscore = r.nextInt(score.length);
            uscore = s.nextInt();
            if (uscore > 6 || uscore < -1) {
                System.out.println("(note : you want to choose only (o to 6)");
                uscore = s.nextInt();
            }
            utotal += rscore;
            System.out.println("Opponent : " + rscore);
            System.out.println(name + " : " + uscore);
            if (rscore == 0 && uscore != rscore) {
                utotal += uscore;
            }
            if (uscore == rscore)
                utotal = utotal - rscore;
            System.out.println("Opponents Total : " + utotal);
    }
        opponent = utotal;
        System.out.printf("Opponent have scored %d runs \nYou needs %d runs to win\n", utotal, utotal + 1);
        System.out.println("Start Batting");
        uscore = -1;
        utotal = 0;
        while (uscore != rscore) {
            rscore = r.nextInt(score.length);
            uscore = s.nextInt();
            if (uscore > 6 || uscore < -1) {
                System.out.println("(note : you want to choose only (o to 6)");
                uscore = s.nextInt();
            }
            utotal += uscore;
            System.out.println(name + " : " + uscore);
            System.out.println("Opponent : " + rscore);
            if (uscore == 0 && uscore != rscore) {
                utotal += rscore;
            }
            if (uscore == rscore)
                utotal = utotal - uscore;
            System.out.println(name + "'s Total : " + utotal);
            if (uscore != rscore && utotal < opponent)
                System.out.printf("%s needs %d runs to win\n", name, opponent - utotal);
            if (opponent < utotal)
                break;
        }
        System.out.println(name+" have scored " + utotal + " runs");
        player = utotal;
        if (player < opponent) {
            System.out.println("Oops you has Lost the match");
        } else if (player > opponent) {
            System.out.println("Congrats you have Won the match");
        } else {
            System.out.println("The match has Tied");
        }
    }
}
