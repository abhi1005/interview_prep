package string;

import java.util.*;

//[["John","johnsmith@mail.com","john_newyork@mail.com"],
// ["John","johnsmith@mail.com","john00@mail.com"],
// ["Mary","mary@mail.com"],
// ["John","johnnybravo@mail.com"]]

public class MergeAccounts {

    public static void main(String[] args) {

    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        //Map of name and List of sets of emails
        Map<String, List<Set<String>>> emailAccounts = new HashMap<>();
        int len = accounts.size();
        for(int i = 0; i < len; i++){
            int emailsTotal = accounts.get(i).size();
            List<Set<String>> differentSets = emailAccounts.get(accounts.get(i).get(0));
            if(differentSets == null)
                differentSets = new ArrayList<>();
            for(int j = 1; j < emailsTotal; j++){
                boolean isPresent = false;
                for(Set<String> set : differentSets){
                    if(set.contains(accounts.get(i).get(j))){
                        for(int k = 0; k < emailsTotal; k++ ){
                            set.add(accounts.get(i).get(k));
                        }
                        differentSets.add(set);
                        j = emailsTotal;
                        isPresent = true;
                    }
                }
                if(!isPresent){
                    Set<String> set = new HashSet<>();
                    set.add(accounts.get(i).get(j));
                    differentSets.add(set);
                }
            }
            emailAccounts.put(accounts.get(i).get(0), differentSets);
        }
        List<List<String>> mergedAccounts = new ArrayList<>();
        for(Map.Entry<String, List<Set<String>>> mapEntry : emailAccounts.entrySet()){
            List<Set<String>> list = mapEntry.getValue();
            for(Set<String> set : list){
                List<String> newList = new ArrayList<>();
                newList.add(mapEntry.getKey());
                for(String s : set){
                    newList.add(s);
                }
                mergedAccounts.add(newList);
            }
        }
        return mergedAccounts;
    }
}
