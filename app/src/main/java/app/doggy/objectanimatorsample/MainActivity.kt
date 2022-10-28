package app.doggy.objectanimatorsample

import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.os.Bundle
import android.view.View
import android.view.animation.DecelerateInterpolator
import androidx.appcompat.app.AppCompatActivity
import app.doggy.objectanimatorsample.databinding.ActivityMainBinding

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
  }

  private fun View.startMoveToPointAnim(transX: Float, transY: Float) {
    val translationX = PropertyValuesHolder.ofFloat(View.TRANSLATION_X, transX)
    val translationY = PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, transY)
    val animator = ObjectAnimator.ofPropertyValuesHolder(this, translationX, translationY).apply {
      duration = 1000
      interpolator = DecelerateInterpolator() // 急速に開始し、その後減速しながら変化させる
    }
    animator.start()
  }
}
