package solid.dip;

public class FrontEndDeveloper implements Developer {
    public void writeJavascript() {
        System.out.println("--->FrontEndDeveloper.writeJava()");
    }

    @Override
    public void develop() {
        writeJavascript();
    }
}
