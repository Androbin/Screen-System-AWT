package de.androbin.screen;

import de.androbin.screen.transit.*;
import de.androbin.shell.*;
import de.androbin.shell.gfx.*;
import java.awt.*;

public class AWTScreenManager extends SmoothScreenManager<AWTTransition> implements AWTGraphics {
  @ Override
  public void render( final Graphics2D g ) {
    if ( transit == null ) {
      final Shell screen = current();
      
      if ( screen != null ) {
        final AWTGraphics graphics = (AWTGraphics) screen;
        graphics.render( g );
      }
    } else {
      final Shell screen0 = transit.screen0;
      final Shell screen1 = transit.screen1;
      
      final AWTGraphics graphics0 = (AWTGraphics) screen0;
      final AWTGraphics graphics1 = (AWTGraphics) screen1;
      
      transit.transition.render( g, getWidth(), getHeight(), graphics0, graphics1 );
    }
  }
}