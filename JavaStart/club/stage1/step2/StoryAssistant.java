package javastory.club.stage1.step2;

public class StoryAssistant {
    public static void main(String args){
        StoryAssistant storyAssistant = new StoryAssistant();
        storyAssistant.showMenu();
    }

    public void showMenu(){
        ClubConsole clubConsole = new ClubConsole();
        clubConsole.showMenu();
    }
}
