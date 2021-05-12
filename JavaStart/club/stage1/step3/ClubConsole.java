package javastory.club.stage1.step3;

import javastory.club.stage1.step1.TravelClub;

import java.util.Scanner;

public class ClubConsole {
    private Scanner scanner ;
    private ClubCoordinator clubCoordinator;

    public ClubConsole(){
        this.scanner = new Scanner(System.in);
        this.clubCoordinator = new ClubCoordinator();
    }

    public void showMenu(){
        int inputNumber = 0;
        while(true){
            displayMainMenu();
            inputNumber = selectMainMenu();

            switch(inputNumber){
                case 1:
                    register();
                    break;
                case 2:
                    find();
                    break;
                case 3:
                    findAll();
                    break;
                case 0:
                    exitProgram();
                    return;
                default:
                    System.out.println("Choose again!");
            }
        }
    }

    private void displayMainMenu(){
        System.out.println(" ");
        System.out.println("........................");
        System.out.println(" Travel club menu");
        System.out.println("........................");
        System.out.println(" 1. Register");
        System.out.println(" 2. Find");
        System.out.println(" 3. Find all");
        System.out.println(" 0. Program exit");
        System.out.println("........................");
    }

    private int selectMainMenu(){
        System.out.println("Select number :");
        int menuNumber = scanner.nextInt();

        if(menuNumber >= 0 && menuNumber <= 3){
            scanner.nextLine();
            return menuNumber;
        }
        else{
            System.out.println("It's a invalid number --> " + menuNumber);
            return -1;
        }
    }
    private void exitProgram(){
        System.out.println("Program exit. Bye....");
        System.out.println(0);
    }

    private void register(){
        System.out.println("Input club name :");
        String clubName = scanner.nextLine();

        if (clubName == null || clubName.equals("")) {
            System.out.println("Club name should not be null ");
            return ;
        }
        clubName = clubName.trim();
        if(clubCoordinator.exist(clubName)){
            System.out.println("Club name already exists. -->"+clubName);
            return ;
        }
        System.out.println("Input club intro :");
        String intro = scanner.nextLine();
        intro.trim();

        try{
            TravelClub newClub = new TravelClub(clubName, intro);
            String saveClubName = clubCoordinator.register(newClub);
            if(saveClubName != null){
                System.out.println("Registered club : "+newClub.tellMeAboutYou());
            }
            else{
                System.out.println("The club with same name already exist. -->"+clubName);
            }
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    private void find(){
        String clubName ="";

        while(true){
            clubName = displayFindMenuAndGetKey();
            if(clubName.equals("0")){
                break;
            }
            TravelClub travelClub = clubCoordinator.find(clubName);
            if(travelClub != null){
                System.out.println("\t >> Found club : "+travelClub.tellMeAboutYou());
            }
            else{
                System.out.println("\t >> No such a club : "+clubName);
            }
        }
    }

    private String displayFindMenuAndGetKey(){
        if( !clubCoordinator.hasClubs()){
            System.out.println("\t > No more clubs in the storage.");
            return "0";
        }
        System.out.println("\n\t > Input club name to find(0.Previous menu) : ");
        String clubName = scanner.nextLine();

        return clubName.trim();
    }

    private void findAll(){
        if( !clubCoordinator.hasClubs()){
            System.out.println("\t > No clubs in the storage.");
            return;
        }
        TravelClub[] clubs = clubCoordinator.findAll();
        System.out.println(" \t >> Found "+clubs.length + "clubs.");

        for( int i = 0 ; i < clubs.length; i++){
            System.out.println("\t >> Found club : "+clubs[i].tellMeAboutYou());
        }
    }
}
