package GameUtil;

import Models.Player;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class Storage {
    static  String[] leaderBoard;
    static {
        leaderBoard=loadData();
    }
    public static String[] loadData(){
        FileReader fr= null;
        StringBuilder dataString=new StringBuilder();
        try {
            fr = new FileReader("Leaderboard.txt");
            BufferedReader br=new BufferedReader(fr);

            int charIndex;

            while((charIndex =br.read())!=-1){
                dataString.append((char) charIndex);
            }
            br.close();
            fr.close();
        } catch (FileNotFoundException e) {
            return new String[]{};
        } catch (IOException e) {
            System.out.println("Can't open file\nLoading Failed..");
        }
        String reducedString=dataString.toString().trim();
        String[] userScores=reducedString.split("->");
        Arrays.sort(userScores, Collections.reverseOrder());
        return userScores;
    }
    public static int getHighestScore(){
        if(leaderBoard.length>1){
            String[] highestUser= leaderBoard[0].split("==");
            return Integer.parseInt(highestUser[0]);
        }else
            return 0;
    }
    public static String getHighestScorer(){
        if(leaderBoard.length>1){
            String[] highestUser= leaderBoard[0].split("==");
            return "["+highestUser[1]+"]";
        }else
            return "";
    }
private static void writeScore(Player player){
    try{
        FileWriter writer = new FileWriter("Leaderboard.txt",true);
        BufferedWriter buffer = new BufferedWriter(writer);
//        System.out.println("Writing Score");
        buffer.append(player.getScore()+"=="+player.getName()+"->");
        buffer.close();
        writer.close();

    }catch (IOException e) {
        System.out.println("Can't open File\nSaving failed");
    }
}
private static void updateScore(Player player){
    try{
        new File("Leaderboard.txt").delete();
//        System.out.println("deleted");
        FileWriter writer = new FileWriter("Leaderboard.txt");
        BufferedWriter buffer = new BufferedWriter(writer);
        for (String userScore : leaderBoard) {
            if(userScore.split("==")[1].compareTo(player.getName())!=0){
                buffer.write(userScore+"->");
            }else if (player.getScore()>Integer.parseInt(userScore.split("==")[0])){
                buffer.append(player.getScore()+"=="+player.getName()+"->");
            }
        }
        buffer.close();
        writer.close();
    }catch (IOException e) {
        System.out.println("Can't open File\nSaving failed");
    }
}
private static boolean isExistingUser(Player player){
        String[] user= new String[2];
    for (String leaderBordScore : leaderBoard) {
        user=leaderBordScore.split("==");
        if(user[1].equals(player.getName())){
//            System.out.println("Existing..");
            return true;
        }
    }
        return false;
}
    public static void save(Player player1, Player player2){
        if(isExistingUser(player1))
            updateScore(player1);
        else
            writeScore(player1);
        if(isExistingUser(player2))
            updateScore(player2);
        else
            writeScore(player2);


    }
}
