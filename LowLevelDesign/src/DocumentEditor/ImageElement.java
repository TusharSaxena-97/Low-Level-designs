package DocumentEditor;

public class ImageElement implements IDocumentElement{

    public String ImagePath;

    ImageElement(String ImagePath)
    {
        this.ImagePath = ImagePath;
    }

    @Override
    public void render()
    {
        System.out.println("RenderingImage " + ImagePath);
    }
}
