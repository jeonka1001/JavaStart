package javastory.club.stage1.step3;

public class StoryAssistant {
    public static void main(String[] args){
        StoryAssistant storyAssistant = new StoryAssistant();
        storyAssistant.startStory();
    }
    public void startStory(){
        ClubConsole clubConsole = new ClubConsole();
        clubConsole.showMenu();
    }
}
