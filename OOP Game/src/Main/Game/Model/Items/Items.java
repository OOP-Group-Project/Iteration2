package Main.Game.Model.Items;

/**
 * Created by Matthew on 3/7/16.
 */
public abstract class Items {


    public enum ItemTypeEnum {
        obstactle, oneshot, takeable, equippable, interactive
    }


    protected String image_url;
    protected String name;
    protected int id;
    ItemTypeEnum type;

    protected int lives = 0;
    protected int strength = 0;
    protected int agility = 0;
    protected int intellect = 0;
    protected int hardiness = 0;
    protected int experience = 0;
    protected int movement = 0;

    public Items(int id, String name, ItemTypeEnum type, String url, String mods){
        image_url = url;
        this.name = name;
        this.id = id;
        this.type = type;

        String modsArray[] = new String[7];
        int length = 1;
        if(mods.contains(",")){
            String tempArray[] = mods.split(",");
            length = tempArray.length;
            for(int i = 0; i < length; ++i){
                modsArray[i] = tempArray[i];
            }
        }
        else{
            modsArray[0] = mods;
        }

        for(int i = 0; i < length; ++i){
            String currentModification[] = modsArray[i].split(":");
            String currentSkill = currentModification[0];
            if (currentSkill.equals("lives")){
                lives = Integer.parseInt(currentModification[1]);
            }
            else if (currentSkill.equals("strength")){
                strength = Integer.parseInt(currentModification[1]);
            }
            else if (currentSkill.equals("agility")){
                agility = Integer.parseInt(currentModification[1]);
            }
            else if (currentSkill.equals("intellect")){
                intellect = Integer.parseInt(currentModification[1]);
            }
            else if (currentSkill.equals("hardiness")){
                hardiness = Integer.parseInt(currentModification[1]);
            }
            else if (currentSkill.equals("experience")){
                experience = Integer.parseInt(currentModification[1]);
            }
            else if (currentSkill.equals("movement")){
                movement = Integer.parseInt(currentModification[1]);
            }

        }
    }

    public Items(int id, String name, ItemTypeEnum type, String url){
        image_url = url;
        this.name = name;
        this.id = id;
        this.type = type;
    }

    public boolean canMove(){
        if(type != ItemTypeEnum.obstactle){
            return true;
        }
        return false;
    }

    public int getId() {
        return id ;
    }

    public String getName() {
        return name;
    }

    public String getImage_url(){
        return image_url;
    }

    protected void changeType(String newType){
        if(newType.equals("equippable")){
            type = ItemTypeEnum.equippable;
        }
    }
}
