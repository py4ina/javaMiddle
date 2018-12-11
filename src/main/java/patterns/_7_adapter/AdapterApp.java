package patterns._7_adapter;

public class AdapterApp {
    public static void main(String[] args) {
        VectorGraphicsInterface vectorGraphicsInterface = new VectorAdapterFromRaster2(new RasterGraphics());
        vectorGraphicsInterface.drawLine();
        vectorGraphicsInterface.drawSquare();
    }
}

interface VectorGraphicsInterface {
    void drawLine();
    void drawSquare();
}

class RasterGraphics {
    void drawRasterLine() {
        System.out.println("RasterGraphics.drawRasterLine()");
    }

    void drawRasterSquare() {
        System.out.println("RasterGraphics.drawRasterSquare()");
    }
}

class VectorAdapterFromRaster extends RasterGraphics implements VectorGraphicsInterface {

    public void drawLine() {
        drawRasterLine();
    }

    public void drawSquare() {
        drawRasterSquare();
    }
}

class VectorAdapterFromRaster2 implements VectorGraphicsInterface {
    private RasterGraphics drawRasterLine;

    public VectorAdapterFromRaster2(RasterGraphics drawRasterLine) {
        this.drawRasterLine = drawRasterLine;
    }

    public void drawLine() {
        drawRasterLine.drawRasterLine();
    }

    public void drawSquare() {
        drawRasterLine.drawRasterSquare();
    }
}
