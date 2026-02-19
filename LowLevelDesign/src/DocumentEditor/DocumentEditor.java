package DocumentEditor;

import java.math.BigDecimal;

public class DocumentEditor {

    public IDocument Document;

    public IDocumentRenderer DocumentRenderer;

    public IPersistence Persistence;

    DocumentEditor( DocumentEditorBuilder dob )
    {
        this.Document = dob.document;
        this.DocumentRenderer = dob.docRender;
        this.Persistence = dob.persistence;
    }

    public void addElement(String text)
    {
        Document.AddElements(new TextElement( text ));
    }

    public void addElement(BigDecimal decimal )
    {
        Document.AddElements(new DecimalElement(decimal));
    }

    public void save()
    {
        Persistence.save(Document);
    }

    public void render()
    {
        DocumentRenderer.render(Document);
    }
}
