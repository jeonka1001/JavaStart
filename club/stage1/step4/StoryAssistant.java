package javastory.club.stage1.step4;

public class StoryAssistant {
    public static void main(String[] args){
        StoryAssistant storyAssistant = new StoryAssistant();
        storyAssistant.startStory();
    }

    public void startStory(){
        ClubConsole travelClubConsole = new ClubConsole();
        travelClubConsole.showMenu();
    }
}
