package DocumentEditor;

public class DocumentEditorBuilder {

    IDocument document;
    IPersistence persistence;
    IDocumentRenderer docRender;

    public DocumentEditorBuilder addDocument(IDocument document)
    {
        this.document = document;
        return this;
    }

    public DocumentEditorBuilder addPersistence(IPersistence persistence)
    {
        this.persistence = persistence;
        return this;
    }

    public DocumentEditorBuilder addRenderer(IDocumentRenderer docRender)
    {
        this.docRender = docRender;
        return this;
    }

    public DocumentEditor build()
    {
        return new DocumentEditor(this);
    }

}
