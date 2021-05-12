package javastory.club.stage1.step4;

import java.util.List;

public class ClubCoordinator {
    private ClubStorage clubStorage;

    public ClubCoordinator(){
        this.clubStorage = new ClubStorage();
    }

    public boolean hasClubs(){
        return clubStorage.count()!=0;
    }
    public boolean register(TravelClub newClub){
        String clubName = clubStorage.store(newClub);
        return clubName != null;
    }

    public boolean exist(String name){
        return clubStorage.exist(name);
    }

    public TravelClub find(String name){
        return clubStorage.retrieve(name);
    }

    public List<TravelClub> findAll(){
        return clubStorage.retrieveAll();
    }
    public void modify(String name, String intro){
        if(!clubStorage.exist(name)){
            return;
        }
        TravelClub club = clubStorage.retrieve(name);
        club.setIntro(intro);

        clubStorage.update(club);
    }

    public void remove(String name){
        if(!clubStorage.exist(name)){
            return ;
        }
        clubStorage.delete(name);
    }
}
