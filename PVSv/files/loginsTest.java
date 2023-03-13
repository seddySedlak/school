package PVSv.files;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class loginsTest {
    public static void main(String[] args) throws IOException {
        int count = 0;
        int password = 0;
        int username = 0;
        List<String> linesPasswords, linesUsernames, allLogins;
        linesPasswords = Files.readAllLines(Paths.get("filesResources\\logins\\passwords.txt"));
        linesUsernames = Files.readAllLines(Paths.get("filesResources\\logins\\usernames.txt"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("filesResources\\logins\\loginsExport.txt")));

        for (int i = 0; i < 4; i++) {
            pw.println(Paths.get("filesResources\\logins\\loginAttempts" + (i + 1) + ".txt"));
            allLogins = Files.readAllLines(Paths.get("filesResources\\logins\\loginAttempts" + (i + 1) + ".txt"));
            for (String login : allLogins) {
                String[] split = login.split(";");
                password = linesPasswords.indexOf(split[1]);
                username = linesUsernames.indexOf(split[0]);
                if (username == password) {
                    pw.println(login);
                    count++;
                }
            }
        }
        System.out.println("Number of valid: " + count);
        pw.close();
    }
}
