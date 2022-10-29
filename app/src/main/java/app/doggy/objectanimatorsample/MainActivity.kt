package app.doggy.objectanimatorsample

import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.view.animation.DecelerateInterpolator
import androidx.appcompat.app.AppCompatActivity
import app.doggy.objectanimatorsample.databinding.ActivityMainBinding
import app.doggy.objectanimatorsample.ui.AddPositionDialog
import java.util.Date

class MainActivity : AppCompatActivity() {

  private lateinit var binding: ActivityMainBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)

    binding.circle.setOnClickListener {
      it.startMoveToPointAnim(
        transX = 500f,
        transY = 500f,
      )
    }

    binding.addButton.setOnClickListener {
      AddPositionDialog().show(supportFragmentManager, AddPositionDialog::class.simpleName)
    }
  }

  // View を移動させる
  private fun View.startMoveToPointAnim(transX: Float, transY: Float) {
    val translationX = PropertyValuesHolder.ofFloat(View.TRANSLATION_X, transX)
    val translationY = PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, transY)
    val animator = ObjectAnimator.ofPropertyValuesHolder(this, translationX, translationY).apply {
      duration = 1000
      interpolator = DecelerateInterpolator() // 急速に開始し、その後減速しながら変化させる
    }
    animator.start()
  }

  // クリックした位置を取得する
  override fun onTouchEvent(event: MotionEvent?): Boolean {
    when (event?.action) {
      MotionEvent.ACTION_DOWN -> {
        Log.d(POSITION, "==== ${Date()} ====")
        Log.d(POSITION, "X: ${event.x}")
        Log.d(POSITION, "Y: ${event.y}")
      }
    }
    return super.onTouchEvent(event)
  }
}

private const val POSITION = "POSITION"
