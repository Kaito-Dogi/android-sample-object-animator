package app.doggy.objectanimatorsample

import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.animation.DecelerateInterpolator
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import app.doggy.objectanimatorsample.databinding.ActivityMainBinding
import app.doggy.objectanimatorsample.model.Dancer
import app.doggy.objectanimatorsample.model.Position
import app.doggy.objectanimatorsample.ui.AddPositionDialog

class MainActivity : AppCompatActivity(), AddPositionDialog.OnClickListener {

  companion object {
    private const val POSITION = "POSITION"
  }

  private lateinit var binding: ActivityMainBinding

  private val mutablePositionList: MutableList<Position> = mutableListOf()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)

    var count = 0
    var dancer: Dancer? = null

    // binding.circle.setOnClickListener {
    //   if (dancer == null) {
    //     dancer = Dancer(
    //       name = "",
    //       positionList = mutablePositionList,
    //     )
    //   }
    //   it.startMoveToPointAnim(
    //     transX = dancer?.positionList?.get(count)?.x ?: return@setOnClickListener,
    //     transY = dancer?.positionList?.get(count)?.y ?: return@setOnClickListener,
    //   )
    //   if (count < (dancer?.positionList?.size?.minus(1) ?: return@setOnClickListener)) {
    //     count++
    //   } else {
    //     count = 0
    //   }
    // }

    binding.addButton.setOnClickListener {
      // AddPositionDialog().show(supportFragmentManager, AddPositionDialog::class.simpleName)
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
  // override fun onTouchEvent(event: MotionEvent?): Boolean {
  //   when (event?.action) {
  //     MotionEvent.ACTION_DOWN -> {
  //       Log.d(POSITION, "==== ${Date()} ====")
  //       Log.d(POSITION, "X: ${event.x}")
  //       Log.d(POSITION, "Y: ${event.y}")
  //     }
  //   }
  //   return super.onTouchEvent(event)
  // }

  override fun onAddButtonClick(dialog: DialogFragment, x: Float, y: Float) {
    Log.d(POSITION, "X: $x")
    Log.d(POSITION, "Y: $y")
    mutablePositionList.add(Position(x, y))
  }
}
