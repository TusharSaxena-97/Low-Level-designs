package DocumentEditor;

public class TextElement implements IDocumentElement{

        public String Text;

        TextElement( String Text )
        {
            this.Text = Text;
        }

        public void render()
        {
            System.out.println( Text );
        }
}
