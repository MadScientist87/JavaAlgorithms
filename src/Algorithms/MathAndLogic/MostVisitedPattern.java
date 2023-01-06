package Algorithms.MathAndLogic;

import java.util.*;

public class MostVisitedPattern {
    public static List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        HashMap<String,User> userNameMap = new HashMap();
        HashMap<String,Integer> sequenceCount = new HashMap();
        List<User> userList = new ArrayList<User>();

        for(int i = 0; i < username.length;i++){
            User user;
            if(!userNameMap.containsKey(username[i])){
                user = new User();
                userList.add(user);
            }
            else{
                user = userNameMap.get(username[i]);

            }
            userNameMap.put(username[i],user);
            user.name = username[i];
            PageVisit page = new PageVisit();
            page.timeStamp = timestamp[i];
            page.page = website[i];
            user.pages.add(page);



        }

        HashMap<User,List<String>> userForKey = new HashMap<>();
        for(User user:userList){
            Collections.sort(user.pages, (a, b)-> a.timeStamp - b.timeStamp);
            if(user.pages.size() >=3){
                for(int i = 0; i < user.pages.size()-2; i++){
                    for(int j =i+1; j<user.pages.size()-1; j++){
                        for(int k =j+1; k<user.pages.size(); k++){

                            String key = user.pages.get(i).page.substring(0) + "-" +
                                    user.pages.get(j).page.substring(0) + "-" +
                                    user.pages.get(k).page.substring(0);
                            List<String> keyList;
                            if(!userForKey.containsKey(user)){
                                keyList = new ArrayList<>();

                                userForKey.put(user,keyList);
                            }
                            else{
                                if( userForKey.get(user).contains(key))
                                    continue;
                            }

                            sequenceCount.put(key, sequenceCount.getOrDefault(key,0)+1);
                            keyList = userForKey.get(user);
                            keyList.add(key);
                            userForKey.put(user,keyList);

                        }
                    }
                }
            }
        }


        int maxvalue = Collections.max(sequenceCount.values());

        List<PageVisit> pages  = new ArrayList<>();
        String answerKey = "";
        List<String> answer = new ArrayList();
        Iterator it = sequenceCount.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            if(answerKey == "" && (int)pair.getValue() == maxvalue){
                answerKey = (String) pair.getKey();
                continue;
            }
            else if ((int)pair.getValue() == maxvalue) {
                if(answerKey.compareTo((String) pair.getKey()) > 0){
                    answerKey = (String) pair.getKey();
                }
            }
        }


        for(String page:answerKey.split("-")){
            answer.add(page);
        }


        return answer;
    }

}

class User{
    public String name;
    public List<PageVisit> pages;

    User(){
        pages = new ArrayList<PageVisit>();
    }

}

class PageVisit{
    public int timeStamp;
    public String page;
}


