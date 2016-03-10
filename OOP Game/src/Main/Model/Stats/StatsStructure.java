package Main.Model.Stats;

import java.util.EnumMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Michael on 3/9/16.
 */
public class StatsStructure {
    private Map<StatsEnum, Integer> map;

    public StatsStructure() {
        map = new EnumMap<>(StatsEnum.class);
    } // end default constructor

    public StatsStructure(StatsEnum stat, int val) {
        /*
        constructor for single stat modifier
         */
        map = new EnumMap<>(StatsEnum.class);
        map.put(stat, val);
    } // end single constructor

    public StatsStructure(StatsEnum[] stats, int[] vals){
        /*
        constructor for multiple stat modifiers
         */
        map = new EnumMap<>(StatsEnum.class);
        for(int i = 0; i < stats.length; i++) {
            map.put(stats[i], vals[i]);
        }
    } // end multi constructor

    public void modifyStat(StatsEnum stat, int val) {
        /*
        add or replace existing stat modifier
         */
        map.put(stat, val);
    } // end modifyStat

    public void removeStat(StatsEnum stat) {
        /*
        remove stat modifier with key=stat
         */
        map.remove(stat);
    } // end removeStat

    public int getStat(StatsEnum stat) {
        /*
        return value associated with key=stat
         */
        return map.get(stat);
    } // end getStat

    public Set<StatsEnum> getKeySet() { return map.keySet(); } // end getKeyset

    public int getSize() { return map.size(); }
}
