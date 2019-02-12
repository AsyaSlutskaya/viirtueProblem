package atsign;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmails {
    public int getUniqueEmails(String[] emails){
        Set<String> setOfEmails = new HashSet<>();
        for (String email : emails) {
            setOfEmails.add(cleanEmail(email));
        }
        return setOfEmails.size();
    }

    String cleanEmail(String email){
        if (email.isEmpty()) return "";

        int i = 0;
        StringBuilder result = new StringBuilder();
        boolean isPlus = false;

        while (email.charAt(i) != '@'){
            if (!isPlus && email.charAt(i) != '.' && email.charAt(i) != '+'){

                result.append(email.charAt(i));
            } else {
                if (email.charAt(i) == '+'){
                    isPlus = true;
                }
            }
            i++;
        }
        while (i < email.length()){
            result.append(email.charAt(i));
            i++;
        }
        return result.toString();
    }

}
