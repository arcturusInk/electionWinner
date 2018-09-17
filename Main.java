package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Main {
    public static HashMap<String, Integer> storeCount = new HashMap<>();
    public static ArrayList<String> arr = new ArrayList();

    public static int addToHashMap(String[] votes){
        Integer count = 1;
        Integer maxVoteCount = 0;
        for(int i = 0; i < votes.length; ++i){
            if(storeCount.containsKey(votes[i])){
                Integer cnt = storeCount.get(votes[i]);
                storeCount.put(votes[i], ++cnt);
                if(cnt > maxVoteCount){
                    maxVoteCount = cnt;
                }
            }else{
                storeCount.put(votes[i], count);
            }
        }
        return maxVoteCount;
    }

    public static void sortTheHighestVotedNominees(int maxVoteCount){
        for(String x: storeCount.keySet()){
            if(storeCount.get(x).equals(maxVoteCount)) {
                arr.add(x);
            }
        }
        Collections.sort(arr);
    }

    public static String electionWinner(String[] votes) {
        int maxVoteCount = addToHashMap(votes);
        sortTheHighestVotedNominees(maxVoteCount);
        return arr.get(arr.size()-1);
    }

    public static void main(String[] args) {
	// write your code here
        String [] nominees = {"Alex","Michael","Harry","Dave","Michael","Victor","Harry","Alex","Mary","Mary"};

        System.out.print(electionWinner(nominees));
    }
}
