package javastory.club.stage1.step1;

public class StoryAssistant {
    public static void main(String[] args){
        StoryAssistant storyAssistant = new StoryAssistant();
        storyAssistant.createTravelClub();
    }
    public void createTravelClub(){
        String name = "JavaTravelClub";
        String intro = "Travel club to Java island.";
        TravelClub club = new TravelClub(name,intro);
        System.out.println(club.tellMeAboutYou());
    }
}
