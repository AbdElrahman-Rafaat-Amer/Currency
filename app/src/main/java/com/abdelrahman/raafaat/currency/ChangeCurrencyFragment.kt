package com.abdelrahman.raafaat.currency

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.abdelrahman.raafaat.currency.databinding.FragmentChangeCurrencyBinding

class ChangeCurrencyFragment : Fragment() {

    private lateinit var binding: FragmentChangeCurrencyBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentChangeCurrencyBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.swapButton.setOnClickListener {
            //will swap between currencies in from and to lists
        }
        binding.detailsButton.setOnClickListener {
            //will navigate to the details screen
        }
    }

}