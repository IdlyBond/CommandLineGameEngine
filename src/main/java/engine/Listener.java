package engine;

import lc.kra.system.LibraryLoader;
import lc.kra.system.keyboard.GlobalKeyboardHook;
import lc.kra.system.keyboard.event.GlobalKeyAdapter;
import lc.kra.system.keyboard.event.GlobalKeyEvent;
import java.util.Map;

public class Listener {

    public boolean keyLeft = false;
    public boolean keyRight = false;
    public boolean keyUp = false;

    private GlobalKeyboardHook keyboardHook;

    public Listener() {
        this.keyboardHook = new GlobalKeyboardHook(true);;
        keyboardHook.addKeyListener(new GlobalKeyAdapter() {

            @Override
            public void keyPressed(GlobalKeyEvent event) {
                if(event.getVirtualKeyCode() == GlobalKeyEvent.VK_LEFT) keyLeft = true;
                if(event.getVirtualKeyCode() == GlobalKeyEvent.VK_RIGHT) keyRight = true;
                if(event.getVirtualKeyCode() == GlobalKeyEvent.VK_UP) keyUp = true;
            }

            @Override
            public void keyReleased(GlobalKeyEvent event) {
                if(event.getVirtualKeyCode() == GlobalKeyEvent.VK_LEFT) keyLeft = false;
                if(event.getVirtualKeyCode() == GlobalKeyEvent.VK_RIGHT) keyRight = false;
                if(event.getVirtualKeyCode() == GlobalKeyEvent.VK_UP) keyUp = false;
            }
        });
    }
}
