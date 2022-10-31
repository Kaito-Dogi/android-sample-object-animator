package app.doggy.objectanimatorsample.ui

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import app.doggy.objectanimatorsample.databinding.DialogAddPositionBinding

class AddPositionDialog : DialogFragment() {

  private lateinit var listener: OnClickListener

  override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
    super.onCreateDialog(savedInstanceState)
    val binding = DialogAddPositionBinding.inflate(requireActivity().layoutInflater)
    val dialog = Dialog(requireActivity())
    dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    binding.addButton.setOnClickListener {
      listener.onAddButtonClick(
        dialog = this,
        x = binding.xEditText.text.toString().toFloat(),
        y = binding.yEditText.text.toString().toFloat(),
      )
      dismiss()
    }
    dialog.setContentView(binding.root)
    return dialog
  }

  override fun onAttach(context: Context) {
    super.onAttach(context)
    try {
      listener = context as OnClickListener
    } catch (e: ClassCastException) {
      throw ClassCastException("$context must implement NoticeDialogListener")
    }
  }

  interface OnClickListener {
    fun onAddButtonClick(dialog: DialogFragment, x: Float, y: Float)
  }
}
