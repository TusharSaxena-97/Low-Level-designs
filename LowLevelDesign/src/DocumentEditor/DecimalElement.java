package DocumentEditor;

import java.math.BigDecimal;

public class DecimalElement implements IDocumentElement {

    public BigDecimal bd;

    DecimalElement(BigDecimal bd )
    {
        this.bd = bd;
    }

    @Override
    public void render() {
        System.out.println(bd);
    }
}
