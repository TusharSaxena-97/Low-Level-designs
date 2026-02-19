package DocumentEditor;

public class DocumentRenderer implements IDocumentRenderer{

    public void render(IDocument Document)
    {
        for( IDocumentElement element : Document.getElements() )
        {
            element.render();
        }
    }
}
