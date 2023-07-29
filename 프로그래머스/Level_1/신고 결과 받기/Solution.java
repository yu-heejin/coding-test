import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

class Solution {
    private final int REPORTER_INDEX = 0;
    private final int REPORTED_INDEX = 1;
    private HashSet<String> reportResults;
    private HashMap<String, Integer> reportedUsers;
    private HashMap<String, Integer> mailedUsers;
    
    public int[] solution(String[] id_list, String[] report, int k) {
        reportResults = new HashSet<>();
        reportedUsers = new HashMap<>();
        mailedUsers = new HashMap<>();
        
        addReportResults(report);
        addReportedUsers();
        addMailedUsers(k);
        
        return getAnswer(id_list);
    }
    
    private void addReportResults(String[] report) {
        for (int i = 0; i < report.length; i++) {
            reportResults.add(report[i]);
        }
    }
    
    private void addReportedUsers() {
        Iterator<String> reportResultsIterator = reportResults.iterator();
        
        while (reportResultsIterator.hasNext()) {
            String[] reportRelation = reportResultsIterator.next().split(" ");
            String reportedUser = reportRelation[REPORTED_INDEX];
            
            reportedUsers.put(reportedUser, reportedUsers.getOrDefault(reportedUser, 0) + 1);
        }
    }
    
    private void addMailedUsers(int k) {
        Iterator<String> reportResultsIterator = reportResults.iterator();
        
        while (reportResultsIterator.hasNext()) {
            String[] reportRelation = reportResultsIterator.next().split(" ");
            String reportedUser = reportRelation[REPORTED_INDEX];
            String reporter = reportRelation[REPORTER_INDEX];
            
            if (reportedUsers.get(reportedUser) >= k) {
                mailedUsers.put(reporter, mailedUsers.getOrDefault(reporter, 0) + 1);
            }
        }
    }
    
    private int[] getAnswer(String[] id_list) {
        int[] answer = new int[id_list.length];
        
        for (int i = 0; i < id_list.length; i++) {
            answer[i] = mailedUsers.getOrDefault(id_list[i], 0);
        }
        
        return answer;
    }
}
