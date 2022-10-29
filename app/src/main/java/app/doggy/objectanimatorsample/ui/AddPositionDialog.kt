package app.doggy.objectanimatorsample.ui

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import app.doggy.objectanimatorsample.databinding.DialogAddPositionBinding

class AddPositionDialog : DialogFragment() {
  companion object {
    // private const val REQUEST_POSITIVE_BUTTON_KEY = "REQUEST_POSITIVE_BUTTON_KEY"
  }

  private var _binding: DialogAddPositionBinding? = null
  private val binding: DialogAddPositionBinding
    get() = _binding!!

  // inner class Builder(private val fragment: Fragment) {
  //   private val bundle = Bundle()
  //
  //   fun setPositiveButton(onClick: (x: Float, y: Float) -> Unit): Builder {
  //     fragment.childFragmentManager.setFragmentResultListener(
  //       REQUEST_POSITIVE_BUTTON_KEY,
  //       fragment.viewLifecycleOwner,
  //     ) { _, _ ->
  //       onClick.invoke(
  //         binding.xEditText.text.toString().toFloat(),
  //         binding.yEditText.text.toString().toFloat(),
  //       )
  //     }
  //     return this
  //   }
  //
  //   fun build(): AddPositionDialog {
  //     return AddPositionDialog().apply {
  //       arguments = bundle
  //     }
  //   }
  // }

  override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
    super.onCreateDialog(savedInstanceState)
    _binding = DialogAddPositionBinding.inflate(requireActivity().layoutInflater)
    val dialog = Dialog(requireActivity())
    dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    // binding.addButton.setOnClickListener {
    //   dismiss()
    //   setFragmentResult(
    //     REQUEST_POSITIVE_BUTTON_KEY,
    //     bundleOf(),
    //   )
    // }
    dialog.setContentView(binding.root)
    return dialog
  }
}
