package de.androbin.screen.transit;

import de.androbin.shell.gfx.*;
import java.awt.*;

public abstract class AWTTransition extends Transition {
  public AWTTransition( final float duration ) {
    super( duration );
  }
  
  public abstract void render( Graphics2D g, int width, int height,
      AWTGraphics graphics0, AWTGraphics graphics1 );
}