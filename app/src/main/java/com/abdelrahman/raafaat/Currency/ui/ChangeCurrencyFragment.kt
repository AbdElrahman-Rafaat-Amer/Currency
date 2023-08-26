package com.abdelrahman.raafaat.currency.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.activityViewModels
import com.abdelrahman.raafaat.currency.R
import com.abdelrahman.raafaat.currency.databinding.FragmentChangeCurrencyBinding
import com.abdelrahman.raafaat.currency.viewmodel.CurrencyViewModel

class ChangeCurrencyFragment : Fragment() {

    private lateinit var binding: FragmentChangeCurrencyBinding
    private val currencyViewModel: CurrencyViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentChangeCurrencyBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        currencyViewModel.getSymbols()
        observeViewModel()
        binding.swapButton.setOnClickListener {
            //will swap between currencies in from and to lists
        }
        binding.detailsButton.setOnClickListener {
            //will navigate to the details screen
        }
    }

    private fun observeViewModel() {
        currencyViewModel.currencies.observe(viewLifecycleOwner) { currencies ->
            val arrayAdapter = ArrayAdapter(requireContext(), R.layout.dropdown_item, currencies)
            binding.fromAutCompleteText.setAdapter(arrayAdapter)
            binding.toAutCompleteText.setAdapter(arrayAdapter)
        }
    }

}