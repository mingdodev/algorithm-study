import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] people, int limit) {
        int n = people.length;
        Arrays.sort(people);
        
        int answer = 0;
        int minPerson = 0;
        int maxPerson = n - 1;
        
        while (minPerson < maxPerson) {
            if (people[maxPerson] + people[minPerson] <= limit) minPerson++;
            maxPerson--;
            answer++;
        }
        if (minPerson == maxPerson) answer++; 
        
        return answer;
    }
}