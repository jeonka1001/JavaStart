class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        java.util.Stack<Integer> stack = new java.util.Stack<>();
        for(int i=0;i<moves.length;i++){
            int m = moves[i]-1;
            for(int j=0;j<board.length;j++)
            {
                int pick = board[j][m]; // 인형을 하나 뽑는다.
                board[j][m]=0; // 뽑은 인형 자리는 0
                if(pick!=0){
                    if(stack.isEmpty()){ // 스택이 비어있는지 검사
                        stack.push(pick); // 비어있을 경우 방금 뽑은거 넣기
                    }
                    else{ // 비어있지않을경우 비교하기
                        if(!stack.isEmpty()&&stack.peek()==pick){  
                            //최근 넣은것과 방금 뽑은것이 같으면
                            stack.pop(); // 최상단 원소 지우기
                            answer +=2; //+2증가 
                        }
                        else{ // 다르면
                            stack.push(pick); // 넣기
                            
                        }
                    }
                    break;
                }
            }
        }
        return answer;
    }
}
