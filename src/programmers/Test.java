package programmers;

public class Test {
	 public static int solution(String s) {
        int answer = s.length();
        
        //문자열 길이의 반 이상이 넘어가면 문자를 더이상 자를 수 없기 때문에 1/2만 for 문 수행
        for (int i=1; i<=s.length()/2;i++) {
        	String temp = s.substring(0, i); // 초기 문자열 자르기
        	StringBuilder sb = new StringBuilder();
        	int cnt=1; //동일한 문자열이 반복되는 횟수
        	String current="";
        	
        	for(int j=i; j<s.length();j+=i) {
        		if(j+i>s.length()) {
        			current = s.substring(j, s.length()); //j부터 마지막 문자열까지 자르기
            	}else {
            		current = s.substring(j, (i+j)); //j부터 (i+j) 지점까지 자르기
            	}
            	
            	if(temp.equals(current)) {
            		cnt++;
            	}else if(!temp.equals(current)){
            		if(cnt>1) {
            			sb.append(cnt);
            			sb.append(temp);
            		}else {
            			sb.append(temp);
            		}
            		temp=current;
            		cnt=1;
            	}
        	}
        	//for문 종료 후 남은 문자열 처리
        	if(cnt>1) {
    			sb.append(cnt);
    			sb.append(temp);
    		}else {
    			sb.append(temp);
    		}
        	
        	answer=sb.length()<answer?sb.length():answer;
        }
        return answer;
	 }
	
}
