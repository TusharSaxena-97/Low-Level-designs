package DocumentEditor;

import java.math.BigDecimal;

public class Client {
    public static void main( String args[])
    {
        DocumentEditorBuilder dob = new DocumentEditorBuilder();
        DocumentEditor de = dob.addDocument( new TextDocument() )
                .addPersistence( new SaveFile() )
                .addRenderer( new DocumentRenderer() )
                .build();

        de.addElement("Some Text");
        de.addElement("Some More text");
        de.addElement("Much More text");
        de.addElement(new BigDecimal(10.0000000) );
        de.addElement(new BigDecimal(9999.99999) );
        de.addElement("C:/Tushar/Images/Handsome.png");

        de.render();
        de.save();
    }
}
