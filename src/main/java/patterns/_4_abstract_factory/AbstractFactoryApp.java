package patterns._4_abstract_factory;

public class AbstractFactoryApp {
    public static void main(String[] args) {
        DeviceFactory deviceFactory = getFactoryByCode("EN");

        Mouse       mouse = deviceFactory.getMouse();
        Keyboard    keyboard = deviceFactory.getKeyboard();
        Touchpad    touchpad = deviceFactory.getTouchpad();

        mouse.click();
        keyboard.print();
        touchpad.track(10, 100);
    }

    private static DeviceFactory getFactoryByCode(String code) {
        switch (code) {
            case "RU": return new RuDeviceFactory();
            case "EN": return new EnDeviceFactory();
            default: throw new RuntimeException("Unsupported country code");
        }
    }
}

interface Mouse {
    void click();
    void dbclick();
    void scroll(int direction);
}

interface Keyboard {
    void print();
    void println();
}

interface Touchpad {
    void track(int deltaX, int deltaY);
}

interface DeviceFactory {
    Mouse getMouse();
    Keyboard getKeyboard();
    Touchpad getTouchpad();
}


class RuMouse implements Mouse {

    @Override
    public void click() {
        System.out.println("RuMouse.click()");
    }

    @Override
    public void dbclick() {
        System.out.println("RuMouse.dbclick()");
    }

    @Override
    public void scroll(int direction) {
        System.out.println("RuMouse.scroll(" + direction + ")");
    }
}

class RuKeyboard implements Keyboard {

    @Override
    public void print() {
        System.out.println("RuKeyboard.print()");
    }

    @Override
    public void println() {
        System.out.println("RuKeyboard.println()");
    }
}

class RuTouchpad implements Touchpad {
    @Override
    public void track(int deltaX, int deltaY) {
        System.out.println("RuTouchpad.track("+deltaX+", "+deltaY+")");
    }
}

class EnMouse implements Mouse {

    @Override
    public void click() {
        System.out.println("EnMouse.click()");
    }

    @Override
    public void dbclick() {
        System.out.println("EnMouse.dbclick()");
    }

    @Override
    public void scroll(int direction) {
        System.out.println("EnMouse.scroll(" + direction + ")");
    }
}

class EnKeyboard implements Keyboard {

    @Override
    public void print() {
        System.out.println("EnKeyboard.print()");
    }

    @Override
    public void println() {
        System.out.println("EnKeyboard.println()");
    }
}

class EnTouchpad implements Touchpad {
    @Override
    public void track(int deltaX, int deltaY) {
        System.out.println("EnTouchpad.track("+deltaX+", "+deltaY+")");
    }
}


class RuDeviceFactory implements DeviceFactory {

    @Override
    public Mouse getMouse() {
        return new RuMouse();
    }

    @Override
    public Keyboard getKeyboard() {
        return new RuKeyboard();
    }

    @Override
    public Touchpad getTouchpad() {
        return new RuTouchpad();
    }
}

class EnDeviceFactory implements DeviceFactory {

    @Override
    public Mouse getMouse() {
        return new EnMouse();
    }

    @Override
    public Keyboard getKeyboard() {
        return new EnKeyboard();
    }

    @Override
    public Touchpad getTouchpad() {
        return new EnTouchpad();
    }
}