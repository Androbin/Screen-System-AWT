package de.androbin.screen.transit;

import de.androbin.shell.gfx.*;
import java.awt.*;

public final class AWTSlideTransition extends AWTTransition {
  private final int dx;
  private final int dy;
  
  public AWTSlideTransition( final int dx, final int dy, final float duration ) {
    super( duration );
    
    this.dx = dx;
    this.dy = dy;
  }
  
  @ Override
  public float getPauseTime() {
    return 0.5f * duration;
  }
  
  @ Override
  public float getResumeTime() {
    return 0.5f * duration;
  }
  
  @ Override
  public void render( final Graphics2D g, final int width, final int height,
      final AWTGraphics graphics0, final AWTGraphics graphics1 ) {
    final float progress = getTime() / duration;
    
    render( g, width, height, graphics0, progress );
    render( g, width, height, graphics1, progress - 1f );
  }
  
  private void render( final Graphics2D g, final int width, final int height,
      final AWTGraphics graphics, final float progress ) {
    if ( graphics == null ) {
      return;
    }
    
    final float x = dx * progress * width;
    final float y = dy * progress * height;
    
    final Graphics2D g2 = (Graphics2D) g.create();
    g2.translate( x, y );
    graphics.render( g2 );
    g2.dispose();
  }
}