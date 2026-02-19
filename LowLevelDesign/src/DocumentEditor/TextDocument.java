package DocumentEditor;
import java.math.BigDecimal;
import java.util.*;

public class TextDocument implements IDocument{

    @Override
    public void AddElements(IDocumentElement ele) {
        docElements.add( ele );
    }

    @Override
    public List<IDocumentElement> getElements() {
         return docElements;
    }
}
