package src.AOLUserCSVtoSort;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Files;

public class AOLUserCSVtoSort {
     public static void main(String[] args) {
         String outputFile = "csv/aol_user_ct_full.csv";
         String File = "/csv";
        String csvFile = ".csv";
        try {
            File files = new File(outputFile);
            System.out.println(files.toString().split("").length);
            BufferedReader br = new BufferedReader(new FileReader(files));
            br.readLine();
            String line;
            String temp= "google";
            boolean g= true;
            boolean f= true;
            boolean y= true;
            boolean p= true;
            boolean pl= true;
            boolean n= true;
            boolean t= true;
            boolean ps= true;
            boolean am= true;
            boolean b= true;
            boolean re= true;
            String tempstr="";
            int count=0;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");
                String name = fields[0];
                String date = fields[1];
                String time = fields[2];
                String email = fields[3];
                String gender = fields[4];

                if (date.contains(temp)&&g){
                    System.out.println(name + "\t" + date + "\t" + time + "\t" + email+ "\t" + gender);
                    g=false;
                    count++;
                }else if (date.contains("ploto")&&pl){
                    System.out.println(name + "\t" + date + "\t" + time + "\t" + email+ "\t" + gender);
                    pl=false;
                    count++;
                }
                else if(date.contains("facebook")&&f){
                    System.out.println(name + "\t" + date + "\t" + time + "\t" + email+ "\t" + gender);
                    f=false;
                    count++;
                }

                else if (date.contains(("protest"))&&p){
                    System.out.println("Protest:"+name + "\t" + date + "\t" + time + "\t" + email+ "\t" + gender);
                    p=false;
                    count++;
                }
                else if (date.contains("twitter")&&t){
                    System.out.println("Twitter:"+name + "\t" + date + "\t" + time + "\t" + email+ "\t" + gender);
                    t=false;
                    count++;
                }
                else if (date.contains("youtube")&&y){
                    System.out.println("youtube:"+name + "\t" + date + "\t" + time + "\t" + email+ "\t" + gender);
                    y=false;
                    count++;
                }
                else if (date.contains("nintendo")&&n){
                    System.out.println("nintendo:"+name + "\t" + date + "\t" + time + "\t" + email+ "\t" + gender);
                    n=false;
                    count++;
                }
                else if ((date.contains("playstation")||date.contains("sony"))&&ps){
                    System.out.println("playstation/sony:"+name + "\t" + date + "\t" + time + "\t" + email+ "\t" + gender);
                    ps=false;
                    count++;
                }
                else if (date.contains("angela merkel")&&am){
                    System.out.println("angel:"+name + "\t" + date + "\t" + time + "\t" + email+ "\t" + gender);
                    am=false;
                    count++;
                } else if (date.contains("business")&&b) {
                    System.out.println("business:"+name + "\t" + date + "\t" + time + "\t" + email+ "\t" + gender);
                    b=false;
                    count++;
                }
                else if (date.contains("real estate")&&re) {
                    System.out.println("real estate:"+name + "\t" + date + "\t" + time + "\t" + email+ "\t" + gender);
                    count++;
                    re=false;
                }

            }
            System.out.println("cout:"+count);
        }
        catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }



    }
}
