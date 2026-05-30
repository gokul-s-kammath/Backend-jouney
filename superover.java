import java.util.*;

class Player {
    Random rand = new Random();
    String name;
    private int totalrun;
    boolean isout = false;

    public Player(String name, int totalrun) {
        this.name = name;
        this.totalrun = totalrun;
    }

    public void setrun(int run) {
        if (run > 0) {
            totalrun += run;
        }
    }

    public int getrun() {
        return this.totalrun;
    }

    public int com() {
        return rand.nextInt(6) + 1;
    }
}

class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Player computer = new Player("Computer", 0);
        Player user = new Player("User", 0);

        System.out.println("====== SUPER OVER CRICKET ======");
        
        
        System.out.println("\n🏏 The User is batting first!");
        int userBalls = 0;

        while (userBalls < 6 && !user.isout) {
            try {
                System.out.print("Ball " + (userBalls + 1) + " - Choose your shot (1-6): ");
                int userShot = sc.nextInt();

                if (userShot < 1 || userShot > 6) {
                    System.out.println("Penalty! Invalid run choice. Computer gets +3 bonus runs!");
                    computer.setrun(3);
                    userBalls++; 
                    continue;
                }

                
                int compBowl = computer.com();
                System.out.println("  Computer bowled: " + compBowl);

                if (userShot == compBowl) {
                    System.out.println(" OUT!!! The batsman and bowler matched numbers.");
                    user.isout = true;
                } else {
                    user.setrun(userShot);
                    System.out.println("  Current Score: " + user.getrun());
                }
                userBalls++;

            } catch (Exception e) {
                System.out.println("Please enter numbers only!");
                sc.next(); 
            }
        }

        System.out.println("\n=== INNINGS BREAK ===");
        System.out.println("User scored a total of: " + user.getrun() + " runs.");
        System.out.println("The target for the Computer is: " + (user.getrun() + 1));
        System.out.println("=====================");

        System.out.println("\n🏏 The Computer is chasing the target!");
        int compBalls = 0;

        
        while (compBalls < 6 && !computer.isout && computer.getrun() <= user.getrun()) {
            try {
                System.out.print("Ball " + (compBalls + 1) + " - Predict the computer's shot (1-6): ");
                int userBowl = sc.nextInt();

                if (userBowl < 1 || userBowl > 6) {
                    System.out.println("Invalid bowling number! Pick between 1 and 6.");
                    continue; 
                }

                int compShot = computer.com();
                System.out.println("  Computer played shot: " + compShot);

                if (compShot == userBowl) {
                    System.out.println(" OUT!!! You successfully predicted the shot.");
                    computer.isout = true;
                } else {
                    computer.setrun(compShot);
                    System.out.println("  Computer Current Score: " + computer.getrun());
                }
                compBalls++;

            } catch (Exception e) {
                System.out.println("Please enter numbers only!");
                sc.next();
            }
        }

        
        System.out.println("\n====== FINAL RESULT ======");
        System.out.println("User Final Score: " + user.getrun());
        System.out.println("Computer Final Score: " + computer.getrun());
        System.out.println("--------------------------");

        if (computer.getrun() > user.getrun()) {
            System.out.println("🏆 " + computer.name + " has won the game!");
        } else if (computer.getrun() == user.getrun()) {
            System.out.println("🤝 The game has been a draw!");
        } else {
            System.out.println("🏆 " + user.name + " has won the game!");
        }

        sc.close();
    }
}
