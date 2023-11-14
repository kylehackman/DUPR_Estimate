package hackman.kyle.duprestimate

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import hackman.kyle.duprestimate.databinding.ActivityMainBinding
import hackman.kyle.logic.NavigationViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
    }

    override fun onDestroy() {
        NavigationViewModel.screenState.removeAllObservers()
        super.onDestroy()
    }

    override fun onBackPressed() {
        if (NavigationViewModel.shouldOverrideBackPressed()) {
            NavigationViewModel.onBackPressed()
        } else {
            super.onBackPressed()
        }
    }
}
