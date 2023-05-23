package com.mayencastro.parcial2moviles.ui.sport

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.mayencastro.parcial2moviles.databinding.FragmentSportBinding
import com.mayencastro.parcial2moviles.ui.sport.viewmodel.SportsViewModel

/**
 * A simple [Fragment] subclass.
 * Use the [SportFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SportFragment : Fragment() {
    private val viewModel: SportsViewModel by activityViewModels{
        SportsViewModel.Factory

    }

    private lateinit var binding: FragmentSportBinding



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentSportBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewmodel = viewModel
    }
}