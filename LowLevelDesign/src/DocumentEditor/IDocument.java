package DocumentEditor;

import java.math.BigDecimal;
import java.util.*;

public interface IDocument {
        List<IDocumentElement> docElements = new ArrayList<>();
        public void AddElements( IDocumentElement element );
        public List<IDocumentElement> getElements( );
}
