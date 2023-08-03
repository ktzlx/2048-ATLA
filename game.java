import java.util.Random;
import java.util.ArrayList;
public class game{
  private int[][] board;
  final int four=4;
  private Random r = new Random();
  public game(){
    board = new int [four][four];
    reStart();
  } 
  
  public int[][] guigame(){
    return board;
  }
  
  public void addNum(){
    ArrayList<Integer> emptyx= new ArrayList<Integer>();
    ArrayList<Integer> emptyy= new ArrayList<Integer>();
    for(int x=0; x<four; x++){
      for(int y=0; y<four; y++){
        if(board[x][y]==0){
          int[]a ={x,y};
          emptyx.add(x);
          emptyy.add(y);
        }
      }
    }
    int choice= r.nextInt(emptyx.size());
    int spawn= r.nextInt(10)<9?2:4;//90%210%4
    int X =emptyx.get(choice);
    int Y =emptyy.get(choice);
    board[X][Y]=spawn;
  }
  void reStart(){
    for(int x=0;x<4;x++){
      for(int y=0;y<4;y++){
         board[x][y]=0;
        }
      }
    
    for(int x=0; x<2;x++) addNum();
  }
  void winlose(){
    int count=0;
    int win=0;
    for(int x=0;x<4;x++){
      for(int y=0;y<4;y++){
        if(board[x][y]!=0) count++;
        if(board[x][y]==2048)win++;
        if (win==1){
          System.out.println("You Win :)");
          System.out.println("Would you like to play again");
          reStart();
          break;
        }
        if(count==16){
          System.out.println("You Lose :(");
          System.out.println("Would you like to play again");
          reStart();
          break;
        }
      }
    }
  }
  
  /**/
  void left(){
        int count=0;
        for(int x=0;x<4;x++){
            count=0;
            for(int y=0;y<4;y++){
                if(board[x][y]!=0){
                    int current= board[x][y];
                    int Y=y;
                    while(Y-1>=0&&board[x][Y-1]==0)Y--;
                    int newv=board[x][Y];
                    if(newv!=current){
                        for (int v = 0; v <= 3; v++) {
                            if (Y== v && board[x][Y] == 0) {
                                board[x][Y] = current;
                                board[x][y] = 0;
                            }
                        }
                    }
                    if(current==board[x][3]||current==board[x][Y+1]){
                        count++;
                        if(count==1||count==2){
                            board[x][Y]*=2;
                            if(y==3)board[x][3]=0;
                            else board[x][y+1]=0;
                        }
                        else{
                            board[x][Y+1]=current;
                            board[x][y]=0;}
                    }
                }
            }
        }
    }
  
  void right(){
    int count=0;
    for(int x=0;x<4;x++){
    count=0;
      for(int y=3;y>-1;y--){
        if(board[x][y]!=0){
          int current= board[x][y];
          int Y=y;
         while(Y+1<=3&&board[x][Y+1]==0)Y++;
          int newv=board[x][Y]; 
          if(newv!=current){
            for (int v = 3; v >= 0; v--) {
               if (Y== v && board[x][Y] == 0) {
               board[x][Y] = current;
               board[x][y] = 0;
              }
            }
          }
          if((current==board[x][0]||current==board[x][Y-1])&&current!=0){
            count++;
            if(count==1||count==2){
            board[x][Y]*=2;
            if(y==0) board[x][0]=0;
            else board[x][y-1]=0;
            }
            else{ 
              board[x][Y-1]=current;
              board[x][y]=0;}
          }
        }
      }
    }
  }void up(){
        int count=0;
        for(int y=0;y<4;y++){
            count=0;
            for(int x=0;x<4;x++){

                if(board[x][y]!=0){
                    int current= board[x][y];
                    int X=x;
                    while(X-1>=0&&board[X-1][y]==0)X--;
                    int newv=board[X][y];
                    if(newv!=current){
                        for (int v = 0; v <= 3; v++) {
                            if (X == v && board[X][y] == 0) {
                                board[X][y] = current;
                                board[x][y] = 0;
                            }
                        }
                    }
                    if(current==board[X+1][y]||current==board[3][y]){
                        count++;
                        if(count==1||count==2){
                            board[X][y]*=2;
                            if(x==3) board[3][y]=0;
                            else board[X+1][y]=0;
                        }
                        else{
                            board[X+1][y]=current;
                            board[x][y]=0;
                        }
                    }
                }
            }
        }
    }
  void down(){
        int count=0;
        for(int y=0;y<4;y++){
            count=0;
            for(int x=3;x>-1;x--){
                if(board[x][y]!=3){
                    int current= board[x][y];
                    int X=x;
                    while(X+1<=3&&board[X+1][y]==0) X++;
                    int newv=board[X][y];
                    if(newv!=current){
                        for (int v = 3; v >= 0; v--) {
                            if (X == v && board[X][y] == 0) {
                                board[X][y] = current;
                                board[x][y] = 0;
                            }
                        }
                    }
                    if((current==board[0][y]||current==board[X-1][y])&&current!=0){
                        count++;
                        if(count==1||count==2){
                            board[X][y]*=2;
                            if(x==0) board[0][y]=0;
                            else board[x-1][y]=0;
                        }
                        else{
                            board[X-1][y]=current;
                            board[x][y]=0;}

                    }
                }
            }
        }
    }  

}

