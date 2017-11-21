package de.androbin.screen.transit;

import de.androbin.shell.gfx.*;
import java.awt.*;

public final class AWTColorCrossfade extends AWTTransition {
  private final float red;
  private final float green;
  private final float blue;
  
  public AWTColorCrossfade( final Color color, final float crossing, final float duration ) {
    this( color.getRed() / 255f, color.getGreen() / 255f, color.getBlue() / 255f,
        crossing, duration );
  }
  
  public AWTColorCrossfade( final float red, final float green, final float blue,
      final float crossing, final float duration ) {
    super( crossing, duration );
    
    this.red = red;
    this.green = green;
    this.blue = blue;
  }
  
  @ Override
  public void render( final Graphics2D g, final int width, final int height,
      final AWTGraphics graphics0, final AWTGraphics graphics1 ) {
    final float time = getTime();
    final float alpha;
    
    if ( time < crossing ) {
      render( g, graphics0 );
      alpha = time / crossing;
    } else {
      render( g, graphics1 );
      alpha = ( duration - time ) / ( duration - crossing );
    }
    
    g.setColor( new Color( red, green, blue, alpha ) );
    g.fillRect( 0, 0, width, height );
  }
  
  private void render( final Graphics2D g, final AWTGraphics graphics ) {
    if ( graphics == null ) {
      return;
    }
    
    final Graphics2D g2 = (Graphics2D) g.create();
    graphics.render( g2 );
    g2.dispose();
  }
}