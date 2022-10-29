package app.doggy.objectanimatorsample.ui

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import app.doggy.objectanimatorsample.databinding.DialogAddPositionBinding

class AddPositionDialog : DialogFragment() {

  override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
    super.onCreateDialog(savedInstanceState)
    val binding = DialogAddPositionBinding.inflate(requireActivity().layoutInflater)
    val dialog = Dialog(requireActivity())
    dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    dialog.setContentView(binding.root)
    return dialog
  }
}
