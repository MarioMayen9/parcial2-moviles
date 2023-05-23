package com.mayencastro.parcial2moviles.ui.sport.newsport

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.mayencastro.parcial2moviles.R
import com.mayencastro.parcial2moviles.databinding.FragmentNewSportBinding
import com.mayencastro.parcial2moviles.ui.sport.viewmodel.SportsViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * A simple [Fragment] subclass.
 * Use the [NewSportFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class NewSportFragment : Fragment() {
    private lateinit var binding: FragmentNewSportBinding

    private val viewModel: SportsViewModel by activityViewModels{
        SportsViewModel.Factory

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNewSportBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViewModel()
        setObserver()


    }

    private fun setViewModel(){
        binding.viewmodel = viewModel
    }

    private fun setObserver() {
        viewModel.status.observe(viewLifecycleOwner) { status ->
            when {
                status.equals(SportsViewModel.M_CREATED) -> {
                    val mylist = viewModel.getModel().reversed()
                    Log.d("TAG APP", status)
                    Log.d("TAG APP", mylist.toString())
                    viewModel.clearStatus()
                    viewModel.clearData()
                    findNavController().popBackStack()
                }
                status.equals(SportsViewModel.WRONG_INFORMATION) -> {
                    Log.d("TAG APP", status)
                    showToast("Ingresa la información", 2000)

                    viewModel.clearStatus()
                }
            }
        }
    }
    private fun showToast(message: String, duration: Long) {
        val toast = Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT)
        toast.show()

        GlobalScope.launch(Dispatchers.Main) {
            delay(duration)
            toast.cancel()
        }
    }


}