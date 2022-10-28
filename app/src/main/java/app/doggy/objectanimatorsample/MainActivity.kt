package app.doggy.objectanimatorsample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import app.doggy.objectanimatorsample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
