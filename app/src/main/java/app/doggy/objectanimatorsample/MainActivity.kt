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
import app.doggy.objectanimatorsample.databinding.ViewCircleBinding
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

    var sceneCount = 0

    // TODO: id が一致する Dancer の positionList に値を追加する
    var selectedDancerId = 0

    val dancers = mutableListOf<Dancer>()

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

    binding.playButton.setOnClickListener {
      dancers.forEach { dancer ->
        val dancerView = binding.root.getViewById(dancer.id)
        dancerView.startMoveToPointAnim(
          transX = dancer.positionList[sceneCount].x,
          transY = dancer.positionList[sceneCount].y,
        )
      }
    }

    binding.addButton.setOnClickListener {
      // TODO: 初期位置を指定して、Circle を追加する
      // AddPositionDialog().show(supportFragmentManager, AddPositionDialog::class.simpleName)

      val circleView = ViewCircleBinding.inflate(
        layoutInflater,
        binding.root,
        false,
      ).apply {
        val viewId = View.generateViewId()
        val dancer = Dancer(
          id = viewId,
          name = "",
          positionList = listOf(
            Position(
              x = 100f * viewId,
              y = 100f * viewId,
            ),
          ),
        )
        dancers.add(dancer)

        root.id = dancer.id
        root.x = dancer.positionList[0].x
        root.y = dancer.positionList[0].y
        root.setOnClickListener {
          selectedDancerId = root.id
        }
      }
      binding.root.addView(circleView.root)
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
