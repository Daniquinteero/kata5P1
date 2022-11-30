package kata5p1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.regex.Pattern;

public class MailListReader implements Loader{

    private static final Pattern pattern = Pattern.compile("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");

    public MailListReader() {
    }
    
    @Override
    public Iterable<String> read(String fileName) {
        return new Iterable<String>(){
            @Override
            public Iterator<String> iterator() {
                return new Iterator<String>() {
                    BufferedReader reader = createReader();
                    String nextEmail = nextEmail();
                    
                    @Override
                    public boolean hasNext() {
                        return nextEmail != null;
                    }

                    @Override
                    public String next() {
                        String email = nextEmail;
                        nextEmail = nextEmail();
                        return email;
                    }
                    
                    private String nextEmail(){
                        String line;
                        while (true) {
                            try  {
                                line = reader.readLine();
                            } catch (IOException ex) {
                                return null;
                            }
                            if (line == null) return null;
                            if (isEmail(line)) return line;
                        }

                    }
                    
                    private boolean isEmail(String line){
                        return pattern.matcher(line).matches();
                    }
                    
                    private BufferedReader createReader() {
                        try {
                            return new BufferedReader(new FileReader(new File(fileName)));
                        } catch (FileNotFoundException ex) {
                            return null;
                        }
                    }
                };
            }
        };
    } 
}