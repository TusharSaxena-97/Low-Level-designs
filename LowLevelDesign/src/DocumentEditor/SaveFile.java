package DocumentEditor;

public class SaveFile implements IPersistence{

    @Override
    public void save(IDocument document) {

        System.out.println("Saving to file ....");

        for( IDocumentElement ele : document.getElements() )
           ele.render();

        System.out.println("File Saved....");
    }

}
