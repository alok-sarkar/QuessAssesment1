package GameUtil;

import Models.Player;

import java.io.*;
import java.text.Collator;
import java.util.Arrays;
import java.util.Collections;

public class Storage {
    public static String[] loadData(){
        FileReader fr= null;
        StringBuilder dataString=new StringBuilder();
        try {
            fr = new FileReader("Leaderboard.txt");
            BufferedReader br=new BufferedReader(fr);

            int i;

            while((i=br.read())!=-1){
                dataString.append((char)i);
            }
            br.close();
            fr.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not Found\nLoading Failed..");
            System.out.println();
        } catch (IOException e) {
            System.out.println("Can't open file\nLoading Failed..");
        }
        String[] userScores=dataString.toString().split("\n");
        Arrays.sort(userScores, Collections.reverseOrder());
        return userScores;
    }
    public static boolean save(Player player1, Player player2){
        try{
            FileWriter writer = new FileWriter("Leaderboard.txt",true);
            BufferedWriter buffer = new BufferedWriter(writer);

            buffer.append(player1.getScore()+"->"+player1.getName());
            buffer.newLine();
            buffer.append(player2.getScore()+"->"+player2.getName());
            buffer.newLine();
            buffer.close();
            writer.close();
            return true;
        }catch (IOException e) {
            System.out.println("Can't open File\nSaving failed");
            return false;
        }

    }
}
