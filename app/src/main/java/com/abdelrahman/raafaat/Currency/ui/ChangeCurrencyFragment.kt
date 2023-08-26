package com.abdelrahman.raafaat.currency.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
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
        initUI()
    }

    private fun observeViewModel() {
        currencyViewModel.currencies.observe(viewLifecycleOwner) { currencies ->
            val arrayAdapter = ArrayAdapter(requireContext(), R.layout.dropdown_item, currencies)
            binding.fromAutCompleteText.setAdapter(arrayAdapter)
            binding.toAutCompleteText.setAdapter(arrayAdapter)
            binding.fromAutCompleteText.setText(currencies[0], false)
            binding.toAutCompleteText.setText(currencies[1], false)
            convertCurrency()
        }

        currencyViewModel.convertedCurrency.observe(viewLifecycleOwner) { convertedValue ->
            binding.toCurrencyTextView.text = convertedValue.toString()
        }
    }

    private fun convertCurrency() {
        currencyViewModel.convertCurrency(
            binding.fromAutCompleteText.text.toString(),
            binding.toAutCompleteText.text.toString(),
            binding.fromCurrencyEditText.text.toString().toDouble()
        )
    }

    private fun initUI() {
        binding.swapButton.setOnClickListener {
            val from = binding.fromAutCompleteText.text.toString()
            val to = binding.toAutCompleteText.text.toString()
            binding.fromAutCompleteText.setText(to, false)
            binding.toAutCompleteText.setText(from, false)
            convertCurrency()
        }

        binding.detailsButton.setOnClickListener {
            //will navigate to the details screen
        }

        binding.fromAutCompleteText.setOnItemClickListener { _, _, _, _ ->
            convertCurrency()
        }

        binding.toAutCompleteText.setOnItemClickListener { _, _, _, _ ->
            convertCurrency()
        }
    }
}