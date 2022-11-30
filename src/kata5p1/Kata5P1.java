package kata5p1;

import java.util.List;


public class Kata5P1 {

    public static void main(String[] args) {
        
        // Versión 3
        
        //SelectApp app = new SelectApp("kata5.db");
        //app.selectAll();
        //CreateTable.CreateNewTable("kata5.db");
        
        Iterable<String> emails = new MailListReader().read("emails.txt");
        new TableDataInsertion().insertList(emails);
    }
}
