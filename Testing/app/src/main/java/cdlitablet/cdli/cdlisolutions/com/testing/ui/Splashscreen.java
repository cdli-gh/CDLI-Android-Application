package cdlitablet.cdli.cdlisolutions.com.testing.ui;

import android.app.Activity;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import cdlitablet.cdli.cdlisolutions.com.testing.R;

public class Splashscreen extends Activity {

  Thread splashTread;
  @BindView(R.id.splash)
  ImageView iv;
  @BindView(R.id.lin_lay)
  LinearLayout l;

  public void onAttachedToWindow() {
    super.onAttachedToWindow();
    Window window = getWindow();
    window.setFormat(PixelFormat.RGBA_8888);
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_splash);
    ButterKnife.bind(this);
    StartAnimations();
  }

  private void StartAnimations() {
    Animation anim = AnimationUtils.loadAnimation(this, R.anim.alpha);
    anim.reset();
    l.clearAnimation();
    l.startAnimation(anim);

    anim = AnimationUtils.loadAnimation(this, R.anim.translate);
    anim.reset();
    iv.clearAnimation();
    iv.startAnimation(anim);

    splashTread = new Thread() {
      @Override
      public void run() {
        try {
          int waited = 0;

          while (waited < 3500) {
            sleep(100);
            waited += 100;
          }
          Intent intent = new Intent(Splashscreen.this, MainActivity.class);
          intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
          startActivity(intent);
          finish();
        } catch (InterruptedException e) {
        } finally {
          finish();
        }
      }
    };
    splashTread.start();
  }
}